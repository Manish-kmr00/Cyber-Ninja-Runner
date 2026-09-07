package com.bytedance.sdk.component.SD.Og;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.JG;
import com.bytedance.sdk.component.Og.pA.SD;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.bytedance.sdk.component.Og.pA.oX;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class Og extends KZx {
    private boolean BSW;
    private com.bytedance.sdk.component.Og.pA.pA SGo;
    private Map<String, String> WV;
    public static final com.bytedance.sdk.component.Og.pA.pA pA = new com.bytedance.sdk.component.Og.pA.pA.C0194pA().pA().Og();
    public static final com.bytedance.sdk.component.Og.pA.pA Og = new com.bytedance.sdk.component.Og.pA.pA.C0194pA().Og();

    public Og(BSW bsw) {
        super(bsw);
        this.SGo = pA;
        this.BSW = false;
        this.WV = new HashMap();
    }

    public void pA(String str, String str2) {
        if (str == null) {
            return;
        }
        this.WV.put(str, str2);
    }

    public void pA(boolean z) {
        this.BSW = z;
    }

    public void pA(final com.bytedance.sdk.component.SD.pA.pA pAVar) {
        try {
            Wx.pA pAVar2 = new Wx.pA();
            if (this.BSW) {
                pAVar2.Og(this.omh);
            } else {
                SD.pA pAVar3 = new SD.pA();
                Uri uri = Uri.parse(this.omh);
                pAVar3.pA(uri.getScheme());
                pAVar3.Og(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    pAVar3.KZx(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.WV.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.WV.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        pAVar3.pA(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                pAVar2.pA(pAVar3.Og());
            }
            pA(pAVar2);
            pAVar2.pA(this.SGo);
            pAVar2.pA((Object) KZx());
            if (!TextUtils.isEmpty(this.ML)) {
                pAVar2.pA(this.ML);
            }
            if (this.JG > 0) {
                pAVar2.pA(this.JG);
            }
            this.KZx.pA(pAVar2.pA().Og()).pA(new com.bytedance.sdk.component.Og.pA.KZx() { // from class: com.bytedance.sdk.component.SD.Og.Og.1
                @Override // com.bytedance.sdk.component.Og.pA.KZx
                public void pA(com.bytedance.sdk.component.Og.pA.Og og, IOException iOException) {
                    com.bytedance.sdk.component.SD.pA.pA pAVar4 = pAVar;
                    if (pAVar4 != null) {
                        pAVar4.pA(Og.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.Og.pA.KZx
                public void pA(com.bytedance.sdk.component.Og.pA.Og og, DX dx) throws IOException {
                    String strOg;
                    if (pAVar != null) {
                        HashMap map = new HashMap();
                        if (dx != null) {
                            JG jgSD = dx.SD();
                            if (jgSD != null) {
                                for (int i = 0; i < jgSD.pA(); i++) {
                                    map.put(jgSD.pA(i), jgSD.Og(i));
                                }
                            }
                            oX oXVarJG = dx.JG();
                            if (oXVarJG == null) {
                                strOg = "";
                            } else {
                                strOg = oXVarJG.Og();
                            }
                            pAVar.pA(Og.this, new com.bytedance.sdk.component.SD.Og(dx.ZZv(), dx.KZx(), dx.ML(), map, strOg, dx.Og(), dx.pA()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (pAVar != null) {
                pAVar.pA(this, new IOException(th.getMessage()));
            }
        }
    }

    public com.bytedance.sdk.component.SD.Og pA() {
        try {
            Wx.pA pAVar = new Wx.pA();
            String strOg = "";
            if (this.BSW) {
                pAVar.Og(this.omh);
            } else {
                SD.pA pAVar2 = new SD.pA();
                Uri uri = Uri.parse(this.omh);
                pAVar2.pA(uri.getScheme());
                pAVar2.Og(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    pAVar2.KZx(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.WV.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.WV.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        pAVar2.pA(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                pAVar.pA(pAVar2.Og());
            }
            pA(pAVar);
            pAVar.pA(this.SGo);
            pAVar.pA((Object) KZx());
            DX dxOg = this.KZx.pA(pAVar.pA().Og()).Og();
            if (dxOg == null) {
                return null;
            }
            HashMap map = new HashMap();
            JG jgSD = dxOg.SD();
            if (jgSD != null) {
                for (int i = 0; i < jgSD.pA(); i++) {
                    map.put(jgSD.pA(i), jgSD.Og(i));
                }
            }
            oX oXVarJG = dxOg.JG();
            if (oXVarJG != null) {
                strOg = oXVarJG.Og();
            }
            return new com.bytedance.sdk.component.SD.Og(dxOg.ZZv(), dxOg.KZx(), dxOg.ML(), map, strOg, dxOg.Og(), dxOg.pA());
        } catch (Throwable unused) {
            return null;
        }
    }
}
