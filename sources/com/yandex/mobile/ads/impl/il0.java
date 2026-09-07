package com.yandex.mobile.ads.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public interface il0 {

    public static final class c implements il0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f9239a;

        public c(Uri reportUri) {
            Intrinsics.checkNotNullParameter(reportUri, "reportUri");
            this.f9239a = reportUri;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.f9239a, ((c) obj).f9239a);
        }

        public final int hashCode() {
            return this.f9239a.hashCode();
        }

        public final String toString() {
            return "Success(reportUri=" + this.f9239a + ")";
        }

        public final Uri a() {
            return this.f9239a;
        }
    }

    public static final class a implements il0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9237a;

        public a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.f9237a = message;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f9237a, ((a) obj).f9237a);
        }

        public final int hashCode() {
            return this.f9237a.hashCode();
        }

        public final String toString() {
            return "Failure(message=" + this.f9237a + ")";
        }

        public final String a() {
            return this.f9237a;
        }
    }

    public static final class b implements il0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9238a = new b();

        private b() {
        }
    }
}
