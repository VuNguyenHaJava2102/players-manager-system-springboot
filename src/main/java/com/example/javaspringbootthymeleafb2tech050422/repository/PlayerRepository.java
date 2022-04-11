package com.example.javaspringbootthymeleafb2tech050422.repository;

import com.example.javaspringbootthymeleafb2tech050422.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
