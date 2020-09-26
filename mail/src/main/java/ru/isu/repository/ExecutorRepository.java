package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.model.custom.Executor;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, String> {
}
