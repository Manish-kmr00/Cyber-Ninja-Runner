package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;

/* JADX INFO: loaded from: classes5.dex */
public final class Jn implements Ra {
    @Override // io.appmetrica.analytics.impl.Ra
    public final String a(Context context) {
        IdentifiersResult identifiersResultQ = new Ke(C4135g7.a(context.getApplicationContext()).a()).q();
        if (TextUtils.isEmpty(identifiersResultQ.id)) {
            return null;
        }
        return identifiersResultQ.id;
    }
}
