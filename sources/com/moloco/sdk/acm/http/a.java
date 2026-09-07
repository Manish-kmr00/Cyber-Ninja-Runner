package com.moloco.sdk.acm.http;

import io.ktor.http.HeadersBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.acm.http.a$a, reason: collision with other inner class name */
    public static final class C0528a extends Lambda implements Function1<HeadersBuilder, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6036a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0528a(String str, String str2, String str3, String str4, String str5, String str6) {
            super(1);
            this.f6036a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
        }

        public final void a(HeadersBuilder headersBuilder) {
            Intrinsics.checkNotNullParameter(headersBuilder, "$this$null");
            StringBuilder sb = new StringBuilder();
            String str = this.f6036a;
            String str2 = this.b;
            String str3 = this.c;
            if (str != null) {
                sb.append("AppBundle/" + str + ';');
            }
            if (str2 != null) {
                sb.append("AppVersion/" + str2 + ';');
            }
            if (str3 != null) {
                sb.append("AppKey/" + str3 + ';');
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply {\n…\") }\n        }.toString()");
            StringBuilder sb2 = new StringBuilder();
            String str4 = this.d;
            String str5 = this.e;
            if (str4 != null) {
                sb2.append("SdkVersion/" + str4 + ';');
            }
            if (str5 != null) {
                sb2.append("Mediator/" + str5 + ';');
            }
            String string2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply {\n…\") }\n        }.toString()");
            StringBuilder sb3 = new StringBuilder("OS/Android;");
            String str6 = this.f;
            if (str6 != null) {
                sb3.append("osv/" + str6 + ';');
            }
            String string3 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "StringBuilder().apply {\n…\") }\n        }.toString()");
            headersBuilder.append("X-Moloco-App-Info", string);
            headersBuilder.append("X-Moloco-Device-Info", string3);
            headersBuilder.append("X-Moloco-SDK-Info", string2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HeadersBuilder headersBuilder) {
            a(headersBuilder);
            return Unit.INSTANCE;
        }
    }

    public final Function1<HeadersBuilder, Unit> a(String str, String str2, String str3, String str4, String str5, String str6) {
        return new C0528a(str4, str5, str3, str, str6, str2);
    }
}
