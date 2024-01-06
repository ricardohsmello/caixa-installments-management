package br.com.ricas.caixa.application.api.rest

import br.com.ricas.caixa.application.api.request.InstallmentRequest
import br.com.ricas.caixa.domain.entity.InstallmentDocument
import br.com.ricas.caixa.domain.service.InstallmentsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/installments")
class InstallmentsController(
    private val installmentsService: InstallmentsService
) {

    @PostMapping("/create")
    fun create(@RequestBody installmentRequest: InstallmentRequest) {
        installmentsService.create(InstallmentDocument.toDomain(installmentRequest))
    }
}