package com.zup.pagamento.repository

import com.zup.pagamento.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    @Query(nativeQuery = true,
            value = """
                select distinct u.* 
                from forma_pagamento fp 
                inner join restaurante_forma_pagamento rfp on fp.id = rfp.id_forma_pagamento
                inner join restaurante r on rfp.id_restaurante = r.id  
                inner join usuario_forma_pagamento ufp on fp.id = ufp.id_forma_pagamento 
                inner join usuario u on ufp.id_usuario = u.id
                inner join tipo_pagamento tp on tp.id = fp.id_tipo_pagamento 
                where 1=1
                and upper(u.email) = upper(:emailUsuario)
                and r.id = :idRestaurante
            """)
    fun formasPagamentoPorUsuarioERestauranteId(@Param("idRestaurante") idRestaurante: Long,
                                                @Param("emailUsuario") emailUsuario: String): List<Usuario>
}