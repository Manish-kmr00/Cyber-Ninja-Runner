package com.yandex.div.serialization;

import com.yandex.div.json.JsonTemplate;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.templates.TemplateProvider;
import com.yandex.div2.JsonParserComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BuiltInParser.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"builtInParserComponent", "Lcom/yandex/div2/JsonParserComponent;", "getBuiltInParserComponent", "()Lcom/yandex/div2/JsonParserComponent;", "builtInParsingContext", "Lcom/yandex/div/serialization/ParsingContext;", "getBuiltInParsingContext", "()Lcom/yandex/div/serialization/ParsingContext;", "div-data_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BuiltInParserKt {
    private static final ParsingContext builtInParsingContext = new ParsingContext() { // from class: com.yandex.div.serialization.BuiltInParserKt$builtInParsingContext$1
        private final ParsingErrorLogger logger;
        private final TemplateProvider<JsonTemplate<?>> templates = TemplateProvider.INSTANCE.empty();

        {
            ParsingErrorLogger LOG = ParsingErrorLogger.LOG;
            Intrinsics.checkNotNullExpressionValue(LOG, "LOG");
            this.logger = LOG;
        }

        @Override // com.yandex.div.serialization.ParsingContext
        public TemplateProvider<JsonTemplate<?>> getTemplates() {
            return this.templates;
        }

        @Override // com.yandex.div.serialization.ParsingContext
        public ParsingErrorLogger getLogger() {
            return this.logger;
        }
    };
    private static final JsonParserComponent builtInParserComponent = new JsonParserComponent();

    public static final ParsingContext getBuiltInParsingContext() {
        return builtInParsingContext;
    }

    public static final JsonParserComponent getBuiltInParserComponent() {
        return builtInParserComponent;
    }
}
