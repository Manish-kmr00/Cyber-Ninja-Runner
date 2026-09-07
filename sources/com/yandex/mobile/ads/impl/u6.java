package com.yandex.mobile.ads.impl;

import com.amazon.device.ads.DTBMetricsConfiguration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u6 {
    public static b7 a(String jsonData) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(a(new JSONObject(jsonData)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            String str = "Couldn't parse " + jsonData + " to QualityAdVerificationConfiguration";
            op0.b(new Object[0]);
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (b7) objM7904constructorimpl;
    }

    private static Map b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            c7 c7Var = new c7(jSONObject2.getBoolean("isDisabled"), jSONObject2.getInt("usagePercent"));
            Intrinsics.checkNotNull(next);
            mapCreateMapBuilder.put(next, c7Var);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static b7 a(JSONObject jSONObject) {
        Object objM7904constructorimpl;
        Set setEmptySet;
        if (jSONObject == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean z = jSONObject.getBoolean("isEnabled");
            boolean z2 = jSONObject.getBoolean("isInDebug");
            String string = jSONObject.getString(DTBMetricsConfiguration.APSMETRICS_APIKEY);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            long j = jSONObject.getLong("validationTimeoutInSec");
            int i = jSONObject.getInt("usagePercent");
            boolean z3 = jSONObject.getBoolean("willBlockAdOnInternalError");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("enabledAdUnits");
            if (jSONArrayOptJSONArray != null) {
                Set setCreateSetBuilder = SetsKt.createSetBuilder();
                int length = jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String string2 = jSONArrayOptJSONArray.getString(i2);
                    Intrinsics.checkNotNull(string2);
                    if (string2.length() > 0) {
                        setCreateSetBuilder.add(string2);
                    }
                }
                setEmptySet = SetsKt.build(setCreateSetBuilder);
            } else {
                setEmptySet = null;
            }
            if (setEmptySet == null) {
                setEmptySet = SetsKt.emptySet();
            }
            Set set = setEmptySet;
            Map mapB = b(jSONObject.optJSONObject("adNetworksCustomParameters"));
            if (mapB == null) {
                mapB = MapsKt.emptyMap();
            }
            objM7904constructorimpl = Result.m7904constructorimpl(new b7(z, z2, string, j, i, z3, set, mapB));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            String str = "Couldn't parse " + jSONObject + " to QualityVerificationConfiguration";
            op0.b(new Object[0]);
        }
        return (b7) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }

    static final class a extends Lambda implements Function1<JsonArrayBuilder, Unit> {
        final /* synthetic */ b7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b7 b7Var) {
            super(1);
            this.b = b7Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(JsonArrayBuilder jsonArrayBuilder) {
            JsonArrayBuilder putJsonArray = jsonArrayBuilder;
            Intrinsics.checkNotNullParameter(putJsonArray, "$this$putJsonArray");
            Iterator<T> it = this.b.f().iterator();
            while (it.hasNext()) {
                JsonElementBuildersKt.add(putJsonArray, (String) it.next());
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1<JsonObjectBuilder, Unit> {
        final /* synthetic */ b7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(b7 b7Var) {
            super(1);
            this.b = b7Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(JsonObjectBuilder jsonObjectBuilder) {
            JsonObjectBuilder putJsonObject = jsonObjectBuilder;
            Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
            Iterator<T> it = this.b.a().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                JsonElementBuildersKt.putJsonObject(putJsonObject, (String) entry.getKey(), new v6(entry));
            }
            return Unit.INSTANCE;
        }
    }

    public static String a(b7 b7Var) {
        if (b7Var == null) {
            return null;
        }
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder, "isEnabled", Boolean.valueOf(b7Var.e()));
        JsonElementBuildersKt.put(jsonObjectBuilder, "isInDebug", Boolean.valueOf(b7Var.d()));
        JsonElementBuildersKt.put(jsonObjectBuilder, DTBMetricsConfiguration.APSMETRICS_APIKEY, b7Var.b());
        JsonElementBuildersKt.put(jsonObjectBuilder, "validationTimeoutInSec", Long.valueOf(b7Var.h()));
        JsonElementBuildersKt.put(jsonObjectBuilder, "usagePercent", Integer.valueOf(b7Var.g()));
        JsonElementBuildersKt.put(jsonObjectBuilder, "willBlockAdOnInternalError", Boolean.valueOf(b7Var.c()));
        JsonElementBuildersKt.putJsonArray(jsonObjectBuilder, "enabledAdUnits", new a(b7Var));
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "adNetworksCustomParameters", new b(b7Var));
        return jsonObjectBuilder.build().toString();
    }
}
