package com.bytedance.sdk.openadsdk.api.init;

import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.pA.KZx;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.core.roi;
import com.bytedance.sdk.openadsdk.utils.TX;
import com.bytedance.sdk.openadsdk.utils.gbA;

/* JADX INFO: loaded from: classes13.dex */
public final class PAGConfig implements InitConfig {
    private static String BSW;
    private String Bzk;
    private int KZx;
    private boolean Og;
    private String SGo;
    private boolean omh;
    private String pA;
    private int ZZv = -1;
    private int ML = -1;
    private int JG = -1;
    private int SD = 0;

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isUseTextureView() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getData() {
        return this.SGo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str) {
        this.SGo = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAppId() {
        return this.pA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(String str) {
        this.pA = str;
    }

    public boolean getDebugLog() {
        return this.Og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        this.Og = z;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getAppIconId() {
        return this.KZx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(int i) {
        this.KZx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.ZZv = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getCoppa() {
        return this.ZZv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.ML = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getGdpr() {
        return this.ML;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.JG = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getCcpa() {
        return this.JG;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getTitleBarTheme() {
        return this.SD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public void ML(int i) {
        this.SD = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isSupportMultiProcess() {
        return this.omh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og(boolean z) {
        this.omh = z;
        KZx.pA(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(String str) {
        this.Bzk = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getPackageName() {
        if (TextUtils.isEmpty(this.Bzk)) {
            return BSW;
        }
        return this.Bzk;
    }

    public static void setChildDirected(int i) {
        if (gbA.Bzk("setCoppa")) {
            if (i < -1 || i > 1) {
                i = -1;
            }
            roi.pA().Og(i);
        }
    }

    public static int getChildDirected() {
        if (gbA.Bzk("getCoppa")) {
            return roi.pA().Og();
        }
        return -1;
    }

    public static void setGDPRConsent(int i) {
        gbA.Bzk("setGdpr");
        if (i < -1 || i > 1) {
            i = -1;
        }
        roi.pA().KZx(i);
    }

    public static int getGDPRConsent() {
        if (!gbA.Bzk("getGdpr")) {
            return -1;
        }
        int iKZx = roi.pA().KZx();
        if (iKZx == 1) {
            return 0;
        }
        if (iKZx == 0) {
            return 1;
        }
        return iKZx;
    }

    public static void setDoNotSell(int i) {
        if (gbA.Bzk("setCCPA")) {
            if (i < -1 || i > 1) {
                i = -1;
            }
            roi.pA().ZZv(i);
        }
    }

    public static int getDoNotSell() {
        if (gbA.Bzk("getCCPA")) {
            return roi.pA().JG();
        }
        return -1;
    }

    public static void debugLog(boolean z) {
        if (roi.pA() != null) {
            if (z) {
                roi.pA().ML(1);
                roi.pA().pA();
                return;
            }
            roi.pA().ML(0);
            com.bytedance.sdk.component.SD.ZZv.KZx.pA(com.bytedance.sdk.component.SD.ZZv.KZx.pA.OFF);
            WV.KZx();
            com.bykv.vk.openvk.pA.pA.pA.SD.KZx.Og();
            TX.Og();
        }
    }

    public static void setAppIconId(int i) {
        if (roi.pA() != null) {
            roi.pA().JG(i);
        }
    }

    public static void setUserData(String str) {
        if (roi.pA() != null) {
            roi.pA().Og(str);
        }
    }

    public static void setPackageName(String str) {
        BSW = str;
    }

    public static class Builder {
        private String BSW;
        private String[] Bzk;
        private int KZx;
        private boolean Og;
        private String SGo;
        private String pA;
        private int ZZv = -1;
        private int ML = -1;
        private int JG = -1;
        private int SD = 0;
        private boolean omh = false;

        public Builder useTextureView(boolean z) {
            return this;
        }

        public Builder setUserData(String str) {
            this.BSW = str;
            return this;
        }

        public Builder appId(String str) {
            this.pA = str;
            return this;
        }

        public Builder debugLog(boolean z) {
            this.Og = z;
            return this;
        }

        public Builder appIcon(int i) {
            this.KZx = i;
            return this;
        }

        public Builder setChildDirected(int i) {
            this.ZZv = i;
            return this;
        }

        public Builder setGDPRConsent(int i) {
            this.ML = i;
            return this;
        }

        public Builder setDoNotSell(int i) {
            this.JG = i;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.SD = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.omh = z;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.Bzk = strArr;
            return this;
        }

        public Builder setPackageName(String str) {
            this.SGo = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.Og(this.pA);
            pAGConfig.Og(this.ZZv);
            pAGConfig.pA(this.KZx);
            pAGConfig.ML(this.SD);
            pAGConfig.Og(this.omh);
            pAGConfig.KZx(this.ML);
            pAGConfig.ZZv(this.JG);
            pAGConfig.pA(this.Og);
            pAGConfig.KZx(this.SGo);
            pAGConfig.pA(this.BSW);
            return pAGConfig;
        }
    }
}
