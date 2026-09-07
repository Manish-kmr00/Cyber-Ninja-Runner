package com.yandex.div.core.view2.reuse;

import com.yandex.div.core.view2.logging.bind.ForceRebindReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComplexRebindReporter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/reuse/ComplexRebindReporter;", "Lcom/yandex/div/core/view2/logging/bind/ForceRebindReporter;", "onComplexRebindFatalNoState", "", "onComplexRebindNoDivInState", "onComplexRebindNoExistingParent", "onComplexRebindNothingToBind", "onComplexRebindSuccess", "onComplexRebindUnsupportedElementException", "e", "Lcom/yandex/div/core/view2/reuse/RebindTask$UnsupportedElementException;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ComplexRebindReporter extends ForceRebindReporter {
    default void onComplexRebindFatalNoState() {
    }

    default void onComplexRebindNoDivInState() {
    }

    default void onComplexRebindNoExistingParent() {
    }

    default void onComplexRebindNothingToBind() {
    }

    default void onComplexRebindSuccess() {
    }

    default void onComplexRebindUnsupportedElementException(RebindTask.UnsupportedElementException e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
