package br.com.fiap.guardiao_app.screens

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.guardiao_app.components.Footer
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocalizacaoScreen(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    val statusPermissao = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    var localizacaoAtual by remember { mutableStateOf<LatLng?>(null) }
    val localCliente = remember { LocationServices.getFusedLocationProviderClient(context) }

    LaunchedEffect(statusPermissao.allPermissionsGranted) {
        if (statusPermissao.allPermissionsGranted) {
            localCliente.getLastLocation { location ->
                location?.let {
                    localizacaoAtual = LatLng(it.latitude, it.longitude)
                }
            }
        } else {
            statusPermissao.launchMultiplePermissionRequest()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            LocalizacaoHeader()

            val localizacao = localizacaoAtual

            localizacao?.let { loc ->
                val cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(loc, 15f)
                }

                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState
                ) {
                    Marker(
                        state = rememberMarkerState(position = loc),
                        title = "Sua localização"
                    )
                }
            } ?: run {
                Text("Obtendo localização...", modifier = Modifier.padding(16.dp))
            }
        }

        Footer(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@SuppressLint("MissingPermission")
private fun FusedLocationProviderClient.getLastLocation(onSuccess: (Location?) -> Unit) {
    this.lastLocation.addOnSuccessListener { location: Location? ->
        onSuccess(location)
    }
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
                color = androidx.compose.ui.graphics.Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
