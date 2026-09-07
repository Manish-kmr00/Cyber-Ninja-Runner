package com.inmobi.media;

import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import com.inmobi.unifiedId.InMobiUnifiedIdService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.wc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3616wc {
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    /* JADX WARN: Code duplicated, block: B:63:0x0133 A[LOOP:1: B:61:0x012d->B:63:0x0133, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0147  */
    public static C3630xc a() {
        JSONArray jSONArray;
        Iterator it;
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        boolean enabled = ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig().getEnabled();
        if (!enabled) {
            InMobiUnifiedIdService.reset();
        }
        if (!enabled) {
            return new C3630xc();
        }
        Boolean boolC = C3532qc.f3412a.c();
        boolean zBooleanValue = boolC != null ? boolC.booleanValue() : true;
        if (zBooleanValue) {
            InMobiUnifiedIdService.reset();
        }
        if (zBooleanValue) {
            return new C3630xc();
        }
        HashMap map = new HashMap();
        JSONObject jSONObjectA = AbstractC3296a5.a();
        Iterator<String> itKeys = jSONObjectA != null ? jSONObjectA.keys() : null;
        if (itKeys != null) {
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("src", next);
                    jSONObject.put("envelope", jSONObjectA.get(next));
                    Intrinsics.checkNotNull(next);
                    map.put(next, jSONObject);
                } catch (JSONException e) {
                    StringsKt.trimMargin$default(" Error in looping through publisher provided unif id " + e.getMessage() + "  \n                                        " + jSONObjectA.get(next), null, 1, null);
                }
            }
        }
        JSONObject jSONObjectB = AbstractC3296a5.b();
        boolean z = false;
        z = false;
        z = false;
        if (jSONObjectB != null) {
            try {
                if (jSONObjectB.has("ufids")) {
                    JSONArray jSONArray2 = jSONObjectB.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    boolean z2 = false;
                    boolean z3 = false;
                    for (int i = 0; i < length; i++) {
                        try {
                            String string = jSONArray2.getJSONObject(i).has("src") ? jSONArray2.getJSONObject(i).getString("src") : null;
                            String string2 = jSONArray2.getJSONObject(i).has("envelope") ? jSONArray2.getJSONObject(i).getString("envelope") : null;
                            if (System.currentTimeMillis() > jSONArray2.getJSONObject(i).getLong("expiry")) {
                                z2 = true;
                            } else if (string != null && string2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("src", string);
                                jSONObject2.put("envelope", string2);
                                map.put(string, jSONObject2);
                                z3 = true;
                            }
                        } catch (JSONException unused) {
                            z = z3;
                            jSONObjectB.toString();
                            if (!map.isEmpty()) {
                                return new C3630xc();
                            }
                            jSONArray = new JSONArray();
                            it = map.values().iterator();
                            while (it.hasNext()) {
                                jSONArray.put((JSONObject) it.next());
                            }
                            return new C3630xc(jSONArray.toString(), z);
                        }
                    }
                    if (z2) {
                        InMobiUnifiedIdService.fetchUnifiedIdsInternal$media_release(null);
                    }
                    z = z3;
                }
            } catch (JSONException unused2) {
            }
        }
        if (!map.isEmpty()) {
            return new C3630xc();
        }
        jSONArray = new JSONArray();
        it = map.values().iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        return new C3630xc(jSONArray.toString(), z);
    }

    public static final void b(InMobiUnifiedIdInterface inMobiUnifiedIdInterface, JSONObject jSONObject, Error error) {
        if (inMobiUnifiedIdInterface != null) {
            inMobiUnifiedIdInterface.onFetchCompleted(jSONObject, error);
        }
    }

    public static void a(final InMobiUnifiedIdInterface inMobiUnifiedIdInterface, final JSONObject jSONObject, final Error error) {
        short s;
        String message = error != null ? error.getMessage() : null;
        if (Intrinsics.areEqual(message, InMobiUnifiedIdInterface.NETWORK_FAILURE_AND_NO_LOCAL_DATA_PRESENT)) {
            s = 93;
        } else {
            s = Intrinsics.areEqual(message, InMobiUnifiedIdInterface.NO_LOCAL_DATA_PRESENT) ? (short) 94 : (short) -1;
        }
        if (s >= 0) {
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("errorCode", Short.valueOf(s)));
            Ob ob = Ob.f3160a;
            Ob.b("FetchCallbackFailure", mapMutableMapOf, Sb.SDK);
        }
        Lb.a(new Runnable() { // from class: com.inmobi.media.wc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3616wc.b(inMobiUnifiedIdInterface, jSONObject, error);
            }
        });
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("ufids")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                        if (System.currentTimeMillis() < jSONObject3.getLong("expiry")) {
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONArray.length() <= 0) {
            return null;
        }
        jSONObject2.put("ufids", jSONArray);
        return jSONObject2;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        HashMap map = new HashMap();
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject2 != null) {
            try {
                if (jSONObject2.has("ufids")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray2.getJSONObject(i).getString("src");
                        Intrinsics.checkNotNull(string);
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                        map.put(string, jSONObject4);
                    }
                }
            } catch (JSONException unused) {
                Objects.toString(jSONObject2);
                Objects.toString(jSONObject);
            }
        }
        if (jSONObject != null && jSONObject.has("ufids")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("ufids");
            int length2 = jSONArray3.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String string2 = jSONArray3.getJSONObject(i2).getString("src");
                Intrinsics.checkNotNull(string2);
                JSONObject jSONObject5 = jSONArray3.getJSONObject(i2);
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                map.put(string2, jSONObject5);
            }
        }
        Collection collectionValues = map.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        jSONObject3.put("ufids", jSONArray);
        return jSONObject3;
    }
}
