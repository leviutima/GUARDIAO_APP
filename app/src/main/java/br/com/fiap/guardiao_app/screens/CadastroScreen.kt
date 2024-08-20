package br.com.fiap.guardiao_app.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.guardiao_app.components.Footer
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Composable
fun HeaderCadastro() {
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
                text = "Cadastro",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}



@Composable
fun CadastroScreen(modifier: Modifier = Modifier, navController: NavController) {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarsenha by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var autorizo by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderCadastro()

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 32.dp)
                    .padding(top = 16.dp)
            ) {
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text(text = "Nome Completo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text(text = "Senha") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                OutlinedTextField(
                    value = confirmarsenha,
                    onValueChange = { confirmarsenha = it },
                    label = { Text(text = "Confirmar Senha") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = celular,
                        onValueChange = { celular = it },
                        label = { Text("Celular") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )

                    OutlinedTextField(
                        value = cep,
                        onValueChange = { cep = it },
                        label = { Text("CEP") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .weight(1f)
                    )
                }

                OutlinedTextField(
                    value = dataNascimento,
                    onValueChange = { dataNascimento = it },
                    placeholder = {
                        Text(text = "Data de nascimento")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Gray)
                        .clickable {
                            showDatePicker(context) { selectedDate ->
                                dataNascimento = selectedDate
                            }
                        },
                    readOnly = true,
                    enabled = false,
                    singleLine = true
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = autorizo,
                        onCheckedChange = { autorizo = it }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Eu, autorizo o aplicativo \"Segurança\" a coletar, armazenar e compartilhar minhas informações pessoais, incluindo nome, localização, e detalhes de contato, com meus contatos de emergência e autoridades locais, em situações de emergência. Entendo que essas informações serão usadas exclusivamente para fins de proteção e suporte, conforme descrito nos Termos de Uso e na Política de Privacidade do aplicativo.",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.width(500.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AzulRoyal
                        )
                    ) {
                        Text(text = "Cadastrar")
                    }
                }
            }
            Footer(
                modifier = Modifier.fillMaxWidth(),
                navController = navController
            )
        }
    }
}



fun showDatePicker(context: android.content.Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = android.app.DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(selectedYear, selectedMonth, selectedDay)
            val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            onDateSelected(format.format(selectedDate.time))
        },
        year, month, day
    )

    // Verifique se o diálogo está sendo exibido
    Log.d("showDatePicker", "DatePickerDialog será exibido")

    datePickerDialog.show()
}