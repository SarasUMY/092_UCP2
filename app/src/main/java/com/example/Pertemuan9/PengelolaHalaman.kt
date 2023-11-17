package com.example.Pertemuan9

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

enum class PengelolaHalaman {
    Home,
    Summary,
    Formulir
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormApp(
    viewModel: FormViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
) {
     Scaffold {innerPadding ->
         val uiState by viewModel.stateUI.collectAsState()

         NavHost(
             startDestination = PengelolaHalaman.Home.name,
             modifier = Modifier.padding(innerPadding)
         )
         {
             composable(route = PengelolaHalaman.Home.name) {
                 HalamanHome(onNextButtonClicked = {
                     navController.navigate(PengelolaHalaman.Formulir.name)
                 })
             }

             composable(route = PengelolaHalaman.Formulir.name) {
                 HalamanHome(
                     onSubmitButtonClicked = {
                         viewModel.setBiodata(it)
                         navController.navigate(PengelolaHalaman.Formulir.name)
                     })
             }

             composable(route = PengelolaHalaman.Formulir.name) {
                 val context = LocalContext.current
                 HalamanSatu(
                     pilihanDosen = DospemSa.map {id -> context.resources.getString(id)},
                     onSelectionChanged = {viewModel.setDospemDua(it)},
                     onNextButtonClicked = { navController.navigate(PengelolaHalaman.Home.name) },
         }
     }
     }
}