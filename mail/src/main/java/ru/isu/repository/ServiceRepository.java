package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isu.model.basic.Service;

public interface ServiceRepository extends JpaRepository<Service, String> {
}
