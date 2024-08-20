package br.com.fiap.guardiao_app.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LocalizacaoScreen(modifier: Modifier = Modifier, navController: NavController){

}
@Composable
fun LocalizacaoHeader() {
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
                text = "Localização Atual",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}