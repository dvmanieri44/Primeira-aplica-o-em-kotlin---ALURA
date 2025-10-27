import br.com.alura.davgame.modelo.Gamer

fun main() {
    var jogador = Gamer("Davi", "dvponce3@gmail.com")

    println(jogador.toString())

    var jogadorDois = Gamer("Davi", "dvponce3@gmail.com", "18/08/2005", "dvmanmieri")

    println(jogadorDois.toString())
    jogador.let {
        it.usuario = "dvponce3@gmail.com"
        it.dataNascimento ="18/08/2500 asd asdasdas"



    }
    println(jogador.toString())


}