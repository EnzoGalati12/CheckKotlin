package br.com.rm95608.enzo.api

import br.com.rm95608.enzo.model.Naruto
import br.com.rm95608.enzo.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NarutoApi {

    @GET("character")
    fun getNarutoInfo(@Path("characterId") narutoname: String?): Call<Naruto>

    @GET("character/{characterId}")
    fun getNarutoRepos(@Path("characterId") narutoname: String?): Call<List<Repository>>
}


//https://narutodb.xyz/api/character/{characterId}