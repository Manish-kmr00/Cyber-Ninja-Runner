package com.chartboost.sdk.impl;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class gd extends gc {
    public gd(pc.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.d.toString();
    }

    public final void b(String str) {
        tc tcVarC = tc.c();
        if (tcVarC != null) {
            for (zb zbVar : tcVarC.b()) {
                if (this.c.contains(zbVar.e())) {
                    zbVar.f().a(str, this.e);
                }
            }
        }
    }

    @Override // com.chartboost.sdk.impl.pc, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
