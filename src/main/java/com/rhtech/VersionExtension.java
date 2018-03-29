package com.rhtech;

import lombok.Getter;
import lombok.Setter;
import org.gradle.api.Project;
import org.gradle.api.provider.Property;

@Getter
@Setter
public class VersionExtension
{
    private Property<String> appVersion;
    private Property<String> appTitle;

    public VersionExtension(Project project)
    {
        this.appVersion = project.getObjects().property(String.class);
        this.appTitle = project.getObjects().property(String.class);
    }

}