package id.osg3_20.bikewiseapp.data.local;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class IncidentDataBase_Impl extends IncidentDataBase {
  private volatile IncidentDao _incidentDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `incidents` (`mId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `description` TEXT, `address` TEXT, `occurred_at` TEXT, `updated_at` TEXT, `image_url` TEXT, `media` TEXT, `type` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"1bc91cd0ab6df49a600d912993545027\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `incidents`");
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
        final HashMap<String, TableInfo.Column> _columnsIncidents = new HashMap<String, TableInfo.Column>(9);
        _columnsIncidents.put("mId", new TableInfo.Column("mId", "INTEGER", true, 1));
        _columnsIncidents.put("title", new TableInfo.Column("title", "TEXT", false, 0));
        _columnsIncidents.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsIncidents.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        _columnsIncidents.put("occurred_at", new TableInfo.Column("occurred_at", "TEXT", false, 0));
        _columnsIncidents.put("updated_at", new TableInfo.Column("updated_at", "TEXT", false, 0));
        _columnsIncidents.put("image_url", new TableInfo.Column("image_url", "TEXT", false, 0));
        _columnsIncidents.put("media", new TableInfo.Column("media", "TEXT", false, 0));
        _columnsIncidents.put("type", new TableInfo.Column("type", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIncidents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIncidents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIncidents = new TableInfo("incidents", _columnsIncidents, _foreignKeysIncidents, _indicesIncidents);
        final TableInfo _existingIncidents = TableInfo.read(_db, "incidents");
        if (! _infoIncidents.equals(_existingIncidents)) {
          throw new IllegalStateException("Migration didn't properly handle incidents(id.osg3_20.bikewiseapp.model.IncidentDetail).\n"
                  + " Expected:\n" + _infoIncidents + "\n"
                  + " Found:\n" + _existingIncidents);
        }
      }
    }, "1bc91cd0ab6df49a600d912993545027", "9fa48641d2dd7a6eacf2f6757017b3d7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "incidents");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `incidents`");
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
  public IncidentDao incidentDao() {
    if (_incidentDao != null) {
      return _incidentDao;
    } else {
      synchronized(this) {
        if(_incidentDao == null) {
          _incidentDao = new IncidentDao_Impl(this);
        }
        return _incidentDao;
      }
    }
  }
}
