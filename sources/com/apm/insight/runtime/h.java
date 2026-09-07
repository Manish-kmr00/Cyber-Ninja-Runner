package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.ICommonParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DefaultCommonParams.java */
/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f287a = null;
    private int b = -1;

    public static com.apm.insight.nativecrash.b a(Context context) {
        return new com.apm.insight.nativecrash.b(context, new ICommonParams() { // from class: com.apm.insight.runtime.h.1
            @Override // com.apm.insight.ICommonParams
            public final String getDeviceId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final long getUserId() {
                return 0L;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Object> getCommonParams() {
                return new HashMap();
            }
        });
    }

    public final void a(String str) {
        this.f287a = str;
        q.a().a(str);
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.f287a) && !"0".equals(this.f287a)) {
            return this.f287a;
        }
        String strD = com.apm.insight.e.a().d();
        this.f287a = strD;
        if (TextUtils.isEmpty(strD) || "0".equals(this.f287a)) {
            String strB = q.a().b();
            this.f287a = strB;
            return strB;
        }
        return this.f287a;
    }

    public final boolean b() {
        return this.f287a != null;
    }
}
