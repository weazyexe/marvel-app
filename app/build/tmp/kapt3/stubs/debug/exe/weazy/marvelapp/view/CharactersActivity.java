package exe.weazy.marvelapp.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lexe/weazy/marvelapp/view/CharactersActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/paginate/Paginate$Callbacks;", "()V", "adapter", "Lexe/weazy/marvelapp/adapter/CharactersAdapter;", "hasLoadedAllItems", "", "isLoading", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "viewModel", "Lexe/weazy/marvelapp/viewmodel/CharactersViewModel;", "initAdapter", "", "initViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onLoadMore", "setState", "state", "Lexe/weazy/marvelapp/state/CharactersState;", "showSnackbar", "msg", "", "app_debug"})
public final class CharactersActivity extends androidx.appcompat.app.AppCompatActivity implements com.paginate.Paginate.Callbacks {
    private exe.weazy.marvelapp.viewmodel.CharactersViewModel viewModel;
    private exe.weazy.marvelapp.adapter.CharactersAdapter adapter;
    private androidx.recyclerview.widget.LinearLayoutManager layoutManager;
    private boolean isLoading;
    private boolean hasLoadedAllItems;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onLoadMore() {
    }
    
    @java.lang.Override()
    public boolean isLoading() {
        return false;
    }
    
    @java.lang.Override()
    public boolean hasLoadedAllItems() {
        return false;
    }
    
    private final void setState(exe.weazy.marvelapp.state.CharactersState state) {
    }
    
    private final void showSnackbar(java.lang.String msg) {
    }
    
    private final void initViewModel() {
    }
    
    private final void initAdapter() {
    }
    
    public CharactersActivity() {
        super();
    }
}