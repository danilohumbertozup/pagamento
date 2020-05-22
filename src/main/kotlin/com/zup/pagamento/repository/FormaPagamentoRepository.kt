package com.zup.pagamento.repository

import com.zup.pagamento.model.FormaPagamento
import org.springframework.data.jpa.repository.JpaRepository

interface FormaPagamentoRepository : JpaRepository<FormaPagamento, Long> {
}