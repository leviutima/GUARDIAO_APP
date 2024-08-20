package br.com.fiap.guardiao_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.guardiao_app.screens.AzulRoyal
import androidx.compose.foundation.layout.navigationBarsPadding

@Composable
fun Footer(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = AzulRoyal)
            .navigationBarsPadding() // Adiciona padding para evitar sobreposição
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Perfil usuário",
                modifier = Modifier
                    .size(62.dp)
                    .clickable {
                        navController.navigate("Cadastro")
                    }
            )
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Emergência",
                modifier = Modifier
                    .size(62.dp)
                    .clickable {
                    }
            )
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier
                    .size(62.dp)
                    .clickable {
                        navController.navigate("Home")
                    }
            )
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = "Localização",
                modifier = Modifier
                    .size(62.dp)
                    .clickable {
                        navController.navigate("Localizacao")
                    }
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Contatos",
                modifier = Modifier
                    .size(62.dp)
                    .clickable {
                        navController.navigate("Contatos")
                    }
            )
        }
    }
}
