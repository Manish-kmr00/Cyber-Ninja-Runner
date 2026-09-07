package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements UserAgentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7180a = "WebBrowserUserAgentService";
    public final Lazy b = LazyKt.lazy(new a());

    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            try {
                String property = System.getProperty("http.agent");
                if (property != null && !StringsKt.isBlank(property)) {
                    Intrinsics.checkNotNullExpressionValue(property, "{\n                userAgent\n            }");
                    return property;
                }
                return "";
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, c.this.f7180a, e.toString(), null, false, 12, null);
                return "";
            }
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.UserAgentService
    public String invoke() {
        return a();
    }

    public final String a() {
        return (String) this.b.getValue();
    }
}
