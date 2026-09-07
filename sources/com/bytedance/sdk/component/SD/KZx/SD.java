package com.bytedance.sdk.component.SD.KZx;

import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Wx;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class SD implements com.bytedance.sdk.component.Og.pA.omh {
    private int pA;

    public void pA(int i) {
        this.pA = i;
    }

    @Override // com.bytedance.sdk.component.Og.pA.omh
    public DX pA(com.bytedance.sdk.component.Og.pA.omh.pA pAVar) throws IOException {
        DX dxPA;
        Exception e;
        Wx wxPA = pAVar.pA();
        if (omh.pA().pA(this.pA).Og() != null) {
            omh.pA().pA(this.pA).Og().ML();
        }
        String string = wxPA.Og().toString();
        String strPA = omh.pA().pA(this.pA).pA(string);
        if (!string.equals(strPA)) {
            wxPA = wxPA.Bzk().Og(strPA).Og();
        }
        IOException iOException = null;
        try {
            dxPA = pAVar.pA(wxPA);
            try {
                if (dxPA.KZx() == -1) {
                    omh.pA().pA(this.pA).pA(wxPA, new IOException());
                }
            } catch (Exception e2) {
                e = e2;
                IOException iOException2 = new IOException(e.getMessage());
                omh.pA().pA(this.pA).pA(wxPA, e);
                iOException = iOException2;
            }
        } catch (Exception e3) {
            dxPA = null;
            e = e3;
        }
        omh.pA().pA(this.pA).pA(wxPA, dxPA);
        if (iOException == null) {
            return dxPA == null ? pAVar.pA(wxPA) : dxPA;
        }
        throw iOException;
    }
}
