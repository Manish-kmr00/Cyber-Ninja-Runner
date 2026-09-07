package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class y implements com.fyber.inneractive.sdk.click.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f1841a;
    public final /* synthetic */ EnumC3243g b;
    public final /* synthetic */ A c;

    public y(A a2, h0 h0Var, EnumC3243g enumC3243g) {
        this.c = a2;
        this.f1841a = h0Var;
        this.b = enumC3243g;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        A a2 = this.c;
        a2.getClass();
        IAlog.a("%s super click result: %s", IAlog.a(a2), bVar);
        A a3 = this.c;
        if (a3.h == null) {
            IAlog.a("%s click handler is null. Probably cancelled", IAlog.a(a3));
            return;
        }
        a3.h = null;
        a3.i = null;
        a3.E();
        A a4 = this.c;
        h0 h0Var = this.f1841a;
        EnumC3243g enumC3243g = this.b;
        a4.getClass();
        com.fyber.inneractive.sdk.click.q qVar = bVar.f1653a;
        if (qVar == com.fyber.inneractive.sdk.click.q.OPEN_IN_EXTERNAL_APPLICATION || qVar == com.fyber.inneractive.sdk.click.q.OPEN_GOOGLE_STORE) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external application", new Object[0]);
            ArrayList arrayList = bVar.f;
            com.fyber.inneractive.sdk.click.j jVar = (com.fyber.inneractive.sdk.click.j) arrayList.get(arrayList.size() - 1);
            com.fyber.inneractive.sdk.click.q qVar2 = jVar.c;
            if (qVar2 == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) {
                a4.a(jVar.f1660a, qVar2);
            }
            if (a4.c != null) {
                a4.D();
            }
        } else if (qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_INTERNAL_BROWSER) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in internal browser", new Object[0]);
            a4.d = true;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(a4);
        } else if (qVar == com.fyber.inneractive.sdk.click.q.OPENED_USING_CHROME_NAVIGATE || qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external browser", new Object[0]);
            a4.a(bVar.d, bVar.f1653a);
            if (a4.c != null) {
                a4.D();
            }
        }
        if (a4.o() == com.fyber.inneractive.sdk.ignite.m.NONE || !(TextUtils.isEmpty(bVar.c) || bVar.c.equals("IgniteGooglePlay"))) {
            a4.b(bVar, h0Var, enumC3243g);
        }
    }
}
