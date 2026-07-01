package om.company.service__reservas_app.service__reservas_app.datasources.repository.cliente

import om.company.service__reservas_app.service__reservas_app.datasources.repository.ClienteRepositoryJPA
import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import om.company.service__reservas_app.service__reservas_app.repositories.ClienteRepository

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
        /*
         * Salva o cliente na base
         */
        return clienteRepositoryJPA.save(cliente)
    }
}