package com.rhtech.extensions;

import lombok.Getter;
import lombok.Setter;
import org.gradle.api.Project;
import org.gradle.api.provider.Property;

@Getter
@Setter
public class VersionConfigExtension
{
    private Property<String> appVersion;
    private Property<String> appTitle;

    public VersionConfigExtension(Project project)
    {
        this.appVersion = project.getObjects().property(String.class);
        this.appTitle = project.getObjects().property(String.class);
    }
}