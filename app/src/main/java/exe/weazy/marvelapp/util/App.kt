package exe.weazy.marvelapp.util

import android.app.Application
import exe.weazy.marvelapp.di.*


class App : Application() {

    companion object {
        private lateinit var component : AppComponent

        fun getComponent() = component
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .databaseModule(DatabaseModule(applicationContext))
            .build()
    }
}