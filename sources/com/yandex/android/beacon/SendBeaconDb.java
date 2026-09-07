package com.yandex.android.beacon;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.safedk.android.analytics.brandsafety.l;
import com.yandex.android.util.SerializationUtils;
import com.yandex.div.internal.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SendBeaconDb.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0010\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0017J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0012J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\bH\u0017J\u0016\u0010!\u001a\u0004\u0018\u00010\u0010*\u00020\u00152\u0006\u0010\"\u001a\u00020\u001cH\u0012J\u0016\u0010#\u001a\u0004\u0018\u00010\u0005*\u00020\u00152\u0006\u0010\"\u001a\u00020\u001cH\u0012¨\u0006&"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconDb;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "databaseName", "", "(Landroid/content/Context;Ljava/lang/String;)V", l.l, "Lcom/yandex/android/beacon/BeaconItem$Persistent;", "url", "Landroid/net/Uri;", SendBeaconDb.COLUMN_HEADERS, "", "addTimestamp", "", "payload", "Lorg/json/JSONObject;", "allItems", "", "beaconItemFromCursor", "cursor", "Landroid/database/Cursor;", "onCreate", "", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "remove", "", "item", "getNullableJson", "columnIndex", "getNullableString", "Companion", "Factory", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SendBeaconDb extends SQLiteOpenHelper {
    private static final String ADD_PAYLOAD_COLUMN_TO_ITEM = "\n            ALTER TABLE items ADD COLUMN payload TEXT;\n        ";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PAYLOAD = "payload";
    private static final String COLUMN_URL = "url";
    private static final String DATABASE_CREATE = "\n            CREATE TABLE items(\n            _id INTEGER PRIMARY KEY AUTOINCREMENT,\n            url TEXT NOT NULL,\n            headers TEXT,\n            add_timestamp INTEGER, \n            payload TEXT)";
    private static final int DATABASE_INIT_VERSION = 1;
    private static final int DATABASE_VERSION = 2;
    private static final String REMOVE_CLAUSE = "_id = ?";
    private static final String TABLE_ITEMS = "items";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String COLUMN_HEADERS = "headers";
    private static final String COLUMN_ADD_TIMESTAMP = "add_timestamp";
    private static final String[] QUERY_COLUMNS = {"_id", "url", COLUMN_HEADERS, COLUMN_ADD_TIMESTAMP, "payload"};
    public static Factory factory = SendBeaconDb$Companion$factory$1.INSTANCE;

    /* JADX INFO: compiled from: SendBeaconDb.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconDb$Factory;", "", "create", "Lcom/yandex/android/beacon/SendBeaconDb;", "context", "Landroid/content/Context;", "databaseName", "", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Factory {
        SendBeaconDb create(Context context, String databaseName);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendBeaconDb(Context context, String databaseName) {
        super(context, databaseName, (SQLiteDatabase.CursorFactory) null, 2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Assert.assertTrue(context instanceof Application);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        if (oldVersion == 1) {
            sqLiteDatabase.execSQL(ADD_PAYLOAD_COLUMN_TO_ITEM);
        }
    }

    public List<BeaconItem.Persistent> allItems() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursorQuery = null;
        try {
            cursorQuery = readableDatabase.query("items", QUERY_COLUMNS, null, null, null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    arrayList.add(beaconItemFromCursor(cursorQuery));
                }
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            readableDatabase.close();
        }
    }

    public BeaconItem.Persistent add(Uri url, Map<String, String> headers, long addTimestamp, JSONObject payload) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("url", url.toString());
        contentValues.put(COLUMN_HEADERS, SerializationUtils.serialize(headers));
        contentValues.put(COLUMN_ADD_TIMESTAMP, Long.valueOf(addTimestamp));
        SQLiteDatabase writableDatabase = getWritableDatabase();
        SQLiteDatabase sQLiteDatabase = writableDatabase;
        try {
            long jInsert = writableDatabase.insert("items", null, contentValues);
            CloseableKt.closeFinally(sQLiteDatabase, null);
            return new BeaconItem.Persistent(url, headers, payload, addTimestamp, jInsert);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(sQLiteDatabase, th);
                throw th2;
            }
        }
    }

    public boolean remove(BeaconItem.Persistent item) throws IOException {
        if (item == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        SQLiteDatabase sQLiteDatabase = writableDatabase;
        try {
            int iDelete = writableDatabase.delete("items", REMOVE_CLAUSE, new String[]{String.valueOf(item.getRowId())});
            CloseableKt.closeFinally(sQLiteDatabase, null);
            return iDelete != 0;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(sQLiteDatabase, th);
                throw th2;
            }
        }
    }

    private BeaconItem.Persistent beaconItemFromCursor(Cursor cursor) {
        Uri uri = Uri.parse(cursor.getString(1));
        Intrinsics.checkNotNullExpressionValue(uri, "parse(cursor.getString(1))");
        return new BeaconItem.Persistent(uri, SerializationUtils.deserializeMap(cursor.getString(2)), getNullableJson(cursor, 4), cursor.getLong(3), cursor.getLong(0));
    }

    /* JADX INFO: compiled from: SendBeaconDb.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/yandex/android/beacon/SendBeaconDb$Companion;", "", "()V", "ADD_PAYLOAD_COLUMN_TO_ITEM", "", "COLUMN_ADD_TIMESTAMP", "COLUMN_HEADERS", "COLUMN_ID", "COLUMN_PAYLOAD", "COLUMN_URL", "DATABASE_CREATE", "DATABASE_INIT_VERSION", "", "DATABASE_VERSION", "QUERY_COLUMNS", "", "[Ljava/lang/String;", "REMOVE_CLAUSE", "TABLE_ITEMS", "factory", "Lcom/yandex/android/beacon/SendBeaconDb$Factory;", "getFactory$beacon_release$annotations", "beacon_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getFactory$beacon_release$annotations() {
        }

        private Companion() {
        }
    }

    private String getNullableString(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }

    private JSONObject getNullableJson(Cursor cursor, int i) {
        String nullableString = getNullableString(cursor, i);
        if (nullableString == null || nullableString.length() <= 0) {
            return null;
        }
        try {
            return new JSONObject(nullableString);
        } catch (JSONException e) {
            Assert.fail("Payload parsing exception: " + e);
            return null;
        }
    }
}
