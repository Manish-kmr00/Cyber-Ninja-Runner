package com.mbridge.msdk.tracker;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes7.dex */
public class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5615a;
    private JSONObject d;
    private h i;
    private int b = 0;
    private int c = 0;
    private long g = 0;
    private long h = 604800000;
    private boolean j = false;
    private boolean k = false;
    private long f = System.currentTimeMillis();
    private String e = UUID.randomUUID().toString();

    public e(String str) {
        this.f5615a = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public String b() {
        return this.f5615a;
    }

    public int c() {
        return this.c;
    }

    public JSONObject d() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.d = jSONObject2;
        return jSONObject2;
    }

    public h e() {
        return this.i;
    }

    public long f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public int h() {
        return this.b;
    }

    public String i() {
        return this.e;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return this.j;
    }

    public void a(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(long j) {
        this.f = j;
    }

    void a(String str) {
        this.e = str;
    }

    void b(long j) {
        this.h = j;
    }

    public long a() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(h hVar) {
        this.i = hVar;
    }

    public void a(boolean z) {
        this.k = z;
    }
}
