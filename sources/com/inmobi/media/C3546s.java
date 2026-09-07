package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.media.MediaEvents;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3546s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdEvents f3421a;
    public final MediaEvents b;

    public C3546s(AdSession adSession, String str) {
        Intrinsics.checkNotNullParameter(adSession, "adSession");
        if (!Intrinsics.areEqual(str, "native_video_ad")) {
            this.f3421a = AdEvents.createAdEvents(adSession);
        } else {
            this.b = MediaEvents.createMediaEvents(adSession);
            this.f3421a = AdEvents.createAdEvents(adSession);
        }
    }
}
