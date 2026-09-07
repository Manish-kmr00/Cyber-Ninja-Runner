package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9404a;

    public static final class a {
        @JvmStatic
        public static kb2 b(String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new kb2(1, description);
        }

        @JvmStatic
        public static kb2 a(String str) {
            if (str == null) {
                str = "Ad request failed with network error";
            }
            return new kb2(2, str);
        }

        @JvmStatic
        public static kb2 b() {
            Intrinsics.checkNotNullParameter("Server temporarily unavailable. Please, try again later.", "message");
            return new kb2(4, "Server temporarily unavailable. Please, try again later.");
        }

        @JvmStatic
        public static kb2 a(d50 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            String message = error.getMessage();
            if (message == null) {
                message = "Ad request completed successfully, but there are no ads available.";
            }
            return new kb2(3, message);
        }

        @JvmStatic
        public static kb2 a() {
            return new kb2(1, "Internal error. Failed to parse response");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kb2(int i, String errorDescription) {
        this(errorDescription);
        Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
    }

    public final String a() {
        return this.f9404a;
    }

    private kb2(String str) {
        this.f9404a = str;
    }
}
