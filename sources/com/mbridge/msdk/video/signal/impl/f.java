package com.mbridge.msdk.video.signal.impl;

import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.video.module.MBridgeVideoView;

/* JADX INFO: compiled from: DefaultJSNotifyProxy.java */
/* JADX INFO: loaded from: classes11.dex */
public class f implements com.mbridge.msdk.video.signal.g {
    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i) {
        o0.a("DefaultJSNotifyProxy", "onVideoStatusNotify:" + i);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i, String str) {
        o0.a("DefaultJSNotifyProxy", "onClick:" + i + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(MBridgeVideoView.v vVar) {
        o0.a("DefaultJSNotifyProxy", "onProgressNotify:" + vVar.toString());
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(Object obj) {
        o0.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }

    @Override // com.mbridge.msdk.video.signal.g
    public void a(int i, int i2, int i3, int i4) {
        o0.a("DefaultJSNotifyProxy", "showDataInfo");
    }
}
