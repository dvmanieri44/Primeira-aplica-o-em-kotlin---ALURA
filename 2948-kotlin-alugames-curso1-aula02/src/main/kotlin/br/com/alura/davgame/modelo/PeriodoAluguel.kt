package br.com.alura.davgame.modelo

import java.time.LocalDate
import java.time.Period

data class PeriodoAluguel(val dataInicial: LocalDate,
                          val dataEntrega: LocalDate,
                          val emDias: Int = Period.between(dataInicial,dataEntrega).days
){

}
