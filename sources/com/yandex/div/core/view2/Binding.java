package com.yandex.div.core.view2;

import com.yandex.div.DivDataTag;
import com.yandex.div2.DivData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewBindingProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/view2/Binding;", "", "tag", "Lcom/yandex/div/DivDataTag;", "data", "Lcom/yandex/div2/DivData;", "(Lcom/yandex/div/DivDataTag;Lcom/yandex/div2/DivData;)V", "getData", "()Lcom/yandex/div2/DivData;", "getTag", "()Lcom/yandex/div/DivDataTag;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Binding {
    private final DivData data;
    private final DivDataTag tag;

    public Binding(DivDataTag tag, DivData divData) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.data = divData;
    }

    public final DivDataTag getTag() {
        return this.tag;
    }

    public final DivData getData() {
        return this.data;
    }
}
