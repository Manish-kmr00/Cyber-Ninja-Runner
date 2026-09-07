package com.json;

import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.Logger;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
class yc implements Callable<eb> {
    private static final String d = "FileWorkerThread";
    private static final String e = "X-Android-Protocols";
    private static final String f = "http/1.1,h2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final db f4617a;
    private final String b;
    private long c;

    yc(db dbVar, String str, long j) {
        this.f4617a = dbVar;
        this.b = str;
        this.c = j;
    }

    int a(byte[] bArr, String str) throws Exception {
        return IronSourceStorageUtils.saveFile(bArr, str);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public eb call() {
        int i;
        if (this.c == 0) {
            this.c = 1L;
        }
        eb ebVarA = null;
        for (int i2 = 0; i2 < this.c; i2++) {
            ebVarA = a(this.f4617a.e(), i2, this.f4617a.a(), this.f4617a.c(), this.f4617a.f());
            int iB = ebVarA.b();
            if (iB != 1008 && iB != 1009) {
                break;
            }
        }
        if (ebVarA != null && ebVarA.a() != null) {
            StringBuilder sbAppend = new StringBuilder().append(this.b);
            String str = File.separator;
            String string = sbAppend.append(str).append(this.f4617a.b().getName()).toString();
            String str2 = this.f4617a.d() + str + d9.E + this.f4617a.b().getName();
            try {
                if (a(ebVarA.a(), str2) == 0) {
                    ebVarA.a(1006);
                } else if (!a(str2, string)) {
                    ebVarA.a(1014);
                }
            } catch (FileNotFoundException e2) {
                o9.d().a(e2);
                i = 1018;
                ebVarA.a(i);
            } catch (Error e3) {
                o9.d().a(e3);
                if (!TextUtils.isEmpty(e3.getMessage())) {
                    Logger.i(d, e3.getMessage());
                }
                i = 1019;
                ebVarA.a(i);
            } catch (Exception e4) {
                o9.d().a(e4);
                if (!TextUtils.isEmpty(e4.getMessage())) {
                    Logger.i(d, e4.getMessage());
                }
                ebVarA.a(1009);
            }
        }
        return ebVarA;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x017a A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #13 {all -> 0x0176, blocks: (B:103:0x0172, B:107:0x017a), top: B:118:0x0172 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0108 A[Catch: all -> 0x0104, PHI: r5 r9
  0x0108: PHI (r5v13 java.net.HttpURLConnection) = 
  (r5v8 java.net.HttpURLConnection)
  (r5v9 java.net.HttpURLConnection)
  (r5v10 java.net.HttpURLConnection)
  (r5v11 java.net.HttpURLConnection)
  (r5v14 java.net.HttpURLConnection)
 binds: [B:63:0x0106, B:88:0x0142, B:80:0x012f, B:96:0x0155, B:72:0x011c] A[DONT_GENERATE, DONT_INLINE]
  0x0108: PHI (r9v24 int) = (r9v14 int), (r9v17 int), (r9v19 int), (r9v21 int), (r9v27 int) binds: [B:63:0x0106, B:88:0x0142, B:80:0x012f, B:96:0x0155, B:72:0x011c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x0104, blocks: (B:60:0x0100, B:64:0x0108, B:71:0x0119, B:79:0x012c, B:87:0x013f, B:95:0x0152), top: B:112:0x001a }] */
    eb a(String str, int i, int i2, int i3, boolean z) throws Throwable {
        HttpURLConnection httpURLConnection;
        eb ebVar = new eb();
        if (TextUtils.isEmpty(str)) {
            ebVar.a(str);
            ebVar.a(1007);
            return ebVar;
        }
        InputStream inputStreamUrlConnectionGetInputStream = null;
        int iHttpUrlConnectionGetResponseCode = 0;
        try {
            try {
                try {
                    try {
                        URL url = new URL(str);
                        url.toURI();
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            if (z) {
                                try {
                                    httpURLConnection.setRequestProperty(e, f);
                                } catch (IllegalStateException e2) {
                                    o9.d().a(e2);
                                }
                            }
                            httpURLConnection.setConnectTimeout(i2);
                            httpURLConnection.setReadTimeout(i3);
                            httpURLConnection.connect();
                            iHttpUrlConnectionGetResponseCode = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                            if (iHttpUrlConnectionGetResponseCode < 200 || iHttpUrlConnectionGetResponseCode >= 400) {
                                Logger.i(d, " RESPONSE CODE: " + iHttpUrlConnectionGetResponseCode + " URL: " + str + " ATTEMPT: " + i);
                                iHttpUrlConnectionGetResponseCode = 1011;
                            } else {
                                inputStreamUrlConnectionGetInputStream = IronSourceNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                                ebVar.a(a(inputStreamUrlConnectionGetInputStream));
                            }
                            if (inputStreamUrlConnectionGetInputStream != null) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            o9.d().a(e);
                            i = 1018;
                            if (0 != 0) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            }
                            ebVar.a(str);
                            ebVar.a(i);
                            return ebVar;
                        } catch (Error e4) {
                            e = e4;
                            o9.d().a(e);
                            iHttpUrlConnectionGetResponseCode = 1019;
                            if (!TextUtils.isEmpty(e.getMessage())) {
                                Logger.i(d, e.getMessage());
                            }
                            if (0 != 0) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                            if (httpURLConnection != null) {
                            }
                            ebVar.a(str);
                            ebVar.a(iHttpUrlConnectionGetResponseCode);
                            return ebVar;
                        } catch (MalformedURLException e5) {
                            e = e5;
                            o9.d().a(e);
                            i = 1004;
                            if (0 != 0) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            }
                            ebVar.a(str);
                            ebVar.a(i);
                            return ebVar;
                        } catch (SocketTimeoutException e6) {
                            e = e6;
                            o9.d().a(e);
                            i = 1008;
                            if (0 != 0) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            }
                            ebVar.a(str);
                            ebVar.a(i);
                            return ebVar;
                        } catch (URISyntaxException e7) {
                            e = e7;
                            o9.d().a(e);
                            i = 1010;
                            if (0 != 0) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            }
                            ebVar.a(str);
                            ebVar.a(i);
                            return ebVar;
                        } catch (Exception e8) {
                            e = e8;
                            o9.d().a(e);
                            if (!TextUtils.isEmpty(e.getMessage())) {
                                Logger.i(d, e.getMessage());
                            }
                            i = 1009;
                            if (0 != 0) {
                                inputStreamUrlConnectionGetInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                            }
                            ebVar.a(str);
                            ebVar.a(i);
                            return ebVar;
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        httpURLConnection = null;
                    } catch (Error e10) {
                        e = e10;
                        httpURLConnection = null;
                    } catch (MalformedURLException e11) {
                        e = e11;
                        httpURLConnection = null;
                    } catch (SocketTimeoutException e12) {
                        e = e12;
                        httpURLConnection = null;
                    } catch (URISyntaxException e13) {
                        e = e13;
                        httpURLConnection = null;
                    } catch (Exception e14) {
                        e = e14;
                        httpURLConnection = null;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                inputStreamUrlConnectionGetInputStream.close();
                                if (0 != 0) {
                                    IronSourceNetworkBridge.httpUrlConnectionDisconnect(null);
                                }
                            } catch (Throwable th2) {
                                o9.d().a(th2);
                                IronLog.INTERNAL.error(th2.toString());
                                ebVar.a(str);
                                ebVar.a(0);
                                throw th;
                            }
                        } else if (0 != 0) {
                            IronSourceNetworkBridge.httpUrlConnectionDisconnect(null);
                        }
                        ebVar.a(str);
                        ebVar.a(0);
                        throw th;
                    }
                    IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                } catch (Throwable th3) {
                    o9.d().a(th3);
                    IronLog.INTERNAL.error(th3.toString());
                }
                ebVar.a(str);
                ebVar.a(iHttpUrlConnectionGetResponseCode);
            } catch (Throwable th4) {
                o9.d().a(th4);
                IronLog.INTERNAL.error(th4.toString());
                ebVar.a(str);
                ebVar.a(i);
            }
            return ebVar;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    boolean a(String str, String str2) throws Exception {
        return IronSourceStorageUtils.renameFile(str, str2);
    }

    byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr, 0, 8192);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }
}
