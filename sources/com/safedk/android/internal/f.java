package com.safedk.android.internal;

import android.support.annotation.NonNull;
import com.google.common.net.HttpHeaders;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.NetworkBridge;
import com.safedk.android.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class f extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8140a = "SafeDKInputStream";
    private final boolean b;
    private final String c;
    private final String d;
    private final InputStream e;
    private Map<String, List<String>> j;
    private HttpURLConnection l;
    private boolean g = false;
    private boolean h = false;
    private int i = 0;
    private ByteArrayOutputStream k = new ByteArrayOutputStream();
    private final long f = System.currentTimeMillis();

    public f(String str, String str2, InputStream inputStream, Map<String, List<String>> map, boolean z) {
        this.c = str;
        this.d = str2;
        this.e = inputStream;
        this.j = map;
        this.b = z;
    }

    public void a(HttpURLConnection httpURLConnection) {
        this.l = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.e != null) {
            int i = this.e.read();
            if (i >= 0) {
                try {
                    this.k.write(i);
                    return i;
                } catch (Throwable th) {
                    try {
                        Logger.e(f8140a, th.getMessage());
                        return i;
                    } catch (Throwable th2) {
                        return i;
                    }
                }
            }
            return i;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] b) throws IOException {
        if (this.e == null) {
            return 0;
        }
        int i = this.e.read(b);
        a(b, 0, i);
        return i;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] b, int off, int len) throws IOException {
        if (this.e == null) {
            return 0;
        }
        int i = this.e.read(b, off, len);
        a(b, off, i);
        return i;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.e != null) {
            return this.e.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (this.e != null) {
            return this.e.skip(n);
        }
        return 0L;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.e != null) {
            this.e.reset();
        }
    }

    private int a(ByteArrayOutputStream byteArrayOutputStream) {
        if (byteArrayOutputStream != null) {
            return byteArrayOutputStream.size();
        }
        return 0;
    }

    private void b() {
        int i;
        do {
            try {
                i = this.e.read();
                if (i > 0) {
                    this.k.write(i);
                }
            } catch (Exception e) {
                Logger.d(f8140a, "read all before close - exception= " + e);
                return;
            }
        } while (i > 0);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (this.e != null) {
                b();
                int iA = a(this.k);
                int iC = c(this.j);
                if (iC == iA || this.h) {
                    Logger.d(f8140a, "closing the stream, " + this + ", with amount read: " + iA);
                    this.e.close();
                } else if (iC > -1) {
                    Logger.d(f8140a, "Attempt to close the stream, " + this + ", before reading all of it has been made! amount read: " + iA + ", content size: " + iC + " sdk: " + this.c);
                }
            }
        } catch (Throwable th) {
            Logger.d(f8140a, "Exception closing input stream : " + th.getMessage(), th);
        } finally {
            a("sc");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        if (this.e != null) {
            return this.e.markSupported();
        }
        return false;
    }

    public void a() {
        if (!this.g) {
            a("cd");
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            try {
                if (this.k != null) {
                    this.k.write(bArr, i, i2);
                }
            } catch (Throwable th) {
                try {
                    Logger.e(f8140a, th.getMessage(), th);
                    return;
                } catch (Throwable th2) {
                    return;
                }
            }
        }
        if (b(this.j) && i2 == -1) {
            a("sr-lc");
        }
        if (this.b && this.k != null) {
            int iC = c(this.j);
            int size = this.k.size();
            if (iC > -1) {
                if (iC == size) {
                    a("sr-cs");
                }
            } else if (a(this.j) && i2 < this.i) {
                a("sr-rb");
            }
            this.i = i2;
        }
    }

    public void a(String str) {
        boolean zB;
        boolean zB2;
        String string;
        try {
            if ((b(this.j) || this.k == null || this.k.size() != 0) && !this.g) {
                this.g = true;
                com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(this.c);
                if (bVarJ != null) {
                    zB2 = bVarJ.b(AdNetworkConfiguration.SUPPORTS_GZIP_CONTENT);
                    zB = bVarJ.b(AdNetworkConfiguration.SHOULD_ADD_BYTE_ARRAY_AS_PARAM_ON_AD_FETCHED);
                } else {
                    zB = false;
                    zB2 = false;
                }
                if (zB2 && a(this.j)) {
                    string = com.safedk.android.utils.c.a(this.k.toByteArray());
                    if (string == null) {
                        this.g = false;
                        return;
                    }
                } else {
                    string = this.k.toString();
                }
                boolean z = string == null || string.length() == 0;
                if (!this.c.equals(com.safedk.android.utils.h.p) || !z) {
                    String str2 = this.f + ";" + str + ";" + (System.currentTimeMillis() - this.f);
                    if (zB) {
                        CreativeInfoManager.a(this.c, this.d, string, this.k.toByteArray(), this.j, str2);
                    } else {
                        CreativeInfoManager.a(this.c, this.d, string, null, this.j, str2);
                    }
                    this.h = true;
                }
                this.k = null;
                this.j = null;
                if (this.l != null) {
                    NetworkBridge.disposeOfConnectionToStreamMapping(this.l);
                }
            }
        } catch (Throwable th) {
            try {
                Logger.e(f8140a, th.getMessage());
            } catch (Throwable th2) {
            }
        }
    }

    private static boolean a(Map<String, List<String>> map) {
        if (map == null) {
            return false;
        }
        List<String> list = map.get("Content-Encoding");
        return list != null && list.contains("gzip");
    }

    private static boolean b(Map<String, List<String>> map) {
        if (map == null) {
            return false;
        }
        List<String> list = map.get(HttpHeaders.TRANSFER_ENCODING);
        return list != null && list.contains("chunked");
    }

    private static int c(Map<String, List<String>> map) {
        List<String> list;
        if (map == null || (list = map.get("Content-Length")) == null) {
            return -1;
        }
        return Integer.parseInt(list.get(0));
    }
}
