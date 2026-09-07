package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4611za extends M2 {
    public C4611za(int i) {
        super(i);
    }

    @Override // io.appmetrica.analytics.impl.M2, io.appmetrica.analytics.impl.Aa
    public final C4225jn a(String str) {
        int length = 0;
        if (str != null) {
            int length2 = str.length();
            int i = this.f11252a;
            if (length2 > i) {
                String strSubstring = str.substring(0, i);
                length = str.getBytes().length - strSubstring.getBytes().length;
                str = strSubstring;
            }
        }
        return new C4225jn(str, new C4479u3(length));
    }
}
