package com.yandex.div.storage;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivTemplateStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J-\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\f\"\u00020\u0006H'¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/yandex/div/storage/DivTemplateStorage;", "", "clear", "", "deleteTemplates", "cardId", "", "readTemplates", "", "", "readTemplatesByIds", "templateId", "", "([Ljava/lang/String;)Ljava/util/Map;", "writeTemplates", "templates", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivTemplateStorage {
    void clear();

    void deleteTemplates(String cardId);

    Map<String, byte[]> readTemplates(String cardId);

    Map<String, byte[]> readTemplatesByIds(String... templateId);

    void writeTemplates(String cardId, Map<String, byte[]> templates);
}
