package com.facebook.ads.redexgen.core;

import android.media.Spatializer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2271cy implements Spatializer.OnSpatializerStateChangedListener {
    public final /* synthetic */ C2272cz A00;
    public final /* synthetic */ C13555u A01;

    public C2271cy(C2272cz c2272cz, C13555u c13555u) {
        this.A00 = c2272cz;
        this.A01 = c13555u;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }
}
