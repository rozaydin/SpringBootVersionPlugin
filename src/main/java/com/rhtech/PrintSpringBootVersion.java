package com.rhtech;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class PrintSpringBootVersion extends DefaultTask
{
    @TaskAction
    public void printSpringBootVersion() {
        String appName = getProject().getExtensions().getExtraProperties().get(Property.appTitle.name()).toString();
        String version = getProject().getExtensions().getExtraProperties().get(Property.appVersion.name()).toString();
        System.out.println(Property.appTitle.name() + ": " + appName + ", " + Property.appTitle.name() + ": " + version);
    }
}
