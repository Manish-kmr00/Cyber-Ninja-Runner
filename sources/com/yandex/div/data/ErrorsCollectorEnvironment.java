package com.yandex.div.data;

import com.yandex.div.json.ParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.TemplateProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorsCollectorEnvironment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0013R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/data/ErrorsCollectorEnvironment;", "Lcom/yandex/div/json/ParsingEnvironment;", "origin", "(Lcom/yandex/div/json/ParsingEnvironment;)V", "errors", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "getLogger", "()Lcom/yandex/div/json/ParsingErrorLogger;", "originLogger", "templates", "Lcom/yandex/div/json/templates/TemplateProvider;", "Lcom/yandex/div/data/EntityTemplate;", "getTemplates", "()Lcom/yandex/div/json/templates/TemplateProvider;", "collectErrors", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorsCollectorEnvironment implements ParsingEnvironment {
    private final List<Exception> errors;
    private final ParsingErrorLogger logger;
    private final ParsingErrorLogger originLogger;
    private final TemplateProvider<EntityTemplate<?>> templates;

    public ErrorsCollectorEnvironment(ParsingEnvironment origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.originLogger = origin.getLogger();
        this.errors = new ArrayList();
        this.templates = origin.getTemplates();
        this.logger = new ParsingErrorLogger() { // from class: com.yandex.div.data.ErrorsCollectorEnvironment$$ExternalSyntheticLambda0
            @Override // com.yandex.div.json.ParsingErrorLogger
            public final void logError(Exception exc) {
                ErrorsCollectorEnvironment.logger$lambda$0(this.f$0, exc);
            }
        };
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public TemplateProvider<EntityTemplate<?>> getTemplates() {
        return this.templates;
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public ParsingErrorLogger getLogger() {
        return this.logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logger$lambda$0(ErrorsCollectorEnvironment this$0, Exception e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        this$0.errors.add(e);
        this$0.originLogger.logError(e);
    }

    public final List<Exception> collectErrors() {
        return CollectionsKt.toList(this.errors);
    }
}
