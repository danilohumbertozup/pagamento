package com.zup.pagamento.controller

import com.zup.pagamento.model.FormaPagamentoResponse
import com.zup.pagamento.repository.FormaPagamentoRepository
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Email

@RestController
@RequestMapping(path = ["/v1"])
@Api(value = "/v1", description = "API por realizar as buscas")
@Validated
class RestApiController {
    @Autowired
    lateinit var formaPagamentoRepository: FormaPagamentoRepository

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/formasPagamentoPorUsuarioERestauranteId")
    fun formasPagamentoPorUsuarioERestauranteId(@RequestParam("idRestaurante", required = true) idRestaurante: Long,
                                                @RequestParam("emailUsuario", required = true) @Email emailUsuario: String): List<FormaPagamentoResponse> {
        return formaPagamentoRepository.formasPagamentoPorUsuarioERestauranteId(idRestaurante, emailUsuario)
    }

}