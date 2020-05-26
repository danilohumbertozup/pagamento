package com.zup.pagamento.repository

import com.zup.pagamento.model.FormaPagamento
import com.zup.pagamento.model.FormaPagamentoResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface FormaPagamentoRepository : JpaRepository<FormaPagamento, Long> {

    @Query(nativeQuery = true,
            value = "select fp.id, \n" +
                    "\t\tfp.descricao\n" +
                    "from forma_pagamento fp \n" +
                    "inner join restaurante_forma_pagamento rfp on fp.id = rfp.id_forma_pagamento\n" +
                    "inner join restaurante r on rfp.id_restaurante = r.id  \n" +
                    "inner join usuario_forma_pagamento ufp on fp.id = ufp.id_forma_pagamento \n" +
                    "inner join usuario u on ufp.id_usuario = u.id\n" +
                    "where 1=1\n" +
                    "and upper(u.email) = upper(:emailUsuario)\n" +
                    "and r.id = :idRestaurante")
    fun formasPagamentoPorUsuarioERestauranteId(@Param("idRestaurante") idRestaurante: Long,
                                                @Param("emailUsuario") emailUsuario: String): List<FormaPagamentoResponse>
}