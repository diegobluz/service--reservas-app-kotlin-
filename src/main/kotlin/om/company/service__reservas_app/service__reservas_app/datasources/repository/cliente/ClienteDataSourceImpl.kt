package om.company.service__reservas_app.service__reservas_app.datasources.repository.cliente

import om.company.service__reservas_app.service__reservas_app.datasources.repository.ClienteRepositoryJPA
import om.company.service__reservas_app.service__reservas_app.entities.ClienteEntity
import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import om.company.service__reservas_app.service__reservas_app.repositories.ClienteRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class ClienteDataSourceImpl(
    private val clienteRepositoryJPA: ClienteRepositoryJPA
): ClienteRepository {

    override fun obterCpf(cpf: String): ClienteDTO {
        /*
        * Consulta na base o cpf do cliente
        */
        return clienteRepositoryJPA.obterCpf(cpf)
    }

    override fun findByCpf(cpf: String): ClienteDTO? {
        /*
         * Consulta na base o cliente pelo cpf
         */
        return clienteRepositoryJPA.findByCpf(cpf)
    }

    override fun save(cliente: ClienteDTO): ClienteDTO {
        // converter o DTO para entity para usar no Hibernate
        val salvarCliente = ClienteEntity(
            id = cliente.id,
            cpf = cliente.cpf,
            nomeCompleto = cliente.nomeCompleto,
            telefone = cliente.telefone,
            email = cliente.email,
            dataNascimento = cliente.dataNascimento,
            sexo = cliente.sexo,
            dataCadastro = cliente.dataCadastro ?: LocalDateTime.now(),
            dataUltimaAtualizacao = LocalDateTime.now()
        )

        val savedCliente = clienteRepositoryJPA.save(salvarCliente)
        return toDTO(savedCliente) //retorna o DTO convertido da entity salva
    }

    private fun toDTO(entity: ClienteEntity): ClienteDTO {
        return ClienteDTO(
            id = entity.id,
            cpf = entity.cpf,
            nomeCompleto = entity.nomeCompleto,
            telefone = entity.telefone,
            email = entity.email,
            dataNascimento = entity.dataNascimento,
            sexo = entity.sexo,
            dataCadastro = entity.dataCadastro,
            dataUltimaAtualizacao = entity.dataUltimaAtualizacao
        )
    }
}