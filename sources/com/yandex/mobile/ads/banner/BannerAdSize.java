package com.yandex.mobile.ads.banner;

import android.content.Context;
import com.yandex.mobile.ads.impl.bl1;
import com.yandex.mobile.ads.impl.n22;
import com.yandex.mobile.ads.impl.ob0;
import com.yandex.mobile.ads.impl.ws;
import com.yandex.mobile.ads.impl.zy1;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/yandex/mobile/ads/banner/BannerAdSize;", "Lcom/yandex/mobile/ads/impl/bl1;", "Landroid/content/Context;", "context", "", "getHeightInPixels", "(Landroid/content/Context;)I", "getWidthInPixels", "getHeight", "getWidth", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "height", "width", "Lcom/yandex/mobile/ads/impl/zy1;", "sizeInfo", "<init>", "(Lcom/yandex/mobile/ads/impl/zy1;)V", "a", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class BannerAdSize extends bl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final zy1 b;

    /* JADX INFO: renamed from: com.yandex.mobile.ads.banner.BannerAdSize$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lcom/yandex/mobile/ads/banner/BannerAdSize$a;", "", "()V", "fixedSize", "Lcom/yandex/mobile/ads/banner/BannerAdSize;", "context", "Landroid/content/Context;", "width", "", "height", "inlineSize", "maxHeight", "stickySize", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final BannerAdSize fixedSize(Context context, int width, int height) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new BannerAdSize(new ob0(width, height, zy1.a.c));
        }

        @JvmStatic
        public final BannerAdSize inlineSize(Context context, int width, int maxHeight) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new BannerAdSize(new ob0(width, maxHeight, zy1.a.d));
        }

        @JvmStatic
        public final BannerAdSize stickySize(Context context, int width) {
            Intrinsics.checkNotNullParameter(context, "context");
            ws coreBannerAdSize = n22.a(context, width);
            Intrinsics.checkNotNullParameter(coreBannerAdSize, "coreBannerAdSize");
            return new BannerAdSize(coreBannerAdSize.a());
        }

        private Companion() {
        }
    }

    public BannerAdSize(zy1 sizeInfo) {
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        this.b = sizeInfo;
    }

    @JvmStatic
    public static final BannerAdSize fixedSize(Context context, int i, int i2) {
        return INSTANCE.fixedSize(context, i, i2);
    }

    @JvmStatic
    public static final BannerAdSize inlineSize(Context context, int i, int i2) {
        return INSTANCE.inlineSize(context, i, i2);
    }

    @JvmStatic
    public static final BannerAdSize stickySize(Context context, int i) {
        return INSTANCE.stickySize(context, i);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(BannerAdSize.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.b, ((BannerAdSize) other).b);
    }

    public final int getHeight() {
        return this.b.getHeight();
    }

    public final int getHeightInPixels(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.b.b(context);
    }

    public final int getWidth() {
        return this.b.getWidth();
    }

    public final int getWidthInPixels(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.b.d(context);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString();
    }

    public final int getHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.b.a(context);
    }

    public final int getWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.b.c(context);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    protected final zy1 getB() {
        return this.b;
    }
}
