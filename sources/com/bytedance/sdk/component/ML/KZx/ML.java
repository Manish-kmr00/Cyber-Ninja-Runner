package com.bytedance.sdk.component.ML.KZx;

import android.content.Context;
import com.bytedance.sdk.component.ML.TX;
import com.bytedance.sdk.component.ML.WV;
import com.bytedance.sdk.component.ML.Wx;
import com.bytedance.sdk.component.ML.XT;
import com.bytedance.sdk.component.ML.aBv;
import com.bytedance.sdk.component.ML.yFO;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes11.dex */
public class ML implements Wx {
    private TX Bzk;
    private com.bytedance.sdk.component.ML.KZx JG;
    private com.bytedance.sdk.component.ML.ZZv KZx;
    private yFO ML;
    private ExecutorService Og;
    private aBv SD;
    private XT ZZv;
    private com.bytedance.sdk.component.ML.Og omh;
    private WV pA;

    private ML(pA pAVar) {
        this.pA = pAVar.pA;
        this.Og = pAVar.Og;
        this.KZx = pAVar.KZx;
        this.ZZv = pAVar.ZZv;
        this.ML = pAVar.ML;
        this.JG = pAVar.JG;
        this.omh = pAVar.omh;
        this.SD = pAVar.SD;
        this.Bzk = pAVar.Bzk;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public WV pA() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public ExecutorService Og() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public com.bytedance.sdk.component.ML.ZZv ZZv() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public XT ML() {
        return this.ZZv;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public yFO JG() {
        return this.ML;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public com.bytedance.sdk.component.ML.KZx SD() {
        return this.JG;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public aBv omh() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public TX KZx() {
        return this.Bzk;
    }

    @Override // com.bytedance.sdk.component.ML.Wx
    public com.bytedance.sdk.component.ML.Og Bzk() {
        return this.omh;
    }

    public static ML pA(Context context) {
        return new pA().pA();
    }

    public static class pA {
        private TX Bzk;
        private com.bytedance.sdk.component.ML.KZx JG;
        private com.bytedance.sdk.component.ML.ZZv KZx;
        private yFO ML;
        private ExecutorService Og;
        private aBv SD;
        private XT ZZv;
        private com.bytedance.sdk.component.ML.Og omh;
        private WV pA;

        public pA pA(com.bytedance.sdk.component.ML.Og og) {
            this.omh = og;
            return this;
        }

        public pA pA(TX tx) {
            this.Bzk = tx;
            return this;
        }

        public pA pA(com.bytedance.sdk.component.ML.ZZv zZv) {
            this.KZx = zZv;
            return this;
        }

        public ML pA() {
            return new ML(this);
        }
    }
}
