package com.zup.pagamento.service

import com.zup.pagamento.model.FormaPagamentoResponse
import com.zup.pagamento.repository.FormaPagamentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service

@Service
class FormaPagamentoService {

    @Autowired
    lateinit var formaPagamentoRepository: FormaPagamentoRepository

    fun formasPagamentoPorUsuarioERestauranteId(@Param("idRestaurante") idRestaurante: Long,
                                                @Param("emailUsuario") emailUsuario: String): List<FormaPagamentoResponse> {
        return this.formaPagamentoRepository.formasPagamentoPorUsuarioERestauranteId(idRestaurante, emailUsuario)
    }
}