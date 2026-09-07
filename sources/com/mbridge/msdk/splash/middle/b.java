package com.mbridge.msdk.splash.middle;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;

/* JADX INFO: compiled from: SplashLoadListenerImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBSplashLoadListener f5444a;
    private c b;
    private String c;
    private String d;
    private MBridgeIds e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.b = cVar;
        this.e = mBridgeIds;
        if (mBridgeIds != null) {
            this.c = mBridgeIds.getUnitId();
        }
    }

    public void a(MBSplashLoadListener mBSplashLoadListener) {
        this.f5444a = mBSplashLoadListener;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(CampaignEx campaignEx, int i) {
        c cVar;
        c cVar2 = this.b;
        if (cVar2 == null || !cVar2.g() || campaignEx == null) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f5444a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadSuccessed(this.e, i);
            this.f5444a.isSupportZoomOut(this.e, campaignEx.getFlb() == 1);
        }
        this.b.b(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), arrayList, this.c, campaignEx.isBidCampaign());
        if (i != 2 || (cVar = this.b) == null) {
            return;
        }
        cVar.b(campaignEx, 0, true);
    }

    public void a(com.mbridge.msdk.foundation.error.b bVar, int i) {
        c cVar = this.b;
        if (cVar == null || !cVar.g()) {
            return;
        }
        String str = "";
        if (bVar != null) {
            String strG = bVar.g();
            if (!TextUtils.isEmpty(strG)) {
                str = strG;
            }
        }
        MBSplashLoadListener mBSplashLoadListener = this.f5444a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.e, str, i);
        }
        this.b.b(false);
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, this.c, !TextUtils.isEmpty(this.d), bVar != null ? bVar.a() : null);
    }
}
