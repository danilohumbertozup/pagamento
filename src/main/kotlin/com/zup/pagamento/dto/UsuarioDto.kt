package com.zup.pagamento.dto

data class UsuarioDto(var email: String, var formasPagamento: Set<FormaPagamentoDto>)