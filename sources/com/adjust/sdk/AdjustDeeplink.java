package com.adjust.sdk;

import android.net.Uri;

/* JADX INFO: loaded from: classes9.dex */
public class AdjustDeeplink {
    Uri url;

    public AdjustDeeplink(Uri uri) {
        this.url = uri;
    }

    public Uri getUrl() {
        return this.url;
    }

    public boolean isValid() {
        Uri uri = this.url;
        return (uri == null || uri.toString().isEmpty()) ? false : true;
    }
}
