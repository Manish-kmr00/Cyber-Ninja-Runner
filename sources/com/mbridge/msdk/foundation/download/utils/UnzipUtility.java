package com.mbridge.msdk.foundation.download.utils;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.tools.o0;
import com.safedk.android.internal.partials.MintegralFilesBridge;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    private void extractFile(ZipInputStream zipInputStream, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(MintegralFilesBridge.fileOutputStreamCtor(file));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = zipInputStream.read(bArr);
                        if (i == -1) {
                            bufferedOutputStream.close();
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException e) {
                    e = e;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:144:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:? A[RETURN, SYNTHETIC] */
    public int unzip(String str, String str2) throws Throwable {
        Throwable th;
        InputStream inputStream;
        IOException iOException;
        InputStream inputStream2;
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        IOException e;
        Throwable th2;
        String canonicalPath;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str2 = str2 + RemoteSettings.FORWARD_SLASH_STRING;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        FileOutputStream fileOutputStream = null;
        InputStream inputStream3 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            FileOutputStream fileOutputStream3 = null;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement == null) {
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e2) {
                                    o0.b(TAG, e2.getMessage());
                                }
                            }
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException e3) {
                                    o0.b(TAG, e3.getMessage());
                                }
                            }
                            return 2;
                        }
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            File file2 = new File(str2 + name);
                            try {
                                canonicalPath = file2.getCanonicalPath();
                            } catch (IOException unused) {
                                canonicalPath = "";
                            }
                            if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(str2) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                                if (zipEntryNextElement.isDirectory()) {
                                    file2.mkdirs();
                                } else {
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    fileOutputStreamFileOutputStreamCtor = MintegralFilesBridge.fileOutputStreamCtor(file2);
                                    try {
                                        inputStream3 = zipFile.getInputStream(zipEntryNextElement);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = inputStream3.read(bArr, 0, 1024);
                                            if (i == -1) {
                                                break;
                                            }
                                            fileOutputStreamFileOutputStreamCtor.write(bArr, 0, i);
                                            fileOutputStreamFileOutputStreamCtor.flush();
                                        }
                                        fileOutputStream3 = fileOutputStreamFileOutputStreamCtor;
                                    } catch (IOException e4) {
                                        e = e4;
                                        try {
                                            o0.b(TAG, e.getMessage());
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (IOException e5) {
                                                    o0.b(TAG, e5.getMessage());
                                                }
                                            }
                                            if (fileOutputStreamFileOutputStreamCtor != null) {
                                                return 3;
                                            }
                                            try {
                                                fileOutputStreamFileOutputStreamCtor.close();
                                                return 3;
                                            } catch (IOException e6) {
                                                o0.b(TAG, e6.getMessage());
                                                return 3;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStream3;
                                            fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                                            fileOutputStreamFileOutputStreamCtor = fileOutputStream;
                                            inputStream3 = inputStream;
                                            th2 = th;
                                            if (inputStream3 != null) {
                                                try {
                                                    inputStream3.close();
                                                } catch (IOException e7) {
                                                    o0.b(TAG, e7.getMessage());
                                                }
                                            }
                                            if (fileOutputStreamFileOutputStreamCtor == null) {
                                                throw th2;
                                            }
                                            try {
                                                fileOutputStreamFileOutputStreamCtor.close();
                                                throw th2;
                                            } catch (IOException e8) {
                                                o0.b(TAG, e8.getMessage());
                                                throw th2;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        if (inputStream3 != null) {
                                            inputStream3.close();
                                        }
                                        if (fileOutputStreamFileOutputStreamCtor == null) {
                                            throw th2;
                                        }
                                        fileOutputStreamFileOutputStreamCtor.close();
                                        throw th2;
                                    }
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e9) {
                                    o0.b(TAG, e9.getMessage());
                                }
                            }
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException e10) {
                                    o0.b(TAG, e10.getMessage());
                                }
                            }
                            return 2;
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e11) {
                                o0.b(TAG, e11.getMessage());
                            }
                        }
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException e12) {
                                o0.b(TAG, e12.getMessage());
                            }
                        }
                        return 2;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream3;
                        fileOutputStream = fileOutputStream3;
                        fileOutputStreamFileOutputStreamCtor = fileOutputStream;
                        inputStream3 = inputStream;
                        th2 = th;
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (fileOutputStreamFileOutputStreamCtor == null) {
                            throw th2;
                        }
                        fileOutputStreamFileOutputStreamCtor.close();
                        throw th2;
                    }
                } catch (IOException e13) {
                    iOException = e13;
                    inputStream2 = inputStream3;
                    fileOutputStream2 = fileOutputStream3;
                    fileOutputStreamFileOutputStreamCtor = fileOutputStream2;
                    inputStream3 = inputStream2;
                    e = iOException;
                    o0.b(TAG, e.getMessage());
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        return 3;
                    }
                    fileOutputStreamFileOutputStreamCtor.close();
                    return 3;
                }
            }
            zipFile.close();
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException e14) {
                    o0.b(TAG, e14.getMessage());
                }
            }
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                } catch (IOException e15) {
                    o0.b(TAG, e15.getMessage());
                }
            }
            return 0;
        } catch (IOException e16) {
            iOException = e16;
            inputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }
}
