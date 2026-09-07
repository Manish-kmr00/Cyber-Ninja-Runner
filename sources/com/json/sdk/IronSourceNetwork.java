package com.json.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.json.bk;
import com.json.ec;
import com.json.ek;
import com.json.fh;
import com.json.lh;
import com.json.mh;
import com.json.no;
import com.json.o9;
import com.json.rj;
import com.json.sdk.controller.e;
import com.json.sdk.utils.Logger;
import com.json.sdk.utils.SDKUtils;
import com.json.vj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class IronSourceNetwork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f4272a = "IronSourceNetwork";
    private static bk b;
    private static List<no> c = new ArrayList();
    private static ek d;

    private static synchronized void a() throws Exception {
        if (b == null) {
            throw new NullPointerException("Call initSDK first");
        }
    }

    private static void a(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        if (jSONObject != null) {
            ec ecVarA = mh.a(jSONObject);
            if (ecVarA.a()) {
                lh.a(ecVarA, mh.a(context, str, str2, map));
            }
        }
    }

    public static synchronized void addInitListener(no noVar) {
        ek ekVar = d;
        if (ekVar == null) {
            c.add(noVar);
        } else if (ekVar.b()) {
            noVar.onSuccess();
        } else {
            noVar.onFail(d.getError());
        }
    }

    public static synchronized void destroyAd(rj rjVar) throws Exception {
        a();
        b.b(rjVar);
    }

    public static synchronized e getControllerManager() {
        return b.a();
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void initSDK(Context context, String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            Logger.e(f4272a, "applicationKey is NULL");
            return;
        }
        if (b == null) {
            SDKUtils.setInitSDKParams(map);
            try {
                a(context, SDKUtils.getNetworkConfiguration().optJSONObject("events"), str2, str, map);
            } catch (Exception e) {
                o9.d().a(e);
                Logger.e(f4272a, "Failed to init event tracker: " + e.getMessage());
            }
            b = vj.a(context, str, str2);
        }
    }

    public static synchronized boolean isAdAvailableForInstance(rj rjVar) {
        bk bkVar = b;
        if (bkVar == null) {
            return false;
        }
        return bkVar.a(rjVar);
    }

    public static synchronized void loadAd(rj rjVar, Map<String, String> map) throws Exception {
        a();
        b.a(rjVar, map);
    }

    public static synchronized void loadAdView(Activity activity, rj rjVar, Map<String, String> map) throws Exception {
        a();
        b.b(activity, rjVar, map);
    }

    public static void onPause(Activity activity) {
        bk bkVar = b;
        if (bkVar == null) {
            return;
        }
        bkVar.onPause(activity);
    }

    public static void onResume(Activity activity) {
        bk bkVar = b;
        if (bkVar == null) {
            return;
        }
        bkVar.onResume(activity);
    }

    public static synchronized void release(Activity activity) {
        bk bkVar = b;
        if (bkVar == null) {
            return;
        }
        bkVar.a(activity);
    }

    public static synchronized void showAd(Activity activity, rj rjVar, Map<String, String> map) throws Exception {
        a();
        b.a(activity, rjVar, map);
    }

    public static synchronized void updateInitFailed(fh fhVar) {
        d = new ek(fhVar);
        Iterator<no> it = c.iterator();
        while (it.hasNext()) {
            it.next().onFail(fhVar);
        }
        c.clear();
    }

    public static synchronized void updateInitSucceeded() {
        d = new ek();
        Iterator<no> it = c.iterator();
        while (it.hasNext()) {
            it.next().onSuccess();
        }
        c.clear();
    }
}
