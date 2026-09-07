package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.openvk.pA.pA.Og.pA.pA.pA;
import com.bykv.vk.openvk.pA.pA.pA.pA.Og;
import com.bytedance.sdk.component.utils.JG;
import com.bytedance.sdk.openadsdk.core.aBv;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class CacheDirFactory {
    public static volatile Og MEDIA_CACHE_DIR = null;
    public static String ROOT_DIR = null;
    public static final int SPLASH_USE_INTERNAL_STORAGE = 1;
    private static String pA;

    public static int getCacheType() {
        return 1;
    }

    private static Og pA() {
        if (MEDIA_CACHE_DIR == null) {
            synchronized (CacheDirFactory.class) {
                if (MEDIA_CACHE_DIR == null) {
                    pA pAVar = new pA();
                    MEDIA_CACHE_DIR = pAVar;
                    pAVar.pA(getRootDir());
                    MEDIA_CACHE_DIR.ZZv();
                }
            }
        }
        return MEDIA_CACHE_DIR;
    }

    public static String getRootDir() {
        if (!TextUtils.isEmpty(ROOT_DIR)) {
            return ROOT_DIR;
        }
        File filePA = JG.pA(aBv.pA(), com.bytedance.sdk.openadsdk.multipro.Og.KZx(), "tt_ad");
        if (filePA.isFile()) {
            filePA.delete();
        }
        if (!filePA.exists()) {
            filePA.mkdirs();
        }
        String absolutePath = filePA.getAbsolutePath();
        ROOT_DIR = absolutePath;
        return absolutePath;
    }

    public static Og getICacheDir(int i) {
        return pA();
    }

    public static String getImageCacheDir() {
        if (pA == null) {
            pA = getDiskCacheDirPath("image");
        }
        return pA;
    }

    public static String getDiskCacheDirPath(String str) {
        return getRootDir() + File.separator + str;
    }
}
