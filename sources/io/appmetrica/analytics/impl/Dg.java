package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class Dg extends Gg {
    public Dg(C4282m5 c4282m5) {
        super(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        String value = c3984a6.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (!"open".equals(jSONObject.optString("type"))) {
                return false;
            }
            Un un = this.f11164a.t;
            synchronized (un) {
                un.c(un.b() + 1);
            }
            if (!a(jSONObject.optString("link"))) {
                return false;
            }
            c3984a6.n = Boolean.TRUE;
            b();
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void b() {
        Un un = this.f11164a.t;
        synchronized (un) {
            un.a(un.a() + 1);
        }
        this.f11164a.y();
        Q8 q8 = this.f11164a.l;
        if (q8.c == null) {
            q8.a();
        }
        S8 s8 = q8.c;
        s8.getClass();
        s8.b = new HashSet();
        s8.d = 0;
        S8 s9 = q8.c;
        s9.f11346a = true;
        V8 v8 = q8.b;
        IBinaryDataHelper iBinaryDataHelper = v8.c;
        U8 u8 = v8.b;
        v8.f11390a.getClass();
        A9 a9A = T8.a(s9);
        u8.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(a9A));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter(Constants.REFERRER);
                if (!TextUtils.isEmpty(queryParameter)) {
                    C4354p2 c4354p2 = this.f11164a.s().z;
                    for (String str2 : queryParameter.split(com.ironsource.b9.i.c)) {
                        int iIndexOf = str2.indexOf("=");
                        if (iIndexOf >= 0 && a(Uri.decode(str2.substring(0, iIndexOf)), Uri.decode(str2.substring(iIndexOf + 1)), c4354p2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C4354p2 c4354p2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c4354p2 == null) {
            return false;
        }
        for (Pair pair : c4354p2.f11711a) {
            if (In.a(pair.first, str) && ((obj = pair.second) == null || ((C4329o2) obj).f11694a.equals(str2))) {
                return true;
            }
        }
        return false;
    }
}
