package com.yandex.div.core.view2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompositeLogId.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"compositeLogIdOf", "Lcom/yandex/div/core/view2/CompositeLogId;", "scope", "Lcom/yandex/div/core/view2/Div2View;", "actionLogId", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CompositeLogIdKt {
    public static final CompositeLogId compositeLogIdOf(Div2View scope, String actionLogId) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(actionLogId, "actionLogId");
        String id = scope.getDataTag().getId();
        Intrinsics.checkNotNullExpressionValue(id, "scope.dataTag.id");
        return new CompositeLogId(id, scope.getLogId(), actionLogId);
    }
}
