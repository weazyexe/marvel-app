package exe.weazy.marvelapp.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH\'\u00a8\u0006\f"}, d2 = {"Lexe/weazy/marvelapp/network/NetworkService;", "", "fetchHeroes", "Lio/reactivex/Observable;", "Lexe/weazy/marvelapp/network/HeroesResponse;", "apiKey", "", "timestamp", "", "hash", "offset", "", "app_debug"})
public abstract interface NetworkService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "characters")
    public abstract io.reactivex.Observable<exe.weazy.marvelapp.network.HeroesResponse> fetchHeroes(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apikey")
    java.lang.String apiKey, @retrofit2.http.Query(value = "ts")
    long timestamp, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "hash")
    java.lang.String hash, @retrofit2.http.Query(value = "offset")
    int offset);
}