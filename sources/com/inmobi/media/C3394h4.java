package com.inmobi.media;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3394h4 extends B {
    public final WeakReference e;
    public final r f;
    public final RelativeLayout g;
    public boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3394h4(WeakReference activityRef, r adContainer, RelativeLayout adBackgroundView) {
        super(adBackgroundView);
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(adBackgroundView, "adBackgroundView");
        this.e = activityRef;
        this.f = adContainer;
        this.g = adBackgroundView;
    }

    @Override // com.inmobi.media.B
    public final void a(EnumC3501o9 orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.b = orientation;
        r rVar = this.f;
        Intrinsics.checkNotNull(rVar, "null cannot be cast to non-null type com.inmobi.ads.containers.RenderView");
        Ba ba = (Ba) rVar;
        int iA = AbstractC3515p9.a(orientation);
        L4 l4 = ba.i;
        if (l4 != null) {
            String TAG = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "fireOrientationChange " + ba + ' ' + iA);
        }
        ba.b("window.imraid.broadcastEvent('orientationChange','" + iA + "');");
    }

    @Override // com.inmobi.media.B
    public final void b() {
        Activity activity = (Activity) this.e.get();
        if (!(activity instanceof InMobiAdActivity) ? false : ((InMobiAdActivity) activity).e) {
            try {
                InterfaceC3519q fullScreenEventsListener = this.f.getFullScreenEventsListener();
                if (fullScreenEventsListener != null) {
                    fullScreenEventsListener.b(null);
                }
            } catch (Exception unused) {
                AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
            }
        } else {
            r rVar = this.f;
            Intrinsics.checkNotNull(rVar, "null cannot be cast to non-null type com.inmobi.ads.containers.RenderView");
            Ba ba = (Ba) rVar;
            ba.setFullScreenActivityContext(null);
            try {
                ba.a();
            } catch (Exception unused2) {
                AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in processing close request");
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
        if (this.h) {
            return;
        }
        try {
            this.h = true;
            InterfaceC3519q fullScreenEventsListener = this.f.getFullScreenEventsListener();
            if (fullScreenEventsListener != null) {
                fullScreenEventsListener.a(null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.inmobi.media.B
    public final void d() {
    }

    @Override // com.inmobi.media.B
    public final void f() {
        this.g.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        Tc viewableAd = this.f.getViewableAd();
        View viewD = viewableAd != null ? viewableAd.d() : null;
        if (viewD != null) {
            ViewParent parent = viewD.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(viewD);
            }
            this.g.addView(viewD, layoutParams);
        }
    }

    @Override // com.inmobi.media.B
    public final void g() {
        if (1 == this.f.getPlacementType()) {
            try {
                HashMap map = new HashMap();
                Tc viewableAd = this.f.getViewableAd();
                if (viewableAd != null) {
                    viewableAd.a(map);
                }
            } catch (Exception unused) {
                InterfaceC3519q fullScreenEventsListener = this.f.getFullScreenEventsListener();
                if (fullScreenEventsListener != null) {
                    fullScreenEventsListener.a();
                }
            }
        }
    }

    @Override // com.inmobi.media.B
    public final void a() {
        r rVar = this.f;
        Ba ba = rVar instanceof Ba ? (Ba) rVar : null;
        if (ba == null) {
            return;
        }
        L4 l4 = ba.i;
        if (l4 != null) {
            String str = Ba.O0;
            ((M4) l4).a(str, AbstractC3474ma.a(ba, str, "TAG", "fireBackButtonPressedEvent "));
        }
        String str2 = ba.H;
        if (str2 != null) {
            ba.a(str2, "broadcastEvent('backButtonPressed')");
        }
        if (ba.G) {
            return;
        }
        try {
            ba.a();
        } catch (Exception unused) {
            AbstractC3498o6.a((byte) 2, "InMobi", "SDK encountered unexpected error in processing close request");
        }
    }
}
