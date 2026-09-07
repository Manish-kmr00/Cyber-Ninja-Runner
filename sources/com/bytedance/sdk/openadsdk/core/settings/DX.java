package com.bytedance.sdk.openadsdk.core.settings;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.aBv;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.internal.partials.PangleFilesBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DX implements ML {
    private final String SD;
    private pA SGo;
    private final ConcurrentHashMap<String, Object> KZx = new ConcurrentHashMap<>();
    private final Object ZZv = new Object();
    private final Object ML = new Object();
    private final CountDownLatch JG = new CountDownLatch(1);
    private Properties omh = new Properties();
    private volatile boolean Bzk = false;

    public interface pA {
        void Og();

        void pA();
    }

    public DX(String str, pA pAVar) {
        this.SD = str;
        this.SGo = pAVar;
        xy.pA(new com.bytedance.sdk.component.omh.omh("SetL_".concat(String.valueOf(str))) { // from class: com.bytedance.sdk.openadsdk.core.settings.DX.1
            @Override // java.lang.Runnable
            public void run() {
                DX.this.pA(false);
            }
        });
    }

    public String pA(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        ML();
        return this.omh.getProperty(str, str2);
    }

    private void ML() {
        if (this.Bzk) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.JG.await(xy.ML() ? 4 : 8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "awaitLoadedLocked: ", e);
        }
    }

    public int pA(String str, int i) {
        if (str != null && !str.isEmpty()) {
            ML();
            try {
                return Integer.parseInt(this.omh.getProperty(str, String.valueOf(i)));
            } catch (NumberFormatException e) {
                com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "", e);
            }
        }
        return i;
    }

    public long pA(String str, long j) {
        if (str != null && !str.isEmpty()) {
            ML();
            try {
                return Long.parseLong(this.omh.getProperty(str, String.valueOf(j)));
            } catch (NumberFormatException e) {
                com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "", e);
            }
        }
        return j;
    }

    public float pA(String str, float f) {
        if (str != null && !str.isEmpty()) {
            ML();
            try {
                return Float.parseFloat(this.omh.getProperty(str, String.valueOf(f)));
            } catch (NumberFormatException e) {
                com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "", e);
            }
        }
        return f;
    }

    public boolean pA(String str, boolean z) {
        if (str != null && !str.isEmpty()) {
            ML();
            try {
                return Boolean.parseBoolean(this.omh.getProperty(str, String.valueOf(z)));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "", e);
            }
        }
        return z;
    }

    public void pA(boolean z) {
        pA pAVar;
        Object obj;
        synchronized (this.ZZv) {
            if (!this.Bzk || z) {
                File fileJG = JG();
                if (fileJG.exists()) {
                    Properties properties = new Properties();
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(fileJG);
                            try {
                                properties.load(fileInputStream2);
                                new Object[]{"reload: find", Integer.valueOf(properties.size()), "items from " + fileJG.getAbsolutePath()};
                                if (!properties.isEmpty()) {
                                    this.omh = properties;
                                    this.KZx.clear();
                                }
                                com.bytedance.sdk.openadsdk.utils.BSW.pA(fileInputStream2);
                                obj = this.ZZv;
                            } catch (OutOfMemoryError unused) {
                                fileInputStream = fileInputStream2;
                                try {
                                    com.bytedance.sdk.component.utils.JG.KZx(fileJG);
                                } catch (Throwable th) {
                                    com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "delete: ", th);
                                }
                                if (fileInputStream != null) {
                                    com.bytedance.sdk.openadsdk.utils.BSW.pA(fileInputStream);
                                }
                                obj = this.ZZv;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "reload: ", th);
                                if (fileInputStream != null) {
                                    com.bytedance.sdk.openadsdk.utils.BSW.pA(fileInputStream);
                                }
                                obj = this.ZZv;
                            }
                        } catch (OutOfMemoryError unused2) {
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        obj.notifyAll();
                    } catch (Throwable th4) {
                        if (fileInputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.BSW.pA(fileInputStream);
                        }
                        this.ZZv.notifyAll();
                        throw th4;
                    }
                } else if (aBv.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()) && "tt_sdk_settings.prop".equals(this.SD)) {
                    try {
                        boolean z2 = false;
                        SharedPreferences sharedPreferences = com.bytedance.sdk.openadsdk.core.aBv.pA().getSharedPreferences("tt_sdk_settings", 0);
                        if (!sharedPreferences.getAll().isEmpty()) {
                            ML.pA pAVarPA = pA();
                            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (key != null && !key.isEmpty() && value != null) {
                                    pAVarPA.pA(key, value.toString());
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                pAVarPA.pA();
                            }
                            sharedPreferences.edit().clear().commit();
                        }
                    } catch (Exception unused3) {
                    }
                }
                if (!this.Bzk && (pAVar = this.SGo) != null) {
                    pAVar.pA();
                }
                this.Bzk = true;
                this.JG.countDown();
            }
        }
    }

    private File JG() {
        return new File(com.bytedance.sdk.openadsdk.core.aBv.pA().getFilesDir(), this.SD);
    }

    public ML.pA pA() {
        return new Og();
    }

    public <T> T pA(String str, T t, ML.Og<T> og) {
        T tOg;
        if (str != null && !str.isEmpty()) {
            if (this.KZx.containsKey(str)) {
                try {
                    return (T) this.KZx.get(str);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "", e);
                    return t;
                }
            }
            ML();
            String property = this.omh.getProperty(str, null);
            if (property != null && og != null && (tOg = og.Og(property)) != null) {
                this.KZx.put(str, tOg);
                return tOg;
            }
        }
        return t;
    }

    public boolean Og() {
        return this.Bzk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void pA(Properties properties) {
        synchronized (this.ML) {
            File fileJG = JG();
            ?? r2 = 0;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStreamFileOutputStreamCtor = PangleFilesBridge.fileOutputStreamCtor(fileJG);
                    try {
                        properties.store(fileOutputStreamFileOutputStreamCtor, (String) null);
                        String str = "success";
                        new Object[]{"saveToLocal: save to", fileJG.getAbsolutePath(), "success"};
                        com.bytedance.sdk.openadsdk.utils.BSW.pA(fileOutputStreamFileOutputStreamCtor);
                        r2 = str;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStreamFileOutputStreamCtor;
                        com.bytedance.sdk.component.utils.WV.pA("SdkSettings.Prop", "saveToLocal: ", e);
                        r2 = fileOutputStream;
                        if (fileOutputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.BSW.pA(fileOutputStream);
                            r2 = fileOutputStream;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r2 = fileOutputStreamFileOutputStreamCtor;
                        if (r2 != 0) {
                            com.bytedance.sdk.openadsdk.utils.BSW.pA(r2);
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        oX.Xj();
    }

    public void KZx() {
        File fileJG = JG();
        if (fileJG.exists()) {
            fileJG.delete();
        }
    }

    public class Og implements ML.pA {
        private final Map<String, Object> Og = new HashMap();
        private final Object KZx = new Object();

        public Og() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public void pA() {
            Object obj;
            new Object[]{"commit: ", this.Og};
            Properties properties = new Properties();
            synchronized (this.KZx) {
                properties.putAll(DX.this.omh);
                boolean z = false;
                for (Map.Entry<String, Object> entry : this.Og.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == this || value == null) {
                        if (properties.containsKey(key)) {
                            properties.remove(key);
                            z = true;
                        }
                    } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(value)) {
                        properties.put(key, String.valueOf(value));
                        z = true;
                    }
                }
                this.Og.clear();
                if (z) {
                    DX.this.pA(properties);
                    DX.this.omh = properties;
                    DX.this.KZx.clear();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public ML.pA pA(String str, String str2) {
            synchronized (this.KZx) {
                this.Og.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public ML.pA pA(String str, int i) {
            synchronized (this.KZx) {
                this.Og.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public ML.pA pA(String str, long j) {
            synchronized (this.KZx) {
                this.Og.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public ML.pA pA(String str) {
            synchronized (this.KZx) {
                this.Og.put(str, this);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public ML.pA pA(String str, float f) {
            synchronized (this.KZx) {
                this.Og.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ML.pA
        public ML.pA pA(String str, boolean z) {
            synchronized (this.KZx) {
                this.Og.put(str, Boolean.valueOf(z));
            }
            return this;
        }
    }

    protected void ZZv() {
        pA pAVar = this.SGo;
        if (pAVar != null) {
            pAVar.Og();
        }
    }
}
