package om.company.service__reservas_app.service__reservas_app.datasources.repository

import om.company.service__reservas_app.service__reservas_app.entities.ClienteEntity
import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepositoryJPA : JpaRepository<ClienteEntity, Long> {

    fun obterCpf(cpf: String): ClienteDTO
    fun findByCpf(cpf: String): ClienteDTO?
    fun save(cliente: ClienteEntity): ClienteEntity

}