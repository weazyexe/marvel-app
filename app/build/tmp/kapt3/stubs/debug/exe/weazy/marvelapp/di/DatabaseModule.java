package exe.weazy.marvelapp.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lexe/weazy/marvelapp/di/DatabaseModule;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "provideDatabase", "Lexe/weazy/marvelapp/db/AppDatabase;", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final exe.weazy.marvelapp.db.AppDatabase provideDatabase() {
        return null;
    }
    
    public DatabaseModule(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}