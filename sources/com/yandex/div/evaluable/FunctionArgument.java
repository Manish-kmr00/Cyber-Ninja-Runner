package com.yandex.div.evaluable;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionArgument.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/evaluable/FunctionArgument;", "", "type", "Lcom/yandex/div/evaluable/EvaluableType;", "isVariadic", "", "(Lcom/yandex/div/evaluable/EvaluableType;Z)V", "()Z", "getType", "()Lcom/yandex/div/evaluable/EvaluableType;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class FunctionArgument {
    private final boolean isVariadic;
    private final EvaluableType type;

    public static /* synthetic */ FunctionArgument copy$default(FunctionArgument functionArgument, EvaluableType evaluableType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            evaluableType = functionArgument.type;
        }
        if ((i & 2) != 0) {
            z = functionArgument.isVariadic;
        }
        return functionArgument.copy(evaluableType, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EvaluableType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsVariadic() {
        return this.isVariadic;
    }

    public final FunctionArgument copy(EvaluableType type, boolean isVariadic) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new FunctionArgument(type, isVariadic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionArgument)) {
            return false;
        }
        FunctionArgument functionArgument = (FunctionArgument) other;
        return this.type == functionArgument.type && this.isVariadic == functionArgument.isVariadic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        boolean z = this.isVariadic;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "FunctionArgument(type=" + this.type + ", isVariadic=" + this.isVariadic + ')';
    }

    public FunctionArgument(EvaluableType type, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.isVariadic = z;
    }

    public /* synthetic */ FunctionArgument(EvaluableType evaluableType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(evaluableType, (i & 2) != 0 ? false : z);
    }

    public final EvaluableType getType() {
        return this.type;
    }

    public final boolean isVariadic() {
        return this.isVariadic;
    }
}
