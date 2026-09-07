package com.yandex.div.storage.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.appevents.UserDataStore;
import com.json.cc;
import com.yandex.div.core.DivActionHandler;
import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatabaseOpenHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/DatabaseOpenHelper;", "", "readableDatabase", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "getReadableDatabase", "()Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "writableDatabase", "getWritableDatabase", "CreateCallback", "Database", "UpgradeCallback", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DatabaseOpenHelper {

    /* JADX INFO: compiled from: DatabaseOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/DatabaseOpenHelper$CreateCallback;", "", "onCreate", "", UserDataStore.DATE_OF_BIRTH, "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface CreateCallback {
        void onCreate(Database db);
    }

    /* JADX INFO: compiled from: DatabaseOpenHelper.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&Jk\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "Ljava/io/Closeable;", "beginTransaction", "", "compileStatement", "Landroid/database/sqlite/SQLiteStatement;", "sql", "", "endTransaction", "execSQL", "query", "Landroid/database/Cursor;", cc.Q, "columns", "", DivActionHandler.DivActionReason.SELECTION, "selectionArgs", "groupBy", "having", "orderBy", "limit", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "rawQuery", "(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;", "setTransactionSuccessful", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Database extends Closeable {
        void beginTransaction();

        SQLiteStatement compileStatement(String sql);

        void endTransaction();

        void execSQL(String sql);

        Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit);

        Cursor rawQuery(String query, String[] selectionArgs);

        void setTransactionSuccessful();
    }

    /* JADX INFO: compiled from: DatabaseOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/DatabaseOpenHelper$UpgradeCallback;", "", "onUpgrade", "", UserDataStore.DATE_OF_BIRTH, "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "oldVersion", "", "newVersion", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface UpgradeCallback {
        void onUpgrade(Database db, int oldVersion, int newVersion);
    }

    Database getReadableDatabase();

    Database getWritableDatabase();
}
