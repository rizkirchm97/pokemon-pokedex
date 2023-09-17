package com.rizkir.pokemon.di

import android.app.Application
import androidx.room.Room
import com.rizkir.pokemon.common.util.Constants
import com.rizkir.pokemon.data.local.PokemonDao
import com.rizkir.pokemon.data.local.PokemonDatabase
import com.rizkir.pokemon.data.remote.PokemonApi
import com.rizkir.pokemon.data.repositories.PokemonRepositoryImpl
import com.rizkir.pokemon.domain.repositories.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Api
    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokemonApi::class.java)
    }

    // Local Cache
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): PokemonDatabase {
        return Room.databaseBuilder(
            app,
            PokemonDatabase::class.java,
            PokemonDatabase.DATABASE_NAME
        ).build()
    }

    // Repo
    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonApi,
        db: PokemonDatabase
    ): PokemonRepository = PokemonRepositoryImpl(api, db.pokemonDao)
}