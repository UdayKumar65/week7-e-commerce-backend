package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}