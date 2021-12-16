package fr.stackoverflow.example.app;

import fr.stackoverflow.example.api.openelevation.OpenElevationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"fr.stackoverflow.example"})
public class Main implements ApplicationRunner {

    @Autowired
    OpenElevationClient elevationClient;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args).close();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.elevationClient.getElevation("dummy");
    }
}
