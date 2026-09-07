package com.safedk.android.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes11.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8157a = "GzipUtil";

    public static String a(byte[] bArr) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        String string;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Cannot unzip null or empty bytes");
        }
        Logger.d(f8157a, "unzip started, input size is " + bArr.length);
        if (!b(bArr)) {
            Logger.d(f8157a, "unzip started, input is not compressed");
            return new String(bArr);
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    inputStreamReader = new InputStreamReader(gZIPInputStream, "UTF-8");
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            Logger.d(f8157a, "unzip started, output size is " + sb.length());
                            string = sb.toString();
                        } catch (IOException e) {
                            e = e;
                            Logger.d(f8157a, "Exception in unzip: " + e.getMessage());
                            string = null;
                        } catch (Throwable th) {
                            th = th;
                            Logger.d(f8157a, "Exception in unzip: " + th.getMessage());
                            string = null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = null;
                    inputStreamReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    inputStreamReader = null;
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                inputStreamReader = null;
                gZIPInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
                gZIPInputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            inputStreamReader = null;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            gZIPInputStream = null;
            byteArrayInputStream = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e6) {
                Logger.d(f8157a, "Exception in unzip finally block: " + e6.getMessage());
                return string;
            }
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (gZIPInputStream != null) {
            gZIPInputStream.close();
        }
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
            return string;
        }
        return string;
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArrC = c(bArr2);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < bArr.length) {
                i = i3;
                while (i > 0 && bArr2[i] != bArr[i2]) {
                    i = iArrC[i - 1];
                }
                if (bArr2[i] == bArr[i2]) {
                    i++;
                }
                if (i != bArr2.length) {
                    i2++;
                } else {
                    return (i2 - bArr2.length) + 1;
                }
            } else {
                return -1;
            }
        }
    }

    private static int[] c(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i = 0;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            while (i > 0 && bArr[i] != bArr[i2]) {
                i = iArr[i - 1];
            }
            if (bArr[i] == bArr[i2]) {
                i++;
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    public static boolean b(byte[] bArr) {
        return bArr[0] == 31 && bArr[1] == -117;
    }
}
