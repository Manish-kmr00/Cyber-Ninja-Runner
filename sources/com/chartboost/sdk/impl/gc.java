package com.chartboost.sdk.impl;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class gc extends pc {
    public final HashSet<String> c;
    public final JSONObject d;
    public final long e;

    public gc(pc.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar);
        this.c = new HashSet<>(hashSet);
        this.d = jSONObject;
        this.e = j;
    }
}
