package com.yandex.div.json.templates;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.div.json.JsonTemplate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CachingTemplateProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\u0012H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0092\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/json/templates/CachingTemplateProvider;", "T", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div/json/templates/TemplateProvider;", "cacheProvider", "Lcom/yandex/div/json/templates/InMemoryTemplateProvider;", "fallbackProvider", "(Lcom/yandex/div/json/templates/InMemoryTemplateProvider;Lcom/yandex/div/json/templates/TemplateProvider;)V", "get", "templateId", "", "(Ljava/lang/String;)Lcom/yandex/div/json/JsonTemplate;", "putAll", "", "parsed", "", "takeSnapshot", TypedValues.AttributesType.S_TARGET, "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class CachingTemplateProvider<T extends JsonTemplate<?>> implements TemplateProvider<T> {
    private final InMemoryTemplateProvider<T> cacheProvider;
    private TemplateProvider<? extends T> fallbackProvider;

    public CachingTemplateProvider(InMemoryTemplateProvider<T> cacheProvider, TemplateProvider<? extends T> fallbackProvider) {
        Intrinsics.checkNotNullParameter(cacheProvider, "cacheProvider");
        Intrinsics.checkNotNullParameter(fallbackProvider, "fallbackProvider");
        this.cacheProvider = cacheProvider;
        this.fallbackProvider = fallbackProvider;
    }

    @Override // com.yandex.div.json.templates.TemplateProvider
    public T get(String templateId) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        T t = (T) this.cacheProvider.get(templateId);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.fallbackProvider.get(templateId);
        if (t2 == null) {
            return null;
        }
        this.cacheProvider.put$div_data_release(templateId, t2);
        return t2;
    }

    public void takeSnapshot(Map<String, T> target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.cacheProvider.takeSnapshot$div_data_release(target);
    }

    public void putAll(Map<String, ? extends T> parsed) {
        Intrinsics.checkNotNullParameter(parsed, "parsed");
        for (Map.Entry<String, ? extends T> entry : parsed.entrySet()) {
            this.cacheProvider.put$div_data_release(entry.getKey(), entry.getValue());
        }
    }
}
