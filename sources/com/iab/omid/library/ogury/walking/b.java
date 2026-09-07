package com.iab.omid.library.ogury.walking;

import com.iab.omid.library.ogury.walking.async.d;
import com.iab.omid.library.ogury.walking.async.e;
import com.iab.omid.library.ogury.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class b implements com.iab.omid.library.ogury.walking.async.b.InterfaceC0369b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2827a;
    private final com.iab.omid.library.ogury.walking.async.c b;

    public b(com.iab.omid.library.ogury.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.ogury.walking.async.b.InterfaceC0369b
    public JSONObject a() {
        return this.f2827a;
    }

    @Override // com.iab.omid.library.ogury.walking.async.b.InterfaceC0369b
    public void a(JSONObject jSONObject) {
        this.f2827a = jSONObject;
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
