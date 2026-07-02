package com.company.service.reservas.app.datasources.repository

import com.company.service.reservas.app.entities.ClienteEntity
import com.company.service.reservas.app.entities.dto.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepositoryJPA : JpaRepository<ClienteEntity, Long> {
    @Query("""
        SELECT new com.company.service.reservas.app.entities.dto.ClienteDTO(
            c.id, c.cpf, c.nomeCompleto, c.telefone, c.email, c.dataNascimento, c.sexo, c.dataCadastro, null, c.dataUltimaAtualizacao
        ) 
        FROM ClienteEntity c WHERE c.cpf = :cpf
    """)
    fun obterCpf(@Param("cpf")cpf: String): ClienteDTO
    @Query("""
        SELECT new com.company.service.reservas.app.entities.dto.ClienteDTO(
            c.id, c.cpf, c.nomeCompleto, c.telefone, c.email, c.dataNascimento, c.sexo, c.dataCadastro, null, c.dataUltimaAtualizacao
        ) 
        FROM ClienteEntity c WHERE c.cpf = :cpf
    """)
    fun findByCpf(@Param("cpf")cpf: String): ClienteDTO?

}