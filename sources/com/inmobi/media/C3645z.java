package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: renamed from: com.inmobi.media.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C3645z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3490a;
    public final String b;
    public final boolean c;
    public final AtomicBoolean d;
    public final String e;
    public L4 f;

    public C3645z(WeakReference adUnitEventListener, String adtype, boolean z) {
        Intrinsics.checkNotNullParameter(adUnitEventListener, "adUnitEventListener");
        Intrinsics.checkNotNullParameter(adtype, "adtype");
        this.f3490a = adUnitEventListener;
        this.b = adtype;
        this.c = z;
        this.d = new AtomicBoolean(false);
        this.e = String.valueOf(Reflection.getOrCreateKotlinClass(C3645z.class).getSimpleName());
    }

    public final void a(Yb yb) {
        Zb zb;
        AtomicBoolean atomicBoolean;
        if (this.d.getAndSet(true)) {
            L4 l4 = this.f;
            if (l4 != null) {
                ((M4) l4).c(this.e, "skipping as Impression is already Called");
            }
            if (yb != null) {
                E0 e0 = yb.f3248a;
                if (e0 == null || (zb = e0.b) == null || (atomicBoolean = zb.f3259a) == null || !atomicBoolean.getAndSet(true)) {
                    yb.a().put("networkType", C3435k3.q());
                    yb.a().put("errorCode", (short) 2179);
                    LinkedHashMap linkedHashMapA = yb.a();
                    Ob ob = Ob.f3160a;
                    Ob.b("AdImpressionSuccessful", linkedHashMapA, Sb.SDK);
                    return;
                }
                return;
            }
            return;
        }
        C3587ub c3587ub = C3587ub.f3446a;
        String str = this.b;
        Boolean boolValueOf = Boolean.valueOf(this.c);
        c3587ub.getClass();
        C3587ub.a(str, boolValueOf);
        AbstractC3520q0 abstractC3520q0 = (AbstractC3520q0) this.f3490a.get();
        if (abstractC3520q0 != null) {
            abstractC3520q0.a(yb);
        } else if (yb != null) {
            yb.c();
        }
        L4 l5 = this.f;
        if (l5 != null) {
            ((M4) l5).a(this.e, "==== CHECKPOINT REACHED - IMPRESSION FIRED ====");
        }
        L4 l6 = this.f;
        if (l6 != null) {
            ((M4) l6).b();
        }
    }
}
