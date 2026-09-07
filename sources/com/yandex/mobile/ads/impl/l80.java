package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class l80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n80 f9489a;
    private final g b;

    public /* synthetic */ l80(int i) {
        this(new n80(), new g());
    }

    public l80(n80 falseClickFormatter, g abExperimentDataConverter) {
        Intrinsics.checkNotNullParameter(falseClickFormatter, "falseClickFormatter");
        Intrinsics.checkNotNullParameter(abExperimentDataConverter, "abExperimentDataConverter");
        this.f9489a = falseClickFormatter;
        this.b = abExperimentDataConverter;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a1 A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #0 {all -> 0x00a8, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x0027, B:15:0x003c, B:16:0x004d, B:19:0x0052, B:22:0x006c, B:24:0x0086, B:31:0x00a1, B:27:0x009a, B:11:0x0035), top: B:36:0x0001 }] */
    public final k80 a(String str) {
        qs qsVar;
        j80 j80Var;
        o0.a aVar;
        try {
            if (str == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            qs.a aVar2 = qs.c;
            String value = jSONObject.getString("ad_type");
            Intrinsics.checkNotNullExpressionValue(value, "getString(...)");
            aVar2.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            qs[] qsVarArrValues = qs.values();
            int length = qsVarArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    qsVar = null;
                    break;
                }
                qs qsVar2 = qsVarArrValues[i];
                if (Intrinsics.areEqual(qsVar2.a(), value)) {
                    qsVar = qsVar2;
                    break;
                }
                i++;
            }
            if (qsVar == null) {
                return null;
            }
            long j = jSONObject.getLong("start_time");
            n80 n80Var = this.f9489a;
            String strOptString = jSONObject.optString("false_click");
            n80Var.getClass();
            try {
                if (strOptString == null) {
                    j80Var = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    String string = jSONObject2.getString("url");
                    long j2 = jSONObject2.getLong("interval");
                    Intrinsics.checkNotNull(string);
                    j80Var = new j80(string, j2);
                }
            } catch (JSONException unused) {
            }
            HashMap mapA = a(jSONObject);
            g gVar = this.b;
            String strOptString2 = jSONObject.optString("ab_experiments");
            gVar.getClass();
            f fVarA = g.a(strOptString2);
            for (o0.a aVar3 : o0.a.values()) {
                if (Intrinsics.areEqual(aVar3.a(), jSONObject.getString("type"))) {
                    aVar = aVar3;
                    if (aVar == null) {
                        return null;
                    }
                    return new k80(qsVar, j, aVar, j80Var, mapA, fVarA);
                }
            }
            aVar = null;
            if (aVar == null) {
                return null;
            }
            return new k80(qsVar, j, aVar, j80Var, mapA, fVarA);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static HashMap a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject2 = jSONObject.getJSONObject("report_data");
            Iterator<String> itKeys = jSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                map.put(next, jSONObject2.get(next));
            }
            Result.m7904constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }

    public final String a(k80 k80Var) {
        String string;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ad_type", k80Var.c().a());
        jSONObject.put("start_time", k80Var.f());
        jSONObject.put("type", k80Var.b().a());
        n80 n80Var = this.f9489a;
        j80 j80VarD = k80Var.d();
        n80Var.getClass();
        String string2 = null;
        if (j80VarD != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("interval", j80VarD.c());
            jSONObject2.put("url", j80VarD.d());
            string = jSONObject2.toString();
        } else {
            string = null;
        }
        jSONObject.put("false_click", string);
        jSONObject.put("report_data", new JSONObject(k80Var.e()));
        g gVar = this.b;
        f fVarA = k80Var.a();
        gVar.getClass();
        if (fVarA != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(com.json.tr.d, fVarA.a());
            jSONObject3.put("test_ids", fVarA.b());
            string2 = jSONObject3.toString();
        }
        jSONObject.put("ab_experiments", string2);
        return jSONObject.toString();
    }
}
