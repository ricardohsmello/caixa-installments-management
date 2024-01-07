package br.com.ricas.caixa.domain.service.impl

import br.com.ricas.caixa.domain.entity.InstallmentDocument
import br.com.ricas.caixa.domain.service.InstallmentsService
import br.com.ricas.caixa.infrastructure.repository.mongo.InstallmentsRepository
import org.springframework.stereotype.Service

@Service
class InstallmentsServiceImpl(
    private val installmentsRepository: InstallmentsRepository
) : InstallmentsService {
    override fun create(installmentDocument: InstallmentDocument) {

        installmentsRepository.save(installmentDocument)
    }
}