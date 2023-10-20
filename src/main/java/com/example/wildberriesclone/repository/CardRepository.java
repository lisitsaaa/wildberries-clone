package com.example.wildberriesclone.repository;

import com.example.wildberriesclone.entity.account.user.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
