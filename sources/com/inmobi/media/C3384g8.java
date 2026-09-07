package com.inmobi.media;

import com.google.common.base.Ascii;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.g8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3384g8 implements InterfaceC3519q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3398h8 f3326a;

    public C3384g8(C3398h8 c3398h8) {
        this.f3326a = c3398h8;
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void a() {
        Intrinsics.checkNotNullExpressionValue(this.f3326a.X, "access$getTAG$p(...)");
        A0 a0 = this.f3326a.w;
        if (a0 != null) {
            a0.c();
        }
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void b(Object obj) {
        Tc viewableAd;
        Intrinsics.checkNotNullExpressionValue(this.f3326a.X, "access$getTAG$p(...)");
        C3426j8 c3426j8 = obj instanceof C3426j8 ? (C3426j8) obj : null;
        if (c3426j8 != null) {
            HashMap map = c3426j8.t;
            Boolean bool = Boolean.FALSE;
            map.put("didRequestFullScreen", bool);
            map.put("isFullScreen", bool);
            c3426j8.w = null;
            HashMap map2 = c3426j8.t;
            map2.put("didRequestFullScreen", bool);
            map2.put("isFullScreen", bool);
            c3426j8.w = null;
        }
        C3398h8 c3398h8 = this.f3326a;
        if (c3398h8.f3274a == 0) {
            Tc viewableAd2 = c3398h8.getViewableAd();
            if (viewableAd2 != null) {
                viewableAd2.a((byte) 2);
            }
            C3313b7 c3313b7 = this.f3326a.v;
            if (c3313b7 != null && (viewableAd = c3313b7.getViewableAd()) != null) {
                viewableAd.a(Ascii.DLE);
            }
            if (c3426j8 != null) {
                c3426j8.a("exitFullscreen", this.f3326a.j(c3426j8), (T6) null, this.f3326a.W);
            }
        } else {
            Tc viewableAd3 = c3398h8.getViewableAd();
            if (viewableAd3 != null) {
                viewableAd3.a((byte) 3);
            }
        }
        A0 a0 = this.f3326a.w;
        if (a0 != null) {
            a0.b();
        }
        L4 l4 = this.f3326a.W;
        if (l4 != null) {
            ((M4) l4).a();
        }
    }

    @Override // com.inmobi.media.InterfaceC3519q
    public final void a(Object obj) {
        if (this.f3326a.f() == null) {
            return;
        }
        C3426j8 c3426j8 = obj instanceof C3426j8 ? (C3426j8) obj : null;
        Intrinsics.checkNotNullExpressionValue(this.f3326a.X, "access$getTAG$p(...)");
        if (c3426j8 != null) {
            HashMap map = c3426j8.t;
            Boolean bool = Boolean.TRUE;
            map.put("didRequestFullScreen", bool);
            map.put("isFullScreen", bool);
            map.put("shouldAutoPlay", bool);
            C3455l7 c3455l7 = c3426j8.w;
            if (c3455l7 != null) {
                HashMap map2 = c3455l7.t;
                map2.put("didRequestFullScreen", bool);
                map2.put("isFullScreen", bool);
                map2.put("shouldAutoPlay", bool);
            }
        }
        C3398h8 c3398h8 = this.f3326a;
        if (c3398h8.f3274a == 0) {
            Tc viewableAd = c3398h8.getViewableAd();
            if (viewableAd != null) {
                viewableAd.a((byte) 1);
            }
            if (c3426j8 != null) {
                c3426j8.a("fullscreen", this.f3326a.j(c3426j8), (T6) null, this.f3326a.W);
            }
        }
        A0 a0 = this.f3326a.w;
        if (a0 != null) {
            a0.d();
        }
    }
}
