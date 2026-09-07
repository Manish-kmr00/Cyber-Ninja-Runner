package com.smaato.sdk.nativead;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_NativeAdAssets_Image extends NativeAdAssets.Image {
    private final Drawable drawable;
    private final int height;
    private final Uri uri;
    private final int width;

    AutoValue_NativeAdAssets_Image(Drawable drawable, Uri uri, int i, int i2) {
        this.drawable = drawable;
        if (uri == null) {
            throw new NullPointerException("Null uri");
        }
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    @Override // com.smaato.sdk.nativead.NativeAdAssets.Image
    public Drawable drawable() {
        return this.drawable;
    }

    @Override // com.smaato.sdk.nativead.NativeAdAssets.Image
    public Uri uri() {
        return this.uri;
    }

    @Override // com.smaato.sdk.nativead.NativeAdAssets.Image
    public int width() {
        return this.width;
    }

    @Override // com.smaato.sdk.nativead.NativeAdAssets.Image
    public int height() {
        return this.height;
    }

    public String toString() {
        return "Image{drawable=" + this.drawable + ", uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdAssets.Image)) {
            return false;
        }
        NativeAdAssets.Image image = (NativeAdAssets.Image) obj;
        Drawable drawable = this.drawable;
        if (drawable != null ? drawable.equals(image.drawable()) : image.drawable() == null) {
            if (this.uri.equals(image.uri()) && this.width == image.width() && this.height == image.height()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Drawable drawable = this.drawable;
        return (((((((drawable == null ? 0 : drawable.hashCode()) ^ 1000003) * 1000003) ^ this.uri.hashCode()) * 1000003) ^ this.width) * 1000003) ^ this.height;
    }
}
