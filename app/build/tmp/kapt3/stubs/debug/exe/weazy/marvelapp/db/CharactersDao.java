package exe.weazy.marvelapp.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\bH\'J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0010"}, d2 = {"Lexe/weazy/marvelapp/db/CharactersDao;", "", "delete", "", "character", "Lexe/weazy/marvelapp/entity/Character;", "getAll", "Landroidx/paging/DataSource$Factory;", "", "getById", "id", "getByLimitAndOffset", "offset", "limit", "insert", "update", "app_debug"})
public abstract interface CharactersDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM character ORDER BY name ASC")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, exe.weazy.marvelapp.entity.Character> getAll();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM character WHERE id = :id")
    public abstract exe.weazy.marvelapp.entity.Character getById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM character ORDER BY name ASC LIMIT :limit OFFSET :offset")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, exe.weazy.marvelapp.entity.Character> getByLimitAndOffset(int offset, int limit);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    exe.weazy.marvelapp.entity.Character character);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    exe.weazy.marvelapp.entity.Character character);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    exe.weazy.marvelapp.entity.Character character);
}