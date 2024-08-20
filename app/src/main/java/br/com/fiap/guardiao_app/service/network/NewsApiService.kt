package br.com.fiap.guardiao_app.service.network

import br.com.fiap.guardiao_app.service.network.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String = "br"
    ): NewsResponse
}
