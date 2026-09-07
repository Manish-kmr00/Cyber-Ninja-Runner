package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class so2 extends tn2 {
    public so2(co2.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.mobile.ads.impl.co2, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public final void onPostExecute(String str) {
        nn2 nn2VarA;
        if (!TextUtils.isEmpty(str) && (nn2VarA = nn2.a()) != null) {
            for (mn2 mn2Var : nn2VarA.b()) {
                if (this.c.contains(mn2Var.i())) {
                    mn2Var.j().a(str, this.e);
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final String doInBackground(Object[] objArr) {
        if (zn2.b(this.d, ((bo2) this.b).b())) {
            return null;
        }
        ((bo2) this.b).a(this.d);
        return this.d.toString();
    }
}
