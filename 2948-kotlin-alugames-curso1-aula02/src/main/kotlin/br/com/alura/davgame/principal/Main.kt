package br.com.alura.davgame.principal

import br.com.alura.davgame.modelo.Gamer
import br.com.alura.davgame.modelo.Jogo
import br.com.alura.davgame.servicos.consumoApi
import java.util.*


fun main() {

    //Classe principal utilizada para inicar games

    // Próxima aula: "Refatorando código"


    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso!")

    do {

        val id = leitura.nextLine()

        val api = consumoApi()

        val infomacaoJogo = api.buscaJogo(id)

        var meuJogo: Jogo? = null

        val chamada = runCatching {
            meuJogo = Jogo(
                infomacaoJogo.info.title,
                infomacaoJogo.info.thumb

            )

        }

        chamada.onFailure {
            println("br.com.alura.davgame.modelo.Jogo inexistente")
        }

        chamada.onSuccess {
            println("Você deseja colocar uma descrição personalizada? S/N")

            val opcao = leitura.nextLine()

            if (opcao.equals("S",true)){

                val descricao = leitura.nextLine()
                meuJogo?.descricao = descricao

            }else{
                meuJogo?.descricao = meuJogo?.titulo
            }

            gamer.jogosBuscados.add(meuJogo)
        }

        println(meuJogo.toString())
        println("===/===")
        println("Deseja continuar procurando mais jogos? S/N")
        val resposta = leitura.nextLine()





    }while (resposta.equals("s",true))

    println("Fim")
    println(gamer.jogosBuscados)

    println("\nJogos ordenados por título:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo:" +it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman",true) ?: false
    }

    println("=== Jogos filtrados ===")

    println(jogosFiltrados)


    println("Deseja excluir algum item da lista?")
    val opcao = leitura.nextLine()
    if(opcao.equals("s",true)){

        println(gamer.jogosBuscados)

        println("\n===/===\nInforme a posição do jogo que quer excluir")

        val posicao = leitura.nextInt()

        leitura.nextLine()

        gamer.jogosBuscados.removeAt(posicao)

        println("Lista atualizada!")
        println(gamer.jogosBuscados)
    }

    println("Busca finalizada!!")



}