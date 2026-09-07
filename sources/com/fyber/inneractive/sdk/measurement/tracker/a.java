package com.fyber.inneractive.sdk.measurement.tracker;

import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.C3274m;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends f {
    public a(Partner partner, C3274m c3274m, x xVar) {
        super(partner, c3274m, xVar);
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final void a(C3274m c3274m) {
        super.a(c3274m);
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(this.f1866a);
        this.b = adEventsCreateAdEvents;
        adEventsCreateAdEvents.loaded();
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final AdSessionConfiguration b() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.UNSPECIFIED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final void c() {
        AdEvents adEvents;
        if (this.d || this.f1866a == null || (adEvents = this.b) == null) {
            return;
        }
        this.d = true;
        try {
            adEvents.impressionOccurred();
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final void a() {
        IAlog.f("%s Unsupported functionality for non video MRAID ads", IAlog.a(this));
    }
}
