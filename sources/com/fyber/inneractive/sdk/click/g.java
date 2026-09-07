package com.fyber.inneractive.sdk.click;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InternalStoreWebpageActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.G;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.W;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public W f1657a;
    public boolean b;
    public f c;
    public final h0 d;
    public final EnumC3243g e;
    public boolean f = false;

    public g(f fVar, h0 h0Var, EnumC3243g enumC3243g) {
        this.c = fVar;
        this.d = h0Var;
        this.e = enumC3243g;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final boolean a(Uri uri, r rVar) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        W w;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        if (rVar != null) {
            mVar = rVar.l;
            this.b = rVar.k;
            this.f1657a = rVar.j;
        } else {
            mVar = mVar2;
        }
        return mVar != mVar2 && IAConfigManager.O.E.n() && (w = this.f1657a) != null && w.l;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final void cancel() {
        this.f = true;
        this.c = null;
    }

    @Override // com.fyber.inneractive.sdk.click.a
    public final b a(Context context, Uri uri, List list) {
        PackageInfo packageInfo;
        D d;
        W w = this.f1657a;
        if (w != null) {
            boolean z = this.b;
            if (w.C) {
                G g = G.FAILED;
                IllegalStateException illegalStateException = new IllegalStateException("Store controller is already open");
                context.getClass();
                d = new D(g, illegalStateException);
            } else {
                w.C = true;
                try {
                    context.getClass();
                } catch (Throwable unused) {
                }
                w.D = true;
                if (w.j.equals("invalid_task_id") && !w.z) {
                    w.d = z ? com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP;
                }
                w.B = z;
                if (w.A) {
                    w.d("onInstallationSuccess();");
                } else if (!w.z) {
                    String str = w.c;
                    try {
                        packageInfo = !TextUtils.isEmpty(str) ? AbstractC3251o.f2370a.getPackageManager().getPackageInfo(str, 0) : null;
                    } catch (Exception unused2) {
                    }
                    if (packageInfo != null) {
                        w.d("onInstallationSuccess();");
                    } else if (z) {
                        w.b.a(w.c, new com.fyber.inneractive.sdk.ignite.g(w.f, w.d, w.h.f1833a));
                        w.d("onShowInstallStarted();");
                    }
                }
                try {
                    InternalStoreWebpageActivity.startActivity(context, w.e);
                    d = new D(G.OPENED_INTERNAL_STORE, null);
                } catch (ActivityNotFoundException e) {
                    d = new D(G.FAILED, e);
                }
            }
            Throwable th = d.b;
            if (th == null) {
                IAConfigManager.O.s.b(new com.fyber.inneractive.sdk.network.h0(new e(this, list, uri), uri.toString()));
                return new b(uri.toString(), q.OPEN_INTERNAL_STORE, "IgniteGooglePlay", null);
            }
            if (list != null) {
                list.add(new j(this.f1657a.k, false, q.OPEN_INTERNAL_STORE, th.toString()));
            }
            return r.a(uri.toString(), "IgniteGooglePlay", "mInternalStoreWebpageController.show has failed");
        }
        return r.a(uri.toString(), "IgniteGooglePlay", "mInternalStoreWebpageController is null");
    }
}
