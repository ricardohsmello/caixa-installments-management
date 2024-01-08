package br.com.ricas.caixa.domain.entity

import br.com.ricas.caixa.application.api.request.InstallmentRequest
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.Date

@Document("installments")
data class InstallmentDocument(
    @Id
    val id: ObjectId?,
    @Field("nro_contrato")
    val nroContrato: String,
    @Field("due_date")
    val dueDate: Date,
    val paid: Boolean,
    val amount: Double,
    val interest: Double,
    val insurance: Double,
    val fees: Int,
    @Field("outstanding_balance")
    val outstandingBalance: Double,
    @Field("monetary_correction")
    val monetaryCorrection: Double,
    val amortization: Double,
    @Field("is_contribution")
    val isContribution: Boolean
) {
    companion object {
        fun toDomain(installmentRequest: InstallmentRequest): InstallmentDocument {
            return InstallmentDocument(
                id = null,
                nroContrato = installmentRequest.nroContrato,
                dueDate = installmentRequest.dueDate,
                paid = installmentRequest.paid,
                amount = installmentRequest.amount,
                interest = installmentRequest.interest,
                insurance = installmentRequest.insurance,
                fees = installmentRequest.fees,
                outstandingBalance = installmentRequest.outstandingBalance,
                monetaryCorrection = installmentRequest.monetaryCorrection,
                amortization = installmentRequest.amortization,
                isContribution = installmentRequest.isContribution
            )
        }
    }
}
