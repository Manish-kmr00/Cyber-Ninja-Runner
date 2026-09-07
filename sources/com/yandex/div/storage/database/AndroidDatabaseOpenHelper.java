package com.yandex.div.storage.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.json.cc;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.internal.Assert;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidDatabaseOpenHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u0001:\u0003 !\"B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0011H\u0012J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006#"}, d2 = {"Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper;", "Lcom/yandex/div/storage/database/DatabaseOpenHelper;", "context", "Landroid/content/Context;", "name", "", "version", "", "ccb", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$CreateCallback;", "ucb", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$UpgradeCallback;", "(Landroid/content/Context;Ljava/lang/String;ILcom/yandex/div/storage/database/DatabaseOpenHelper$CreateCallback;Lcom/yandex/div/storage/database/DatabaseOpenHelper$UpgradeCallback;)V", "databaseManager", "Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$DatabaseManager;", "mOpenCloseInfoMap", "", "Landroid/database/sqlite/SQLiteDatabase;", "Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$OpenCloseInfo;", "mOpenCloseLock", "", "mSQLiteOpenHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "readableDatabase", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "getReadableDatabase", "()Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "writableDatabase", "getWritableDatabase", "getOpenCloseInfo", "sqLiteDatabase", "wrapDataBase", "AndroidSQLiteDatabase", "DatabaseManager", "OpenCloseInfo", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class AndroidDatabaseOpenHelper implements DatabaseOpenHelper {
    private final DatabaseManager databaseManager;
    private final Map<SQLiteDatabase, OpenCloseInfo> mOpenCloseInfoMap;
    private final Object mOpenCloseLock;
    private final SQLiteOpenHelper mSQLiteOpenHelper;

    public AndroidDatabaseOpenHelper(Context context, String name, int i, final DatabaseOpenHelper.CreateCallback ccb, final DatabaseOpenHelper.UpgradeCallback ucb) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ccb, "ccb");
        Intrinsics.checkNotNullParameter(ucb, "ucb");
        this.mOpenCloseLock = new Object();
        this.mOpenCloseInfoMap = new HashMap();
        SQLiteOpenHelper sQLiteOpenHelper = new SQLiteOpenHelper(context, name, i) { // from class: com.yandex.div.storage.database.AndroidDatabaseOpenHelper.1
            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                ccb.onCreate(this.wrapDataBase(sqLiteDatabase));
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
                Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                ucb.onUpgrade(this.wrapDataBase(sqLiteDatabase), oldVersion, newVersion);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
                db.setForeignKeyConstraintsEnabled(true);
            }
        };
        this.mSQLiteOpenHelper = sQLiteOpenHelper;
        this.databaseManager = new DatabaseManager(sQLiteOpenHelper);
    }

    @Override // com.yandex.div.storage.database.DatabaseOpenHelper
    public DatabaseOpenHelper.Database getReadableDatabase() {
        return wrapDataBase(this.databaseManager.openReadableDatabase());
    }

    @Override // com.yandex.div.storage.database.DatabaseOpenHelper
    public DatabaseOpenHelper.Database getWritableDatabase() {
        return wrapDataBase(this.databaseManager.openWritableDatabase());
    }

    public DatabaseOpenHelper.Database wrapDataBase(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        return new AndroidSQLiteDatabase(this, sqLiteDatabase, getOpenCloseInfo(sqLiteDatabase));
    }

    private OpenCloseInfo getOpenCloseInfo(SQLiteDatabase sqLiteDatabase) {
        OpenCloseInfo openCloseInfo;
        synchronized (this.mOpenCloseLock) {
            openCloseInfo = this.mOpenCloseInfoMap.get(sqLiteDatabase);
            if (openCloseInfo == null) {
                openCloseInfo = new OpenCloseInfo();
                this.mOpenCloseInfoMap.put(sqLiteDatabase, openCloseInfo);
            }
            openCloseInfo.setCurrentlyOpenedCount(openCloseInfo.getCurrentlyOpenedCount() + 1);
            openCloseInfo.getCurrentlyOpenedCount();
        }
        return openCloseInfo;
    }

    /* JADX INFO: compiled from: AndroidDatabaseOpenHelper.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016Jk\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001bJ)\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0016\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$AndroidSQLiteDatabase;", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "mDb", "Landroid/database/sqlite/SQLiteDatabase;", "mOpenCloseInfo", "Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$OpenCloseInfo;", "(Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper;Landroid/database/sqlite/SQLiteDatabase;Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$OpenCloseInfo;)V", "beginTransaction", "", "close", "compileStatement", "Landroid/database/sqlite/SQLiteStatement;", "sql", "", "endTransaction", "execSQL", "query", "Landroid/database/Cursor;", cc.Q, "columns", "", DivActionHandler.DivActionReason.SELECTION, "selectionArgs", "groupBy", "having", "orderBy", "limit", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "rawQuery", "(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;", "setTransactionSuccessful", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class AndroidSQLiteDatabase implements DatabaseOpenHelper.Database {
        private final SQLiteDatabase mDb;
        private final OpenCloseInfo mOpenCloseInfo;
        final /* synthetic */ AndroidDatabaseOpenHelper this$0;

        public AndroidSQLiteDatabase(AndroidDatabaseOpenHelper androidDatabaseOpenHelper, SQLiteDatabase mDb, OpenCloseInfo mOpenCloseInfo) {
            Intrinsics.checkNotNullParameter(mDb, "mDb");
            Intrinsics.checkNotNullParameter(mOpenCloseInfo, "mOpenCloseInfo");
            this.this$0 = androidDatabaseOpenHelper;
            this.mDb = mDb;
            this.mOpenCloseInfo = mOpenCloseInfo;
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public void execSQL(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.mDb.execSQL(sql);
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
            Intrinsics.checkNotNullParameter(table, "table");
            Cursor cursorQuery = this.mDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
            Intrinsics.checkNotNullExpressionValue(cursorQuery, "mDb.query(table, columns…, having, orderBy, limit)");
            return cursorQuery;
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public Cursor rawQuery(String query, String[] selectionArgs) {
            Intrinsics.checkNotNullParameter(query, "query");
            Cursor cursorRawQuery = this.mDb.rawQuery(query, selectionArgs);
            Intrinsics.checkNotNullExpressionValue(cursorRawQuery, "mDb.rawQuery(query, selectionArgs)");
            return cursorRawQuery;
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public void beginTransaction() {
            this.mDb.beginTransaction();
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public void setTransactionSuccessful() {
            this.mDb.setTransactionSuccessful();
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public void endTransaction() {
            this.mDb.endTransaction();
        }

        @Override // com.yandex.div.storage.database.DatabaseOpenHelper.Database
        public SQLiteStatement compileStatement(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            SQLiteStatement sQLiteStatementCompileStatement = this.mDb.compileStatement(sql);
            Intrinsics.checkNotNullExpressionValue(sQLiteStatementCompileStatement, "mDb.compileStatement(sql)");
            return sQLiteStatementCompileStatement;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.this$0.databaseManager.closeDatabase(this.mDb);
        }
    }

    /* JADX INFO: compiled from: AndroidDatabaseOpenHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$OpenCloseInfo;", "", "()V", "currentlyOpenedCount", "", "getCurrentlyOpenedCount", "()I", "setCurrentlyOpenedCount", "(I)V", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class OpenCloseInfo {
        private int currentlyOpenedCount;

        public final int getCurrentlyOpenedCount() {
            return this.currentlyOpenedCount;
        }

        public final void setCurrentlyOpenedCount(int i) {
            this.currentlyOpenedCount = i;
        }
    }

    /* JADX INFO: compiled from: AndroidDatabaseOpenHelper.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/storage/database/AndroidDatabaseOpenHelper$DatabaseManager;", "", "databaseHelper", "Landroid/database/sqlite/SQLiteOpenHelper;", "(Landroid/database/sqlite/SQLiteOpenHelper;)V", "readableDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "readableUsers", "", "Ljava/lang/Thread;", "readableUsersCount", "", "writableDatabase", "writableUsers", "writableUsersCount", "closeDatabase", "", "mDb", "openReadableDatabase", "openWritableDatabase", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class DatabaseManager {
        private final SQLiteOpenHelper databaseHelper;
        private SQLiteDatabase readableDatabase;
        private final Set<Thread> readableUsers;
        private int readableUsersCount;
        private SQLiteDatabase writableDatabase;
        private final Set<Thread> writableUsers;
        private int writableUsersCount;

        public DatabaseManager(SQLiteOpenHelper databaseHelper) {
            Intrinsics.checkNotNullParameter(databaseHelper, "databaseHelper");
            this.databaseHelper = databaseHelper;
            this.readableUsers = new LinkedHashSet();
            this.writableUsers = new LinkedHashSet();
        }

        public final synchronized SQLiteDatabase openWritableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            this.writableDatabase = this.databaseHelper.getWritableDatabase();
            this.writableUsersCount++;
            Set<Thread> set = this.writableUsers;
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "currentThread()");
            set.add(threadCurrentThread);
            sQLiteDatabase = this.writableDatabase;
            Intrinsics.checkNotNull(sQLiteDatabase);
            return sQLiteDatabase;
        }

        public final synchronized SQLiteDatabase openReadableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            this.readableDatabase = this.databaseHelper.getReadableDatabase();
            this.readableUsersCount++;
            Set<Thread> set = this.readableUsers;
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "currentThread()");
            set.add(threadCurrentThread);
            sQLiteDatabase = this.readableDatabase;
            Intrinsics.checkNotNull(sQLiteDatabase);
            return sQLiteDatabase;
        }

        public final synchronized void closeDatabase(SQLiteDatabase mDb) {
            Intrinsics.checkNotNullParameter(mDb, "mDb");
            if (Intrinsics.areEqual(mDb, this.writableDatabase)) {
                this.writableUsers.remove(Thread.currentThread());
                if (this.writableUsers.isEmpty()) {
                    while (true) {
                        int i = this.writableUsersCount;
                        this.writableUsersCount = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        SQLiteDatabase sQLiteDatabase = this.writableDatabase;
                        Intrinsics.checkNotNull(sQLiteDatabase);
                        sQLiteDatabase.close();
                    }
                }
            } else if (Intrinsics.areEqual(mDb, this.readableDatabase)) {
                this.readableUsers.remove(Thread.currentThread());
                if (this.readableUsers.isEmpty()) {
                    while (true) {
                        int i2 = this.readableUsersCount;
                        this.readableUsersCount = i2 - 1;
                        if (i2 <= 0) {
                            break;
                        }
                        SQLiteDatabase sQLiteDatabase2 = this.readableDatabase;
                        Intrinsics.checkNotNull(sQLiteDatabase2);
                        sQLiteDatabase2.close();
                    }
                }
            } else {
                Assert.fail("Trying to close unknown database from DatabaseManager");
                mDb.close();
            }
        }
    }
}
