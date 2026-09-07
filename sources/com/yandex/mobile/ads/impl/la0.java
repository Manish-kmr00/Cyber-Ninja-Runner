package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class la0 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9492a;
    private final List<a> b;

    public la0(String actionType, ArrayList items) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f9492a = actionType;
        this.b = items;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof la0)) {
            return false;
        }
        la0 la0Var = (la0) obj;
        return Intrinsics.areEqual(this.f9492a, la0Var.f9492a) && Intrinsics.areEqual(this.b, la0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9492a.hashCode() * 31);
    }

    public final String toString() {
        return "FeedbackAction(actionType=" + this.f9492a + ", items=" + this.b + ")";
    }

    @Override // com.yandex.mobile.ads.impl.x
    public final String a() {
        return this.f9492a;
    }

    public final List<a> c() {
        return this.b;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9493a;
        private final String b;

        public a(String title, String url) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(url, "url");
            this.f9493a = title;
            this.b = url;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f9493a, aVar.f9493a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f9493a.hashCode() * 31);
        }

        public final String toString() {
            return "Item(title=" + this.f9493a + ", url=" + this.b + ")";
        }

        public final String a() {
            return this.f9493a;
        }

        public final String b() {
            return this.b;
        }
    }
}
