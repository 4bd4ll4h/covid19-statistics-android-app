package com.abd4ll4h.covid19hope;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class dao_Impl implements dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Status> __insertionAdapterOfStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSummary;

  public dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStatus = new EntityInsertionAdapter<Status>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Status` (`NewConfirmed`,`TotalConfirmed`,`NewDeaths`,`TotalDeaths`,`NewRecovered`,`TotalRecovered`,`Date`,`country`,`Slug`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Status value) {
        stmt.bindLong(1, value.getNewConfirmed());
        stmt.bindLong(2, value.getTotalConfirmed());
        stmt.bindLong(3, value.getNewDeaths());
        stmt.bindLong(4, value.getTotalDeaths());
        stmt.bindLong(5, value.getNewRecovered());
        stmt.bindLong(6, value.getTotalRecovered());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCountry());
        }
        if (value.getSlug() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSlug());
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteSummary = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE  FROM status ";
        return _query;
      }
    };
  }

  @Override
  public void setSummary(final List<Status> countries) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStatus.insert(countries);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSummary() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSummary.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSummary.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Status>> getSummary(final String[] ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM status WHERE id IN (");
    final int _inputSize = ids.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : ids) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"status"}, false, new Callable<List<Status>>() {
      @Override
      public List<Status> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNewConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "NewConfirmed");
          final int _cursorIndexOfTotalConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalConfirmed");
          final int _cursorIndexOfNewDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "NewDeaths");
          final int _cursorIndexOfTotalDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalDeaths");
          final int _cursorIndexOfNewRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "NewRecovered");
          final int _cursorIndexOfTotalRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalRecovered");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Date");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "Slug");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Status> _result = new ArrayList<Status>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Status _item_1;
            _item_1 = new Status();
            final long _tmpNewConfirmed;
            _tmpNewConfirmed = _cursor.getLong(_cursorIndexOfNewConfirmed);
            _item_1.setNewConfirmed(_tmpNewConfirmed);
            final long _tmpTotalConfirmed;
            _tmpTotalConfirmed = _cursor.getLong(_cursorIndexOfTotalConfirmed);
            _item_1.setTotalConfirmed(_tmpTotalConfirmed);
            final long _tmpNewDeaths;
            _tmpNewDeaths = _cursor.getLong(_cursorIndexOfNewDeaths);
            _item_1.setNewDeaths(_tmpNewDeaths);
            final long _tmpTotalDeaths;
            _tmpTotalDeaths = _cursor.getLong(_cursorIndexOfTotalDeaths);
            _item_1.setTotalDeaths(_tmpTotalDeaths);
            final long _tmpNewRecovered;
            _tmpNewRecovered = _cursor.getLong(_cursorIndexOfNewRecovered);
            _item_1.setNewRecovered(_tmpNewRecovered);
            final long _tmpTotalRecovered;
            _tmpTotalRecovered = _cursor.getLong(_cursorIndexOfTotalRecovered);
            _item_1.setTotalRecovered(_tmpTotalRecovered);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item_1.setDate(_tmpDate);
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            _item_1.setCountry(_tmpCountry);
            final String _tmpSlug;
            _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
            _item_1.setSlug(_tmpSlug);
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item_1.setId(_tmpId);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Status getDashbord(final String id) {
    final String _sql = "SELECT * FROM status WHERE id LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNewConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "NewConfirmed");
      final int _cursorIndexOfTotalConfirmed = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalConfirmed");
      final int _cursorIndexOfNewDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "NewDeaths");
      final int _cursorIndexOfTotalDeaths = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalDeaths");
      final int _cursorIndexOfNewRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "NewRecovered");
      final int _cursorIndexOfTotalRecovered = CursorUtil.getColumnIndexOrThrow(_cursor, "TotalRecovered");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Date");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "Slug");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final Status _result;
      if(_cursor.moveToFirst()) {
        _result = new Status();
        final long _tmpNewConfirmed;
        _tmpNewConfirmed = _cursor.getLong(_cursorIndexOfNewConfirmed);
        _result.setNewConfirmed(_tmpNewConfirmed);
        final long _tmpTotalConfirmed;
        _tmpTotalConfirmed = _cursor.getLong(_cursorIndexOfTotalConfirmed);
        _result.setTotalConfirmed(_tmpTotalConfirmed);
        final long _tmpNewDeaths;
        _tmpNewDeaths = _cursor.getLong(_cursorIndexOfNewDeaths);
        _result.setNewDeaths(_tmpNewDeaths);
        final long _tmpTotalDeaths;
        _tmpTotalDeaths = _cursor.getLong(_cursorIndexOfTotalDeaths);
        _result.setTotalDeaths(_tmpTotalDeaths);
        final long _tmpNewRecovered;
        _tmpNewRecovered = _cursor.getLong(_cursorIndexOfNewRecovered);
        _result.setNewRecovered(_tmpNewRecovered);
        final long _tmpTotalRecovered;
        _tmpTotalRecovered = _cursor.getLong(_cursorIndexOfTotalRecovered);
        _result.setTotalRecovered(_tmpTotalRecovered);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _result.setDate(_tmpDate);
        final String _tmpCountry;
        _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        _result.setCountry(_tmpCountry);
        final String _tmpSlug;
        _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
        _result.setSlug(_tmpSlug);
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
