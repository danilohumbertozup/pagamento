package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "RESTAURANTE")
class Restaurante(
        @Column(name = "NOME", nullable = false)
        @NotNull(message = "Nome do restaurante é obrigatório.")
        var nome: String,

        @ManyToOne
        @JoinColumn(name = "ID_FORMA_PAGAMENTO", referencedColumnName = "ID")
        var formaPagamento: FormaPagamento) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long = 0
}