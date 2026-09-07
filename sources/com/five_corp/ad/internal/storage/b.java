package com.five_corp.ad.internal.storage;

import android.util.Log;
import com.safedk.android.internal.partials.LINEFilesBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1526a;
    public final com.five_corp.ad.internal.logger.a b;

    public b(File file, com.five_corp.ad.internal.logger.a aVar) {
        this.f1526a = new File(file, "com.five_corp");
        this.b = aVar;
    }

    public final com.five_corp.ad.internal.util.g a(String str) {
        com.five_corp.ad.internal.util.f fVarB = b(str);
        if (!fVarB.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, fVarB.b);
        }
        if (!((Boolean) fVarB.c).booleanValue()) {
            return new com.five_corp.ad.internal.util.g(true, null);
        }
        File file = new File(this.f1526a, str);
        try {
            return !file.delete() ? new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.S2, "File path: " + file.getAbsolutePath(), null, null)) : new com.five_corp.ad.internal.util.g(true, null);
        } catch (SecurityException e) {
            return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.T2, "File path: " + file.getAbsolutePath(), e, null));
        }
    }

    public final com.five_corp.ad.internal.util.f b(String str) {
        File file = new File(this.f1526a, str);
        try {
            return new com.five_corp.ad.internal.util.f(true, null, Boolean.valueOf(file.exists()));
        } catch (SecurityException e) {
            return new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.Q2, "File path: " + file.getAbsolutePath(), e, null), null);
        }
    }

    public final com.five_corp.ad.internal.util.f c(String str) {
        File file = new File(this.f1526a, str);
        try {
            return new com.five_corp.ad.internal.util.f(true, null, Integer.valueOf((int) file.length()));
        } catch (SecurityException e) {
            return new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.R2, "File path: " + file.getAbsolutePath(), e, null), null);
        }
    }

    public final com.five_corp.ad.internal.util.g d(String str) {
        com.five_corp.ad.internal.util.f fVarB = b(str);
        if (!fVarB.f1560a) {
            return new com.five_corp.ad.internal.util.g(false, fVarB.b);
        }
        File file = new File(this.f1526a, str);
        try {
            return !file.setReadable(true, false) ? new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.g3, "File path: " + file.getAbsolutePath(), null, null)) : new com.five_corp.ad.internal.util.g(true, null);
        } catch (SecurityException e) {
            return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.h3, "File path: " + file.getAbsolutePath(), e, null));
        }
    }

    public final com.five_corp.ad.internal.util.g b() {
        try {
            if (this.f1526a.exists()) {
                return new com.five_corp.ad.internal.util.g(true, null);
            }
            if (!this.f1526a.mkdirs()) {
                return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.b3, "Data directory path: " + this.f1526a.getAbsolutePath(), null, null));
            }
            if (!this.f1526a.setReadable(true, false)) {
                return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.c3, "Data directory path: " + this.f1526a.getAbsolutePath(), null, null));
            }
            if (!this.f1526a.setWritable(true, false)) {
                return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.d3, "Data directory path: " + this.f1526a.getAbsolutePath(), null, null));
            }
            if (!this.f1526a.setExecutable(true, false)) {
                return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.e3, "Data directory path: " + this.f1526a.getAbsolutePath(), null, null));
            }
            return new com.five_corp.ad.internal.util.g(true, null);
        } catch (SecurityException e) {
            return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.f3, "Data directory path: " + this.f1526a.getAbsolutePath(), e, null));
        }
    }

    public final com.five_corp.ad.internal.util.f a() {
        try {
            File[] fileArrListFiles = this.f1526a.listFiles();
            ArrayList arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                arrayList.add(file.getName());
            }
            return new com.five_corp.ad.internal.util.f(true, null, arrayList);
        } catch (SecurityException e) {
            return new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.P2, "Data directory path: " + this.f1526a.getAbsolutePath(), e, null), null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00ea: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:54:0x00ea */
    public final com.five_corp.ad.internal.util.g a(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        FileOutputStream fileOutputStream;
        File file = new File(this.f1526a, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File fileCreateTempFile = File.createTempFile("tmp", null, this.f1526a);
                fileOutputStreamFileOutputStreamCtor = LINEFilesBridge.fileOutputStreamCtor(fileCreateTempFile);
                try {
                    fileOutputStreamFileOutputStreamCtor.write(bArr);
                    fileOutputStreamFileOutputStreamCtor.flush();
                    fileOutputStreamFileOutputStreamCtor.getFD().sync();
                    if (!fileCreateTempFile.renameTo(file)) {
                        com.five_corp.ad.internal.util.g gVar = new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.k3, "File path: " + file.getAbsolutePath(), null, null));
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (IOException e) {
                            Log.getStackTraceString(e);
                        }
                        return gVar;
                    }
                    if (!file.setReadable(true, false)) {
                        com.five_corp.ad.internal.util.g gVar2 = new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.a3, "File path: " + file.getAbsolutePath(), null, null));
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (IOException e2) {
                            Log.getStackTraceString(e2);
                        }
                        return gVar2;
                    }
                    try {
                        fileOutputStreamFileOutputStreamCtor.close();
                    } catch (IOException e3) {
                        Log.getStackTraceString(e3);
                    }
                    return new com.five_corp.ad.internal.util.g(true, null);
                } catch (IOException e4) {
                    e = e4;
                    com.five_corp.ad.internal.util.g gVar3 = new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.Z2, "File path: " + file.getAbsolutePath(), e, null));
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (IOException e5) {
                            Log.getStackTraceString(e5);
                        }
                    }
                    return gVar3;
                } catch (SecurityException e6) {
                    e = e6;
                    com.five_corp.ad.internal.util.g gVar4 = new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.Y2, "File path: " + file.getAbsolutePath(), e, null));
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (IOException e7) {
                            Log.getStackTraceString(e7);
                        }
                    }
                    return gVar4;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (IOException e8) {
                            Log.getStackTraceString(e8);
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
                fileOutputStreamFileOutputStreamCtor = null;
            } catch (SecurityException e10) {
                e = e10;
                fileOutputStreamFileOutputStreamCtor = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStreamFileOutputStreamCtor = fileOutputStream2;
                if (fileOutputStreamFileOutputStreamCtor != null) {
                    fileOutputStreamFileOutputStreamCtor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            fileOutputStreamFileOutputStreamCtor = fileOutputStream2;
            if (fileOutputStreamFileOutputStreamCtor != null) {
                fileOutputStreamFileOutputStreamCtor.close();
            }
            throw th;
        }
    }
}
