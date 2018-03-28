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
        final String application_properties_path = project.getRootDir().getAbsolutePath() + "/src/main/resources/application.properties";
        try (InputStream is = new FileInputStream(application_properties_path))
        {
            Properties properties = new Properties();
            properties.load(is);

            project.getExtensions().getExtraProperties().set("appName", properties.getProperty("spring.application.name"));
            project.getExtensions().getExtraProperties().set("version", properties.getProperty("spring.application.version"));

            project.getLogger().lifecycle(properties.getProperty("spring.application.name"));
            project.getLogger().lifecycle(properties.getProperty("spring.application.version"));

            project.getLogger().lifecycle(project.getExtensions().getExtraProperties().get("appName").toString());

        }
        catch (Exception exc)
        {
            project.getLogger().error("Unable to load application.properties file!", exc);
        }
    }
}