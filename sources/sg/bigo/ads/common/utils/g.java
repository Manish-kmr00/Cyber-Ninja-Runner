package sg.bigo.ads.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes10.dex */
public final class g {
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    public static String a(InputStream inputStream) throws Throwable {
        String string = "";
        if (inputStream == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                }
                string = byteArrayOutputStream2.toString();
                a((Closeable) inputStream);
                a(byteArrayOutputStream2);
            } catch (IOException unused) {
                byteArrayOutputStream = byteArrayOutputStream2;
                a((Closeable) inputStream);
                if (byteArrayOutputStream != null) {
                    a(byteArrayOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                a((Closeable) inputStream);
                if (byteArrayOutputStream != null) {
                    a(byteArrayOutputStream);
                }
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return string;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] b(File file) throws Throwable {
        FileInputStream fileInputStream;
        File fileA = a(file);
        if (fileA.exists()) {
            file.delete();
            fileA.renameTo(file);
        }
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            int length = (int) file.length();
            if (length != 0) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[length];
                        if (fileInputStream.read(bArr) == length) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                                sg.bigo.ads.common.t.a.b("IOUtils", "close file " + file.getPath() + " failed");
                            }
                            return bArr;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                                sg.bigo.ads.common.t.a.b("IOUtils", "close file " + file.getPath() + " failed");
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                    sg.bigo.ads.common.t.a.a(0, "IOUtils", "read file " + file.getPath() + " failed");
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                            sg.bigo.ads.common.t.a.b("IOUtils", "close file " + file.getPath() + " failed");
                        }
                    }
                    return null;
                }
            } else {
                fileInputStream = null;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "IOUtils", "readFileLocked length=" + length + ", fileName=" + file.getName());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i = fileInputStream3.read(bArr2);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sg.bigo.ads.common.t.a.a(0, 3, "IOUtils", "readFileLocked data=" + byteArray.length + ", fileName=" + file.getName());
                if (byteArray.length == 0) {
                    sg.bigo.ads.common.t.a.a(0, "IOUtils", "read " + file.getName() + " failed, data's length is 0.");
                    throw new Exception("read " + file.getName() + " failed, data's length is 0.");
                }
                try {
                    fileInputStream3.close();
                } catch (IOException unused5) {
                    sg.bigo.ads.common.t.a.b("IOUtils", "close file " + file.getPath() + " failed");
                }
                return byteArray;
            } catch (Exception unused6) {
                fileInputStream = fileInputStream3;
                sg.bigo.ads.common.t.a.a(0, "IOUtils", "read file " + file.getPath() + " failed");
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream3;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        } catch (Exception unused7) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
