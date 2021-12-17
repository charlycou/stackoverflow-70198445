package fr.stackoverflow.example.app;

import fr.stackoverflow.example.api.openelevation.OpenElevationClient;
import fr.stackoverflow.example.api.openelevation.OpenElevationConfig;
import fr.stackoverflow.example.api.openelevation.model.LocationElevationResultsDTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
  OpenElevationConfig.class // c'est ca!
})
public class AppTest {

  @Autowired
  OpenElevationClient elevationClient;

  @Test
  public void testApp() {
    assertThrows(org.springframework.web.client.HttpClientErrorException.BadRequest.class, () -> {
      this.elevationClient.getElevation("dummy");
    });
  }

  @Test
  public void testApp2() {
    LocationElevationResultsDTO elevation = elevationClient.getElevation("41.161758,-8.583933");
    assertNotNull(elevation);
    assertNotNull(elevation.getResults());
    assertThat(elevation.getResults().isEmpty()).isFalse();
    assertNotNull(elevation.getResults().get(0));
    assertNotNull(elevation.getResults().get(0).getElevation());
    assertThat(elevation.getResults().get(0).getElevation()).isEqualTo(117);
  }
}
