package com.five_corp.ad.internal;

import android.util.Log;
import com.safedk.android.internal.partials.LINEFilesBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1519a;

    public r(File file) {
        this.f1519a = new File(file, "com.five_corp.ad");
    }

    public final void a(String str) {
        c(str + "_SUCCESS").delete();
        c(str).delete();
    }

    public final boolean b(String str) {
        return c(new StringBuilder().append(str).append("_SUCCESS").toString()).exists() && c(str).exists();
    }

    public final File c(String str) {
        return new File(this.f1519a, str);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final com.five_corp.ad.internal.util.f d(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (!b(str)) {
                    a(str);
                    return new com.five_corp.ad.internal.util.f(false, new o(p.w, null, null, null), null);
                }
                fileInputStream = new FileInputStream(c(str));
                try {
                    byte[] bArr = new byte[(int) fileInputStream.getChannel().size()];
                    fileInputStream.read(bArr);
                    com.five_corp.ad.internal.util.f fVar = new com.five_corp.ad.internal.util.f(true, null, bArr);
                    try {
                        fileInputStream.close();
                        return fVar;
                    } catch (IOException e) {
                        Log.getStackTraceString(e);
                        return new com.five_corp.ad.internal.util.f(false, new o(p.w, null, e, null), null);
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.getStackTraceString(e);
                    com.five_corp.ad.internal.util.f fVar2 = new com.five_corp.ad.internal.util.f(false, new o(p.w, null, e, null), null);
                    if (fileInputStream == null) {
                        return fVar2;
                    }
                    try {
                        fileInputStream.close();
                        return fVar2;
                    } catch (IOException e3) {
                        Log.getStackTraceString(e3);
                        return new com.five_corp.ad.internal.util.f(false, new o(p.w, null, e3, null), null);
                    }
                }
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        Log.getStackTraceString(e5);
                        return new com.five_corp.ad.internal.util.f(false, new o(p.w, null, e5, null), null);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static String a(long j) {
        return "adcfg-" + Long.toString(j) + ".json";
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final com.five_corp.ad.internal.util.g a(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File fileC = c(str);
                fileOutputStreamFileOutputStreamCtor = LINEFilesBridge.fileOutputStreamCtor(fileC);
                try {
                    fileOutputStreamFileOutputStreamCtor.write(bArr);
                    if (!fileC.setReadable(true, false)) {
                        com.five_corp.ad.internal.util.g gVarA = com.five_corp.ad.internal.util.g.a(p.w);
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                            return gVarA;
                        } catch (IOException e) {
                            Log.getStackTraceString(e);
                            return new com.five_corp.ad.internal.util.g(false, new o(p.w, null, e, null));
                        }
                    }
                    fileOutputStreamFileOutputStreamCtor.flush();
                    fileOutputStreamFileOutputStreamCtor.getFD().sync();
                    try {
                        fileOutputStreamFileOutputStreamCtor.close();
                        return new com.five_corp.ad.internal.util.g(true, null);
                    } catch (IOException e2) {
                        Log.getStackTraceString(e2);
                        return new com.five_corp.ad.internal.util.g(false, new o(p.w, null, e2, null));
                    }
                } catch (IOException e3) {
                    e = e3;
                    Log.getStackTraceString(e);
                    com.five_corp.ad.internal.util.g gVar = new com.five_corp.ad.internal.util.g(false, new o(p.w, null, e, null));
                    if (fileOutputStreamFileOutputStreamCtor == null) {
                        return gVar;
                    }
                    try {
                        fileOutputStreamFileOutputStreamCtor.close();
                        return gVar;
                    } catch (IOException e4) {
                        Log.getStackTraceString(e4);
                        return new com.five_corp.ad.internal.util.g(false, new o(p.w, null, e4, null));
                    }
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStreamFileOutputStreamCtor = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        Log.getStackTraceString(e6);
                        return new com.five_corp.ad.internal.util.g(false, new o(p.w, null, e6, null));
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
