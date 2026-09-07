package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.Partner;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.n9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3487n9 extends AbstractC3473m9 {
    public Partner b = Partner.createPartner("Inmobi", "a" + StringsKt.replace$default("10.8.2", ".", "", false, 4, (Object) null));

    /* JADX WARN: Code duplicated, block: B:7:0x000e A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0013, B:7:0x000e), top: B:13:0x0002 }] */
    public final void a(AdConfig adConfig) {
        AdConfig.OmidConfig omidConfig;
        if (adConfig != null) {
            try {
                AdConfig.ViewabilityConfig viewability = adConfig.getViewability();
                if (viewability == null || (omidConfig = viewability.getOmidConfig()) == null) {
                    omidConfig = new AdConfig.OmidConfig();
                }
            } catch (Exception e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
                return;
            }
        } else {
            omidConfig = new AdConfig.OmidConfig();
        }
        this.b = Partner.createPartner(omidConfig.getPartnerKey(), "a" + StringsKt.replace$default("10.8.2", ".", "", false, 4, (Object) null));
        AbstractC3399h9.a(omidConfig);
    }
}
