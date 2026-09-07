package com.yandex.div.data;

import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.TemplateParsingEnvironment;
import com.yandex.div.json.templates.CachingTemplateProvider;
import com.yandex.div.json.templates.InMemoryTemplateProvider;
import com.yandex.div.json.templates.TemplateProvider;
import com.yandex.div2.DivTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: DivParsingEnvironment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/data/DivParsingEnvironment;", "Lcom/yandex/div/json/TemplateParsingEnvironment;", "Lcom/yandex/div2/DivTemplate;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "templateProvider", "Lcom/yandex/div/json/templates/CachingTemplateProvider;", "(Lcom/yandex/div/json/ParsingErrorLogger;Lcom/yandex/div/json/templates/CachingTemplateProvider;)V", "templateFactory", "Lcom/yandex/div/json/TemplateParsingEnvironment$TemplateFactory;", "getTemplateFactory", "()Lcom/yandex/div/json/TemplateParsingEnvironment$TemplateFactory;", "templates", "getTemplates", "()Lcom/yandex/div/json/templates/CachingTemplateProvider;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DivParsingEnvironment extends TemplateParsingEnvironment<DivTemplate> {
    private final TemplateParsingEnvironment.TemplateFactory<DivTemplate> templateFactory;
    private final CachingTemplateProvider<DivTemplate> templates;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivParsingEnvironment(ParsingErrorLogger logger) {
        this(logger, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    public /* synthetic */ DivParsingEnvironment(ParsingErrorLogger parsingErrorLogger, CachingTemplateProvider cachingTemplateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parsingErrorLogger, (i & 2) != 0 ? new CachingTemplateProvider(new InMemoryTemplateProvider(), TemplateProvider.INSTANCE.empty()) : cachingTemplateProvider);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivParsingEnvironment(ParsingErrorLogger logger, CachingTemplateProvider<DivTemplate> templateProvider) {
        super(logger, templateProvider);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(templateProvider, "templateProvider");
        this.templates = templateProvider;
        this.templateFactory = new TemplateParsingEnvironment.TemplateFactory() { // from class: com.yandex.div.data.DivParsingEnvironment$$ExternalSyntheticLambda0
            @Override // com.yandex.div.json.TemplateParsingEnvironment.TemplateFactory
            public final Object create(ParsingEnvironment parsingEnvironment, boolean z, JSONObject jSONObject) {
                return DivParsingEnvironment.templateFactory$lambda$0(parsingEnvironment, z, jSONObject);
            }
        };
    }

    @Override // com.yandex.div.json.TemplateParsingEnvironment, com.yandex.div.serialization.ParsingContext
    public CachingTemplateProvider<DivTemplate> getTemplates() {
        return this.templates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DivTemplate templateFactory$lambda$0(ParsingEnvironment env, boolean z, JSONObject json) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(json, "json");
        return DivTemplate.INSTANCE.invoke(env, z, json);
    }

    @Override // com.yandex.div.json.TemplateParsingEnvironment
    public TemplateParsingEnvironment.TemplateFactory<DivTemplate> getTemplateFactory() {
        return this.templateFactory;
    }
}
