package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class vk1 {

    public static final class b extends vk1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k90 f10489a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k90 feedItem) {
            super(0);
            Intrinsics.checkNotNullParameter(feedItem, "feedItem");
            this.f10489a = feedItem;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual(this.f10489a, ((b) obj).f10489a);
        }

        public final int hashCode() {
            return this.f10489a.hashCode();
        }

        public final String toString() {
            return "Success(feedItem=" + this.f10489a + ")";
        }
    }

    private vk1() {
    }

    public static final class a extends vk1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w3 f10488a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w3 adRequestError) {
            super(0);
            Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
            this.f10488a = adRequestError;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f10488a, ((a) obj).f10488a);
        }

        public final int hashCode() {
            return this.f10488a.hashCode();
        }

        public final String toString() {
            return "Failure(adRequestError=" + this.f10488a + ")";
        }

        public final w3 a() {
            return this.f10488a;
        }
    }

    public /* synthetic */ vk1(int i) {
        this();
    }
}
