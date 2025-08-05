package isi.sn.sector_service.Repository;

import isi.sn.sector_service.Entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
