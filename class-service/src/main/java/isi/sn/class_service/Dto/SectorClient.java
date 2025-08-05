package isi.sn.class_service.Dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Déclare un client Feign pour communiquer avec le microservice nommé "sector-service"
@FeignClient(name = "sector-service")
public interface SectorClient {

    // Récupère un secteur par son identifiant
    @GetMapping("/api/sectors/{id}")
    Sector getSectorById(@PathVariable Long id);
    // Récupère la liste de tous les secteurs
    @GetMapping("/api/sectors")
    List<Sector> getAllSectors();

}
