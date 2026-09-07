package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j6 extends g5 implements q0.e {
    private final com.applovin.impl.sdk.network.a g;
    private final q0.e h;
    private b6.b i;
    private v4 j;
    private v4 k;
    protected q0.b l;

    public j6(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
        this(aVar, kVar, false);
    }

    public abstract void a(String str, int i, String str2, Object obj);

    public abstract void a(String str, Object obj, int i);

    @Override // java.lang.Runnable
    public void run() {
        q0 q0VarX = b().x();
        if (!b().F0() && !b().C0()) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "AppLovin SDK is disabled");
            a(this.g.f(), -22, null, null);
        } else if (!StringUtils.isValidString(this.g.f()) || this.g.f().length() < 4) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Task has an invalid or null request endpoint.");
            }
            a(this.g.f(), AppLovinErrorCodes.INVALID_URL, null, null);
        } else {
            if (TextUtils.isEmpty(this.g.h())) {
                this.g.b(this.g.b() != null ? "POST" : "GET");
            }
            q0VarX.a(this.g, this.l, this.h);
        }
    }

    public j6(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z) {
        super("TaskRepeatRequest", kVar, z);
        this.i = b6.b.OTHER;
        if (aVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        a(aVar.f());
        this.g = aVar;
        this.l = new q0.b();
        this.h = new a(kVar);
    }

    public void b(v4 v4Var) {
        this.k = v4Var;
    }

    public void c(v4 v4Var) {
        this.j = v4Var;
    }

    public void a(b6.b bVar) {
        this.i = bVar;
    }

    class a implements q0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.k f467a;

        a(com.applovin.impl.sdk.k kVar) {
            this.f467a = kVar;
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, Object obj, int i) {
            j6.this.g.a(0);
            j6.this.a(str, obj, i);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, Object obj) {
            long millis;
            boolean z = false;
            boolean z2 = i < 200 || i >= 500;
            boolean z3 = i == 429;
            boolean z4 = i != -1009 || j6.this.g.q();
            boolean z5 = (i == -900 || i == -1000) ? false : true;
            if (z4 && z5 && (z2 || z3 || j6.this.g.p())) {
                String strA = j6.this.g.a();
                if (j6.this.g.j() <= 0) {
                    if (strA != null && strA.equals(j6.this.g.f())) {
                        j6 j6Var = j6.this;
                        j6Var.a(j6Var.k);
                    } else {
                        j6 j6Var2 = j6.this;
                        j6Var2.a(j6Var2.j);
                    }
                    j6 j6Var3 = j6.this;
                    j6Var3.a(j6Var3.g.f(), i, str2, obj);
                    return;
                }
                com.applovin.impl.sdk.o oVar = j6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    j6 j6Var4 = j6.this;
                    j6Var4.c.k(j6Var4.b, "Unable to send request due to server failure (code " + i + "). " + j6.this.g.j() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(j6.this.g.k()) + " seconds...");
                }
                int iJ = j6.this.g.j() - 1;
                j6.this.g.a(iJ);
                if (iJ == 0) {
                    j6 j6Var5 = j6.this;
                    j6Var5.a(j6Var5.j);
                    if (StringUtils.isValidString(strA) && strA.length() >= 4) {
                        com.applovin.impl.sdk.o oVar2 = j6.this.c;
                        if (com.applovin.impl.sdk.o.a()) {
                            j6 j6Var6 = j6.this;
                            j6Var6.c.d(j6Var6.b, "Switching to backup endpoint " + strA);
                        }
                        j6.this.g.a(strA);
                        z = true;
                    }
                }
                if (((Boolean) this.f467a.a(v4.e3)).booleanValue() && z) {
                    millis = 0;
                } else {
                    millis = j6.this.g.n() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, j6.this.g.c())) : j6.this.g.k();
                }
                b6 b6VarR0 = this.f467a.r0();
                j6 j6Var7 = j6.this;
                b6VarR0.a(j6Var7, j6Var7.i, millis);
                return;
            }
            j6 j6Var8 = j6.this;
            j6Var8.a(j6Var8.g.f(), i, str2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v4 v4Var) {
        if (v4Var != null) {
            b().p0().a(v4Var, v4Var.a());
        }
    }
}
