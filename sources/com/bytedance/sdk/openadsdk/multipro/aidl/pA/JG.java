package com.bytedance.sdk.openadsdk.multipro.aidl.pA;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.WV;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class JG extends com.bytedance.sdk.component.JG.pA.JG.pA {
    private static volatile JG pA;

    public static JG Og() {
        if (pA == null) {
            synchronized (JG.class) {
                if (pA == null) {
                    pA = new JG();
                }
            }
        }
        return pA;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG
    public Map pA(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!WV.pA()) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.pA.pA.pA(com.bytedance.sdk.openadsdk.multipro.ML.pA(aBv.pA()).pA(uri, strArr, str, strArr2, str2));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG
    public String pA(Uri uri) {
        if (WV.pA()) {
            return com.bytedance.sdk.openadsdk.multipro.ML.pA(aBv.pA()).pA(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG
    public String pA(Uri uri, ContentValues contentValues) {
        Uri uriPA;
        if (WV.pA() && (uriPA = com.bytedance.sdk.openadsdk.multipro.ML.pA(aBv.pA()).pA(uri, contentValues)) != null) {
            return uriPA.toString();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG
    public int pA(Uri uri, String str, String[] strArr) {
        if (WV.pA()) {
            return com.bytedance.sdk.openadsdk.multipro.ML.pA(aBv.pA()).pA(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.JG.pA.JG
    public int pA(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (WV.pA()) {
            return com.bytedance.sdk.openadsdk.multipro.ML.pA(aBv.pA()).pA(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
