package exe.weazy.marvelapp.di

import dagger.Component
import exe.weazy.marvelapp.repository.MarvelRepository

@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(marvelRepository: MarvelRepository)
}