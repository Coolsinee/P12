package com.example.p12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.serpro69.kfaker.Faker
import com.example.p12.ui.theme.P12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}
@Composable
fun CityItem(text: String) {
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))
}

@Composable
fun MyScreen() {
    val faker = Faker()
    val citiz = remember {
        (1..50).map{faker.address.city()}.toMutableStateList()
    }
    Column(modifier = Modifier.verticalScroll(ScrollState(0), true)) {
        TextButton(onClick = { citiz.add(faker.address.city()) }) {
            CityItem("+")
        }
        citiz.forEach {
            key(it) { CityItem(it) }
        }
    }
}

@Composable
fun CityItem1(text: String) {
    Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))

}
@Composable
fun MyScreen1() {
    val faker = Faker()
    val citiz1 = remember {
        (1..10000).map{ faker.address.city() }.toMutableStateList()
    }
    LazyColumn() {
        items(citiz1) { item ->
            CityItem1(text = item)
        }
    }
}
