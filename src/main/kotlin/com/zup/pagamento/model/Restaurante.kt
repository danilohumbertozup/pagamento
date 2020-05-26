package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "RESTAURANTE")
class Restaurante(
        @Column(name = "NOME", nullable = false)
        @NotNull(message = "Nome do restaurante é obrigatório.")
        var nome: String,

        @ManyToMany
        @JoinTable(name = "RESTAURANTE_FORMA_PAGAMENTO",
                joinColumns = [JoinColumn(name = "ID_RESTAURANTE")],
                inverseJoinColumns = [JoinColumn(name = "ID_FORMA_PAGAMENTO")])
        var formasPagamento: Set<FormaPagamento>) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long = 0

}