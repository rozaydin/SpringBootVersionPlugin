package com.rhtech;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

public class SpringBootVersionPluginTest
{

    @Test
    public void shouldWork() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("com.rhtech.springbootversion");
    }

}
