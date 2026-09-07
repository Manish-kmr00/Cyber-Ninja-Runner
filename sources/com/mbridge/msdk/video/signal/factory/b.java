package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.impl.i;
import com.mbridge.msdk.video.signal.impl.j;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.video.signal.impl.m;
import com.mbridge.msdk.video.signal.impl.n;
import com.mbridge.msdk.video.signal.impl.o;
import com.mbridge.msdk.video.signal.impl.q;
import java.util.List;

/* JADX INFO: compiled from: JSFactory.java */
/* JADX INFO: loaded from: classes13.dex */
public class b extends a {
    private Activity h;
    private WebView i;
    private MBridgeVideoView j;
    private MBridgeContainerView k;
    private CampaignEx l;
    private MBridgeBTContainer m;
    private com.mbridge.msdk.video.signal.a.InterfaceC0519a n;
    private String o;
    private List<CampaignEx> p;

    public b(Activity activity) {
        this.h = activity;
    }

    public void a(k kVar) {
        this.b = kVar;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getActivityProxy() {
        WebView webView = this.i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.f5945a == null) {
            this.f5945a = new i(webView);
        }
        return this.f5945a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.i getIJSRewardVideoV1() {
        Activity activity;
        MBridgeContainerView mBridgeContainerView = this.k;
        if (mBridgeContainerView == null || (activity = this.h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f == null) {
            this.f = new o(activity, mBridgeContainerView);
        }
        return this.f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSBTModule() {
        if (this.h == null || this.m == null) {
            return super.getJSBTModule();
        }
        if (this.g == null) {
            this.g = new j(this.h, this.m);
        }
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        CampaignEx campaignEx;
        List<CampaignEx> list;
        Activity activity = this.h;
        if (activity == null || (campaignEx = this.l) == null) {
            return super.getJSCommon();
        }
        if (this.b == null) {
            this.b = new k(activity, campaignEx);
        }
        if (this.l.getDynamicTempCode() == 5 && (list = this.p) != null) {
            d dVar = this.b;
            if (dVar instanceof k) {
                ((k) dVar).a(list);
            }
        }
        this.b.setActivity(this.h);
        this.b.setUnitId(this.o);
        this.b.a(this.n);
        return this.b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        MBridgeContainerView mBridgeContainerView = this.k;
        if (mBridgeContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.e == null) {
            this.e = new m(mBridgeContainerView);
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        WebView webView = this.i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.d == null) {
            this.d = new n(webView);
        }
        return this.d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.j getJSVideoModule() {
        MBridgeVideoView mBridgeVideoView = this.j;
        if (mBridgeVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.c == null) {
            this.c = new q(mBridgeVideoView);
        }
        return this.c;
    }

    public void a(List<CampaignEx> list) {
        this.p = list;
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.h = activity;
        this.m = mBridgeBTContainer;
        this.i = webView;
    }

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.video.signal.a.InterfaceC0519a interfaceC0519a) {
        this.h = activity;
        this.i = webView;
        this.j = mBridgeVideoView;
        this.k = mBridgeContainerView;
        this.l = campaignEx;
        this.n = interfaceC0519a;
        this.o = mBridgeVideoView.getUnitId();
    }
}
