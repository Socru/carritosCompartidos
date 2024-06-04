package com.example.carritoscompartidos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carritoscompartidos.ui.theme.CarritosCompartidosTheme

class CreateTripActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarritosCompartidosTheme {
                CreateTripScreen(onCreateTrip = { origin, destination, price, seats ->
                    // Aquí podrías manejar la lógica para guardar el viaje, por ejemplo en una base de datos
                    Toast.makeText(this, "Viaje creado: $origin -> $destination con $price USD y $seats asientos", Toast.LENGTH_LONG).show()
                    // Volver a la actividad anterior después de crear el viaje
                    finish()
                })
            }
        }
    }
}

@Composable
fun CreateTripScreen(onCreateTrip: (String, String, String, String) -> Unit) {
    var origin by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var seats by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Crear nuevo viaje")

        OutlinedTextField(
            value = origin,
            onValueChange = { origin = it },
            label = { Text("Origen") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destino") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Precio (USD)") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = seats,
            onValueChange = { seats = it },
            label = { Text("Número de asientos") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(onClick = {
            onCreateTrip(origin, destination, price, seats)
        }, modifier = Modifier.padding(vertical = 8.dp)) {
            Text("Crear viaje")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateTripScreenPreview() {
    CarritosCompartidosTheme {
        CreateTripScreen { origin, destination, price, seats ->
            // Vista previa no realiza ninguna acción
        }
    }
}
