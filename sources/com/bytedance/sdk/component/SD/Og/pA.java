package com.bytedance.sdk.component.SD.Og;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.JG;
import com.bytedance.sdk.component.Og.pA.Wx;
import com.google.common.net.HttpHeaders;
import com.inmobi.unification.sdk.InitializationStatus;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes11.dex */
public class pA extends KZx {
    public File Og;
    private volatile boolean SGo;
    public File pA;

    public pA(BSW bsw) {
        super(bsw);
    }

    public void pA(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.pA = new File(str, str2);
        this.Og = new File(str, str2 + ".temp");
    }

    public void pA(final com.bytedance.sdk.component.SD.pA.pA pAVar) {
        File file = this.pA;
        if (file == null || this.Og == null) {
            if (pAVar != null) {
                pAVar.pA(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.pA.length() != 0 && pAVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.SD.Og og = new com.bytedance.sdk.component.SD.Og(true, 200, InitializationStatus.SUCCESS, null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            og.pA(this.pA);
            pAVar.pA(this, og);
            return;
        }
        long length = this.Og.length();
        final long j = length >= 0 ? length : 0L;
        Wx.pA pAVar2 = new Wx.pA();
        pAVar2.pA((Object) KZx());
        Og("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.omh)) {
            pAVar.pA(this, new IOException("Url is Empty"));
            return;
        }
        try {
            pAVar2.Og(this.omh);
            if (!TextUtils.isEmpty(this.ML)) {
                pAVar2.pA(this.ML);
            }
            if (this.JG > 0) {
                pAVar2.pA(this.JG);
            }
            pA(pAVar2);
            com.bytedance.sdk.component.Og.pA.Og ogPA = this.KZx.pA(pAVar2.pA().Og());
            if (ogPA == null) {
                pAVar.pA(this, new IOException("new call error"));
            } else {
                ogPA.pA(new com.bytedance.sdk.component.Og.pA.KZx() { // from class: com.bytedance.sdk.component.SD.Og.pA.1
                    @Override // com.bytedance.sdk.component.Og.pA.KZx
                    public void pA(com.bytedance.sdk.component.Og.pA.Og og2, IOException iOException) {
                        com.bytedance.sdk.component.SD.pA.pA pAVar3 = pAVar;
                        if (pAVar3 != null) {
                            pAVar3.pA(pA.this, iOException);
                        }
                        pA.this.ZZv();
                    }

                    @Override // com.bytedance.sdk.component.Og.pA.KZx
                    public void pA(com.bytedance.sdk.component.Og.pA.Og og2, DX dx) throws IOException {
                        RandomAccessFile randomAccessFile;
                        long j2;
                        boolean z;
                        if (pAVar == null) {
                            return;
                        }
                        HashMap map = new HashMap();
                        if (dx == null) {
                            return;
                        }
                        JG jgSD = dx.SD();
                        if (jgSD != null) {
                            for (int i = 0; i < jgSD.pA(); i++) {
                                map.put(jgSD.pA(i), jgSD.Og(i));
                            }
                        }
                        com.bytedance.sdk.component.SD.Og og3 = new com.bytedance.sdk.component.SD.Og(dx.ZZv(), dx.KZx(), dx.ML(), map, null, dx.Og(), dx.pA());
                        if (dx.ZZv()) {
                            long jPA = dx.JG().pA();
                            if (jPA <= 0) {
                                jPA = pA.JG(map);
                            }
                            boolean zML = pA.ML(map);
                            int i2 = -1;
                            if (zML) {
                                jPA += j;
                                String str = (String) map.get(HttpHeaders.CONTENT_RANGE);
                                if (!TextUtils.isEmpty(str)) {
                                    String str2 = "bytes " + j + "-" + (jPA - 1);
                                    if (TextUtils.indexOf(str, str2) == -1) {
                                        pA.this.ZZv();
                                        pAVar.pA(pA.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + pA.this.Og + "]."));
                                        return;
                                    }
                                }
                            }
                            if (jPA > 0 && pA.this.Og.exists() && pA.this.Og.length() == jPA) {
                                if (!pA.this.Og.renameTo(pA.this.pA)) {
                                    pAVar.pA(pA.this, new IOException("Rename fail"));
                                    return;
                                } else {
                                    og3.pA(pA.this.pA);
                                    pAVar.pA(pA.this, og3);
                                    return;
                                }
                            }
                            InputStream inputStreamKZx = null;
                            try {
                                randomAccessFile = new RandomAccessFile(pA.this.Og, "rw");
                                try {
                                    if (zML) {
                                        randomAccessFile.seek(j);
                                        j2 = j;
                                    } else {
                                        randomAccessFile.setLength(0L);
                                        j2 = 0;
                                    }
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable unused2) {
                                randomAccessFile = null;
                            }
                            try {
                                inputStreamKZx = dx.JG().KZx();
                                if (pA.SD(map) && !(inputStreamKZx instanceof GZIPInputStream)) {
                                    inputStreamKZx = new GZIPInputStream(inputStreamKZx);
                                }
                                try {
                                    byte[] bArr = new byte[16384];
                                    long j3 = 0;
                                    int i3 = 0;
                                    while (true) {
                                        int i4 = inputStreamKZx.read(bArr, i3, 16384 - i3);
                                        if (i4 != i2) {
                                            i3 += i4;
                                            InputStream inputStream = inputStreamKZx;
                                            j3 += (long) i4;
                                            try {
                                                if (j3 % 16384 == 0 || j3 == jPA - j) {
                                                    randomAccessFile.seek(j2);
                                                    randomAccessFile.write(bArr, 0, i3);
                                                    j2 += (long) i3;
                                                    i3 = 0;
                                                }
                                                if (pA.this.SGo) {
                                                    throw new IOException("net is cancel");
                                                }
                                                inputStreamKZx = inputStream;
                                                i2 = -1;
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStreamKZx = inputStream;
                                                try {
                                                    pAVar.pA(pA.this, new IOException(th.getMessage()));
                                                    if (!zML) {
                                                        pA.this.ZZv();
                                                    }
                                                    try {
                                                        return;
                                                    } catch (Throwable unused3) {
                                                        return;
                                                    }
                                                } finally {
                                                    if (inputStreamKZx != null) {
                                                        try {
                                                            inputStreamKZx.close();
                                                        } catch (Throwable unused4) {
                                                        }
                                                    }
                                                    try {
                                                        randomAccessFile.close();
                                                    } catch (Throwable unused5) {
                                                    }
                                                }
                                            }
                                        } else {
                                            InputStream inputStream2 = inputStreamKZx;
                                            if (i3 != 0) {
                                                randomAccessFile.seek(j2);
                                                z = false;
                                                randomAccessFile.write(bArr, 0, i3);
                                            } else {
                                                z = false;
                                            }
                                            if (!zML) {
                                                jPA = pA.this.Og.length();
                                            }
                                            if (jPA > 0 && pA.this.Og.exists() && pA.this.Og.length() == jPA) {
                                                if (!pA.this.Og.renameTo(pA.this.pA)) {
                                                    pAVar.pA(pA.this, new IOException("Rename fail"));
                                                } else {
                                                    og3.pA(pA.this.pA);
                                                    pAVar.pA(pA.this, og3);
                                                }
                                            } else {
                                                pAVar.pA(pA.this, new IOException(" tempFile.length() == fileSize is" + (pA.this.Og.length() == jPA ? true : z)));
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (Throwable unused6) {
                                                }
                                            }
                                            try {
                                                randomAccessFile.close();
                                                return;
                                            } catch (Throwable unused7) {
                                                return;
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } else {
                            pAVar.pA(pA.this, og3);
                        }
                    }
                });
            }
        } catch (IllegalArgumentException unused) {
            pAVar.pA(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public com.bytedance.sdk.component.SD.Og pA() {
        DX dxOg;
        RandomAccessFile randomAccessFile;
        long j;
        InputStream inputStream;
        File file = this.pA;
        if (file != null && this.Og != null) {
            long j2 = 0;
            if (file.exists() && this.pA.length() != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.component.SD.Og og = new com.bytedance.sdk.component.SD.Og(true, 200, InitializationStatus.SUCCESS, null, null, jCurrentTimeMillis, jCurrentTimeMillis);
                og.pA(this.pA);
                return og;
            }
            long length = this.Og.length();
            if (length < 0) {
                length = 0;
            }
            Wx.pA pAVar = new Wx.pA();
            pAVar.pA((Object) KZx());
            Og("Range", "bytes=" + length + "-");
            if (TextUtils.isEmpty(this.omh)) {
                Log.e("DownloadExecutor", "execute: Url is Empty");
                return null;
            }
            try {
                pAVar.Og(this.omh);
                pA(pAVar);
                try {
                    com.bytedance.sdk.component.Og.pA.Og ogPA = this.KZx.pA(pAVar.pA().Og());
                    if (ogPA == null || (dxOg = ogPA.Og()) == null || !dxOg.ZZv()) {
                        return null;
                    }
                    HashMap map = new HashMap();
                    JG jgSD = dxOg.SD();
                    if (jgSD != null) {
                        for (int i = 0; i < jgSD.pA(); i++) {
                            map.put(jgSD.pA(i), jgSD.Og(i));
                        }
                    }
                    com.bytedance.sdk.component.SD.Og og2 = new com.bytedance.sdk.component.SD.Og(dxOg.ZZv(), dxOg.KZx(), dxOg.ML(), map, null, dxOg.Og(), dxOg.pA());
                    long jPA = dxOg.JG().pA();
                    if (jPA <= 0) {
                        jPA = JG(map);
                    }
                    long length2 = this.Og.length();
                    boolean zML = ML(map);
                    int i2 = -1;
                    if (zML) {
                        jPA += length2;
                        String str = (String) map.get(HttpHeaders.CONTENT_RANGE);
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = "bytes " + length2 + "-" + (jPA - 1);
                            if (TextUtils.indexOf(str, str2) == -1) {
                                new StringBuilder("execute: The Content-Range Header is invalid Assume[").append(str2).append("] vs Real[").append(str).append("], please remove the temporary file [").append(this.Og);
                                ZZv();
                                return null;
                            }
                        }
                        j2 = 0;
                    }
                    if (jPA > j2 && this.Og.exists() && this.Og.length() == jPA) {
                        if (!this.Og.renameTo(this.pA)) {
                            return null;
                        }
                        og2.pA(this.pA);
                        return og2;
                    }
                    com.bytedance.sdk.component.SD.Og og3 = og2;
                    try {
                        randomAccessFile = new RandomAccessFile(this.Og, "rw");
                        try {
                            if (zML) {
                                randomAccessFile.seek(length);
                                j = length;
                            } else {
                                randomAccessFile.setLength(0L);
                                j = 0;
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        randomAccessFile = null;
                    }
                    try {
                        InputStream inputStreamKZx = dxOg.JG().KZx();
                        try {
                            if (SD(map) && !(inputStreamKZx instanceof GZIPInputStream)) {
                                inputStreamKZx = new GZIPInputStream(inputStreamKZx);
                            }
                            byte[] bArr = new byte[16384];
                            int i3 = 0;
                            long j3 = 0;
                            while (true) {
                                int i4 = inputStreamKZx.read(bArr, i3, 16384 - i3);
                                if (i4 == i2) {
                                    com.bytedance.sdk.component.SD.Og og4 = og3;
                                    if (i4 != 0) {
                                        randomAccessFile.seek(j);
                                        randomAccessFile.write(bArr, 0, i3);
                                    }
                                    if (!zML || length == 0) {
                                        jPA = this.Og.length();
                                    }
                                    if (jPA <= 0 || !this.Og.exists() || this.Og.length() != jPA) {
                                        this.Og.length();
                                        if (inputStreamKZx != null) {
                                            try {
                                                inputStreamKZx.close();
                                            } catch (Throwable unused3) {
                                            }
                                        }
                                        try {
                                            randomAccessFile.close();
                                            return null;
                                        } catch (Throwable unused4) {
                                            return null;
                                        }
                                    }
                                    if (this.Og.renameTo(this.pA)) {
                                        og4.pA(this.pA);
                                        if (inputStreamKZx != null) {
                                            try {
                                                inputStreamKZx.close();
                                            } catch (Throwable unused5) {
                                            }
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable unused6) {
                                        }
                                        return og4;
                                    }
                                    if (inputStreamKZx != null) {
                                        try {
                                            inputStreamKZx.close();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    try {
                                        randomAccessFile.close();
                                        return null;
                                    } catch (Throwable unused8) {
                                        return null;
                                    }
                                }
                                i3 += i4;
                                com.bytedance.sdk.component.SD.Og og5 = og3;
                                j3 += (long) i4;
                                if (j3 % 16384 == 0 || j3 == jPA - length) {
                                    randomAccessFile.seek(j);
                                    randomAccessFile.write(bArr, 0, i3);
                                    j += (long) i3;
                                    i3 = 0;
                                }
                                if (this.SGo) {
                                    throw new IOException("net is cancel");
                                }
                                og3 = og5;
                                i2 = -1;
                            }
                        } catch (Throwable unused9) {
                            inputStream = inputStreamKZx;
                            if (!zML) {
                                try {
                                    ZZv();
                                } finally {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused10) {
                                        }
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                            }
                            try {
                                return null;
                            } catch (Throwable unused12) {
                                return null;
                            }
                        }
                    } catch (Throwable unused13) {
                        inputStream = null;
                    }
                } catch (IOException unused14) {
                    ZZv();
                    return null;
                }
            } catch (IllegalArgumentException unused15) {
                Log.e("DownloadExecutor", "execute: Url is not a valid HTTP or HTTPS URL");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ML(Map<String, String> map) {
        if (TextUtils.equals(map.get(HttpHeaders.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long JG(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean SD(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZZv() {
        try {
            this.pA.delete();
        } catch (Throwable unused) {
        }
        try {
            this.Og.delete();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.SD.Og.KZx
    public void Og() {
        this.SGo = true;
        super.Og();
    }
}
