package br.com.ricas.caixa.infrastructure.repository

import br.com.ricas.caixa.domain.InstallmentsPort
import br.com.ricas.caixa.domain.entity.Installments
import br.com.ricas.caixa.infrastructure.entity.InstallmentsEntity
import com.mongodb.kotlin.client.MongoDatabase
import org.bson.BsonDocument
import org.bson.BsonObjectId
import org.bson.types.ObjectId
import org.springframework.stereotype.Repository

@Repository
class InstallmentsRepository(
    private val mongoDatabase: MongoDatabase
) : InstallmentsPort {

    override fun findAll(): List<Installments> {
        val collection = mongoDatabase.getCollection<InstallmentsEntity>("installments")
        return collection.find().map { it.toDomain() }.toList()
    }

    override fun save(installments: Installments): String {

        val collection = mongoDatabase.getCollection<InstallmentsEntity>("installments")
        val insertOne = collection.insertOne(installments.toEntity())

        return insertOne.insertedId.toString()
    }

    override fun deleteById(id: String) {
        val collection = mongoDatabase.getCollection<InstallmentsEntity>("installments")

        val filter = BsonDocument("_id", BsonObjectId(ObjectId(id)))
        collection.deleteOne(filter)
    }

}