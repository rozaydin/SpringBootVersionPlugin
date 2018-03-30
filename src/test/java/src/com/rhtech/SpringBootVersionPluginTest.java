package src.com.rhtech;

import com.rhtech.Prop;
import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class SpringBootVersionPluginTest
{
    @Test
    public void shouldWork() {

        Project project = ProjectBuilder.builder()
                .withName("Test-Project")
                .withProjectDir(Paths.get("src/main/test/resources").toFile())
                .build();

        project.getPluginManager().apply("com.rhtech.springbootversion");
        assert project.getProperties().get(Prop.title.name()) != null;
        assert project.getProperties().get(Prop.version.name()) != null;

        project.afterEvaluate((proj)->{
            System.out.println(project.getExtensions().getByName(Prop.title.name()));
            System.out.println(project.getExtensions().getByName(Prop.version.name()));
        });
    }

}
