package com.mbridge.msdk.out;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes11.dex */
public interface OnImageLoadListener {
    void loadError(String str);

    void loadSuccess(Drawable drawable, int i);
}
