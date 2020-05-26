package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "FORMA_PAGAMENTO")
class FormaPagamento(
        @ManyToOne
        @JoinColumn(name = "ID_TIPO_PAGAMENTO", referencedColumnName = "ID")
        @NotNull(message = "Tipo de pagamento é obrigatório.")
        var tipo: TipoPagamento,

        @Column(name = "DESCRICAO", nullable = false)
        @NotNull(message = "Descrição da forma de pagamento é obrigatório.")
        var descricao: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FormaPagamento

        if (descricao != other.descricao) return false

        return true
    }

    override fun hashCode(): Int {
        return descricao.hashCode()
    }
}