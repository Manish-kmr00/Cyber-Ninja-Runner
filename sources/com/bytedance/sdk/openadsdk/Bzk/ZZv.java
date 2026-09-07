package com.bytedance.sdk.openadsdk.Bzk;

import android.content.Context;
import com.bytedance.sdk.component.ML.SGo;
import com.bytedance.sdk.component.ML.TX;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.JG;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.rB;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    public static SGo pA(String str) {
        return pA.Og(str);
    }

    public static SGo pA(DX dx) {
        return pA.Og(dx);
    }

    public static InputStream pA(String str, String str2) {
        return pA.Og(str, str2);
    }

    public static boolean pA(String str, String str2, String str3) {
        return pA.Og(str, str2, str3);
    }

    public static com.bytedance.sdk.component.ML.DX pA() {
        return pA.pA;
    }

    private static final class pA {
        private static final com.bytedance.sdk.component.ML.DX pA = pA(aBv.pA());

        private static com.bytedance.sdk.component.ML.DX pA(Context context) {
            return com.bytedance.sdk.component.ML.KZx.Og.pA(context, new com.bytedance.sdk.component.ML.KZx.ML.pA().pA(new com.bytedance.sdk.component.ML.KZx.pA.pA(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040L, new File(CacheDirFactory.getImageCacheDir()))).pA(new TX() { // from class: com.bytedance.sdk.openadsdk.Bzk.ZZv.pA.2
                @Override // com.bytedance.sdk.component.ML.TX
                public ExecutorService pA() {
                    return xy.Og();
                }
            }).pA(new com.bytedance.sdk.component.ML.ZZv() { // from class: com.bytedance.sdk.openadsdk.Bzk.ZZv.pA.1
                @Override // com.bytedance.sdk.component.ML.ZZv
                /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
                public com.bytedance.sdk.component.ML.Og.ZZv pA(com.bytedance.sdk.component.ML.ML ml) {
                    BSW bswML = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ML();
                    Wx wxOg = new Wx.pA().Og(ml.pA()).pA().Og();
                    com.bytedance.sdk.component.Og.pA.DX dxOg = null;
                    com.bytedance.sdk.component.ML.Og.ML ml2 = ml.KZx() ? new com.bytedance.sdk.component.ML.Og.ML() : null;
                    if (ml2 != null) {
                        ml2.pA(System.currentTimeMillis());
                    }
                    try {
                        dxOg = bswML.pA(wxOg).Og();
                        if (ml2 != null) {
                            ml2.Og(System.currentTimeMillis());
                        }
                        Map<String, String> mapPA = pA(ml, dxOg);
                        byte[] bArrZZv = dxOg.JG().ZZv();
                        if (ml2 != null) {
                            ml2.KZx(System.currentTimeMillis());
                        }
                        com.bytedance.sdk.component.ML.Og.ZZv zZv = new com.bytedance.sdk.component.ML.Og.ZZv(dxOg.KZx(), bArrZZv, "", mapPA);
                        zZv.pA(ml2);
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(dxOg);
                        return zZv;
                    } catch (Throwable th) {
                        try {
                            return pA(ml2, th);
                        } finally {
                            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(dxOg);
                        }
                    }
                }

                private Map<String, String> pA(com.bytedance.sdk.component.ML.ML ml, com.bytedance.sdk.component.Og.pA.DX dx) {
                    if (!ml.Og()) {
                        return null;
                    }
                    JG jgSD = dx.SD();
                    HashMap map = new HashMap();
                    int iPA = jgSD.pA();
                    for (int i = 0; i < iPA; i++) {
                        String strPA = jgSD.pA(i);
                        String strOg = jgSD.Og(i);
                        if (strPA != null) {
                            map.put(strPA, strOg);
                        }
                    }
                    return map;
                }

                private com.bytedance.sdk.component.ML.Og.ZZv pA(com.bytedance.sdk.component.ML.Og.ML ml, Throwable th) {
                    th.getMessage();
                    if (ml != null) {
                        ml.KZx(System.currentTimeMillis());
                    }
                    com.bytedance.sdk.component.ML.Og.ZZv zZv = new com.bytedance.sdk.component.ML.Og.ZZv(98765, th, "net failed");
                    zZv.pA(ml);
                    return zZv;
                }
            }).pA());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static SGo Og(String str) {
            return pA(pA.pA(str).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static SGo Og(DX dx) {
            return pA(pA.pA(dx.pA()).pA(dx.Og()).Og(dx.KZx()).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).pA(dx.SD()));
        }

        private static SGo pA(SGo sGo) {
            return rB.pA() ? sGo.pA(new ML()) : sGo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static InputStream Og(String str, String str2) {
            return pA.pA(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean Og(String str, String str2, String str3) {
            return pA.pA(str, str2, str3);
        }
    }
}
