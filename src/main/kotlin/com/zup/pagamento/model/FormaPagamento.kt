package com.zup.pagamento.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "FORMA_PAGAMENTO")
data class FormaPagamento(
        @Id
        @GeneratedValue
        @Column(name = "ID", nullable = false)
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "ID_TIPO_FORMA_PAGAMENTO", referencedColumnName = "ID")
        @NotNull(message = "Tipo da forma de pagamento é obrigatório.")
        @JsonManagedReference
        val tipo: TipoFormaPagamento,

        @Column(name = "DESCRICAO", nullable = false)
        @NotNull(message = "Descrição da forma de pagamento é obrigatório.")
        val descricao: String,

        @OneToMany(mappedBy = "formaPagamento", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, targetEntity = Usuario::class)
        @JsonBackReference
        var usuarios: MutableSet<Usuario> = mutableSetOf(),

        @OneToMany(mappedBy = "formaPagamento", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY, targetEntity = Restaurante::class)
        @JsonBackReference
        var restaurantes: MutableSet<Restaurante> = mutableSetOf())