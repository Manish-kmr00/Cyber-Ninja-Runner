package com.yandex.div.storage.db;

import com.yandex.div.storage.entity.TemplateUsage;
import kotlin.Metadata;

/* JADX INFO: compiled from: TemplateUsageDao.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/db/TemplateUsageDao;", "", "deleteAllTemplateUsages", "", "deleteTemplateUsages", "cardId", "", "insertTemplateUsage", "usage", "Lcom/yandex/div/storage/entity/TemplateUsage;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TemplateUsageDao {
    void deleteAllTemplateUsages();

    void deleteTemplateUsages(String cardId);

    void insertTemplateUsage(TemplateUsage usage);
}
