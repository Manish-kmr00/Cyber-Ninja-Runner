package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Lb implements InterfaceC4304n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D4 f11241a;

    public Lb(D4 d4) {
        this.f11241a = d4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4304n2
    public final Cn a(An an, Cn cn) {
        int i = an.b;
        int i2 = this.f11241a.f11100a;
        if (i == i2) {
            if (((Cn) ((HashMap) an.f11064a.get(cn.b)).get(new String(cn.f11094a))) != null) {
                ((HashMap) an.f11064a.get(cn.b)).put(new String(cn.f11094a), cn);
            }
        } else if (i < i2) {
            ((HashMap) an.f11064a.get(cn.b)).put(new String(cn.f11094a), cn);
            an.b++;
        }
        return cn;
    }
}
