package br.com.fiap.guardiao_app.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.guardiao_app.R
import br.com.fiap.guardiao_app.components.Footer
import br.com.fiap.guardiao_app.service.network.RetrofitInstance
import br.com.fiap.guardiao_app.service.network.model.Article
import coil.compose.rememberImagePainter

val AzulRoyal = Color(0xFF6495ED)

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    var articles by remember { mutableStateOf<List<Article>>(emptyList()) }

    LaunchedEffect(Unit) {
        val response = RetrofitInstance.api.getTopHeadlines(apiKey = "2ccdf4c678f84d599baf310036e51ba7")
        articles = response.articles
        articles.forEach { article ->
            Log.d("NewsImage", "Image URL: ${article.urlToImage}")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Cabeçalho
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(color = AzulRoyal)
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo guardião",
                modifier = Modifier.size(100.dp),
            )
        }

        // Corpo da página com rolagem
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 80.dp, bottom = 80.dp)
                .background(Color.White)
                .padding(32.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Input(name = "FIAP")
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Text(
                        text = "Principais notícias",
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Image(
                        painter = painterResource(id = R.drawable.noticias),
                        contentDescription = "Globo de noticias",
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(articles.size) { index ->
                NewsItem(article = articles[index])
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Rodapé
        Footer(
            navController = navController,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun NewsItem(article: Article) {
    Column(modifier = Modifier.fillMaxWidth()) {
        article.urlToImage?.let {
            Image(
                painter = rememberImagePainter(data = it),
                contentDescription = article.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        Text(text = article.title, fontSize = 18.sp, modifier = Modifier.padding(top = 8.dp))
        Text(text = article.description ?: "", fontSize = 14.sp, color = Color.Gray)
    }
}


@Composable
fun Input(name: String) {

    var texto by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = texto,
        onValueChange = { novoTexto ->
            texto = novoTexto
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {
            Text(text = "Pesquisa")
        },
        placeholder = {
            Text(text = "O que você deseja?")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Ícone de lupa")
        },
    )
}