package com.five_corp.ad.internal;

import android.util.Log;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

/* JADX INFO: loaded from: classes11.dex */
public final class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.context.m f1261a;
    public final /* synthetic */ com.five_corp.ad.internal.ad_check.b b;
    public final /* synthetic */ com.five_corp.ad.internal.ad_check.c c;
    public final /* synthetic */ B d;

    public A(B b, com.five_corp.ad.internal.context.m mVar, com.five_corp.ad.internal.ad_check.b bVar, com.five_corp.ad.internal.ad_check.c cVar) {
        this.d = b;
        this.f1261a = mVar;
        this.b = bVar;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = B.g;
            com.five_corp.ad.internal.util.f fVarA = this.d.b.a(this.d.f1262a.b(this.f1261a), "POST", this.d.f1262a.a(this.f1261a).toString(), "application/json;charset=utf-8");
            if (!fVarA.f1560a) {
                this.b.a(fVarA.b);
                return;
            }
            com.five_corp.ad.internal.http.c cVar = (com.five_corp.ad.internal.http.c) fVarA.c;
            int i2 = cVar.f1392a;
            if (i2 == 403) {
                this.b.a(new o(p.W, null, null, null));
                return;
            }
            if (i2 / 100 == 5) {
                this.b.a(new o(p.X, null, null, null));
                return;
            }
            if (i2 / 100 == 4) {
                this.b.a(new o(p.Y, null, null, null));
                return;
            }
            String strA = cVar.a();
            if (strA == null) {
                this.b.a(new o(p.Z, null, null, null));
                return;
            }
            if (strA.isEmpty()) {
                this.b.a(new o(p.a0, null, null, null));
                return;
            }
            try {
                com.five_corp.ad.internal.ad_check.a aVarA = com.five_corp.ad.internal.parser.a.a(strA);
                int iA = com.five_corp.ad.e.a(aVarA.f1312a);
                if (iA == 0) {
                    this.b.a(new o(p.T, null, null, null));
                } else if (iA == 1) {
                    this.b.a(new o(p.e0, null, null, null));
                } else {
                    if (iA != 2) {
                        return;
                    }
                    this.c.a((List) Objects.requireNonNull(aVarA.b));
                }
            } catch (com.five_corp.ad.internal.exception.b e) {
                int i3 = B.g;
                e.toString();
                this.b.a(new o(e.f1373a, null, e, null));
            } catch (JSONException e2) {
                int i4 = B.g;
                e2.toString();
                this.b.a(new o(p.b0, null, e2, null));
            }
        } catch (Exception e3) {
            int i5 = B.g;
            e3.toString();
            Log.getStackTraceString(e3);
            this.b.a(new o(p.c0, null, e3, null));
        }
    }
}
