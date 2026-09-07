package com.bytedance.sdk.openadsdk.p002Sd;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class SD implements JG {
    private JG Og;
    Handler pA = null;

    SD(JG jg) {
        this.Og = jg;
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public ExecutorService pA() {
        JG jg = this.Og;
        if (jg == null || jg.pA() == null) {
            return Executors.newCachedThreadPool();
        }
        return this.Og.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public Context Og() {
        JG jg = this.Og;
        if (jg == null || jg.Og() == null) {
            return omh();
        }
        return this.Og.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public String KZx() {
        JG jg = this.Og;
        if (jg == null || TextUtils.isEmpty(jg.KZx())) {
            return "null";
        }
        return this.Og.KZx();
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public Handler ZZv() {
        JG jg = this.Og;
        if (jg == null || jg.SD() == null) {
            HandlerThread handlerThread = new HandlerThread("pag_strategy", -1);
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.pA = handler;
            return handler;
        }
        return this.Og.ZZv();
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public String ML() {
        JG jg = this.Og;
        if (jg != null) {
            return jg.ML();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public JSONObject JG() {
        JG jg = this.Og;
        if (jg != null) {
            return jg.JG();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public Map<String, String> SD() {
        JG jg = this.Og;
        if (jg == null || jg.SD() == null) {
            return new HashMap();
        }
        return this.Og.SD();
    }

    @Override // com.bytedance.sdk.openadsdk.p002Sd.JG
    public JSONObject pA(JSONObject jSONObject) {
        JG jg = this.Og;
        return jg != null ? jg.pA(jSONObject) : jSONObject;
    }

    private Context omh() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            return (Application) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
