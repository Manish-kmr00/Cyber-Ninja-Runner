package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class po2 extends tn2 {
    public po2(co2.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.mobile.ads.impl.co2, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public final void onPostExecute(String str) {
        nn2 nn2VarA = nn2.a();
        if (nn2VarA != null) {
            for (mn2 mn2Var : nn2VarA.b()) {
                if (this.c.contains(mn2Var.i())) {
                    mn2Var.j().b(str, this.e);
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final String doInBackground(Object[] objArr) {
        return this.d.toString();
    }
}
