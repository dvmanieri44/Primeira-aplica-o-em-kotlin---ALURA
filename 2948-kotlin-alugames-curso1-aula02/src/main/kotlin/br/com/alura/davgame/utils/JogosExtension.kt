package br.com.alura.davgame.utils

import br.com.alura.davgame.modelo.InfoJogo
import br.com.alura.davgame.modelo.Jogo

fun InfoJogo.retornaJogos(): Jogo {
    return Jogo(this.titulo,this.descricao,this.preco)
}
