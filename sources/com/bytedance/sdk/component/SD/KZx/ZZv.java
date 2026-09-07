package com.bytedance.sdk.component.SD.KZx;

import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class ZZv {
    public boolean pA = false;
    public boolean Og = true;
    public Map<String, Integer> KZx = null;
    public Map<String, String> ZZv = null;
    public int ML = 10;
    public int JG = 1;
    public int SD = 1;
    public int omh = 10;
    public int Bzk = 1;
    public int SGo = 1;
    public int BSW = 900;
    public int WV = 120;
    public String Wx = null;
    public int Sn = 0;
    public long DX = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.pA);
        sb.append(" probeEnable: ").append(this.Og);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.KZx;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.ZZv;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.ML).append("#").append(this.JG).append("#").append(this.SD);
        sb.append(" reqErr: ").append(this.omh).append("#").append(this.Bzk).append("#").append(this.SGo);
        sb.append(" updateInterval: ").append(this.BSW);
        sb.append(" updateRandom: ").append(this.WV);
        sb.append(" httpBlack: ").append(this.Wx);
        return sb.toString();
    }
}
