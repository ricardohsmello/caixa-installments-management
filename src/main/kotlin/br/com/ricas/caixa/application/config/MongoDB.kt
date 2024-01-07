package br.com.ricas.caixa.application.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class MongoDB {

    @Value("\${username}")
    lateinit var username: String

    @Value("\${password}")
    lateinit var password: String

    @Value("\${cluster}")
    lateinit var cluster: String

    @Value("\${database}")
    lateinit var database: String



}