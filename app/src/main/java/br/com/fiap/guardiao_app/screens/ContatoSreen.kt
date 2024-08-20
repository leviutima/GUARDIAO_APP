package br.com.fiap.guardiao_app.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.guardiao_app.R
import br.com.fiap.guardiao_app.components.Footer


@Composable
fun ContactsHeader() {
    Surface(
        color = AzulRoyal,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(0.dp) // Remove qualquer padding extra
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Contatos",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}


@Composable
fun IconWithLabelAndAction(iconResId: Int, label: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(2.dp, Color(0xFF428BEA)) // Cor da borda atualizada
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = label,
                    modifier = Modifier.size(36.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = label,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_map_24), // Atualizado para o novo ícone
                        contentDescription = "Mapa",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Enviar Localização",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun AddContactButton(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                navController.navigate("Adicionar")
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_person_add_alt_1_24),
            contentDescription = "Adicionar Contato",
            modifier = Modifier
                .size(36.dp)
                .clickable{
                    navController.navigate("Adicionar")
                },
            tint = Color.Black

        )
        Text(
            text = "Adicionar Contato",
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Composable
fun ContactsScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactsHeader()
        AddContactButton(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconWithLabelAndAction(
                iconResId = R.drawable.baseline_person_24,
                label = "Mãe"
            )
            IconWithLabelAndAction(
                iconResId = R.drawable.baseline_person_24,
                label = "Pai"
            )
            IconWithLabelAndAction(
                iconResId = R.drawable.baseline_person_24,
                label = "Irmã"
            )
            IconWithLabelAndAction(
                iconResId = R.drawable.baseline_person_24,
                label = "Irmão"
            )
            IconWithLabelAndAction(
                iconResId = R.drawable.baseline_person_24,
                label = "Tia"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Footer(navController = navController,
                modifier = Modifier.fillMaxWidth())
    }
}


