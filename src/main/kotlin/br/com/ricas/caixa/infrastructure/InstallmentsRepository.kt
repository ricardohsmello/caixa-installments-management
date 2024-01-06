package br.com.ricas.caixa.infrastructure

import br.com.ricas.caixa.domain.entity.InstallmentDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface InstallmentsRepository : MongoRepository<InstallmentDocument, String>