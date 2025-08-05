package isi.sn.class_service.Dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "sector-service")
public interface SectorClient {

    @GetMapping("/api/sectors/{id}")
    Sector getSectorById(@PathVariable Long id);

    @GetMapping("/api/sectors")
    List<Sector> getAllSectors();

}
