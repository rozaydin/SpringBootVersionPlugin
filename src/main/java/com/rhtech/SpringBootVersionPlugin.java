package com.rhtech;

import com.rhtech.extensions.StringProperty;
import com.rhtech.extensions.VersionConfigExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.internal.provider.DefaultPropertyState;
import org.gradle.api.provider.Property;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class SpringBootVersionPlugin implements Plugin<Project>
{
    private Property<String> version;
    private Property<String> title;

    @Override public void apply(Project project)
    {
        VersionConfigExtension extension = project.getExtensions().create("versionProperties", VersionConfigExtension.class, project);
        title = new StringProperty();   // project.getObjects().property(String.class);
        version = new StringProperty(); // project.getObjects().property(String.class);

        // register to project extensions
        project.getExtensions().add(Prop.title.name(), title);
        project.getExtensions().add(Prop.version.name(), version);

        // https://github.com/jonathanhood/gradle-plugin-example/blob/master/tutorial/5-making-configurable-plugins.md
        project.afterEvaluate((proj) -> {
            final String application_properties_path = project.getRootDir().getAbsolutePath() + "/src/main/resources/application.properties";
            try (InputStream is = new FileInputStream(application_properties_path))
            {
                Properties properties = new Properties();
                properties.load(is);
                title.set((properties.getProperty(extension.getAppTitle().get())));
                version.set((properties.getProperty(extension.getAppVersion().get())));
            }
            catch (Exception exc)
            {
                project.getLogger().error("Unable to load application.properties file!", exc);
            }
        });
        // create task
        project.getTasks().create("printSpringBootVersion", PrintSpringBootVersion.class);
    }
}