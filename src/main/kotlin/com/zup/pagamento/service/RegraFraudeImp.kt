package com.zup.pagamento.service

import com.zup.pagamento.dto.UsuarioDto
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

    override fun avaliarFormaPagamentoDisponivelParaUsuarios(): List<UsuarioDto> {
        var fraudadores = retornarUsuariosFraudadores()
        var us2: List<UsuarioDto> = listOf()

        usuarioRepository.findAll().forEach {
            if (fraudadores.contains(it.email)) {
                it.formasPagamento = it.formasPagamento.filter { fm -> !fm.tipo.pagamentoOnline }.toSet()
            }
            us2 += listOf<UsuarioDto>(it.converterResponse())
        }

        return us2
    }

    override fun retornarUsuariosFraudadores(): List<String> = fraudadorRepository.findAll().map { it.email }

}