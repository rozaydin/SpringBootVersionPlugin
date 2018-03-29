package com.rhtech;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class SpringBootVersionPlugin implements Plugin<Project>
{
    @Override public void apply(Project project)
    {
        VersionExtension extension = project.getExtensions().create("versionProperties", VersionExtension.class, project);
        // https://github.com/jonathanhood/gradle-plugin-example/blob/master/tutorial/5-making-configurable-plugins.md
        project.afterEvaluate((proj) -> {
            final String application_properties_path = project.getRootDir().getAbsolutePath() + "/src/main/resources/application.properties";
            try (InputStream is = new FileInputStream(application_properties_path))
            {
                Properties properties = new Properties();
                properties.load(is);
                project.getExtensions().getExtraProperties().set("appTitle", properties.getProperty(extension.getAppTitle().get()));
                project.getExtensions().getExtraProperties().set("version", properties.getProperty(extension.getAppVersion().get()));
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