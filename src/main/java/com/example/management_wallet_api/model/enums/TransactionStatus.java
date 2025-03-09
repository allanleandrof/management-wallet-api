package com.example.management_wallet_api.model.enums;

public enum TransactionStatus {
    PENDING,    // Transação pendente de processamento
    COMPLETED,  // Transação concluída com sucesso
    FAILED,     // Transação falhou
    CANCELLED   // Transação cancelada pelo usuário ou sistema
}
