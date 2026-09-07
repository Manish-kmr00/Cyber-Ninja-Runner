package com.iab.omid.library.odeeoio.walking;

import com.iab.omid.library.odeeoio.walking.a.d;
import com.iab.omid.library.odeeoio.walking.a.e;
import com.iab.omid.library.odeeoio.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.iab.omid.library.odeeoio.walking.a.b.InterfaceC0365b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2793a;
    private final com.iab.omid.library.odeeoio.walking.a.c b;

    public b(com.iab.omid.library.odeeoio.walking.a.c cVar) {
        this.b = cVar;
    }

    public void a() {
        this.b.b(new d(this));
    }

    @Override // com.iab.omid.library.odeeoio.walking.a.b.InterfaceC0365b
    public void a(JSONObject jSONObject) {
        this.f2793a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }

    @Override // com.iab.omid.library.odeeoio.walking.a.b.InterfaceC0365b
    public JSONObject b() {
        return this.f2793a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }
}
