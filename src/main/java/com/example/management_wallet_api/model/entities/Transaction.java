package com.example.management_wallet_api.model.entities;

import com.example.management_wallet_api.model.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_wallet_id", nullable = false)
    private Wallet senderWallet; // Carteira que enviou o dinheiro

    @ManyToOne
    @JoinColumn(name = "receiver_wallet_id", nullable = false)
    private Wallet receiverWallet; // Carteira que recebeu o dinheiro

    @Column(nullable = false)
    private BigDecimal amount; // Valor da transação

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status; // Status da transação (PENDENTE, COMPLETA, FALHA)

    @CreationTimestamp
    private LocalDateTime createdAt; // Data e hora da transação
}
