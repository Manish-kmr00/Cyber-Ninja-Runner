package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdEvents;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.k9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3441k9 extends Sc {
    public final Sc e;
    public C3371f9 f;
    public final L4 g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3441k9(C3313b7 adContainer, Sc mViewableAd, C3371f9 c3371f9, L4 l4) {
        super(adContainer);
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        this.e = mViewableAd;
        this.f = c3371f9;
        this.g = l4;
        this.h = "k9";
    }

    @Override // com.inmobi.media.Tc
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.e.a(view, parent, z);
    }

    @Override // com.inmobi.media.Tc
    public final View b() {
        return this.e.b();
    }

    @Override // com.inmobi.media.Tc
    public final View d() {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "inflateView");
        }
        return this.e.d();
    }

    @Override // com.inmobi.media.Tc
    public final void e() {
        try {
            try {
                L4 l4 = this.g;
                if (l4 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).c(TAG, "stopTrackingForImpression");
                }
                C3371f9 c3371f9 = this.f;
                if (c3371f9 != null) {
                    c3371f9.a();
                }
            } catch (Exception e) {
                L4 l5 = this.g;
                if (l5 != null) {
                    String TAG2 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).b(TAG2, "Exception in stopTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.e();
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        this.e.a(childView, obstructionCode);
    }

    public final void b(HashMap map) {
        View viewG;
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "registerView");
        }
        r rVar = this.f3206a;
        if (!(rVar instanceof C3313b7) || (viewG = ((C3313b7) rVar).g()) == null) {
            return;
        }
        L4 l5 = this.g;
        if (l5 != null) {
            String TAG2 = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).a(TAG2, "creating AD session");
        }
        C3371f9 c3371f9 = this.f;
        if (c3371f9 != null) {
            c3371f9.a(viewG, map, this.e.b());
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        this.e.a(childView);
    }

    @Override // com.inmobi.media.Tc
    public final void a(HashMap map) {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "startTrackingForImpression");
        }
        try {
            try {
                if (this.d.getViewability().getOmidConfig().isOmidEnabled()) {
                    AbstractC3473m9.f3376a.getClass();
                    if (Omid.isActive()) {
                        L4 l5 = this.g;
                        if (l5 != null) {
                            String TAG2 = this.h;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((M4) l5).a(TAG2, "OMID enabled and initialised");
                        }
                        b(map);
                        a((byte) 19);
                    }
                }
            } catch (Exception e) {
                L4 l6 = this.g;
                if (l6 != null) {
                    String TAG3 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l6).b(TAG3, "Exception in startTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.a(map);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(byte b) {
        C3546s c3546s;
        AdEvents adEvents;
        AdEvents adEvents2;
        try {
            try {
                L4 l4 = this.g;
                if (l4 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((M4) l4).c(TAG, "onAdEvent - event - " + ((int) b));
                }
                C3371f9 c3371f9 = this.f;
                if (c3371f9 != null && C3371f9.a(c3371f9.e, (byte) 2)) {
                    byte b2 = b;
                    if (b2 == 0) {
                        C3546s c3546s2 = c3371f9.g;
                        if (c3546s2 != null && (adEvents2 = c3546s2.f3421a) != null) {
                            adEvents2.impressionOccurred();
                        }
                    } else if (b2 == 19 && (c3546s = c3371f9.g) != null && (adEvents = c3546s.f3421a) != null) {
                        adEvents.loaded();
                    }
                }
            } catch (Exception e) {
                L4 l5 = this.g;
                if (l5 != null) {
                    String TAG2 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).b(TAG2, "Exception in onAdEvent with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.a(b);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e.a(context, b);
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        super.a();
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "destroy");
        }
        try {
            this.f = null;
        } catch (Exception e) {
            L4 l5 = this.g;
            if (l5 != null) {
                String TAG2 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).b(TAG2, "Exception in destroy with message : " + e.getMessage());
            }
        } finally {
            this.e.a();
        }
    }
}
