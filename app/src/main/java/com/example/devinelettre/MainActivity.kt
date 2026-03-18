package com.example.devinelettre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.devinelettre.ui.theme.DevineLettreTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevineLettreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GuessLetterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GuessLetterScreen(modifier: Modifier = Modifier) {
    val lettres = LocalContext.current.resources.getStringArray(R.array.liste_lettres)
    var lettreCourante by remember { mutableStateOf(lettres.random()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .padding(horizontal = 24.dp, vertical = 62.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = lettreCourante,
                fontSize = 440.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                lineHeight = 120.sp
            )
        }

        Button(
            onClick = { lettreCourante = lettres[Random.nextInt(lettres.size)] },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2B2B2B),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(bottom = 100.dp)
                .widthIn(min = 160.dp)
                .heightIn(min = 64.dp),
        ) {
            Text(text = "Dévine", fontSize = 22.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuessLetterScreenPreview() {
    DevineLettreTheme {
        GuessLetterScreen()
    }
}