package exe.weazy.marvelapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Named("publicApiKey")
    fun providePublicApiKey() = "872806c25a20775fc12224ef216fb8de"

    @Provides
    @Named("privateApiKey")
    fun providePrivateApiKey() = "fe262e15bfccbbc293340975020637a426b37133"
}