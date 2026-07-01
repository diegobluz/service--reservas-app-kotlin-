package om.company.service__reservas_app.service__reservas_app.utils

class Validate {

    companion object {
        fun validarCpf(cpf: String?): String? {
            // 1. Limpa o texto mantendo apenas os números
            val cpfLimpo = cpf?.replace(Regex("[^0-9]"), "")

            // 2. Validações básicas: tamanho e sequências repetidas conhecidas
            if (cpfLimpo?.length != 11 || cpfLimpo.all { it == cpfLimpo[0] }) {
                return null
            }

            // 3. Algoritmo de validação do primeiro dígito verificador
            val digito1 = calcularDigitoCpf(cpfLimpo.substring(0, 9), 10)

            // 4. Algoritmo de validação do segundo dígito verificador
            val digito2 = calcularDigitoCpf(cpfLimpo.substring(0, 9) + digito1, 11)

            // 5. Verifica se os dígitos calculados batem com os finais do CPF
            val ehValido = cpfLimpo.endsWith("$digito1$digito2")

            // 6. Se for válido, aplica a máscara de formatação e retorna
            return if (ehValido) {
                // Formata usando a estrutura de String do Java/Kotlin
                "%s.%s.%s-%s".format(
                    cpfLimpo.substring(0, 3),
                    cpfLimpo.substring(3, 6),
                    cpfLimpo.substring(6, 9),
                    cpfLimpo.substring(9, 11)
                )
            } else {
                null
            }
        }

        private fun calcularDigitoCpf(num: String, pesoInicial: Int): Int {
            var peso = pesoInicial
            var soma = 0
            for (elemento in num) {
                soma += (elemento.toString().toInt()) * peso--
            }
            val resto = soma % 11
            return if (resto < 2) 0 else 11 - resto
        }
    }
}