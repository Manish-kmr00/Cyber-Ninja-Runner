package com.moloco.sdk.internal.services.proto;

import android.util.Base64;
import com.moloco.sdk.UserIntent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6423a = 0;

    @Override // com.moloco.sdk.internal.services.proto.a
    public String a(UserIntent.UserAdInteractionExt input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        String strEncodeToString = Base64.encodeToString(input.toByteArray(), i);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(input.toByteArray(), flags)");
        return strEncodeToString;
    }
}
