package id.osg3_20.bikewiseapp.data.local;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import id.osg3_20.bikewiseapp.model.IncidentDetail;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class IncidentDao_Impl implements IncidentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfIncidentDetail;

  public IncidentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncidentDetail = new EntityInsertionAdapter<IncidentDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `incidents`(`mId`,`title`,`description`,`address`,`occurred_at`,`updated_at`,`image_url`,`media`,`type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IncidentDetail value) {
        stmt.bindLong(1, value.mId);
        if (value.title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.description);
        }
        if (value.address == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.address);
        }
        if (value.occurred_at == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.occurred_at);
        }
        if (value.updated_at == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.updated_at);
        }
        if (value.image_url == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.image_url);
        }
        if (value.type == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.type);
        }
      }
    };
  }

  @Override
  public void insertIncident(List<IncidentDetail> incidents) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfIncidentDetail.insert(incidents);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<IncidentDetail> getIncident() {
    final String _sql = "SELECT * FROM incidents";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("mId");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("address");
      final int _cursorIndexOfOccurredAt = _cursor.getColumnIndexOrThrow("occurred_at");
      final int _cursorIndexOfUpdatedAt = _cursor.getColumnIndexOrThrow("updated_at");
      final int _cursorIndexOfImageUrl = _cursor.getColumnIndexOrThrow("image_url");
      final int _cursorIndexOfMedia = _cursor.getColumnIndexOrThrow("media");
      final int _cursorIndexOfType = _cursor.getColumnIndexOrThrow("type");
      final List<IncidentDetail> _result = new ArrayList<IncidentDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IncidentDetail _item;
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        final String _tmpOccurred_at;
        _tmpOccurred_at = _cursor.getString(_cursorIndexOfOccurredAt);
        final String _tmpUpdated_at;
        _tmpUpdated_at = _cursor.getString(_cursorIndexOfUpdatedAt);
        final String _tmpImage_url;
        _tmpImage_url = _cursor.getString(_cursorIndexOfImageUrl);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        _item = new IncidentDetail(_tmpMId,_tmpTitle,_tmpDescription,_tmpAddress,_tmpOccurred_at,_tmpUpdated_at,_tmpImage_url,_tmpType);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
