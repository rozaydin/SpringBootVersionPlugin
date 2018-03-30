package com.rhtech;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.TaskAction;

public class PrintSpringBootVersion extends DefaultTask
{
    @TaskAction
    public void printSpringBootVersion()
    {
        Property<String> title = (Property<String>) getProject().getExtensions().getByName("title");
        Property<String> version = (Property<String>) getProject().getExtensions().getByName("version");
        System.out.println(Prop.title.name() + ": " + title.get() + ", " + Prop.version.name() + ": " + version.get());
    }
}
