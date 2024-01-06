package br.com.ricas.caixa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CaixaApplication

fun main(args: Array<String>) {
	runApplication<CaixaApplication>(*args)
}
