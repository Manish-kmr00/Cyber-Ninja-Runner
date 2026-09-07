package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.json.fe;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3148y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1936a;
    public final HashMap b;
    public String c;

    public C3148y(String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7) {
        String str8;
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (TextUtils.isEmpty(property)) {
            str8 = "https://" + IAConfigManager.O.i.f;
        } else {
            str8 = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches() ? "https://" + property + "/simpleM2M/Event" : "https://" + property + ".inner-active.mobi/simpleM2M/Event";
        }
        this.c = null;
        if (TextUtils.isEmpty(str8)) {
            throw new InvalidParameterException();
        }
        this.b = new HashMap();
        this.f1936a = str8;
        a(str7 == null ? "8.3.6" : str7, fe.S);
        a(AbstractC3251o.f2370a.getPackageName(), "pkgn");
        if (IAConfigManager.d()) {
            return;
        }
        a("Android", "osn");
        a(Build.VERSION.RELEASE, "osv");
        a(AbstractC3247k.k(), "model");
        a(AbstractC3247k.m(), "pkgv");
        a(str, "appid");
        a(str2, "session");
        a(str3, "adnt");
        a(l, "adnt_id");
        a(str4, "creative_id");
        a(str5, "adomain");
        a(str6, "campaign_id");
    }

    public final void a(Object obj, String str) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.b.put(str, obj);
    }
}
