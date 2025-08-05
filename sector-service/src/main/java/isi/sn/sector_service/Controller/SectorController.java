package isi.sn.sector_service.Controller;

import isi.sn.sector_service.Entity.Sector;
import isi.sn.sector_service.Repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    @Autowired
    private SectorRepository sectorRepository;

    @GetMapping
    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id) {
        return sectorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sector createSector(@RequestBody Sector sector) {
        return sectorRepository.save(sector);
    }

}
