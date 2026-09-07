package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PH {
    public Uri A00;
    public ZC A04;
    public Object A05;
    public String A06;
    public String A07;
    public String A08;
    public PI A01 = new PI();
    public PK A02 = new PK();
    public List<StreamKey> A09 = Collections.emptyList();
    public List<MediaItem.SubtitleConfiguration> A0A = Collections.emptyList();
    public PN A03 = new PN();

    public final PH A00(Uri uri) {
        this.A00 = uri;
        return this;
    }

    public final PH A01(Object obj) {
        this.A05 = obj;
        return this;
    }

    public final PH A02(String str) {
        this.A06 = str;
        return this;
    }

    public final PH A03(String str) {
        this.A07 = (String) AbstractC2388es.A01(str);
        return this;
    }

    public final PH A04(List<StreamKey> streamKeys) {
        List<StreamKey> listEmptyList;
        if (streamKeys != null && !streamKeys.isEmpty()) {
            listEmptyList = Collections.unmodifiableList(new ArrayList(streamKeys));
        } else {
            listEmptyList = Collections.emptyList();
        }
        this.A09 = listEmptyList;
        return this;
    }

    public final ZE A05() {
        AbstractC2388es.A08(this.A02.A00 == null || this.A02.A03 != null);
        ZF zf = null;
        Uri uri = this.A00;
        if (uri != null) {
            zf = new ZF(uri, this.A08, this.A02.A03 != null ? this.A02.A08() : null, null, this.A09, this.A06, this.A0A, this.A05);
        }
        return new ZE(this.A07 != null ? this.A07 : "", this.A01.A0B(), zf, this.A03.A05(), this.A04 != null ? this.A04 : ZC.A0Z);
    }
}
