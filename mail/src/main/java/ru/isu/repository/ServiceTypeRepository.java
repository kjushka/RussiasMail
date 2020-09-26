package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isu.model.basic.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, String> {
}
