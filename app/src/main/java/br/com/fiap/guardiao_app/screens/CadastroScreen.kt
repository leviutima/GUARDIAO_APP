package br.com.fiap.guardiao_app.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.guardiao_app.R
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
            .height(60.dp) // Ajuste a altura conforme necessário
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp), // Ajusta o padding horizontal
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Espaça a imagem e o texto
        ) {
            // Imagem no canto superior esquerdo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(40.dp) // Ajuste o tamanho conforme necessário
            )

            // Texto centralizado
            Text(
                text = "Cadastro",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .weight(1f) // Faz o texto ocupar o espaço restante
                    .align(Alignment.CenterVertically), // Centraliza verticalmente
                textAlign = TextAlign.Center
            )
        }
    }
}


@Composable
fun CadastroScreen(modifier: Modifier = Modifier, navController: NavController) {

    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }
    val focusRequester5 = remember { FocusRequester() }
    val focusRequester6 = remember { FocusRequester() }
    val focusRequester7 = remember { FocusRequester() }

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarsenha by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    var autorizo by remember { mutableStateOf(false) }

    var nomeErro by remember { mutableStateOf(false) }
    var emailErro by remember { mutableStateOf(false) }
    var senhaErro by remember { mutableStateOf(false) }
    var confirmarsenhaErro by remember { mutableStateOf(false) }
    var dataNascimentoErro by remember { mutableStateOf(false) }
    var celularErro by remember { mutableStateOf(false) }
    var cepErro by remember { mutableStateOf(false) }
    var autorizoErro by remember { mutableStateOf(false) }

    var erroMensagem by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Erro") },
            text = { Text(text = erroMensagem) },
            confirmButton = {
                Button(
                    onClick = { showDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = AzulRoyal) // Cor do botão OK
                ) {
                    Text("OK", color = Color.White) // Cor do texto do botão OK
                }
            }
        )
    }

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
                    onValueChange = {
                        nome = it
                        nomeErro = false
                    },
                    label = { Text(text = "Nome Completo") },
                    isError = nomeErro,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusRequester2.requestFocus()
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .focusRequester(focusRequester1)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailErro = false
                    },
                    label = { Text(text = "Email") },
                    isError = emailErro,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusRequester3.requestFocus()
                        }
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .focusRequester(focusRequester2)
                )

                OutlinedTextField(
                    value = senha,
                    onValueChange = {
                        senha = it
                        senhaErro = false
                    },
                    label = { Text(text = "Senha") },
                    isError = senhaErro,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusRequester4.requestFocus()
                        }
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .focusRequester(focusRequester3)
                )

                OutlinedTextField(
                    value = confirmarsenha,
                    onValueChange = {
                        confirmarsenha = it
                        confirmarsenhaErro = false
                    },
                    label = { Text(text = "Confirmar Senha") },
                    isError = confirmarsenhaErro,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusRequester5.requestFocus()
                        }
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .focusRequester(focusRequester4)
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = celular,
                        onValueChange = {
                            // Permite apenas números e limita a 11 caracteres
                            celular = it.filter { char -> char.isDigit() }.take(11)
                            celularErro = false
                        },
                        label = { Text("Celular") },
                        isError = celularErro,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Number // Permite apenas números
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusRequester6.requestFocus()
                            }
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                            .focusRequester(focusRequester5)
                    )

                    OutlinedTextField(
                        value = cep,
                        onValueChange = {
                            // Permite apenas números e limita a 8 caracteres
                            cep = it.filter { char -> char.isDigit() }.take(8)
                            cepErro = false
                        },
                        label = { Text("CEP") },
                        isError = cepErro,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number // Permite apenas números
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .focusRequester(focusRequester6)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = dataNascimento,
                    onValueChange = {
                        dataNascimento = it
                        dataNascimentoErro = false
                    },
                    label = { Text("Data de Nascimento") },
                    isError = dataNascimentoErro,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .border(1.dp, Color.Gray)
                        .clickable {
                            showDatePicker(context) { selectedDate ->
                                dataNascimento = selectedDate
                                dataNascimentoErro = false
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
                        onCheckedChange = {
                            autorizo = it
                            autorizoErro = !it  // Atualiza o estado de erro com base na seleção
                        },
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = if (autorizoErro) Color.Red else MaterialTheme.colorScheme.onSurface
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Eu, autorizo o aplicativo \"Guardião\" a coletar, armazenar e compartilhar minhas informações pessoais, incluindo nome, localização, e detalhes de contato, com meus contatos de emergência e autoridades locais, em situações de emergência. Entendo que essas informações serão usadas exclusivamente para fins de proteção e suporte, conforme descrito nos Termos de Uso e na Política de Privacidade do aplicativo.",
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 6.sp
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }


                Button(
                    onClick = {
                        var allFieldsValid = true

                        if (nome.isBlank()) {
                            nomeErro = true
                            allFieldsValid = false
                        }

                        if (email.isBlank()) {
                            emailErro = true
                            allFieldsValid = false
                        }

                        if (senha.isBlank()) {
                            senhaErro = true
                            allFieldsValid = false
                        }

                        if (confirmarsenha.isBlank() || confirmarsenha != senha) {
                            confirmarsenhaErro = true
                            allFieldsValid = false
                        }

                        if (celular.isBlank()) {
                            celularErro = true
                            allFieldsValid = false
                        }

                        if (cep.isBlank()) {
                            cepErro = true
                            allFieldsValid = false
                        }

                        if (dataNascimento.isBlank()) {
                            dataNascimentoErro = true
                            allFieldsValid = false
                        }

                        if (!autorizo) {
                            autorizoErro = true
                            allFieldsValid = false
                        }

                        if (allFieldsValid) {
                            navController.navigate("Home") // Navega para a HomeScreen
                        } else {
                            erroMensagem = "Por favor, preencha todos os campos obrigatórios."
                            showDialog = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AzulRoyal) // Definindo a cor de fundo do botão
                ) {
                    Text(text = "Cadastrar")
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
