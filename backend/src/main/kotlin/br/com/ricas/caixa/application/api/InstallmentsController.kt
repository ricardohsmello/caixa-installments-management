package br.com.ricas.caixa.application.api

import br.com.ricas.caixa.application.api.request.InstallmentRequest
import br.com.ricas.caixa.application.api.response.InstallmentResponse
import br.com.ricas.caixa.domain.entity.Installments
import br.com.ricas.caixa.domain.service.InstallmentsService
import br.com.ricas.caixa.infrastructure.logging.RicasLog
import br.com.ricas.caixa.infrastructure.logging.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("api/installments")
@RicasLog
class InstallmentsController(
    private val installmentsService: InstallmentsService
) {

//    @CrossOrigin(origins = ["http://localhost:4200"])
//    @PostMapping(consumes = ["multipart/form-data"])
//    fun create(@RequestPart("installmentRequest") installmentRequest: InstallmentRequest,
//               @RequestPart("file") file: MultipartFile) : ResponseEntity<String> {
//        logger().info(
//            "Starting create installment with: $installmentRequest"
//        )
//
//        val installment = installmentsService.save(Installments.toDomain(installmentRequest))
//        return ResponseEntity.ok(installment)
//    }

    @CrossOrigin(origins = ["http://localhost:4200"])
    @PostMapping(consumes = ["multipart/form-data"])
    fun upload(@RequestPart("file") file: MultipartFile) : ResponseEntity<String> {
        logger().info(
            "Starting upload installment "
        )

        val installment = installmentsService.upload(file)
        return ResponseEntity.ok(installment)
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