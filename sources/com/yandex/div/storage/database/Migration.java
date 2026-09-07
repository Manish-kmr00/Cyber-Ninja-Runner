package com.yandex.div.storage.database;

import android.database.SQLException;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;

/* JADX INFO: compiled from: Migration.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/Migration;", "", "migrate", "", UserDataStore.DATE_OF_BIRTH, "Lcom/yandex/div/storage/database/DatabaseOpenHelper$Database;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Migration {
    void migrate(DatabaseOpenHelper.Database db) throws SQLException;
}
