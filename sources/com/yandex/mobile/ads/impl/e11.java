package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e11 {
    public static a a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        w01 w01Var = new w01();
        i1 i1Var = new i1();
        Cif cif = new Cif();
        xo0[] xo0VarArr = new xo0[4];
        xo0 e = null;
        try {
            w01Var.a(d11.a.b);
            e = null;
        } catch (xo0 e2) {
            e = e2;
        }
        xo0VarArr[0] = e;
        try {
            i1Var.a(context);
            e = null;
        } catch (xo0 e3) {
            e = e3;
        }
        xo0VarArr[1] = e;
        try {
            qg1.a(context);
            e = null;
        } catch (xo0 e4) {
            e = e4;
        }
        xo0VarArr[2] = e;
        try {
            cif.a();
        } catch (xo0 e5) {
            e = e5;
        }
        xo0VarArr[3] = e;
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) xo0VarArr);
        return !listListOfNotNull.isEmpty() ? new a.b(listListOfNotNull) : a.C0741a.f8751a;
    }

    public interface a {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.e11$a$a, reason: collision with other inner class name */
        public static final class C0741a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0741a f8751a = new C0741a();

            private C0741a() {
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<xo0> f8752a;

            public b(List<xo0> causes) {
                Intrinsics.checkNotNullParameter(causes, "causes");
                this.f8752a = causes;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.areEqual(this.f8752a, ((b) obj).f8752a);
            }

            public final int hashCode() {
                return this.f8752a.hashCode();
            }

            public final String toString() {
                return "IncorrectIntegration(causes=" + this.f8752a + ")";
            }

            public final List<xo0> a() {
                return this.f8752a;
            }
        }
    }
}
