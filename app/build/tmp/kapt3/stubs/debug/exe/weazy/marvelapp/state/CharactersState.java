package exe.weazy.marvelapp.state;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lexe/weazy/marvelapp/state/CharactersState;", "", "Error", "Loaded", "Loading", "app_debug"})
public abstract interface CharactersState {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lexe/weazy/marvelapp/state/CharactersState$Loading;", "Lexe/weazy/marvelapp/state/CharactersState;", "()V", "app_debug"})
    public static final class Loading implements exe.weazy.marvelapp.state.CharactersState {
        
        public Loading() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lexe/weazy/marvelapp/state/CharactersState$Error;", "Lexe/weazy/marvelapp/state/CharactersState;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "app_debug"})
    public static final class Error implements exe.weazy.marvelapp.state.CharactersState {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String msg = null;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getMsg() {
            return null;
        }
        
        public Error(@org.jetbrains.annotations.Nullable()
        java.lang.String msg) {
            super();
        }
        
        public Error() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lexe/weazy/marvelapp/state/CharactersState$Loaded;", "Lexe/weazy/marvelapp/state/CharactersState;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "app_debug"})
    public static final class Loaded implements exe.weazy.marvelapp.state.CharactersState {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String msg = null;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getMsg() {
            return null;
        }
        
        public Loaded(@org.jetbrains.annotations.Nullable()
        java.lang.String msg) {
            super();
        }
        
        public Loaded() {
            super();
        }
    }
}