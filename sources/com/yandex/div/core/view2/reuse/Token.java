package com.yandex.div.core.view2.reuse;

import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div2.Div;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/view2/reuse/Token;", "", "item", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "childIndex", "", "(Lcom/yandex/div/internal/core/DivItemBuilderResult;I)V", "getChildIndex", "()I", "div", "Lcom/yandex/div2/Div;", "getDiv", "()Lcom/yandex/div2/Div;", "divHash", "getDivHash", "getItem", "()Lcom/yandex/div/internal/core/DivItemBuilderResult;", "isCombinable", "", "other", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Token {
    private final int childIndex;
    private final Div div;
    private final int divHash;
    private final DivItemBuilderResult item;

    public Token(DivItemBuilderResult item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.childIndex = i;
        this.divHash = item.getDiv().propertiesHash();
        this.div = item.getDiv();
    }

    public final DivItemBuilderResult getItem() {
        return this.item;
    }

    public final int getChildIndex() {
        return this.childIndex;
    }

    public final int getDivHash() {
        return this.divHash;
    }

    public final Div getDiv() {
        return this.div;
    }

    public final boolean isCombinable(Token other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.divHash == other.divHash && Intrinsics.areEqual(DivUtilKt.getType(this.div), DivUtilKt.getType(other.div));
    }
}
