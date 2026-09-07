package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Me {
    public static final String c = "Me";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oa f11258a;
    public final String b;

    public Me(Oa oa, String str) {
        this.f11258a = oa;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T a(String str, float f) {
        synchronized (this) {
            this.f11258a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T b(String str, String str2) {
        synchronized (this) {
            this.f11258a.a(str, str2);
        }
        return this;
    }

    public final Ne c(String str) {
        return new Ne(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T d(String str) {
        synchronized (this) {
            this.f11258a.remove(str);
        }
        return this;
    }

    public Set<String> c() {
        return this.f11258a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T a(String str, String[] strArr) {
        String string;
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : strArr) {
                jSONArray.put(str2);
            }
            string = jSONArray.toString();
        } catch (Throwable unused) {
            string = null;
        }
        this.f11258a.a(str, string);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T b(String str, long j) {
        synchronized (this) {
            this.f11258a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T b(String str, int i) {
        synchronized (this) {
            this.f11258a.a(i, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Me> T b(String str, boolean z) {
        synchronized (this) {
            this.f11258a.a(str, z);
        }
        return this;
    }

    public final <T extends Me> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.f11258a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.f11258a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.f11258a.getString(str, str2);
    }

    public final void b() {
        synchronized (this) {
            this.f11258a.b();
        }
    }

    public final boolean a(String str, boolean z) {
        return this.f11258a.getBoolean(str, z);
    }

    public final boolean b(String str) {
        return this.f11258a.a(str);
    }
}
