package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4512vb implements Pn {
    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(String str) {
        if (str == null) {
            return new Nn(this, false, "key is null");
        }
        if (str.startsWith("appmetrica")) {
            return new Nn(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new Nn(this, false, "key length more then 200 characters");
        }
        return new Nn(this, true, "");
    }
}
