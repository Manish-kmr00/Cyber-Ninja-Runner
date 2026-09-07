package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: classes6.dex */
public final class fd1 extends LruCache<String, Bitmap> {
    fd1(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String str, Bitmap bitmap) {
        String str2 = str;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            return bitmap2.getByteCount() / 1024;
        }
        return super.sizeOf(str2, null);
    }
}
