package com.company.service.reservas.app.transportlayers.schedule

import com.company.service.reservas.app.entities.enums.StatusReserve
import com.company.service.reservas.app.interactors.ReservaUseCase
import org.slf4j.LoggerFactory // <- IMPORT ADICIONADO
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ReserveSchedule(
    private val useCase: ReservaUseCase,
) {

    @Scheduled(cron = "0 0 0 * * ?") // Executa diariamente às 00:00
    fun gerarRelatorio() {
        log.info("Gerando relatório diário...")

        var now = LocalDate.now()
        var startDate = LocalDate.of(now.year, now.month, 1)

        useCase.executeRelatorio(startDate, now)

    }


    companion object {
        private val log = LoggerFactory.getLogger(ReserveSchedule::class.java)
    }
}