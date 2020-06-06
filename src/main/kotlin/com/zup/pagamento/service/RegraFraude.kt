package com.zup.pagamento.service

import com.zup.pagamento.dto.UsuarioDto

interface RegraFraude {
    fun avaliarFormaPagamentoDisponivelParaUsuario(idRestaurante: Long, email: String): List<UsuarioDto>
    fun retornarUsuariosFraudadores(): Set<String>
}