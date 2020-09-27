package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.model.basic.Geozone;

@Repository
public interface GeozoneRepository extends JpaRepository<Geozone, String> {
    Geozone findGeozoneByName(String name);
}
