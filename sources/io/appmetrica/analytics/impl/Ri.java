package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Ri implements InterfaceC4226k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Ke f11334a;
    public ScreenInfo b;
    public boolean c;
    public boolean d;
    public final Qi e = new Qi();
    public WeakReference f = new WeakReference(null);

    public final synchronized void a(Activity activity) {
        this.f = new WeakReference(activity);
        if (!this.d) {
            if (this.f11334a == null) {
                this.f11334a = new Ke(C4135g7.a(activity).a());
            }
            Ke ke = this.f11334a;
            Intrinsics.checkNotNull(ke);
            this.b = ke.p();
            if (this.f11334a == null) {
                this.f11334a = new Ke(C4135g7.a(activity).a());
            }
            Ke ke2 = this.f11334a;
            Intrinsics.checkNotNull(ke2);
            this.c = ke2.t();
            this.d = true;
        }
        if (this.b == null) {
            b(activity);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            this.e.getClass();
            ScreenInfo screenInfoA = Qi.a(context);
            if (screenInfoA == null || Intrinsics.areEqual(screenInfoA, this.b)) {
                return;
            }
            this.b = screenInfoA;
            if (this.f11334a == null) {
                this.f11334a = new Ke(C4135g7.a(context).a());
            }
            Ke ke = this.f11334a;
            Intrinsics.checkNotNull(ke);
            ke.a(this.b);
        }
    }

    public final synchronized ScreenInfo a(Context context) {
        if (!this.d) {
            if (this.f11334a == null) {
                this.f11334a = new Ke(C4135g7.a(context).a());
            }
            Ke ke = this.f11334a;
            Intrinsics.checkNotNull(ke);
            this.b = ke.p();
            if (this.f11334a == null) {
                this.f11334a = new Ke(C4135g7.a(context).a());
            }
            Ke ke2 = this.f11334a;
            Intrinsics.checkNotNull(ke2);
            this.c = ke2.t();
            this.d = true;
        }
        b((Context) this.f.get());
        if (this.b == null) {
            if (AndroidUtils.isApiAchieved(30)) {
                if (!this.c) {
                    b(context);
                    this.c = true;
                    if (this.f11334a == null) {
                        this.f11334a = new Ke(C4135g7.a(context).a());
                    }
                    Ke ke3 = this.f11334a;
                    Intrinsics.checkNotNull(ke3);
                    ke3.v();
                }
            } else {
                b(context);
            }
        }
        return this.b;
    }

    public final void a(Ke ke) {
        this.f11334a = ke;
    }
}
