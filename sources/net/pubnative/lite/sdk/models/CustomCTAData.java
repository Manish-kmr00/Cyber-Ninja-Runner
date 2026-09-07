package net.pubnative.lite.sdk.models;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes11.dex */
public class CustomCTAData {
    private Bitmap bitmap;
    private final String iconURL;
    private final String label;

    public CustomCTAData(String str, String str2) {
        this.iconURL = str;
        this.label = str2;
    }

    public String getIconURL() {
        return this.iconURL;
    }

    public String getLabel() {
        return this.label;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
