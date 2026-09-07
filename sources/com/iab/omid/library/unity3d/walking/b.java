package com.iab.omid.library.unity3d.walking;

import com.iab.omid.library.unity3d.walking.async.d;
import com.iab.omid.library.unity3d.walking.async.e;
import com.iab.omid.library.unity3d.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class b implements com.iab.omid.library.unity3d.walking.async.b.InterfaceC0385b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2972a;
    private final com.iab.omid.library.unity3d.walking.async.c b;

    public b(com.iab.omid.library.unity3d.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.InterfaceC0385b
    public JSONObject a() {
        return this.f2972a;
    }

    @Override // com.iab.omid.library.unity3d.walking.async.b.InterfaceC0385b
    public void a(JSONObject jSONObject) {
        this.f2972a = jSONObject;
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
