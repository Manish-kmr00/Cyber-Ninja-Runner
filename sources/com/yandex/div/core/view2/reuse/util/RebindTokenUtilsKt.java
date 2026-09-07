package com.yandex.div.core.view2.reuse.util;

import com.yandex.div.core.view2.reuse.ExistingToken;
import com.yandex.div.core.view2.reuse.NewToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RebindTokenUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"combineTokens", "Lcom/yandex/div/core/view2/reuse/ExistingToken;", "existingToken", "newToken", "Lcom/yandex/div/core/view2/reuse/NewToken;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RebindTokenUtilsKt {
    public static final ExistingToken combineTokens(ExistingToken existingToken, NewToken newToken) {
        Intrinsics.checkNotNullParameter(existingToken, "existingToken");
        Intrinsics.checkNotNullParameter(newToken, "newToken");
        return new ExistingToken(newToken.getItem(), newToken.getChildIndex(), existingToken.getView(), existingToken.getParentToken());
    }
}
