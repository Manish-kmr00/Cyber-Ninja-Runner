package com.iab.omid.library.inmobi.walking;

import com.iab.omid.library.inmobi.walking.async.d;
import com.iab.omid.library.inmobi.walking.async.e;
import com.iab.omid.library.inmobi.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class b implements com.iab.omid.library.inmobi.walking.async.b.InterfaceC0354b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2688a;
    private final com.iab.omid.library.inmobi.walking.async.c b;

    public b(com.iab.omid.library.inmobi.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.inmobi.walking.async.b.InterfaceC0354b
    public JSONObject a() {
        return this.f2688a;
    }

    @Override // com.iab.omid.library.inmobi.walking.async.b.InterfaceC0354b
    public void a(JSONObject jSONObject) {
        this.f2688a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }

    public void b() {
        this.b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }
}
