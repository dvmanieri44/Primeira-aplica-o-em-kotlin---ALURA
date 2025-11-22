package br.com.alura.davgame.modelo

class PlanoAssinatura(tipo: String,
    val mensalidade:Double,
    val jogosIncluidos: Int
    ): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double{

        val alugados = aluguel.gamer?.jogosAlugados?.size?:0

        println("Alugados: $alugados e $jogosIncluidos")

        if( alugados > jogosIncluidos){
            return (aluguel.jogo?.preco?: 0.0) * (aluguel.perioro.emDias)
        }

        return mensalidade
    }

}