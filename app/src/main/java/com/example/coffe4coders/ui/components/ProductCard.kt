package com.example.coffe4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R
import com.example.coffe4coders.ui.theme.Coffe4codersTheme
import com.example.coffe4coders.ui.theme.PlatziBlue
import com.example.coffe4coders.ui.theme.PlatziGreen


enum class CountryISO(val iso:String){
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun backgroundImage():Int {
        when(this){
            COL-> return R.drawable.co
            BRA-> return R.drawable.br
            CRI-> return R.drawable.ri
            NIC-> return R.drawable.ni
        }
    }

    fun countryFlag():Int {
        when(this){
            COL-> return R.drawable.flagco
            BRA-> return R.drawable.flagbr
            CRI-> return R.drawable.flagri
            NIC-> return R.drawable.flagni
        }
    }

    fun getSurfaceColor():Color {
        when(this){
            COL,NIC-> return PlatziBlue
            BRA,CRI -> return PlatziGreen
        }
    }

}

typealias SelectedAction =()->Unit


@Composable
fun ProductCard(name:String,
                summary:String,
                price:Double,
                currency:String,
                country:CountryISO,
                selected:SelectedAction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selected()
            }
            .size(480.dp)
    ) {
        Image(painter = painterResource(country.backgroundImage()), contentDescription = null)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.getSurfaceColor().copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(name, style = MaterialTheme.typography.h4)
                Text(summary, style = MaterialTheme.typography.body1)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row {
                        Image(
                            painter = painterResource(country.countryFlag()),
                            contentDescription = null, modifier = Modifier.size(32.dp,32.dp)
                        )
                        Text("$ $price $currency", modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4)
                    }



                }

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {

    Coffe4codersTheme() {
        ProductCard("Café de Colombia",
            "Café de las Montañas",
            35.0,"USD",
            CountryISO.COL)
             {}
    }

}