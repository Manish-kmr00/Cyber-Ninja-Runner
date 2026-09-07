package com.iab.omid.library.pubmatic.walking.async;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a extends b {
    protected final HashSet<String> c;
    protected final JSONObject d;
    protected final long e;

    public a(b.InterfaceC0373b interfaceC0373b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0373b);
        this.c = new HashSet<>(hashSet);
        this.d = jSONObject;
        this.e = j;
    }
}
