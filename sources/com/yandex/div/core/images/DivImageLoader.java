package com.yandex.div.core.images;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes6.dex */
public interface DivImageLoader {
    LoadReference loadImage(String str, ImageView imageView);

    LoadReference loadImage(String str, DivImageDownloadCallback divImageDownloadCallback);

    LoadReference loadImageBytes(String str, DivImageDownloadCallback divImageDownloadCallback);

    default Boolean hasSvgSupport() {
        return false;
    }

    default LoadReference loadImage(String str, DivImageDownloadCallback divImageDownloadCallback, int i) {
        return loadImage(str, divImageDownloadCallback);
    }

    default LoadReference loadImageBytes(String str, DivImageDownloadCallback divImageDownloadCallback, int i) {
        return loadImageBytes(str, divImageDownloadCallback);
    }
}
