package com.example.todo.presentation.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.theme.backgroundColor
import java.text.DateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoDetail(

) {
    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
    val openDatePicker = remember{ mutableStateOf(false) }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.9f)
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            item{
                OutlinedTextField(
                    value = "Title",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Add title"
                        )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults
                        .colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                )
            }
            item{
                OutlinedTextField(
                    value = "Description",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Add description"
                        )
                    },
                    colors = TextFieldDefaults
                        .colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                )
            }
            item{
                DatePicker(
                    state = datePickerState,
                    title = {
                        Text(
                            text = "Start date"
                        )
                    },
                    colors = DatePickerDefaults
                        .colors(
                            containerColor = Color.White,
                            selectedYearContainerColor = Color.White
                        )
                )
            }
            val df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US)
            item{
                OutlinedTextField(
                    value = "",
                    onValueChange = {

                    },
                    modifier = Modifier
                        .clickable {
                            openDatePicker.value = true
                        }
                        .fillMaxWidth(),
                    colors = TextFieldDefaults
                        .colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            focusedLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .clickable {
                                    openDatePicker.value = true
                                }
                        )
                    }
                )
            }
        }
    }
    if(openDatePicker.value){
        DatePickerDialog(
            onDismissRequest = {
                openDatePicker.value = false
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDatePicker.value = false
                    },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                ) {
                    Text(
                        text = "Confirm",
                        color = Color.White
                    )
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        openDatePicker.value = false
                    },
                    colors = ButtonDefaults
                        .buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                ) {
                    Text(
                        text = "Cancel",
                        color = Color.Black
                    )
                }
            },
            colors = DatePickerDefaults
                .colors(
                    containerColor = Color.White
                ),
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(10.dp)
        ) {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults
                    .colors(
                        containerColor = Color.White
                    )
            )
        }
    }
}

@Preview
@Composable
fun ToDoDetailPrev() {
    ToDoDetail()
}