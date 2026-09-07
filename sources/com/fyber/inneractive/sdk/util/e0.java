package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.C3129e;
import com.fyber.inneractive.sdk.network.C3130f;
import com.fyber.inneractive.sdk.network.RunnableC3127c;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2361a;

    public e0(Looper looper, C3130f c3130f) {
        super(looper);
        this.f2361a = new WeakReference(c3130f);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        String string;
        super.handleMessage(message);
        f0 f0Var = (f0) AbstractC3256u.a(this.f2361a);
        if (f0Var != null) {
            C3130f c3130f = (C3130f) f0Var;
            int i = message.what;
            if (i == 12312329 || i == 20150330) {
                if (c3130f.f && c3130f.f1921a.size() > 0) {
                    while (true) {
                        JSONObject jSONObject = null;
                        string = null;
                        if (c3130f.f1921a.size() <= 0) {
                            break;
                        }
                        try {
                            jSONObject = (JSONObject) c3130f.f1921a.poll();
                        } catch (Throwable unused) {
                        }
                        if (jSONObject != null) {
                            c3130f.b.put(jSONObject);
                        }
                    }
                    if (c3130f.b.length() > 0) {
                        JSONArray jSONArray = c3130f.b;
                        int i2 = AbstractC3081k.f1710a;
                        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
                        if (TextUtils.isEmpty(property)) {
                            str = "https://" + IAConfigManager.O.i.f;
                        } else {
                            str = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches() ? "https://" + property + "/simpleM2M/Event" : "https://" + property + ".inner-active.mobi/simpleM2M/Event";
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            string = jSONArray.toString();
                        } catch (Throwable unused2) {
                        }
                        if (string != null) {
                            IAConfigManager.O.s.b(new com.fyber.inneractive.sdk.network.X(new C3129e(str, jSONArray, jCurrentTimeMillis), str, string));
                        }
                        c3130f.b = new JSONArray();
                    }
                }
                e0 e0Var = c3130f.d;
                if (e0Var != null) {
                    e0Var.removeMessages(12312329);
                    long j = c3130f.e * 1000;
                    e0 e0Var2 = c3130f.d;
                    if (e0Var2 != null) {
                        e0Var2.post(new RunnableC3127c(c3130f, 12312329, j));
                    }
                }
            }
        }
    }
}
