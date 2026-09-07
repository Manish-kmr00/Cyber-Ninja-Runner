package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class G2 {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T8 f3076a;
    public final TreeMap b;
    public final LinkedHashMap c;
    public final C3620x2 d;

    public G2(A2 networkRequest, T8 mNetworkResponse) {
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        Intrinsics.checkNotNullParameter(mNetworkResponse, "mNetworkResponse");
        this.f3076a = mNetworkResponse;
        TreeMap treeMap = new TreeMap(networkRequest.y);
        this.b = treeMap;
        this.c = new LinkedHashMap();
        P8 p8 = mNetworkResponse.c;
        Unit unit = null;
        if (p8 != null) {
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                C2 c2 = new C2(null, (Config) value);
                c2.c = new C3620x2((byte) 0, "Network error in fetching config.");
                LinkedHashMap linkedHashMap = this.c;
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                linkedHashMap.put(key, c2);
            }
            C3620x2 c3620x2 = new C3620x2((byte) 0, p8.b);
            this.d = c3620x2;
            Intrinsics.checkNotNullExpressionValue("G2", "TAG");
            byte b = c3620x2.f3471a;
            String str = c3620x2.b;
            Pair pairA = B2.a(this.b);
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("errorCode", Integer.valueOf(p8.f3168a.f3094a)), TuplesKt.to("name", (List) pairA.component1()), TuplesKt.to("lts", (List) pairA.component2()), TuplesKt.to("networkType", C3435k3.q()));
            Ob ob = Ob.f3160a;
            Ob.b("InvalidConfig", mapMutableMapOf, Sb.SDK);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f3076a.a());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Config config = (Config) this.b.get(next);
                    if (config != null) {
                        Intrinsics.checkNotNull(config);
                        C2 c3 = new C2(jSONObject2, config);
                        LinkedHashMap linkedHashMap2 = this.c;
                        Intrinsics.checkNotNull(next);
                        linkedHashMap2.put(next, c3);
                    }
                }
                Pair pairA2 = B2.a(this.b);
                Map mapMutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.to("name", (List) pairA2.component1()), TuplesKt.to("lts", (List) pairA2.component2()));
                Ob ob2 = Ob.f3160a;
                Ob.b("ConfigFetched", mapMutableMapOf2, Sb.SDK);
            } catch (JSONException e2) {
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Exception while parsing config";
                } else {
                    Intrinsics.checkNotNull(localizedMessage);
                }
                C3620x2 c3620x3 = new C3620x2((byte) 2, localizedMessage);
                this.d = c3620x3;
                String str2 = c3620x3.b;
                Pair pairA3 = B2.a(this.b);
                Map mapMutableMapOf3 = MapsKt.mutableMapOf(TuplesKt.to("errorCode", (short) 1), TuplesKt.to("name", (List) pairA3.component1()), TuplesKt.to("lts", (List) pairA3.component2()), TuplesKt.to("networkType", C3435k3.q()));
                Ob ob3 = Ob.f3160a;
                Ob.b("InvalidConfig", mapMutableMapOf3, Sb.SDK);
            }
        }
    }

    public final boolean a() {
        I3 i3;
        P8 p8 = this.f3076a.c;
        if ((p8 != null ? p8.f3168a : null) != I3.i) {
            if (p8 == null || (i3 = p8.f3168a) == null) {
                i3 = I3.e;
            }
            int i = i3.f3094a;
            if (500 > i || i >= 600) {
                return false;
            }
        }
        return true;
    }
}
