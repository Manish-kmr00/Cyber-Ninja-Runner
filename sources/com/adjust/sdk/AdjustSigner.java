package com.adjust.sdk;

import android.content.Context;
import com.json.b9;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class AdjustSigner {
    private static volatile Object signerInstance;

    private AdjustSigner() {
    }

    private static void getSignerInstance() {
        if (signerInstance == null) {
            synchronized (AdjustSigner.class) {
                if (signerInstance == null) {
                    signerInstance = Reflection.createDefaultInstance("com.adjust.sdk.sig.Signer");
                }
            }
        }
    }

    public static boolean isPresent() {
        getSignerInstance();
        return signerInstance != null;
    }

    public static void onResume(ILogger iLogger) {
        getSignerInstance();
        if (signerInstance == null) {
            return;
        }
        try {
            Reflection.invokeInstanceMethod(signerInstance, b9.h.u0, null, new Object[0]);
        } catch (Exception e) {
            iLogger.warn("Invoking Signer onResume() received an error [%s]", e.getMessage());
        }
    }

    public static Map<String, String> sign(Map<String, String> map, Map<String, String> map2, Context context, ILogger iLogger) {
        getSignerInstance();
        HashMap map3 = new HashMap();
        if (signerInstance != null) {
            try {
                iLogger.debug("Signing all the parameters", new Object[0]);
                Reflection.invokeInstanceMethod(signerInstance, "sign", new Class[]{Context.class, Map.class, Map.class, Map.class}, context, map, map2, map3);
            } catch (Exception e) {
                iLogger.warn("Invoking Signer sign() for %s received an error [%s]", e.getMessage());
            }
        }
        return map3;
    }
}
