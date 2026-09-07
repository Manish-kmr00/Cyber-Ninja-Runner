package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Y4 extends Sc {
    public final C3398h8 e;
    public final Wc f;
    public final L4 g;
    public final String h;
    public final WeakReference i;
    public final C3397h7 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y4(C3398h8 mAdContainer, Wc mViewableAd, L4 l4) {
        super(mAdContainer);
        Intrinsics.checkNotNullParameter(mAdContainer, "mAdContainer");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        this.e = mAdContainer;
        this.f = mViewableAd;
        this.g = l4;
        this.h = "Y4";
        this.i = new WeakReference(mAdContainer.j());
        this.j = new C3397h7((byte) 0, l4);
    }

    @Override // com.inmobi.media.Tc
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "inflate view");
        }
        View viewB = this.f.b();
        Context context = (Context) this.i.get();
        if (viewB != null && context != null) {
            this.j.a(context, viewB, this.e);
        }
        return this.f.a(view, parent, z);
    }

    @Override // com.inmobi.media.Tc
    public final View b() {
        return this.f.b();
    }

    @Override // com.inmobi.media.Tc
    public final F7 c() {
        return this.f.b;
    }

    @Override // com.inmobi.media.Tc
    public final void e() {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "stop tracking for impression");
        }
        try {
            Context context = (Context) this.i.get();
            if (context != null && !this.e.t) {
                L4 l5 = this.g;
                if (l5 != null) {
                    String TAG2 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).a(TAG2, "stop tracking");
                }
                this.j.a(context, this.e);
            }
        } catch (Exception e) {
            L4 l6 = this.g;
            if (l6 != null) {
                String TAG3 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((M4) l6).b(TAG3, "Exception in stopTrackingForImpression with message : " + e.getMessage());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        } finally {
            this.f.getClass();
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        this.f.getClass();
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
    }

    @Override // com.inmobi.media.Tc
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        this.f.getClass();
        Intrinsics.checkNotNullParameter(childView, "childView");
    }

    @Override // com.inmobi.media.Tc
    public final void a(HashMap map) {
        L4 l4 = this.g;
        if (l4 != null) {
            String str = this.h;
            ((M4) l4).a(str, O5.a(str, "TAG", "start tracking impression with ").append(map != null ? Integer.valueOf(map.size()) : null).append(" friendlyViews").toString());
        }
        try {
            try {
                View videoContainerView = this.f3206a.getVideoContainerView();
                C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                Context context = (Context) this.i.get();
                AdConfig.ViewabilityConfig viewability = this.d.getViewability();
                if (context != null && c3570t8 != null && !this.e.t) {
                    C3556s8 videoView = c3570t8.getVideoView();
                    L4 l5 = this.g;
                    if (l5 != null) {
                        String TAG = this.h;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((M4) l5).a(TAG, "start tracking");
                    }
                    this.j.a(context, videoView, this.e, viewability);
                    View viewB = this.f.b();
                    Object tag = videoView.getTag();
                    C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
                    if (c3426j8 != null && viewB != null && a(c3426j8)) {
                        L4 l6 = this.g;
                        if (l6 != null) {
                            String TAG2 = this.h;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((M4) l6).a(TAG2, "start tracking inline ad");
                        }
                        C3397h7 c3397h7 = this.j;
                        C3398h8 c3398h8 = this.e;
                        c3397h7.a(context, viewB, c3398h8, c3398h8.b0, viewability);
                    }
                }
            } catch (Exception e) {
                L4 l7 = this.g;
                if (l7 != null) {
                    String TAG3 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l7).b(TAG3, "Exception in startTrackingForImpression with message : " + e.getMessage());
                }
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(e);
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
            }
        } finally {
            this.f.getClass();
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(byte b) {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "Received event : " + ((int) b));
        }
        this.f.getClass();
    }

    @Override // com.inmobi.media.Tc
    public final void a(Context context, byte b) {
        Wc wc;
        Intrinsics.checkNotNullParameter(context, "context");
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onActivityStateChanged state - " + ((int) b));
        }
        try {
            if (b == 0) {
                C3397h7 c3397h7 = this.j;
                c3397h7.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                C3552s4 c3552s4 = (C3552s4) c3397h7.d.get(context);
                if (c3552s4 != null) {
                    Intrinsics.checkNotNullExpressionValue(c3552s4.d, "TAG");
                    for (Map.Entry entry : c3552s4.f3424a.entrySet()) {
                        View view = (View) entry.getKey();
                        C3524q4 c3524q4 = (C3524q4) entry.getValue();
                        c3552s4.c.a(view, c3524q4.f3404a, c3524q4.b);
                    }
                    if (!c3552s4.e.hasMessages(0)) {
                        c3552s4.e.postDelayed(c3552s4.f, c3552s4.g);
                    }
                    c3552s4.c.f();
                }
            } else if (b == 1) {
                C3397h7 c3397h8 = this.j;
                c3397h8.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                C3552s4 c3552s5 = (C3552s4) c3397h8.d.get(context);
                if (c3552s5 != null) {
                    Intrinsics.checkNotNullExpressionValue(c3552s5.d, "TAG");
                    c3552s5.c.a();
                    c3552s5.e.removeCallbacksAndMessages(null);
                    c3552s5.b.clear();
                }
            } else if (b == 2) {
                C3397h7 c3397h9 = this.j;
                c3397h9.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                L4 l5 = c3397h9.b;
                if (l5 != null) {
                    String TAG2 = c3397h9.c;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).a(TAG2, "Activity destroyed, removing impression tracker");
                }
                C3552s4 c3552s6 = (C3552s4) c3397h9.d.remove(context);
                if (c3552s6 != null) {
                    c3552s6.f3424a.clear();
                    c3552s6.b.clear();
                    c3552s6.c.a();
                    c3552s6.e.removeMessages(0);
                    c3552s6.c.b();
                }
                if (context instanceof Activity) {
                    c3397h9.d.isEmpty();
                }
            } else {
                L4 l6 = this.g;
                if (l6 != null) {
                    String TAG3 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l6).b(TAG3, "UnHandled sate ( " + ((int) b) + " ) received in onActivityStateChanged()");
                }
            }
            wc = this.f;
        } catch (Exception e) {
            L4 l7 = this.g;
            if (l7 != null) {
                String TAG4 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                ((M4) l7).b(TAG4, "Exception in onActivityStateChanged with message : " + e.getMessage());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            wc = this.f;
        } finally {
            this.f.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
        }
        wc.getClass();
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        L4 l4 = this.g;
        if (l4 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "destroy");
        }
        Context context = (Context) this.i.get();
        View viewB = this.f.b();
        if (context != null && viewB != null) {
            this.j.a(context, viewB, this.e);
        }
        super.a();
        this.i.clear();
        this.f.a();
    }

    public final boolean a(C3426j8 c3426j8) {
        Object obj = c3426j8.t.get("isFullScreen");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        return this.e.f3274a == 0 && !(bool != null ? bool.booleanValue() : false);
    }
}
