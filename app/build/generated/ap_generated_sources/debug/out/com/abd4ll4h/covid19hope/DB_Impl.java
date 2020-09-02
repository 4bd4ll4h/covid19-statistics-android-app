package com.abd4ll4h.covid19hope;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DB_Impl extends DB {
  private volatile dao _dao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Status` (`NewConfirmed` INTEGER NOT NULL, `TotalConfirmed` INTEGER NOT NULL, `NewDeaths` INTEGER NOT NULL, `TotalDeaths` INTEGER NOT NULL, `NewRecovered` INTEGER NOT NULL, `TotalRecovered` INTEGER NOT NULL, `Date` TEXT, `country` TEXT, `Slug` TEXT, `id` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Global` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `NewConfirmed` INTEGER NOT NULL, `TotalConfirmed` INTEGER NOT NULL, `NewDeaths` INTEGER NOT NULL, `TotalDeaths` INTEGER NOT NULL, `NewRecovered` INTEGER NOT NULL, `TotalRecovered` INTEGER NOT NULL, `date` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'eb8b8427e5cb656b7b778f4c12907ab7')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Status`");
        _db.execSQL("DROP TABLE IF EXISTS `Global`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsStatus = new HashMap<String, TableInfo.Column>(10);
        _columnsStatus.put("NewConfirmed", new TableInfo.Column("NewConfirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("TotalConfirmed", new TableInfo.Column("TotalConfirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("NewDeaths", new TableInfo.Column("NewDeaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("TotalDeaths", new TableInfo.Column("TotalDeaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("NewRecovered", new TableInfo.Column("NewRecovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("TotalRecovered", new TableInfo.Column("TotalRecovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("Date", new TableInfo.Column("Date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("Slug", new TableInfo.Column("Slug", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStatus.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStatus = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStatus = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStatus = new TableInfo("Status", _columnsStatus, _foreignKeysStatus, _indicesStatus);
        final TableInfo _existingStatus = TableInfo.read(_db, "Status");
        if (! _infoStatus.equals(_existingStatus)) {
          return new RoomOpenHelper.ValidationResult(false, "Status(com.abd4ll4h.covid19hope.Status).\n"
                  + " Expected:\n" + _infoStatus + "\n"
                  + " Found:\n" + _existingStatus);
        }
        final HashMap<String, TableInfo.Column> _columnsGlobal = new HashMap<String, TableInfo.Column>(8);
        _columnsGlobal.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("NewConfirmed", new TableInfo.Column("NewConfirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("TotalConfirmed", new TableInfo.Column("TotalConfirmed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("NewDeaths", new TableInfo.Column("NewDeaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("TotalDeaths", new TableInfo.Column("TotalDeaths", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("NewRecovered", new TableInfo.Column("NewRecovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("TotalRecovered", new TableInfo.Column("TotalRecovered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGlobal.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGlobal = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGlobal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGlobal = new TableInfo("Global", _columnsGlobal, _foreignKeysGlobal, _indicesGlobal);
        final TableInfo _existingGlobal = TableInfo.read(_db, "Global");
        if (! _infoGlobal.equals(_existingGlobal)) {
          return new RoomOpenHelper.ValidationResult(false, "Global(com.abd4ll4h.covid19hope.Global).\n"
                  + " Expected:\n" + _infoGlobal + "\n"
                  + " Found:\n" + _existingGlobal);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "eb8b8427e5cb656b7b778f4c12907ab7", "3d7c257b61fb2253f0552f87ff91a87f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Status","Global");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Status`");
      _db.execSQL("DELETE FROM `Global`");
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
  public dao dao() {
    if (_dao != null) {
      return _dao;
    } else {
      synchronized(this) {
        if(_dao == null) {
          _dao = new dao_Impl(this);
        }
        return _dao;
      }
    }
  }
}
