package com.yandex.div.core.expression;

import com.yandex.div.json.ParsingException;
import com.yandex.div.json.ParsingExceptionReason;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionFallbacksHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0080\bø\u0001\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"suppressExpressionErrors", "", "block", "Lkotlin/Function0;", "isExpressionResolveFail", "", "Lcom/yandex/div/json/ParsingException;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ExpressionFallbacksHelperKt {
    public static final void suppressExpressionErrors(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke();
        } catch (ParsingException e) {
            if (!isExpressionResolveFail(e)) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isExpressionResolveFail(ParsingException parsingException) {
        return parsingException.getReason() == ParsingExceptionReason.MISSING_VARIABLE || parsingException.getReason() == ParsingExceptionReason.INVALID_VALUE || parsingException.getReason() == ParsingExceptionReason.TYPE_MISMATCH;
    }
}
