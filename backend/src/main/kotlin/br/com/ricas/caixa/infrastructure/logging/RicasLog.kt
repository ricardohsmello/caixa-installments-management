package br.com.ricas.caixa.infrastructure.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class RicasLog
inline fun <reified T> T.logger(): Logger {
    return LoggerFactory.getLogger(T::class.java)
}