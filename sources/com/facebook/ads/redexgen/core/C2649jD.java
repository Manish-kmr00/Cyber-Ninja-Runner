package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2649jD implements ViewpointAction<C14569t, C14619y> {
    public C2646jA A00;

    public C2649jD(C2646jA c2646jA) {
        this.A00 = c2646jA;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oc != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.facebook.ads.redexgen.core.ViewpointAction
    public final void A6H(C2959oc<C14569t, C14619y> c2959oc, InterfaceC2949oP interfaceC2949oP) {
        switch (interfaceC2949oP.A9K(c2959oc)) {
            case A02:
            case A04:
                this.A00.A02(c2959oc, interfaceC2949oP);
                break;
        }
    }
}
