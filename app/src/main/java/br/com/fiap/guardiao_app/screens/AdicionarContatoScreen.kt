package br.com.fiap.guardiao_app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.guardiao_app.components.Footer


@Composable
fun AdicionarContato(modifier: Modifier = Modifier, navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        AdicionarContatoHeader()

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = celular,
                onValueChange = {celular = it},
                label = { Text(text = "Celular")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(16.dp))
            
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(500.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AzulRoyal
                )
                ) {
                Text(
                    text = "Adicionar",
                    color = Color.White
                )
            }
        }

        Footer(modifier = Modifier.fillMaxWidth(), navController = navController)
    }
}

@Composable
fun AdicionarContatoHeader() {
    Surface(
        color = AzulRoyal,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(0.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Adicionar",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}