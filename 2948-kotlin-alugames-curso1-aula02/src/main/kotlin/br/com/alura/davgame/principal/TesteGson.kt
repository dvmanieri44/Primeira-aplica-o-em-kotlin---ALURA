package br.com.alura.davgame.principal

import br.com.alura.davgame.modelo.Aluguel
import br.com.alura.davgame.modelo.PeriodoAluguel
import br.com.alura.davgame.modelo.Plano
import br.com.alura.davgame.modelo.PlanoAssinatura
import br.com.alura.davgame.servicos.consumoApi
import java.time.LocalDate

fun main() {

    val testeConsumo = consumoApi()

    val jogoGTA = testeConsumo.buscaJogo(1)

    val jogotLoU = testeConsumo.buscaJogo(2)

    val gamerLista = testeConsumo.buscaGamers()

    val gamer = gamerLista?.get((1))


    val periodoAluguel = PeriodoAluguel(LocalDate.now(), LocalDate.now().plusDays(3))

    var aluguellJogo = gamer?.alugaJogo(jogoGTA,periodoAluguel)

    gamer?.plano = PlanoAssinatura("PRATA",24.4,4)

    aluguellJogo = gamer?.alugaJogo(jogotLoU,periodoAluguel)
    aluguellJogo = gamer?.alugaJogo(jogotLoU,periodoAluguel)
    aluguellJogo = gamer?.alugaJogo(jogotLoU,periodoAluguel)
    aluguellJogo = gamer?.alugaJogo(jogotLoU,periodoAluguel)
    aluguellJogo = gamer?.alugaJogo(jogotLoU,periodoAluguel)




    println(aluguellJogo)
    println(gamer?.jogosAlugados)


}