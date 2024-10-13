package mx.delasalle.loteriamexicana.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.delasalle.loteriamexicana.R

//@Preview(showBackground = true)
@Composable
fun FirstScreen(innerPadding: Dp, navController: NavController){
//
    Column(modifier = Modifier
        .fillMaxSize()
        //.padding(innerPadding),
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(painter = painterResource(id = R.drawable.logoloteria), contentDescription = "Logo")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("second_screen")
        }) {
            Text(text = "Iniciar Juego")
        }
    }

}