package om.company.service__reservas_app.service__reservas_app.entities


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "cliente")
class ClienteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "cpf", length = 11)
    var cpf: String? = null,

    @Column(name = "nome_completo", length = 60)
    var nomeCompleto: String? = null,

    @Column(name = "telefone", length = 12)
    var telefone: String? = null,

    @Column(name = "email", length = 40)
    var email: String? = null,

    @Column(name = "data_nascimento")
    var dataNascimento: LocalDate? = null,

    @Column(name = "sexo", length = 11)
    var sexo: String? = null,

    @Column(name = "data_cadastro")
    var dataCadastro: LocalDateTime? = null,

    @Column(name = "data_ultima_atualizacao")
    var dataUltimaAtualizacao: LocalDateTime? = null


)