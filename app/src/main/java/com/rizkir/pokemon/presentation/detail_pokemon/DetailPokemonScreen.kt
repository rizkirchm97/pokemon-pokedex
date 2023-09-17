package com.rizkir.pokemon.presentation.detail_pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.rizkir.pokemon.common.components.ApplicationAppbar
import com.rizkir.pokemon.common.components.CircularProgress
import com.rizkir.pokemon.common.components.ErrorOccurred
import com.rizkir.pokemon.domain.entities.pokemon_detail.AbilitiesItem
import com.rizkir.pokemon.domain.entities.pokemon_detail.Pokemon

@Composable
fun DetailPokemonScreen(
    uiState: UiState, onPopBack: () -> Unit
) {

    DetailPokemonScreen(
        uiState = uiState,
        onPopBack = onPopBack,
        success = { data, modifier ->
            DetailPokemonContent(data = data, modifier = modifier)
        },
        error = {
            ErrorOccurred(message = it.toString())
        }
    )

}

@Composable
fun DetailPokemonContent(
    modifier: Modifier = Modifier,
    data: Pokemon?
) {
    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current).data(data?.sprites?.frontDefault)
                .size(Size.ORIGINAL).crossfade(true).build()
        )
        Text(text = data?.name.toString(), fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Image(painter = painter, contentDescription = data?.name, modifier = Modifier.align(CenterHorizontally))
        AbilitiesItemUi(
            modifier = modifier,
            data = data
        ) {
            ListTile(it)
        }
    }
}

@Composable
fun ListTile(
    data: AbilitiesItem?
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = data?.ability?.name ?: "",
            modifier = Modifier.padding(16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AbilitiesItemUi(
    modifier: Modifier = Modifier,
    data: Pokemon?,
    hasAbilitiesList: @Composable (data: AbilitiesItem?) -> Unit
) {
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(16.dp)) {
        if (data?.abilities?.isNotEmpty() == true) {
            items(data.abilities.size) {index ->
                val item = data.abilities[index]
                hasAbilitiesList(item)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPokemonScreen(
    uiState: UiState,
    onPopBack: () -> Unit,
    success: @Composable (data: Pokemon?, modifier: Modifier) -> Unit,
    error: @Composable (message: String?) -> Unit
) {
    Scaffold(
        topBar = {
            ApplicationAppbar(
                title = "Pokemon Info",
                onClickBack = onPopBack
            )
        }
    ) {
        val padding = Modifier.padding(it)
        LoadingComponent(
            uiState = uiState,
            loadingContent = {
                CircularProgress()
            }) {
            when (uiState) {
                is UiState.Success -> {
                    success(uiState.data, padding)
                }

                is UiState.Error -> {
                    error(uiState.message)
                }

                else -> Unit
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