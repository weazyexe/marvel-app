package exe.weazy.marvelapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0$J\u0014\u0010%\u001a\u00020&2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lexe/weazy/marvelapp/repository/MarvelRepository;", "", "()V", "dao", "Lexe/weazy/marvelapp/db/CharactersDao;", "database", "Lexe/weazy/marvelapp/db/AppDatabase;", "getDatabase", "()Lexe/weazy/marvelapp/db/AppDatabase;", "setDatabase", "(Lexe/weazy/marvelapp/db/AppDatabase;)V", "privateApiKey", "", "getPrivateApiKey", "()Ljava/lang/String;", "setPrivateApiKey", "(Ljava/lang/String;)V", "publicApiKey", "getPublicApiKey", "setPublicApiKey", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "service", "Lexe/weazy/marvelapp/network/NetworkService;", "fetchCharactersFromNetwork", "Lio/reactivex/Observable;", "", "Lexe/weazy/marvelapp/entity/Character;", "offset", "", "limit", "getCacheDataSource", "Landroidx/paging/DataSource$Factory;", "writeCharactersToCache", "", "characters", "app_debug"})
public final class MarvelRepository {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "publicApiKey")
    @javax.inject.Inject()
    public java.lang.String publicApiKey;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "privateApiKey")
    @javax.inject.Inject()
    public java.lang.String privateApiKey;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public exe.weazy.marvelapp.db.AppDatabase database;
    private final exe.weazy.marvelapp.db.CharactersDao dao = null;
    private exe.weazy.marvelapp.network.NetworkService service;
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final void setRetrofit(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPublicApiKey() {
        return null;
    }
    
    public final void setPublicApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrivateApiKey() {
        return null;
    }
    
    public final void setPrivateApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final exe.weazy.marvelapp.db.AppDatabase getDatabase() {
        return null;
    }
    
    public final void setDatabase(@org.jetbrains.annotations.NotNull()
    exe.weazy.marvelapp.db.AppDatabase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<java.util.List<exe.weazy.marvelapp.entity.Character>> fetchCharactersFromNetwork(int offset, int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.paging.DataSource.Factory<java.lang.Integer, exe.weazy.marvelapp.entity.Character> getCacheDataSource() {
        return null;
    }
    
    public final void writeCharactersToCache(@org.jetbrains.annotations.NotNull()
    java.util.List<exe.weazy.marvelapp.entity.Character> characters) {
    }
    
    public MarvelRepository() {
        super();
    }
}