package br.com.alura.davgame.servicos

import br.com.alura.davgame.modelo.Gamer
import br.com.alura.davgame.modelo.InfoGamer
import br.com.alura.davgame.modelo.InfoJogo
import br.com.alura.davgame.modelo.Jogo
import br.com.alura.davgame.utils.retornaGamer
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.sun.jdi.Type
import java.io.File


class consumoApi {


    fun buscaJogo (id: String): InfoJogo{

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id="+id))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaGamers (): List<Gamer>?{

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val type = Types.newParameterizedType(List::class.java, InfoGamer::class.java)

        val jsonAdapter = moshi.adapter<List<InfoGamer>>(type)

        val jsonString = File("src/main/kotlin/br/com/alura/davgame/dados/gamers.json").readText()

        val listaGamers = jsonAdapter.fromJson(jsonString)

        val listaGamersConvertida = listaGamers?.map {
            infoGamer -> infoGamer.retornaGamer()
        }

        return listaGamersConvertida

    }

    private fun getJsonFromFile(fileName: String): String {
        val inputStream = this::class.java.classLoader.getResourceAsStream(fileName)
        return inputStream?.bufferedReader()?.readText()
            ?: throw IllegalArgumentException("Arquivo não encontrado: $fileName")
    }

}