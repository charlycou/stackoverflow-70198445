package fr.stackoverflow.example.api.openelevation;

import fr.stackoverflow.example.api.openelevation.api.OpenElevationLookupApi;
import fr.stackoverflow.example.api.openelevation.model.LocationElevationResultsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenElevationClientImpl implements OpenElevationClient {

  private final OpenElevationLookupApi openElevationLookupApi;

  @Autowired
  public OpenElevationClientImpl(OpenElevationLookupApi openElevationLookupApi, @Value("${openelevation.api.url}") String basePath) {
    openElevationLookupApi.getApiClient().setBasePath(basePath);
    this.openElevationLookupApi = openElevationLookupApi;
  }

  @Override
  public LocationElevationResultsDTO getElevation(String locations) {
    return this.openElevationLookupApi.getLookup(locations);
  }
}
