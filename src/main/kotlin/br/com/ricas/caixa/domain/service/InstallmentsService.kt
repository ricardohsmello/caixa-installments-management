package br.com.ricas.caixa.domain.service

import br.com.ricas.caixa.domain.entity.InstallmentDocument

interface InstallmentsService {
    fun create(installmentDocument: InstallmentDocument)
}