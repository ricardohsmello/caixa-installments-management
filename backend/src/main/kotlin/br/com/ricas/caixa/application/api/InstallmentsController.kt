package br.com.ricas.caixa.application.api

import br.com.ricas.caixa.application.api.request.InstallmentRequest
import br.com.ricas.caixa.application.api.response.InstallmentResponse
import br.com.ricas.caixa.domain.entity.InstallmentDocument
import br.com.ricas.caixa.domain.service.InstallmentsService
import br.com.ricas.caixa.infrastructure.logging.RicasLog
import br.com.ricas.caixa.infrastructure.logging.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/installments")
@RicasLog
class InstallmentsController(
    private val installmentsService: InstallmentsService
) {
    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping
    fun create(@RequestBody installmentRequest: InstallmentRequest) : ResponseEntity<InstallmentResponse> {
        logger().info(
            "Starting create installment with: $installmentRequest"
        )

        val installment = installmentsService.create(InstallmentDocument.toDomain(installmentRequest))
        return ResponseEntity.ok(installment.toResponse())
    }
    @GetMapping
    fun findAll(): List<InstallmentResponse> {
        return installmentsService.findAll().map { it.toResponse()
        }
    }
    @CrossOrigin(origins = ["http://localhost:4200"])
    @DeleteMapping("{id}")
    fun deleteById(@PathVariable("id") id: String) {
        installmentsService.delete(id)
    }
}