package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.cd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4041cd extends N2 {
    public final String b;

    public C4041cd(String str, Wk wk) {
        super(wk);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.N2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
