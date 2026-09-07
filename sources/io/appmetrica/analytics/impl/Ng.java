package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Ng extends Gg {
    public final SafePackageManager b;

    public Ng(C4282m5 c4282m5) {
        this(c4282m5, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        HashSet hashSet;
        C4282m5 c4282m5 = this.f11164a;
        if (c4282m5.t.c() && c4282m5.x()) {
            Le le = c4282m5.c;
            String strE = this.f11164a.c.e();
            if (TextUtils.isEmpty(strE)) {
                hashSet = null;
            } else {
                try {
                    hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(strE);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(new Y9(jSONArray.getJSONObject(i)));
                    }
                } catch (Throwable unused) {
                    hashSet = null;
                }
            }
            try {
                ArrayList<Y9> arrayListB = b();
                if (CollectionUtils.areCollectionsEqual(hashSet, arrayListB)) {
                    C4386q9 c4386q9 = c4282m5.n;
                    int i2 = c4386q9.k;
                    c4386q9.m = i2;
                    c4386q9.f11734a.a(i2).b();
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    for (Y9 y9 : arrayListB) {
                        y9.getClass();
                        JSONObject jSONObjectPut = new JSONObject().put("name", y9.f11433a).put("required", y9.c);
                        int i3 = y9.b;
                        if (i3 != -1) {
                            jSONObjectPut.put("version", i3);
                        }
                        jSONArray2.put(jSONObjectPut);
                    }
                    C3984a6 c3984a6A = C3984a6.a(c3984a6, new JSONObject().put("features", jSONArray2).toString());
                    C4386q9 c4386q10 = c4282m5.n;
                    c4386q10.a(c3984a6A, C4521vk.a(c4386q10.c.b(c3984a6A), c3984a6A.i));
                    int i4 = c4386q10.k;
                    c4386q10.m = i4;
                    c4386q10.f11734a.a(i4).b();
                    le.i(jSONArray2.toString());
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    public final ArrayList b() {
        FeatureInfo[] featureInfoArr;
        try {
            C4282m5 c4282m5 = this.f11164a;
            SafePackageManager safePackageManager = this.b;
            Context context = c4282m5.f11664a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            X9 v9 = AndroidUtils.isApiAchieved(24) ? new V9() : new W9();
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(v9.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Ng(C4282m5 c4282m5, SafePackageManager safePackageManager) {
        super(c4282m5);
        this.b = safePackageManager;
    }
}
