package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g71 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckBox f8973a;
    private final ProgressBar b;
    private final View c;
    private final Map<String, View> d;
    private final b81 e;
    private final ImageView f;

    private g71(a aVar) {
        this.f8973a = aVar.c();
        this.b = aVar.f();
        this.c = aVar.d();
        this.d = aVar.a();
        this.e = aVar.e();
        this.f = aVar.b();
    }

    public final CheckBox c() {
        return this.f8973a;
    }

    public final ProgressBar f() {
        return this.b;
    }

    public final View d() {
        return this.c;
    }

    public final Map<String, View> a() {
        return this.d;
    }

    public final b81 e() {
        return this.e;
    }

    @Deprecated(message = "")
    public final ImageView b() {
        return this.f;
    }

    public /* synthetic */ g71(a aVar, int i) {
        this(aVar);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f8974a;
        private final b81 b;
        private CheckBox c;
        private ProgressBar d;
        private final Map<String, View> e;
        private ImageView f;

        public a(View nativeAdView, b81 nativeBindType, Map<String, ? extends View> initialAssetViews) {
            Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
            Intrinsics.checkNotNullParameter(nativeBindType, "nativeBindType");
            Intrinsics.checkNotNullParameter(initialAssetViews, "initialAssetViews");
            this.f8974a = nativeAdView;
            this.b = nativeBindType;
            this.e = MapsKt.toMutableMap(initialAssetViews);
        }

        public final View d() {
            return this.f8974a;
        }

        public final b81 e() {
            return this.b;
        }

        public final CheckBox c() {
            return this.c;
        }

        public final ProgressBar f() {
            return this.d;
        }

        public final Map<String, View> a() {
            return this.e;
        }

        public final ImageView b() {
            return this.f;
        }

        public final a g(TextView textView) {
            this.e.put("sponsored", textView);
            return this;
        }

        public final a h(TextView textView) {
            this.e.put("title", textView);
            return this;
        }

        public final a a(TextView textView) {
            this.e.put("age", textView);
            return this;
        }

        public final void a(View view, String assetName) {
            Intrinsics.checkNotNullParameter(assetName, "assetName");
            this.e.put(assetName, view);
        }

        public final a i(TextView textView) {
            this.e.put("warning", textView);
            return this;
        }

        public final a c(TextView textView) {
            this.e.put("call_to_action", textView);
            return this;
        }

        public final a b(TextView textView) {
            this.e.put("body", textView);
            return this;
        }

        public final a d(TextView textView) {
            this.e.put("domain", textView);
            return this;
        }

        public final a e(TextView textView) {
            this.e.put("price", textView);
            return this;
        }

        public final a f(TextView textView) {
            this.e.put("review_count", textView);
            return this;
        }

        public final a a(ImageView imageView) {
            this.e.put("favicon", imageView);
            return this;
        }

        public final a b(ImageView imageView) {
            this.e.put("feedback", imageView);
            return this;
        }

        public final a c(ImageView imageView) {
            this.e.put("icon", imageView);
            return this;
        }

        @Deprecated(message = "")
        public final a d(ImageView imageView) {
            this.f = imageView;
            return this;
        }

        public final a a(CustomizableMediaView customizableMediaView) {
            this.e.put("media", customizableMediaView);
            return this;
        }

        public final a a(CheckBox checkBox) {
            this.c = checkBox;
            return this;
        }

        public final a a(View view) {
            this.e.put("rating", view);
            return this;
        }

        public final a a(ProgressBar progressBar) {
            this.d = progressBar;
            return this;
        }
    }
}
