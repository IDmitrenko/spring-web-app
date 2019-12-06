package ru.dias.springwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dias.springwebapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
