package br.com.fiap.guardiao_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.guardiao_app.screens.AdicionarContato
import br.com.fiap.guardiao_app.screens.CadastroScreen
import br.com.fiap.guardiao_app.screens.ContactsScreen
import br.com.fiap.guardiao_app.screens.HomeScreen
import br.com.fiap.guardiao_app.screens.LocalizacaoScreen
import br.com.fiap.guardiao_app.ui.theme.GUARDIAO_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GUARDIAO_APPTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ) {
                    composable(route = "Home"){ HomeScreen(navController = navController)}
                    composable(route = "Cadastro"){ CadastroScreen(navController = navController) }
                    composable(route = "Contatos"){ ContactsScreen(navController = navController) }
                    composable(route = "Adicionar"){ AdicionarContato(navController = navController) }
                    composable(route = "Localizacao"){ LocalizacaoScreen(navController = navController)}
                }


            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GUARDIAO_APPTheme {
        HomeScreen(navController = rememberNavController())
    }
}