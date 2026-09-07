package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.j9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3427j9 extends Sc {
    public static final /* synthetic */ int h = 0;
    public final Tc e;
    public C3371f9 f;
    public final L4 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3427j9(r adContainer, Tc mViewableAd, C3371f9 c3371f9, L4 l4) {
        super(adContainer);
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        this.e = mViewableAd;
        this.f = c3371f9;
        this.g = l4;
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
            Intrinsics.checkNotNullExpressionValue("j9", "TAG");
            ((M4) l4).c("j9", "inflateView called");
        }
        return this.e.d();
    }

    @Override // com.inmobi.media.Tc
    public final void e() {
        try {
            try {
                L4 l4 = this.g;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("j9", "TAG");
                    ((M4) l4).a("j9", "stopTrackingForImpression");
                }
                C3371f9 c3371f9 = this.f;
                if (c3371f9 != null) {
                    c3371f9.a();
                }
            } catch (Exception e) {
                L4 l5 = this.g;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("j9", "TAG");
                    ((M4) l5).b("j9", "Exception in stopTrackingForImpression with message : " + e.getMessage());
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
        C3371f9 c3371f9 = this.f;
        if (c3371f9 != null) {
            c3371f9.a(childView, obstructionCode);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        C3371f9 c3371f9 = this.f;
        if (c3371f9 != null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            byte b = c3371f9.e;
            if (b > 0) {
                AdSession adSession = c3371f9.f;
                if (adSession != null) {
                    adSession.removeFriendlyObstruction(childView);
                    return;
                }
                return;
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: 1"));
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(HashMap map) {
        View view;
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("j9", "TAG");
            ((M4) l4).a("j9", "startTrackingForImpression");
        }
        try {
            try {
                if (this.d.getViewability().getOmidConfig().isOmidEnabled()) {
                    AbstractC3473m9.f3376a.getClass();
                    if (Omid.isActive()) {
                        r rVar = this.f3206a;
                        if (rVar instanceof C3313b7) {
                            C3313b7 c3313b7 = (C3313b7) rVar;
                            view = c3313b7.H;
                            if (view == null) {
                                view = c3313b7.I;
                            }
                        } else {
                            View viewB = this.e.b();
                            view = viewB instanceof WebView ? (WebView) viewB : null;
                        }
                        if (view != null) {
                            L4 l5 = this.g;
                            if (l5 != null) {
                                Intrinsics.checkNotNullExpressionValue("j9", "TAG");
                                ((M4) l5).a("j9", "creating OMSDK session");
                            }
                            C3371f9 c3371f9 = this.f;
                            if (c3371f9 != null) {
                                c3371f9.a(view, map, (View) null);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                L4 l6 = this.g;
                if (l6 != null) {
                    Intrinsics.checkNotNullExpressionValue("j9", "TAG");
                    ((M4) l6).b("j9", "Exception in startTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.a(map);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(byte b) {
        this.e.a(b);
    }

    @Override // com.inmobi.media.Tc
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e.a(context, b);
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        L4 l4 = this.g;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("j9", "TAG");
            ((M4) l4).c("j9", "destroy");
        }
        super.a();
        try {
            this.f = null;
        } catch (Exception e) {
            L4 l5 = this.g;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("j9", "TAG");
                ((M4) l5).a("j9", "Exception in destroy with message", e);
            }
        } finally {
            this.e.a();
        }
    }
}
