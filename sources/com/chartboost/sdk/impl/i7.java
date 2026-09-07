package com.chartboost.sdk.impl;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.chartboost.sdk.internal.Model.CBError;
import com.safedk.android.internal.partials.ChartboostFilesBridge;
import com.safedk.android.internal.partials.ChartboostNetworkBridge;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
public class i7<T> implements Runnable, Comparable<i7<T>> {
    public final Executor b;
    public final j7 c;
    public final h2 d;
    public final ba e;
    public final sa f;
    public final c2<T> g;
    public final l4 h;
    public e2<T> i;
    public f2 j;
    public boolean k = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1043a;

        static {
            int[] iArr = new int[c2.b.values().length];
            f1043a = iArr;
            try {
                iArr[c2.b.UI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1043a[c2.b.ASYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static boolean b(int i) {
        return ((100 <= i && i < 200) || i == 204 || i == 304) ? false : true;
    }

    public i7(Executor executor, j7 j7Var, h2 h2Var, ba baVar, sa saVar, c2<T> c2Var, l4 l4Var) {
        this.b = executor;
        this.c = j7Var;
        this.d = h2Var;
        this.e = baVar;
        this.f = saVar;
        this.g = c2Var;
        this.h = l4Var;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00ea A[Catch: all -> 0x012d, TryCatch #5 {all -> 0x012d, blocks: (B:29:0x0096, B:31:0x009e, B:33:0x00ab, B:32:0x00a5, B:46:0x00e2, B:48:0x00ea, B:50:0x00f7, B:49:0x00f1, B:16:0x0038, B:18:0x0040, B:20:0x004e, B:21:0x0059, B:22:0x0066), top: B:69:0x0038, inners: #7, #4 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f1 A[Catch: all -> 0x012d, TryCatch #5 {all -> 0x012d, blocks: (B:29:0x0096, B:31:0x009e, B:33:0x00ab, B:32:0x00a5, B:46:0x00e2, B:48:0x00ea, B:50:0x00f7, B:49:0x00f1, B:16:0x0038, B:18:0x0040, B:20:0x004e, B:21:0x0059, B:22:0x0066), top: B:69:0x0038, inners: #7, #4 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0122  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() {
        int i;
        e2<T> e2Var = this.i;
        if (e2Var != null) {
            try {
                CBError cBError = e2Var.error;
                if (cBError == null) {
                    this.g.a(e2Var.value, this.j);
                } else {
                    this.g.a(cBError, this.j);
                }
                return;
            } catch (Exception e) {
                b7.b("deliver result: ", e);
                return;
            }
        }
        if (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.g.status, c2.d.QUEUED, c2.d.PROCESSING)) {
            return;
        }
        long jB = this.e.b();
        try {
            try {
                if (this.d.e()) {
                    f2 f2VarA = a(this.g);
                    this.j = f2VarA;
                    if (f2VarA.c()) {
                        this.i = this.g.a(this.j);
                    } else {
                        this.i = a(this.j.getStatusCode());
                    }
                } else {
                    this.i = a();
                }
                this.g.processingNs = this.e.b() - jB;
                int i2 = a.f1043a[this.g.dispatch.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        return;
                    }
                    this.b.execute(this);
                    return;
                }
                this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.b();
                    }
                });
            } catch (InterruptedIOException e2) {
                e = e2;
                if (this.d.e()) {
                    this.i = a(e);
                } else {
                    this.i = a();
                }
                a(ma.h.DISPATCHER_EXCEPTION, e.toString());
                this.g.processingNs = this.e.b() - jB;
                i = a.f1043a[this.g.dispatch.ordinal()];
                if (i != 1) {
                    this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.b();
                        }
                    });
                } else if (i != 2) {
                }
            } catch (SocketException e3) {
                e = e3;
                if (this.d.e()) {
                    this.i = a(e);
                } else {
                    this.i = a();
                }
                a(ma.h.DISPATCHER_EXCEPTION, e.toString());
                this.g.processingNs = this.e.b() - jB;
                i = a.f1043a[this.g.dispatch.ordinal()];
                if (i != 1) {
                    this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.b();
                        }
                    });
                } else if (i != 2) {
                }
            } catch (UnknownHostException e4) {
                e = e4;
                if (this.d.e()) {
                    this.i = a(e);
                } else {
                    this.i = a();
                }
                a(ma.h.DISPATCHER_EXCEPTION, e.toString());
                this.g.processingNs = this.e.b() - jB;
                i = a.f1043a[this.g.dispatch.ordinal()];
                if (i != 1) {
                    this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.b();
                        }
                    });
                } else if (i != 2) {
                }
            } catch (SSLException e5) {
                e = e5;
                if (this.d.e()) {
                    this.i = a(e);
                } else {
                    this.i = a();
                }
                a(ma.h.DISPATCHER_EXCEPTION, e.toString());
                this.g.processingNs = this.e.b() - jB;
                i = a.f1043a[this.g.dispatch.ordinal()];
                if (i != 1) {
                    this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.b();
                        }
                    });
                } else if (i != 2) {
                }
            } catch (Throwable th) {
                if (this.d.e()) {
                    this.i = a(th);
                } else {
                    this.i = a();
                }
                a(ma.h.REQUEST_JSON_SERIALIZATION_ERROR, th.toString());
                this.g.processingNs = this.e.b() - jB;
                int i3 = a.f1043a[this.g.dispatch.ordinal()];
                if (i3 == 1) {
                    this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.b();
                        }
                    });
                } else if (i3 != 2) {
                }
            }
        } catch (Throwable th2) {
            this.g.processingNs = this.e.b() - jB;
            int i4 = a.f1043a[this.g.dispatch.ordinal()];
            if (i4 == 1) {
                this.f.a(new Function0() { // from class: com.chartboost.sdk.impl.i7$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.b();
                    }
                });
            } else if (i4 == 2) {
                this.b.execute(this);
            }
            throw th2;
        }
    }

    public final /* synthetic */ Unit b() {
        run();
        return Unit.INSTANCE;
    }

    public final void a(Map<String, String> map, HttpsURLConnection httpsURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpsURLConnection.addRequestProperty(str, map.get(str));
            }
        }
    }

    public final void c(HttpsURLConnection httpsURLConnection) throws IOException {
        File file = new File(this.g.outputFile.getParentFile(), this.g.outputFile.getName() + ".tmp");
        if (this.g instanceof tb) {
            if (file.exists()) {
                return;
            }
            if (!file.createNewFile()) {
                throw new IOException("Video temp file was not created and doesn't exist");
            }
        }
        c2<T> c2Var = this.g;
        if (c2Var instanceof tb) {
            a(c2Var.getUri(), a(httpsURLConnection));
        }
        InputStream inputStreamUrlConnectionGetInputStream = ChartboostNetworkBridge.urlConnectionGetInputStream(httpsURLConnection);
        try {
            FileOutputStream fileOutputStreamFileOutputStreamCtor = ChartboostFilesBridge.fileOutputStreamCtor(file);
            try {
                if (this.g instanceof tb) {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStreamUrlConnectionGetInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else if (file.exists()) {
                            fileOutputStreamFileOutputStreamCtor.write(bArr, 0, i);
                        } else {
                            throw new IOException("Temp file was deleted during download");
                        }
                    }
                } else {
                    i3.f1040a.a(inputStreamUrlConnectionGetInputStream, fileOutputStreamFileOutputStreamCtor);
                }
                fileOutputStreamFileOutputStreamCtor.close();
                if (inputStreamUrlConnectionGetInputStream != null) {
                    inputStreamUrlConnectionGetInputStream.close();
                }
                if (file.renameTo(this.g.outputFile)) {
                    return;
                }
                if (!file.delete()) {
                    String str = "Unable to delete " + file.getAbsolutePath() + " after failing to rename to " + this.g.outputFile.getAbsolutePath();
                    a(str);
                    throw new IOException(str);
                }
                String str2 = "Unable to move " + file.getAbsolutePath() + " to " + this.g.outputFile.getAbsolutePath();
                a(str2);
                throw new IOException(str2);
            } catch (Throwable th) {
                try {
                    fileOutputStreamFileOutputStreamCtor.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (inputStreamUrlConnectionGetInputStream != null) {
                try {
                    inputStreamUrlConnectionGetInputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public final byte[] b(HttpsURLConnection httpsURLConnection) throws IOException {
        InputStream errorStream;
        byte[] bArrA;
        InputStream inputStream = null;
        try {
            try {
                errorStream = ChartboostNetworkBridge.urlConnectionGetInputStream(httpsURLConnection);
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            errorStream = httpsURLConnection.getErrorStream();
        }
        InputStream inputStream2 = errorStream;
        if (inputStream2 != null) {
            bArrA = i3.f1040a.a(new BufferedInputStream(inputStream2));
        } else {
            bArrA = new byte[0];
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused3) {
            }
        }
        return bArrA;
    }

    public final void c() {
        c2<T> c2Var = this.g;
        if (c2Var == null || c2Var.outputFile == null || !(c2Var instanceof tb)) {
            return;
        }
        File file = new File(this.g.outputFile.getParentFile(), this.g.outputFile.getName() + ".tmp");
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(i7 i7Var) {
        return this.g.getPriority().getValue() - i7Var.g.getPriority().getValue();
    }

    public final void a(String str, long j) {
        if (this.k) {
            this.k = false;
            this.g.a(str, j);
        }
    }

    public final byte[] a(HttpsURLConnection httpsURLConnection, int i, long j) throws IOException {
        byte[] bArrB;
        byte[] bArr = new byte[0];
        try {
            if (b(i)) {
                if (this.g.outputFile != null) {
                    c(httpsURLConnection);
                } else {
                    bArrB = b(httpsURLConnection);
                }
                return bArr;
            }
            bArrB = new byte[0];
            bArr = bArrB;
            return bArr;
        } finally {
            this.g.readDataNs = this.e.b() - j;
        }
    }

    public final f2 a(c2<T> c2Var, int i) throws IOException {
        this.k = true;
        d2 d2VarA = c2Var.a();
        Map<String, String> map = d2VarA.headers;
        HttpsURLConnection httpsURLConnectionA = this.c.a(c2Var);
        httpsURLConnectionA.setSSLSocketFactory(k2.a());
        httpsURLConnectionA.setConnectTimeout(i);
        httpsURLConnectionA.setReadTimeout(i);
        httpsURLConnectionA.setUseCaches(false);
        httpsURLConnectionA.setDoInput(true);
        try {
            a(map, httpsURLConnectionA);
            httpsURLConnectionA.setRequestMethod(c2Var.getMethod().name());
            a(d2VarA, httpsURLConnectionA);
            long jB = this.e.b();
            try {
                int iHttpUrlConnectionGetResponseCode = ChartboostNetworkBridge.httpUrlConnectionGetResponseCode(httpsURLConnectionA);
                long jB2 = this.e.b();
                c2Var.getResponseCodeNs = jB2 - jB;
                if (iHttpUrlConnectionGetResponseCode != -1) {
                    f2 f2Var = new f2(iHttpUrlConnectionGetResponseCode, a(httpsURLConnectionA, iHttpUrlConnectionGetResponseCode, jB2));
                    ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnectionA);
                    return f2Var;
                }
                throw new IOException("Could not retrieve response code from HttpsURLConnection.");
            } catch (Throwable th) {
                c2Var.getResponseCodeNs = this.e.b() - jB;
                throw th;
            }
        } catch (Throwable th2) {
            ChartboostNetworkBridge.httpUrlConnectionDisconnect(httpsURLConnectionA);
            throw th2;
        }
    }

    public final f2 a(c2<T> c2Var) throws IOException {
        int i = 10000;
        int i2 = 0;
        while (true) {
            try {
                return a(c2Var, i);
            } catch (SocketTimeoutException e) {
                if (i2 >= 1) {
                    throw e;
                }
                i *= 2;
                i2++;
            }
        }
    }

    public final void a(ma maVar, String str) {
        try {
            c();
            this.h.mo4741track(r3.a(maVar, str));
        } catch (Exception unused) {
        }
    }

    public final void a(String str) {
        this.h.mo4741track(r3.a(ma.h.RESPONSE_DATA_WRITE_ERROR, str));
    }

    public final e2<T> a(int i) {
        return e2.a(new CBError(CBError.c.NETWORK_FAILURE, "Failure due to HTTP status code " + i));
    }

    public final e2<T> a() {
        return e2.a(new CBError(CBError.c.INTERNET_UNAVAILABLE, "Internet Unavailable"));
    }

    public final e2<T> a(IOException iOException) {
        return e2.a(new CBError(CBError.c.NETWORK_FAILURE, iOException.toString()));
    }

    public final e2<T> a(Throwable th) {
        return e2.a(new CBError(CBError.c.MISCELLANEOUS, th.toString()));
    }

    public final void a(d2 d2Var, HttpsURLConnection httpsURLConnection) throws IOException {
        if (!c2.c.POST.equals(this.g.getMethod()) || d2Var.body == null) {
            return;
        }
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setFixedLengthStreamingMode(d2Var.body.length);
        if (d2Var.getContentType() != null) {
            httpsURLConnection.addRequestProperty("Content-Type", d2Var.getContentType());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(ChartboostNetworkBridge.urlConnectionGetOutputStream(httpsURLConnection));
        try {
            dataOutputStream.write(d2Var.body);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final long a(HttpsURLConnection httpsURLConnection) {
        return httpsURLConnection.getContentLengthLong();
    }
}
