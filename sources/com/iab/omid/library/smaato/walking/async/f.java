package com.iab.omid.library.smaato.walking.async;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class f extends a {
    public f(b.InterfaceC0381b interfaceC0381b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0381b, hashSet, jSONObject, j);
    }

    private void b(String str) {
        com.iab.omid.library.smaato.internal.c cVarC = com.iab.omid.library.smaato.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.smaato.adsession.a aVar : cVarC.b()) {
                if (this.c.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().b(str, this.e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (com.iab.omid.library.smaato.utils.c.h(this.d, this.b.a())) {
            return null;
        }
        this.b.a(this.d);
        return this.d.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iab.omid.library.smaato.walking.async.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
