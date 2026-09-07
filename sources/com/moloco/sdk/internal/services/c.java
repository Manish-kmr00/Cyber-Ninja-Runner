package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c {

    public static final class a extends c {
        public static final int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6354a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.f6354a = id;
        }

        public final String a() {
            return this.f6354a;
        }

        public final String b() {
            return this.f6354a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f6354a, ((a) obj).f6354a);
        }

        public int hashCode() {
            return this.f6354a.hashCode();
        }

        public String toString() {
            return "Available(id=" + this.f6354a + ')';
        }

        public final a a(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new a(id);
        }

        public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.f6354a;
            }
            return aVar.a(str);
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6355a = new b();
        public static final int b = 0;

        public b() {
            super(null);
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public c() {
    }
}
