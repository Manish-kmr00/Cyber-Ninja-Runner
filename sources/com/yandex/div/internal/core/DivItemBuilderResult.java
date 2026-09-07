package com.yandex.div.internal.core;

import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivItemBuilderResult.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/internal/core/DivItemBuilderResult;", "", "div", "Lcom/yandex/div2/Div;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div2/Div;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "getDiv", "()Lcom/yandex/div2/Div;", "getExpressionResolver", "()Lcom/yandex/div/json/expressions/ExpressionResolver;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class DivItemBuilderResult {
    private final Div div;
    private final ExpressionResolver expressionResolver;

    public static /* synthetic */ DivItemBuilderResult copy$default(DivItemBuilderResult divItemBuilderResult, Div div, ExpressionResolver expressionResolver, int i, Object obj) {
        if ((i & 1) != 0) {
            div = divItemBuilderResult.div;
        }
        if ((i & 2) != 0) {
            expressionResolver = divItemBuilderResult.expressionResolver;
        }
        return divItemBuilderResult.copy(div, expressionResolver);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Div getDiv() {
        return this.div;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ExpressionResolver getExpressionResolver() {
        return this.expressionResolver;
    }

    public final DivItemBuilderResult copy(Div div, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        return new DivItemBuilderResult(div, expressionResolver);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DivItemBuilderResult)) {
            return false;
        }
        DivItemBuilderResult divItemBuilderResult = (DivItemBuilderResult) other;
        return Intrinsics.areEqual(this.div, divItemBuilderResult.div) && Intrinsics.areEqual(this.expressionResolver, divItemBuilderResult.expressionResolver);
    }

    public int hashCode() {
        return (this.div.hashCode() * 31) + this.expressionResolver.hashCode();
    }

    public String toString() {
        return "DivItemBuilderResult(div=" + this.div + ", expressionResolver=" + this.expressionResolver + ')';
    }

    public DivItemBuilderResult(Div div, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        this.div = div;
        this.expressionResolver = expressionResolver;
    }

    public final Div getDiv() {
        return this.div;
    }

    public final ExpressionResolver getExpressionResolver() {
        return this.expressionResolver;
    }
}
