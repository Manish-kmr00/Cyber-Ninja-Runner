package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3293a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3308b2 f3262a;
    public final L4 b;

    public C3293a2(InterfaceC3308b2 mEventHandler, L4 l4) {
        Intrinsics.checkNotNullParameter(mEventHandler, "mEventHandler");
        this.f3262a = mEventHandler;
        this.b = l4;
    }

    public final void a(T1 click) {
        HashMap map;
        Intrinsics.checkNotNullParameter(click, "click");
        try {
            L4 l4 = this.b;
            if (l4 != null) {
                String strF = C3364f2.f();
                Intrinsics.checkNotNullExpressionValue(strF, "access$getTAG$p(...)");
                ((M4) l4).c(strF, "ping - " + click.f3198a);
            }
            S8 mRequest = new S8(click.b, this.b);
            HashMap mapA = C3364f2.a(C3364f2.f3308a, click);
            if (!mapA.isEmpty()) {
                mRequest.i.putAll(mapA);
            }
            mRequest.x = false;
            mRequest.t = false;
            mRequest.u = false;
            Map map2 = click.c;
            if (map2 != null && (map = mRequest.j) != null) {
                map.putAll(map2);
            }
            mRequest.r = click.d;
            AdConfig.ImaiConfig imaiConfig = C3364f2.g;
            if (imaiConfig != null) {
                mRequest.p = imaiConfig.getPingTimeout() * 1000;
                mRequest.q = imaiConfig.getPingTimeout() * 1000;
            }
            Intrinsics.checkNotNullParameter(mRequest, "mRequest");
            T8 t8B = mRequest.b();
            if (!t8B.b()) {
                this.f3262a.a(click);
                return;
            }
            P8 p8 = t8B.c;
            I3 i3 = p8 != null ? p8.f3168a : I3.e;
            if (I3.k == i3) {
                this.f3262a.a(click);
                return;
            }
            if (!click.d && (I3.u == i3 || I3.w == i3)) {
                this.f3262a.a(click);
                return;
            }
            boolean z = W8.f3228a;
            if (!W8.f3228a || (i3 != I3.q && i3 != I3.p && i3 != I3.o && i3 != I3.n && i3 != I3.r)) {
                this.f3262a.a(click, i3);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue(C3364f2.f(), "access$getTAG$p(...)");
            InterfaceC3308b2 interfaceC3308b2 = this.f3262a;
            I3 errorCode = I3.e;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            interfaceC3308b2.a(click, errorCode);
        }
    }
}
