package exe.weazy.marvelapp.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lexe/weazy/marvelapp/adapter/CharactersAdapter;", "Landroidx/paging/PagedListAdapter;", "Lexe/weazy/marvelapp/model/Character;", "Lexe/weazy/marvelapp/adapter/CharactersAdapter$Holder;", "diffUtilItemCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_debug"})
public final class CharactersAdapter extends androidx.paging.PagedListAdapter<exe.weazy.marvelapp.model.Character, exe.weazy.marvelapp.adapter.CharactersAdapter.Holder> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public exe.weazy.marvelapp.adapter.CharactersAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    exe.weazy.marvelapp.adapter.CharactersAdapter.Holder holder, int position) {
    }
    
    public CharactersAdapter(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.DiffUtil.ItemCallback<exe.weazy.marvelapp.model.Character> diffUtilItemCallback) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lexe/weazy/marvelapp/adapter/CharactersAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lexe/weazy/marvelapp/adapter/CharactersAdapter;Landroid/view/View;)V", "characterImageView", "Landroid/widget/ImageView;", "characterLayout", "Landroid/widget/FrameLayout;", "descriptionTextView", "Landroid/widget/TextView;", "nameTextView", "bind", "", "character", "Lexe/weazy/marvelapp/model/Character;", "app_debug"})
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.TextView nameTextView;
        private android.widget.TextView descriptionTextView;
        private android.widget.ImageView characterImageView;
        private android.widget.FrameLayout characterLayout;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        exe.weazy.marvelapp.model.Character character) {
        }
        
        public Holder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}