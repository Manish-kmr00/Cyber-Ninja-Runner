package com.yandex.div.json;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.json.templates.TemplateProvider;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingEnvironmentExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0017\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0096\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/json/KeyWatchingTemplateProvider;", "Lcom/yandex/div/json/templates/TemplateProvider;", "Lcom/yandex/div/data/EntityTemplate;", "base", "(Lcom/yandex/div/json/templates/TemplateProvider;)V", "_requestedKeys", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "requestedKeys", "", "getRequestedKeys", "()Ljava/util/Set;", "get", "templateId", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class KeyWatchingTemplateProvider implements TemplateProvider<EntityTemplate<?>> {
    private final LinkedHashSet<String> _requestedKeys;
    private final TemplateProvider<EntityTemplate<?>> base;

    /* JADX WARN: Multi-variable type inference failed */
    public KeyWatchingTemplateProvider(TemplateProvider<? extends EntityTemplate<?>> base) {
        Intrinsics.checkNotNullParameter(base, "base");
        this.base = base;
        this._requestedKeys = new LinkedHashSet<>();
    }

    public final Set<String> getRequestedKeys() {
        return this._requestedKeys;
    }

    @Override // com.yandex.div.json.templates.TemplateProvider
    public EntityTemplate<?> get(String templateId) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        this._requestedKeys.add(templateId);
        return this.base.get(templateId);
    }
}
