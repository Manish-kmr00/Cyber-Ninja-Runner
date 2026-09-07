package com.bykv.vk.openvk.pA.pA.pA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.BSW;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class KZx {
    private static int JG = 1;
    private static String KZx;
    private static BSW ML;
    private static Context Og;
    private static boolean ZZv;
    public static boolean pA;

    public static Context pA() {
        return Og;
    }

    public static String Og() {
        if (TextUtils.isEmpty(KZx)) {
            try {
                File file = new File(pA().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                KZx = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return KZx;
    }

    public static void pA(Context context, String str) {
        Og = context;
        KZx = str;
    }

    public static boolean KZx() {
        return ZZv;
    }

    public static void pA(boolean z) {
        ZZv = z;
    }

    public static BSW ZZv() {
        if (ML == null) {
            ML = new BSW.pA("v_config").pA(10000L, TimeUnit.MILLISECONDS).Og(10000L, TimeUnit.MILLISECONDS).KZx(10000L, TimeUnit.MILLISECONDS).pA();
        }
        return ML;
    }

    public static void pA(BSW bsw) {
        ML = bsw;
    }

    public static boolean ML() {
        return pA;
    }

    public static void pA(int i) {
        JG = i;
    }

    public static int JG() {
        return JG;
    }
}
