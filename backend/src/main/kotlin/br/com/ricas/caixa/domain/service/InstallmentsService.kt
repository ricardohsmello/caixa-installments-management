package br.com.ricas.caixa.domain.service

import br.com.ricas.caixa.domain.entity.Installments
import br.com.ricas.caixa.infrastructure.repository.InstallmentsRepository
import org.springframework.stereotype.Service

@Service
class InstallmentsService(
    private val installmentsRepository: InstallmentsRepository
)  {
    fun save(installments: Installments): String =
        installmentsRepository.save(installments)

    fun findAll(): List<Installments> =
        installmentsRepository.findAll()

    fun delete(id: String) {
        installmentsRepository.deleteById(id)
    }
}
