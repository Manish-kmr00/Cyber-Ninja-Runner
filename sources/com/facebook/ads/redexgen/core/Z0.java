package com.facebook.ads.redexgen.core;

import android.media.MediaCodecInfo;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z0 {
    public static String[] A00 = {"XxiXJDFJHqMt3VFtEhfKHwqRcDt44aYQ", "w6qQLsvleLW4BzVJ23uaQ", "tw9aRoi8CVqOfW6Nyj5jb7Z90Zpzph61", "Zy", "Jh0fdgezz0pvldyneKtCvE14XkM0I7gM", "6kHiUA3KIlYHa6QCH8FXrYaY", "X8DPbS085fPi2GB25u4C9GmgYGa2cpud", "vvXcQ2u0spo9u9aTv4vnM6cI"};

    public static int A00(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty() || Z2.A07()) {
            return 0;
        }
        MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i2, (int) d);
        for (int i3 = 0; i3 < supportedPerformancePoints.size(); i3++) {
            if (supportedPerformancePoints.get(i3).covers(performancePoint)) {
                String[] strArr = A00;
                if (strArr[5].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[4] = "LvMOmArBHIzTlJ0RDJ8tT4APsOY6Tyyb";
                strArr2[2] = "sO2iIktrU0y9sdB8K279l7VmPHjfIycK";
                return 2;
            }
        }
        return 1;
    }
}
