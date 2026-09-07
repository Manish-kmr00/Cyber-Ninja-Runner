package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Ascii;
import com.iab.omid.library.inmobi.adsession.media.Position;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import com.inmobi.commons.core.configs.AdConfig;
import com.safedk.android.internal.partials.InMobiVideoBridge;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.h8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3398h8 extends C3313b7 {
    public final String U;
    public final String V;
    public final L4 W;
    public final String X;
    public final String Y;
    public WeakReference Z;
    public final C3384g8 a0;
    public final C3370f8 b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3398h8(Context context, byte b, C3625x7 dataModel, String impressionId, Set set, AdConfig adConfig, long j, boolean z, String creativeId, J2 j2, C3297a6 c3297a6, L4 l4) {
        super(context, b, dataModel, impressionId, set, adConfig, j, z, creativeId, j2, c3297a6, l4);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.U = impressionId;
        this.V = creativeId;
        this.W = l4;
        this.X = "h8";
        this.Y = "InMobi";
        this.a0 = new C3384g8(this);
        this.b0 = new C3370f8(this);
    }

    public final void a(View view, final boolean z) {
        final C3556s8 c3556s8 = (C3556s8) view.findViewById(Integer.MAX_VALUE);
        if (c3556s8 != null) {
            Object tag = c3556s8.getTag();
            final C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
            if (c3426j8 != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.h8$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3398h8.a(c3426j8, z, this, c3556s8);
                    }
                });
            }
        }
    }

    @Override // com.inmobi.media.C3313b7
    public final void b(View view) {
        if (this.r || this.t || !(view instanceof C3556s8)) {
            return;
        }
        this.r = true;
        J2 j2 = this.h;
        if (j2 != null) {
            j2.a();
        }
        Object tag = ((C3556s8) view).getTag();
        if (tag instanceof C3426j8) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            C3426j8 c3426j8 = (C3426j8) tag;
            Object obj = c3426j8.t.get("didImpressionFire");
            if (Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
                return;
            }
            ArrayList<C3328c8> arrayList = c3426j8.s;
            HashMap mapJ = j(c3426j8);
            List list = null;
            for (C3328c8 c3328c8 : arrayList) {
                if (Intrinsics.areEqual("VideoImpression", c3328c8.b)) {
                    if (StringsKt.startsWith$default(c3328c8.d, "http", false, 2, (Object) null)) {
                        C3455l7.a(c3328c8, mapJ, (T6) null, this.W);
                    }
                    HashMap map = c3328c8.e;
                    Object obj2 = map != null ? map.get("referencedEvents") : null;
                    list = obj2 instanceof List ? (List) obj2 : null;
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            c3426j8.a((String) it.next(), mapJ, (T6) null, this.W);
                        }
                    }
                }
            }
            if (list == null || list.isEmpty()) {
                c3426j8.a("start", mapJ, (T6) null, this.W);
                c3426j8.a("Impression", mapJ, this.O, this.W);
            }
            C3513p7 c3513p7 = this.b.e;
            if (c3513p7 != null) {
                c3513p7.a("Impression", j(c3426j8), this.O, this.W);
            }
            c3426j8.t.put("didImpressionFire", Boolean.TRUE);
            Sc sc = this.p;
            if (sc != null) {
                sc.a((byte) 0);
            }
            A0 a0 = this.w;
            if (a0 != null) {
                a0.f();
            }
        }
    }

    @Override // com.inmobi.media.C3313b7
    public final void c(C3455l7 asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        byte b = asset.k;
        if (b != 0) {
            if (b == 2) {
                try {
                    if (1 != this.f3274a) {
                        A0 a0 = this.w;
                        if (a0 != null) {
                            a0.h();
                        }
                        r();
                        return;
                    }
                    super.c(asset);
                    if (Intrinsics.areEqual(ShareConstants.VIDEO_URL, asset.c)) {
                        View videoContainerView = getVideoContainerView();
                        C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
                        if (c3570t8 != null) {
                            c3570t8.getVideoView().c();
                            c3570t8.getVideoView().j();
                        }
                        r();
                        return;
                    }
                    L4 l4 = this.W;
                    if (l4 != null) {
                        String TAG = this.X;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((M4) l4).b(TAG, "Action 2 not valid for asset of type: " + asset.c);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    L4 l5 = this.W;
                    if (l5 != null) {
                        String str = this.X;
                        ((M4) l5).b(str, O5.a(str, "TAG", "Action 2 not valid for asset of type: ").append(asset.c).toString());
                    }
                    C3339d5 c3339d5 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e, "event"));
                    return;
                }
            }
            if (b == 3) {
                try {
                    if (!Intrinsics.areEqual(ShareConstants.VIDEO_URL, asset.c)) {
                        L4 l6 = this.W;
                        if (l6 != null) {
                            String TAG2 = this.X;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((M4) l6).b(TAG2, "Action 3 not valid for asset of type: " + asset.c);
                            return;
                        }
                        return;
                    }
                    Ba ba = this.H;
                    if (ba != null) {
                        L4 l7 = ba.i;
                        if (l7 != null) {
                            String TAG3 = Ba.O0;
                            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                            ((M4) l7).a(TAG3, "replayToInterActive");
                        }
                        ba.b("window.imraid.broadcastEvent('replay');");
                    }
                    View viewG = g();
                    if (viewG != null) {
                        C3314b8 c3314b8A = C3313b7.a(viewG);
                        if (c3314b8A != null) {
                            c3314b8A.d();
                        }
                        ViewParent parent = viewG.getParent();
                        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup != null) {
                            viewGroup.removeView(viewG);
                        }
                    }
                    View videoContainerView2 = getVideoContainerView();
                    C3570t8 c3570t9 = videoContainerView2 instanceof C3570t8 ? (C3570t8) videoContainerView2 : null;
                    if (c3570t9 != null) {
                        c3570t9.getVideoView().k();
                        c3570t9.getVideoView().start();
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    L4 l8 = this.W;
                    if (l8 != null) {
                        String str2 = this.X;
                        ((M4) l8).b(str2, ld.a(e2, O5.a(str2, "TAG", "Encountered unexpected error in handling replay action on video: ")));
                    }
                    AbstractC3498o6.a((byte) 2, this.Y, "SDK encountered unexpected error in replaying video");
                    C3339d5 c3339d6 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e2, "event"));
                    return;
                }
            }
            if (b == 1) {
                super.c(asset);
                return;
            }
            if (b == 4) {
                try {
                    if (this.f3274a != 0) {
                        L4 l9 = this.W;
                        if (l9 != null) {
                            String TAG4 = this.X;
                            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                            ((M4) l9).b(TAG4, "Invalid action! Online inline videos can be expanded to fullscreen!");
                            return;
                        }
                        return;
                    }
                    View videoContainerView3 = getVideoContainerView();
                    C3570t8 c3570t10 = videoContainerView3 instanceof C3570t8 ? (C3570t8) videoContainerView3 : null;
                    if (c3570t10 != null) {
                        C3556s8 videoView = c3570t10.getVideoView();
                        Object tag = videoView.getTag();
                        C3426j8 c3426j8 = tag instanceof C3426j8 ? (C3426j8) tag : null;
                        if (videoView.getState() == 1 || c3426j8 == null) {
                            return;
                        }
                        try {
                            a(c3426j8, videoView);
                            return;
                        } catch (Exception e3) {
                            L4 l10 = this.W;
                            if (l10 != null) {
                                String TAG5 = this.X;
                                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                                ((M4) l10).b(TAG5, "SDK encountered unexpected error in handling the onVideoRequestedFullScreen event; " + e3.getMessage());
                            }
                            C3339d5 c3339d7 = C3339d5.f3292a;
                            P1 event = new P1(e3);
                            Intrinsics.checkNotNullParameter(event, "event");
                            C3339d5.c.a(event);
                            return;
                        }
                    }
                    return;
                } catch (Exception e4) {
                    L4 l11 = this.W;
                    if (l11 != null) {
                        String str3 = this.X;
                        ((M4) l11).b(str3, ld.a(e4, O5.a(str3, "TAG", "Encountered unexpected error in handling fullscreen action on video: ")));
                    }
                    AbstractC3498o6.a((byte) 2, this.Y, "SDK encountered unexpected error in expanding video to fullscreen");
                    C3339d5 c3339d8 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e4, "event"));
                    return;
                }
            }
            if (b == 5) {
                try {
                    View videoContainerView4 = getVideoContainerView();
                    C3570t8 c3570t11 = videoContainerView4 instanceof C3570t8 ? (C3570t8) videoContainerView4 : null;
                    if (c3570t11 != null) {
                        Object tag2 = c3570t11.getVideoView().getTag();
                        C3426j8 c3426j9 = tag2 instanceof C3426j8 ? (C3426j8) tag2 : null;
                        if (c3426j9 != null) {
                            HashMap map = c3426j9.t;
                            Boolean bool = Boolean.TRUE;
                            map.put("shouldAutoPlay", bool);
                            C3455l7 c3455l7 = c3426j9.w;
                            if (c3455l7 != null) {
                                c3455l7.t.put("shouldAutoPlay", bool);
                            }
                        }
                        c3570t11.getVideoView().start();
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    L4 l12 = this.W;
                    if (l12 != null) {
                        String str4 = this.X;
                        ((M4) l12).b(str4, ld.a(e5, O5.a(str4, "TAG", "Encountered unexpected error in handling play action on video: ")));
                    }
                    AbstractC3498o6.a((byte) 2, this.Y, "SDK encountered unexpected error in playing video");
                    C3339d5 c3339d9 = C3339d5.f3292a;
                    C3339d5.c.a(I4.a(e5, "event"));
                    return;
                }
            }
            try {
                if (1 != this.f3274a) {
                    A0 a1 = this.w;
                    if (a1 != null) {
                        a1.h();
                    }
                    r();
                    return;
                }
                super.c(asset);
                if (Intrinsics.areEqual(ShareConstants.VIDEO_URL, asset.c)) {
                    View videoContainerView5 = getVideoContainerView();
                    C3570t8 c3570t12 = videoContainerView5 instanceof C3570t8 ? (C3570t8) videoContainerView5 : null;
                    if (c3570t12 != null) {
                        c3570t12.getVideoView().c();
                        c3570t12.getVideoView().j();
                    }
                    r();
                    return;
                }
                L4 l13 = this.W;
                if (l13 != null) {
                    String TAG6 = this.X;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    ((M4) l13).b(TAG6, "Action 2 not valid for asset of type: " + asset.c);
                }
            } catch (Exception e6) {
                L4 l14 = this.W;
                if (l14 != null) {
                    String str5 = this.X;
                    ((M4) l14).b(str5, O5.a(str5, "TAG", "Action 2 not valid for asset of type: ").append(asset.c).toString());
                }
                C3339d5 c3339d10 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e6, "event"));
            }
        }
    }

    public final void d(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        L4 l4 = this.W;
        if (l4 != null) {
            String str = this.X;
            ((M4) l4).c(str, O5.a(str, "TAG", "Firing Q4 beacons for completion at ").append(videoAsset.D).toString());
        }
        videoAsset.t.put("didQ4Fire", Boolean.TRUE);
        videoAsset.a("complete", j(videoAsset), (T6) null, this.W);
        Sc sc = this.p;
        if (sc != null) {
            sc.a(Ascii.FF);
        }
        L4 l5 = this.W;
        if (l5 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l5).c(TAG, "onVideoQuartileEvent(Q4)");
        }
    }

    public final void e(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        videoAsset.t.put("lastMediaVolume", 0);
        videoAsset.a("mute", j(videoAsset), (T6) null, this.W);
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onVideoMuted");
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a(Ascii.CR);
        }
    }

    public final void f(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        C3314b8 c3314b8A = C3313b7.a(g());
        if (c3314b8A != null) {
            c3314b8A.b();
        }
        videoAsset.a("pause", j(videoAsset), (T6) null, this.W);
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onVideoPaused");
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a((byte) 7);
        }
    }

    public final void g(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onVideoPlayed");
        }
        if (this.f3274a == 0) {
            Object obj = videoAsset.t.get("currentMediaVolume");
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 0;
            Object obj2 = videoAsset.t.get("lastMediaVolume");
            Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue > 0 && iIntValue2 == 0) {
                i(videoAsset);
            }
            Object obj3 = videoAsset.t.get("currentMediaVolume");
            Integer num3 = obj3 instanceof Integer ? (Integer) obj3 : null;
            int iIntValue3 = num3 != null ? num3.intValue() : 0;
            Object obj4 = videoAsset.t.get("lastMediaVolume");
            Integer num4 = obj4 instanceof Integer ? (Integer) obj4 : null;
            int iIntValue4 = num4 != null ? num4.intValue() : 0;
            if (iIntValue3 == 0 && iIntValue4 > 0) {
                e(videoAsset);
            }
        }
        Object obj5 = videoAsset.t.get("didStartPlaying");
        if (Intrinsics.areEqual(obj5 instanceof Boolean ? (Boolean) obj5 : null, Boolean.FALSE)) {
            videoAsset.t.put("didStartPlaying", Boolean.TRUE);
            Tc viewableAd = getViewableAd();
            if (viewableAd != null) {
                viewableAd.a((byte) 6);
            }
        }
    }

    @Override // com.inmobi.media.C3313b7, com.inmobi.media.r
    public final String getCreativeId() {
        return this.V;
    }

    @Override // com.inmobi.media.C3313b7, com.inmobi.media.r
    public final InterfaceC3519q getFullScreenEventsListener() {
        return this.a0;
    }

    @Override // com.inmobi.media.C3313b7, com.inmobi.media.r
    public final String getImpressionId() {
        return this.U;
    }

    @Override // com.inmobi.media.C3313b7, com.inmobi.media.r
    public final View getVideoContainerView() {
        WeakReference weakReference = this.Z;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // com.inmobi.media.C3313b7, com.inmobi.media.r
    public final Tc getViewableAd() {
        Context contextJ = j();
        if (this.p == null && contextJ != null) {
            L4 l4 = this.j;
            if (l4 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).c(TAG, "fireLoadedAndServedBeacons");
            }
            C3513p7 c3513p7 = this.b.e;
            if (c3513p7 != null) {
                HashMap mapA = a(c3513p7);
                a((byte) 1, mapA);
                a((byte) 2, mapA);
            }
            this.p = new Y4(this, new Wc(this, this.W), this.W);
            Set<C3504oc> set = this.d;
            if (set != null) {
                for (C3504oc c3504oc : set) {
                    try {
                        if (c3504oc.f3393a == 3) {
                            Object obj = c3504oc.b.get("omidAdSession");
                            C3371f9 c3371f9 = obj instanceof C3371f9 ? (C3371f9) obj : null;
                            Object obj2 = c3504oc.b.get("videoAutoPlay");
                            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                            Object obj3 = c3504oc.b.get("videoSkippable");
                            Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
                            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
                            Object obj4 = c3504oc.b.get("videoSkipOffset");
                            Integer num = obj4 instanceof Integer ? (Integer) obj4 : null;
                            VastProperties vastPropertiesCreateVastPropertiesForSkippableMedia = zBooleanValue2 ? VastProperties.createVastPropertiesForSkippableMedia(num != null ? num.intValue() : 0, zBooleanValue, Position.STANDALONE) : VastProperties.createVastPropertiesForNonSkippableMedia(zBooleanValue, Position.STANDALONE);
                            Sc sc = this.p;
                            if (c3371f9 == null || sc == null) {
                                L4 l5 = this.W;
                                if (l5 != null) {
                                    String TAG2 = this.X;
                                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                    ((M4) l5).b(TAG2, "Did not find a OMID video ad session; the OMID decorator will not be applied.");
                                }
                            } else {
                                Intrinsics.checkNotNull(vastPropertiesCreateVastPropertiesForSkippableMedia);
                                this.p = new C3457l9(contextJ, sc, this, c3371f9, vastPropertiesCreateVastPropertiesForSkippableMedia, this.W);
                            }
                        }
                    } catch (Exception e) {
                        L4 l6 = this.W;
                        if (l6 != null) {
                            String str = this.X;
                            ((M4) l6).b(str, ld.a(e, O5.a(str, "TAG", "Exception occurred while creating the video viewable ad : ")));
                        }
                        C3339d5 c3339d5 = C3339d5.f3292a;
                        C3339d5.c.a(I4.a(e, "event"));
                    }
                }
            }
        }
        return this.p;
    }

    public final void h(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        C3314b8 c3314b8A = C3313b7.a(g());
        if (c3314b8A != null) {
            c3314b8A.c();
        }
        videoAsset.a("resume", j(videoAsset), (T6) null, this.W);
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onVideoResumed");
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a((byte) 8);
        }
    }

    @Override // com.inmobi.media.C3313b7
    public final Yc i() {
        return this.b0;
    }

    public final HashMap j(C3426j8 c3426j8) {
        String strB;
        C3556s8 videoView;
        C3513p7 c3513p7 = c3426j8.r;
        if (!(c3513p7 instanceof C3513p7)) {
            c3513p7 = null;
        }
        HashMap map = new HashMap();
        WeakReference weakReference = this.Z;
        View view = weakReference != null ? (View) weakReference.get() : null;
        C3570t8 c3570t8 = view instanceof C3570t8 ? (C3570t8) view : null;
        if (c3570t8 != null && (videoView = c3570t8.getVideoView()) != null) {
        }
        map.put("[ERRORCODE]", "405");
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int iNextInt = 0;
        while (iNextInt == 0) {
            iNextInt = (secureRandom.nextInt() & Integer.MAX_VALUE) % 10;
        }
        sb.append(iNextInt);
        for (int i = 1; i < 8; i++) {
            sb.append((secureRandom.nextInt() & Integer.MAX_VALUE) % 10);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        map.put("[CACHEBUSTING]", string);
        Rc rcD = c3426j8.d();
        if (rcD != null && (strB = ((Qc) rcD).b()) != null) {
        }
        map.put("$TS", String.valueOf(System.currentTimeMillis()));
        Object obj = c3426j8.t.get("seekPosition");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = iIntValue;
        String str = String.format(locale, "%02d:%02d:%02d.%03d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(j))), Long.valueOf(timeUnit.toSeconds(j) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j))), Long.valueOf(j - (timeUnit.toSeconds(j) * ((long) 1000)))}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        map.put("[CONTENTPLAYHEAD]", str);
        if (c3513p7 != null) {
        }
        Object map2 = this.b.t;
        if (map2 == null) {
            map2 = new HashMap();
        }
        map.putAll(map2);
        return map;
    }

    @Override // com.inmobi.media.C3313b7
    public final boolean k() {
        return this.f3274a == 0 && f() != null;
    }

    @Override // com.inmobi.media.C3313b7
    public final void l() {
        super.l();
        View videoContainerView = getVideoContainerView();
        C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
        if (c3570t8 != null) {
            C3556s8 videoView = c3570t8.getVideoView();
            if (this.f3274a == 0 && !k() && videoView.getVideoVolume() > 0) {
                videoView.setLastVolume(-2);
                a(true);
            }
            videoView.pause();
        }
    }

    @Override // com.inmobi.media.C3313b7
    public final boolean n() {
        return !this.A;
    }

    public final void r() {
        J2 j2 = this.h;
        if (j2 != null) {
            if (!j2.g.get()) {
                j2.d.h = 1;
                Intrinsics.checkNotNull(j2.c);
            }
            this.h.b();
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a(Ascii.SI);
        }
    }

    public final void i(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        videoAsset.t.put("lastMediaVolume", 15);
        videoAsset.a("unmute", j(videoAsset), (T6) null, this.W);
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onVideoUnMuted");
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a(Ascii.SO);
        }
    }

    public static final void a(C3426j8 c3426j8, boolean z, C3398h8 this$0, C3556s8 c3556s8) {
        int videoVolume;
        int lastVolume;
        int videoVolume2;
        int lastVolume2;
        int videoVolume3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c3426j8.t.put(VastAttributes.VISIBLE, Boolean.valueOf(z));
        if (z && !this$0.u) {
            c3426j8.t.put("lastVisibleTimestamp", Long.valueOf(SystemClock.uptimeMillis()));
            if (c3556s8.getPauseScheduled() && c3556s8.getMediaPlayer() != null) {
                if (c3426j8.c()) {
                    c3556s8.k();
                } else {
                    c3556s8.c();
                }
            }
            Handler handler = c3556s8.s;
            if (handler != null) {
                handler.removeMessages(0);
            }
            c3556s8.t = false;
            Intrinsics.checkNotNull(c3556s8);
            if (this$0.f3274a == 0 && !this$0.k() && (videoVolume3 = c3556s8.getVideoVolume()) != c3556s8.getLastVolume() && c3556s8.isPlaying()) {
                this$0.a(videoVolume3 <= 0);
                c3556s8.setLastVolume(videoVolume3);
            }
            if (this$0.f3274a == 0 && !this$0.k() && !c3426j8.B && !c3556s8.isPlaying() && c3556s8.getState() == 5 && (videoVolume2 = c3556s8.getVideoVolume()) != (lastVolume2 = c3556s8.getLastVolume()) && lastVolume2 > 0) {
                this$0.a(true);
                c3556s8.setLastVolume(videoVolume2);
            }
            if (1 == c3556s8.getState()) {
                O7 mediaPlayer = c3556s8.getMediaPlayer();
                if (mediaPlayer == null) {
                    return;
                }
                mediaPlayer.b = 3;
                return;
            }
            if (2 == c3556s8.getState() || 4 == c3556s8.getState() || (5 == c3556s8.getState() && c3426j8.B)) {
                c3556s8.start();
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(c3556s8);
        if (this$0.f3274a == 0 && !this$0.k() && !this$0.u && (videoVolume = c3556s8.getVideoVolume()) != (lastVolume = c3556s8.getLastVolume()) && lastVolume > 0) {
            this$0.a(true);
            c3556s8.setLastVolume(videoVolume);
        }
        c3556s8.a(c3426j8.E);
    }

    public final void a(boolean z) {
        A0 a0;
        if (this.f3274a != 0 || k() || (a0 = this.w) == null) {
            return;
        }
        L4 l4 = a0.f3025a.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).a(strE, "onAudioStateChanged");
        }
        if (a0.f3025a.Z()) {
            return;
        }
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) a0.b.get();
        if (abstractC3520q0 != null) {
            abstractC3520q0.a(z);
            return;
        }
        L4 l5 = a0.f3025a.j;
        if (l5 != null) {
            ((M4) l5).b("InMobi", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void a(C3426j8 videoAsset, int i) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).a(TAG, "Moat onVideoError + " + i);
        }
        videoAsset.a("error", j(videoAsset), (T6) null, this.W);
        L4 l5 = this.W;
        if (l5 != null) {
            String TAG2 = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).c(TAG2, "onVideoError");
        }
        Sc sc = this.p;
        if (sc != null) {
            sc.a((byte) 17);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    public final void a(C3426j8 c3426j8, C3556s8 c3556s8) {
        boolean z;
        if (this.t || this.x.get() == null) {
            return;
        }
        Object obj = c3426j8.t.get("didRequestFullScreen");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null ? bool.booleanValue() : false) {
            return;
        }
        HashMap map = c3426j8.t;
        Boolean bool2 = Boolean.TRUE;
        map.put("didRequestFullScreen", bool2);
        map.put("seekPosition", Integer.valueOf(c3556s8.getCurrentPosition()));
        map.put("lastMediaVolume", Integer.valueOf(c3556s8.getVolume()));
        O7 mediaPlayer = c3556s8.getMediaPlayer();
        if (mediaPlayer != null) {
            z = mediaPlayer.isPlaying();
        }
        if (z) {
            O7 mediaPlayer2 = c3556s8.getMediaPlayer();
            if (mediaPlayer2 != null) {
                InMobiVideoBridge.MediaPlayerPause(mediaPlayer2);
            }
            c3556s8.getAudioFocusManager$media_release().a();
        }
        O7 mediaPlayer3 = c3556s8.getMediaPlayer();
        if (mediaPlayer3 != null) {
            mediaPlayer3.f3156a = 4;
        }
        c3426j8.t.put("isFullScreen", bool2);
        HashMap map2 = c3426j8.t;
        O7 mediaPlayer4 = c3556s8.getMediaPlayer();
        map2.put("seekPosition", Integer.valueOf(mediaPlayer4 != null ? mediaPlayer4.getCurrentPosition() : 0));
        L4 l4 = this.j;
        if (l4 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "launchFullscreen");
        }
        C3313b7 c3313b7C = C3313b7.c(this);
        if (c3313b7C == null) {
            return;
        }
        A0 a0 = c3313b7C.w;
        if (a0 != null) {
            a0.e();
        }
        C3575u c3575u = this.M;
        int iHashCode = hashCode();
        U6 u6 = new U6(this, c3313b7C);
        c3575u.getClass();
        C3575u.a(iHashCode, u6);
    }

    public final void b(C3426j8 videoAsset, C3556s8 videoView) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "onVideoViewCreated");
        }
        videoView.setIsLockScreen(this.D);
        ViewParent parent = videoView.getParent();
        C3570t8 c3570t8 = parent instanceof C3570t8 ? (C3570t8) parent : null;
        if (c3570t8 != null) {
            this.Z = new WeakReference(c3570t8);
            C3456l8 mediaController = c3570t8.getVideoView().getMediaController();
            if (mediaController != null) {
                mediaController.setVideoAd(this);
            }
        }
    }

    @Override // com.inmobi.media.C3313b7, com.inmobi.media.r
    public final void b() {
        C3556s8 videoView;
        if (this.t) {
            return;
        }
        View videoContainerView = getVideoContainerView();
        C3570t8 c3570t8 = videoContainerView instanceof C3570t8 ? (C3570t8) videoContainerView : null;
        if (c3570t8 != null && (videoView = c3570t8.getVideoView()) != null) {
            videoView.g();
        }
        super.b();
    }

    public final void b(C3426j8 videoAsset) {
        HashMap map;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        if (this.t) {
            return;
        }
        Object obj = videoAsset.t.get("didRequestFullScreen");
        if (Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE)) {
            HashMap map2 = videoAsset.t;
            Boolean bool = Boolean.FALSE;
            map2.put("didRequestFullScreen", bool);
            C3455l7 c3455l7 = videoAsset.w;
            if (c3455l7 != null && (map = c3455l7.t) != null) {
                map.put("didRequestFullScreen", bool);
            }
            a();
            videoAsset.t.put("isFullScreen", bool);
        }
    }

    public final void c(C3426j8 videoAsset) {
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        L4 l4 = this.W;
        if (l4 != null) {
            String TAG = this.X;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "Video completed; rewards, if any, will be unlocked and end-card displayed");
        }
        Object obj = videoAsset.t.get("didSignalVideoCompleted");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        J2 j2 = this.h;
        if (j2 != null) {
            if (!j2.g.get()) {
                j2.d.i = 1;
                Intrinsics.checkNotNull(j2.c);
            }
            this.h.b();
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            L4 l5 = this.W;
            if (l5 != null) {
                String TAG2 = this.X;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l5).c(TAG2, "Ignoring callback onAdRewardsUnlocked(), as it is only fired after first time video is played.");
            }
        } else {
            q();
            A0 a0 = this.w;
            if (a0 != null) {
                L4 l6 = a0.f3025a.j;
                if (l6 != null) {
                    String strE = C0.e();
                    Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
                    ((M4) l6).a(strE, "onMediaPlaybackComplete");
                }
                if (!a0.f3025a.Z()) {
                    AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) a0.b.get();
                    if (abstractC3520q0 != null) {
                        abstractC3520q0.f();
                    } else {
                        L4 l7 = a0.f3025a.j;
                        if (l7 != null) {
                            ((M4) l7).b("InMobi", "Listener was garbage collected.Unable to give callback");
                        }
                    }
                }
            }
        }
        if (1 == this.f3274a) {
            b((C3455l7) videoAsset);
        }
    }
}
