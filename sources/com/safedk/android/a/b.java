package com.safedk.android.a;

import com.google.common.net.HttpHeaders;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes7.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7947a = "ConfigDownload";
    private static final int b = 2;
    private static final int[] c = {60000, POBCommonConstants.BANNER_BID_EXPIRE_TIME_IN_MILLIS};
    private e d;
    private final String e;
    private final String f;

    public b(e eVar, String str, String str2) {
        this.d = new e();
        this.d = eVar;
        this.e = str;
        this.f = str2;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c9  */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        Throwable th;
        f fVar;
        f fVar2 = null;
        String userId = SafeDK.getInstance().getUserId();
        int i = 0;
        while (i <= 2) {
            try {
                URL url = new URL(this.e);
                Logger.d(f7947a, "Config url: " + url);
                fVar = new f(url.openConnection());
                try {
                    fVar.a(false);
                    if (userId != null) {
                        fVar.a(HttpHeaders.COOKIE, "user_id=" + userId);
                    }
                    if (this.f != null) {
                        fVar.a(HttpHeaders.IF_NONE_MATCH, this.f);
                    }
                    fVar.f();
                    a(fVar);
                    if (fVar != null) {
                        fVar.d();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e = e;
                    try {
                        Logger.e(f7947a, "Failed to download configuration", e);
                        this.d.b(e.getMessage());
                        if (i >= 2 || !a(e)) {
                            if (fVar != null) {
                                fVar.d();
                                return;
                            }
                            return;
                        }
                        int iA = a(i);
                        try {
                            Logger.d(f7947a, "Next retry in " + iA + " ms");
                            Thread.sleep(iA);
                        } catch (InterruptedException e2) {
                            Logger.e(f7947a, "Thread interrupted while sleeping: ", e2);
                            Thread.currentThread().interrupt();
                        }
                        if (fVar != null) {
                            fVar.d();
                        }
                        i++;
                        fVar2 = fVar;
                    } catch (Throwable th2) {
                        th = th2;
                        fVar2 = fVar;
                        if (fVar2 != null) {
                            fVar2.d();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Logger.e(f7947a, "Caught exception", th);
                    new CrashReporter().caughtException(th);
                    if (fVar != null) {
                        fVar.d();
                    }
                    i++;
                    fVar2 = fVar;
                }
            } catch (Exception e3) {
                e = e3;
                fVar = fVar2;
            } catch (Throwable th4) {
                th = th4;
                if (fVar2 != null) {
                    fVar2.d();
                }
                throw th;
            }
        }
    }

    private String a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            char[] cArr = new char[65536];
            while (true) {
                int i = inputStreamReader.read(cArr);
                if (i == -1) {
                    break;
                }
                sb.append(cArr, 0, i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.e(f7947a, "Failed to read configuration from input stream", e);
        }
        return sb.toString();
    }

    private int a(f fVar) throws IOException {
        InputStream inputStreamE = null;
        int iB = fVar.b();
        Logger.d(f7947a, "response code = " + iB);
        try {
            if (iB < 300) {
                inputStreamE = fVar.e();
                String strA = a(inputStreamE);
                Logger.d(f7947a, "response = " + strA);
                this.d.a(strA, b(fVar));
            } else {
                if (iB != 304) {
                    InputStream inputStreamG = fVar.g();
                    String strA2 = a(inputStreamG);
                    this.d.a(strA2);
                    if (inputStreamG != null) {
                        inputStreamG.close();
                    }
                    throw new HttpRetryException(strA2, iB);
                }
                this.d.a(null, b(fVar));
            }
        } catch (IOException e) {
            Logger.e(f7947a, "Failed to get response from server", e);
            this.d.a("Failed to read data from connection");
        } catch (Throwable th) {
            Logger.e(f7947a, "Caught exception", th);
            new CrashReporter().caughtException(th);
        } finally {
            if (inputStreamE != null) {
                inputStreamE.close();
            }
        }
        return iB;
    }

    private int a(int i) {
        return c[i];
    }

    private boolean a(Exception exc) {
        return (exc.getClass().isInstance(InterruptedIOException.class) || exc.getClass().isInstance(UnknownHostException.class) || exc.getClass().isInstance(MalformedURLException.class)) ? false : true;
    }

    private String b(f fVar) {
        return fVar.b("ETag");
    }
}
