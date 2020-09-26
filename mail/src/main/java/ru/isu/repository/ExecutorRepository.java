package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.isu.model.custom.Executor;

import java.util.List;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, String> {

    /*@Query("select exec from Executor exec where (" +
            "select count(cserv) from CustomService cserv where cserv.maxWeight > :weight and cserv.minWeight < :weight and (" +
            "select count(serv) from Service serv where serv.name = :servName) > 0 and (" +
            "select count(cgeo) from CustomGeozone cgeo where (" +
            "select count(geo) from Geozone geo where geo.name = :name) > 0) > 0" +
            ") > 0")*/
    /*@Query("select exec from Executor exec where ")
    List<Executor> findExecutorsByParams(@Param("weight") Integer weight);*/
}
