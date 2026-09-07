package com.yandex.div.json.templates;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.div.internal.util.CollectionsKt;
import com.yandex.div.json.JsonTemplate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InMemoryTemplateProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H\u0000¢\u0006\u0002\b\u0012R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/json/templates/InMemoryTemplateProvider;", "T", "Lcom/yandex/div/json/JsonTemplate;", "Lcom/yandex/div/json/templates/TemplateProvider;", "()V", "templatesMap", "", "", "get", "templateId", "(Ljava/lang/String;)Lcom/yandex/div/json/JsonTemplate;", "put", "", "jsonTemplate", "put$div_data_release", "(Ljava/lang/String;Lcom/yandex/div/json/JsonTemplate;)V", "takeSnapshot", TypedValues.AttributesType.S_TARGET, "takeSnapshot$div_data_release", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InMemoryTemplateProvider<T extends JsonTemplate<?>> implements TemplateProvider<T> {
    private final Map<String, T> templatesMap = CollectionsKt.arrayMap();

    @Override // com.yandex.div.json.templates.TemplateProvider
    public T get(String templateId) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        return this.templatesMap.get(templateId);
    }

    public final void put$div_data_release(String templateId, T jsonTemplate) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(jsonTemplate, "jsonTemplate");
        this.templatesMap.put(templateId, jsonTemplate);
    }

    public final void takeSnapshot$div_data_release(Map<String, T> target) {
        Intrinsics.checkNotNullParameter(target, "target");
        target.putAll(this.templatesMap);
    }
}
