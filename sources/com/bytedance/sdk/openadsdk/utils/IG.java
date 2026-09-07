package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.safedk.android.internal.partials.PangleFilesBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class IG implements Thread.UncaughtExceptionHandler {
    public static volatile boolean pA;
    private String KZx;
    private final Thread.UncaughtExceptionHandler Og = Thread.getDefaultUncaughtExceptionHandler();

    public static IG pA() {
        return new IG();
    }

    private IG() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        Og();
    }

    private void Og() {
        Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
        if (contextPA == null) {
            return;
        }
        try {
            File file = new File(contextPA.getFilesDir(), "TTCache");
            file.mkdirs();
            this.KZx = file.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        pA = true;
        boolean zContains = false;
        com.bytedance.sdk.component.omh.JG.pA(false);
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null) {
                zContains = string.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (zContains) {
            pA(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.Og;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x010d A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0108 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void pA(Thread thread, Throwable th) {
        FileOutputStream fileOutputStreamFileOutputStreamCtor;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.KZx)) {
                Og();
            }
            if (TextUtils.isEmpty(this.KZx)) {
                return;
            }
            File file = new File(this.KZx, "tt_crash_count.properties");
            if (file.exists() && file.isFile() && file.canRead()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream3);
                    String property = properties.getProperty("crash_count", "0");
                    String property2 = properties.getProperty("crash_last_time", "0");
                    int iIntValue = Integer.valueOf(property).intValue();
                    int i2 = 0;
                    boolean z2 = true;
                    if (System.currentTimeMillis() - Long.valueOf(property2).longValue() < 300000) {
                        i = iIntValue + 1;
                        z = false;
                    } else {
                        z = true;
                        i = 1;
                    }
                    if (i < 3) {
                        z2 = false;
                    }
                    if (!z2) {
                        i2 = i;
                    }
                    com.bytedance.sdk.component.utils.WV.pA("TTCrashHandler", "==" + i2 + ", " + z2 + ", " + z);
                    if (z2) {
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                    } else {
                        properties.setProperty("crash_count", String.valueOf(i2));
                        if (z) {
                            properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                        }
                        fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(file);
                        try {
                            properties.store(fileOutputStreamFileOutputStreamCtor, "tt_crash_info");
                            fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream3;
                            com.bytedance.sdk.component.utils.WV.pA("TTCrashHandler", "crash count error", th);
                        }
                    }
                    if (z2) {
                        KZx();
                    }
                    fileOutputStreamFileOutputStreamCtor = fileOutputStream;
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        fileOutputStreamFileOutputStreamCtor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStreamFileOutputStreamCtor = fileOutputStream;
                }
            } else {
                Properties properties2 = new Properties();
                properties2.setProperty("crash_count", "1");
                properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(file);
                try {
                    properties2.store(fileOutputStreamFileOutputStreamCtor, "tt_crash_info");
                    com.bytedance.sdk.component.utils.WV.pA("TTCrashHandler", "==first");
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileOutputStreamFileOutputStreamCtor != null) {
                        try {
                            fileOutputStreamFileOutputStreamCtor.close();
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        com.bytedance.sdk.component.utils.WV.pA("TTCrashHandler", "crash count error", th);
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileOutputStreamFileOutputStreamCtor != null) {
                            try {
                                fileOutputStreamFileOutputStreamCtor.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStreamFileOutputStreamCtor = null;
        }
    }

    private void KZx() {
        try {
            Method methodPA = com.bytedance.sdk.component.utils.WQf.pA("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (methodPA != null) {
                methodPA.invoke(null, com.bytedance.sdk.openadsdk.core.aBv.pA());
            }
        } catch (Throwable unused) {
        }
        try {
            Method methodPA2 = com.bytedance.sdk.component.utils.WQf.pA("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (methodPA2 != null) {
                methodPA2.invoke(null, com.bytedance.sdk.openadsdk.core.aBv.pA());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.pA.Og.Og.Og();
        } catch (Throwable unused4) {
        }
    }
}
