package br.com.alura.davgame.principal

import br.com.alura.davgame.servicos.consumoApi

fun main() {
    val testeConsumo = consumoApi()

   // val gamers = testeConsumo.buscaGamers()

    val jogo = testeConsumo.buscaJogo(1)

    println(jogo)


}