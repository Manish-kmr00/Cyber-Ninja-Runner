package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.text.Cue;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1851Qf implements InterfaceC1775Nb {
    public final long A00;

    @MetaExoPlayerCustomization("Oculus does not work well with Google Guava")
    public final List<C1853Qh> A01;
    public static final C1851Qf A03 = new C1851Qf(MetaExoPlayerCustomizedCollections.A01(), 0);
    public static final String A04 = AbstractC2471gE.A0h(0);
    public static final String A05 = AbstractC2471gE.A0h(1);
    public static final InterfaceC1774Na<C1851Qf> A02 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Qg
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return C1851Qf.A00(bundle);
        }
    };

    @MetaExoPlayerCustomization("Oculus does not work well with Google Guava")
    public C1851Qf(List<C1853Qh> list, long j) {
        this.A01 = MetaExoPlayerCustomizedCollections.A03((C1853Qh[]) list.toArray(new C1853Qh[0]));
        this.A00 = j;
    }

    public static final C1851Qf A00(Bundle bundle) {
        List listA01;
        List<Cue> cues = bundle.getParcelableArrayList(A04);
        if (cues == null) {
            listA01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            listA01 = C2394ey.A01(C1853Qh.A0I, cues);
        }
        return new C1851Qf(listA01, bundle.getLong(A05));
    }
}
