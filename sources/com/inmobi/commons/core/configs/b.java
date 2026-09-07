package com.inmobi.commons.core.configs;

import com.inmobi.media.A5;
import com.inmobi.media.C3312b6;
import com.inmobi.media.C3477n;
import com.inmobi.media.C3491o;
import com.inmobi.media.C3505p;
import com.inmobi.media.C3610w6;
import com.inmobi.media.Ya;
import com.inmobi.media.Za;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static A5 a() {
        return new A5().a(new Za(Reporting.EventType.CACHE, AdConfig.class), (Ya) new C3610w6(new a(), AdConfig.CacheConfig.class)).a(new Za("allowedContentType", AdConfig.VastVideoConfig.class), (Ya) new C3312b6(new C3477n(), String.class)).a(new Za("gestures", AdConfig.RenderingConfig.class), (Ya) new C3312b6(new C3491o(), Integer.TYPE)).a(new Za("skipFields", AdConfig.ContextualDataConfig.class), (Ya) new C3312b6(new C3505p(), String.class));
    }
}
