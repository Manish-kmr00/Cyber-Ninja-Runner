package com.smaato.sdk.nativead;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class NativeAdAssets {

    public static abstract class Builder {
        public abstract NativeAdAssets build();

        public abstract Builder cta(String str);

        public abstract Builder icon(Image image);

        public abstract Builder images(List<Image> list);

        public abstract Builder mraidJs(String str);

        public abstract Builder rating(Double d);

        public abstract Builder sponsored(String str);

        public abstract Builder text(String str);

        public abstract Builder title(String str);

        public abstract Builder vastTag(String str);
    }

    public abstract String cta();

    public abstract Image icon();

    public abstract List<Image> images();

    public abstract String mraidJs();

    public abstract Double rating();

    public abstract String sponsored();

    public abstract String text();

    public abstract String title();

    public abstract String vastTag();

    public static Builder builder() {
        return new AutoValue_NativeAdAssets.Builder().images(Collections.emptyList());
    }

    public Builder buildUpon() {
        return new AutoValue_NativeAdAssets.Builder().title(title()).mraidJs(mraidJs()).vastTag(vastTag()).text(text()).sponsored(sponsored()).cta(cta()).icon(icon()).images(images()).rating(rating());
    }

    public static abstract class Image {
        public abstract Drawable drawable();

        public abstract int height();

        public abstract Uri uri();

        public abstract int width();

        public static Image create(Uri uri, int i, int i2) {
            return new AutoValue_NativeAdAssets_Image(null, uri, i, i2);
        }

        public Image withDrawable(Drawable drawable) {
            return new AutoValue_NativeAdAssets_Image(drawable, uri(), width(), height());
        }
    }
}
