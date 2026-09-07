package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class Am implements Qn {
    @Override // io.appmetrica.analytics.impl.Qn
    public final byte[] a(R8 r8, C4045ch c4045ch) {
        return !TextUtils.isEmpty(r8.b) ? StringUtils.getUTF8Bytes(r8.b) : new byte[0];
    }
}
