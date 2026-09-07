package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.json.cc;
import com.json.tr;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC3145v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3148y f1933a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ String g;
    public final /* synthetic */ C3146w h;

    public RunnableC3145v(C3146w c3146w, C3148y c3148y, String str, String str2, String str3, String str4, Integer num, String str5) {
        this.h = c3146w;
        this.f1933a = c3148y;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = num;
        this.g = str5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strA;
        HashMap map;
        com.fyber.inneractive.sdk.response.e eVar;
        C3146w c3146w = this.h;
        EnumC3143t enumC3143t = c3146w.b;
        if (enumC3143t != null) {
            this.f1933a.a(Integer.valueOf(enumC3143t.val), NotificationCompat.CATEGORY_ERROR);
            this.h.b.getClass();
            strA = r0.ERROR_TABLE.a();
            IAlog.a("Event dispatcher - dispatching error: %s", this.h.b);
            IAlog.d("%s %s", "DISPATCHED_SDK_ERROR", Integer.valueOf(this.h.b.val));
        } else {
            EnumC3144u enumC3144u = c3146w.c;
            if (enumC3144u != null) {
                this.f1933a.a(Integer.valueOf(enumC3144u.val), "event");
                this.h.c.getClass();
                strA = r0.EVENT_TABLE.a();
                IAlog.a("Event dispatcher - dispatching event: %s", this.h.c);
                IAlog.d("%s %s", "DISPATCHED_SDK_EVENT", Integer.valueOf(this.h.c.val));
            } else {
                strA = null;
            }
        }
        C3148y c3148y = this.f1933a;
        StringBuilder sbAppend = new StringBuilder().append(strA);
        C3146w c3146w2 = this.h;
        EnumC3143t enumC3143t2 = c3146w2.b;
        c3148y.a(sbAppend.append(enumC3143t2 != null ? String.valueOf(enumC3143t2.val) : String.valueOf(c3146w2.c.val)).toString(), cc.Q);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        this.f1933a.a(Long.valueOf(calendar.getTimeInMillis()), "date_created");
        if (!IAConfigManager.d()) {
            this.f1933a.a(this.b, "contentid");
            this.f1933a.a(this.c, "fairbidv");
            if (!TextUtils.isEmpty(this.d)) {
                this.f1933a.a(this.d, "placement_type");
            }
            if (!TextUtils.isEmpty(this.e)) {
                this.f1933a.a(this.e, "spot_id");
            }
            if (!InneractiveAdManager.isCurrentUserAChild()) {
                String strJ = AbstractC3247k.j();
                if (!TextUtils.isEmpty(strJ)) {
                    this.f1933a.a(strJ, "ciso");
                }
            }
            this.f1933a.a(this.f, "ad_type");
            if (this.h.g && !TextUtils.isEmpty(this.g)) {
                this.f1933a.c = this.g;
            }
            this.f1933a.a(com.fyber.inneractive.sdk.util.a0.a().b(), "n");
            try {
                this.f1933a.a(C3146w.h.format(calendar.getTime()), "day");
            } catch (Throwable unused) {
            }
            this.f1933a.a(Integer.valueOf(calendar.get(11)), "hour");
            JSONArray jSONArray = this.h.d;
            if (jSONArray != null && jSONArray.length() > 0) {
                this.f1933a.a(this.h.d, tr.d);
            }
            com.fyber.inneractive.sdk.response.e eVar2 = this.h.e;
            if (eVar2 != null && eVar2.D) {
                this.f1933a.a("1", "sdk_bidding");
            }
            if (InneractiveAdManager.isCurrentUserAChild()) {
                this.f1933a.a("1", "child_mode");
            }
            IAConfigManager iAConfigManager = IAConfigManager.O;
            this.f1933a.a(iAConfigManager.E.n() && (eVar = this.h.e) != null && eVar.H != com.fyber.inneractive.sdk.ignite.m.NONE ? "1" : "0", "ignite");
            C3148y c3148y2 = this.f1933a;
            com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
            c3148y2.a(lVar != null ? lVar.f1221a.d() : null, "ignitep");
            C3148y c3148y3 = this.f1933a;
            com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
            c3148y3.a(lVar2 != null ? lVar2.f1221a.i() : null, "ignitev");
            JSONArray jSONArrayB = iAConfigManager.M.b();
            if (jSONArrayB != null && jSONArrayB.length() > 0) {
                this.f1933a.a(jSONArrayB, "s_experiments");
            }
            JSONArray jSONArray2 = this.h.f;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                for (int i = 0; i < jSONArray2.length(); i++) {
                    if (jSONArray2.optJSONObject(i).length() >= 1) {
                        this.f1933a.a(this.h.f, "extra");
                        break;
                    }
                }
            }
            com.fyber.inneractive.sdk.response.e eVar3 = this.h.e;
            if (eVar3 != null && eVar3.L) {
                this.f1933a.a("1", "dynamic_controls");
            }
        }
        C3148y c3148y4 = this.f1933a;
        if (TextUtils.isEmpty(c3148y4.f1936a) || (map = c3148y4.b) == null || map.size() == 0) {
            return;
        }
        C3130f c3130f = IAConfigManager.O.I;
        c3130f.getClass();
        JSONObject jSONObject = new JSONObject();
        HashMap map2 = c3148y4.b;
        for (String str : map2.keySet()) {
            Object obj = map2.get(str);
            if (obj != null) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused2) {
                }
            }
        }
        String strSubstring = c3148y4.c;
        if (strSubstring != null) {
            int length = strSubstring.length();
            if (length > 51200) {
                int iIndexOf = strSubstring.indexOf("iawrapper");
                if (iIndexOf == -1) {
                    iIndexOf = 0;
                }
                strSubstring = strSubstring.substring(iIndexOf, 51199);
                IAlog.a("Sdk event dispatcher: message size %d is too long! trimming message to %d Characters", Integer.valueOf(length), 51200);
            }
            try {
                jSONObject.put(Reporting.Key.CLICK_SOURCE_TYPE_AD, strSubstring);
            } catch (JSONException e) {
                IAlog.a("Failed inserting ad body to json", e, new Object[0]);
            }
        }
        if (IAlog.f2345a == 1) {
            try {
                IAlog.d("%s, Event: %s", "SDK_EVENT", jSONObject.toString());
            } catch (Throwable unused3) {
            }
        }
        c3130f.f1921a.offer(jSONObject);
        if (c3130f.f1921a.size() > 30) {
            com.fyber.inneractive.sdk.util.e0 e0Var = c3130f.d;
            if (e0Var != null && e0Var.hasMessages(12312329)) {
                c3130f.d.removeMessages(12312329);
            }
            com.fyber.inneractive.sdk.util.e0 e0Var2 = c3130f.d;
            if (e0Var2 != null) {
                e0Var2.post(new RunnableC3127c(c3130f, 12312329, 0L));
            }
        }
    }
}
