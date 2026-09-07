package com.yandex.div.evaluable;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpressionContext.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/evaluable/ExpressionContext;", "", "evaluable", "Lcom/yandex/div/evaluable/Evaluable;", "constructor-impl", "(Lcom/yandex/div/evaluable/Evaluable;)Lcom/yandex/div/evaluable/Evaluable;", "getEvaluable", "()Lcom/yandex/div/evaluable/Evaluable;", "equals", "", "other", "equals-impl", "(Lcom/yandex/div/evaluable/Evaluable;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/yandex/div/evaluable/Evaluable;)I", "toString", "", "toString-impl", "(Lcom/yandex/div/evaluable/Evaluable;)Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
@JvmInline
public final class ExpressionContext {
    private final Evaluable evaluable;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ExpressionContext m6167boximpl(Evaluable evaluable) {
        return new ExpressionContext(evaluable);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Evaluable m6168constructorimpl(Evaluable evaluable) {
        Intrinsics.checkNotNullParameter(evaluable, "evaluable");
        return evaluable;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6169equalsimpl(Evaluable evaluable, Object obj) {
        return (obj instanceof ExpressionContext) && Intrinsics.areEqual(evaluable, ((ExpressionContext) obj).m6173unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6170equalsimpl0(Evaluable evaluable, Evaluable evaluable2) {
        return Intrinsics.areEqual(evaluable, evaluable2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6171hashCodeimpl(Evaluable evaluable) {
        return evaluable.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6172toStringimpl(Evaluable evaluable) {
        return "ExpressionContext(evaluable=" + evaluable + ')';
    }

    public boolean equals(Object obj) {
        return m6169equalsimpl(this.evaluable, obj);
    }

    public int hashCode() {
        return m6171hashCodeimpl(this.evaluable);
    }

    public String toString() {
        return m6172toStringimpl(this.evaluable);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Evaluable m6173unboximpl() {
        return this.evaluable;
    }

    private /* synthetic */ ExpressionContext(Evaluable evaluable) {
        this.evaluable = evaluable;
    }

    public final Evaluable getEvaluable() {
        return this.evaluable;
    }
}
