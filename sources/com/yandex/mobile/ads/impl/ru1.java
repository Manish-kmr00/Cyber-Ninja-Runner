package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface ru1 {

    public static final class b implements ru1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cu1 f10143a;
        private final ir b;

        public b(cu1 sdkConfiguration, ir configurationSource) {
            Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
            Intrinsics.checkNotNullParameter(configurationSource, "configurationSource");
            this.f10143a = sdkConfiguration;
            this.b = configurationSource;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f10143a, bVar.f10143a) && this.b == bVar.b;
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f10143a.hashCode() * 31);
        }

        public final String toString() {
            return "Success(sdkConfiguration=" + this.f10143a + ", configurationSource=" + this.b + ")";
        }

        public final cu1 b() {
            return this.f10143a;
        }

        public final ir a() {
            return this.b;
        }
    }

    public static final class a implements ru1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ki2 f10142a;
        private final ir b;

        public a(ki2 error, ir configurationSource) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(configurationSource, "configurationSource");
            this.f10142a = error;
            this.b = configurationSource;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f10142a, aVar.f10142a) && this.b == aVar.b;
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f10142a.hashCode() * 31);
        }

        public final String toString() {
            return "Failure(error=" + this.f10142a + ", configurationSource=" + this.b + ")";
        }

        public final ki2 b() {
            return this.f10142a;
        }

        public final ir a() {
            return this.b;
        }
    }
}
