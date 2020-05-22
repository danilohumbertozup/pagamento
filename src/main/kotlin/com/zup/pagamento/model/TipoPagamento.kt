package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "TIPO_PAGAMENTO")
class TipoPagamento (
        @Column(name = "TIPO", nullable = false)
        @NotNull(message = "Tipo de pagamento é obrigatório.")
        var tipo: String,

        @Column(name = "PAGAMENTO_ONLINE", nullable = false)
        @NotNull(message = "Pagamento  é obrigatório.")
        var pagamentoOnline: Boolean) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long = 0
}