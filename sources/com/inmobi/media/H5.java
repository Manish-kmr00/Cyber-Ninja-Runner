package com.inmobi.media;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class H5 extends B {
    public final WeakReference e;
    public final r f;
    public final RelativeLayout g;
    public boolean h;
    public boolean i;
    public C3556s8 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5(WeakReference activityRef, r adContainer, RelativeLayout adBackgroundView) {
        super(adBackgroundView);
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(adBackgroundView, "adBackgroundView");
        this.e = activityRef;
        this.f = adContainer;
        this.g = adBackgroundView;
    }

    public static final void a(H5 this$0, C3426j8 c3426j8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f.getPlacementType() == 1) {
            Object obj = c3426j8.t.get("didCompleteQ4");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return;
            }
        }
        C3556s8 c3556s8 = this$0.j;
        if (c3556s8 != null) {
            c3556s8.start();
        }
    }

    @Override // com.inmobi.media.B
    public final void b() {
        C3556s8 c3556s8;
        Activity activity = (Activity) this.e.get();
        if (!(activity instanceof InMobiAdActivity) ? false : ((InMobiAdActivity) activity).e) {
            r rVar = this.f;
            if (rVar instanceof C3398h8) {
                View videoContainerView = ((C3398h8) rVar).getVideoContainerView();
                C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                if (c3570t8 != null) {
                    Object tag = c3570t8.getVideoView().getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                    a((C3426j8) tag);
                }
            } else if (rVar instanceof C3313b7) {
                a((C3426j8) null);
            }
        } else {
            r rVar2 = this.f;
            if (rVar2 instanceof C3398h8) {
                C3556s8 c3556s9 = this.j;
                Object tag2 = c3556s9 != null ? c3556s9.getTag() : null;
                C3426j8 c3426j8 = tag2 instanceof C3426j8 ? (C3426j8) tag2 : null;
                if (c3426j8 != null) {
                    if (1 == ((C3313b7) rVar2).f3274a && (c3556s8 = this.j) != null) {
                        c3556s8.f();
                    }
                    a(c3426j8);
                }
            } else if (rVar2 instanceof C3313b7) {
                a((C3426j8) null);
            }
            SparseArray sparseArray = InMobiAdActivity.k;
            r container = this.f;
            Intrinsics.checkNotNullParameter(container, "container");
            InMobiAdActivity.k.remove(container.hashCode());
        }
        this.f.b();
    }

    @Override // com.inmobi.media.B
    public final void c() {
        r rVar = this.f;
        if (rVar instanceof C3398h8) {
            C3556s8 c3556s8 = this.j;
            Object tag = c3556s8 != null ? c3556s8.getTag() : null;
            final C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (c3426j8 != null && this.h) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.inmobi.media.H5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        H5.a(this.f$0, c3426j8);
                    }
                }, 50L);
            }
            try {
                if (!this.i) {
                    this.i = true;
                    InterfaceC3519q fullScreenEventsListener = this.f.getFullScreenEventsListener();
                    if (fullScreenEventsListener != null) {
                        fullScreenEventsListener.a(c3426j8);
                    }
                }
            } catch (Exception e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        } else if (rVar instanceof C3313b7) {
            try {
                if (!this.i) {
                    this.i = true;
                    InterfaceC3519q fullScreenEventsListener2 = rVar.getFullScreenEventsListener();
                    if (fullScreenEventsListener2 != null) {
                        fullScreenEventsListener2.a(null);
                    }
                }
            } catch (Exception e2) {
                C3339d5 c3339d6 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e2, "event"));
            }
        }
        this.h = false;
    }

    @Override // com.inmobi.media.B
    public final void d() {
        this.h = true;
        C3556s8 c3556s8 = this.j;
        if (c3556s8 != null) {
            c3556s8.pause();
        }
    }

    @Override // com.inmobi.media.B
    public final void f() {
        C3513p7 c3513p7;
        C3471m7 c3471m7;
        byte placementType = this.f.getPlacementType();
        this.g.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        Object dataModel = this.f.getDataModel();
        C3622x4 c3622x4 = null;
        C3625x7 c3625x7 = dataModel instanceof C3625x7 ? (C3625x7) dataModel : null;
        Point point = (c3625x7 == null || (c3513p7 = c3625x7.e) == null || (c3471m7 = c3513p7.d) == null) ? null : c3471m7.f3375a;
        Tc viewableAd = this.f.getViewableAd();
        int requestedOrientation = 0;
        View viewA = viewableAd != null ? viewableAd.a(null, this.g, false) : null;
        r rVar = this.f;
        if (rVar instanceof C3398h8) {
            View videoContainerView = ((C3398h8) rVar).getVideoContainerView();
            C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
            if (c3570t8 != null) {
                C3556s8 videoView = c3570t8.getVideoView();
                this.j = videoView;
                if (videoView != null) {
                    videoView.requestFocus();
                }
                C3556s8 c3556s8 = this.j;
                Object tag = c3556s8 != null ? c3556s8.getTag() : null;
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                C3426j8 c3426j8 = (C3426j8) tag;
                C3455l7 c3455l7 = c3426j8.w;
                if (c3455l7 != null) {
                    Intrinsics.checkNotNull(c3455l7, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                    c3426j8.a((C3426j8) c3455l7);
                }
                if (placementType == 0) {
                    c3426j8.t.put("placementType", (byte) 0);
                } else {
                    c3426j8.t.put("placementType", (byte) 1);
                }
            }
        }
        if (viewA != null) {
            Intrinsics.checkNotNull(point);
            this.g.addView(viewA, new RelativeLayout.LayoutParams(point.x, point.y));
        }
        Activity activity = (Activity) this.e.get();
        if (activity == null || c3625x7 == null) {
            return;
        }
        byte b = c3625x7.b;
        if (b == 1) {
            requestedOrientation = 1;
        } else if (b != 2) {
            requestedOrientation = activity.getRequestedOrientation();
        }
        if (activity instanceof InMobiAdActivity) {
            C3622x4 c3622x5 = ((InMobiAdActivity) activity).f3023a;
            if (c3622x5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
            } else {
                c3622x4 = c3622x5;
            }
            c3622x4.f3473a.setRequestedOrientation(requestedOrientation);
        }
    }

    @Override // com.inmobi.media.B
    public final void g() {
        try {
            AdConfig adConfig = this.f.getAdConfig();
            Tc viewableAd = this.f.getViewableAd();
            if ((viewableAd != null ? viewableAd.b() : null) != null) {
                r rVar = this.f;
                if (!(rVar instanceof C3398h8)) {
                    if (rVar instanceof C3313b7) {
                        try {
                            viewableAd.a((HashMap) null);
                            return;
                        } catch (Exception unused) {
                            InterfaceC3519q fullScreenEventsListener = this.f.getFullScreenEventsListener();
                            if (fullScreenEventsListener != null) {
                                fullScreenEventsListener.a();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                C3556s8 c3556s8 = this.j;
                Object tag = c3556s8 != null ? c3556s8.getTag() : null;
                C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
                if (c3426j8 != null) {
                    AdConfig.ViewabilityConfig viewability = adConfig.getViewability();
                    int videoImpressionMinTimeViewed = viewability.getVideoImpressionMinTimeViewed();
                    HashMap map = c3426j8.F;
                    Object obj = map != null ? map.get("time") : null;
                    if (obj instanceof Integer) {
                        videoImpressionMinTimeViewed = ((Number) obj).intValue();
                    }
                    viewability.setVideoImpressionMinTimeViewed(videoImpressionMinTimeViewed);
                    viewableAd.a((HashMap) null);
                }
            }
        } catch (Exception e) {
            InterfaceC3519q fullScreenEventsListener2 = this.f.getFullScreenEventsListener();
            if (fullScreenEventsListener2 != null) {
                fullScreenEventsListener2.a();
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }

    @Override // com.inmobi.media.B
    public final void a() {
        if (this.f.c()) {
            return;
        }
        r rVar = this.f;
        if (rVar instanceof C3398h8) {
            if (((C3398h8) rVar).b.c) {
                return;
            }
            Activity activity = (Activity) this.e.get();
            if (activity instanceof InMobiAdActivity) {
                ((InMobiAdActivity) activity).e = true;
            }
            C3556s8 c3556s8 = this.j;
            if (c3556s8 == null) {
                Activity activity2 = (Activity) this.e.get();
                if (activity2 == null) {
                    return;
                }
                activity2.finish();
                return;
            }
            Object tag = c3556s8.getTag();
            C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (c3426j8 != null) {
                if (1 == ((C3313b7) rVar).f3274a) {
                    c3556s8.f();
                }
                try {
                    Object obj = c3426j8.t.get("isFullScreen");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) obj).booleanValue()) {
                        c3426j8.t.put("seekPosition", Integer.valueOf(c3556s8.getCurrentPosition()));
                        ((C3398h8) rVar).b(c3426j8);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in closing video");
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e, "event"));
                    return;
                }
            }
            return;
        }
        if (rVar instanceof C3313b7) {
            C3313b7 c3313b7 = (C3313b7) rVar;
            if (c3313b7.b.c) {
                return;
            }
            c3313b7.a();
            return;
        }
        Activity activity3 = (Activity) this.e.get();
        if (activity3 == null) {
            return;
        }
        activity3.finish();
    }

    public final void a(C3426j8 c3426j8) {
        try {
            InterfaceC3519q fullScreenEventsListener = this.f.getFullScreenEventsListener();
            if (fullScreenEventsListener != null) {
                fullScreenEventsListener.b(c3426j8);
            }
        } catch (Exception e) {
            AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
