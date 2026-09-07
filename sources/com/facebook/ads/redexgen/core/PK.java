package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PK {
    public Uri A00;
    public List<Integer> A01;
    public Map<String, String> A02;
    public UUID A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public byte[] A07;

    @Deprecated
    public PK() {
        this.A02 = Collections.emptyMap();
        this.A01 = Collections.emptyList();
    }

    public final PL A08() {
        return new PL(this);
    }
}
