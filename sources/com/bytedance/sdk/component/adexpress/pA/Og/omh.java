package com.bytedance.sdk.component.adexpress.pA.Og;

import com.bytedance.sdk.component.utils.WV;
import com.json.cc;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class omh {
    private static com.bytedance.sdk.component.adexpress.pA.KZx.pA pA;

    public static void pA() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(ML.omh(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarPA = com.bytedance.sdk.component.adexpress.pA.KZx.pA.pA(PangleNetworkBridge.jsonObjectInit(new String(bArr, cc.N)));
                    if (pAVarPA != null) {
                        pA = pAVarPA;
                        pA.KZx();
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        WV.pA("Version", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.pA.KZx.pA Og() {
        return pA;
    }

    public static synchronized void pA(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar) {
        if (pAVar != null) {
            if (pAVar.SD()) {
                pA = pAVar;
            }
        }
    }

    public static void KZx() {
        ML.pA(ML.omh(), Og(), "temp_pkg_info.json");
    }

    public static boolean pA(String str) {
        return ML.pA(Og(), str);
    }

    public static boolean Og(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar) {
        return ML.KZx(Og(), pAVar);
    }

    public static void ZZv() {
        ML.Og(ML.omh(), Og(), "temp_pkg_info.json");
        pA = null;
    }
}
