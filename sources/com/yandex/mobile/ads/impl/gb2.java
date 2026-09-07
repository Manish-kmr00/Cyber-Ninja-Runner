package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.monetization.ads.video.playback.view.ExtendedVideoAdControlsContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class gb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExtendedVideoAdControlsContainer f8987a;
    private final TextView b;
    private final ImageView c;
    private final v31 d;
    private final ProgressBar e;
    private final View f;
    private final TextView g;
    private final ImageView h;
    private final ImageView i;
    private final TextView j;
    private final TextView k;
    private final View l;
    private final ImageView m;
    private final TextView n;
    private final TextView o;
    private final ImageView p;
    private final TextView q;

    private gb2(a aVar) {
        this.f8987a = aVar.e();
        this.b = aVar.d();
        this.c = aVar.c();
        this.d = aVar.i();
        this.e = aVar.j();
        this.f = aVar.l();
        this.g = aVar.n();
        this.h = aVar.m();
        this.i = aVar.g();
        this.j = aVar.f();
        this.k = aVar.a();
        this.l = aVar.b();
        this.m = aVar.p();
        this.n = aVar.o();
        this.o = aVar.k();
        this.p = aVar.h();
        this.q = aVar.q();
    }

    public final ExtendedVideoAdControlsContainer a() {
        return this.f8987a;
    }

    public final TextView e() {
        return this.b;
    }

    public final ImageView d() {
        return this.c;
    }

    public final v31 i() {
        return this.d;
    }

    public final ProgressBar j() {
        return this.e;
    }

    public final View l() {
        return this.f;
    }

    public final TextView n() {
        return this.g;
    }

    public final ImageView m() {
        return this.h;
    }

    public final ImageView g() {
        return this.i;
    }

    public final TextView f() {
        return this.j;
    }

    public final TextView b() {
        return this.k;
    }

    public final View c() {
        return this.l;
    }

    public final ImageView p() {
        return this.m;
    }

    public final TextView o() {
        return this.n;
    }

    public final TextView k() {
        return this.o;
    }

    public final ImageView h() {
        return this.p;
    }

    public final TextView q() {
        return this.q;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExtendedVideoAdControlsContainer f8988a;
        private TextView b;
        private ImageView c;
        private v31 d;
        private ProgressBar e;
        private View f;
        private TextView g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private TextView k;
        private ImageView l;
        private TextView m;
        private TextView n;
        private View o;
        private ImageView p;
        private TextView q;

        public a(ExtendedVideoAdControlsContainer controlsContainer) {
            Intrinsics.checkNotNullParameter(controlsContainer, "controlsContainer");
            this.f8988a = controlsContainer;
        }

        public final ExtendedVideoAdControlsContainer e() {
            return this.f8988a;
        }

        public final TextView d() {
            return this.b;
        }

        public final ImageView c() {
            return this.c;
        }

        public final v31 i() {
            return this.d;
        }

        public final ProgressBar j() {
            return this.e;
        }

        public final View l() {
            return this.f;
        }

        public final TextView n() {
            return this.g;
        }

        public final ImageView m() {
            return this.h;
        }

        public final ImageView g() {
            return this.i;
        }

        public final TextView f() {
            return this.j;
        }

        public final TextView a() {
            return this.k;
        }

        public final ImageView p() {
            return this.l;
        }

        public final TextView o() {
            return this.m;
        }

        public final TextView k() {
            return this.n;
        }

        public final View b() {
            return this.o;
        }

        public final ImageView h() {
            return this.p;
        }

        public final TextView q() {
            return this.q;
        }

        public final a b(TextView textView) {
            this.b = textView;
            return this;
        }

        public final a e(TextView textView) {
            this.g = textView;
            return this;
        }

        public final a c(TextView textView) {
            this.j = textView;
            return this;
        }

        public final a a(TextView textView) {
            this.k = textView;
            return this;
        }

        public final a d(TextView textView) {
            this.n = textView;
            return this;
        }

        public final a f(TextView textView) {
            this.m = textView;
            return this;
        }

        public final a g(TextView textView) {
            this.q = textView;
            return this;
        }

        public final a b(ImageView imageView) {
            this.i = imageView;
            return this;
        }

        public final a e(ImageView imageView) {
            this.l = imageView;
            return this;
        }

        public final a d(ImageView imageView) {
            this.h = imageView;
            return this;
        }

        public final a c(ImageView imageView) {
            this.p = imageView;
            return this;
        }

        public final a a(View view) {
            this.o = view;
            return this;
        }

        public final a b(View view) {
            this.f = view;
            return this;
        }

        public final a a(ImageView imageView) {
            this.c = imageView;
            return this;
        }

        public final a a(v31 v31Var) {
            this.d = v31Var;
            return this;
        }

        public final a a(ProgressBar progressBar) {
            this.e = progressBar;
            return this;
        }
    }

    public /* synthetic */ gb2(a aVar, int i) {
        this(aVar);
    }
}
