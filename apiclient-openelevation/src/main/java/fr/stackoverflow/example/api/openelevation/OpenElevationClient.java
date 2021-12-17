package fr.stackoverflow.example.api.openelevation;



import fr.stackoverflow.example.api.openelevation.model.LocationElevationResultsDTO;

public interface OpenElevationClient {
    LocationElevationResultsDTO getElevation(String locations);
}
