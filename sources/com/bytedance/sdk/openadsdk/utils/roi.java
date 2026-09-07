package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes9.dex */
public class roi {
    private static String KZx = null;
    private static String Og = null;
    private static volatile boolean ZZv = true;
    private static String pA;

    /* JADX INFO: Access modifiers changed from: private */
    public static void ML() {
        String simOperatorName;
        String simOperator;
        String strSubstring;
        if (com.bytedance.sdk.openadsdk.core.aBv.pA() == null) {
            return;
        }
        ZZv = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.aBv.pA().getSystemService("phone");
            try {
                int simState = telephonyManager.getSimState();
                if (simState == 0 || simState == 1) {
                    ZZv = false;
                }
                com.bytedance.sdk.component.utils.WV.pA("MCC", ZZv ? "Have SIM card" : "No SIM card");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("SimUtils", th.getMessage());
            }
            String str = null;
            try {
                simOperatorName = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                simOperatorName = null;
            }
            try {
                simOperator = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                simOperator = null;
            }
            if (simOperator == null || simOperator.length() < 5) {
                try {
                    simOperator = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(simOperator) || simOperator.length() <= 4) {
                strSubstring = null;
            } else {
                String strSubstring2 = simOperator.substring(0, 3);
                strSubstring = simOperator.substring(3);
                str = strSubstring2;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                pA = simOperatorName;
            }
            if (!TextUtils.isEmpty(str)) {
                Og = str;
            }
            if (TextUtils.isEmpty(strSubstring)) {
                return;
            }
            KZx = strSubstring;
        } catch (Throwable unused4) {
        }
    }

    public static String pA() {
        pA.pA();
        return pA;
    }

    public static String Og() {
        try {
            pA.pA();
            if (!ZZv) {
                com.bytedance.sdk.component.utils.WV.pA("MCC", "getMCC" + (ZZv ? "Have SIM card" : "No SIM card, MCC returns null"));
                return null;
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.aBv.pA().getResources().getConfiguration();
            String strValueOf = configuration.mcc != 0 ? String.valueOf(configuration.mcc) : Og;
            com.bytedance.sdk.component.utils.WV.pA("MCC", "config=" + configuration.mcc + ",sMCC=" + Og);
            return strValueOf;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("SimUtils", th.getMessage());
            return null;
        }
    }

    public static String KZx() {
        pA.pA();
        return KZx;
    }

    public static class pA extends com.bytedance.sdk.component.omh.omh {
        public static AtomicBoolean pA = new AtomicBoolean(false);
        private static final AtomicLong Og = new AtomicLong(0);

        public pA(String str, int i) {
            super(str, i);
        }

        public static void pA() {
            if (pA.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = Og;
            if (jCurrentTimeMillis - atomicLong.get() < 600000) {
                return;
            }
            atomicLong.set(jCurrentTimeMillis);
            xy.Og((com.bytedance.sdk.component.omh.omh) new pA("UpdateSimStatusTask", 5));
        }

        @Override // java.lang.Runnable
        public void run() {
            pA.set(true);
            roi.ML();
            pA.set(false);
        }
    }
}
