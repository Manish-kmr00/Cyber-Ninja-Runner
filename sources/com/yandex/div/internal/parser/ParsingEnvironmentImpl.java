package com.yandex.div.internal.parser;

import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.TemplateProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingEnvironmentImpl.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/yandex/div/internal/parser/ParsingEnvironmentImpl;", "Lcom/yandex/div/json/ParsingEnvironment;", "templates", "Lcom/yandex/div/json/templates/TemplateProvider;", "Lcom/yandex/div/json/JsonTemplate;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Lcom/yandex/div/json/templates/TemplateProvider;Lcom/yandex/div/json/ParsingErrorLogger;)V", "getLogger", "()Lcom/yandex/div/json/ParsingErrorLogger;", "getTemplates", "()Lcom/yandex/div/json/templates/TemplateProvider;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ParsingEnvironmentImpl implements ParsingEnvironment {
    private final ParsingErrorLogger logger;
    private final TemplateProvider<JsonTemplate<?>> templates;

    /* JADX WARN: Multi-variable type inference failed */
    public ParsingEnvironmentImpl(TemplateProvider<? extends JsonTemplate<?>> templates, ParsingErrorLogger logger) {
        Intrinsics.checkNotNullParameter(templates, "templates");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.templates = templates;
        this.logger = logger;
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public TemplateProvider<JsonTemplate<?>> getTemplates() {
        return this.templates;
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public ParsingErrorLogger getLogger() {
        return this.logger;
    }
}
