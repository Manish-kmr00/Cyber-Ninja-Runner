package com.json;

import android.content.Context;
import android.text.TextUtils;
import com.json.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class jh implements cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f3811a = new HashMap();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3812a;
        String b;
        String c;
        Context d;
        String e;

        b a(Context context) {
            this.d = context;
            return this;
        }

        b a(String str) {
            this.b = str;
            return this;
        }

        public jh a() {
            return new jh(this);
        }

        b b(String str) {
            this.c = str;
            return this;
        }

        b c(String str) {
            this.f3812a = str;
            return this;
        }

        b d(String str) {
            this.e = str;
            return this;
        }
    }

    private jh(b bVar) {
        a(bVar);
        a(bVar.d);
    }

    private void a(Context context) {
        f3811a.put("connectiontype", y8.b(context));
        f3811a.put(cc.f, y8.d(context));
    }

    private void a(b bVar) {
        Context context = bVar.d;
        za zaVarB = za.b(context);
        f3811a.put(cc.j, SDKUtils.encodeString(zaVarB.e()));
        f3811a.put(cc.k, SDKUtils.encodeString(zaVarB.f()));
        f3811a.put(cc.l, Integer.valueOf(zaVarB.a()));
        f3811a.put(cc.m, SDKUtils.encodeString(zaVarB.d()));
        f3811a.put(cc.n, SDKUtils.encodeString(zaVarB.c()));
        f3811a.put("bundleid", SDKUtils.encodeString(context.getPackageName()));
        f3811a.put(cc.g, SDKUtils.encodeString(bVar.b));
        f3811a.put("sessionid", SDKUtils.encodeString(bVar.f3812a));
        f3811a.put(cc.b, SDKUtils.encodeString(SDKUtils.getSDKVersion()));
        f3811a.put(cc.o, "prod");
        f3811a.put("origin", "n");
        if (TextUtils.isEmpty(bVar.e)) {
            return;
        }
        f3811a.put(cc.i, SDKUtils.encodeString(bVar.e));
    }

    public static void a(String str) {
        f3811a.put("connectiontype", SDKUtils.encodeString(str));
    }

    public static void b(String str) {
        f3811a.put(cc.f, SDKUtils.encodeString(str));
    }

    @Override // com.json.cf
    public Map<String, Object> a() {
        return f3811a;
    }
}
