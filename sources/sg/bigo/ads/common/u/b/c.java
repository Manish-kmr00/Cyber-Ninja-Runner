package sg.bigo.ads.common.u.b;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import sg.bigo.ads.common.u.a;
import sg.bigo.ads.common.u.f;

/* JADX INFO: loaded from: classes10.dex */
public abstract class c<T extends sg.bigo.ads.common.u.a> {
    public final int i;
    public final T j;
    public Executor k;
    public long l = 15000;
    public final Map<String, Set<String>> m = new HashMap();
    public final boolean n;

    public c(int i, T t, boolean z, Context context) {
        this.i = i;
        this.j = t;
        this.n = z;
        a("BIGO-Ad-Request-Id", String.valueOf(i));
        a("User-Agent", sg.bigo.ads.common.aa.c.c(context));
    }

    private Set<String> b(String str) {
        Set<String> set = this.m.get(str);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.m.put(str, hashSet);
        return hashSet;
    }

    public String a() {
        return "GET";
    }

    public final void a(String str) {
        b(str).clear();
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        b(str).add(str2);
    }

    public f b() {
        return null;
    }

    public byte[] c() {
        return null;
    }

    public String d() {
        return null;
    }

    public int e() {
        return -1;
    }

    public boolean f() {
        return false;
    }

    public final String g() {
        return this.j.a();
    }

    public void h() {
    }
}
