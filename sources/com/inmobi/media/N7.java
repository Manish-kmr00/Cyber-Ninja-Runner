package com.inmobi.media;

/* JADX INFO: loaded from: classes5.dex */
public abstract class N7 {
    public static O7 a() {
        synchronized (O7.d) {
            O7 o7 = O7.e;
            if (o7 == null) {
                return new O7();
            }
            O7.e = o7.c;
            o7.c = null;
            O7.f--;
            return o7;
        }
    }
}
