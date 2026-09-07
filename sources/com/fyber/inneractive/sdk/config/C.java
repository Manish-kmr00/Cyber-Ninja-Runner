package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.C3126b;
import com.fyber.inneractive.sdk.network.C3131g;
import com.fyber.inneractive.sdk.network.i0;
import com.fyber.inneractive.sdk.network.k0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes13.dex */
public final class C implements com.fyber.inneractive.sdk.network.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1667a;

    public C(IAConfigManager iAConfigManager) {
        this.f1667a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        int i;
        I i2 = (I) obj;
        if (i2 != null) {
            if (z) {
                IAConfigManager iAConfigManager = this.f1667a;
                IAConfigManager iAConfigManager2 = IAConfigManager.O;
                iAConfigManager.getClass();
                iAConfigManager.e = i2.c;
                iAConfigManager.d = i2.b;
                iAConfigManager.f1673a = i2.d;
                iAConfigManager.b = i2.e;
            } else {
                IAConfigManager.P = System.currentTimeMillis();
                IAConfigManager iAConfigManager3 = this.f1667a;
                iAConfigManager3.getClass();
                IAlog.a("Got new remote configuration from server:", new Object[0]);
                iAConfigManager3.e = i2.c;
                iAConfigManager3.d = i2.b;
                iAConfigManager3.f1673a = i2.d;
                iAConfigManager3.b = i2.e;
            }
        } else if (exc instanceof C3131g) {
            IAConfigManager.P = System.currentTimeMillis();
        }
        if (z) {
            return;
        }
        IAConfigManager iAConfigManager4 = this.f1667a;
        IAConfigManager iAConfigManager5 = IAConfigManager.O;
        if (iAConfigManager5.e != null) {
            iAConfigManager4.a(null);
        } else {
            iAConfigManager4.getClass();
            if ((exc instanceof InvalidAppIdException) || (exc instanceof FileNotFoundException) || (!(exc instanceof k0) ? !TextUtils.isEmpty(iAConfigManager4.c.trim()) : (i = ((k0) exc).f1923a) < 400 || i >= 500)) {
                iAConfigManager4.a(new InvalidAppIdException());
            } else if (exc instanceof C3126b) {
                iAConfigManager4.a(exc);
            } else {
                iAConfigManager4.a(new J());
            }
        }
        if (iAConfigManager5.e != null) {
            IAConfigManager iAConfigManager6 = this.f1667a;
            if (iAConfigManager6.C == null) {
                iAConfigManager6.C = new com.fyber.inneractive.sdk.network.V(new F(iAConfigManager6), iAConfigManager6.f, new com.fyber.inneractive.sdk.config.global.m());
            }
            i0 i0Var = iAConfigManager6.C.f;
            if (i0Var == i0.RUNNING || i0Var == i0.QUEUED) {
                return;
            }
            iAConfigManager5.s.b(iAConfigManager6.C);
        }
    }
}
