package com.yandex.yatagan.internal;

import com.amazon.aps.shared.util.APSSharedUtil;
import com.json.m5;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: checks.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u0082\u0002\n\n\b\b\u0000\u001a\u0004\b\u0003\u0010\u0001\u001a!\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u0001H\u0007H\u0007¢\u0006\u0002\u0010\t\u001a!\u0010\n\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u0001H\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0007\u001a&\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0012H\u0007¨\u0006\u0013"}, d2 = {"assertNotNull", "", m5.p, "", "message", "", "checkInputNotNull", "T", "input", "(Ljava/lang/Object;)Ljava/lang/Object;", "checkProvisionNotNull", "reportMissingAutoBuilderInput", "", "missingInputClass", "Ljava/lang/Class;", "reportUnexpectedAutoBuilderInput", "inputClass", "expectedClasses", "", "public"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Checks {
    public static final void assertNotNull(Object obj, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (obj == null) {
            throw new IllegalStateException(message);
        }
    }

    public static final <T> T checkInputNotNull(T t) {
        assertNotNull(t, "Component input is null or unspecified");
        return t;
    }

    public static final <T> T checkProvisionNotNull(T t) {
        assertNotNull(t, "Provision result is null");
        return t;
    }

    public static final Void reportUnexpectedAutoBuilderInput(Class<?> inputClass, Iterable<? extends Class<?>> expectedClasses) {
        Intrinsics.checkNotNullParameter(inputClass, "inputClass");
        Intrinsics.checkNotNullParameter(expectedClasses, "expectedClasses");
        if (CollectionsKt.none(expectedClasses)) {
            throw new IllegalArgumentException("No inputs are expected, got " + inputClass.getCanonicalName());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument of ").append(inputClass).append(" is not expected. Should be one of: ");
        CollectionsKt.joinTo(expectedClasses, sb, (Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE & 2) != 0 ? ", " : null, (Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE & 4) != 0 ? "" : null, (Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE & 8) != 0 ? "" : null, (Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE & 16) != 0 ? -1 : 0, (Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE & 32) != 0 ? APSSharedUtil.TRUNCATE_SEPARATOR : null, (Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE & 64) != 0 ? null : new Function1<Class<?>, CharSequence>() { // from class: com.yandex.yatagan.internal.Checks$reportUnexpectedAutoBuilderInput$1$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Class<?> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String canonicalName = it.getCanonicalName();
                Intrinsics.checkNotNullExpressionValue(canonicalName, "it.canonicalName");
                return canonicalName;
            }
        });
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalArgumentException(string);
    }

    public static final Void reportMissingAutoBuilderInput(Class<?> missingInputClass) {
        Intrinsics.checkNotNullParameter(missingInputClass, "missingInputClass");
        throw new IllegalStateException("Can not create component instance as (at least) the following required input is missing: " + missingInputClass.getCanonicalName());
    }
}
