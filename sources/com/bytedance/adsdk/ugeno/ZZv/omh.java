package com.bytedance.adsdk.ugeno.ZZv;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class omh {
    public static Og.pA pA(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Og.pA pAVar = new Og.pA();
        Uri uri = Uri.parse(com.bytedance.adsdk.ugeno.KZx.Og.pA(str, jSONObject));
        if (uri == null) {
            return null;
        }
        if (!TextUtils.isEmpty(uri.getScheme())) {
            pAVar.pA(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        pAVar.Og(authority);
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.KZx.Og.pA(uri.getQueryParameter(str2), jSONObject));
            }
        }
        pAVar.pA(map);
        return pAVar;
    }
}
