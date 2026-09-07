package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6732a = 0;

    public static final class a extends o {
        public static final int e = 0;
        public final boolean b;
        public final int c;
        public final int d;

        public /* synthetic */ a(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, i, i2);
        }

        public final int a() {
            return this.d;
        }

        public final boolean b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public a(boolean z, int i, int i2) {
            super(null);
            this.b = z;
            this.c = i;
            this.d = i2;
        }
    }

    public static final class b extends o {
        public static final int g = 8;
        public final Painter b;
        public final String c;
        public final long d;
        public final Shape e;
        public final long f;

        public /* synthetic */ b(Painter painter, String str, long j, Shape shape, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(painter, str, j, shape, j2);
        }

        public final long a() {
            return this.f;
        }

        public final Shape b() {
            return this.e;
        }

        public final String c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final Painter e() {
            return this.b;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Painter painter, String str, long j, Shape backgroundShape, long j2) {
            super(null);
            Intrinsics.checkNotNullParameter(painter, "painter");
            Intrinsics.checkNotNullParameter(backgroundShape, "backgroundShape");
            this.b = painter;
            this.c = str;
            this.d = j;
            this.e = backgroundShape;
            this.f = j2;
        }
    }

    public static final class c extends o {
        public static final int c = 0;
        public final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.b = text;
        }

        public final String a() {
            return this.b;
        }
    }

    public /* synthetic */ o(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public o() {
    }
}
