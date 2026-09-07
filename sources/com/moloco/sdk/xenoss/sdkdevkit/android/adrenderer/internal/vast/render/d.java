package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7065a = 0;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d$a$a, reason: collision with other inner class name */
        public static final class C0682a extends a {
            public static final C0682a b = new C0682a();
            public static final int c = 0;

            public C0682a() {
                super(null);
            }
        }

        public static final class b extends a {
            public static final int c = 0;
            public final int b;

            public /* synthetic */ b(int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(i);
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
                return (obj instanceof b) && this.b == ((b) obj).b;
            }

            public int hashCode() {
                return UInt.m8013hashCodeimpl(this.b);
            }

            public String toString() {
                return "Countdown(seconds=" + ((Object) UInt.m8047toStringimpl(this.b)) + ')';
            }

            public b(int i) {
                super(null);
                this.b = i;
            }

            public final b a(int i) {
                return new b(i, null);
            }

            public static /* synthetic */ b a(b bVar, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = bVar.b;
                }
                return bVar.a(i);
            }
        }

        public static final class c extends a {
            public static final c b = new c();
            public static final int c = 0;

            public c() {
                super(null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    StateFlow<a> l();
}
