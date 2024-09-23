package br.com.ricas.caixa.domain.service

import br.com.ricas.caixa.domain.entity.Installments
import br.com.ricas.caixa.infrastructure.repository.InstallmentsRepository
import net.sourceforge.tess4j.Tesseract
import net.sourceforge.tess4j.TesseractException
import org.springframework.ai.chat.client.ChatClient
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.lang.Integer.parseInt
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@Service
class InstallmentsService(
    private val installmentsRepository: InstallmentsRepository,
    private val chatClient: ChatClient
)  {

    // TODO Refactor everything here.

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

            val prompt = "Por favor, me retorna a seguinte ordem de valores:\n" +
                    "data mais recente, valor da prestacao, amortizacao, juros, seguro FGHAB, taxas, saldo devedor e correcao monetaria. Todos estes valores tem que serem retornados nesta ordem, separados por | e somente eles, sem o R$. Nao quero nenhum texto gerado seu, apenas o resultado que pedi.$result"

            val extractedValues = chatClient.prompt().user(prompt).call().content()

            val installment = extractInstallment(extractedValues)
            installmentsRepository.save(installment)

            tempFile.delete()
        } catch (e: TesseractException) {
            System.err.println("Error occurred while transcribing the image: " + e.message)
        } catch (e: Exception) {
            System.err.println("Unexpected error: " + e.message)
        }

        return saveResult
    }

    fun extractInstallment(input: String): Installments {
        val parts = input.split("\\|".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        var dueDate: Date? = null
        try {
            dueDate = dateFormat.parse(parts[0])
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val amount = parseDouble(parts[1])
        val amortization = parseDouble(parts[2])
        val interest = parseDouble(parts[3])
        val insurance = parseDouble(parts[4])
        val outstandingBalance = parseDouble(parts[6])
        val monetaryCorrection = parseDouble(parts[7])

        return Installments(
            "155554006358-9",
            dueDate,
            true,
            amount,
            interest,
            insurance,
            25,
            outstandingBalance,
            monetaryCorrection,
            amortization,
            false
        )
    }

    private fun parseDouble(value: String): Double {
        var value = value
        value = value.replace(",", ".")
        return value.toDouble()
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


}
