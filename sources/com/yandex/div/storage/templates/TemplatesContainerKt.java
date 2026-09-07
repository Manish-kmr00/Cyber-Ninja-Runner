package com.yandex.div.storage.templates;

import com.yandex.div.data.DivParsingEnvironment;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.CachingTemplateProvider;
import com.yandex.div.json.templates.InMemoryTemplateProvider;
import com.yandex.div.json.templates.TemplateProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: TemplatesContainer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002*\f\b\u0002\u0010\u0004\"\u00020\u00052\u00020\u0005*\f\b\u0002\u0010\u0006\"\u00020\u00052\u00020\u0005*\f\b\u0002\u0010\u0007\"\u00020\u00052\u00020\u0005¨\u0006\b"}, d2 = {"createEmptyEnv", "Lcom/yandex/div/data/DivParsingEnvironment;", "logger", "Lcom/yandex/div/json/ParsingErrorLogger;", "GroupId", "", "TemplateHash", "TemplateId", "div-storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TemplatesContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DivParsingEnvironment createEmptyEnv(ParsingErrorLogger parsingErrorLogger) {
        return new DivParsingEnvironment(parsingErrorLogger, new CachingTemplateProvider(new InMemoryTemplateProvider(), TemplateProvider.INSTANCE.empty()));
    }
}
