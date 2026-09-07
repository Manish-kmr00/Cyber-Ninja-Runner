package com.yandex.div.evaluable.function;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.yandex.div.evaluable.Evaluable;
import com.yandex.div.evaluable.EvaluationContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: StringFunctions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"buildRepeatableString", "", "evaluationContext", "Lcom/yandex/div/evaluable/EvaluationContext;", "expressionContext", "Lcom/yandex/div/evaluable/ExpressionContext;", SessionDescription.ATTR_LENGTH, "", "repeatable", "buildRepeatableString-zb-MA7A", "(Lcom/yandex/div/evaluable/EvaluationContext;Lcom/yandex/div/evaluable/Evaluable;ILjava/lang/String;)Ljava/lang/String;", "div-evaluable"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StringFunctionsKt {
    /* JADX INFO: renamed from: buildRepeatableString-zb-MA7A, reason: not valid java name */
    public static final String m6183buildRepeatableStringzbMA7A(EvaluationContext evaluationContext, Evaluable expressionContext, int i, String repeatable) {
        Intrinsics.checkNotNullParameter(evaluationContext, "evaluationContext");
        Intrinsics.checkNotNullParameter(expressionContext, "expressionContext");
        Intrinsics.checkNotNullParameter(repeatable, "repeatable");
        String str = repeatable;
        if (str.length() == 0 || i <= 0) {
            if (str.length() == 0) {
                evaluationContext.getWarningSender().mo6114sendBIH1yYw(expressionContext, "String for padding is empty.");
                return "";
            }
            return "";
        }
        StringBuilder sb = new StringBuilder(i);
        Iterator<Integer> it = RangesKt.until(0, i).iterator();
        while (it.hasNext()) {
            sb.append(repeatable.charAt(((IntIterator) it).nextInt() % repeatable.length()));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }
}
