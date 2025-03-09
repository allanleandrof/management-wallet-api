package com.example.management_wallet_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String username; // Nome de usuário único

    @Column(nullable = false, unique = true)
    private String email; // Email único para login

    @Column(nullable = false)
    private String password; // Senha criptografada

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Wallet wallet; // Cada usuário tem UMA carteira

    @CreationTimestamp
    private LocalDateTime createdAt; // Data de criação

    @UpdateTimestamp
    private LocalDateTime updatedAt; // Última atualização
}
