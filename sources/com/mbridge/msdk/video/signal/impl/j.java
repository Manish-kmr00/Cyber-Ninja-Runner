package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;

/* JADX INFO: compiled from: JSBTModule.java */
/* JADX INFO: loaded from: classes11.dex */
public class j extends c {
    private Activity b;
    private MBridgeBTContainer c;

    public j(Activity activity, MBridgeBTContainer mBridgeBTContainer) {
        this.b = activity;
        this.c = mBridgeBTContainer;
    }

    @Override // com.mbridge.msdk.video.signal.impl.c, com.mbridge.msdk.video.signal.c
    public void reactDeveloper(Object obj, String str) {
        super.reactDeveloper(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.c;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reactDeveloper(obj, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.c, com.mbridge.msdk.video.signal.c
    public void reportUrls(Object obj, String str) {
        super.reportUrls(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.c;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reportUrls(obj, str);
        } else {
            com.mbridge.msdk.video.bt.component.d.c().c(obj, str);
        }
    }
}
