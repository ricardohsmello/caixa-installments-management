package br.com.ricas.caixa.domain.service

import br.com.ricas.caixa.domain.entity.Installments
import br.com.ricas.caixa.infrastructure.repository.InstallmentsRepository
import net.sourceforge.tess4j.Tesseract
import net.sourceforge.tess4j.TesseractException
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*
import java.util.regex.Pattern

@Service
class InstallmentsService(
    private val installmentsRepository: InstallmentsRepository
)  {
    fun save(installment: Installments): String {
        return installmentsRepository.save(installment)
    }

    fun upload(file: MultipartFile): String {
        val tesseract = Tesseract()
        tesseract.setDatapath("src/main/resources/tessdata")

        var saveResult = ""

        try {
            val tempFile = convertMultipartFileToFile(file)
            val result: String = tesseract.doOCR(tempFile)
            val lines = result.split("\n")

            val installments = Installments(
                amortization = findLineValue(result,"Amortização"),
                amount = findLineValue(result,"prestação"),
                dueDate = Date(),
                fees = findLineValue(result,"Taxas")?.toInt(),
                insurance = findLineValue(result,"Seguro FGHB"),
                interest = findLineValue(result,"Juros"),
                isContribution = false,
                monetaryCorrection = findLineValue(result,"Correção monetária"),
                nroContrato = "123",
                outstandingBalance = findLineValue(result,"Saldo devedor"),
                paid = true
            )

            saveResult = save(installments)


            tempFile.delete()

        } catch (e: TesseractException) {
            System.err.println("Error occurred while transcribing the image: " + e.message)
        } catch (e: Exception) {
            System.err.println("Unexpected error: " + e.message)
        }

        return saveResult
    }

    private fun convertMultipartFileToFile(multipartFile: MultipartFile): File {
        val tempFile = File.createTempFile("upload-", multipartFile.originalFilename)
        multipartFile.transferTo(tempFile)

        return tempFile
    }

    fun findAll(): List<Installments> =
        installmentsRepository.findAll()

    fun delete(id: String) {
        installmentsRepository.deleteById(id)
    }


    fun findLineValue(content: String, startPhrase: String): Double? {
        val pattern = Pattern.compile("$startPhrase\\b.*\\b(R\\\$[\\d.,]*)")
        val matcher = pattern.matcher(content)
        if (matcher.find()) {
            val value = matcher.group(1).replace("R$", "").replace(",", ".").trim()
            return value.toDoubleOrNull()
        }

        return null
    }
}
