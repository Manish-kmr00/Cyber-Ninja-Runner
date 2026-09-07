package com.inmobi.media;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public abstract class sd {
    /* JADX WARN: Code duplicated, block: B:16:0x003f  */
    public static HashMap a() {
        boolean zA;
        String strH = C3517pb.f3400a.h();
        rd rdVar = null;
        if (strH == null || C3601vb.a(strH).isConnectedWifiEnabled()) {
            if (C3517pb.q()) {
                zA = AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_WIFI_STATE");
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean zA2 = AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_FINE_LOCATION");
                    if (zA && zA2) {
                        zA = true;
                    } else {
                        zA = false;
                    }
                }
            } else {
                zA = false;
            }
            if (zA) {
                boolean z = (C3601vb.a().getWifiFlag() & 2) == 2;
                Context contextD = C3517pb.d();
                if (contextD != null) {
                    try {
                        Object systemService = contextD.getSystemService(com.json.x8.b);
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                        WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                        if (connectionInfo != null) {
                            String bssid = connectionInfo.getBSSID();
                            String ssid = connectionInfo.getSSID();
                            if (bssid != null) {
                                if (!((z || ssid == null || !StringsKt.endsWith$default(ssid, "_nomap", false, 2, (Object) null)) ? false : true)) {
                                    rd rdVar2 = new rd();
                                    try {
                                        rdVar2.f3420a = a(bssid);
                                        if (ssid != null && StringsKt.startsWith$default(ssid, "\"", false, 2, (Object) null) && StringsKt.endsWith$default(ssid, "\"", false, 2, (Object) null)) {
                                            Intrinsics.checkNotNullExpressionValue(ssid.substring(1, ssid.length() - 1), "this as java.lang.String…ing(startIndex, endIndex)");
                                        }
                                        connectionInfo.getRssi();
                                        connectionInfo.getIpAddress();
                                        rdVar = rdVar2;
                                    } catch (Exception e) {
                                        e = e;
                                        rdVar = rdVar2;
                                        C3339d5 c3339d5 = C3339d5.f3292a;
                                        C3339d5.c.a(I4.a(e, "event"));
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            }
        }
        HashMap map = new HashMap();
        if (rdVar != null) {
            map.put("c-ap-bssid", String.valueOf(rdVar.f3420a));
        }
        return map;
    }

    public static final boolean b() {
        if (!C3517pb.q()) {
            return false;
        }
        String[] strArr = {"android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"};
        boolean zA = AbstractC3599v9.a(C3517pb.d(), "android.permission.ACCESS_FINE_LOCATION");
        boolean z = true;
        for (int i = 0; i < 3; i++) {
            if (!AbstractC3599v9.a(C3517pb.d(), strArr[i])) {
                z = false;
            }
        }
        if (z) {
            return Build.VERSION.SDK_INT < 29 || zA;
        }
        return false;
    }

    public static long a(String str) {
        String[] strArr = (String[]) new Regex("\\:").split(str, 0).toArray(new String[0]);
        byte[] bArr = new byte[6];
        for (int i = 0; i < 6; i++) {
            try {
                bArr[i] = (byte) Integer.parseInt(strArr[i], CharsKt.checkRadix(16));
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return ((((long) bArr[0]) & 255) << 40) | ((((long) bArr[3]) & 255) << 16) | (((long) bArr[5]) & 255) | ((((long) bArr[4]) & 255) << 8) | ((((long) bArr[2]) & 255) << 24) | ((((long) bArr[1]) & 255) << 32);
    }
}
