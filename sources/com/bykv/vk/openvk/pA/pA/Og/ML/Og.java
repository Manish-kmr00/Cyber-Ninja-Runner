package com.bykv.vk.openvk.pA.pA.Og.ML;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes7.dex */
public class Og {
    public static long pA(String str, String str2) {
        File fileKZx = KZx(str, str2);
        if (fileKZx.exists()) {
            return fileKZx.length();
        }
        File fileOg = Og(str, str2);
        if (fileOg.exists()) {
            return fileOg.length();
        }
        return 0L;
    }

    public static File Og(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File KZx(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static void pA(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2, String str) throws IOException {
        try {
            randomAccessFile.seek(i);
            randomAccessFile.write(bArr, 0, i2);
        } catch (Throwable unused) {
        }
    }
}
