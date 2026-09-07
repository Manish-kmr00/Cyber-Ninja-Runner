package com.bytedance.sdk.component.ML.KZx;

import com.bytedance.sdk.component.ML.BSW;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class ZZv<T> implements BSW {
    private int BSW;
    private boolean Bzk;
    private int JG;
    private T KZx;
    private int ML;
    private String Og;
    private Map<String, String> SD;
    private com.bytedance.sdk.component.ML.SD SGo;
    private T ZZv;
    private boolean omh;
    private String pA;

    public ZZv pA(KZx kZx, T t) {
        this.KZx = t;
        this.pA = kZx.ML();
        this.Og = kZx.pA();
        this.ML = kZx.Og();
        this.JG = kZx.KZx();
        this.Bzk = kZx.DX();
        this.SGo = kZx.oX();
        this.BSW = kZx.aBv();
        return this;
    }

    public ZZv pA(KZx kZx, T t, Map<String, String> map, boolean z) {
        this.SD = map;
        this.omh = z;
        return pA(kZx, t);
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public String pA() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public T Og() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public T KZx() {
        return this.ZZv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.ML.BSW
    public void pA(Object obj) {
        this.ZZv = this.KZx;
        this.KZx = obj;
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public Map<String, String> ZZv() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public boolean ML() {
        return this.omh;
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public boolean JG() {
        return this.Bzk;
    }

    @Override // com.bytedance.sdk.component.ML.BSW
    public int SD() {
        return this.BSW;
    }
}
