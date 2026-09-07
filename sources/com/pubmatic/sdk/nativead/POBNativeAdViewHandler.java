package com.pubmatic.sdk.nativead;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public class POBNativeAdViewHandler implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f7691a;
    private POBNativeAdViewListener b;
    private boolean c = false;

    public void onAdViewAttachedToWindow() {
        POBNativeAdViewListener pOBNativeAdViewListener;
        if (this.c || (pOBNativeAdViewListener = this.b) == null) {
            return;
        }
        this.c = true;
        View view = this.f7691a;
        if (view != null) {
            pOBNativeAdViewListener.onRecordImpression(view);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b == null || this.f7691a == null) {
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            this.b.onAssetClicked(this.f7691a, ((Integer) view.getTag()).intValue());
        } else if (!(tag instanceof String)) {
            this.b.onRecordClick(this.f7691a);
        } else {
            this.b.onNonAssetClicked(this.f7691a, (String) view.getTag());
        }
    }

    public void setAdView(View view) {
        this.f7691a = view;
    }

    public void setListener(POBNativeAdViewListener pOBNativeAdViewListener) {
        this.b = pOBNativeAdViewListener;
    }
}
