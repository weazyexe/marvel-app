package exe.weazy.marvelapp.db;

import android.database.Cursor;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.sqlite.db.SupportSQLiteStatement;
import exe.weazy.marvelapp.model.Character;
import exe.weazy.marvelapp.model.Thumbnail;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unchecked")
public final class CharactersDao_Impl implements CharactersDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCharacter;

  private final ThumbnailConverter __thumbnailConverter = new ThumbnailConverter();

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCharacter;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfCharacter;

  private final SharedSQLiteStatement __preparedStmtOfNukeTable;

  public CharactersDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCharacter = new EntityInsertionAdapter<Character>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Character`(`id`,`name`,`description`,`image`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Character value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final String _tmp;
        _tmp = __thumbnailConverter.thumbnailToString(value.getImage());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
      }
    };
    this.__deletionAdapterOfCharacter = new EntityDeletionOrUpdateAdapter<Character>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Character` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Character value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCharacter = new EntityDeletionOrUpdateAdapter<Character>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Character` SET `id` = ?,`name` = ?,`description` = ?,`image` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Character value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final String _tmp;
        _tmp = __thumbnailConverter.thumbnailToString(value.getImage());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfNukeTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM character";
        return _query;
      }
    };
  }

  @Override
  public void insert(@NotNull Character character) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCharacter.insert(character);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(@NotNull Character character) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCharacter.handle(character);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(@NotNull Character character) {
    __db.beginTransaction();
    try {
      __updateAdapterOfCharacter.handle(character);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void nukeTable() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfNukeTable.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfNukeTable.release(_stmt);
    }
  }

  @Override
  public DataSource.Factory<Integer, Character> getAll() {
    final String _sql = "SELECT * FROM character ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, Character>() {
      @Override
      public LimitOffsetDataSource<Character> create() {
        return new LimitOffsetDataSource<Character>(__db, _statement, false , "character") {
          @Override
          protected List<Character> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = cursor.getColumnIndexOrThrow("id");
            final int _cursorIndexOfName = cursor.getColumnIndexOrThrow("name");
            final int _cursorIndexOfDescription = cursor.getColumnIndexOrThrow("description");
            final int _cursorIndexOfImage = cursor.getColumnIndexOrThrow("image");
            final List<Character> _res = new ArrayList<Character>(cursor.getCount());
            while(cursor.moveToNext()) {
              final Character _item;
              final int _tmpId;
              _tmpId = cursor.getInt(_cursorIndexOfId);
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              final Thumbnail _tmpImage;
              final String _tmp;
              _tmp = cursor.getString(_cursorIndexOfImage);
              _tmpImage = __thumbnailConverter.stringToThumbnail(_tmp);
              _item = new Character(_tmpId,_tmpName,_tmpDescription,_tmpImage);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public Character getById(int id) {
    final String _sql = "SELECT * FROM character WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final Character _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final Thumbnail _tmpImage;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfImage);
        _tmpImage = __thumbnailConverter.stringToThumbnail(_tmp);
        _result = new Character(_tmpId,_tmpName,_tmpDescription,_tmpImage);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DataSource.Factory<Integer, Character> getByLimitAndOffset(int offset, int limit) {
    final String _sql = "SELECT * FROM character ORDER BY name ASC LIMIT ? OFFSET ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    _argIndex = 2;
    _statement.bindLong(_argIndex, offset);
    return new DataSource.Factory<Integer, Character>() {
      @Override
      public LimitOffsetDataSource<Character> create() {
        return new LimitOffsetDataSource<Character>(__db, _statement, false , "character") {
          @Override
          protected List<Character> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = cursor.getColumnIndexOrThrow("id");
            final int _cursorIndexOfName = cursor.getColumnIndexOrThrow("name");
            final int _cursorIndexOfDescription = cursor.getColumnIndexOrThrow("description");
            final int _cursorIndexOfImage = cursor.getColumnIndexOrThrow("image");
            final List<Character> _res = new ArrayList<Character>(cursor.getCount());
            while(cursor.moveToNext()) {
              final Character _item;
              final int _tmpId;
              _tmpId = cursor.getInt(_cursorIndexOfId);
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              final Thumbnail _tmpImage;
              final String _tmp;
              _tmp = cursor.getString(_cursorIndexOfImage);
              _tmpImage = __thumbnailConverter.stringToThumbnail(_tmp);
              _item = new Character(_tmpId,_tmpName,_tmpDescription,_tmpImage);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }
}