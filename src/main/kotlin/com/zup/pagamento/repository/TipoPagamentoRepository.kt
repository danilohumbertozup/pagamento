package com.zup.pagamento.repository

import com.zup.pagamento.model.TipoPagamento
import org.springframework.data.jpa.repository.JpaRepository

interface TipoPagamentoRepository : JpaRepository<TipoPagamento, Long> {
}