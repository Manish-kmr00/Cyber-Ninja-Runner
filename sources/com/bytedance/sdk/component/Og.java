package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.PangleFilesBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes8.dex */
public class Og {
    private static ArrayMap<String, File> BSW;
    private static ArrayMap<File, Og> WV;
    private static pA Wx;
    private static boolean pA;
    private final File Bzk;
    private int JG;
    private final Object KZx;
    private volatile boolean ML;
    private final Object Og;
    private long SD;
    private final File SGo;
    private Properties ZZv;
    private long omh;

    public interface pA {
        ExecutorService getExecutorService();
    }

    static /* synthetic */ int Bzk(Og og) {
        int i = og.JG;
        og.JG = i - 1;
        return i;
    }

    static /* synthetic */ long JG(Og og) {
        long j = og.SD;
        og.SD = 1 + j;
        return j;
    }

    static /* synthetic */ int ML(Og og) {
        int i = og.JG;
        og.JG = i + 1;
        return i;
    }

    public static void pA(pA pAVar) {
        Wx = pAVar;
    }

    public static Og pA(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (Og.class) {
            if (BSW == null) {
                BSW = new ArrayMap<>();
            }
            File file = BSW.get(str);
            if (file == null) {
                file = new File(context.getFilesDir(), str);
                BSW.put(str, file);
            }
            if (WV == null) {
                WV = new ArrayMap<>();
            }
            Og og = WV.get(file);
            if (og != null) {
                return og;
            }
            Og og2 = new Og(file);
            WV.put(file, og2);
            return og2;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.Og$1] */
    private Og(File file) {
        Object obj = new Object();
        this.Og = obj;
        this.KZx = new Object();
        this.ZZv = new Properties();
        this.ML = false;
        this.JG = 0;
        this.Bzk = file;
        this.SGo = pA(file);
        synchronized (obj) {
            this.ML = false;
        }
        pA pAVar = Wx;
        if (pAVar == null || pAVar.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.Og.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Og.this.pA();
                }
            }.start();
        } else {
            Wx.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.Og.2
                @Override // java.lang.Runnable
                public void run() {
                    Og.this.pA();
                }
            });
        }
    }

    static File pA(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00db A[Catch: all -> 0x00e7, TryCatch #3 {, blocks: (B:48:0x00d5, B:50:0x00db, B:51:0x00dd, B:52:0x00e5), top: B:67:0x00d5 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00dd A[Catch: all -> 0x00e7, TryCatch #3 {, blocks: (B:48:0x00d5, B:50:0x00db, B:51:0x00dd, B:52:0x00e5), top: B:67:0x00d5 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void pA() {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (this.Og) {
            if (this.ML) {
                if (pA) {
                    Log.d("TTPropHelper", "reload: already loaded, ignore");
                }
                return;
            }
            if (this.SGo.exists()) {
                this.Bzk.delete();
                this.SGo.renameTo(this.Bzk);
            }
            if (pA) {
                Log.d("TTPropHelper", "reload: " + this.Bzk.getAbsolutePath() + ", exist? " + this.Bzk.exists());
            }
            Properties properties = null;
            if (this.Bzk.exists()) {
                Properties properties2 = new Properties();
                try {
                    try {
                        fileInputStream = new FileInputStream(this.Bzk);
                        try {
                            properties2.load(fileInputStream);
                            if (pA) {
                                Log.d("TTPropHelper", "reload: find " + properties2.size() + " ,items from " + this.Bzk.getAbsolutePath());
                            }
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                Log.e("TTPropHelper", "reload: ", th);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                properties = properties2;
                                synchronized (this.Og) {
                                    if (properties != null) {
                                        if (!properties.isEmpty()) {
                                            this.ZZv = properties;
                                        }
                                        this.ML = true;
                                        this.Og.notifyAll();
                                    }
                                    this.ML = true;
                                    this.Og.notifyAll();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th4) {
                                        Log.w("TTPropHelper", th4.getMessage());
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        fileInputStream = null;
                        th = th5;
                    }
                } catch (Throwable th6) {
                    Log.w("TTPropHelper", th6.getMessage());
                }
                properties = properties2;
            }
            synchronized (this.Og) {
                if (properties != null) {
                    if (!properties.isEmpty()) {
                        this.ZZv = properties;
                    }
                    this.ML = true;
                    this.Og.notifyAll();
                } else {
                    this.ML = true;
                    this.Og.notifyAll();
                }
                throw th;
            }
        }
    }

    private void ZZv() {
        while (!this.ML) {
            try {
                this.Og.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public String pA(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.Og) {
            ZZv();
            property = this.ZZv.getProperty(str, str2);
        }
        return property;
    }

    public int pA(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        synchronized (this.Og) {
            try {
                try {
                    ZZv();
                    i2 = Integer.parseInt(this.ZZv.getProperty(str, String.valueOf(i)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public long pA(String str, long j) {
        long j2;
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        synchronized (this.Og) {
            try {
                try {
                    ZZv();
                    j2 = Long.parseLong(this.ZZv.getProperty(str, String.valueOf(j)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    public float pA(String str, float f) {
        float f2;
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        synchronized (this.Og) {
            try {
                try {
                    ZZv();
                    f2 = Float.parseFloat(this.ZZv.getProperty(str, String.valueOf(f)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return f;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f2;
    }

    public boolean pA(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        synchronized (this.Og) {
            try {
                try {
                    ZZv();
                    z2 = Boolean.parseBoolean(this.ZZv.getProperty(str, String.valueOf(z)));
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public boolean pA(String str) {
        boolean zContainsKey;
        synchronized (this.Og) {
            try {
                try {
                    ZZv();
                    zContainsKey = this.ZZv.containsKey(str);
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zContainsKey;
    }

    public KZx Og() {
        return new KZx();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Og$Og, reason: collision with other inner class name */
    private static class C0192Og {
        final CountDownLatch KZx;
        boolean ML;
        final Properties Og;
        volatile boolean ZZv;
        final long pA;

        private C0192Og(long j, Properties properties) {
            this.KZx = new CountDownLatch(1);
            this.ZZv = false;
            this.ML = false;
            this.pA = j;
            this.Og = properties;
        }

        void pA(boolean z, boolean z2) {
            this.ML = z;
            this.ZZv = z2;
            this.KZx.countDown();
        }
    }

    public class KZx implements SharedPreferences.Editor {
        private final Object Og = new Object();
        private final Map<String, Object> KZx = new HashMap();
        private boolean ZZv = false;

        public KZx() {
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return pA(str, (Set<String>) set);
        }

        public KZx pA(String str, Set<String> set) {
            synchronized (this.Og) {
                this.KZx.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx putInt(String str, int i) {
            synchronized (this.Og) {
                this.KZx.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx putLong(String str, long j) {
            synchronized (this.Og) {
                this.KZx.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx putFloat(String str, float f) {
            synchronized (this.Og) {
                this.KZx.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx putString(String str, String str2) {
            synchronized (this.Og) {
                this.KZx.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx putBoolean(String str, boolean z) {
            synchronized (this.Og) {
                this.KZx.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx remove(String str) {
            synchronized (this.Og) {
                this.KZx.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public KZx clear() {
            synchronized (this.Og) {
                this.ZZv = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long jCurrentTimeMillis = Og.pA ? System.currentTimeMillis() : 0L;
            C0192Og c0192OgOg = Og();
            Og.this.pA(c0192OgOg, true);
            try {
                c0192OgOg.KZx.await();
                return c0192OgOg.ZZv;
            } catch (InterruptedException unused) {
            } finally {
                if (Og.pA) {
                    Log.d("TTPropHelper", Og.this.Bzk.getName() + ":" + c0192OgOg.pA + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            Og.this.pA(Og(), false);
        }

        private C0192Og Og() {
            Properties properties;
            long j;
            Object obj;
            boolean z;
            synchronized (Og.this.Og) {
                if (Og.this.JG > 0) {
                    Properties properties2 = new Properties();
                    properties2.putAll(Og.this.ZZv);
                    Og.this.ZZv = properties2;
                }
                properties = Og.this.ZZv;
                Og.ML(Og.this);
                synchronized (this.Og) {
                    boolean z2 = false;
                    if (this.ZZv) {
                        if (properties.isEmpty()) {
                            z = false;
                        } else {
                            properties.clear();
                            z = true;
                        }
                        this.ZZv = false;
                        z2 = z;
                    }
                    for (Map.Entry<String, Object> entry : this.KZx.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value == this || value == null) {
                            if (properties.containsKey(key)) {
                                properties.remove(key);
                                z2 = true;
                            }
                        } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                            properties.put(key, String.valueOf(value));
                            z2 = true;
                        }
                    }
                    this.KZx.clear();
                    if (z2) {
                        Og.JG(Og.this);
                    }
                    j = Og.this.SD;
                }
            }
            return new C0192Og(j, properties);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final C0192Og c0192Og, final boolean z) {
        boolean z2;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.Og.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (Og.this.KZx) {
                    try {
                        Og.this.Og(c0192Og, z);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (Og.this.Og) {
                    Og.Bzk(Og.this);
                }
            }
        };
        if (z) {
            synchronized (this.Og) {
                z2 = this.JG == 1;
            }
            if (z2) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.KZx.pA(runnable, true ^ z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:117:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0128 A[Catch: all -> 0x01a4, TryCatch #4 {all -> 0x01a4, blocks: (B:39:0x0093, B:40:0x0095, B:76:0x0124, B:78:0x0128, B:80:0x012f, B:82:0x0138, B:84:0x0140, B:86:0x014c, B:96:0x01a2, B:97:0x01a3, B:75:0x0123, B:55:0x00ed, B:56:0x00f3, B:74:0x011c, B:94:0x01a0, B:93:0x0197, B:89:0x0191, B:70:0x0116, B:51:0x00e7), top: B:112:0x0093, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x012d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0138 A[Catch: all -> 0x01a4, TryCatch #4 {all -> 0x01a4, blocks: (B:39:0x0093, B:40:0x0095, B:76:0x0124, B:78:0x0128, B:80:0x012f, B:82:0x0138, B:84:0x0140, B:86:0x014c, B:96:0x01a2, B:97:0x01a3, B:75:0x0123, B:55:0x00ed, B:56:0x00f3, B:74:0x011c, B:94:0x01a0, B:93:0x0197, B:89:0x0191, B:70:0x0116, B:51:0x00e7), top: B:112:0x0093, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x013e  */
    /* JADX WARN: Code duplicated, block: B:86:0x014c A[Catch: all -> 0x01a4, TRY_LEAVE, TryCatch #4 {all -> 0x01a4, blocks: (B:39:0x0093, B:40:0x0095, B:76:0x0124, B:78:0x0128, B:80:0x012f, B:82:0x0138, B:84:0x0140, B:86:0x014c, B:96:0x01a2, B:97:0x01a3, B:75:0x0123, B:55:0x00ed, B:56:0x00f3, B:74:0x011c, B:94:0x01a0, B:93:0x0197, B:89:0x0191, B:70:0x0116, B:51:0x00e7), top: B:112:0x0093, inners: #0 }] */
    public void Og(C0192Og c0192Og, boolean z) {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        Throwable th;
        long jCurrentTimeMillis3;
        String str;
        String message;
        long jCurrentTimeMillis4;
        long jCurrentTimeMillis5;
        boolean z2;
        long jCurrentTimeMillis6 = pA ? System.currentTimeMillis() : 0L;
        boolean zExists = this.Bzk.exists();
        if (pA) {
            jCurrentTimeMillis = System.currentTimeMillis();
            jCurrentTimeMillis2 = jCurrentTimeMillis;
        } else {
            jCurrentTimeMillis = 0;
            jCurrentTimeMillis2 = 0;
        }
        if (zExists) {
            if (this.omh >= c0192Og.pA) {
                z2 = false;
            } else if (z) {
                z2 = true;
            } else {
                synchronized (this.Og) {
                    z2 = this.SD == c0192Og.pA;
                }
            }
            if (!z2) {
                c0192Og.pA(false, true);
                return;
            }
            boolean zExists2 = this.SGo.exists();
            if (pA) {
                jCurrentTimeMillis2 = System.currentTimeMillis();
            }
            if (!zExists2) {
                if (!this.Bzk.renameTo(this.SGo)) {
                    Log.e("TTPropHelper", "Couldn't rename file " + this.Bzk + " to backup file " + this.SGo);
                    c0192Og.pA(false, false);
                    return;
                }
            } else {
                this.Bzk.delete();
            }
        }
        try {
            synchronized (this.KZx) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        FileOutputStream fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(this.Bzk);
                        try {
                            try {
                                jCurrentTimeMillis3 = pA ? System.currentTimeMillis() : 0L;
                                try {
                                    c0192Og.Og.store(fileOutputStreamFileOutputStreamCtor, (String) null);
                                    if (pA) {
                                        Log.d("TTPropHelper", "save: " + c0192Og.Og);
                                        Log.d("TTPropHelper", "saveToLocal: save to" + this.Bzk.getAbsolutePath() + "success");
                                    }
                                    try {
                                        fileOutputStreamFileOutputStreamCtor.close();
                                    } catch (Throwable th2) {
                                        str = "TTPropHelper";
                                        message = th2.getMessage();
                                        Log.w(str, message);
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                                    Log.e("TTPropHelper", "saveToLocal: ", e);
                                    c0192Og.pA(false, false);
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th3) {
                                            str = "TTPropHelper";
                                            message = th3.getMessage();
                                            Log.w(str, message);
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (Throwable th5) {
                                        Log.w("TTPropHelper", th5.getMessage());
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                            jCurrentTimeMillis3 = 0;
                            Log.e("TTPropHelper", "saveToLocal: ", e);
                            c0192Og.pA(false, false);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (pA) {
                                jCurrentTimeMillis4 = System.currentTimeMillis();
                            } else {
                                jCurrentTimeMillis4 = 0;
                            }
                            this.SGo.delete();
                            if (pA) {
                                jCurrentTimeMillis5 = System.currentTimeMillis();
                            } else {
                                jCurrentTimeMillis5 = 0;
                            }
                            this.omh = c0192Og.pA;
                            c0192Og.pA(true, true);
                            if (pA) {
                                Log.d("TTPropHelper", "write: " + (jCurrentTimeMillis - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis2 - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis3 - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis4 - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis5 - jCurrentTimeMillis6));
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (pA) {
                jCurrentTimeMillis4 = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis4 = 0;
            }
            this.SGo.delete();
            if (pA) {
                jCurrentTimeMillis5 = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis5 = 0;
            }
            this.omh = c0192Og.pA;
            c0192Og.pA(true, true);
            if (pA) {
                Log.d("TTPropHelper", "write: " + (jCurrentTimeMillis - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis2 - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis3 - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis4 - jCurrentTimeMillis6) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis5 - jCurrentTimeMillis6));
            }
        } catch (Throwable th7) {
            Log.w("TTPropHelper", "writeToFile: Got exception:", th7);
            if (this.Bzk.exists() && !this.Bzk.delete()) {
                Log.e("TTPropHelper", "Couldn't clean up partially-written file " + this.Bzk);
            }
            c0192Og.pA(false, false);
        }
    }
}
