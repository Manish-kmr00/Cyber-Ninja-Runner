package com.iab.omid.library.bigosg.walking;

import com.iab.omid.library.bigosg.walking.a.d;
import com.iab.omid.library.bigosg.walking.a.e;
import com.iab.omid.library.bigosg.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class b implements com.iab.omid.library.bigosg.walking.a.b.InterfaceC0342b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2581a;
    private final com.iab.omid.library.bigosg.walking.a.c b;

    public b(com.iab.omid.library.bigosg.walking.a.c cVar) {
        this.b = cVar;
    }

    public void a() {
        this.b.b(new d(this));
    }

    @Override // com.iab.omid.library.bigosg.walking.a.b.InterfaceC0342b
    public void a(JSONObject jSONObject) {
        this.f2581a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new f(this, hashSet, jSONObject, j));
    }

    @Override // com.iab.omid.library.bigosg.walking.a.b.InterfaceC0342b
    public JSONObject b() {
        return this.f2581a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new e(this, hashSet, jSONObject, j));
    }
}
