package com.zup.pagamento.service

import com.zup.pagamento.dto.UsuarioDto
import com.zup.pagamento.repository.FormaPagamentoRepository
import com.zup.pagamento.repository.FraudadorRepository
import com.zup.pagamento.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RegraFraudeImp : RegraFraude {

    @Autowired
    lateinit var fraudadorRepository: FraudadorRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    override fun avaliarFormaPagamentoDisponivelParaUsuario(idRestaurante: Long, email: String): List<UsuarioDto> {
        val fraudadores = retornarUsuariosFraudadores()
        var us2: List<UsuarioDto> = listOf()

        val formasPagamentoUsuario = usuarioRepository.formasPagamentoPorUsuarioERestauranteId(idRestaurante, email)

        for (usuario in formasPagamentoUsuario) {
            if (fraudadores.contains(usuario.email)) {
                usuario.formasPagamento = usuario.formasPagamento.filter { fm -> !fm.tipo.pagamentoOnline }.toSet()
                us2 += listOf<UsuarioDto>(usuario.converterResponse())
            } else us2 = listOf<UsuarioDto>(usuario.converterResponse())
        }
        return us2
    }

    override fun retornarUsuariosFraudadores(): Set<String> = fraudadorRepository.findAll().map { it.email }.toSet()

}