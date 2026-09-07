package com.bytedance.sdk.component.ML.ZZv;

/* JADX INFO: loaded from: classes8.dex */
public class BSW extends pA {
    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public void pA(final com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        final com.bytedance.sdk.component.ML.KZx.JG jgYFO = kZx.yFO();
        com.bytedance.sdk.component.ML.ZZv ZZv = jgYFO.ZZv();
        kZx.pA(false);
        try {
            com.bytedance.sdk.component.ML.JG jgPA = ZZv.pA(new com.bytedance.sdk.component.ML.Og.KZx(kZx.pA(), kZx.Wx(), kZx.Sn(), kZx.TX()));
            int iOg = jgPA.Og();
            kZx.pA(jgPA.pA());
            if (jgPA.Og() == 200) {
                final byte[] bArr = (byte[]) jgPA.KZx();
                kZx.pA(new Og(bArr, jgPA));
                final String strSGo = kZx.SGo();
                final com.bytedance.sdk.component.ML.Og ogVZF = kZx.vZF();
                if (ogVZF.KZx()) {
                    jgYFO.Og(kZx.vZF()).pA(strSGo, bArr);
                }
                jgYFO.JG().submit(new Runnable() { // from class: com.bytedance.sdk.component.ML.ZZv.BSW.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ogVZF.ZZv()) {
                            jgYFO.KZx(kZx.vZF()).pA(strSGo, bArr);
                        }
                    }
                });
                return;
            }
            jgYFO.omh();
            String.valueOf(jgPA);
            Object objKZx = jgPA.KZx();
            pA(iOg, jgPA.ZZv(), objKZx instanceof Throwable ? (Throwable) objKZx : null, kZx);
        } catch (Throwable th) {
            pA(1004, "net request failed!", th, kZx);
        }
    }

    private void pA(int i, String str, Throwable th, com.bytedance.sdk.component.ML.KZx.KZx kZx) {
        kZx.pA(new omh(i, str, th));
    }

    @Override // com.bytedance.sdk.component.ML.ZZv.Bzk
    public String pA() {
        return "net_request";
    }
}
