package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Handler;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.setting.l;

/* JADX INFO: compiled from: DemandNativePreloadController.java */
/* JADX INFO: loaded from: classes9.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f5201a;

    public abstract void a(int i, long j, int i2, l lVar, String str, String str2, com.mbridge.msdk.preload.listenter.a aVar, boolean z);

    public synchronized void a(int i, long j, int i2, l lVar, String str, String str2, boolean z, com.mbridge.msdk.preload.listenter.a aVar) {
        try {
            a(i, j, i2, lVar, str, str2, aVar, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Context context, CampaignEx campaignEx) {
    }

    public void a(CampaignUnit campaignUnit) {
    }

    public void a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar, int i) {
    }
}
