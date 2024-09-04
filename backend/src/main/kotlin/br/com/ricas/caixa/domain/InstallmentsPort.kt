package br.com.ricas.caixa.domain

import br.com.ricas.caixa.domain.entity.Installments

interface InstallmentsPort {

    fun findAll(): List<Installments>

    fun save(installments: Installments): String

    fun deleteById(id: String)
}