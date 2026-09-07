package com.mbridge.msdk.setting;

import android.text.TextUtils;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBDNSManager.java */
/* JADX INFO: loaded from: classes12.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5394a;
    private HashMap<String, f> b;

    /* JADX INFO: compiled from: MBDNSManager.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f5395a = new e();
    }

    public static e a() {
        return b.f5395a;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            if (this.b == null) {
                this.b = new HashMap<>();
            }
            Iterator<String> itKeys = jSONObjectJsonObjectInit.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObjectJsonObjectInit.getString(next);
                f fVar = new f();
                fVar.a(next);
                fVar.b(string);
                this.b.put(next, fVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private e() {
        this.f5394a = 6;
        this.b = new HashMap<>();
    }

    public int a(String str) {
        HashMap<String, f> map;
        f fVar;
        int i;
        if (TextUtils.isEmpty(str) || (map = this.b) == null || !map.containsKey(str) || (fVar = this.b.get(str)) == null) {
            return 0;
        }
        if (fVar.b()) {
            i = 1;
        } else {
            i = fVar.a() >= this.f5394a ? 2 : 0;
        }
        fVar.a(false);
        return i;
    }
}
