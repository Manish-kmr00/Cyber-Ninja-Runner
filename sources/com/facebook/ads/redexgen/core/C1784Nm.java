package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1784Nm implements InterfaceC2966ol {
    public final List<InterfaceC2967om> A00 = new ArrayList();

    @Override // com.facebook.ads.redexgen.core.InterfaceC2966ol
    public final InterfaceC2967om A6Y(int i) {
        this.A00.get(i);
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<InterfaceC2967om> iterator() {
        return this.A00.iterator();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2966ol
    public final int size() {
        return this.A00.size();
    }
}
