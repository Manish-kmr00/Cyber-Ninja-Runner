package net.pubnative.lite.sdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes12.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String AGE_OF_APP = "age_of_app";
    private static final String CREATE_TABLE = "create table IMPRESSIION(_id TEXT PRIMARY KEY , zone_id TEXT , timestamp LONG , age_of_app LONG , event_type TEXT , session_duration LONG); ";
    static final String DB_NAME = "hybid_impression.DB";
    static final int DB_VERSION = 1;
    public static final String EVENT_TYPE = "event_type";
    public static final String SESSION_DURATION = "session_duration";
    public static final String TABLE_NAME = "IMPRESSIION";
    public static final String TIMESTAMP = "timestamp";
    public static final String ZONE_ID = "zone_id";
    public static final String _ID = "_id";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS IMPRESSIION");
        onCreate(sQLiteDatabase);
    }
}
