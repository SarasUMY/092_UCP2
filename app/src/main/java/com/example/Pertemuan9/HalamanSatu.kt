package com.example.Pertemuan9

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.a092_ucp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihanDosen: List<String>,
    onSelectionChanged: (String) -> Unit,
    onSubmitButtonClicked: (MutableList<String>) -> Unit
) {
    var nameTxt by remember {
        mutableStateOf("")
    }

    var nimTxt by remember {
        mutableStateOf("")
    }

    var konsentrasiTxt by remember {
        mutableStateOf("")
    }

    var judulTxt by remember {
        mutableStateOf("")
    }

    var listData: MutableList<String> = mutableListOf(nameTxt, nimTxt, konsentrasiTxt, judulTxt)
    var dosenYgDipilih by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Formulir Pengajuan Skripsi",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nameTxt,
            onValueChange = { nameTxt = it },
            label = { Text(text = stringResource(id = R.string.name)) }
        )

        OutlinedTextField(
            value = nimTxt,
            onValueChange = { nimTxt = it },
            label = { Text(text = stringResource(id = R.string.nim)) }
        )

        OutlinedTextField(
            value = konsentrasiTxt,
            onValueChange = { konsentrasiTxt = it },
            label = { Text(text = stringResource(id = R.string.konsentrasi)) }
        )

        OutlinedTextField(
            value = judulTxt,
            onValueChange = { judulTxt = it },
            label = { Text(text = stringResource(id = R.string.judul)) }
        )

        Spacer(modifier = Modifier.height(25.dp))

        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            pilihanDosen.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = dosenYgDipilih == item,
                    onClick = {
                        dosenYgDipilih = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }

            Button(onClick = { onSubmitButtonClicked(listData) }) {
                Text(text = stringResource(id = R.string.btn_submit))
            }

        }
    }
}