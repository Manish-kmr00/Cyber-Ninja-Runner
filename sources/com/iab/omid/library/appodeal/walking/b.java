package com.iab.omid.library.appodeal.walking;

import com.iab.omid.library.appodeal.walking.async.d;
import com.iab.omid.library.appodeal.walking.async.e;
import com.iab.omid.library.appodeal.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class b implements com.iab.omid.library.appodeal.walking.async.b.InterfaceC0339b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2548a;
    private final com.iab.omid.library.appodeal.walking.async.c b;

    public b(com.iab.omid.library.appodeal.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.appodeal.walking.async.b.InterfaceC0339b
    public JSONObject a() {
        return this.f2548a;
    }

    @Override // com.iab.omid.library.appodeal.walking.async.b.InterfaceC0339b
    public void a(JSONObject jSONObject) {
        this.f2548a = jSONObject;
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
