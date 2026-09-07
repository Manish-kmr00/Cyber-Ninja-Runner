package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class m71 {
    static final /* synthetic */ KProperty<Object>[] f = {ta.a(m71.class, "nativeAdView", "getNativeAdView()Landroid/view/View;", 0), ta.a(m71.class, "imageView", "getImageView()Landroid/widget/ImageView;", 0), ta.a(m71.class, "muteButtonView", "getMuteButtonView()Landroid/widget/CheckBox;", 0), ta.a(m71.class, "videoProgressView", "getVideoProgressView()Landroid/widget/ProgressBar;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn1 f9603a;
    private final zn1 b;
    private final zn1 c;
    private final zn1 d;
    private final LinkedHashMap e;

    public final View a(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        WeakReference weakReference = (WeakReference) this.e.get(assetName);
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private m71(a aVar) {
        this.f9603a = ao1.a(aVar.d());
        this.b = ao1.a(aVar.b());
        this.c = ao1.a(aVar.c());
        this.d = ao1.a(aVar.e());
        this.e = xt0.a(aVar.a());
    }

    public final View d() {
        return (View) this.f9603a.getValue(this, f[0]);
    }

    @Deprecated(message = "")
    public final ImageView b() {
        return (ImageView) this.b.getValue(this, f[1]);
    }

    public final CheckBox c() {
        return (CheckBox) this.c.getValue(this, f[2]);
    }

    public final ProgressBar e() {
        return (ProgressBar) this.d.getValue(this, f[3]);
    }

    public /* synthetic */ m71(a aVar, int i) {
        this(aVar);
    }

    public final LinkedHashMap a() {
        return this.e;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f9604a;
        private CheckBox b;
        private ProgressBar c;
        private final Map<String, View> d;
        private ImageView e;

        public a(View nativeAdView, Map<String, ? extends View> initialAssetViews) {
            Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
            Intrinsics.checkNotNullParameter(initialAssetViews, "initialAssetViews");
            this.f9604a = nativeAdView;
            this.d = MapsKt.toMutableMap(initialAssetViews);
        }

        public final View d() {
            return this.f9604a;
        }

        public final CheckBox c() {
            return this.b;
        }

        public final ProgressBar e() {
            return this.c;
        }

        public final Map<String, View> a() {
            return this.d;
        }

        public final ImageView b() {
            return this.e;
        }

        @Deprecated(message = "")
        public final a a(ImageView imageView) {
            this.e = imageView;
            return this;
        }

        public final a a(CheckBox checkBox) {
            this.b = checkBox;
            return this;
        }

        public final a a(ProgressBar progressBar) {
            this.c = progressBar;
            return this;
        }
    }
}
