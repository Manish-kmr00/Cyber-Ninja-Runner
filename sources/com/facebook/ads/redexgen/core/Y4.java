package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Tracks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y4 implements InterfaceC1775Nb {

    @MetaExoPlayerCustomization("Remove Immutable List for Oculus")
    public final List<Y5> A00;
    public static final Y4 A02 = new Y4(new ArrayList());
    public static final String A03 = AbstractC2471gE.A0h(0);
    public static final InterfaceC1774Na<Y4> A01 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Y9
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return Y4.A00(bundle);
        }
    };

    public Y4(List<Y5> list) {
        this.A00 = MetaExoPlayerCustomizedCollections.A03((Y5[]) list.toArray(new Y5[0]));
    }

    public static /* synthetic */ Y4 A00(Bundle bundle) {
        List<Tracks.Group> groups;
        List<Tracks.Group> groups2 = bundle.getParcelableArrayList(A03);
        if (groups2 == null) {
            groups = Collections.emptyList();
        } else {
            groups = C2394ey.A01(Y5.A06, groups2);
        }
        return new Y4(groups);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.A00.equals(((Y4) obj).A00);
    }

    public final int hashCode() {
        return this.A00.hashCode();
    }
}
