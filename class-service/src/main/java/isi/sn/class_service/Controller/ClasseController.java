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
}

