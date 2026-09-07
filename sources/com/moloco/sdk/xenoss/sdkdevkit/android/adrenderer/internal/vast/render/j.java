package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7075a = 0;

    public static final class a extends j {
        public static final int c = 0;
        public final int b;

        public a(int i) {
            super(null);
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.b == ((a) obj).b;
        }

        public int hashCode() {
            return Integer.hashCode(this.b);
        }

        public String toString() {
            return "Html(webViewId=" + this.b + ')';
        }

        public final a a(int i) {
            return new a(i);
        }

        public static /* synthetic */ a a(a aVar, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = aVar.b;
            }
            return aVar.a(i);
        }
    }

    public static final class b extends j {
        public static final int e = 0;
        public final String b;
        public final int c;
        public final int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String imageUrl, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            this.b = imageUrl;
            this.c = i;
            this.d = i2;
        }

        public final String a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final int d() {
            return this.d;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d;
        }

        public final int f() {
            return this.c;
        }

        public int hashCode() {
            return (((this.b.hashCode() * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "Image(imageUrl=" + this.b + ", w=" + this.c + ", h=" + this.d + ')';
        }

        public final b a(String imageUrl, int i, int i2) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            return new b(imageUrl, i, i2);
        }

        public static /* synthetic */ b a(b bVar, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = bVar.b;
            }
            if ((i3 & 2) != 0) {
                i = bVar.c;
            }
            if ((i3 & 4) != 0) {
                i2 = bVar.d;
            }
            return bVar.a(str, i, i2);
        }
    }

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public j() {
    }
}
