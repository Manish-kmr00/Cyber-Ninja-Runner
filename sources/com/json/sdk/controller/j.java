package com.json.sdk.controller;

import com.json.fh;
import com.json.mediationsdk.logger.IronLog;
import com.json.nh;
import com.json.o9;
import com.json.po;
import com.json.rk;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sk;
import com.json.tk;
import com.json.uc;
import com.json.wc;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4323a;
    private final wc b;

    class a implements po {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ tk f4324a;
        final /* synthetic */ sk b;

        a(tk tkVar, sk skVar) {
            this.f4324a = tkVar;
            this.b = skVar;
        }

        @Override // com.json.po
        public void a(nh nhVar) {
            try {
                tk tkVar = this.f4324a;
                sk skVar = this.b;
                tkVar.b(skVar, j.this.a(skVar, nhVar.a()));
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.json.po
        public void a(nh nhVar, fh fhVar) {
            try {
                tk tkVar = this.f4324a;
                sk skVar = this.b;
                tkVar.a(skVar, j.this.a(skVar, fhVar.b()));
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    j(String str, wc wcVar) {
        this.f4323a = str;
        this.b = wcVar;
    }

    private nh a(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has(uc.c.d)) {
            return new nh(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, jSONObject.getString(uc.c.d)));
        }
        throw new Exception(uc.a.b);
    }

    private po a(sk skVar, tk tkVar) {
        return new a(tkVar, skVar);
    }

    private JSONObject a(sk skVar, long j) {
        try {
            return skVar.e().put("result", j);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return IronSourceNetworkBridge.jsonObjectInit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(sk skVar, String str) {
        try {
            return skVar.e().put("errMsg", str);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return IronSourceNetworkBridge.jsonObjectInit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(sk skVar, JSONObject jSONObject) {
        try {
            return skVar.e().put("result", jSONObject);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return IronSourceNetworkBridge.jsonObjectInit();
        }
    }

    private nh b(JSONObject jSONObject, String str) throws Exception {
        if (!jSONObject.has(uc.c.c) || !jSONObject.has(uc.c.b)) {
            throw new Exception(uc.a.f4485a);
        }
        String string = jSONObject.getString(uc.c.c);
        return new nh(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, string), jSONObject.getString(uc.c.b));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    void a(JSONObject jSONObject, rk rkVar) {
        byte b;
        JSONObject jSONObjectA;
        JSONObject jSONObjectA2;
        sk skVar = new sk(jSONObject);
        tk tkVar = new tk(rkVar);
        try {
            String strB = skVar.b();
            JSONObject jSONObjectC = skVar.c();
            nh nhVarB = b(jSONObjectC, this.f4323a);
            IronSourceStorageUtils.ensurePathSafety(nhVarB, this.f4323a);
            switch (strB.hashCode()) {
                case -2073025383:
                    if (!strB.equals(uc.b.f4486a)) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case -1137024519:
                    if (!strB.equals(uc.b.c)) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -318115535:
                    if (!strB.equals(uc.b.e)) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 537556755:
                    if (!strB.equals(uc.b.f)) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1764172231:
                    if (!strB.equals(uc.b.b)) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1953259713:
                    if (!strB.equals(uc.b.d)) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                this.b.a(nhVarB, jSONObjectC.optString(uc.c.f4487a), jSONObjectC.optInt("connectionTimeout"), jSONObjectC.optInt("readTimeout"), a(skVar, tkVar));
                return;
            }
            if (b == 1) {
                this.b.a(nhVarB);
                jSONObjectA = nhVarB.a();
            } else if (b == 2) {
                this.b.b(nhVarB);
                jSONObjectA = nhVarB.a();
            } else {
                if (b != 3) {
                    if (b == 4) {
                        jSONObjectA2 = a(skVar, this.b.d(nhVarB));
                    } else {
                        if (b != 5) {
                            return;
                        }
                        this.b.a(nhVarB, jSONObjectC.optJSONObject(uc.c.g));
                        jSONObjectA = nhVarB.a();
                    }
                    tkVar.b(skVar, jSONObjectA2);
                }
                jSONObjectA = this.b.c(nhVarB);
            }
            jSONObjectA2 = a(skVar, jSONObjectA);
            tkVar.b(skVar, jSONObjectA2);
        } catch (Exception e) {
            o9.d().a(e);
            tkVar.a(skVar, a(skVar, e.getMessage()));
        }
    }
}
