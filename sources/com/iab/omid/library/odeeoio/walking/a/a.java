package com.iab.omid.library.odeeoio.walking.a;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet<String> f2790a;
    protected final JSONObject b;
    protected final long c;

    public a(b.InterfaceC0365b interfaceC0365b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0365b);
        this.f2790a = new HashSet<>(hashSet);
        this.b = jSONObject;
        this.c = j;
    }
}
