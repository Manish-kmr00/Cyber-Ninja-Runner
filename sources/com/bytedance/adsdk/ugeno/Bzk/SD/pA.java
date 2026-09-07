package com.bytedance.adsdk.ugeno.Bzk.SD;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public abstract class pA extends com.bytedance.adsdk.ugeno.Og.pA<com.bytedance.adsdk.ugeno.Bzk.Og.pA> {
    public pA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                Og(str, str2);
                break;
        }
    }
}
