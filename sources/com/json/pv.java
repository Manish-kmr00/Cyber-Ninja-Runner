package com.json;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class pv {
    private int b = 4;
    private int c = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Boolean> f4171a = new a();

    class a extends HashMap<String, Boolean> {
        a() {
            put(ug.k, Boolean.valueOf(pv.this.b == 0));
            put(ug.l, Boolean.valueOf(pv.this.c == 0));
            Boolean bool = Boolean.FALSE;
            put(ug.m, bool);
            put(ug.n, bool);
        }
    }

    pv() {
    }

    public JSONObject a() {
        return new JSONObject(this.f4171a);
    }

    void a(String str, int i, boolean z) {
        if (this.f4171a.containsKey(str)) {
            this.f4171a.put(str, Boolean.valueOf(i == 0));
        }
        this.f4171a.put(ug.m, Boolean.valueOf(z));
        this.f4171a.put(ug.n, Boolean.valueOf((this.f4171a.get(ug.l).booleanValue() || this.f4171a.get(ug.k).booleanValue()) && this.f4171a.get(ug.m).booleanValue()));
    }
}
