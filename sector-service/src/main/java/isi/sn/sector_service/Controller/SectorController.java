package isi.sn.sector_service.Controller;

import isi.sn.sector_service.Entity.Sector;
import isi.sn.sector_service.Repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable Long id, @RequestBody Sector updatedSector) {
        return sectorRepository.findById(id).map(sector -> {
            sector.setName(updatedSector.getName());
            return ResponseEntity.ok(sectorRepository.save(sector));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        Optional<Sector> optionalSector = sectorRepository.findById(id);

        if (optionalSector.isPresent()) {
            sectorRepository.delete(optionalSector.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
