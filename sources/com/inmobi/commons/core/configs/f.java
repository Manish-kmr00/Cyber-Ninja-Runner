package com.inmobi.commons.core.configs;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.inmobi.media.A5;
import com.inmobi.media.Ab;
import com.inmobi.media.C3312b6;
import com.inmobi.media.C3610w6;
import com.inmobi.media.C3615wb;
import com.inmobi.media.C3629xb;
import com.inmobi.media.C3643yb;
import com.inmobi.media.C3657zb;
import com.inmobi.media.Ya;
import com.inmobi.media.Za;

/* JADX INFO: loaded from: classes8.dex */
public final class f {
    public static A5 a() {
        return new A5().a(new Za("carrierNames", SignalsConfig.NovatiqConfig.class), (Ya) new C3312b6(new C3615wb(), String.class)).a(new Za(SessionDescription.ATTR_CONTROL, SignalsConfig.SessionConfig.class), (Ya) new C3312b6(new C3629xb(), Integer.TYPE)).a(new Za("generalKeys", SignalsConfig.PublisherConfig.class), (Ya) new C3610w6(new C3643yb(), String.class)).a(new Za("adSpecificKeys", SignalsConfig.PublisherConfig.class), (Ya) new C3610w6(new C3657zb(), String.class)).a(new Za("versionList", SignalsConfig.Purchases.class), (Ya) new C3312b6(new Ab(), String.class));
    }
}
