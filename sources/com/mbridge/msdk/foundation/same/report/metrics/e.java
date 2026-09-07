package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ParameterWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f5025a = new HashMap();

    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            if (!(obj instanceof String)) {
                this.f5025a.put(str, obj + "");
            } else if (!TextUtils.isEmpty((String) obj)) {
                this.f5025a.put(str, (String) obj);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public Object b(String str) {
        return this.f5025a.get(str);
    }

    public void c(String str) {
        if (this.f5025a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f5025a.remove(str);
    }

    public boolean a(String str) {
        return this.f5025a.containsKey(str);
    }

    public Map<String, String> a() {
        return this.f5025a;
    }

    public void a(e eVar) {
        Map<String, String> map;
        Map<String, String> map2;
        if (eVar == null || (map = eVar.f5025a) == null || (map2 = this.f5025a) == null) {
            return;
        }
        map2.putAll(map);
    }
}
