package com.zup.pagamento.repository

import com.zup.pagamento.model.FormaPagamento
import com.zup.pagamento.model.TipoFormaPagamento
import com.zup.pagamento.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}