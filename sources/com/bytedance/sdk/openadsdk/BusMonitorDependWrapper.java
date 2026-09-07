package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.oX.Og;
import com.bytedance.sdk.openadsdk.oX.Og.pA;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class BusMonitorDependWrapper implements Og {
    private Handler Og;
    private Og pA;

    public BusMonitorDependWrapper(Og og) {
        this.pA = og;
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public Context getContext() {
        Og og = this.pA;
        if (og != null && og.getContext() != null) {
            return this.pA.getContext();
        }
        return getReflectContext();
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public Handler getHandler() {
        Og og = this.pA;
        if (og != null && og.getHandler() != null) {
            return this.pA.getHandler();
        }
        if (this.Og == null) {
            HandlerThread handlerThread = new HandlerThread("pag_monitor");
            handlerThread.start();
            this.Og = new Handler(handlerThread.getLooper());
        }
        return this.Og;
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public int getUploadIntervalTime() {
        int uploadIntervalTime;
        Og og = this.pA;
        return (og == null || (uploadIntervalTime = og.getUploadIntervalTime()) < 1800000) ? Constants.THIRTY_MINUTES : uploadIntervalTime;
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public boolean isMonitorOpen() {
        Og og = this.pA;
        if (og != null) {
            return og.isMonitorOpen();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public void onMonitorUpload(List<pA> list) {
        Og og = this.pA;
        if (og != null) {
            og.onMonitorUpload(list);
        }
    }

    public static Context getReflectContext() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            return (Application) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public int getOnceLogCount() {
        Og og = this.pA;
        if (og != null) {
            return og.getOnceLogCount();
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.oX.Og
    public int getOnceLogInterval() {
        Og og = this.pA;
        if (og != null) {
            return og.getOnceLogInterval();
        }
        return 1000;
    }
}
