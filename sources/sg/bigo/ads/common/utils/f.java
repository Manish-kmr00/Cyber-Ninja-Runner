package sg.bigo.ads.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public final class f {
    public static long a(long j, int i) {
        char c;
        if (i == 2) {
            c = '\n';
        } else if (i == 3) {
            c = 20;
        } else {
            if (i != 4) {
                return j;
            }
            c = 30;
        }
        return j >> c;
    }

    public static long a(String str, int i) {
        File file = new File(str);
        if (file.exists()) {
            return a(file.length(), i);
        }
        return 0L;
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return file.delete();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Exception e;
        File file = new File(str);
        boolean z = false;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    fileInputStream.read(bArr);
                    String str2 = new String(bArr);
                    if (str2.contains("ftyp") && str2.contains("moov")) {
                        sg.bigo.ads.common.t.a.a(0, 3, "FileUtils", "contains ftyp moov");
                        z = true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    sg.bigo.ads.common.t.a.a(0, "FileUtils", "read file " + file.getPath() + " failed" + e.getMessage());
                    if (fileInputStream != null) {
                    }
                    return z;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                e = e3;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str, str2);
        boolean z = false;
        try {
            boolean zMkdirs = !file.exists() ? file.mkdirs() : true;
            if (file2.exists()) {
                return zMkdirs;
            }
            if (zMkdirs && file2.createNewFile()) {
                z = true;
            }
            return z;
        } catch (IOException unused) {
            return false;
        }
    }

    public static void b(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        b(file2);
                    } else {
                        a(file2);
                    }
                }
            }
        }
        a(file);
    }

    public static boolean b(String str) {
        if (q.a((CharSequence) str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String c(String str) {
        return str + ".tmp";
    }

    public static void c(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
    }

    public static boolean c(File file) {
        boolean z = false;
        try {
            File parentFile = file.getParentFile();
            boolean zMkdirs = !parentFile.exists() ? parentFile.mkdirs() : true;
            if (file.exists()) {
                return zMkdirs;
            }
            if (zMkdirs && file.createNewFile()) {
                z = true;
            }
            return z;
        } catch (IOException unused) {
            return false;
        }
    }

    public static String d(String str) {
        return str + ".tmp";
    }
}
