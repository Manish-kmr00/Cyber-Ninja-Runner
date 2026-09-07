package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2941oH {
    public static C2941oH A03 = null;
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C2951oR A02;

    public C2941oH(ViewpointQeConfig viewpointQeConfig, AbstractC2957oa abstractC2957oa, C2951oR c2951oR, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c2951oR;
        abstractC2957oa.A02(new C1779Nf(c2951oR));
    }

    public static C2941oH A00(ViewpointQeConfig viewpointQeConfig, AbstractC2957oa abstractC2957oa, InterfaceC2962of interfaceC2962of, InterfaceC1780Nh interfaceC1780Nh) {
        C2941oH localsTestInstance = A03;
        if (localsTestInstance != null) {
            return localsTestInstance;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        return new C2941oH(viewpointQeConfig, abstractC2957oa, new C2951oR(viewpointQeConfig, interfaceC2962of, C2102a9.A00, interfaceC1780Nh, viewpointRegistry, new Handler(Looper.getMainLooper())), viewpointRegistry);
    }

    public final void A01(InterfaceC2956oZ interfaceC2956oZ) {
        this.A02.A0E(interfaceC2956oZ);
    }

    public final void A02(InterfaceC2953oW interfaceC2953oW) {
        this.A02.A0F(interfaceC2953oW);
    }

    public final void A03(DspViewableNode dspViewableNode) {
        A04(dspViewableNode, null);
    }

    public final void A04(DspViewableNode dspViewableNode, C2963oi c2963oi) {
        if (this.A00.A00 && c2963oi != null) {
            this.A01.A06(dspViewableNode, c2963oi);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A05(DspViewableNode dspViewableNode, C2963oi c2963oi, C2959oc c2959oc) {
        if (this.A00.A00 && c2963oi != null) {
            this.A01.A07(dspViewableNode, c2963oi, c2959oc);
        } else {
            this.A01.A08(dspViewableNode, c2959oc);
        }
    }

    public final void A06(DspViewableNode dspViewableNode, C2959oc c2959oc) {
        A05(dspViewableNode, null, c2959oc);
    }
}
