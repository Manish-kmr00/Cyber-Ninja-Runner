package com.yandex.mobile.ads.impl;

import android.media.MediaDrm;

/* JADX INFO: loaded from: classes11.dex */
final class i40 {
    public static boolean a(Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }

    public static int b(Throwable th) {
        int iA = x82.a(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo());
        if (iA != 2 && iA != 4) {
            if (iA != 10) {
                if (iA != 7) {
                    if (iA != 8) {
                        switch (iA) {
                            case 15:
                                break;
                            case 16:
                            case 18:
                                break;
                            case 17:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                break;
                            default:
                                switch (iA) {
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                        return 6002;
                                    default:
                                        return 6006;
                                }
                        }
                    }
                    return 6003;
                }
            }
            return 6004;
        }
        return 6005;
    }
}
