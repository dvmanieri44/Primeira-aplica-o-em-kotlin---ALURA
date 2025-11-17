package br.com.alura.davgame.utils

import br.com.alura.davgame.modelo.Gamer
import br.com.alura.davgame.modelo.InfoGamer

fun InfoGamer.retornaGamer():Gamer{
    return Gamer(this.nome,this.email)
}