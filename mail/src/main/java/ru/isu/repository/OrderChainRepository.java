package ru.isu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.model.custom.OrderChain;

@Repository
public interface OrderChainRepository extends JpaRepository<OrderChain, String> {
}
