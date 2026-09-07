package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class Rd implements Pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11329a;

    public Rd(String str) {
        this.f11329a = str;
    }

    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(String str) {
        return TextUtils.isEmpty(str) ? new Nn(this, false, this.f11329a + " is empty.") : new Nn(this, true, "");
    }
}
