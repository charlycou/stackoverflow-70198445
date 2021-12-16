package fr.stackoverflow.example.app;

import fr.stackoverflow.example.api.openelevation.OpenElevationClient;
import fr.stackoverflow.example.api.openelevation.OpenElevationConfig;

import fr.stackoverflow.example.api.openelevation.RestClientConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.ResourceAccessException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        RestClientConfig.class,
        //OpenElevationClient.class //The test is failing with this class
        OpenElevationConfig.class //The test is successfull with this one
})
public class AppTest {
    @Autowired
    OpenElevationClient elevationClient;

    @Test
    public void testApp() {
        Assert.assertThrows(ResourceAccessException.class, () -> {
            this.elevationClient.getElevation("dummy");
        });
    }
}
