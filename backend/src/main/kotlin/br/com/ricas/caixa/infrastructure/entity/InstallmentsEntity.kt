package br.com.ricas.caixa.infrastructure.entity

import br.com.ricas.caixa.domain.entity.Installments
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId
import java.util.*

data class InstallmentsEntity(
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

    fun toDomain(): Installments {
        return Installments(
//            id = null,
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
