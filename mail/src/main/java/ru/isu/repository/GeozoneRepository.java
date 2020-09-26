package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isu.model.Geozone;

public interface GeozoneRepository extends JpaRepository<Geozone, Long> {
}
