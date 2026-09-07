package com.mbridge.msdk.foundation.same.net.utils;

/* JADX INFO: compiled from: CommonHttpConfig.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static String a(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        String str;
        if (aVar == null) {
            return "Network error,Load failed";
        }
        try {
            int i = aVar.f4982a;
            com.mbridge.msdk.foundation.same.net.toolbox.a aVar2 = aVar.c;
            int i2 = aVar2 != null ? aVar2.d : 0;
            if (i == -2) {
                str = "Network is canceled";
            } else if (i == 15) {
                str = "Network error,I/O exception contents null";
            } else if (i == 880023) {
                str = "timeout";
            } else if (i != 880041) {
                switch (i) {
                    case 1:
                        return "Network error,Load failed";
                    case 2:
                        str = "Network error,I/O exception";
                        break;
                    case 3:
                        str = "Network error,timeout exception";
                        break;
                    case 4:
                        str = "Network unknown error";
                        break;
                    case 5:
                        str = "Network error，https is not work,please check your phone time";
                        break;
                    case 6:
                        str = i2 == 0 ? "Network error,please check " : "Network error,please check state code " + i2;
                        break;
                    case 7:
                        str = i2 == 0 ? "The server returns an exception " : "The server returns an exception state code " + i2;
                        break;
                    case 8:
                        str = "Cast exception, return data can not be casted correctly";
                        break;
                    default:
                        switch (i) {
                            case 10:
                                str = "Network error,socket timeout exception";
                                break;
                            case 11:
                                str = "Network error，sslp exception";
                                break;
                            case 12:
                                str = "Network error,ConnectException";
                                break;
                            case 13:
                                if (aVar2 != null) {
                                    byte[] bArr = aVar2.f4990a;
                                    return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                                }
                                str = "Unknown socket exception";
                                break;
                            default:
                                str = "Network error,unknown";
                                break;
                        }
                        break;
                }
            } else {
                str = "Network error,UnknownHostException";
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
