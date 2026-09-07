package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.I;
import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.mraid.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public abstract class AbstractC3123f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1899a;
    public final Map b;
    public final I c;
    public final h0 d;

    public AbstractC3123f(Map map, I i, h0 h0Var) {
        this.b = map;
        this.d = h0Var;
        this.c = i;
    }

    public final int a(String str) {
        String str2 = (String) this.b.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2, 10);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public abstract void a();

    public abstract boolean b();
}
