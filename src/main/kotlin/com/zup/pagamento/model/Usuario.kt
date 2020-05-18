package com.zup.pagamento.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "USUARIO")
data class Usuario(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID", nullable = false)
        var id: Long,

        @Column(nullable = false, name = "EMAIL")
        @NotNull(message = "Email obrigatório")
        @Email(message = "Email inválido.")
        var email: String,

        @ManyToOne
        @JoinColumn(name = "ID_FORMA_PAGAMENTO", referencedColumnName = "ID")
        @JsonManagedReference
        var formaPagamento: FormaPagamento)
