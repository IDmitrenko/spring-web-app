package ru.dias.springwebapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dias.springwebapp.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
