package com.yandex.div.storage.db;

import android.database.sqlite.SQLiteDatabase;
import com.yandex.div.internal.Assert;
import com.yandex.div.storage.entity.TemplateUsage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TemplateUsageDaoImpl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/storage/db/TemplateUsageDaoImpl;", "Lcom/yandex/div/storage/db/TemplateUsageDao;", "writableDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "deleteAllTemplateUsages", "", "deleteTemplateUsages", "cardId", "", "insertTemplateUsage", "usage", "Lcom/yandex/div/storage/entity/TemplateUsage;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TemplateUsageDaoImpl implements TemplateUsageDao {
    private final SQLiteDatabase writableDatabase;

    public TemplateUsageDaoImpl(SQLiteDatabase writableDatabase) {
        Intrinsics.checkNotNullParameter(writableDatabase, "writableDatabase");
        this.writableDatabase = writableDatabase;
        if (writableDatabase.isReadOnly()) {
            Assert.fail(getClass().getName() + " requires writable db!");
        }
    }

    @Override // com.yandex.div.storage.db.TemplateUsageDao
    public void insertTemplateUsage(TemplateUsage usage) {
        Intrinsics.checkNotNullParameter(usage, "usage");
        this.writableDatabase.execSQL(TemplateUsageQueries.INSERT_TEMPLATE_USAGE_QUERY_TEMPLATE, new String[]{usage.getCardId(), usage.getTemplateId()});
    }

    @Override // com.yandex.div.storage.db.TemplateUsageDao
    public void deleteAllTemplateUsages() {
        this.writableDatabase.execSQL(TemplateUsageQueries.DELETE_ALL_TEMPLATE_USAGES_QUERY);
    }

    @Override // com.yandex.div.storage.db.TemplateUsageDao
    public void deleteTemplateUsages(String cardId) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        this.writableDatabase.execSQL(TemplateUsageQueries.DELETE_TEMPLATE_USAGE_BY_CARD_ID_QUERY_TEMPLATE, new String[]{cardId});
    }
}
