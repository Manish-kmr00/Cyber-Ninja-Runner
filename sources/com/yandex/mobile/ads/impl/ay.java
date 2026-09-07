package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public interface ay {

    public static final class d implements ay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f8455a;

        public d(Uri reportUri) {
            Intrinsics.checkNotNullParameter(reportUri, "reportUri");
            this.f8455a = reportUri;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.areEqual(this.f8455a, ((d) obj).f8455a);
        }

        public final int hashCode() {
            return this.f8455a.hashCode();
        }

        public final String toString() {
            return "ShareReport(reportUri=" + this.f8455a + ")";
        }

        public final Uri a() {
            return this.f8455a;
        }
    }

    public static final class c implements ay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8454a;

        public c(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.f8454a = text;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.f8454a, ((c) obj).f8454a);
        }

        public final int hashCode() {
            return this.f8454a.hashCode();
        }

        public final String toString() {
            return "Message(text=" + this.f8454a + ")";
        }

        public final String a() {
            return this.f8454a;
        }
    }

    public static final class e implements ay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8456a;
        private final String b;

        public e(String message) {
            Intrinsics.checkNotNullParameter(HttpHeaders.WARNING, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            this.f8456a = HttpHeaders.WARNING;
            this.b = message;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Intrinsics.areEqual(this.f8456a, eVar.f8456a) && Intrinsics.areEqual(this.b, eVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f8456a.hashCode() * 31);
        }

        public final String toString() {
            return "Warning(title=" + this.f8456a + ", message=" + this.b + ")";
        }

        public final String a() {
            return this.b;
        }
    }

    public static final class b implements ay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8453a = new b();

        private b() {
        }
    }

    public static final class a implements ay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8452a = new a();

        private a() {
        }
    }
}
