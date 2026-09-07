package com.yandex.div.storage.database;

import android.database.sqlite.SQLiteStatement;
import kotlin.Metadata;

/* JADX INFO: compiled from: SqlCompiler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/SqlCompiler;", "", "compileQuery", "Lcom/yandex/div/storage/database/ReadState;", "sql", "", "selectionArgs", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/yandex/div/storage/database/ReadState;", "compileStatement", "Landroid/database/sqlite/SQLiteStatement;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SqlCompiler {
    ReadState compileQuery(String sql, String... selectionArgs);

    SQLiteStatement compileStatement(String sql);
}
