package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isu.model.basic.SupplementaryCondition;

public interface SupplementaryConditionRepository extends JpaRepository<SupplementaryCondition, String> {
}
