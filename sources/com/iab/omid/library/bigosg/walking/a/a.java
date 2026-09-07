package com.iab.omid.library.bigosg.walking.a;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HashSet<String> f2578a;
    protected final JSONObject b;
    protected final long c;

    public a(b.InterfaceC0342b interfaceC0342b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0342b);
        this.f2578a = new HashSet<>(hashSet);
        this.b = jSONObject;
        this.c = j;
    }
}
