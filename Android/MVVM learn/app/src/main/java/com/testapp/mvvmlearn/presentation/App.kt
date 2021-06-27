package com.testapp.mvvmlearn.presentation

import android.app.Application
import com.testapp.mvvmlearn.BuildConfig
import com.testapp.mvvmlearn.presentation.di.Injector
import com.testapp.mvvmlearn.presentation.di.artist.ArtistSubcomponent
import com.testapp.mvvmlearn.presentation.di.core.AppComponent
import com.testapp.mvvmlearn.presentation.di.core.AppModule
import com.testapp.mvvmlearn.presentation.di.core.DaggerAppComponent
import com.testapp.mvvmlearn.presentation.di.core.NetworkModule
import com.testapp.mvvmlearn.presentation.di.core.datamodule.RemoteDataModule
import com.testapp.mvvmlearn.presentation.di.movie.MovieSubcomponent
import com.testapp.mvvmlearn.presentation.di.tvshow.TvShowSubcomponent

class App : Application() , Injector {
    private lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEYS))
            .build()
    }


    override fun createMovieSubcomponent(): MovieSubcomponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createTvShowsSubcomponent(): TvShowSubcomponent {
        return appComponent.tvShowSubcomponent().create()
    }

    override fun creteArtistSubcomponent(): ArtistSubcomponent {
        return appComponent.artistSubcomponent().create()
    }
}