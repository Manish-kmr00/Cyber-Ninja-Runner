package com.bytedance.sdk.openadsdk.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.aBv;
import com.json.b9;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class KZx {
    private static final AtomicBoolean Og = new AtomicBoolean(false);
    private static boolean pA = true;

    public static void pA(Context context) {
        if (context != null && pA && Og.compareAndSet(false, true)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (aBv.pA(context)) {
                        Og(context);
                        return;
                    }
                    String strOg = aBv.Og(context);
                    try {
                        if (TextUtils.isEmpty(strOg)) {
                            strOg = context.getPackageName() + Process.myPid();
                        }
                        WebView.setDataDirectorySuffix(strOg);
                    } catch (IllegalStateException unused) {
                        pA(strOg);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                WV.Og(th.getMessage());
            }
        }
    }

    public static void pA() {
        pA = false;
    }

    private static void pA(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.RandomAccessFile] */
    private static void Og(Context context) throws Throwable {
        ?? r1;
        FileChannel channel;
        Throwable th;
        ?? r2;
        String strOg = Og();
        ?? randomAccessFile = "webview_data.lock";
        File file = new File(context.getDir(TextUtils.isEmpty(strOg) ? b9.h.K : "webview_".concat(String.valueOf(strOg)), 0).getPath(), "webview_data.lock");
        file.getAbsolutePath();
        if (!file.exists()) {
            return;
        }
        FileChannel fileChannel = null;
        FileLock fileLockTryLock = null;
        fileChannel = null;
        fileChannel = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    channel = randomAccessFile.getChannel();
                    if (channel != null) {
                        try {
                            fileLockTryLock = channel.tryLock();
                        } catch (Exception unused) {
                            fileChannel = channel;
                            pA(file);
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Throwable th2) {
                                    th2.getMessage();
                                }
                            }
                            if (randomAccessFile != 0) {
                                try {
                                    randomAccessFile.close();
                                    return;
                                } catch (Throwable th3) {
                                    th3.getMessage();
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            r2 = randomAccessFile;
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th5) {
                                    th5.getMessage();
                                }
                            }
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                    throw th;
                                } catch (Throwable th6) {
                                    th6.getMessage();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    if (fileLockTryLock != null) {
                        fileLockTryLock.close();
                    } else {
                        pA(file);
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th7) {
                            th7.getMessage();
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th8) {
                        th8.getMessage();
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                randomAccessFile = 0;
            } catch (Throwable th9) {
                th = th9;
                r1 = 0;
                channel = null;
                th = th;
                r2 = r1;
                if (channel != null) {
                    channel.close();
                }
                if (r2 != 0) {
                    r2.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            channel = fileChannel;
            r1 = randomAccessFile;
            th = th;
            r2 = r1;
            if (channel != null) {
                channel.close();
            }
            if (r2 != 0) {
                r2.close();
                throw th;
            }
            throw th;
        }
    }

    private static void pA(File file) {
        pA(file, file.exists() ? file.delete() : false);
    }

    private static void pA(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            WV.pA("TTAD.TTMultiInitHelper", e.getMessage());
        }
    }

    private static String Og() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
