package br.com.alura.davgame.modelo

import kotlin.Double

open class Plano(var tipo: String) {

    open fun obterValor(aluguel: Aluguel): Double{
        return (aluguel.jogo?.preco?: 0.0) * (aluguel.perioro.emDias)
    }
}