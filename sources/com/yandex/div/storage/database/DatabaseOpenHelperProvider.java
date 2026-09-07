package com.yandex.div.storage.database;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: DatabaseOpenHelperProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/database/DatabaseOpenHelperProvider;", "", "provide", "Lcom/yandex/div/storage/database/DatabaseOpenHelper;", "context", "Landroid/content/Context;", "name", "", "version", "", "ccb", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$CreateCallback;", "ucb", "Lcom/yandex/div/storage/database/DatabaseOpenHelper$UpgradeCallback;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DatabaseOpenHelperProvider {
    DatabaseOpenHelper provide(Context context, String name, int version, DatabaseOpenHelper.CreateCallback ccb, DatabaseOpenHelper.UpgradeCallback ucb);
}
