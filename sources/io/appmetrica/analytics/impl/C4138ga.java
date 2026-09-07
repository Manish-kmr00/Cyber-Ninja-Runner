package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ga, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4138ga {
    public static volatile C4138ga c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11566a;
    public final HashMap b = new HashMap();

    public C4138ga(Context context) {
        this.f11566a = context;
    }

    public static C4138ga a(Context context) {
        if (c == null) {
            synchronized (C4138ga.class) {
                if (c == null) {
                    c = new C4138ga(context);
                }
            }
        }
        return c;
    }

    public final D9 a(String str) {
        if (!this.b.containsKey(str)) {
            synchronized (this) {
                if (!this.b.containsKey(str)) {
                    this.b.put(str, new D9(this.f11566a, str));
                }
            }
        }
        return (D9) this.b.get(str);
    }
}
