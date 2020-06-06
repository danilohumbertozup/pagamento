package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "FRAUDADOR")
class Fraudador (
        @Column(name = "EMAIL", nullable = false)
        @NotNull(message = "Email é obrigatório.")
        var email: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long = 0

}