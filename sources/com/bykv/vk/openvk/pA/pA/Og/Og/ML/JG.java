package com.bykv.vk.openvk.pA.pA.Og.Og.ML;

import com.bykv.vk.openvk.pA.pA.Og.Og.Bzk;
import com.bytedance.sdk.component.Og.pA.DX;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class JG extends pA {
    private DX KZx;

    public JG(DX dx, ML ml) {
        com.bytedance.sdk.component.Og.pA.JG jgSD;
        this.KZx = dx;
        this.pA = new ArrayList();
        if (dx != null && (jgSD = dx.SD()) != null) {
            for (int i = 0; i < jgSD.pA(); i++) {
                this.pA.add(new Bzk.Og(jgSD.pA(i), jgSD.Og(i)));
            }
        }
        this.Og = ml;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public int pA() {
        return this.KZx.KZx();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public boolean Og() {
        return this.KZx.KZx() >= 200 && this.KZx.KZx() < 300;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public String pA(String str, String str2) {
        return pA(str) != null ? pA(str).Og : str2;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public List<Bzk.Og> KZx() {
        return this.pA;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public InputStream ZZv() {
        return this.KZx.JG().KZx();
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public String ML() {
        DX dx = this.KZx;
        if (dx != null && dx.omh() != null) {
            return this.KZx.omh().toString();
        }
        return "http/1.1";
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA
    public String JG() {
        return pA(this.KZx.KZx());
    }
}
