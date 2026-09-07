package com.chartboost.sdk.impl;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<o9> f1012a;
    public final g5 b;

    public f5(Context context, AtomicReference<o9> atomicReference) {
        g5 g5Var = new g5(context.getCacheDir());
        this.b = g5Var;
        this.f1012a = atomicReference;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(atomicReference.get().o);
            File file = new File(g5Var.f1027a, "templates");
            if (file.exists()) {
                a(file.listFiles(), jCurrentTimeMillis);
                a(g5Var);
            }
        } catch (Exception e) {
            b7.b("Exception while cleaning up templates directory at " + this.b.f.getPath(), e);
            e.printStackTrace();
        }
    }

    public File[] c() {
        File fileB = b();
        if (fileB != null) {
            return fileB.listFiles();
        }
        return null;
    }

    public final void a(File[] fileArr, long j) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.isDirectory()) {
                    b(file.listFiles(), j);
                    a(file.listFiles(), file);
                }
            }
        }
    }

    public final void b(File[] fileArr, long j) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.lastModified() < j && !file.delete()) {
                    b7.b("Unable to delete " + file.getPath(), null);
                }
            }
        }
    }

    public JSONObject e() {
        String[] list;
        JSONObject jSONObject = new JSONObject();
        try {
            File file = a().f1027a;
            for (String str : this.f1012a.get().p) {
                if (!str.equals("templates")) {
                    File file2 = new File(file, str);
                    JSONArray jSONArray = new JSONArray();
                    if (file2.exists() && (list = file2.list()) != null) {
                        for (String str2 : list) {
                            if (!str2.equals(".nomedia") && !str2.endsWith(".tmp")) {
                                jSONArray.put(str2);
                            }
                        }
                    }
                    z1.a(jSONObject, str, jSONArray);
                }
            }
        } catch (Exception e) {
            b7.b("getWebViewCacheAssets: " + e, null);
        }
        return jSONObject;
    }

    public boolean c(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public File d() {
        return this.b.i;
    }

    public void d(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                int i = randomAccessFile.read();
                randomAccessFile.seek(0L);
                randomAccessFile.write(i);
                randomAccessFile.close();
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            b7.b("File not found when attempting to touch", e);
        } catch (IOException e2) {
            b7.b("IOException when attempting to touch file", e2);
        }
    }

    public g5 a() {
        return this.b;
    }

    public long b(File file) {
        long jB = 0;
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles == null) {
                        return 0L;
                    }
                    for (File file2 : fileArrListFiles) {
                        jB += b(file2);
                    }
                    return jB;
                }
            } catch (Exception e) {
                b7.b("getFolderSize: " + e, null);
                return 0L;
            }
        }
        if (file != null) {
            return file.length();
        }
        return 0L;
    }

    public boolean a(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public final void a(File[] fileArr, File file) {
        if (fileArr == null || fileArr.length != 0 || file.delete()) {
            return;
        }
        b7.b("Unable to delete " + file.getPath(), null);
    }

    public File b() {
        return this.b.h;
    }

    public File a(File file, String str) {
        if (file == null || str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists() || file2.length() <= 0) {
            return null;
        }
        return file2;
    }

    public Boolean a(v vVar) {
        Map<String, c1> mapD = vVar.d();
        g5 g5VarA = a();
        if (g5VarA == null) {
            return Boolean.FALSE;
        }
        File file = g5VarA.f1027a;
        for (c1 c1Var : mapD.values()) {
            File fileA = c1Var.a(file);
            if (fileA == null) {
                return Boolean.FALSE;
            }
            if (!fileA.exists()) {
                b7.b("Asset does not exist: " + c1Var.b, null);
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public final void a(g5 g5Var) {
        File file = new File(g5Var.f1027a, ".adId");
        if (!file.exists() || file.delete()) {
            return;
        }
        b7.b("Unable to delete " + file.getPath(), null);
    }
}
