package com.zup.pagamento.repository

import com.zup.pagamento.model.Restaurante
import org.springframework.data.jpa.repository.JpaRepository

interface RestauranteRepository : JpaRepository<Restaurante, Long> {
}