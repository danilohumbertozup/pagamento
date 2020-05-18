package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "TIPO_FORMA_PAGAMENTO")
data class TipoFormaPagamento(
        @Id
        @GeneratedValue
        @Column(name = "ID", nullable = false)
        var id: Long,

        @Column(name = "TIPO", nullable = false)
        @NotNull(message = "Tipo da forma de pagamento é obrigatório.")
        var tipo: String,

        @Column(name = "PAGAMENTO_ONLINE", nullable = false)
        @NotNull(message = "Tipo da forma de pagamento é obrigatório.")
        var pagamentoOnline: Boolean)