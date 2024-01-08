package br.com.ricas.caixa.application.api.rest

import br.com.ricas.caixa.application.api.request.InstallmentRequest
import br.com.ricas.caixa.domain.entity.InstallmentDocument
import br.com.ricas.caixa.domain.service.InstallmentsService
import br.com.ricas.caixa.infrastructure.logging.RicasLog
import br.com.ricas.caixa.infrastructure.logging.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/installments")
@RicasLog
class InstallmentsController(
    private val installmentsService: InstallmentsService
) {
    @PostMapping("/create")
    fun create(@RequestBody installmentRequest: InstallmentRequest) : ResponseEntity<String> {
        logger().info(
            "Starting create installment with: $installmentRequest"
        )

        val installment = installmentsService.create(InstallmentDocument.toDomain(installmentRequest))
        return ResponseEntity.ok("Installment created with id: ${installment.id}")
    }
}