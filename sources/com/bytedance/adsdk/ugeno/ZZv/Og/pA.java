package com.bytedance.adsdk.ugeno.ZZv.Og;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes6.dex */
public abstract class pA {
    public static final HashSet<String> pA = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", EventConstants.SKIP, "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected Map<String, String> JG;
    protected com.bytedance.adsdk.ugeno.Og.KZx KZx;
    protected String ML;
    protected com.bytedance.adsdk.ugeno.ZZv.Og.pA Og;
    protected String SD;
    protected String ZZv;

    public abstract void pA();

    public pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
        this.KZx = kZx;
        this.Og = pAVar;
        this.SD = str;
        Og();
    }

    private void Og() {
        com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar = this.Og;
        if (pAVar == null) {
            return;
        }
        this.ZZv = pAVar.pA();
        this.ML = this.Og.Og();
        this.JG = this.Og.KZx();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ZZv.Og.pA$pA, reason: collision with other inner class name */
    public static class C0177pA {
        public static pA pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, com.bytedance.adsdk.ugeno.ZZv.Og.pA pAVar) {
            if (pAVar == null) {
                return null;
            }
            String strOg = pAVar.Og();
            if (pA.pA.contains(strOg)) {
                return new KZx(kZx, str, pAVar);
            }
            strOg.hashCode();
            if (strOg.equals("update")) {
                return new ZZv(kZx, str, pAVar);
            }
            if (strOg.equals("emit")) {
                return new Og(kZx, str, pAVar);
            }
            return null;
        }
    }
}
