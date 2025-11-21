package br.com.alura.davgame.principal

import br.com.alura.davgame.modelo.Aluguel
import br.com.alura.davgame.modelo.PeriodoAluguel
import br.com.alura.davgame.servicos.consumoApi
import java.time.LocalDate

fun main() {
    val testeConsumo = consumoApi()

   // val gamers = testeConsumo.buscaGamers()

    val jogoGTA = testeConsumo.buscaJogo(1)

    val jogotLoU = testeConsumo.buscaJogo(2)


    //todo: Deixar os métodos iguais, ou passa parametro o o jogo é decidido na classe consumo api, ou pega a lista inteira e define aqui
    val gamerLista = testeConsumo.buscaGamers()

    val gamer = gamerLista?.get((1))


    val periodoAluguel = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(3))

    var aluguellJogo = gamer?.alugaJogo(jogoGTA,periodoAluguel)

    aluguellJogo = gamer?.alugaJogo(jogotLoU,periodoAluguel)


    println(gamer?.jogosAlugados)


}