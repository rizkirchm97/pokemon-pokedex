package com.rizkir.pokemon.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rizkir.pokemon.R
import com.rizkir.pokemon.common.components.CircularProgress
import com.rizkir.pokemon.common.components.ErrorOccurred
import com.rizkir.pokemon.domain.entities.pokemon_list.PokemonList
import com.rizkir.pokemon.domain.entities.pokemon_list.ResultsItem

@Composable
fun HomeScreen(
    uiState: UiState,
    onItemClick: (String) -> Unit,
    onSearch: (String) -> Unit
) {

    HomeScreen(uiState = uiState, onSearch = onSearch) { resultItem ->
        ListTile(
            data = resultItem,
            onItemClick = onItemClick
        )
    }


}

@Composable
fun ListTile(
    data: ResultsItem?,
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable {
                onItemClick(data?.name ?: "")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = data?.name ?: "",
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: UiState,
    onSearch: (String) -> Unit,
    hasPokemonList: @Composable (data: ResultsItem?) -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val padding = Modifier.padding(it)
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) { valueToSearch ->
                onSearch(valueToSearch)
            }
            Spacer(modifier = Modifier.padding(16.dp))
            LoadingComponent(uiState = uiState, loadingContent = { CircularProgress() }) {
                when (uiState) {
                    is UiState.Success -> {
                        PokemonUiList(uiState.data) { resultItem ->
                            hasPokemonList(resultItem)
                        }
                    }

                    is UiState.Error -> {
                        uiState.message?.let { message ->
                            ErrorOccurred(
                                message = message
                            )
                        }
                    }

                    else -> Unit
                }
            }
        }
    }
}

@Composable
fun LoadingComponent(
    uiState: UiState,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    if (uiState is UiState.Loading) loadingContent()
    else content()
}

@Composable
fun PokemonUiList(
    data: PokemonList?,
    dataItem: @Composable (ResultsItem?) -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        if (data?.results?.isNotEmpty() == true) {
            items(data.results.size) { index ->
                val item = data.results[index]
                dataItem(item)
            }
        }

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.hasFocus
                }
        )

        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp,
                        vertical = 12.dp
                    )
            )
        }
    }

}