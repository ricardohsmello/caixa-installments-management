package br.com.ricas.caixa.application.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class MongoDB {
    @Value("\${spring.data.mongodb.collection.financing}")
    private val financingCollection: String? = null

    @Value("\${spring.data.mongodb.collection.installments}")
    private val installmentsCollection: String? = null

    fun getFinancingCollection(): String? {
        return financingCollection
    }

    fun getInstallmentsCollection(): String? {
        return installmentsCollection
    }

}