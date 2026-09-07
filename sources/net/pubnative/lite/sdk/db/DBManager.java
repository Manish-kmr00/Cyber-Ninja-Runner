package net.pubnative.lite.sdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.prefs.HyBidPreferences;
import net.pubnative.lite.sdk.utils.HyBidTimeUtils;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes13.dex */
public class DBManager {
    private static final String TAG = "DBManager";
    private final Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        DatabaseHelper databaseHelper = new DatabaseHelper(this.context);
        this.dbHelper = databaseHelper;
        this.database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DatabaseHelper databaseHelper = this.dbHelper;
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }

    private void insert(SessionImpression sessionImpression) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", sessionImpression.getTimestamp());
        contentValues.put("age_of_app", sessionImpression.getAgeOfApp());
        contentValues.put("zone_id", sessionImpression.getZoneId());
        contentValues.put("session_duration", sessionImpression.getSessionDuration());
        this.database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    public void insert(String str) {
        SessionImpression sessionImpression = new SessionImpression();
        sessionImpression.setTimestamp(Long.valueOf(System.currentTimeMillis()));
        sessionImpression.setZoneId(str);
        sessionImpression.setSessionDuration(new HyBidTimeUtils().calculateSessionDuration(sessionImpression.getTimestamp(), getAgeOfApp()));
        manageImpressionSession(sessionImpression.getTimestamp());
        insert(sessionImpression);
    }

    private synchronized ArrayList<SessionImpression> fetch(String str) {
        ArrayList<SessionImpression> arrayList;
        String[] strArr = {"timestamp", "age_of_app", "zone_id", "session_duration"};
        String str2 = "zone_id = " + str;
        arrayList = new ArrayList<>();
        try {
            Cursor cursorQuery = this.database.query(DatabaseHelper.TABLE_NAME, strArr, str2, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    SessionImpression sessionImpression = new SessionImpression();
                    sessionImpression.setTimestamp(Long.valueOf(cursorQuery.getLong(0)));
                    sessionImpression.setAgeOfApp(Long.valueOf(cursorQuery.getLong(1)));
                    sessionImpression.setZoneId(cursorQuery.getString(2));
                    sessionImpression.setSessionDuration(Long.valueOf(cursorQuery.getLong(3)));
                    arrayList.add(sessionImpression);
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
        } catch (SQLException e) {
            HyBid.reportException((Exception) e);
            Logger.e(TAG, "Error during DB operation: ", e);
        }
        return arrayList;
    }

    public Integer getImpressionDepth(String str) {
        return Integer.valueOf(fetch(str).size());
    }

    private void manageImpressionSession(Long l) {
        new HyBidPreferences(this.context).setSessionTimeStamp(l.longValue(), new OnDatabaseResetListener() { // from class: net.pubnative.lite.sdk.db.DBManager$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.db.OnDatabaseResetListener
            public final void onDatabaseReset() {
                this.f$0.nukeTable();
            }
        }, HyBidPreferences.TIMESTAMP.AD_REQUEST);
    }

    public void nukeTable() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.delete(DatabaseHelper.TABLE_NAME, null, null);
        }
    }

    public Long getAgeOfApp() {
        return Long.valueOf(new HyBidPreferences(this.context).getSessionTimeStamp());
    }
}
