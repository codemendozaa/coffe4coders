package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.BodyText
import com.example.coffe4coders.ui.components.CountryISO
import com.example.coffe4coders.ui.components.ProductCard
import com.example.coffe4coders.ui.components.TitleText
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

@Composable
fun FeedScreens(navController: NavController){
    val list = listOf<CountryISO>(
        CountryISO.COL,
        CountryISO.CRI,
        CountryISO.BRA,
        CountryISO.NIC
    )

    Coffe4codersTheme {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)){
                item {
                    Column (modifier = Modifier.padding(8.dp)){
                        TitleText("Welcome")
                        BodyText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500.")
                    }
                }
                items(list){ country ->
                    ProductCard(name = "Cafe de Colombia",
                                summary ="Cafe de las montañas ",
                                price = 35.0 ,
                                currency ="USD",
                                country = country ){
                                navController.navigate("detail"){
                                    launchSingleTop = true
                                }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreensPreview(){
    val navController = rememberNavController()
    FeedScreens(navController)
}
