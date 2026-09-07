package com.bytedance.sdk.openadsdk.JG;

import com.bytedance.sdk.openadsdk.core.KZx;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.json.b9;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    private static volatile pA pA;
    private boolean BSW;
    private int[] Bzk;
    private int DX;
    private int[] JG;
    private boolean KZx;
    private int[] ML;
    private boolean Og;
    private int[] SD;
    private boolean SGo;
    private boolean Sn;
    private int[] WV;
    private boolean Wx;
    private boolean ZZv;
    private boolean aBv;
    private boolean oX;
    private int[] omh;

    private pA() {
        Og();
    }

    public static pA pA() {
        if (pA == null) {
            synchronized (KZx.class) {
                if (pA == null) {
                    pA = new pA();
                }
            }
        }
        return pA;
    }

    public void Og() {
        Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.JG.pA.1
            @Override // java.lang.Runnable
            public void run() {
                pA.this.Sn = com.bytedance.sdk.openadsdk.vZF.pA.pA("feature_switch", false);
                if (pA.this.Sn) {
                    try {
                        pA.this.aBv = com.bytedance.sdk.openadsdk.vZF.pA.pA("exclude_banner_native", false);
                        pA.this.DX = com.bytedance.sdk.openadsdk.vZF.pA.pA("feature_timer_interval", 10000);
                        pA.this.oX = com.bytedance.sdk.openadsdk.vZF.pA.pA("enable_feature_cids", true);
                        String[] strArrSplit = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_ad_show_cnt", "1,3,5&session").split(b9.i.c);
                        String[] strArrSplit2 = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_ad_click_cnt", "1,3,5&session").split(b9.i.c);
                        String[] strArrSplit3 = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_video_play_cnt", "1,3,5&session").split(b9.i.c);
                        String[] strArrSplit4 = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_dislike_cnt", "1,3,5session").split(StringUtils.COMMA);
                        pA pAVar = pA.this;
                        pAVar.Og = pAVar.pA(strArrSplit);
                        pA pAVar2 = pA.this;
                        pAVar2.KZx = pAVar2.pA(strArrSplit2);
                        pA pAVar3 = pA.this;
                        pAVar3.ZZv = pAVar3.pA(strArrSplit3);
                        pA pAVar4 = pA.this;
                        pAVar4.ML = pAVar4.Og(strArrSplit);
                        pA pAVar5 = pA.this;
                        pAVar5.JG = pAVar5.Og(strArrSplit2);
                        pA pAVar6 = pA.this;
                        pAVar6.SD = pAVar6.Og(strArrSplit3);
                        pA pAVar7 = pA.this;
                        pAVar7.WV = pAVar7.KZx(strArrSplit4);
                        String[] strArrSplit5 = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_landingPage_stay_time", "1,3,5&session").split(b9.i.c);
                        String[] strArrSplit6 = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_video_stay_time", "1,3,5&session").split(b9.i.c);
                        pA pAVar8 = pA.this;
                        pAVar8.SGo = pAVar8.pA(strArrSplit5);
                        pA pAVar9 = pA.this;
                        pAVar9.BSW = pAVar9.pA(strArrSplit6);
                        pA pAVar10 = pA.this;
                        pAVar10.omh = pAVar10.Og(strArrSplit5);
                        pA pAVar11 = pA.this;
                        pAVar11.Bzk = pAVar11.Og(strArrSplit6);
                        pA.this.Wx = com.bytedance.sdk.openadsdk.vZF.pA.pA("pag_video_30p_session", true);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(String[] strArr) {
        if (strArr.length == 2) {
            return "session".equals(strArr[1]);
        }
        if (strArr.length == 1) {
            return "session".equals(strArr[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] Og(String[] strArr) {
        if (strArr.length > 0) {
            return KZx(strArr[0].split(StringUtils.COMMA));
        }
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] KZx(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        int i = 0;
        for (String str : strArr) {
            try {
                int i2 = Integer.parseInt(str);
                iArr[i] = i2;
                if (i2 > 0) {
                    i++;
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i == length) {
            return iArr;
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    public boolean KZx() {
        return this.Sn;
    }

    public int ZZv() {
        return this.DX;
    }

    public boolean ML() {
        return this.oX;
    }

    public boolean JG() {
        return this.Og;
    }

    public boolean SD() {
        return this.KZx;
    }

    public boolean omh() {
        return this.ZZv;
    }

    public int[] Bzk() {
        return this.ML;
    }

    public int[] SGo() {
        return this.JG;
    }

    public int[] BSW() {
        return this.SD;
    }

    public int[] WV() {
        return this.omh;
    }

    public int[] Wx() {
        return this.Bzk;
    }

    public boolean Sn() {
        return this.SGo;
    }

    public boolean DX() {
        return this.BSW;
    }

    public int[] oX() {
        return this.WV;
    }

    public boolean aBv() {
        return this.Wx;
    }

    public boolean XT() {
        return this.aBv;
    }
}
