package com.example.jetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcompose.ui.theme.JetComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp).background(brush = Brush.linearGradient(colors = listOf(
                                Color.LightGray, Color.White))),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally){
                        val username = remember {
                            mutableStateOf(TextFieldValue())
                        }
                        val password = remember {
                            mutableStateOf(TextFieldValue())
                        }

                        Text(text = "LOGIN PAGE", style = MaterialTheme.typography.displaySmall
                            ,)
                        Spacer(modifier = Modifier.height(40.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = username.value , onValueChange = {
                                                                     username.value=it
                            }
                            ,
                            label = { Text(text = "Username")},
                            visualTransformation = VisualTransformation.None )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password.value, onValueChange= {
                                                                   password.value=it
                            },
                            label = { Text(text = "Password")},
                            visualTransformation = PasswordVisualTransformation() )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp), onClick = { /*TODO*/ }) {
                            Text(text = "Login")
                            
                        }

                    }

            }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetComposeTheme {
        Greeting("Android")
    }
}