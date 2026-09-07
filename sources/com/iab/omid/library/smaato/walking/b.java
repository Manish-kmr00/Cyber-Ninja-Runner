package com.iab.omid.library.smaato.walking;

import com.iab.omid.library.smaato.walking.async.d;
import com.iab.omid.library.smaato.walking.async.e;
import com.iab.omid.library.smaato.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class b implements com.iab.omid.library.smaato.walking.async.b.InterfaceC0381b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f2938a;
    private final com.iab.omid.library.smaato.walking.async.c b;

    public b(com.iab.omid.library.smaato.walking.async.c cVar) {
        this.b = cVar;
    }

    @Override // com.iab.omid.library.smaato.walking.async.b.InterfaceC0381b
    public JSONObject a() {
        return this.f2938a;
    }

    @Override // com.iab.omid.library.smaato.walking.async.b.InterfaceC0381b
    public void a(JSONObject jSONObject) {
        this.f2938a = jSONObject;
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
