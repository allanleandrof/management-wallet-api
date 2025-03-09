package com.example.management_wallet_api.repository;

import com.example.management_wallet_api.model.entities.Transaction;
import com.example.management_wallet_api.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
