package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.w5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3609w5 extends C0 {
    public int M;
    public boolean N;
    public Mb O;
    public Function0 P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3609w5(Context context, J adPlacement, AbstractC3520q0 abstractC3520q0) {
        super(context, adPlacement, abstractC3520q0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.O = new Mb();
        Intrinsics.checkNotNullExpressionValue("w5", "TAG");
        adPlacement.l();
        a(context, adPlacement, abstractC3520q0);
        c("activity");
    }

    public static final void c(C3609w5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(this$0.r());
    }

    public static final void d(C3609w5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(this$0.r());
    }

    public static final /* synthetic */ String e() {
        return "w5";
    }

    public final boolean C0() {
        if (f0()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", "Some of the dependency libraries for Interstitial not found");
            }
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return false;
        }
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R == null) {
            return false;
        }
        byte bQ = Q();
        if (bQ == 1) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).b("InMobiInterstitial", AbstractC3574tc.n + I());
            }
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD), false, (short) 2008);
        } else if (bQ == 7 || bQ == 6) {
            L4 l6 = this.j;
            if (l6 != null) {
                ((M4) l6).b("InMobiInterstitial", AbstractC3574tc.j + I());
            }
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 2010);
        } else {
            if (bQ != 2) {
                if (4 == Q()) {
                    if (!W()) {
                        L4 l7 = this.j;
                        if (l7 != null) {
                            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                            ((M4) l7).a("w5", "An ad is ready with the ad unit. Signaling ad load success ...");
                        }
                        AbstractC3520q0 abstractC3520q0R2 = r();
                        if (abstractC3520q0R2 == null) {
                            L4 l8 = this.j;
                            if (l8 != null) {
                                ((M4) l8).b("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
                            }
                        } else {
                            e(abstractC3520q0R2);
                            f(abstractC3520q0R2);
                        }
                        return false;
                    }
                    g();
                }
                e0();
                return true;
            }
            if (Intrinsics.areEqual("html", E()) || Intrinsics.areEqual("htmlUrl", E())) {
                L4 l9 = this.j;
                if (l9 != null) {
                    ((M4) l9).b("InMobiInterstitial", AbstractC3574tc.n + I());
                }
                a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD), false, (short) 2011);
            } else {
                e(abstractC3520q0R);
            }
        }
        return false;
    }

    public final boolean D0() {
        L4 l4;
        C3389h c3389hM = m();
        if (c3389hM == null) {
            return false;
        }
        AdConfig adConfigJ = j();
        Intrinsics.checkNotNull(adConfigJ);
        boolean zA = c3389hM.a(adConfigJ.getCacheConfig(q()).getTimeToLive());
        if (zA && (l4 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l4).b("w5", "Top ad has expired, failing show of ad.");
        }
        return !zA;
    }

    public final void E0() {
        r rVarK = k();
        if (rVarK == null) {
            return;
        }
        this.N = true;
        rVarK.e();
    }

    @Override // com.inmobi.media.C0
    public Integer F() {
        AdConfig adConfigJ = j();
        if (adConfigJ != null) {
            return Integer.valueOf(adConfigJ.getMinimumRefreshInterval());
        }
        return null;
    }

    public final Mb F0() {
        return this.O;
    }

    public final boolean G0() {
        return Q() == 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r1.equals("html") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H0() {
        /*
            r6 = this;
            java.lang.String r0 = "Cannot handle markupType: "
            com.inmobi.media.L4 r1 = r6.j
            java.lang.String r2 = "TAG"
            java.lang.String r3 = "w5"
            if (r1 == 0) goto L14
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            com.inmobi.media.M4 r1 = (com.inmobi.media.M4) r1
            java.lang.String r4 = "renderAdPostInternetCheck"
            r1.a(r3, r4)
        L14:
            r6.k0()
            boolean r1 = r6.o0()     // Catch: java.lang.IllegalStateException -> L9b
            if (r1 == 0) goto L1e
            return
        L1e:
            com.inmobi.media.E0 r1 = r6.s()     // Catch: java.lang.IllegalStateException -> L9b
            r1.getClass()     // Catch: java.lang.IllegalStateException -> L9b
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.IllegalStateException -> L9b
            r1.g = r4     // Catch: java.lang.IllegalStateException -> L9b
            r6.d0()     // Catch: java.lang.IllegalStateException -> L9b
            java.lang.String r1 = r6.E()     // Catch: java.lang.IllegalStateException -> L9b
            int r4 = r1.hashCode()     // Catch: java.lang.IllegalStateException -> L9b
            r5 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
            if (r4 == r5) goto L66
            r5 = 3213227(0x3107ab, float:4.50269E-39)
            if (r4 == r5) goto L4f
            r5 = 1236050372(0x49aca1c4, float:1414200.5)
            if (r4 == r5) goto L46
            goto L6e
        L46:
            java.lang.String r4 = "htmlUrl"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.IllegalStateException -> L9b
            if (r1 != 0) goto L57
            goto L6e
        L4f:
            java.lang.String r4 = "html"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.IllegalStateException -> L9b
            if (r1 == 0) goto L6e
        L57:
            android.os.Handler r0 = r6.D()     // Catch: java.lang.IllegalStateException -> L9b
            if (r0 == 0) goto Lb7
            com.inmobi.media.w5$$ExternalSyntheticLambda1 r1 = new com.inmobi.media.w5$$ExternalSyntheticLambda1     // Catch: java.lang.IllegalStateException -> L9b
            r1.<init>()     // Catch: java.lang.IllegalStateException -> L9b
            r0.post(r1)     // Catch: java.lang.IllegalStateException -> L9b
            goto Lb7
        L66:
            java.lang.String r4 = "inmobiJson"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.IllegalStateException -> L9b
            if (r1 != 0) goto L8c
        L6e:
            com.inmobi.media.L4 r1 = r6.j     // Catch: java.lang.IllegalStateException -> L9b
            if (r1 == 0) goto Lb7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)     // Catch: java.lang.IllegalStateException -> L9b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.IllegalStateException -> L9b
            r4.<init>(r0)     // Catch: java.lang.IllegalStateException -> L9b
            java.lang.String r0 = r6.E()     // Catch: java.lang.IllegalStateException -> L9b
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.IllegalStateException -> L9b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.IllegalStateException -> L9b
            com.inmobi.media.M4 r1 = (com.inmobi.media.M4) r1     // Catch: java.lang.IllegalStateException -> L9b
            r1.a(r3, r0)     // Catch: java.lang.IllegalStateException -> L9b
            goto Lb7
        L8c:
            com.inmobi.media.L4 r0 = r6.j     // Catch: java.lang.IllegalStateException -> L9b
            if (r0 == 0) goto Lb7
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)     // Catch: java.lang.IllegalStateException -> L9b
            java.lang.String r1 = "Waiting for Vast Processing"
            com.inmobi.media.M4 r0 = (com.inmobi.media.M4) r0     // Catch: java.lang.IllegalStateException -> L9b
            r0.a(r3, r1)     // Catch: java.lang.IllegalStateException -> L9b
            goto Lb7
        L9b:
            r0 = move-exception
            com.inmobi.media.L4 r1 = r6.j
            if (r1 == 0) goto Laa
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            com.inmobi.media.M4 r1 = (com.inmobi.media.M4) r1
            java.lang.String r2 = "Exception while loading ad."
            r1.a(r3, r2, r0)
        Laa:
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r1 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r0.<init>(r1)
            r1 = 1
            r2 = 2134(0x856, float:2.99E-42)
            r6.b(r0, r1, r2)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C3609w5.H0():void");
    }

    public boolean I0() {
        return 2 == Q();
    }

    @Override // com.inmobi.media.C0
    public final byte J() {
        return (byte) 1;
    }

    public final void J0() {
        short s;
        L4 l4 = this.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "submitAdNotReady " + this);
        }
        Mb mb = this.O;
        E0 e0S = s();
        C3389h c3389hA = this.A ? a(this.x) : m();
        String strP = c3389hA != null ? c3389hA.p() : null;
        C3418j0 c3418j0Y = y();
        Boolean boolO = c3418j0Y != null ? c3418j0Y.o() : null;
        String strE2 = E();
        byte bQ = Q();
        G adNotReadyMetadata = new G(e0S, strP, boolO, strE2, bQ);
        mb.getClass();
        Intrinsics.checkNotNullParameter(adNotReadyMetadata, "adNotReadyMetadata");
        HashMap map = new HashMap();
        long j = e0S.c;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        if (bQ == 0) {
            s = 2204;
        } else if (bQ == 1) {
            s = 2205;
        } else if (bQ == 2) {
            s = 2206;
        } else if (bQ == 3) {
            s = 2207;
        } else if (bQ == 6) {
            s = 2208;
        } else {
            s = bQ == 7 ? (short) 2209 : (short) 2210;
        }
        map.put("errorCode", Short.valueOf(s));
        if (strE2 != null) {
            map.put("markupType", strE2);
        }
        if (strP != null) {
            map.put("creativeType", "\"" + strP + '\"');
        }
        if (boolO != null) {
            map.put("isRewarded", boolO);
        }
        String strA = e0S.a();
        if (strA.length() > 0) {
            map.put("metadataBlob", strA);
        }
        map.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, e0S.f3053a.q());
        map.put("networkType", C3435k3.q());
        map.put("plId", Long.valueOf(e0S.f3053a.I().l()));
        map.put("isAdLoaded", Boolean.valueOf(mb.f3138a));
        String strM = e0S.f3053a.I().m();
        if (strM != null) {
            map.put("plType", strM);
        }
        Ob ob = Ob.f3160a;
        Ob.b("AdNotReady", map, Sb.SDK);
    }

    public final void K0() {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).a("InMobiInterstitial", "Successfully loaded Interstitial ad markup in the WebView for placement id: " + I());
        }
        i();
        r0();
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void a(int i, Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public final short b(Context context) {
        int i;
        try {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", ">>> Starting InMobiAdActivity to display interstitial ad ...");
            }
            r container = k();
            if (container == null) {
                return (short) 2155;
            }
            if (Intrinsics.areEqual("unknown", container.getMarkupType())) {
                return (short) 2156;
            }
            SparseArray sparseArray = InMobiAdActivity.k;
            Intrinsics.checkNotNullParameter(container, "container");
            int iHashCode = container.hashCode();
            InMobiAdActivity.k.put(iHashCode, container);
            Intent intent = new Intent(context, (Class<?>) InMobiAdActivity.class);
            L4 obj = this.j;
            if (obj != null) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                HashMap map = AbstractC3636y4.f3484a;
                String key = string.toString();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(obj, "obj");
                AbstractC3636y4.f3484a.put(key, new WeakReference(obj));
                intent.putExtra("loggerCacheKey", string.toString());
            }
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", iHashCode);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            String strE = E();
            if (Intrinsics.areEqual(strE, "html")) {
                i = 200;
            } else {
                i = Intrinsics.areEqual(strE, "htmlUrl") ? 202 : 201;
            }
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", i);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
            if (context == null) {
                return (short) 2157;
            }
            if (b0()) {
                if (C() == -1) {
                    a(System.currentTimeMillis());
                }
                if (z() > 0) {
                    intent.setFlags(603979776);
                }
            }
            C3517pb.f3400a.a(context, intent);
            return (short) 0;
        } catch (Exception e) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).b("InMobiInterstitial", "Cannot show ad; SDK encountered an unexpected error");
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
            return (short) 2154;
        }
    }

    @Override // com.inmobi.media.C0
    public void c0() {
        if (C0()) {
            super.c0();
        }
    }

    @Override // com.inmobi.media.C0
    public void g() {
        super.g();
        this.P = null;
    }

    public final void h(AbstractC3520q0 abstractC3520q0) {
        short sB = b(t());
        if (abstractC3520q0 == null) {
            L4 l4 = this.j;
            if (l4 != null) {
                ((M4) l4).b("InMobiInterstitial", "Listener was garbage collected.Unable to give callback");
                return;
            }
            return;
        }
        if (sB != 0) {
            a(true, sB);
        } else {
            abstractC3520q0.e();
        }
    }

    public final void i(AbstractC3520q0 abstractC3520q0) {
        if (abstractC3520q0 == null) {
            L4 l4 = this.j;
            if (l4 != null) {
                ((M4) l4).b("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
            }
            a(true, (short) 2151);
            return;
        }
        Function0 function0 = this.P;
        if (function0 != null) {
            function0.invoke();
            return;
        }
        if (!G0()) {
            AbstractC3498o6.a((byte) 2, "InMobiInterstitial", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l5).b("w5", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            }
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            AbstractC3498o6.a((byte) 1, "w5", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            a(true, (short) 2152);
            return;
        }
        g(abstractC3520q0);
        d((byte) 6);
        if (!Intrinsics.areEqual("html", E()) && !Intrinsics.areEqual("htmlUrl", E())) {
            C3575u c3575uV = v();
            int iHashCode = hashCode();
            C3511p5 c3511p5 = new C3511p5(this, abstractC3520q0);
            c3575uV.getClass();
            C3575u.a(iHashCode, c3511p5);
            return;
        }
        if (!W()) {
            h(abstractC3520q0);
            return;
        }
        b(abstractC3520q0, (short) 2153);
        r rVarK = k();
        if (rVarK != null) {
            rVarK.b();
        }
    }

    public final void j(final AbstractC3520q0 abstractC3520q0) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            i(abstractC3520q0);
        } else {
            int i = S3.f3188a;
            ((ExecutorC3596v6) S3.d.getValue()).f3456a.post(new Runnable() { // from class: com.inmobi.media.w5$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C3609w5.a(this.f$0, abstractC3520q0);
                }
            });
        }
    }

    @Override // com.inmobi.media.C0
    public void j0() {
        if (p0()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", "renderAd without internet check");
            }
            H0();
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l5).a("w5", "renderAd");
        }
        a(new C3581u5(this), new C3595v5(this));
    }

    @Override // com.inmobi.media.C0
    public void k0() {
        super.k0();
        this.M = 0;
    }

    @Override // com.inmobi.media.C0
    public void l(Ba ba) {
        super.l(ba);
        if (!b0()) {
            if (Q() == 2) {
                b((byte) 1);
                K0();
                return;
            }
            return;
        }
        int iIndexOf = this.g.indexOf(ba);
        if (iIndexOf < A()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", "Ignoring loaded ad with index " + iIndexOf + " as current rendering index is " + A());
                return;
            }
            return;
        }
        B().add(Integer.valueOf(iIndexOf));
        for (int i = 0; i < iIndexOf; i++) {
            if (this.g.get(i) != null) {
                return;
            }
        }
        if (Q() == 2) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l5).a("w5", "Providing success based on index " + iIndexOf);
            }
            b((byte) 1);
            h(iIndexOf);
            K0();
        }
    }

    @Override // com.inmobi.media.C0
    public String q() {
        return com.safedk.android.analytics.brandsafety.l.w;
    }

    @Override // com.inmobi.media.C0
    public void q0() {
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R != null) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", "callback - onFetchSuccess");
            }
            e(abstractC3520q0R);
            return;
        }
        b((short) 2188);
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l5).b("w5", "listener is null");
        }
    }

    @Override // com.inmobi.media.C0
    public void r0() {
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l4).d("w5", "AdUnit " + this + " state - READY");
        }
        d((byte) 4);
        E0 e0S = s();
        e0S.getClass();
        e0S.i = SystemClock.elapsedRealtime();
        u0();
        z0();
        this.O.f3138a = true;
        AbstractC3520q0 abstractC3520q0R = r();
        if (abstractC3520q0R == null || !abstractC3520q0R.a()) {
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l5).a("w5", "signaling Success");
        }
        f(abstractC3520q0R);
    }

    @Override // com.inmobi.media.C0
    public Ba w() {
        Ba baW = super.w();
        if (this.N && baW != null) {
            baW.e();
        }
        return baW;
    }

    public static final void e(C3609w5 this$0) {
        LinkedList<C3389h> linkedListF;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
        if (this$0.b0()) {
            C3418j0 c3418j0Y = this$0.y();
            int size = (c3418j0Y == null || (linkedListF = c3418j0Y.f()) == null) ? 0 : linkedListF.size();
            for (int i = 1; i < size; i++) {
                this$0.g(this$0.z() + 1);
                this$0.s0();
            }
        }
    }

    @Override // com.inmobi.media.C0
    public void c(String monetizationContext) {
        Intrinsics.checkNotNullParameter(monetizationContext, "monetizationContext");
        super.c("activity");
    }

    @Override // com.inmobi.media.Da
    public synchronized void d(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.d(renderView);
        Handler handlerD = D();
        if (handlerD != null) {
            handlerD.post(new Runnable() { // from class: com.inmobi.media.w5$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    C3609w5.c(this.f$0);
                }
            });
        }
    }

    public final void a(Mb mb) {
        Intrinsics.checkNotNullParameter(mb, "<set-?>");
        this.O = mb;
    }

    @Override // com.inmobi.media.C0
    public void a(byte[] bArr) {
        if (C0()) {
            super.a(bArr);
        }
    }

    public static final void a(C3609w5 this$0, AbstractC3520q0 abstractC3520q0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(abstractC3520q0);
    }

    @Override // com.inmobi.media.Da
    public synchronized void e(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.e(renderView);
        Handler handlerD = D();
        if (handlerD != null) {
            handlerD.post(new Runnable() { // from class: com.inmobi.media.w5$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    C3609w5.d(this.f$0);
                }
            });
        }
    }

    public static final void a(final C3609w5 this$0, Ba renderView, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        final int iIndexOf = this$0.g.indexOf(renderView);
        ArrayList list = this$0.g;
        Intrinsics.checkNotNullParameter(list, "list");
        if (iIndexOf < 0 || iIndexOf >= list.size()) {
            return;
        }
        short sB = this$0.b(context);
        if (sB != 0) {
            this$0.f(iIndexOf);
        }
        this$0.b(iIndexOf, sB == 0);
        Handler handlerD = this$0.D();
        if (handlerD != null) {
            handlerD.post(new Runnable() { // from class: com.inmobi.media.w5$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    C3609w5.a(this.f$0, iIndexOf);
                }
            });
        }
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void a(Ba renderView, Context context) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        L4 l4 = this.j;
        if (l4 != null) {
            String strE = C0.e();
            Intrinsics.checkNotNullExpressionValue(strE, "<get-TAG>(...)");
            ((M4) l4).c(strE, "closeCurrentPodAd " + this);
        }
        if (b0()) {
            Integer numHigher = B().higher(Integer.valueOf(this.g.indexOf(renderView)));
            if (numHigher != null) {
                a(numHigher.intValue(), renderView, context);
            } else {
                b();
            }
        }
    }

    @Override // com.inmobi.media.C0
    public void a(AbstractC3520q0 abstractC3520q0) {
        L4 l4 = this.j;
        if (l4 != null) {
            ((M4) l4).c("w5", O5.a("w5", "TAG", "handleAdScreenDismissed ").append((int) Q()).toString());
        }
        if (Q() == 7) {
            int i = this.M - 1;
            this.M = i;
            if (i == 1) {
                d((byte) 6);
                L4 l5 = this.j;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                    ((M4) l5).d("w5", "AdUnit " + this + " state - RENDERED");
                    return;
                }
                return;
            }
            return;
        }
        if (Q() == 6) {
            this.M--;
            L4 l6 = this.j;
            if (l6 != null) {
                ((M4) l6).a("InMobiInterstitial", "Interstitial ad dismissed for placement id: " + I());
            }
            if (abstractC3520q0 != null) {
                abstractC3520q0.b();
                return;
            }
            L4 l7 = this.j;
            if (l7 != null) {
                ((M4) l7).c("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
            }
        }
    }

    @Override // com.inmobi.media.C0
    public void b(Ba ba, short s) {
        super.b(ba, s);
        if (b0()) {
            int iIndexOf = this.g.indexOf(ba);
            boolean z = false;
            C0.a(this, iIndexOf, false, 2, null);
            int size = this.g.size();
            boolean z2 = true;
            boolean z3 = true;
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = z2;
                    i = -1;
                    break;
                }
                if (i != iIndexOf && this.g.get(i) != null) {
                    if (B().contains(Integer.valueOf(i))) {
                        break;
                    }
                    z2 = false;
                    z3 = false;
                }
                i++;
            }
            if (i != -1) {
                if (z3 && Q() == 2) {
                    b((byte) 1);
                    h(i);
                    L4 l4 = this.j;
                    if (l4 != null) {
                        ((M4) l4).a("w5", O5.a("w5", "TAG", "Providing success based on currIndex ").append(A()).append(" as ").append(iIndexOf).append(" failed").toString());
                    }
                    K0();
                    return;
                }
                return;
            }
            if (z && Q() == 2) {
                L4 l5 = this.j;
                if (l5 != null) {
                    ((M4) l5).a("InMobiInterstitial", "Failed to load the Interstitial markup in the WebView for placement id: " + I());
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
                return;
            }
            return;
        }
        if (Q() == 2) {
            L4 l6 = this.j;
            if (l6 != null) {
                ((M4) l6).a("InMobiInterstitial", "Failed to load the Interstitial markup in the WebView for placement id: " + I());
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
        }
    }

    @Override // com.inmobi.media.C0
    public void a(boolean z, InMobiAdRequestStatus status) {
        String placementType;
        Intrinsics.checkNotNullParameter(status, "status");
        L4 l4 = this.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l4).c("w5", "onDidParseAfterFetch - parsingResult - " + z);
        }
        super.a(z, status);
        if (Q() == 2) {
            L4 l5 = this.j;
            if (l5 != null) {
                ((M4) l5).a("InMobiInterstitial", "Interstitial ad successfully fetched for placement id: " + I());
            }
            if (Intrinsics.areEqual(E(), "inmobiJson") && (placementType = I().m()) != null) {
                EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
                L4 l6 = this.j;
                Intrinsics.checkNotNullParameter("intNative", "logType");
                Intrinsics.checkNotNullParameter(placementType, "placementType");
                TelemetryConfig.LoggingConfig loggingConfig = C3442ka.d.getLoggingConfig();
                if (l6 != null) {
                    EnumC3396h6 logLevel = C3442ka.a("intNative", placementType, loggingConfig);
                    double dB = C3442ka.b("intNative", placementType, loggingConfig);
                    K4 config = new K4(logLevel, dB);
                    Intrinsics.checkNotNullParameter(config, "config");
                    Objects.toString(config);
                    C3414ia c3414ia = ((M4) l6).f3133a;
                    if (c3414ia != null) {
                        Intrinsics.checkNotNullParameter(config, "config");
                        Objects.toString(config);
                        Objects.toString(c3414ia.i);
                        if (!c3414ia.i.get()) {
                            C3424j6 c3424j6 = c3414ia.e;
                            c3424j6.getClass();
                            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                            c3424j6.f3346a = logLevel;
                            c3414ia.f.f3361a = dB;
                        }
                    }
                }
            }
            q0();
        }
    }

    @Override // com.inmobi.media.C0
    public void b(AbstractC3520q0 abstractC3520q0) {
        if (Q() == 6) {
            int i = this.M + 1;
            this.M = i;
            if (i == 1) {
                L4 l4 = this.j;
                if (l4 != null) {
                    ((M4) l4).a("InMobiInterstitial", "Successfully displayed Interstitial for placement id: " + I());
                }
                if (abstractC3520q0 != null) {
                    b((byte) 4);
                    d(abstractC3520q0);
                    return;
                }
                return;
            }
            d((byte) 7);
            return;
        }
        if (Q() == 7) {
            this.M++;
        }
    }

    public final void b(AbstractC3520q0 abstractC3520q0, short s) {
        a(true, s);
        d((byte) 0);
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void b() {
        if (b0()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", "Closing the ad as closeAll is called");
            }
            Handler handlerD = D();
            if (handlerD != null) {
                handlerD.post(new Runnable() { // from class: com.inmobi.media.w5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3609w5.b(this.f$0);
                    }
                });
            }
        }
    }

    public static final void b(C3609w5 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        L4 l4 = this$0.j;
        if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("C0", "TAG");
            ((M4) l4).a("C0", "clearAdPods " + this$0);
        }
        if (this$0.A) {
            this$0.h();
            this$0.g.clear();
            this$0.w = 0;
            this$0.x = 0;
            this$0.z.clear();
        }
        L4 l5 = this$0.j;
        if (l5 != null) {
            ((M4) l5).c("InMobiInterstitial", "Interstitial ad dismissed for placement id: " + this$0.I());
        }
        if (this$0.r() != null) {
            AbstractC3520q0 abstractC3520q0R = this$0.r();
            if (abstractC3520q0R != null) {
                abstractC3520q0R.b();
                return;
            }
            return;
        }
        L4 l6 = this$0.j;
        if (l6 != null) {
            ((M4) l6).c("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
        }
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.Pc
    public void a(C3389h ad, boolean z, short s) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        if (!z) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
            return;
        }
        try {
            super.a(ad, z, s);
        } catch (IllegalStateException e) {
            L4 l4 = this.j;
            if (l4 != null) {
                ((M4) l4).b("w5", O5.a("w5", "TAG", "Exception while onVastProcessCompleted : ").append(e.getMessage()).toString());
            }
        }
        C3389h c3389hM = m();
        if (c3389hM == null) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 55);
        } else if (c3389hM.G()) {
            b(true);
            V();
        } else {
            a(c3389hM);
        }
    }

    @Override // com.inmobi.media.C0
    public void a(J placement, boolean z) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        super.a(placement, z);
        if (!z) {
            if (Intrinsics.areEqual(I(), placement)) {
                if (2 == Q() || 4 == Q()) {
                    d((byte) 0);
                    L4 l4 = this.j;
                    if (l4 != null) {
                        Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                        ((M4) l4).d("w5", "AdUnit " + this + " state - CREATED");
                    }
                    b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), false, (short) 0);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(I(), placement) && 2 == Q()) {
            L4 l5 = this.j;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l5).a("w5", "Asset are ready now");
            }
            if (a0()) {
                c(true);
                f();
            } else {
                r0();
            }
        }
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public void a(int i, final Ba renderView, final Context context) {
        Ba ba;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (!b0()) {
            L4 l4 = this.j;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                ((M4) l4).a("w5", "Cannot show an pod ad as isPod is not set.");
                return;
            }
            return;
        }
        if (B().contains(Integer.valueOf(i)) && i > this.g.indexOf(renderView) && i < this.g.size() && this.g.get(i) != null && ((ba = (Ba) this.g.get(i)) == null || ba.p0)) {
            if (context == null) {
                context = t();
            }
            super.a(i, renderView, context);
            Handler handlerD = D();
            if (handlerD != null) {
                handlerD.post(new Runnable() { // from class: com.inmobi.media.w5$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        C3609w5.a(this.f$0, renderView, context);
                    }
                });
                return;
            }
            return;
        }
        L4 l5 = this.j;
        if (l5 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l5).a("w5", "Cannot show an pod ad with invalid index passed");
        }
        b(this.g.indexOf(renderView), false);
    }

    public static final void a(C3609w5 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(i, false);
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.K
    public boolean a(Ba renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (b0()) {
            return B().higher(Integer.valueOf(this.g.indexOf(renderView))) != null;
        }
        return false;
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.InterfaceC3346dc
    public void a(byte b) {
        if (b == 1) {
            if (b0()) {
                if (Q() == 2) {
                    if (B().isEmpty()) {
                        L4 l4 = this.j;
                        if (l4 != null) {
                            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                            ((M4) l4).b("w5", "RenderView time out, none of the ad provided success");
                        }
                        h();
                        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2139);
                        return;
                    }
                    b((byte) 1);
                    L4 l5 = this.j;
                    if (l5 != null) {
                        ((M4) l5).a("w5", O5.a("w5", "TAG", "RenderView time out, providing success based on ").append(B().first()).toString());
                    }
                    Integer numFirst = B().first();
                    Intrinsics.checkNotNullExpressionValue(numFirst, "first(...)");
                    h(numFirst.intValue());
                    K0();
                    int size = this.g.size();
                    for (int i = 0; i < size; i++) {
                        if (!B().contains(Integer.valueOf(i))) {
                            C0.a(this, i, false, 2, null);
                        }
                    }
                    return;
                }
                h();
                return;
            }
            super.a(b);
            return;
        }
        super.a(b);
    }

    @Override // com.inmobi.media.C0, com.inmobi.media.Da
    public void a(Ba renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.a(renderView, z);
        byte bQ = Q();
        if (bQ == 4) {
            this.P = new C3567t5(this, z ? (short) 2220 : (short) 2219);
            return;
        }
        if (bQ != 6) {
            if (bQ == 7) {
                short s = z ? (short) 2224 : (short) 2223;
                AbstractC3498o6.a((byte) 2, "InMobiInterstitial", "RenderProcess of the WebView has crashed. Please create another adUnit");
                L4 l4 = this.j;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("w5", "TAG");
                    ((M4) l4).b("w5", "RenderProcess of the WebView has crashed. Please create another adUnit");
                }
                renderView.a(z, s);
                Activity fullScreenActivity = renderView.getFullScreenActivity();
                if (fullScreenActivity != null) {
                    L4 l5 = renderView.i;
                    if (l5 != null) {
                        String TAG = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((M4) l5).c(TAG, "fullScreenActivity is not null and finishing");
                    }
                    fullScreenActivity.finish();
                }
                a(r());
                return;
            }
            return;
        }
        short s2 = z ? (short) 2222 : (short) 2221;
        AbstractC3498o6.a((byte) 2, "InMobiInterstitial", "RenderProcess of the WebView has crashed. Please create another adUnit");
        L4 l6 = this.j;
        if (l6 != null) {
            Intrinsics.checkNotNullExpressionValue("w5", "TAG");
            ((M4) l6).b("w5", "RenderProcess of the WebView has crashed. Please create another adUnit");
        }
        Activity fullScreenActivity2 = renderView.getFullScreenActivity();
        if (fullScreenActivity2 != null) {
            L4 l7 = renderView.i;
            if (l7 != null) {
                String TAG2 = Ba.O0;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l7).c(TAG2, "fullScreenActivity is not null and finishing");
            }
            fullScreenActivity2.finish();
        }
        if (this.M == 0) {
            a(true, s2);
        } else {
            renderView.a(z, s2);
            a(r());
        }
    }
}
