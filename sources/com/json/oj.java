package com.json;

import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.utils.IronSourceConstants;

/* JADX INFO: loaded from: classes9.dex */
public class oj extends s7 {
    private static oj R;
    private String P;
    private final ai Q = mm.S().k();

    private oj() {
        this.H = "ironbeast";
        this.G = 2;
        this.I = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.P = "";
    }

    public static synchronized oj i() {
        if (R == null) {
            oj ojVar = new oj();
            R = ojVar;
            ojVar.e();
        }
        return R;
    }

    @Override // com.json.s7
    protected int c(zb zbVar) {
        ai aiVar;
        IronSource.AD_UNIT ad_unit;
        int iF = f(zbVar.c());
        if (iF == s7.e.BANNER.a()) {
            aiVar = this.Q;
            ad_unit = IronSource.AD_UNIT.BANNER;
        } else if (iF == s7.e.NATIVE_AD.a()) {
            aiVar = this.Q;
            ad_unit = IronSource.AD_UNIT.NATIVE_AD;
        } else {
            aiVar = this.Q;
            ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        }
        return aiVar.a(ad_unit);
    }

    @Override // com.json.s7
    protected void d() {
        this.J.add(2001);
        this.J.add(2002);
        this.J.add(2003);
        this.J.add(2004);
        this.J.add(2200);
        this.J.add(2213);
        this.J.add(2211);
        this.J.add(2212);
        this.J.add(3001);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_LOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_RELOAD));
        this.J.add(3201);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS));
        this.J.add(3002);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD));
        this.J.add(3005);
        this.J.add(3300);
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_RELOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS));
        this.J.add(Integer.valueOf(IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS));
        this.J.add(3009);
        this.J.add(4001);
        this.J.add(Integer.valueOf(IronSourceConstants.NT_CALLBACK_LOAD_ERROR));
        this.J.add(4002);
        this.J.add(4005);
        this.J.add(Integer.valueOf(IronSourceConstants.NT_INSTANCE_LOAD_ERROR));
        this.J.add(Integer.valueOf(IronSourceConstants.NT_INSTANCE_SHOW));
    }

    @Override // com.json.s7
    protected boolean d(zb zbVar) {
        int iC = zbVar.c();
        return iC == 2004 || iC == 2005 || iC == 2204 || iC == 2301 || iC == 2300 || iC == 3009 || iC == 3502 || iC == 3501 || iC == 4005 || iC == 4009 || iC == 4502 || iC == 4501;
    }

    @Override // com.json.s7
    protected String e(int i) {
        return this.P;
    }

    @Override // com.json.s7
    protected void f(zb zbVar) {
        this.P = zbVar.b().optString("placement");
    }

    @Override // com.json.s7
    protected boolean j(zb zbVar) {
        return false;
    }
}
