package exe.weazy.marvelapp.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\f\u001a\u00020\rH\u0007RE\u0010\u0003\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lexe/weazy/marvelapp/viewmodel/CharactersViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "characters", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lexe/weazy/marvelapp/entity/Character;", "kotlin.jvm.PlatformType", "getCharacters", "()Landroidx/lifecycle/LiveData;", "characters$delegate", "Lkotlin/Lazy;", "page", "", "repository", "Lexe/weazy/marvelapp/repository/MarvelRepository;", "loadCharacters", "Lexe/weazy/marvelapp/state/CharactersState;", "app_debug"})
public final class CharactersViewModel extends androidx.lifecycle.ViewModel {
    private int page;
    private final exe.weazy.marvelapp.repository.MarvelRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy characters$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagedList<exe.weazy.marvelapp.entity.Character>> getCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final androidx.lifecycle.LiveData<exe.weazy.marvelapp.state.CharactersState> loadCharacters(int page) {
        return null;
    }
    
    public CharactersViewModel() {
        super();
    }
}