package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter();
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    var unitInput = "";
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Inside column all the UI elements will be stacked vertically
        Text(text = "Unit Converter");
        Spacer(modifier = Modifier.height(16.dp));
        OutlinedTextField(value = unitInput, onValueChange = {}, placeholder = {Text(text = "Enter value")});
        Spacer(modifier = Modifier.height(16.dp));
        Row {
            // Inside row all the UI elements will be stacked horizontally
            Box {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF89CFF0))) {
                    Text(text = "Select");
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null);
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(8.dp));
            Box {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF89CFF0))) {
                    Text(text = "Select");
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null);
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = { /*TODO*/ })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp));
        Text(text = "Result: ")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter();
}