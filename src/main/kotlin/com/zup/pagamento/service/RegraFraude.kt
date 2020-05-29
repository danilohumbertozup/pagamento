package com.zup.pagamento.service

import com.zup.pagamento.dto.UsuarioDto

interface RegraFraude {
    fun avaliarFormaPagamentoDisponivelParaUsuarios(): List<UsuarioDto>
    fun retornarUsuariosFraudadores(): List<String>
}