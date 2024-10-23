package com.nubisuno.nativelibraryappdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nubisuno.nativelibraryappdemo.ui.theme.NativeLibraryAppDemoTheme
import com.nubisuno.roktsdkimplemenation.RoktSDkWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        RoktSDkWrapper.initializeSDK("222", "4.6.0", this@MainActivity)
        setContent {
            NativeLibraryAppDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        val attributes: MutableMap<String, String> = HashMap()

        attributes["email"] = "j.smith@example.com"
        attributes["firstname"] = "Jenny"
        attributes["lastname"] = "Smith"
        attributes["mobile"] = "(323) 867-5309"
        attributes["postcode"] = "90210"
        attributes["country"] = "US"

        RoktSDkWrapper.executeLayout(attributes, "<!-VIEW_NAME->")
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
    NativeLibraryAppDemoTheme {
        Greeting("Android")
    }
}