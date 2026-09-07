package com.yandex.div.core.expression.variables;

import android.net.Uri;
import com.yandex.div.evaluable.types.Url;
import kotlin.Metadata;

/* JADX INFO: compiled from: VariableController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0002"}, d2 = {"wrapVariableValue", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class VariableControllerKt {
    public static final Object wrapVariableValue(Object obj) {
        return obj instanceof Uri ? Url.m6229boximpl(Url.m6230constructorimpl(obj.toString())) : obj;
    }
}
