package om.company.service__reservas_app.service__reservas_app.datasources.repository

import om.company.service__reservas_app.service__reservas_app.entities.ClienteEntity
import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepositoryJPA : JpaRepository<ClienteEntity, Long> {
    @Query("""
        SELECT new om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO(
            c.id, c.cpf, c.nomeCompleto, c.telefone, c.email, c.dataNascimento, c.sexo, c.dataCadastro, null, c.dataUltimaAtualizacao
        ) 
        FROM ClienteEntity c WHERE c.cpf = :cpf
    """)
    fun obterCpf(cpf: String): ClienteDTO
    @Query("""
        SELECT new om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO(
            c.id, c.cpf, c.nomeCompleto, c.telefone, c.email, c.dataNascimento, c.sexo, c.dataCadastro, null, c.dataUltimaAtualizacao
        ) 
        FROM ClienteEntity c WHERE c.cpf = :cpf
    """)
    fun findByCpf(cpf: String): ClienteDTO

}