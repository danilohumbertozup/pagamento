package com.zup.pagamento.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "RESTAURANTE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
data class Restaurante(
        @Id
        @GeneratedValue
        @Column(name = "ID", nullable = false)
        var id: Long,

        @Column(name = "NOME", nullable = false)
        @NotNull(message = "Nome do restaurante é obrigatório.")
        var nome: String,

        @ManyToOne
        @JoinColumn(name = "ID_FORMA_PAGAMENTO", referencedColumnName = "ID")
        @JsonManagedReference
        var formaPagamento: FormaPagamento)