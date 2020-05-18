package com.zup.pagamento.controller

import com.zup.pagamento.model.FormaPagamento
import com.zup.pagamento.model.Restaurante
import com.zup.pagamento.model.TipoFormaPagamento
import com.zup.pagamento.model.Usuario
import com.zup.pagamento.repository.FormaPagamentoRepository
import com.zup.pagamento.repository.RestauranteRepository
import com.zup.pagamento.repository.TipoFormaPagamentoRepository
import com.zup.pagamento.repository.UsuarioRepository
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Email

@RestController
@RequestMapping(path = ["/v1/gets"])
@Api(value = "/v1/gets", description = "API por realizar as buscas")
@Validated
class RestApiController {
    @Autowired
    lateinit var formaPagamentoRepository: FormaPagamentoRepository

    @Autowired
    lateinit var restauranteRepository: RestauranteRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    lateinit var tipoFormaPagamentoRepository: TipoFormaPagamentoRepository

    //TODO em andamento ....
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/formasPagamento")
    fun buscaformasPagamentoPorIdRestauranteEEmail(
            @RequestParam(name = "idRestaurante", required = true) idRestaurante: Long,
            @RequestParam(name = "email", required = true)
            @Email(message = "Informe um email válido.") email: String): List<FormaPagamento> {
        return formaPagamentoRepository.findAll()
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/formasPagamento")
    fun formasPagamento(): List<FormaPagamento> {
        return formaPagamentoRepository.findAll()
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurantes")
    fun restaurantes(): List<Restaurante> {
        return restauranteRepository.findAll()
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios")
    fun usuarios(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tiposPagamento")
    fun tiposFormaPagamentoRepository(): List<TipoFormaPagamento> {
        return tipoFormaPagamentoRepository.findAll()
    }

}