package mx.delasalle.loteriamexicana.ui
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import mx.delasalle.loteriamexicana.ui.screen.FirstScreen
import mx.delasalle.loteriamexicana.ui.screen.SecondScreen

@Preview(showBackground = true)
@Composable
fun NavigationApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first_screen"){
        composable ("first_screen"){
            FirstScreen(innerPadding = 16.dp,navController)
        }
        composable ("second_screen") {
            SecondScreen(innerPadding = 16.dp, navController)
        }

    }
}