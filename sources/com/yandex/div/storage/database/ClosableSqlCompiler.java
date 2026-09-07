package com.yandex.div.storage.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.facebook.appevents.UserDataStore;
import com.yandex.div.storage.util.SqlExtensionsKt;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StorageStatementExecutor.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0012\"\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/storage/database/ClosableSqlCompiler;", "Lcom/yandex/div/storage/database/SqlCompiler;", "Ljava/io/Closeable;", UserDataStore.DATE_OF_BIRTH, "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "(Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;)V", "createdCursors", "", "Landroid/database/Cursor;", "createdStatements", "Landroid/database/sqlite/SQLiteStatement;", "close", "", "compileQuery", "Lcom/yandex/div/storage/database/ReadState;", "sql", "", "selectionArgs", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/yandex/div/storage/database/ReadState;", "compileStatement", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class ClosableSqlCompiler implements SqlCompiler, Closeable {
    private final List<Cursor> createdCursors;
    private final List<SQLiteStatement> createdStatements;
    private final DatabaseOpenHelper.Database db;

    public ClosableSqlCompiler(DatabaseOpenHelper.Database db) {
        Intrinsics.checkNotNullParameter(db, "db");
        this.db = db;
        this.createdStatements = new ArrayList();
        this.createdCursors = new ArrayList();
    }

    @Override // com.yandex.div.storage.database.SqlCompiler
    public SQLiteStatement compileStatement(String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.db.compileStatement(sql);
        this.createdStatements.add(sQLiteStatementCompileStatement);
        return sQLiteStatementCompileStatement;
    }

    @Override // com.yandex.div.storage.database.SqlCompiler
    public ReadState compileQuery(final String sql, final String... selectionArgs) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(selectionArgs, "selectionArgs");
        return new ReadState(null, new Provider() { // from class: com.yandex.div.storage.database.ClosableSqlCompiler$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider
            public final Object get() {
                return ClosableSqlCompiler.compileQuery$lambda$2(this.f$0, sql, selectionArgs);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor compileQuery$lambda$2(ClosableSqlCompiler this$0, String sql, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sql, "$sql");
        Intrinsics.checkNotNullParameter(selectionArgs, "$selectionArgs");
        Cursor cursorRawQuery = this$0.db.rawQuery(sql, selectionArgs);
        this$0.createdCursors.add(cursorRawQuery);
        return cursorRawQuery;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<T> it = this.createdStatements.iterator();
        while (it.hasNext()) {
            SqlExtensionsKt.closeSilently((SQLiteStatement) it.next());
        }
        this.createdStatements.clear();
        for (Cursor cursor : this.createdCursors) {
            if (!cursor.isClosed()) {
                SqlExtensionsKt.closeSilently(cursor);
            }
        }
        this.createdCursors.clear();
    }
}
