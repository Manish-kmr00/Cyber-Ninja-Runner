package com.yandex.div.serialization;

import com.yandex.div.data.EntityTemplate;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.TemplateProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParsingContext.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/serialization/OverrideRestrictingParsingContext;", "Lcom/yandex/div/serialization/ParsingContext;", "Lcom/yandex/div/serialization/ParsingContextWrapper;", "baseContext", "(Lcom/yandex/div/serialization/ParsingContext;)V", "allowPropertyOverride", "", "getAllowPropertyOverride", "()Z", "getBaseContext", "()Lcom/yandex/div/serialization/ParsingContext;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "getLogger", "()Lcom/yandex/div/json/ParsingErrorLogger;", "templates", "Lcom/yandex/div/json/templates/TemplateProvider;", "Lcom/yandex/div/data/EntityTemplate;", "getTemplates", "()Lcom/yandex/div/json/templates/TemplateProvider;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class OverrideRestrictingParsingContext implements ParsingContext, ParsingContextWrapper {
    private final ParsingContext baseContext;

    @Override // com.yandex.div.serialization.ParsingContext
    public boolean getAllowPropertyOverride() {
        return false;
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public ParsingErrorLogger getLogger() {
        return this.baseContext.getLogger();
    }

    @Override // com.yandex.div.serialization.ParsingContext
    public TemplateProvider<EntityTemplate<?>> getTemplates() {
        return this.baseContext.getTemplates();
    }

    public OverrideRestrictingParsingContext(ParsingContext baseContext) {
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        this.baseContext = baseContext;
    }

    @Override // com.yandex.div.serialization.ParsingContextWrapper
    public ParsingContext getBaseContext() {
        return this.baseContext;
    }
}
