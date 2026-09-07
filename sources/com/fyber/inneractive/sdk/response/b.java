package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3071a;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2320a;
    public String b;
    public j c;
    public boolean d = true;

    public abstract e a();

    public final e a(String str) throws Exception {
        this.d = str != null;
        e eVar = this.f2320a;
        eVar.getClass();
        eVar.c = System.currentTimeMillis();
        this.c.a(this);
        String strA = this.c.a();
        this.f2320a.h = strA;
        T tA = AbstractC3071a.a(this.b);
        IAlog.a("%sGot unit config for unitId: %s from config manager", IAlog.a(this), this.b);
        IAlog.a("%s%s", IAlog.a(this), tA);
        if (this.d) {
            a(str, tA);
        } else if (this instanceof com.fyber.inneractive.sdk.dv.h) {
            a(strA, tA);
        } else {
            h hVar = new h(strA);
            if (hVar.f2322a) {
                String str2 = hVar.b;
                if (str2 == null || TextUtils.isEmpty(str2.trim())) {
                    throw new Exception("empty ad content detected. failing fast.");
                }
                a(str2, tA);
            }
        }
        return this.f2320a;
    }

    public abstract void a(String str, T t);
}
