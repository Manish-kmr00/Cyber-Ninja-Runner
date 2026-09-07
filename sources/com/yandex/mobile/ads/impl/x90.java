package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class x90 {
    private x90() {
    }

    public static final class b extends x90 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cs0 f10631a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(cs0 feedItem) {
            super(0);
            Intrinsics.checkNotNullParameter(feedItem, "feedItem");
            this.f10631a = feedItem;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f10631a, ((b) obj).f10631a);
        }

        public final int hashCode() {
            return this.f10631a.hashCode();
        }

        public final String toString() {
            return "Success(feedItem=" + this.f10631a + ")";
        }

        public final cs0 a() {
            return this.f10631a;
        }
    }

    public static final class a extends x90 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w3 f10630a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w3 adRequestError) {
            super(0);
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            this.f10630a = adRequestError;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f10630a, ((a) obj).f10630a);
        }

        public final int hashCode() {
            return this.f10630a.hashCode();
        }

        public final String toString() {
            return "Failure(adRequestError=" + this.f10630a + ")";
        }

        public final w3 a() {
            return this.f10630a;
        }
    }

    public /* synthetic */ x90(int i) {
        this();
    }
}
