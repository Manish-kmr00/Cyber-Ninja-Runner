package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class On implements Pn {
    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(List<Nn> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (Nn nn : list) {
            if (!nn.f11273a) {
                linkedList.add(nn.b);
                z = false;
            }
        }
        return z ? new Nn(this, true, "") : new Nn(this, false, TextUtils.join(", ", linkedList));
    }
}
