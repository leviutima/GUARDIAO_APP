package br.com.fiap.guardiao_app.service.network.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)