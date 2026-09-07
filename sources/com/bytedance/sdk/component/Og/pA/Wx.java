package com.bytedance.sdk.component.Og.pA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Wx {
    public com.bytedance.sdk.component.KZx.pA.pA Og = new com.bytedance.sdk.component.KZx.pA.pA();
    public BSW pA;

    public abstract String JG();

    public abstract String KZx();

    public abstract com.bytedance.sdk.component.Og.pA.pA ML();

    public abstract SD Og();

    public abstract int SD();

    public abstract Map<String, List<String>> ZZv();

    public Sn omh() {
        return null;
    }

    public abstract Object pA();

    public void pA(BSW bsw) {
        this.pA = bsw;
    }

    public pA Bzk() {
        return new pA(this);
    }

    public static class pA {
        Sn JG;
        SD KZx;
        Object ML;
        Map<String, List<String>> Og;
        int SD;
        String ZZv;
        String omh;
        com.bytedance.sdk.component.Og.pA.pA pA;

        public pA() {
            this.Og = new HashMap();
        }

        public pA pA(com.bytedance.sdk.component.Og.pA.pA pAVar) {
            this.pA = pAVar;
            return this;
        }

        public pA pA(String str) {
            this.omh = str;
            return this;
        }

        public pA pA(int i) {
            this.SD = i;
            return this;
        }

        pA(Wx wx) {
            this.KZx = wx.Og();
            this.ZZv = wx.KZx();
            this.Og = wx.ZZv();
            this.ML = wx.pA();
            this.JG = wx.omh();
            this.pA = wx.ML();
            this.SD = wx.SD();
            this.omh = wx.JG();
        }

        public pA pA(Object obj) {
            this.ML = obj;
            return this;
        }

        public pA Og(String str) {
            return pA(SD.KZx(str));
        }

        public pA pA(SD sd) {
            this.KZx = sd;
            return this;
        }

        public pA pA(String str, String str2) {
            return Og(str, str2);
        }

        public pA Og(String str, String str2) {
            if (!this.Og.containsKey(str)) {
                this.Og.put(str, new ArrayList());
            }
            this.Og.get(str).add(str2);
            return this;
        }

        public pA pA() {
            return pA("GET", (Sn) null);
        }

        private pA pA(String str, Sn sn) {
            this.ZZv = str;
            this.JG = sn;
            return this;
        }

        public pA pA(Sn sn) {
            return pA("POST", sn);
        }

        public Wx Og() {
            return new Wx() { // from class: com.bytedance.sdk.component.Og.pA.Wx.pA.1
                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public Object pA() {
                    return pA.this.ML;
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public SD Og() {
                    return pA.this.KZx;
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public String KZx() {
                    return pA.this.ZZv;
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public Map ZZv() {
                    return pA.this.Og;
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public com.bytedance.sdk.component.Og.pA.pA ML() {
                    return pA.this.pA;
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public String JG() {
                    return pA.this.omh;
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public int SD() {
                    return pA.this.SD;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.Og.pA.Wx
                public Sn omh() {
                    return pA.this.JG;
                }
            };
        }
    }
}
