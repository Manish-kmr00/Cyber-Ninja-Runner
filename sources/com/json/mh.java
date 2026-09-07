package com.json;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class mh {
    public static ec a(JSONObject jSONObject) {
        return new ec.a(jSONObject.optString(cc.r)).b().b(jSONObject.optBoolean("enabled")).a(new kh()).a(a()).a(false).a();
    }

    public static eh.e a(va vaVar, eh.e eVar) {
        if (vaVar == null || vaVar.g() == null || vaVar.g().get("rewarded") == null) {
            return eVar;
        }
        return Boolean.parseBoolean(vaVar.g().get("rewarded")) ? eh.e.RewardedVideo : eh.e.Interstitial;
    }

    public static jh a(Context context, String str, String str2, Map<String, String> map) throws Exception {
        jh.b bVar = new jh.b();
        if (map != null && map.containsKey("sessionid")) {
            bVar.c(map.get("sessionid"));
        }
        bVar.a(context);
        return bVar.d(str).a(str2).a();
    }

    private static ArrayList<Pair<String, String>> a() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>("Content-Type", "application/json"));
        arrayList.add(new Pair<>("charset", cc.N));
        return arrayList;
    }

    public static boolean a(va vaVar) {
        if (vaVar == null || vaVar.g().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(vaVar.g().get("inAppBidding"));
    }
}
