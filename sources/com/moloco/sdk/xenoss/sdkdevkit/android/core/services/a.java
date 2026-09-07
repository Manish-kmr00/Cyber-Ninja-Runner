package com.moloco.sdk.xenoss.sdkdevkit.android.core.services;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0705a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7182a = 0;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$a, reason: collision with other inner class name */
        public static final class C0706a extends AbstractC0705a {
            public static final C0706a b = new C0706a();
            public static final int c = 0;

            public C0706a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$b */
        public static final class b extends AbstractC0705a {
            public static final int c = 0;
            public final long b;

            public b(long j) {
                super(null);
                this.b = j;
            }

            public final long a() {
                return this.b;
            }

            public final long b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.b == ((b) obj).b;
            }

            public int hashCode() {
                return Long.hashCode(this.b);
            }

            public String toString() {
                return "AppForeground(lastBgTimestamp=" + this.b + ')';
            }

            public final b a(long j) {
                return new b(j);
            }

            public static /* synthetic */ b a(b bVar, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = bVar.b;
                }
                return bVar.a(j);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c */
        public static final class c {
            public static final int d = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final EnumC0707a f7183a;
            public final f b;
            public final g c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$c$a, reason: collision with other inner class name */
            public enum EnumC0707a {
                NONE,
                CLOSE,
                SKIP,
                SKIP_DEC,
                MUTE,
                UNMUTE,
                CTA,
                REPLAY,
                AD_BADGE
            }

            public c(EnumC0707a buttonType, f position, g size) {
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Intrinsics.checkNotNullParameter(position, "position");
                Intrinsics.checkNotNullParameter(size, "size");
                this.f7183a = buttonType;
                this.b = position;
                this.c = size;
            }

            public final EnumC0707a a() {
                return this.f7183a;
            }

            public final f b() {
                return this.b;
            }

            public final g c() {
                return this.c;
            }

            public final EnumC0707a d() {
                return this.f7183a;
            }

            public final f e() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return this.f7183a == cVar.f7183a && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
            }

            public final g f() {
                return this.c;
            }

            public int hashCode() {
                return (((this.f7183a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "Button(buttonType=" + this.f7183a + ", position=" + this.b + ", size=" + this.c + ')';
            }

            public final c a(EnumC0707a buttonType, f position, g size) {
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Intrinsics.checkNotNullParameter(position, "position");
                Intrinsics.checkNotNullParameter(size, "size");
                return new c(buttonType, position, size);
            }

            public static /* synthetic */ c a(c cVar, EnumC0707a enumC0707a, f fVar, g gVar, int i, Object obj) {
                if ((i & 1) != 0) {
                    enumC0707a = cVar.f7183a;
                }
                if ((i & 2) != 0) {
                    fVar = cVar.b;
                }
                if ((i & 4) != 0) {
                    gVar = cVar.c;
                }
                return cVar.a(enumC0707a, fVar, gVar);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$e */
        public static final class e extends AbstractC0705a {
            public static final e b = new e();
            public static final int c = 0;

            public e() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$f */
        public static final class f {
            public static final int c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f7185a;
            public final float b;

            public f(float f, float f2) {
                this.f7185a = f;
                this.b = f2;
            }

            public final float a() {
                return this.f7185a;
            }

            public final float b() {
                return this.b;
            }

            public final float c() {
                return this.f7185a;
            }

            public final float d() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                return Float.compare(this.f7185a, fVar.f7185a) == 0 && Float.compare(this.b, fVar.b) == 0;
            }

            public int hashCode() {
                return (Float.hashCode(this.f7185a) * 31) + Float.hashCode(this.b);
            }

            public String toString() {
                return "Position(topLeftXDp=" + this.f7185a + ", topLeftYDp=" + this.b + ')';
            }

            public final f a(float f, float f2) {
                return new f(f, f2);
            }

            public static /* synthetic */ f a(f fVar, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = fVar.f7185a;
                }
                if ((i & 2) != 0) {
                    f2 = fVar.b;
                }
                return fVar.a(f, f2);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$g */
        public static final class g {
            public static final int c = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f7186a;
            public final float b;

            public g(float f, float f2) {
                this.f7186a = f;
                this.b = f2;
            }

            public final float a() {
                return this.f7186a;
            }

            public final float b() {
                return this.b;
            }

            public final float c() {
                return this.b;
            }

            public final float d() {
                return this.f7186a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof g)) {
                    return false;
                }
                g gVar = (g) obj;
                return Float.compare(this.f7186a, gVar.f7186a) == 0 && Float.compare(this.b, gVar.b) == 0;
            }

            public int hashCode() {
                return (Float.hashCode(this.f7186a) * 31) + Float.hashCode(this.b);
            }

            public String toString() {
                return "Size(widthDp=" + this.f7186a + ", heightDp=" + this.b + ')';
            }

            public final g a(float f, float f2) {
                return new g(f, f2);
            }

            public static /* synthetic */ g a(g gVar, float f, float f2, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = gVar.f7186a;
                }
                if ((i & 2) != 0) {
                    f2 = gVar.b;
                }
                return gVar.a(f, f2);
            }
        }

        public /* synthetic */ AbstractC0705a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a$a$d */
        public static final class d extends AbstractC0705a {
            public static final int f = 8;
            public final f b;
            public final f c;
            public final g d;
            public final List<c> e;

            public /* synthetic */ d(f fVar, f fVar2, g gVar, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fVar, (i & 2) != 0 ? null : fVar2, (i & 4) != 0 ? null : gVar, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final List<c> a() {
                return this.e;
            }

            public final f b() {
                return this.b;
            }

            public final f c() {
                return this.c;
            }

            public final g d() {
                return this.d;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(f clickPosition, f fVar, g gVar, List<c> buttonLayout) {
                super(null);
                Intrinsics.checkNotNullParameter(clickPosition, "clickPosition");
                Intrinsics.checkNotNullParameter(buttonLayout, "buttonLayout");
                this.b = clickPosition;
                this.c = fVar;
                this.d = gVar;
                this.e = buttonLayout;
            }
        }

        public AbstractC0705a() {
        }
    }

    Object a(long j, AbstractC0705a abstractC0705a, String str, Continuation<? super String> continuation);
}
