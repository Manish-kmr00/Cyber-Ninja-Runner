package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W4 extends Tc {
    public final Uc e;
    public final C3380g4 f;
    public final L4 g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W4(Ba container, Uc mViewableAd, C3380g4 htmlAdTracker, L4 l4) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        Intrinsics.checkNotNullParameter(htmlAdTracker, "htmlAdTracker");
        this.e = mViewableAd;
        this.f = htmlAdTracker;
        this.g = l4;
        this.h = "W4";
    }

    @Override // com.inmobi.media.Tc
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewB = this.e.b();
        if (viewB != null) {
            this.f.a(viewB);
            this.f.b(viewB);
        }
        Uc uc = this.e;
        uc.getClass();
        Intrinsics.checkNotNullParameter(parent, "parent");
        return uc.d();
    }

    @Override // com.inmobi.media.Tc
    public final void a(byte b) {
    }

    @Override // com.inmobi.media.Tc
    public final View b() {
        return this.e.b();
    }

    @Override // com.inmobi.media.Tc
    public final F7 c() {
        return this.e.b;
    }

    @Override // com.inmobi.media.Tc
    public final View d() {
        return this.e.d();
    }

    @Override // com.inmobi.media.Tc
    public final void e() {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "stopTrackingForImpression");
        }
        View viewB = this.e.b();
        if (viewB != null) {
            this.f.a(viewB);
            this.e.getClass();
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(HashMap map) {
        L4 l4 = this.g;
        if (l4 != null) {
            String str = this.h;
            ((M4) l4).a(str, O5.a(str, "TAG", "startTrackingForImpression with ").append(map != null ? Integer.valueOf(map.size()) : null).append(" friendly views").toString());
        }
        View token = this.e.b();
        if (token != null) {
            L4 l5 = this.g;
            if (l5 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l5).a(TAG, "start tracking");
            }
            AdConfig.ViewabilityConfig config = this.d.getViewability();
            r rVar = this.f3206a;
            Intrinsics.checkNotNull(rVar, "null cannot be cast to non-null type com.inmobi.ads.containers.RenderView");
            Ba ba = (Ba) rVar;
            ba.setFriendlyViews(map);
            C3380g4 c3380g4 = this.f;
            c3380g4.getClass();
            Intrinsics.checkNotNullParameter(token, "view");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(config, "viewabilityConfig");
            L4 l6 = c3380g4.f;
            if (l6 != null) {
                ((M4) l6).c("HtmlAdTracker", "startTrackingForImpression");
            }
            if (c3380g4.f3324a == 0) {
                L4 l7 = c3380g4.f;
                if (l7 != null) {
                    ((M4) l7).b("HtmlAdTracker", "impression type is loaded. return");
                }
            } else if (!Intrinsics.areEqual(c3380g4.b, "video") && !Intrinsics.areEqual(c3380g4.b, "audio")) {
                byte b = c3380g4.f3324a;
                C3552s4 c3552s4 = c3380g4.g;
                if (c3552s4 == null) {
                    L4 l8 = c3380g4.f;
                    if (l8 != null) {
                        ((M4) l8).c("HtmlAdTracker", "creating Visibility Tracker for " + ((int) b));
                    }
                    C3422j4 c3422j4 = new C3422j4(config, b, c3380g4.f);
                    L4 l9 = c3380g4.f;
                    if (l9 != null) {
                        ((M4) l9).c("HtmlAdTracker", "creating Impression Tracker for " + ((int) b));
                    }
                    C3552s4 c3552s5 = new C3552s4(config, c3422j4, c3380g4.j);
                    c3380g4.g = c3552s5;
                    c3552s4 = c3552s5;
                }
                L4 l10 = c3380g4.f;
                if (l10 != null) {
                    ((M4) l10).c("HtmlAdTracker", "impression tracker add view");
                }
                c3552s4.a(token, token, c3380g4.d, c3380g4.c);
            } else {
                L4 l11 = c3380g4.f;
                if (l11 != null) {
                    ((M4) l11).b("HtmlAdTracker", "creative type is video and audio. return");
                }
            }
            C3380g4 c3380g5 = this.f;
            Yc listener = ba.getVISIBILITY_CHANGE_LISTENER();
            c3380g5.getClass();
            Intrinsics.checkNotNullParameter(token, "view");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(config, "config");
            L4 l12 = c3380g5.f;
            if (l12 != null) {
                ((M4) l12).c("HtmlAdTracker", "startTrackingForVisibility");
            }
            C3422j4 c3422j5 = c3380g5.h;
            if (c3422j5 == null) {
                c3422j5 = new C3422j4(config, (byte) 1, c3380g5.f);
                C3366f4 c3366f4 = new C3366f4(c3380g5);
                L4 l13 = c3422j5.e;
                if (l13 != null) {
                    ((M4) l13).c(VisibilityTracker.TAG, "setVisibilityTrackerListener logger");
                }
                c3422j5.j = c3366f4;
                c3380g5.h = c3422j5;
            }
            c3380g5.i.put(token, listener);
            c3422j5.a(token, token, c3380g5.e);
            this.e.getClass();
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        this.e.getClass();
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        this.e.getClass();
        Intrinsics.checkNotNullParameter(childView, "childView");
    }

    @Override // com.inmobi.media.Tc
    public final void a(Context context, byte b) {
        Uc uc;
        Intrinsics.checkNotNullParameter(context, "context");
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "onActivityStateChanged - state - " + ((int) b));
        }
        try {
            if (b == 0) {
                this.f.a();
            } else if (b == 1) {
                this.f.b();
            } else if (b == 2) {
                C3380g4 c3380g4 = this.f;
                L4 l5 = c3380g4.f;
                if (l5 != null) {
                    ((M4) l5).c("HtmlAdTracker", "onActivityDestroyed");
                }
                C3552s4 c3552s4 = c3380g4.g;
                if (c3552s4 != null) {
                    c3552s4.f3424a.clear();
                    c3552s4.b.clear();
                    c3552s4.c.a();
                    c3552s4.e.removeMessages(0);
                    c3552s4.c.b();
                }
                c3380g4.g = null;
                C3422j4 c3422j4 = c3380g4.h;
                if (c3422j4 != null) {
                    c3422j4.b();
                }
                c3380g4.h = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(this.h, "TAG");
            }
            uc = this.e;
        } catch (Exception e) {
            L4 l6 = this.g;
            if (l6 != null) {
                String TAG2 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l6).b(TAG2, "Exception in onActivityStateChanged with message : " + e.getMessage());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            uc = this.e;
        } finally {
            this.e.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
        }
        uc.getClass();
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "destroy");
        }
        View viewB = this.e.b();
        if (viewB != null) {
            this.f.a(viewB);
            this.f.b(viewB);
        }
        super.a();
        this.e.a();
    }
}
