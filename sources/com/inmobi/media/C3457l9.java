package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.l9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3457l9 extends Sc {
    public final Sc e;
    public C3371f9 f;
    public final VastProperties g;
    public final L4 h;
    public final String i;
    public final float j;
    public final WeakReference k;
    public WeakReference l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3457l9(Context context, Sc mViewableAd, C3398h8 adContainer, C3371f9 c3371f9, VastProperties mVastProperties, L4 l4) {
        super(adContainer);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(mVastProperties, "mVastProperties");
        this.e = mViewableAd;
        this.f = c3371f9;
        this.g = mVastProperties;
        this.h = l4;
        this.i = "l9";
        this.j = 1.0f;
        this.k = new WeakReference(context);
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
    public final F7 c() {
        return this.e.c();
    }

    @Override // com.inmobi.media.Tc
    public final View d() {
        return this.e.d();
    }

    @Override // com.inmobi.media.Tc
    public final void e() {
        try {
            r rVar = this.f3206a;
            if ((rVar instanceof C3398h8) && !((C3398h8) rVar).k()) {
                C3371f9 c3371f9 = this.f;
                if (c3371f9 != null) {
                    c3371f9.a();
                }
                L4 l4 = this.h;
                if (l4 != null) {
                    String TAG = this.i;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    StringBuilder sb = new StringBuilder("Unregistered VideoView to OMID AdSession : ");
                    C3371f9 c3371f10 = this.f;
                    ((M4) l4).a(TAG, sb.append(c3371f10 != null ? c3371f10.hashCode() : 0).toString());
                }
            }
        } catch (Exception e) {
            L4 l5 = this.h;
            if (l5 != null) {
                String TAG2 = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).b(TAG2, "Exception in stopTrackingForImpression with message : " + e.getMessage());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
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
        try {
            L4 l4 = this.h;
            if (l4 != null) {
                String TAG = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "startTrackingForImpression");
            }
            if (this.d.getViewability().getOmidConfig().isOmidEnabled()) {
                AbstractC3473m9.f3376a.getClass();
                if (Omid.isActive()) {
                    L4 l5 = this.h;
                    if (l5 != null) {
                        String TAG2 = this.i;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((M4) l5).a(TAG2, "OMID enabled and OM SDK initialised");
                    }
                    r rVar = this.f3206a;
                    if (rVar instanceof C3398h8) {
                        View videoContainerView = ((C3398h8) rVar).getVideoContainerView();
                        C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                        if (c3570t8 instanceof View) {
                            C3456l8 mediaController = c3570t8.getVideoView().getMediaController();
                            this.l = new WeakReference(c3570t8);
                            L4 l6 = this.h;
                            if (l6 != null) {
                                String TAG3 = this.i;
                                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                ((M4) l6).a(TAG3, "creating new OM SDK ad session");
                            }
                            C3371f9 c3371f9 = this.f;
                            if (c3371f9 != null) {
                                c3371f9.a(c3570t8, mediaController != null ? mediaController.getFriendlyViews() : null, this.e.b());
                            }
                            L4 l7 = this.h;
                            if (l7 != null) {
                                String TAG4 = this.i;
                                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                StringBuilder sb = new StringBuilder("Registered ad view with OMID Video AdSession ");
                                C3371f9 c3371f10 = this.f;
                                ((M4) l7).a(TAG4, sb.append(c3371f10 != null ? c3371f10.hashCode() : 0).toString());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            L4 l8 = this.h;
            if (l8 != null) {
                String TAG5 = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                ((M4) l8).b(TAG5, "Exception in startTrackingForImpression with message : " + e.getMessage());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        } finally {
            this.e.a(map);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(byte b) {
        try {
            L4 l4 = this.h;
            if (l4 != null) {
                String TAG = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).a(TAG, "onAdView - event - " + ((int) b));
            }
            float fA = this.j;
            int duration = 0;
            if (b == 13) {
                fA = 0.0f;
            } else if (b != 14) {
                if (b == 6) {
                    r rVar = this.f3206a;
                    if (rVar instanceof C3398h8) {
                        View videoContainerView = ((C3398h8) rVar).getVideoContainerView();
                        C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                        if (c3570t8 != null) {
                            duration = c3570t8.getVideoView().getDuration();
                            Object tag = c3570t8.getVideoView().getTag();
                            fA = a(tag instanceof C3426j8 ? (C3426j8) tag : null);
                        }
                    }
                } else if (b == 5) {
                    r rVar2 = this.f3206a;
                    if ((rVar2 instanceof C3398h8) && ((C3398h8) rVar2).k()) {
                        return;
                    }
                }
            }
            C3371f9 c3371f9 = this.f;
            if (c3371f9 != null) {
                c3371f9.a(b, duration, fA, this.g);
            }
        } catch (Exception e) {
            L4 l5 = this.h;
            if (l5 != null) {
                String TAG2 = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).b(TAG2, "Exception in onAdEvent with message : " + e.getMessage());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
        } finally {
            this.e.a(b);
        }
    }

    @Override // com.inmobi.media.Tc
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        L4 l4 = this.h;
        if (l4 != null) {
            String TAG = this.i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onActivityStateChanged - state - " + ((int) b));
        }
        this.e.a(context, b);
    }

    @Override // com.inmobi.media.Tc
    public final void a() {
        super.a();
        L4 l4 = this.h;
        if (l4 != null) {
            String TAG = this.i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "destroy");
        }
        try {
            try {
                this.k.clear();
                WeakReference weakReference = this.l;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.f = null;
            } catch (Exception e) {
                L4 l5 = this.h;
                if (l5 != null) {
                    String TAG2 = this.i;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((M4) l5).b(TAG2, "Exception in destroy with message : " + e.getMessage());
                }
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(e);
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
            }
        } finally {
            this.e.a();
        }
    }

    public final float a(C3426j8 c3426j8) {
        if (c3426j8 == null) {
            return 0.0f;
        }
        Object obj = c3426j8.t.get("currentMediaVolume");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        Object obj2 = c3426j8.t.get("lastMediaVolume");
        Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
        if (num == null || num2 == null || num.intValue() <= 0 || num2.intValue() != 0) {
            return 0.0f;
        }
        return this.j;
    }
}
