package com.five_corp.ad.internal.bgtask;

import android.net.Uri;
import com.five_corp.ad.BuildConfig;
import com.five_corp.ad.internal.z;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends m {
    public final com.five_corp.ad.internal.logger.b c;
    public final z d;
    public final com.five_corp.ad.internal.http.d e;

    public j(com.five_corp.ad.internal.logger.b bVar, z zVar, com.five_corp.ad.internal.http.d dVar) {
        super(5);
        this.c = bVar;
        this.d = zVar;
        this.e = dVar;
    }

    @Override // com.five_corp.ad.internal.bgtask.m
    public final boolean b() throws JSONException {
        Uri.Builder builderAuthority = new Uri.Builder().scheme("https").authority("log.fivecdm.com");
        builderAuthority.path("rlog");
        String string = builderAuthority.toString();
        z zVar = this.d;
        com.five_corp.ad.internal.logger.b bVar = this.c;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sv", BuildConfig.SEMVER_PATCH);
        jSONObject.put("pv", zVar.b.f);
        jSONObject.put("dt", "Android");
        jSONObject.put("s", zVar.b.e);
        jSONObject.put("dv", zVar.b.f1263a);
        jSONObject.put("hw", zVar.b.b);
        jSONObject.put("rt", System.currentTimeMillis());
        jSONObject.put("cr", zVar.b.d);
        jSONObject.put("l", Locale.getDefault().toString());
        jSONObject.put("i", zVar.c.appId);
        jSONObject.put("ngnpa", zVar.c.getNeedGdprNonPersonalizedAdsTreatment().value);
        jSONObject.put("ncd", zVar.c.getNeedChildDirectedTreatment().value);
        jSONObject.put("maar", zVar.c.getFiveAdAgeRating().value);
        jSONObject.put("sui", zVar.d.b);
        com.five_corp.ad.internal.tracking_data.a aVarA = zVar.f.a();
        String str = aVarA.f1552a;
        if (str != null) {
            jSONObject.put("ty", str);
        }
        jSONObject.put("nt", aVarA.b ? "1" : "0");
        jSONObject.put("ll", com.five_corp.ad.e.a(bVar.f1422a));
        jSONObject.put("lm", bVar.b);
        com.five_corp.ad.internal.util.f fVarA = this.e.a(string, "POST", jSONObject.toString(), "application/json;charset=utf-8");
        return fVarA.f1560a && ((com.five_corp.ad.internal.http.c) fVarA.c).f1392a == 200;
    }
}
