package com.fyber.inneractive.sdk.network.events;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.C3147x;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.response.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {
    public static void a(EnumC3143t enumC3143t, String str, String str2, InneractiveAdRequest inneractiveAdRequest, e eVar, HashMap map, Boolean bool) {
        C3146w c3146w = new C3146w(enumC3143t, inneractiveAdRequest, eVar);
        C3147x c3147x = new C3147x();
        if (bool != null) {
            c3147x.a(bool, "loaded_from_cache");
        }
        c3147x.a(str, "errorCode").a(str2, "templateURL");
        if (map != null && !map.isEmpty()) {
            for (String str3 : map.keySet()) {
                String str4 = (String) map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    c3147x.a(str4, str3);
                }
            }
        }
        c3146w.f.put(c3147x.f1935a);
        c3146w.a((String) null);
    }

    public static void a(EnumC3143t enumC3143t, b bVar, InneractiveAdRequest inneractiveAdRequest, e eVar, String str, String str2, Boolean bool) {
        C3146w c3146w = new C3146w(enumC3143t, inneractiveAdRequest, eVar);
        C3147x c3147x = new C3147x();
        c3147x.a(bVar.name(), "errorCode");
        if (!TextUtils.isEmpty(str2)) {
            c3147x.a(str2, "templateURL");
        }
        if (!TextUtils.isEmpty(str)) {
            c3147x.a(str, "error");
        }
        if (bool != null) {
            c3147x.a(bool, "loaded_from_cache");
        }
        c3146w.f.put(c3147x.f1935a);
        c3146w.a((String) null);
    }
}
