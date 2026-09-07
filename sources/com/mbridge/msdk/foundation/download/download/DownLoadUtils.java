package com.mbridge.msdk.foundation.download.download;

import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public class DownLoadUtils {
    private static final int DOWNLOAD_CONNECTION_TIME_OUT = 20000;
    private static final int DOWNLOAD_READ_TIME_OUT = 30000;
    public static final String END_TAG = "<mbridgeloadend></mbridgeloadend>";
    private static final String TAG = "DownLoadUtils";

    public static void getSourceCodeFromNetUrl(final String str, final H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source, final boolean z) {
        try {
            if (!y0.a(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.DownLoadUtils.1
                    @Override // com.mbridge.msdk.foundation.same.task.a
                    public void cancelTask() {
                    }

                    @Override // com.mbridge.msdk.foundation.same.task.a
                    public void pauseTask(boolean z2) {
                    }

                    /* JADX WARN: Code duplicated, block: B:104:0x017b A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:105:0x017d A[Catch: Exception -> 0x0179, TRY_LEAVE, TryCatch #10 {Exception -> 0x0179, blocks: (B:101:0x0175, B:105:0x017d), top: B:120:0x0175 }] */
                    /* JADX WARN: Code duplicated, block: B:115:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:120:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:123:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:59:0x00fa A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:60:0x00fc A[Catch: Exception -> 0x00f8, TRY_LEAVE, TryCatch #5 {Exception -> 0x00f8, blocks: (B:56:0x00f4, B:60:0x00fc), top: B:115:0x00f4 }] */
                    /* JADX WARN: Code duplicated, block: B:67:0x010e A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:73:0x011d  */
                    /* JADX WARN: Code duplicated, block: B:74:0x011f A[Catch: all -> 0x011b, TryCatch #11 {all -> 0x011b, blocks: (B:65:0x010a, B:68:0x0110, B:70:0x0113, B:74:0x011f, B:76:0x0125, B:78:0x012b, B:80:0x0133, B:82:0x0137, B:83:0x013d, B:85:0x0141), top: B:123:0x010a }] */
                    /* JADX WARN: Code duplicated, block: B:83:0x013d A[Catch: all -> 0x011b, TryCatch #11 {all -> 0x011b, blocks: (B:65:0x010a, B:68:0x0110, B:70:0x0113, B:74:0x011f, B:76:0x0125, B:78:0x012b, B:80:0x0133, B:82:0x0137, B:83:0x013d, B:85:0x0141), top: B:123:0x010a }] */
                    /* JADX WARN: Code duplicated, block: B:85:0x0141 A[Catch: all -> 0x011b, TRY_LEAVE, TryCatch #11 {all -> 0x011b, blocks: (B:65:0x010a, B:68:0x0110, B:70:0x0113, B:74:0x011f, B:76:0x0125, B:78:0x012b, B:80:0x0133, B:82:0x0137, B:83:0x013d, B:85:0x0141), top: B:123:0x010a }] */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r11v0 */
                    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r1v10 */
                    /* JADX WARN: Type inference failed for: r1v2 */
                    /* JADX WARN: Type inference failed for: r1v20 */
                    /* JADX WARN: Type inference failed for: r1v21, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r1v23, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r1v25 */
                    /* JADX WARN: Type inference failed for: r1v26 */
                    /* JADX WARN: Type inference failed for: r1v27 */
                    /* JADX WARN: Type inference failed for: r1v28 */
                    /* JADX WARN: Type inference failed for: r1v29 */
                    /* JADX WARN: Type inference failed for: r1v3 */
                    /* JADX WARN: Type inference failed for: r1v4 */
                    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
                    /* JADX WARN: Type inference failed for: r1v9 */
                    /* JADX WARN: Type inference failed for: r2v1 */
                    /* JADX WARN: Type inference failed for: r2v17 */
                    /* JADX WARN: Type inference failed for: r2v20 */
                    /* JADX WARN: Type inference failed for: r2v7 */
                    /* JADX WARN: Type inference failed for: r3v0 */
                    /* JADX WARN: Type inference failed for: r3v1 */
                    /* JADX WARN: Type inference failed for: r3v2 */
                    @Override // com.mbridge.msdk.foundation.same.task.a
                    public void runTask() throws Throwable {
                        ByteArrayOutputStream byteArrayOutputStream;
                        ?? r2;
                        byte[] bArr;
                        String str2;
                        Exception e;
                        ?? r1;
                        String message;
                        byte[] byteArray;
                        H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source2;
                        ?? r3;
                        boolean z2;
                        ?? UrlConnectionGetInputStream = "responseCode is ";
                        ?? r4 = 0;
                        boolean z3 = false;
                        try {
                            try {
                                H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source3 = iOnDownLoadH5Source;
                                if (iOnDownLoadH5Source3 != null) {
                                    iOnDownLoadH5Source3.onStart();
                                }
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                                httpsURLConnection.setHostnameVerifier(new MBridgeHostnameVerifier(str));
                                httpsURLConnection.setReadTimeout(30000);
                                httpsURLConnection.setConnectTimeout(20000);
                                int iHttpUrlConnectionGetResponseCode = MintegralNetworkBridge.httpUrlConnectionGetResponseCode(httpsURLConnection);
                                o0.a(DownLoadUtils.TAG, "response code " + iHttpUrlConnectionGetResponseCode);
                                if (iHttpUrlConnectionGetResponseCode == 200) {
                                    UrlConnectionGetInputStream = MintegralNetworkBridge.urlConnectionGetInputStream(httpsURLConnection);
                                    try {
                                        byte[] bArr2 = new byte[6144];
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        while (true) {
                                            try {
                                                try {
                                                    int i = UrlConnectionGetInputStream.read(bArr2);
                                                    if (i == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream.write(bArr2, 0, i);
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    bArr = null;
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                if (UrlConnectionGetInputStream != 0) {
                                                    try {
                                                        UrlConnectionGetInputStream.close();
                                                        if (byteArrayOutputStream != null) {
                                                            byteArrayOutputStream.close();
                                                        }
                                                    } catch (Exception e3) {
                                                        e3.printStackTrace();
                                                        e3.getMessage();
                                                        throw th;
                                                    }
                                                } else if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        if (byteArrayOutputStream.toByteArray() != null) {
                                            byteArray = byteArrayOutputStream.toByteArray();
                                            try {
                                                str2 = !z ? new String(byteArray) : null;
                                            } catch (Exception e4) {
                                                bArr = byteArray;
                                                e = e4;
                                                str2 = null;
                                                r1 = UrlConnectionGetInputStream;
                                                message = e.getMessage();
                                                o0.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                                if (r1 != 0) {
                                                    try {
                                                        r1.close();
                                                        if (byteArrayOutputStream != null) {
                                                            byteArrayOutputStream.close();
                                                        }
                                                    } catch (Exception e5) {
                                                        e5.printStackTrace();
                                                        message = e5.getMessage();
                                                        byteArray = bArr;
                                                        UrlConnectionGetInputStream = r1;
                                                        if (z3) {
                                                            try {
                                                                if (!z) {
                                                                    if (!z3) {
                                                                        iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                                        if (iOnDownLoadH5Source2 != null) {
                                                                            iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                                        }
                                                                    } else {
                                                                        iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                                        if (iOnDownLoadH5Source2 != null) {
                                                                            iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                                        }
                                                                    }
                                                                } else if (!z3) {
                                                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                                    if (iOnDownLoadH5Source2 != null) {
                                                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                                    }
                                                                } else {
                                                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                                    if (iOnDownLoadH5Source2 != null) {
                                                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                                    }
                                                                }
                                                            } catch (Throwable th2) {
                                                                if (MBridgeConstans.DEBUG) {
                                                                    th2.printStackTrace();
                                                                }
                                                                H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source4 = iOnDownLoadH5Source;
                                                                if (iOnDownLoadH5Source4 != null) {
                                                                    try {
                                                                        iOnDownLoadH5Source4.onFailed(th2.getMessage());
                                                                        return;
                                                                    } catch (Exception e6) {
                                                                        e6.printStackTrace();
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            }
                                                        } else if (!z3) {
                                                            iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                            if (iOnDownLoadH5Source2 != null) {
                                                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                            }
                                                        } else {
                                                            iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                            if (iOnDownLoadH5Source2 != null) {
                                                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                            }
                                                        }
                                                    }
                                                } else if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                byteArray = bArr;
                                                UrlConnectionGetInputStream = r1;
                                            }
                                        } else {
                                            byteArray = null;
                                            str2 = null;
                                        }
                                        message = "";
                                        z2 = true;
                                        r3 = UrlConnectionGetInputStream;
                                    } catch (Exception e7) {
                                        bArr = null;
                                        byteArrayOutputStream = null;
                                        str2 = null;
                                        r2 = UrlConnectionGetInputStream;
                                        e = e7;
                                        ?? r11 = r2;
                                        e = e;
                                        r1 = r11;
                                        message = e.getMessage();
                                        o0.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                        if (r1 != 0) {
                                            r1.close();
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        } else if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        byteArray = bArr;
                                        UrlConnectionGetInputStream = r1;
                                        if (z3) {
                                            if (!z) {
                                                if (!z3) {
                                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                    if (iOnDownLoadH5Source2 != null) {
                                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                    }
                                                } else {
                                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                    if (iOnDownLoadH5Source2 != null) {
                                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                    }
                                                }
                                            } else if (!z3) {
                                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                if (iOnDownLoadH5Source2 != null) {
                                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                }
                                            } else {
                                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                if (iOnDownLoadH5Source2 != null) {
                                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                }
                                            }
                                        } else if (!z3) {
                                            iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                            if (iOnDownLoadH5Source2 != null) {
                                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                            }
                                        } else {
                                            iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                            if (iOnDownLoadH5Source2 != null) {
                                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        byteArrayOutputStream = null;
                                        r4 = UrlConnectionGetInputStream;
                                        UrlConnectionGetInputStream = r4;
                                        if (UrlConnectionGetInputStream != 0) {
                                            UrlConnectionGetInputStream.close();
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                        } else if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                        throw th;
                                    }
                                } else {
                                    message = "responseCode is " + iHttpUrlConnectionGetResponseCode;
                                    r3 = 0;
                                    byteArray = null;
                                    byteArrayOutputStream = null;
                                    str2 = null;
                                    z2 = false;
                                }
                                try {
                                    MintegralNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnection);
                                    if (r3 != 0) {
                                        try {
                                            r3.close();
                                        } catch (Exception e8) {
                                            e8.printStackTrace();
                                            message = e8.getMessage();
                                            UrlConnectionGetInputStream = r3;
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z3 = z2;
                                    UrlConnectionGetInputStream = r3;
                                } catch (Exception e9) {
                                    byte[] bArr3 = byteArray;
                                    r2 = r3;
                                    e = e9;
                                    bArr = bArr3;
                                    ?? r12 = r2;
                                    e = e;
                                    r1 = r12;
                                    message = e.getMessage();
                                    o0.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                    if (r1 != 0) {
                                        r1.close();
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } else if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    byteArray = bArr;
                                    UrlConnectionGetInputStream = r1;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                r2 = 0;
                                bArr = null;
                                byteArrayOutputStream = null;
                                str2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = null;
                                UrlConnectionGetInputStream = r4;
                                if (UrlConnectionGetInputStream != 0) {
                                    UrlConnectionGetInputStream.close();
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } else if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                            if (z3) {
                                if (!z && byteArray != null && byteArray.length > 0) {
                                    iOnDownLoadH5Source.onSuccess(null, byteArray, str);
                                } else if (!z3 && y0.b(str2) && str2.length() > 0 && str2.contains(DownLoadUtils.END_TAG)) {
                                    H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source5 = iOnDownLoadH5Source;
                                    if (iOnDownLoadH5Source5 != null) {
                                        iOnDownLoadH5Source5.onSuccess(str2, byteArray, str);
                                    }
                                } else {
                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                    if (iOnDownLoadH5Source2 != null) {
                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                    }
                                }
                            } else if (!z3) {
                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                if (iOnDownLoadH5Source2 != null) {
                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                }
                            } else {
                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                if (iOnDownLoadH5Source2 != null) {
                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                });
                return;
            }
            if (iOnDownLoadH5Source != null) {
                iOnDownLoadH5Source.onFailed("url is error");
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}
