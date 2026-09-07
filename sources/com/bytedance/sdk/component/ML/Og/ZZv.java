package com.bytedance.sdk.component.ML.Og;

import com.bytedance.sdk.component.ML.JG;
import com.bytedance.sdk.component.ML.SD;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv<T> implements JG {
    private T KZx;
    private SD ML;
    private int Og;
    private String ZZv;
    Map<String, String> pA;

    public ZZv(int i, T t, String str) {
        this.Og = i;
        this.KZx = t;
        this.ZZv = str;
    }

    public ZZv(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.pA = map;
    }

    @Override // com.bytedance.sdk.component.ML.JG
    public SD pA() {
        return this.ML;
    }

    public void pA(SD sd) {
        this.ML = sd;
    }

    @Override // com.bytedance.sdk.component.ML.JG
    public int Og() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.ML.JG
    public T KZx() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.ML.JG
    public String ZZv() {
        return this.ZZv;
    }

    @Override // com.bytedance.sdk.component.ML.JG
    public Map<String, String> ML() {
        return this.pA;
    }
}
