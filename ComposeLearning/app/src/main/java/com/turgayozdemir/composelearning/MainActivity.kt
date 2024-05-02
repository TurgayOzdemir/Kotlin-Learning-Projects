package com.turgayozdemir.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.turgayozdemir.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface {
                Greeting(name = "Android")
            }
        }

        //testFunction(5, ::testFunctionLambda)
        testFunction(5){
            testFunctionLambda()
        }
    }

    fun testFunction(int : Int, myFunction : () -> Unit){
        myFunction.invoke()
    }

    fun testFunctionLambda(){
        println("Lambda Function")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //Column, Row, Box
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        CustomText(text = "Android")
        Spacer(modifier = Modifier.padding(5.dp))
        CustomText(text = "Kotlin")
        Spacer(modifier = Modifier.padding(5.dp))
        CustomText(text = "Compose")
        Spacer(modifier = Modifier.padding(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            CustomText(text = "TEST 1")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "TEST 2")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "TEST 3")
        }


    }

}

@Composable
fun CustomText(text : String){

    Text(
        modifier = Modifier
            .clickable {
                println("Merhaba")
            }
            .background(color = Color.Cyan)
            .padding(5.dp),
            //.size(150.dp, 50.dp),
        text = "$text!",
        color = Color.Blue,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLearningTheme {
        Greeting("Android")
    }
}