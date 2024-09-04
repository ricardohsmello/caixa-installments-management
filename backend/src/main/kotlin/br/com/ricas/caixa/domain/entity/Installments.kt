package br.com.ricas.caixa.domain.entity

import br.com.ricas.caixa.application.api.request.InstallmentRequest
import br.com.ricas.caixa.application.api.response.InstallmentResponse
import br.com.ricas.caixa.infrastructure.entity.InstallmentsEntity
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId
import java.util.Date

data class Installments(
    @BsonId
    val id: ObjectId?,
    @BsonProperty("nro_contrato")
    val nroContrato: String?,
    @BsonProperty("due_date")
    val dueDate: Date?,
    val paid: Boolean?,
    val amount: Double?,
    val interest: Double?,
    val insurance: Double?,
    val fees: Int?,
    @BsonProperty("outstanding_balance")
    val outstandingBalance: Double?,
    @BsonProperty("monetary_correction")
    val monetaryCorrection: Double?,
    val amortization: Double?,
    @BsonProperty("is_contribution")
    val isContribution: Boolean?
) {
    companion object {
        fun toDomain(installmentRequest: InstallmentRequest): Installments {
            return Installments(
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
    fun toResponse(): InstallmentResponse {
        return InstallmentResponse(
            id = id.toString(),
            nroContrato = nroContrato,
            dueDate = dueDate,
            paid = paid,
            amount = amount,
            interest = interest,
            insurance = insurance,
            fees = fees,
            outstandingBalance = outstandingBalance,
            monetaryCorrection = monetaryCorrection,
            amortization = amortization,
            isContribution = isContribution
        )
    }


    fun toEntity(): InstallmentsEntity {
        return InstallmentsEntity(
            id = null,
            nroContrato = nroContrato,
            dueDate = dueDate,
            paid = paid,
            amount = amount,
            interest = interest,
            insurance = insurance,
            fees = fees,
            outstandingBalance = outstandingBalance,
            monetaryCorrection = monetaryCorrection,
            amortization = amortization,
            isContribution = isContribution
        )
    }
}
