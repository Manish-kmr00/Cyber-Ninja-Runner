package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes3.dex */
public final class ev implements jm {
    public static final ev s;
    public static final jm.a<ev> t;
    public final CharSequence b;
    public final Layout.Alignment c;
    public final Layout.Alignment d;
    public final Bitmap e;
    public final float f;
    public final int g;
    public final int h;
    public final float i;
    public final int j;
    public final float k;
    public final float l;
    public final boolean m;
    public final int n;
    public final int o;
    public final float p;
    public final int q;
    public final float r;

    static {
        a aVar = new a();
        aVar.f8833a = "";
        s = aVar.a();
        t = new jm.a() { // from class: com.yandex.mobile.ads.impl.ev$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return ev.a(bundle);
            }
        };
    }

    public final a a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ev a(Bundle bundle) {
        a aVar = new a();
        CharSequence charSequence = bundle.getCharSequence(Integer.toString(0, 36));
        if (charSequence != null) {
            aVar.f8833a = charSequence;
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(Integer.toString(1, 36));
        if (alignment != null) {
            aVar.c = alignment;
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(Integer.toString(2, 36));
        if (alignment2 != null) {
            aVar.d = alignment2;
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(Integer.toString(3, 36));
        if (bitmap != null) {
            aVar.b = bitmap;
        }
        if (bundle.containsKey(Integer.toString(4, 36)) && bundle.containsKey(Integer.toString(5, 36))) {
            float f = bundle.getFloat(Integer.toString(4, 36));
            int i = bundle.getInt(Integer.toString(5, 36));
            aVar.e = f;
            aVar.f = i;
        }
        if (bundle.containsKey(Integer.toString(6, 36))) {
            aVar.g = bundle.getInt(Integer.toString(6, 36));
        }
        if (bundle.containsKey(Integer.toString(7, 36))) {
            aVar.h = bundle.getFloat(Integer.toString(7, 36));
        }
        if (bundle.containsKey(Integer.toString(8, 36))) {
            aVar.i = bundle.getInt(Integer.toString(8, 36));
        }
        if (bundle.containsKey(Integer.toString(10, 36)) && bundle.containsKey(Integer.toString(9, 36))) {
            float f2 = bundle.getFloat(Integer.toString(10, 36));
            int i2 = bundle.getInt(Integer.toString(9, 36));
            aVar.k = f2;
            aVar.j = i2;
        }
        if (bundle.containsKey(Integer.toString(11, 36))) {
            aVar.l = bundle.getFloat(Integer.toString(11, 36));
        }
        if (bundle.containsKey(Integer.toString(12, 36))) {
            aVar.m = bundle.getFloat(Integer.toString(12, 36));
        }
        if (bundle.containsKey(Integer.toString(13, 36))) {
            aVar.o = bundle.getInt(Integer.toString(13, 36));
            aVar.n = true;
        }
        if (!bundle.getBoolean(Integer.toString(14, 36), false)) {
            aVar.n = false;
        }
        if (bundle.containsKey(Integer.toString(15, 36))) {
            aVar.p = bundle.getInt(Integer.toString(15, 36));
        }
        if (bundle.containsKey(Integer.toString(16, 36))) {
            aVar.q = bundle.getFloat(Integer.toString(16, 36));
        }
        return aVar.a();
    }

    private ev(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6) {
        if (charSequence == null) {
            hg.a(bitmap);
        } else {
            hg.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.b = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.b = charSequence.toString();
        } else {
            this.b = null;
        }
        this.c = alignment;
        this.d = alignment2;
        this.e = bitmap;
        this.f = f;
        this.g = i;
        this.h = i2;
        this.i = f2;
        this.j = i3;
        this.k = f4;
        this.l = f5;
        this.m = z;
        this.n = i5;
        this.o = i4;
        this.p = f3;
        this.q = i6;
        this.r = f6;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || ev.class != obj.getClass()) {
            return false;
        }
        ev evVar = (ev) obj;
        return TextUtils.equals(this.b, evVar.b) && this.c == evVar.c && this.d == evVar.d && ((bitmap = this.e) != null ? !((bitmap2 = evVar.e) == null || !bitmap.sameAs(bitmap2)) : evVar.e == null) && this.f == evVar.f && this.g == evVar.g && this.h == evVar.h && this.i == evVar.i && this.j == evVar.j && this.k == evVar.k && this.l == evVar.l && this.m == evVar.m && this.n == evVar.n && this.o == evVar.o && this.p == evVar.p && this.q == evVar.q && this.r == evVar.r;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e, Float.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Float.valueOf(this.i), Integer.valueOf(this.j), Float.valueOf(this.k), Float.valueOf(this.l), Boolean.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), Float.valueOf(this.p), Integer.valueOf(this.q), Float.valueOf(this.r)});
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f8833a;
        private Bitmap b;
        private Layout.Alignment c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        private int o;
        private int p;
        private float q;

        public a() {
            this.f8833a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = ViewCompat.MEASURED_STATE_MASK;
            this.p = Integer.MIN_VALUE;
        }

        @Pure
        public final CharSequence d() {
            return this.f8833a;
        }

        public final a a(Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        @Pure
        public final int b() {
            return this.g;
        }

        @Pure
        public final int c() {
            return this.i;
        }

        public final void c(float f) {
            this.q = f;
        }

        private a(ev evVar) {
            this.f8833a = evVar.b;
            this.b = evVar.e;
            this.c = evVar.c;
            this.d = evVar.d;
            this.e = evVar.f;
            this.f = evVar.g;
            this.g = evVar.h;
            this.h = evVar.i;
            this.i = evVar.j;
            this.j = evVar.o;
            this.k = evVar.p;
            this.l = evVar.k;
            this.m = evVar.l;
            this.n = evVar.m;
            this.o = evVar.n;
            this.p = evVar.q;
            this.q = evVar.r;
        }

        public final a d(float f) {
            this.l = f;
            return this;
        }

        public final void d(int i) {
            this.o = i;
            this.n = true;
        }

        public final a a(float f) {
            this.m = f;
            return this;
        }

        public final a a(int i, float f) {
            this.e = f;
            this.f = i;
            return this;
        }

        public final a b(float f) {
            this.h = f;
            return this;
        }

        public final a c(int i) {
            this.p = i;
            return this;
        }

        public final a a(int i) {
            this.g = i;
            return this;
        }

        public final void a(Layout.Alignment alignment) {
            this.d = alignment;
        }

        public final a b(int i) {
            this.i = i;
            return this;
        }

        public final a a(CharSequence charSequence) {
            this.f8833a = charSequence;
            return this;
        }

        public final ev a() {
            return new ev(this.f8833a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
        }

        public final a b(Layout.Alignment alignment) {
            this.c = alignment;
            return this;
        }

        public final void b(int i, float f) {
            this.k = f;
            this.j = i;
        }
    }
}
