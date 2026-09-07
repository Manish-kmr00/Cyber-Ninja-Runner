package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class rd2 {

    public static final class a extends rd2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kb2 f10097a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kb2 error) {
            super(0);
            Intrinsics.checkNotNullParameter(error, "error");
            this.f10097a = error;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f10097a, ((a) obj).f10097a);
        }

        public final int hashCode() {
            return this.f10097a.hashCode();
        }

        public final String toString() {
            return "Error(error=" + this.f10097a + ")";
        }
    }

    public static final class b extends rd2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<eb2> f10098a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List<eb2> result) {
            super(0);
            Intrinsics.checkNotNullParameter(result, "result");
            this.f10098a = result;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f10098a, ((b) obj).f10098a);
        }

        public final int hashCode() {
            return this.f10098a.hashCode();
        }

        public final String toString() {
            return "Success(result=" + this.f10098a + ")";
        }

        public final List<eb2> a() {
            return this.f10098a;
        }
    }

    private rd2() {
    }

    public /* synthetic */ rd2(int i) {
        this();
    }
}
