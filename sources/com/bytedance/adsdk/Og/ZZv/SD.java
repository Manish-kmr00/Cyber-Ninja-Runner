package com.bytedance.adsdk.Og.ZZv;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes10.dex */
public class SD {
    private final ML pA;

    public SD(ML ml) {
        this.pA = ml;
    }

    Pair<KZx, InputStream> pA(String str) {
        KZx kZx;
        try {
            File fileOg = Og(str);
            if (fileOg == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileOg);
            if (fileOg.getAbsolutePath().endsWith(".zip")) {
                kZx = KZx.ZIP;
            } else {
                kZx = KZx.JSON;
            }
            fileOg.getAbsolutePath();
            return new Pair<>(kZx, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File pA(String str, InputStream inputStream, KZx kZx) throws IOException {
        File file = new File(pA(), pA(str, kZx, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }

    void pA(String str, KZx kZx) {
        File file = new File(pA(), pA(str, kZx, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        new StringBuilder("Copying temp file to real file (").append(file2);
        if (zRenameTo) {
            return;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
    }

    private File Og(String str) throws FileNotFoundException {
        File file = new File(pA(), pA(str, KZx.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(pA(), pA(str, KZx.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File pA() {
        File filePA = this.pA.pA();
        if (filePA.isFile()) {
            filePA.delete();
        }
        if (!filePA.exists()) {
            filePA.mkdirs();
        }
        return filePA;
    }

    private static String pA(String str, KZx kZx, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? kZx.pA() : kZx.KZx);
    }
}
