package isi.sn.class_service.Controller;

import isi.sn.class_service.Dto.Sector;
import isi.sn.class_service.Entity.Classe;
import isi.sn.class_service.Dto.SectorClient;
import isi.sn.class_service.Repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private SectorClient sectorClient;

    @GetMapping
    public List<Classe> getAll() {
        return classeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Classe classe) {
        try {
            // Vérifier si le secteur existe
            Sector sector = sectorClient.getSectorById(classe.getSectorId());
            return ResponseEntity.ok(classeRepository.save(classe));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sector not found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getById(@PathVariable Long id) {
        return classeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Classe updatedClasse) {
        return classeRepository.findById(id).map(existing -> {
            try {
                // Vérifie que le nouveau sectorId existe
                sectorClient.getSectorById(updatedClasse.getSectorId());

                existing.setClassName(updatedClasse.getClassName());
                existing.setDescription(updatedClasse.getDescription());
                existing.setSectorId(updatedClasse.getSectorId());

                return ResponseEntity.ok(classeRepository.save(existing));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Sector not found.");
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Classe> optionalClasse = classeRepository.findById(id);

        if (optionalClasse.isPresent()) {
            classeRepository.delete(optionalClasse.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}

