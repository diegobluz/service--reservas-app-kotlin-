package om.company.service__reservas_app.service__reservas_app.repositories

import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO

interface ClienteRepository {


    // Retorna o objeto diretamente (lança exceção ou estoura se não achar, dependendo da sua regra)
    fun obterCpf(cpf: String): ClienteDTO

    // O substituto idiomático do Optional<T> do Java em Kotlin é usar o tipo anulável (?)
    fun findByCpf(cpf: String): ClienteDTO?

    // Método de salvamento (o JpaRepository já herda um 'save' por padrão, mas se precisar sobrescrever o tipo:)
    fun save(cliente: ClienteDTO): ClienteDTO
}