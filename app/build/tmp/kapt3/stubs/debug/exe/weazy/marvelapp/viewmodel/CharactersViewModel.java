package exe.weazy.marvelapp.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0006\u0010\u001b\u001a\u00020\u001aRE\u0010\u0003\u001a,\u0012(\u0012&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lexe/weazy/marvelapp/viewmodel/CharactersViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "characters", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lexe/weazy/marvelapp/model/Character;", "kotlin.jvm.PlatformType", "getCharacters", "()Landroidx/lifecycle/LiveData;", "characters$delegate", "Lkotlin/Lazy;", "page", "", "getPage", "()I", "setPage", "(I)V", "repository", "Lexe/weazy/marvelapp/repository/MarvelRepository;", "state", "Landroidx/lifecycle/MutableLiveData;", "Lexe/weazy/marvelapp/state/CharactersState;", "getState", "()Landroidx/lifecycle/MutableLiveData;", "loadCharacters", "", "refresh", "app_debug"})
public final class CharactersViewModel extends androidx.lifecycle.ViewModel {
    private int page;
    private final exe.weazy.marvelapp.repository.MarvelRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<exe.weazy.marvelapp.state.CharactersState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy characters$delegate = null;
    
    public final int getPage() {
        return 0;
    }
    
    public final void setPage(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<exe.weazy.marvelapp.state.CharactersState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagedList<exe.weazy.marvelapp.model.Character>> getCharacters() {
        return null;
    }
    
    public final void refresh() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final void loadCharacters(int page) {
    }
    
    public CharactersViewModel() {
        super();
    }
}