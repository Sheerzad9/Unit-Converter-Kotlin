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
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var inputValue by remember { mutableStateOf("") };
    var outputValue by remember { mutableStateOf("") };
    var inputUnit by remember { mutableStateOf("Centimeters") };
    var outputUnit by remember { mutableStateOf("Meters") };
    var iExpanded by remember { mutableStateOf(false) };
    var oExpanded by remember { mutableStateOf(false) };
    val conversionFactor = remember { mutableStateOf(0.01) };

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Inside column all the UI elements will be stacked vertically
        Text(text = "Unit Converter");
        Spacer(modifier = Modifier.height(16.dp));
        OutlinedTextField(value = inputValue, onValueChange = {
              inputValue = it;
        }, placeholder = {Text(text = "Enter value")});
        Spacer(modifier = Modifier.height(16.dp));

        Row() {
            Text(text = "From", modifier = Modifier.padding(55.dp, 0.dp, 100.dp, 8.dp));
            Text(text = "To", modifier = Modifier.padding(5.dp, 0.dp, 140.dp, 8.dp));
        }
        Row {
            // Inside row all the UI elements will be stacked horizontally
            Box {
                Button(onClick = { iExpanded = !iExpanded },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF89CFF0)), modifier = Modifier.width(135.dp)) {
                    Text(text = inputUnit);
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null);
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = {
                        iExpanded = false;
                        inputUnit = "Millimeters";
                    })
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = {
                        iExpanded = false;
                        inputUnit = "Centimeters";
                        conversionFactor.value = 0.01;
                    })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = {
                        iExpanded = false;
                        inputUnit = "Meters";
                    })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = {
                        iExpanded = false;
                        inputUnit = "Feet";
                    })
                }
            }
            Spacer(modifier = Modifier.width(8.dp));
            Box {
                Button(onClick = { oExpanded = !oExpanded },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF89CFF0)), modifier = Modifier.width(135.dp)) {
                    Text(text = outputUnit);
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null);
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = {
                        oExpanded = false;
                        outputValue = "Millimeters";
                    })
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = {
                        oExpanded = false;
                        outputValue = "Centimeters";
                    })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = {
                        oExpanded = false;
                        outputValue = "Meters";
                    })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = {
                        oExpanded = false;
                        outputValue = "Feet";
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp));
        Text(text = "Result: ${outputValue}");
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter();
}