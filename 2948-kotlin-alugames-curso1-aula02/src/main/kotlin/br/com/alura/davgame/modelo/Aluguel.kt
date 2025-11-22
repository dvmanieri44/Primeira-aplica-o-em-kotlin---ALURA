package br.com.alura.davgame.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(val gamer: Gamer?,
                   val jogo: Jogo?,
                   val perioro: PeriodoAluguel,

){
            val valorAluguel = gamer?.plano?.obterValor(this)

            override fun toString(): String {
        return "O jogador: ${gamer?.nome}, está alugando o jogo: ${jogo?.titulo}, pelo valor de R$$valorAluguel"
    }
}
