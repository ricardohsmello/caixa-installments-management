package br.com.ricas.caixa.application.api.request

import java.util.*


data class InstallmentRequest(
    val nroContrato: String,
    val dueDate: Date,
    val paid: Boolean,
    val amount: Double,
    val interest: Double,
    val insurance: Double,
    val fees: Int,
    val outstandingBalance: Double,
    val monetaryCorrection: Double,
    val amortization: Double,
    val isContribution: Boolean
)
