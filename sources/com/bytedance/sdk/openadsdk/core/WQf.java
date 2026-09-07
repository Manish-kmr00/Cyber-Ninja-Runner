package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes12.dex */
public class WQf {
    public static ConcurrentHashMap<Integer, WQf> pA = new ConcurrentHashMap<>();
    private String JG;
    private int ML;
    private int ZZv;
    private String Og = "";
    private String KZx = "";

    public String pA() {
        return this.JG;
    }

    public String Og() {
        return this.Og;
    }

    public String KZx() {
        return this.KZx;
    }

    public int ZZv() {
        return this.ZZv;
    }

    public void pA(int i) {
        this.ZZv = i;
    }

    public int ML() {
        return this.ML;
    }

    public void Og(int i) {
        this.ML = i;
    }

    private void JG() {
        this.Og = "";
        this.KZx = "";
        this.ZZv = 0;
        this.ML = 0;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo != null) {
            String strIj = yfo.Ij();
            if (!TextUtils.isEmpty(strIj)) {
                this.JG = strIj;
            }
            String strDC = yfo.dC();
            if (TextUtils.isEmpty(strDC) && yfo.rjD()) {
                strDC = yfo.dGZ().Bzk();
            }
            if (!TextUtils.isEmpty(strDC)) {
                String[] strArrSplit = strDC.split(RemoteSettings.FORWARD_SLASH_STRING);
                if (strArrSplit.length >= 3) {
                    this.Og = strArrSplit[2];
                }
            }
            if (yfo.Wo() == null || TextUtils.isEmpty(yfo.Wo().KZx())) {
                return;
            }
            this.KZx = yfo.Wo().KZx();
        }
    }

    public static void Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo == null || TextUtils.isEmpty(yfo.tM())) {
            return;
        }
        Integer numValueOf = Integer.valueOf(yfo.Wf());
        if (numValueOf.intValue() == 0) {
            return;
        }
        if (pA == null) {
            pA = new ConcurrentHashMap<>();
        }
        WQf wQf = pA.containsKey(numValueOf) ? pA.get(numValueOf) : null;
        if (wQf == null) {
            wQf = new WQf();
        }
        String strIj = yfo.Ij();
        if (TextUtils.isEmpty(strIj) || !strIj.equals(wQf.pA())) {
            wQf.JG();
            wQf.pA(yfo);
            pA.put(numValueOf, wQf);
        }
    }

    public static void KZx(int i) {
        WQf wQf;
        if (i == 0) {
            return;
        }
        if (pA == null) {
            pA = new ConcurrentHashMap<>();
        }
        if (!pA.containsKey(Integer.valueOf(i)) || (wQf = pA.get(Integer.valueOf(i))) == null) {
            return;
        }
        wQf.Og(1);
    }

    public static void KZx(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        WQf wQf;
        if (yfo == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(yfo.Wf());
        if (numValueOf.intValue() == 0) {
            return;
        }
        if (pA == null) {
            pA = new ConcurrentHashMap<>();
        }
        if (!pA.containsKey(numValueOf) || (wQf = pA.get(numValueOf)) == null) {
            return;
        }
        wQf.pA(1);
    }
}
