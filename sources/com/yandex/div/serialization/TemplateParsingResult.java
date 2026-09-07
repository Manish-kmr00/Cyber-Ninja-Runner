package com.yandex.div.serialization;

import com.yandex.div.core.annotations.ExperimentalApi;
import com.yandex.div.data.EntityTemplate;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TemplateParsingResult.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005¢\u0006\u0002\u0010\tJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J\u001b\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005HÆ\u0003JA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00052\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/serialization/TemplateParsingResult;", "T", "Lcom/yandex/div/data/EntityTemplate;", "", "templates", "", "", "templateDependencies", "", "(Ljava/util/Map;Ljava/util/Map;)V", "getTemplateDependencies", "()Ljava/util/Map;", "getTemplates", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalApi
public final /* data */ class TemplateParsingResult<T extends EntityTemplate<?>> {
    private final Map<String, Set<String>> templateDependencies;
    private final Map<String, T> templates;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateParsingResult copy$default(TemplateParsingResult templateParsingResult, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = templateParsingResult.templates;
        }
        if ((i & 2) != 0) {
            map2 = templateParsingResult.templateDependencies;
        }
        return templateParsingResult.copy(map, map2);
    }

    public final Map<String, T> component1() {
        return this.templates;
    }

    public final Map<String, Set<String>> component2() {
        return this.templateDependencies;
    }

    public final TemplateParsingResult<T> copy(Map<String, ? extends T> templates, Map<String, ? extends Set<String>> templateDependencies) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        Intrinsics.checkNotNullParameter(templateDependencies, "templateDependencies");
        return new TemplateParsingResult<>(templates, templateDependencies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateParsingResult)) {
            return false;
        }
        TemplateParsingResult templateParsingResult = (TemplateParsingResult) other;
        return Intrinsics.areEqual(this.templates, templateParsingResult.templates) && Intrinsics.areEqual(this.templateDependencies, templateParsingResult.templateDependencies);
    }

    public int hashCode() {
        return (this.templates.hashCode() * 31) + this.templateDependencies.hashCode();
    }

    public String toString() {
        return "TemplateParsingResult(templates=" + this.templates + ", templateDependencies=" + this.templateDependencies + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateParsingResult(Map<String, ? extends T> templates, Map<String, ? extends Set<String>> templateDependencies) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        Intrinsics.checkNotNullParameter(templateDependencies, "templateDependencies");
        this.templates = templates;
        this.templateDependencies = templateDependencies;
    }

    public final Map<String, T> getTemplates() {
        return this.templates;
    }

    public final Map<String, Set<String>> getTemplateDependencies() {
        return this.templateDependencies;
    }
}
