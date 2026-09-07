package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3237a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f2356a;
    public boolean c;
    public boolean b = false;
    public long d = 0;
    public long e = 0;
    public long f = 0;

    public final void a(boolean z) {
        this.c = z;
        boolean z2 = this.b;
        String str = EventConstants.SKIP;
        if (z2) {
            if (!z) {
                str = "close";
            }
            IAlog.a("%s%s timer could not start. Timer is in action!", "AdExperienceLatency: ", str);
        } else {
            if (!z) {
                str = "close";
            }
            IAlog.a("%s%s timer started", "AdExperienceLatency: ", str);
            this.d = System.currentTimeMillis();
            this.b = true;
        }
    }

    public final void a(String str) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        if (this.b) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - this.d) - this.f;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long seconds = timeUnit.toSeconds(jCurrentTimeMillis);
            long millis = timeUnit.toMillis(jCurrentTimeMillis - TimeUnit.SECONDS.toMillis(seconds));
            Locale locale = Locale.US;
            String str2 = seconds + "." + millis;
            InneractiveAdSpot inneractiveAdSpot = this.f2356a;
            com.fyber.inneractive.sdk.flow.x adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            EnumC3144u enumC3144u = this.c ? EnumC3144u.USER_SKIP_ACTION_LATENCY : EnumC3144u.USER_CLOSE_ACTION_LATENCY;
            InneractiveAdRequest inneractiveAdRequest = adContent != null ? adContent.f1840a : null;
            com.fyber.inneractive.sdk.response.e eVarC = adContent != null ? adContent.c() : null;
            JSONArray jSONArrayB = (adContent == null || (rVar = adContent.c) == null) ? null : rVar.b();
            C3146w c3146w = new C3146w(eVarC);
            c3146w.c = enumC3144u;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            JSONObject jSONObject = new JSONObject();
            String str3 = this.c ? "skip_action_latency" : "close_action_latency";
            try {
                jSONObject.put(str3, str2);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", str3, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("origin", str);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "origin", str);
                }
            }
            c3146w.f.put(jSONObject);
            c3146w.a((String) null);
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.b = false;
        }
    }
}
