package exe.weazy.marvelapp.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unchecked")
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CharactersDao _charactersDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Character` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `image` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"2fe9c070f22f0e70b3d85cef8e0883e2\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Character`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCharacter = new HashMap<String, TableInfo.Column>(4);
        _columnsCharacter.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCharacter.put("name", new TableInfo.Column("name", "TEXT", true, 0));
        _columnsCharacter.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        _columnsCharacter.put("image", new TableInfo.Column("image", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCharacter = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCharacter = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCharacter = new TableInfo("Character", _columnsCharacter, _foreignKeysCharacter, _indicesCharacter);
        final TableInfo _existingCharacter = TableInfo.read(_db, "Character");
        if (! _infoCharacter.equals(_existingCharacter)) {
          throw new IllegalStateException("Migration didn't properly handle Character(exe.weazy.marvelapp.model.Character).\n"
                  + " Expected:\n" + _infoCharacter + "\n"
                  + " Found:\n" + _existingCharacter);
        }
      }
    }, "2fe9c070f22f0e70b3d85cef8e0883e2", "7473908a6a51922e6fd425ad47d0c55a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Character");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Character`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NotNull
  public CharactersDao charactersDao() {
    if (_charactersDao != null) {
      return _charactersDao;
    } else {
      synchronized(this) {
        if(_charactersDao == null) {
          _charactersDao = new CharactersDao_Impl(this);
        }
        return _charactersDao;
      }
    }
  }
}
