package com.example.carritoscompartidos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carritoscompartidos.ui.theme.CarritosCompartidosTheme

class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recuperar el tipo de usuario del intent
        val userType = intent.getStringExtra("USER_TYPE") ?: "2" // Valor predeterminado: Usuario
        val userTypeString = convertUserTypeToString(userType)

        setContent {
            CarritosCompartidosTheme {
                MapScreen(userTypeString)
            }
        }
    }

    private fun convertUserTypeToString(userType: String): String {
        return when (userType) {
            "0" -> "Administrador"
            "1" -> "Conductor"
            else -> "Usuario"
        }
    }
}

@Composable
fun MapScreen(userType: String) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Bienvenido al mapa, $userType")

        if (userType == "Conductor") {
            Button(onClick = {
                val intent = Intent(context, CreateTripActivity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier.padding(vertical = 8.dp)) {
                Text("Crear nuevo viaje")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    CarritosCompartidosTheme {
        MapScreen(userType = "Conductor")
    }
}
