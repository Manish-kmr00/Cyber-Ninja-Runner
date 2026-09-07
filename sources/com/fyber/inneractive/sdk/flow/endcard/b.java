package com.fyber.inneractive.sdk.flow.endcard;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.V;
import com.fyber.inneractive.sdk.network.F;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1789a = IAlog.a(this);
    public final V b;
    public k c;
    public int d;

    public b(V v) {
        this.b = v;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public final void a() {
        k kVar = this.c;
        if (kVar != null) {
            kVar.a();
        }
    }

    public abstract void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar);

    public abstract void a(F f);

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public final View b() {
        return f().b();
    }

    public abstract k c();

    public com.fyber.inneractive.sdk.player.ui.c d() {
        com.fyber.inneractive.sdk.config.global.features.w wVar = this.b.g;
        com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
        cVar.b = j();
        cVar.h = h();
        boolean zB = b(wVar);
        Integer numValueOf = Integer.valueOf(a(wVar));
        if (zB) {
            cVar.f = numValueOf;
        }
        return cVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.k
    public void destroy() {
        e();
        k kVar = this.c;
        if (kVar != null) {
            kVar.destroy();
            this.c = null;
        }
    }

    public void e() {
        a();
    }

    public final k f() {
        if (this.c == null) {
            this.c = c();
        }
        return this.c;
    }

    public abstract EnumC3243g g();

    public abstract com.fyber.inneractive.sdk.model.vast.i h();

    public boolean i() {
        return false;
    }

    public abstract boolean j();

    public void k() {
        IAlog.b("%s loading success for %s", h(), this.f1789a);
    }

    public static boolean b(com.fyber.inneractive.sdk.config.global.features.w wVar) {
        if (wVar == null) {
            return false;
        }
        Boolean boolC = wVar.c("shouldEnableEndCardAutoClick");
        return boolC != null ? boolC.booleanValue() : false;
    }

    public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s loading failed for %s", inneractiveInfrastructureError.getCause(), h(), this.f1789a);
    }

    public static int a(com.fyber.inneractive.sdk.config.global.features.w wVar) {
        if (wVar == null) {
            return 3;
        }
        Integer numA = wVar.a("autoClickDelay");
        int iIntValue = numA != null ? numA.intValue() : 3;
        if (iIntValue < 0 || iIntValue > 10) {
            return 3;
        }
        return iIntValue;
    }
}
