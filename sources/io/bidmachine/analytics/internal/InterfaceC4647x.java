package io.bidmachine.analytics.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.bidmachine.analytics.internal.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public interface InterfaceC4647x extends IInterface {

    /* JADX INFO: renamed from: io.bidmachine.analytics.internal.x$a */
    public static final class a implements InterfaceC4647x {
        public static final d d = new d(null);
        private static final Lazy e = LazyKt.lazy(c.f12180a);
        private static final b f;
        private static final b g;
        private static final b h;
        private static final b i;
        private static final b j;
        private static final b k;
        private static final b l;
        private static final b m;
        private static final b n;
        private static final b o;
        private static final b p;
        private static final b q;
        private static final b r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f12177a;
        private b b;
        private final Function0 c;

        /* JADX INFO: renamed from: io.bidmachine.analytics.internal.x$a$a, reason: collision with other inner class name */
        static final class C0777a extends Lambda implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0777a f12178a = new C0777a();

            C0777a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Parcel invoke() {
                return Parcel.obtain();
            }
        }

        /* JADX INFO: renamed from: io.bidmachine.analytics.internal.x$a$b */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f12179a;
            private final int b;
            private final int c;
            private final int d;
            private final int e;
            private final int f;
            private final int g;
            private final int h;

            public b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f12179a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
                this.e = i5;
                this.f = i6;
                this.g = i7;
                this.h = i8;
            }

            public final b a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                return new b(i, i2, i3, i4, i5, i6, i7, i8);
            }

            public final int b() {
                return this.h;
            }

            public final int c() {
                return this.f;
            }

            public final int d() {
                return this.b;
            }

            public final int e() {
                return this.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f12179a == bVar.f12179a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h;
            }

            public final int f() {
                return this.g;
            }

            public final int g() {
                return this.e;
            }

            public final int h() {
                return this.f12179a;
            }

            public int hashCode() {
                return (((((((((((((Integer.hashCode(this.f12179a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h);
            }

            public String toString() {
                return super.toString();
            }

            public static /* synthetic */ b a(b bVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
                return bVar.a((i9 & 1) != 0 ? bVar.f12179a : i, (i9 & 2) != 0 ? bVar.b : i2, (i9 & 4) != 0 ? bVar.c : i3, (i9 & 8) != 0 ? bVar.d : i4, (i9 & 16) != 0 ? bVar.e : i5, (i9 & 32) != 0 ? bVar.f : i6, (i9 & 64) != 0 ? bVar.g : i7, (i9 & 128) != 0 ? bVar.h : i8);
            }

            public final int a() {
                return this.d;
            }
        }

        /* JADX INFO: renamed from: io.bidmachine.analytics.internal.x$a$c */
        static final class c extends Lambda implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f12180a = new c();

            c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return s0.a("Y29tLmFuZHJvaWQudmVuZGluZy5iaWxsaW5nLklJbkFwcEJpbGxpbmdTZXJ2aWNl");
            }
        }

        /* JADX INFO: renamed from: io.bidmachine.analytics.internal.x$a$d */
        public static final class d {
            private d() {
            }

            public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(t0 t0Var) {
                if (t0Var.compareTo(new t0(5, 1, 0)) < 0) {
                    return b();
                }
                if (t0Var.compareTo(new t0(5, 2, 0)) < 0) {
                    return c();
                }
                if (t0Var.compareTo(new t0(5, 2, 1)) < 0) {
                    return d();
                }
                if (t0Var.compareTo(new t0(6, 0, 0)) < 0) {
                    return e();
                }
                if (t0Var.compareTo(new t0(6, 0, 1)) < 0) {
                    return f();
                }
                if (t0Var.compareTo(new t0(6, 1, 0)) < 0) {
                    return g();
                }
                if (t0Var.compareTo(new t0(6, 2, 0)) < 0) {
                    return h();
                }
                if (t0Var.compareTo(new t0(6, 2, 1)) < 0) {
                    return i();
                }
                if (t0Var.compareTo(new t0(7, 0, 0)) < 0) {
                    return j();
                }
                if (t0Var.compareTo(new t0(7, 1, 0)) < 0) {
                    return k();
                }
                if (t0Var.compareTo(new t0(7, 1, 1)) < 0) {
                    return l();
                }
                return t0Var.compareTo(new t0(7, 2, 0)) < 0 ? m() : n();
            }

            public final b b() {
                return a.g;
            }

            public final b c() {
                return a.h;
            }

            public final b d() {
                return a.i;
            }

            public final b e() {
                return a.j;
            }

            public final b f() {
                return a.k;
            }

            public final b g() {
                return a.l;
            }

            public final b h() {
                return a.m;
            }

            public final b i() {
                return a.n;
            }

            public final b j() {
                return a.o;
            }

            public final b k() {
                return a.p;
            }

            public final b l() {
                return a.q;
            }

            public final b m() {
                return a.r;
            }

            public final b n() {
                return a.f;
            }

            public final String a() {
                return (String) a.e.getValue();
            }
        }

        static {
            b bVar = new b(1, 23, 11, 19, 9, 6, 901, 20);
            f = bVar;
            b bVarA = b.a(bVar, 0, 17, 0, 9, 0, 0, 0, 17, 117, null);
            g = bVarA;
            h = bVarA;
            b bVarA2 = b.a(bVarA, 0, 19, 0, 19, 0, 0, 0, 0, 245, null);
            i = bVarA2;
            j = bVarA2;
            b bVarA3 = b.a(bVarA2, 0, 20, 0, 0, 0, 0, 0, 20, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, null);
            k = bVarA3;
            l = bVarA3;
            b bVarA4 = b.a(bVarA3, 0, 21, 0, 0, 0, 0, 0, 0, 253, null);
            m = bVarA4;
            b bVarA5 = b.a(bVarA4, 0, 22, 0, 0, 0, 0, 0, 0, 253, null);
            n = bVarA5;
            o = bVarA5;
            p = bVarA5;
            b bVarA6 = b.a(bVarA5, 0, 23, 0, 0, 0, 0, 0, 0, 253, null);
            q = bVarA6;
            r = b.a(bVarA6, 0, 23, 0, 0, 0, 0, 0, 0, 253, null);
        }

        public a(IBinder iBinder, b bVar, Function0 function0) {
            this.f12177a = iBinder;
            this.b = bVar;
            this.c = function0;
        }

        private final Parcel o() {
            Parcel parcel = (Parcel) this.c.invoke();
            parcel.writeInterfaceToken(d.a());
            return parcel;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f12177a;
        }

        public /* synthetic */ a(IBinder iBinder, b bVar, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(iBinder, bVar, (i2 & 4) != 0 ? C0777a.f12178a : function0);
        }

        private final void a(Parcel parcel, Parcelable parcelable) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4647x
        public Bundle b(String str, String str2, Bundle bundle) {
            Parcel parcelO = o();
            parcelO.writeInt(this.b.c());
            parcelO.writeString(str);
            parcelO.writeString(str2);
            parcelO.writeString(null);
            a(parcelO, bundle);
            Parcel parcelA = a(this.b.g(), parcelO);
            Bundle bundle2 = (Bundle) a(parcelA, Bundle.CREATOR);
            parcelA.recycle();
            return bundle2;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4647x
        public Bundle a(String str, String str2, Bundle bundle) {
            Parcel parcelO = o();
            parcelO.writeInt(this.b.a());
            parcelO.writeString(str);
            parcelO.writeString(str2);
            parcelO.writeString(null);
            a(parcelO, bundle);
            Parcel parcelA = a(this.b.e(), parcelO);
            Bundle bundle2 = (Bundle) a(parcelA, Bundle.CREATOR);
            parcelA.recycle();
            return bundle2;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4647x
        public Bundle a(String str, String str2, Bundle bundle, Bundle bundle2) {
            Parcel parcelO = o();
            parcelO.writeInt(this.b.b());
            parcelO.writeString(str);
            parcelO.writeString(str2);
            a(parcelO, bundle);
            a(parcelO, bundle2);
            Parcel parcelA = a(this.b.f(), parcelO);
            Bundle bundle3 = (Bundle) a(parcelA, Bundle.CREATOR);
            parcelA.recycle();
            return bundle3;
        }

        @Override // io.bidmachine.analytics.internal.InterfaceC4647x
        public int a(String str, String str2) {
            Parcel parcelO = o();
            parcelO.writeInt(this.b.d());
            parcelO.writeString(str);
            parcelO.writeString(str2);
            Parcel parcelA = a(this.b.h(), parcelO);
            int i2 = parcelA.readInt();
            parcelA.recycle();
            return i2;
        }

        private final Parcelable a(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() == 0) {
                return null;
            }
            Object objCreateFromParcel = creator.createFromParcel(parcel);
            Intrinsics.checkNotNull(objCreateFromParcel, "null cannot be cast to non-null type android.os.Parcelable");
            return (Parcelable) objCreateFromParcel;
        }

        public final Parcel a(int i2, Parcel parcel) {
            Parcel parcel2 = (Parcel) this.c.invoke();
            try {
                try {
                    this.f12177a.transact(i2, parcel, parcel2, 0);
                    parcel2.readException();
                    parcel.recycle();
                    return parcel2;
                } catch (RuntimeException e2) {
                    parcel2.recycle();
                    throw e2;
                }
            } catch (Throwable th) {
                parcel.recycle();
                throw th;
            }
        }
    }

    int a(String str, String str2);

    Bundle a(String str, String str2, Bundle bundle);

    Bundle a(String str, String str2, Bundle bundle, Bundle bundle2);

    Bundle b(String str, String str2, Bundle bundle);
}
