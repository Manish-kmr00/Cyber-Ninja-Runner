package com.yandex.div.serialization;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.TemplateProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingContext.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/serialization/ErrorCollectingParsingContext;", "Lcom/yandex/div/serialization/ParsingContext;", "Lcom/yandex/div/serialization/ParsingContextWrapper;", "baseContext", "(Lcom/yandex/div/serialization/ParsingContext;)V", "allowPropertyOverride", "", "getAllowPropertyOverride", "()Z", "getBaseContext", "()Lcom/yandex/div/serialization/ParsingContext;", "errors", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getErrors", "()Ljava/util/List;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "getLogger", "()Lcom/yandex/div/json/ParsingErrorLogger;", "templates", "Lcom/yandex/div/json/templates/TemplateProvider;", "Lcom/yandex/div/data/EntityTemplate;", "getTemplates", "()Lcom/yandex/div/json/templates/TemplateProvider;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class ErrorCollectingParsingContext implements ParsingContext, ParsingContextWrapper {
    private final ParsingContext baseContext;
    private final List<Exception> errors;
    private final ParsingErrorLogger logger;

    @Override // com.yandex.div.serialization.ParsingContext
    public boolean getAllowPropertyOverride() {
        return this.baseContext.getAllowPropertyOverride();
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public TemplateProvider<EntityTemplate<?>> getTemplates() {
        return this.baseContext.getTemplates();
    }

    public ErrorCollectingParsingContext(ParsingContext baseContext) {
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        this.baseContext = baseContext;
        this.errors = new ArrayList();
        this.logger = new ParsingErrorLogger() { // from class: com.yandex.div.serialization.ErrorCollectingParsingContext$$ExternalSyntheticLambda0
            @Override // com.yandex.div.json.ParsingErrorLogger
            public final void logError(Exception exc) {
                ErrorCollectingParsingContext.logger$lambda$0(this.f$0, exc);
            }
        };
    }

    @Override // com.yandex.div.serialization.ParsingContextWrapper
    public ParsingContext getBaseContext() {
        return this.baseContext;
    }

    public final List<Exception> getErrors() {
        return this.errors;
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public ParsingErrorLogger getLogger() {
        return this.logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logger$lambda$0(ErrorCollectingParsingContext this$0, Exception error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        this$0.errors.add(error);
        this$0.getBaseContext().getLogger().logError(error);
    }
}
