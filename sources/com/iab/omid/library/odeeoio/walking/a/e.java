package com.iab.omid.library.odeeoio.walking.a;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class e extends a {
    public e(b.InterfaceC0365b interfaceC0365b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0365b, hashSet, jSONObject, j);
    }

    private void b(String str) {
        com.iab.omid.library.odeeoio.b.a aVarA = com.iab.omid.library.odeeoio.b.a.a();
        if (aVarA != null) {
            for (com.iab.omid.library.odeeoio.adsession.a aVar : aVarA.b()) {
                if (this.f2790a.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().b(str, this.c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.b.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.odeeoio.walking.a.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
