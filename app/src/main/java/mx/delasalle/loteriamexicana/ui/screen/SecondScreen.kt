package mx.delasalle.loteriamexicana.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mx.delasalle.loteriamexicana.R
import java.util.Random

//Se agregan cambios a estos archivos para corroborar visibilidad en gitlab remoto

@Composable
fun SecondScreen (innerPadding: Dp, navController: NavController){
    val imageList: List<String> = (1..30).map { "img_${it}i" }
    var newImg by remember {
        mutableStateOf(imageList[0])
    }
    var imgId by remember {
        mutableStateOf("img_0i")
    }
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        //.padding(innerPadding),
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        val imageId = remember(newImg) {
            context.resources.getIdentifier(newImg, "drawable", context.packageName)
        }
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Carta actual",
            modifier = Modifier
                .size(200.dp) // Tamaño fijo de 200x200 dp
                .clip(RoundedCornerShape(8.dp)), // Opcional: añadir esquinas redondeadas
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val i = generarAleatorio()
            println(imageList[i])
            newImg = imageList[i]
            //Codigo necesario para cambiar la imagen conforme al nombre que corresponda al indice i
        }) {
            Text(text = "Siguiente Carta")

        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("first_screen")
        }) {
            Text(text = "Terminar Juego")
        }
    }

}

fun generarAleatorio(): Int {
    var r = Random()
    return r.nextInt(30)
}
