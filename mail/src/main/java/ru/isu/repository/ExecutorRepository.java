package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.isu.model.custom.Executor;

import java.util.List;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, String> {


    List<Executor> findExecutorsByParams();
}
