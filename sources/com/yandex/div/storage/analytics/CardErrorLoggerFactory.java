package com.yandex.div.storage.analytics;

import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.storage.templates.TemplatesContainer;
import com.yandex.div.storage.util.CardErrorTransformer;
import com.yandex.div.storage.util.LazyProvider;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CardErrorLoggerFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ*\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/storage/analytics/CardErrorLoggerFactory;", "", "externalErrorTransformer", "Ljavax/inject/Provider;", "Lcom/yandex/div/storage/util/CardErrorTransformer;", "templateContainer", "Lcom/yandex/div/storage/templates/TemplatesContainer;", "parsingErrorLogger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Ljavax/inject/Provider;Lcom/yandex/div/storage/templates/TemplatesContainer;Lcom/yandex/div/json/ParsingErrorLogger;)V", "errorTransformer", "createContextualLogger", "origin", "cardId", "", "groupId", "metadata", "Lorg/json/JSONObject;", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class CardErrorLoggerFactory {
    private final Provider<CardErrorTransformer> errorTransformer;
    private final ParsingErrorLogger parsingErrorLogger;
    private final TemplatesContainer templateContainer;

    public CardErrorLoggerFactory(final Provider<? extends CardErrorTransformer> provider, TemplatesContainer templateContainer, ParsingErrorLogger parsingErrorLogger) {
        Intrinsics.checkNotNullParameter(templateContainer, "templateContainer");
        Intrinsics.checkNotNullParameter(parsingErrorLogger, "parsingErrorLogger");
        this.templateContainer = templateContainer;
        this.parsingErrorLogger = parsingErrorLogger;
        this.errorTransformer = new LazyProvider(new Function0<CardErrorTransformer>() { // from class: com.yandex.div.storage.analytics.CardErrorLoggerFactory$errorTransformer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CardErrorTransformer invoke() {
                if (provider == null) {
                    return new TemplateCardErrorTransformer(this.templateContainer, this.parsingErrorLogger);
                }
                CardErrorTransformer cardErrorTransformer = provider.get();
                Intrinsics.checkNotNullExpressionValue(cardErrorTransformer, "externalErrorTransformer.get()");
                return new CardErrorTransformer.Composite(cardErrorTransformer, new TemplateCardErrorTransformer(this.templateContainer, this.parsingErrorLogger));
            }
        });
    }

    public ParsingErrorLogger createContextualLogger(final ParsingErrorLogger origin, final String cardId, final String groupId, final JSONObject metadata) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new ParsingErrorLogger() { // from class: com.yandex.div.storage.analytics.CardErrorLoggerFactory.createContextualLogger.1
            @Override // com.yandex.div.json.ParsingErrorLogger
            public void logError(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                CardErrorTransformer.CardDetailedErrorException cardDetailedErrorException = new CardErrorTransformer.CardDetailedErrorException(cardId, e.getMessage(), e, null, null, groupId, metadata, 24, null);
                if (((CardErrorTransformer) this.errorTransformer.get()).tryTransformAndLog(cardDetailedErrorException)) {
                    return;
                }
                origin.logError(cardDetailedErrorException);
            }

            @Override // com.yandex.div.json.ParsingErrorLogger
            public void logTemplateError(Exception e, String templateId) {
                Intrinsics.checkNotNullParameter(e, "e");
                Intrinsics.checkNotNullParameter(templateId, "templateId");
                CardErrorTransformer.CardDetailedErrorException cardDetailedErrorException = new CardErrorTransformer.CardDetailedErrorException(cardId, e.getMessage(), e, templateId, null, groupId, metadata, 16, null);
                if (((CardErrorTransformer) this.errorTransformer.get()).tryTransformAndLog(cardDetailedErrorException)) {
                    return;
                }
                origin.logTemplateError(cardDetailedErrorException, templateId);
            }
        };
    }
}
