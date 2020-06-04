package com.zup.pagamento.repository

import com.zup.pagamento.model.FormaPagamento
import com.zup.pagamento.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface FormaPagamentoRepository : JpaRepository<FormaPagamento, Long> {
}