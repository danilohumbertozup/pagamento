package com.zup.pagamento.repository

import com.zup.pagamento.model.FormaPagamento
import com.zup.pagamento.model.TipoFormaPagamento
import org.springframework.data.jpa.repository.JpaRepository

interface FormaPagamentoRepository : JpaRepository<FormaPagamento, Long> {
}