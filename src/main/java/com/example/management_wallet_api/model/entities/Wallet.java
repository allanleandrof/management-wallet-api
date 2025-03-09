package com.example.management_wallet_api.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user; // Cada carteira pertence a UM usuário

    @Column(nullable = false)
    private BigDecimal balance; // Saldo da carteira (decimal para valores monetários)

    @OneToMany(mappedBy = "senderWallet", cascade = CascadeType.ALL)
    private List<Transaction> sentTransactions; // Transferências enviadas

    @OneToMany(mappedBy = "receiverWallet", cascade = CascadeType.ALL)
    private List<Transaction> receivedTransactions; // Transferências recebidas
}
