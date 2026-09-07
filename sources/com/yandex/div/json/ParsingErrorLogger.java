package com.yandex.div.json;

import com.yandex.div.internal.Assert;
import com.yandex.div.internal.Log;

/* JADX INFO: loaded from: classes7.dex */
public interface ParsingErrorLogger {
    public static final ParsingErrorLogger LOG = new ParsingErrorLogger() { // from class: com.yandex.div.json.ParsingErrorLogger$$ExternalSyntheticLambda0
        @Override // com.yandex.div.json.ParsingErrorLogger
        public final void logError(Exception exc) {
            ParsingErrorLogger.lambda$static$0(exc);
        }
    };
    public static final ParsingErrorLogger ASSERT = new ParsingErrorLogger() { // from class: com.yandex.div.json.ParsingErrorLogger$$ExternalSyntheticLambda1
        @Override // com.yandex.div.json.ParsingErrorLogger
        public final void logError(Exception exc) {
            ParsingErrorLogger.lambda$static$1(exc);
        }
    };

    void logError(Exception exc);

    static /* synthetic */ void lambda$static$0(Exception exc) {
        if (Log.isEnabled()) {
            Log.e("ParsingErrorLogger", "An error occurred during parsing process", exc);
        }
    }

    static /* synthetic */ void lambda$static$1(Exception exc) {
        if (Assert.isEnabled()) {
            Assert.fail(exc.getMessage(), exc);
        }
    }

    default void logTemplateError(Exception exc, String str) {
        logError(exc);
    }
}
