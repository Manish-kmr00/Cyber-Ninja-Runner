package com.yandex.div.json.templates;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TemplateProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f*\u000e\b\u0000\u0010\u0001 \u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003:\u0001\fJ\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/json/templates/TemplateProvider;", "T", "Lcom/yandex/div/data/EntityTemplate;", "", "get", "templateId", "", "(Ljava/lang/String;)Lcom/yandex/div/data/EntityTemplate;", "getOrThrow", "json", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/yandex/div/data/EntityTemplate;", "Companion", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TemplateProvider<T extends EntityTemplate<?>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    T get(String templateId);

    default T getOrThrow(String templateId, JSONObject json) throws ParsingException {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(json, "json");
        T t = (T) get(templateId);
        if (t != null) {
            return t;
        }
        throw ParsingExceptionKt.templateNotFound(json, templateId);
    }

    /* JADX INFO: compiled from: TemplateProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\f\b\u0001\u0010\u0005*\u0006\u0012\u0002\b\u00030\u0006J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\f\b\u0001\u0010\u0005*\u0006\u0012\u0002\b\u00030\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00050\t¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/json/templates/TemplateProvider$Companion;", "", "()V", "empty", "Lcom/yandex/div/json/templates/TemplateProvider;", "T", "Lcom/yandex/div/data/EntityTemplate;", "wrap", "map", "", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final <T extends EntityTemplate<?>> TemplateProvider<T> empty() {
            return (TemplateProvider) new TemplateProvider<T>() { // from class: com.yandex.div.json.templates.TemplateProvider$Companion$empty$1
                /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
                @Override // com.yandex.div.json.templates.TemplateProvider
                public EntityTemplate get(String templateId) {
                    Intrinsics.checkNotNullParameter(templateId, "templateId");
                    return null;
                }
            };
        }

        public final <T extends EntityTemplate<?>> TemplateProvider<T> wrap(final Map<String, ? extends T> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return (TemplateProvider) new TemplateProvider<T>() { // from class: com.yandex.div.json.templates.TemplateProvider$Companion$wrap$1
                /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/String;)TT; */
                @Override // com.yandex.div.json.templates.TemplateProvider
                public EntityTemplate get(String templateId) {
                    Intrinsics.checkNotNullParameter(templateId, "templateId");
                    return (EntityTemplate) map.get(templateId);
                }
            };
        }
    }
}
