package net.pubnative.lite.sdk.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/* JADX INFO: loaded from: classes3.dex */
public class PNBitmapLruCache {
    private static final int BYTES_IN_KILOBYTES = 1024;
    private static final int MAX_MEMORY_SIZE = 31457280;
    private static final LruCache<String, Bitmap> mMemoryCache = new LruCache<String, Bitmap>(Math.min((int) (Runtime.getRuntime().maxMemory() / 1024), MAX_MEMORY_SIZE)) { // from class: net.pubnative.lite.sdk.utils.PNBitmapLruCache.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    public static void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        String strValueOf = String.valueOf(str.hashCode());
        if (getBitmapFromMemCache(strValueOf) == null) {
            mMemoryCache.put(strValueOf, bitmap);
        }
    }

    public static Bitmap getBitmapFromMemCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mMemoryCache.get(String.valueOf(str.hashCode()));
    }
}
