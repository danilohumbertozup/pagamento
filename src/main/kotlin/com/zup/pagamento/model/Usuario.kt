package com.zup.pagamento.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "USUARIO")
class Usuario(
        @Column(nullable = false, name = "EMAIL")
        @NotNull(message = "Email obrigatório")
        @Email(message = "Email inválido.")
        var email: String,

        @ManyToMany
        @JoinTable(name = "USUARIO_FORMA_PAGAMENTO",
                joinColumns = [JoinColumn(name = "ID_USUARIO")],
                inverseJoinColumns = [JoinColumn(name = "ID_FORMA_PAGAMENTO")])
        var formasPagamento: Set<FormaPagamento>) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    var id: Long = 0

}
