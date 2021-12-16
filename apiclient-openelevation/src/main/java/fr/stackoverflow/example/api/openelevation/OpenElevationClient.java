package fr.stackoverflow.example.api.openelevation;



import fr.stackoverflow.example.api.openelevation.model.LocationElevationResultsDTO;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface OpenElevationClient {
    LocationElevationResultsDTO getElevation(String locations);
}
