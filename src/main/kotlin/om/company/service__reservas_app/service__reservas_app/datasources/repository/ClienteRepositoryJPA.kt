package om.company.service__reservas_app.service__reservas_app.datasources.repository

import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepositoryJPA : JpaRepository<ClienteDTO, String> {

    fun obterCpf(cpf: String): ClienteDTO
    fun findByCpf(cpf: String): ClienteDTO?
    fun save(cliente: ClienteDTO): ClienteDTO

}