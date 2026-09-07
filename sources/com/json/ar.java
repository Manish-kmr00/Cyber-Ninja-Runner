package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes10.dex */
public class ar extends s7 {
    private static ar R;
    private String P;
    private final ai Q = mm.S().k();

    private ar() {
        this.H = "outcome";
        this.G = 3;
        this.I = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.P = "";
    }

    public static synchronized ar i() {
        if (R == null) {
            ar arVar = new ar();
            R = arVar;
            arVar.e();
        }
        return R;
    }

    @Override // com.json.s7
    protected int c(zb zbVar) {
        return this.Q.a(IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    @Override // com.json.s7
    protected void d() {
        this.J.add(1000);
        this.J.add(1001);
        this.J.add(1002);
        this.J.add(1003);
        this.J.add(1200);
        this.J.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.J.add(1210);
        this.J.add(1211);
        this.J.add(Integer.valueOf(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.J.add(1213);
        this.J.add(Integer.valueOf(IronSourceConstants.RV_MEDIATION_LOAD_ERROR));
    }

    @Override // com.json.s7
    protected boolean d(zb zbVar) {
        int iC = zbVar.c();
        return iC == 14 || iC == 514 || iC == 515 || iC == 516 || iC == 1003 || iC == 1005 || iC == 1203 || iC == 1010 || iC == 1301 || iC == 1302;
    }

    @Override // com.json.s7
    protected String e(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.P : "";
    }

    @Override // com.json.s7
    protected void f(zb zbVar) {
        if (zbVar.c() == 15 || (zbVar.c() >= 300 && zbVar.c() < 400)) {
            this.P = zbVar.b().optString("placement");
        }
    }

    @Override // com.json.s7
    protected boolean j(zb zbVar) {
        return false;
    }
}
