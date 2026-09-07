package com.yandex.div.storage.analytics;

import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.json.ParsingErrorLogger;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionReason;
import com.yandex.div.storage.templates.TemplatesContainer;
import com.yandex.div.storage.util.CardErrorTransformer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TemplateCardErrorTransformer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/storage/analytics/TemplateCardErrorTransformer;", "Lcom/yandex/div/storage/util/CardErrorTransformer;", "templateContainer", "Lcom/yandex/div/storage/templates/TemplatesContainer;", "internalLogger", "Lcom/yandex/div/json/ParsingErrorLogger;", "(Lcom/yandex/div/storage/templates/TemplatesContainer;Lcom/yandex/div/json/ParsingErrorLogger;)V", "tryTransformAndLog", "", "cardError", "Lcom/yandex/div/storage/util/CardErrorTransformer$CardDetailedErrorException;", "Companion", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class TemplateCardErrorTransformer implements CardErrorTransformer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ParsingErrorLogger internalLogger;
    private final TemplatesContainer templateContainer;

    public TemplateCardErrorTransformer(TemplatesContainer templateContainer, ParsingErrorLogger internalLogger) {
        Intrinsics.checkNotNullParameter(templateContainer, "templateContainer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.templateContainer = templateContainer;
        this.internalLogger = internalLogger;
    }

    @Override // com.yandex.div.storage.util.CardErrorTransformer
    public boolean tryTransformAndLog(CardErrorTransformer.CardDetailedErrorException cardError) {
        Intrinsics.checkNotNullParameter(cardError, "cardError");
        CardErrorTransformer.CardDetailedErrorException cardDetailedErrorException = cardError;
        ParsingException parsingExceptionExtractMissingTemplateException$div_storage_release = INSTANCE.extractMissingTemplateException$div_storage_release(cardDetailedErrorException);
        if (parsingExceptionExtractMissingTemplateException$div_storage_release == null) {
            return false;
        }
        String templateName = TemplateCardErrorTransformerKt.getTemplateName(parsingExceptionExtractMissingTemplateException$div_storage_release);
        if (templateName == null) {
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Failed to parse template name from '" + parsingExceptionExtractMissingTemplateException$div_storage_release.getMessage() + '\'');
            }
            return false;
        }
        String cardId = cardError.getCardId();
        ErrorExplanation errorExplanationExplainMissingTemplate = this.templateContainer.explainMissingTemplate(cardId, cardError.getGroupId(), templateName);
        this.internalLogger.logError(new CardErrorTransformer.CardDetailedErrorException(cardId, "missing template = " + templateName + ", reason = " + errorExplanationExplainMissingTemplate.getShortReason(), cardDetailedErrorException, cardId, errorExplanationExplainMissingTemplate.getAllDetails(), cardError.getGroupId(), cardError.getMetadata()));
        return true;
    }

    /* JADX INFO: compiled from: TemplateCardErrorTransformer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/yandex/div/storage/analytics/TemplateCardErrorTransformer$Companion;", "", "()V", "extractMissingTemplateException", "Lcom/yandex/div/json/ParsingException;", "cardError", "", "extractMissingTemplateException$div_storage_release", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ParsingException extractMissingTemplateException$div_storage_release(Throwable cardError) {
            Intrinsics.checkNotNullParameter(cardError, "cardError");
            if (!(cardError instanceof ParsingException)) {
                Throwable cause = cardError.getCause();
                if (cause == null) {
                    return null;
                }
                return extractMissingTemplateException$div_storage_release(cause);
            }
            ParsingException parsingException = (ParsingException) cardError;
            if (parsingException.getReason() == ParsingExceptionReason.MISSING_TEMPLATE) {
                return parsingException;
            }
            Throwable cause2 = cardError.getCause();
            if (cause2 == null) {
                return null;
            }
            return extractMissingTemplateException$div_storage_release(cause2);
        }
    }
}
