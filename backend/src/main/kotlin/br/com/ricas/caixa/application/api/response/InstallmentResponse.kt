package br.com.ricas.caixa.application.api.response

import java.util.*
data class InstallmentResponse(
    val nroContrato: String?,
    val dueDate: Date?,
    val paid: Boolean?,
    val amount: Double?,
    val interest: Double?,
    val insurance: Double?,
    val fees: Int?,
    val outstandingBalance: Double?,
    val monetaryCorrection: Double?,
    val amortization: Double?,
    val isContribution: Boolean?
)
