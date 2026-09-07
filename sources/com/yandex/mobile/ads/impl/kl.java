package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class kl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<pb2> f9427a;
    private final ct b;
    private final WeakReference<ViewGroup> c;
    private final ql0 d;
    private q70 e;

    public kl(ViewGroup adViewGroup, List<pb2> friendlyOverlays, ct binder, WeakReference<ViewGroup> adViewGroupReference, ql0 binderPrivate, q70 q70Var) {
        Intrinsics.checkNotNullParameter(adViewGroup, "adViewGroup");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        Intrinsics.checkNotNullParameter(binder, "binder");
        Intrinsics.checkNotNullParameter(adViewGroupReference, "adViewGroupReference");
        Intrinsics.checkNotNullParameter(binderPrivate, "binderPrivate");
        this.f9427a = friendlyOverlays;
        this.b = binder;
        this.c = adViewGroupReference;
        this.d = binderPrivate;
        this.e = q70Var;
    }

    public final void b() {
        q70 q70Var;
        ViewGroup viewGroup = this.c.get();
        if (viewGroup != null && (q70Var = this.e) != null) {
            viewGroup.removeView(q70Var);
        }
        this.e = null;
        ct ctVar = this.b;
        ctVar.a((xl2) null);
        ctVar.e();
        ctVar.invalidateAdPlayer();
        ctVar.a();
    }

    public final void c() {
        this.d.a();
    }

    public final void d() {
        this.d.b();
    }

    public final void a() {
        ViewGroup viewGroup = this.c.get();
        if (viewGroup != null) {
            if (this.e == null) {
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                this.e = new q70(context);
                viewGroup.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
            }
            q70 q70Var = this.e;
            if (q70Var != null) {
                this.d.a(q70Var, this.f9427a);
            }
        }
    }

    public final void a(fb2 fb2Var) {
        this.b.a(fb2Var);
    }
}
