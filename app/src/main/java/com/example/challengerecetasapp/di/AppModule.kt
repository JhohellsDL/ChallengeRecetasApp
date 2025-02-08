package com.example.challengerecetasapp.di

import androidx.room.Room
import com.example.challengerecetasapp.data.datasource.RecipeLocalDataSource
import com.example.challengerecetasapp.data.datasource.RecipeRemoteDataSource
import com.example.challengerecetasapp.data.local.DataStoreManager
import com.example.challengerecetasapp.data.local.room.AppDatabase
import com.example.challengerecetasapp.data.remote.RecipeApi
import com.example.challengerecetasapp.data.repositories_impl.OnboardingRepositoryImpl
import com.example.challengerecetasapp.domain.repositories.OnboardingRepository
import com.example.challengerecetasapp.domain.repositories.RecipeRepository
import com.example.challengerecetasapp.domain.usecases.GetFavoritesRecipesIdsUseCase
import com.example.challengerecetasapp.domain.usecases.GetFavoritesRecipesUseCase
import com.example.challengerecetasapp.domain.usecases.GetOnboardingStatusUseCase
import com.example.challengerecetasapp.domain.usecases.GetRecipesUseCase
import com.example.challengerecetasapp.domain.usecases.RemoveFavoriteRecipeUseCase
import com.example.challengerecetasapp.domain.usecases.SaveFavoriteRecipeUseCase
import com.example.challengerecetasapp.domain.usecases.SetOnboardingCompletedUseCase
import com.example.challengerecetasapp.navigation.AppNavigator
import com.example.challengerecetasapp.navigation.AppNavigatorImpl
import com.example.challengerecetasapp.ui.detail.DetailViewModel
import com.example.challengerecetasapp.ui.favorites.FavoritesViewModel
import com.example.challengerecetasapp.ui.home.HomeViewModel
import com.example.challengerecetasapp.ui.home.RecipeViewModel
import com.example.challengerecetasapp.ui.onboarding.OnboardingViewModel
import com.example.challengerecetasapp.utils.BASE_URL
import com.example.challengerecetasapp.utils.createDataStore
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataSourceModule = module {
    single<RecipeLocalDataSource> { RecipeLocalDataSource(get()) }
    single<RecipeRemoteDataSource> { RecipeRemoteDataSource(get()) }
}

val repositoryModule = module {
    single<OnboardingRepository> { OnboardingRepositoryImpl(get()) }
    single { RecipeRepository(get(), get()) }
}

val useCaseModule = module {
    factory { GetOnboardingStatusUseCase(get()) }
    factory { SetOnboardingCompletedUseCase(get()) }
    factory { GetRecipesUseCase(get()) }
    factory { GetFavoritesRecipesUseCase(get()) }
    factory { GetFavoritesRecipesIdsUseCase(get()) }
    factory { RemoveFavoriteRecipeUseCase(get()) }
    factory { SaveFavoriteRecipeUseCase(get()) }
}

val dataStoreModule = module {
    single { DataStoreManager(get()) }
    single { createDataStore(get()) }
}

val viewModelModule = module {
    viewModelOf(::OnboardingViewModel)
    viewModelOf(::RecipeViewModel)
    viewModelOf(::FavoritesViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
}

val navigationModule = module {
    single<AppNavigator> { AppNavigatorImpl() }
}

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(RecipeApi::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single { get<AppDatabase>().favoriteRecipeDao() }
}

val appModule =
    listOf(
        viewModelModule,
        navigationModule,
        dataStoreModule,
        useCaseModule,
        repositoryModule,
        networkModule,
        databaseModule,
        dataSourceModule
    )