package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Op, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1811Op implements InterfaceC2595iJ {
    public final /* synthetic */ AbstractC1814Os A00;

    public C1811Op(final AbstractC1814Os val$separatorMatcher) {
        this.A00 = val$separatorMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.4a] */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2595iJ
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C13124a AAa(final C2596iK splitter, final CharSequence toSplit) {
        return new Oo(splitter, toSplit) { // from class: com.facebook.ads.redexgen.X.4a
            @Override // com.facebook.ads.redexgen.core.Oo
            public final int A04(int separatorPosition) {
                return separatorPosition + 1;
            }

            @Override // com.facebook.ads.redexgen.core.Oo
            public final int A05(int start) {
                return this.A00.A00.A08(this.A03, start);
            }
        };
    }
}
