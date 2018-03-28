package com.rhtech;

import org.gradle.api.Project;
import org.gradle.api.Plugin;

public class SpringBootVersionPlugin implements Plugin<Project>
{
    @Override public void apply(Project project)
    {
        project.getLogger().info("i am alive buddy!");
    }
}
