package com.example.myapplication.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyView() {

    var txtName by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val items = listOf(
        "Android",
        "Kotlin",
        "Java",
        "Compose",
        "XML",
        "ViewModel",
        "LiveData",
        "Room",
        "DataStore",
        "Coroutines"
    )

    val filteredItems = remember(txtName) {
        if (txtName.isEmpty()) {
            emptyList()
        } else {
            items.filter {
                it.contains(txtName, ignoreCase = true)
            }
        }
    }

    ExposedDropdownMenuBox(
        expanded = expanded && filteredItems.isNotEmpty(),
        onExpandedChange = { expanded = it }) {

        OutlinedTextField(
            value = txtName,
            onValueChange = {
                txtName = it
                expanded = true
            },
            label = { Text("Enter Tools Android") },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded =expanded && filteredItems.isNotEmpty() ,
            onDismissRequest = { expanded=false }) {

            filteredItems.forEach { item->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                       txtName=item
                       expanded=false

                    })

            }

        }




    }

}