package com.bytedance.sdk.component.ML.KZx.pA.pA;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class Og implements com.bytedance.sdk.component.ML.KZx {
    private pA Og;
    private long pA;

    public Og(File file, long j, ExecutorService executorService) {
        this.pA = j;
        try {
            this.Og = pA.pA(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.ML.KZx
    public InputStream pA(String str) {
        pA pAVar = this.Og;
        if (pAVar == null) {
            return null;
        }
        try {
            pA.KZx kZxPA = pAVar.pA(str);
            if (kZxPA != null) {
                return kZxPA.pA(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ML.pA
    public boolean pA(String str, byte[] bArr) throws Throwable {
        pA pAVar = this.Og;
        if (pAVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable = null;
        pA.C0190pA c0190pA = null;
        try {
            try {
                pA.C0190pA c0190pAOg = pAVar.Og(str);
                try {
                    if (c0190pAOg == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(null);
                        return false;
                    }
                    OutputStream outputStreamPA = c0190pAOg.pA(0);
                    if (outputStreamPA == pA.KZx) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(outputStreamPA);
                        return false;
                    }
                    outputStreamPA.write(bArr);
                    c0190pAOg.pA();
                    this.Og.pA();
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(outputStreamPA);
                    return true;
                } catch (IOException e) {
                    e = e;
                    c0190pA = c0190pAOg;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (c0190pA != null) {
                            try {
                                c0190pA.Og();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(0);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable = closeable;
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(closeable);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    @Override // com.bytedance.sdk.component.ML.pA
    /* JADX INFO: renamed from: Og, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] pA(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStreamPA;
        pA pAVar = this.Og;
        InputStream inputStream = null;
        if (pAVar == null || str == null) {
            return null;
        }
        try {
            pA.KZx kZxPA = pAVar.pA(str);
            if (kZxPA == null) {
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(null);
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(null);
                return null;
            }
            inputStreamPA = kZxPA.pA(0);
            if (inputStreamPA != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStreamPA.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamPA;
                            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
                            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (IOException e) {
                        e = e;
                        Log.w("LruCountDiskCache", e.toString());
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamPA);
                        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
                        return null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamPA);
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    inputStream = inputStreamPA;
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
                    com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamPA);
            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamPA = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStream);
            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
            throw th;
        }
        Log.w("LruCountDiskCache", e.toString());
        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(inputStreamPA);
        com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(byteArrayOutputStream);
        return null;
    }

    @Override // com.bytedance.sdk.component.ML.pA
    /* JADX INFO: renamed from: KZx, reason: merged with bridge method [inline-methods] */
    public boolean Og(String str) {
        try {
            try {
                pA.KZx kZxPA = this.Og.pA(str);
                boolean z = kZxPA != null;
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(kZxPA);
                return z;
            } catch (IOException e) {
                Log.w("LruCountDiskCache", e.getMessage());
                com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(null);
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ML.KZx.KZx.Og.pA(null);
            throw th;
        }
    }
}
