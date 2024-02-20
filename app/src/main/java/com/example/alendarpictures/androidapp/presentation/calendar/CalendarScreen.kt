package com.example.alendarpictures.androidapp.presentation.calendar

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.alendarpictures.R
import com.example.alendarpictures.androidapp.presentation.common.component.DropdownMenuItems
import com.example.alendarpictures.androidapp.presentation.common.dialog.ProgressBarDialog
import com.example.alendarpictures.ui.theme.СalendarPicturesTheme
import com.example.alendarpictures.util.Screen
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CalendarScreen(
    navController: NavController,
    viewModel: CalendarViewModel = hiltViewModel(),
    state: CalendarState = viewModel.state.collectAsStateWithLifecycle().value,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val options = listOf("All", "Selected", "Births", "Deaths", "Holidays", "Events")
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var type by remember {
        mutableStateOf(" ")
    }
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MM yyyy")
                .format(pickedDate)
        }
    }

    ProgressBarDialog(
        onDismissRequest = { viewModel.closeDialog() },
        isShow = state.isShow
    )
    СalendarPicturesTheme {
        Scaffold {
            val dateDialogState = rememberMaterialDialogState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                        })
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TopAppBar(
                    title = { Text(text = "Calendar picture") },
                    actions = {
                        IconButton(onClick = { navController.navigate(Screen.LanguageScreen.route) }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = null
                            )

                        }
                    }
                )

                Button(onClick = { dateDialogState.show() }) {
                    Text(text = "Pick date")
                }
                Text(text = formattedDate)
                Spacer(modifier = Modifier.height(16.dp))
                MaterialDialog(
                    dialogState = dateDialogState,
                    buttons = {
                        positiveButton(text = "Ok")
                        negativeButton(text = "Cancel")
                    }
                ) {
                    datepicker(
                        initialDate = LocalDate.now(),
                        waitForPositiveButton = true,
                    ) {
                        pickedDate = it
                        viewModel.setDate(pickedDate)
                    }
                }
                ExposedDropdownMenuBox(
                    expanded = isExpanded,
                    onExpandedChange = { isExpanded = !isExpanded },
                ) {
                    TextField(
                        modifier = Modifier.menuAnchor(),
                        readOnly = true,
                        value = type,
                        onValueChange = {},
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
                    )
                    ExposedDropdownMenu(
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded = false },
                    ) {
                        DropdownMenuItems(
                            name = stringResource(R.string.all),
                            onClick = {
                                type = "all"
                                isExpanded = false
                                viewModel.openDialog(type)
                            })
                        DropdownMenuItems(
                            name = stringResource(R.string.selected),
                            onClick = {
                                type = "selected"
                                isExpanded = false
                                viewModel.openDialog(type)
                            })
                        DropdownMenuItems(name = stringResource(R.string.births),
                            onClick = {
                                type = "births"
                                isExpanded = false
                                viewModel.openDialog(type)
                            })
                        DropdownMenuItems(name = stringResource(R.string.deaths),
                            onClick = {
                                type = "deaths"
                                isExpanded = false
                                viewModel.openDialog(type)
                            })
                        DropdownMenuItems(name = stringResource(R.string.holidays),
                            onClick = {
                                type = "holidays"
                                isExpanded = false
                                viewModel.openDialog(type)
                            })
                        DropdownMenuItems(name = stringResource(R.string.events),
                            onClick = {
                                type = "events"
                                isExpanded = false
                                viewModel.openDialog(type)
                            })
                    }
                }

                TextButton(onClick = {
                    navController.navigate(Screen.PictureScreen.route)
                }) {
                    Text(text = "Get Picture")
                }
            }

        }
    }
}
