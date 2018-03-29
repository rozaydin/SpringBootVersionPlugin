package com.rhtech;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class PrintSpringBootVersion extends DefaultTask
{
    @TaskAction
    public void printSpringBootVersion() {
        String appName = getProject().getExtensions().getExtraProperties().get("appName").toString();
        String version = getProject().getExtensions().getExtraProperties().get("version").toString();
        System.out.println("appname: " + appName + " " + "version: " + version);
    }
}
