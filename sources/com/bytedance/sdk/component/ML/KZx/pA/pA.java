package com.bytedance.sdk.component.ML.KZx.pA;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.unity3d.services.core.di.ServiceProvider;
import java.io.File;

/* JADX INFO: loaded from: classes13.dex */
public class pA implements com.bytedance.sdk.component.ML.Og, Cloneable {
    private static volatile com.bytedance.sdk.component.ML.Og JG;
    private boolean KZx;
    private File ML;
    private int Og;
    private boolean ZZv;
    private long pA;

    @Override // com.bytedance.sdk.component.ML.Og
    public boolean JG() {
        return true;
    }

    public pA(int i, long j, File file) {
        this(i, j, i != 0, j != 0, file);
    }

    public pA(int i, long j, boolean z, boolean z2, File file) {
        this.pA = j;
        this.Og = i;
        this.KZx = z;
        this.ZZv = z2;
        this.ML = file;
    }

    @Override // com.bytedance.sdk.component.ML.Og
    public long pA() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.ML.Og
    public int Og() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.ML.Og
    public boolean KZx() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.ML.Og
    public boolean ZZv() {
        return this.ZZv;
    }

    @Override // com.bytedance.sdk.component.ML.Og
    public File ML() {
        return this.ML;
    }

    public static void pA(Context context, com.bytedance.sdk.component.ML.Og og) {
        if (og != null) {
            JG = og;
        } else {
            JG = pA(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.ML.Og pA(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (JG == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            jMin = Math.min(omh() / 16, 41943040L);
        } else {
            iMin = Math.min(JG.Og() / 2, 31457280);
            jMin = Math.min(JG.pA() / 2, 41943040L);
        }
        return new pA(Math.max(iMin, 26214400), Math.max(jMin, ServiceProvider.HTTP_CACHE_DISK_SIZE), file);
    }

    public static com.bytedance.sdk.component.ML.Og SD() {
        return JG;
    }

    private static long omh() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
