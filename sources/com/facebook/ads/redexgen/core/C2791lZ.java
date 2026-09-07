package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2791lZ implements InterfaceC12983m {
    public final SharedPreferences A00;

    public C2791lZ(SharedPreferences sharedPreferences) {
        this.A00 = sharedPreferences;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12983m
    public final C2792la A68() {
        return new C2792la(this.A00.edit());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12983m
    public final long A8G(String str, long j) {
        return this.A00.getLong(str, j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12983m
    public final String A94(String str, String str2) {
        return this.A00.getString(str, str2);
    }
}
