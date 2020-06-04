package com.zup.pagamento.repository

import com.zup.pagamento.model.Fraudador
import org.springframework.data.jpa.repository.JpaRepository

interface FraudadorRepository : JpaRepository<Fraudador, Long> {
}