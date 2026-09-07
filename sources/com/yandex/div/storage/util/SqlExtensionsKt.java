package com.yandex.div.storage.util;

import android.database.sqlite.SQLiteStatement;
import com.yandex.div.storage.database.DatabaseOpenHelper;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SqlExtensions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"bindNullableBlob", "", "Landroid/database/sqlite/SQLiteStatement;", "index", "", "value", "", "closeSilently", "Ljava/io/Closeable;", "endTransactionSilently", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "div-storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SqlExtensionsKt {
    public static final void bindNullableBlob(SQLiteStatement sQLiteStatement, int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(sQLiteStatement, "<this>");
        if (bArr == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindBlob(i, bArr);
        }
    }

    public static final void closeSilently(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static final void endTransactionSilently(DatabaseOpenHelper.Database database) {
        Intrinsics.checkNotNullParameter(database, "<this>");
        try {
            database.endTransaction();
        } catch (IllegalStateException unused) {
        }
    }
}
