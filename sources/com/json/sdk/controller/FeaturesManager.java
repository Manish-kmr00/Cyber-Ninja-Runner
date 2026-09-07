package com.json.sdk.controller;

import com.json.b9;
import com.json.ch;
import com.json.mediationsdk.logger.IronLog;
import com.json.mm;
import com.json.o8;
import com.json.o9;
import com.json.p8;
import com.json.re;
import com.json.sdk.utils.SDKUtils;
import com.json.ss;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FeaturesManager {
    private static volatile FeaturesManager d = null;
    private static final String e = "debugMode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, ?> f4278a;
    private final ArrayList<String> b = new a();
    private ch c = mm.S().z();

    class a extends ArrayList<String> {
        a() {
            add(b9.d.f);
            add(b9.d.e);
            add(b9.d.g);
            add(b9.d.h);
            add(b9.d.i);
            add(b9.d.j);
            add(b9.d.k);
            add(b9.d.l);
            add(b9.d.m);
        }
    }

    private FeaturesManager() {
        if (d != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        this.f4278a = new HashMap();
    }

    public static FeaturesManager getInstance() {
        if (d == null) {
            synchronized (FeaturesManager.class) {
                if (d == null) {
                    d = new FeaturesManager();
                }
            }
        }
        return d;
    }

    ArrayList<String> a() {
        return new ArrayList<>(this.b);
    }

    public JSONObject getDataManagerConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return networkConfiguration.has(b9.a.d) ? networkConfiguration.optJSONObject(b9.a.d) : IronSourceNetworkBridge.jsonObjectInit();
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.f4278a.containsKey("debugMode")) {
                num = (Integer) this.f4278a.get("debugMode");
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public o8 getFeatureFlagCatchUrlError() {
        return new o8(SDKUtils.getNetworkConfiguration().optJSONObject(o8.a.FLAG_NAME));
    }

    public p8 getFeatureFlagClickCheck() {
        return new p8(SDKUtils.getNetworkConfiguration());
    }

    public re getFeatureFlagHealthCheck() {
        JSONObject jSONObjectA = this.c.a(b9.a.r);
        return jSONObjectA instanceof JSONObject ? new re(jSONObjectA) : new re(null);
    }

    public int getInitRecoverTrials() {
        JSONObject jSONObjectOptJSONObject = SDKUtils.getNetworkConfiguration().optJSONObject("init");
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optInt(b9.a.e, 0);
        }
        return 0;
    }

    public ss getSessionHistoryConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return new ss(networkConfiguration.has(b9.a.s) ? networkConfiguration.optJSONObject(b9.a.s) : IronSourceNetworkBridge.jsonObjectInit());
    }

    public boolean getStopUseOnResumeAndPause() {
        return Boolean.TRUE.equals(this.c.c(b9.a.u));
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.f4278a = map;
    }
}
