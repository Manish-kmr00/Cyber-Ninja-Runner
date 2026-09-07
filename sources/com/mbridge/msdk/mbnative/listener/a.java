package com.mbridge.msdk.mbnative.listener;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: AdListenerProxy.java */
/* JADX INFO: loaded from: classes11.dex */
public class a implements NativeListener.NativeAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeListener.NativeAdListener f5213a;
    private boolean b = false;
    private String c;
    private Context d;
    private boolean e;

    public a() {
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b() {
        this.b = true;
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdClick(Campaign campaign) {
        NativeListener.NativeAdListener nativeAdListener = this.f5213a;
        if (nativeAdListener != null) {
            nativeAdListener.onAdClick(campaign);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdFramesLoaded(List<Frame> list) {
        NativeListener.NativeAdListener nativeAdListener = this.f5213a;
        if (nativeAdListener != null) {
            nativeAdListener.onAdFramesLoaded(list);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoadError(String str) {
        this.b = false;
        NativeListener.NativeAdListener nativeAdListener = this.f5213a;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.d == null) {
                this.d = c.m().d();
            }
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            com.mbridge.msdk.mbnative.report.a.a(this.d, str, this.c, this.e, (CampaignEx) null);
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onAdLoaded(List<Campaign> list, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        try {
            this.b = false;
            synchronized (list) {
                copyOnWriteArrayList = new CopyOnWriteArrayList(list);
            }
            if (this.f5213a != null) {
                if (copyOnWriteArrayList.size() > 0) {
                    this.f5213a.onAdLoaded(copyOnWriteArrayList, i);
                } else {
                    this.f5213a.onAdLoaded(list, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.out.NativeListener.NativeAdListener
    public void onLoggingImpression(int i) {
        NativeListener.NativeAdListener nativeAdListener = this.f5213a;
        if (nativeAdListener != null) {
            nativeAdListener.onLoggingImpression(i);
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public a(NativeListener.NativeAdListener nativeAdListener) {
        this.f5213a = nativeAdListener;
    }

    public boolean a() {
        return this.b;
    }

    public void a(CampaignEx campaignEx, String str) {
        this.b = false;
        NativeListener.NativeAdListener nativeAdListener = this.f5213a;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.d == null) {
                this.d = c.m().d();
            }
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            com.mbridge.msdk.mbnative.report.a.a(this.d, str, this.c, this.e, campaignEx);
        }
    }
}
