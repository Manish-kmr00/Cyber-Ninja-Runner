package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3060h {
    public static TokenParametersOuterClass$TokenParameters.NullableString a(String str) {
        y yVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableString.newBuilder();
        if (!TextUtils.isEmpty(str)) {
            yVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableString) yVarNewBuilder.b).setData(str);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableString) yVarNewBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableBool a(Boolean bool) {
        v vVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableBool.newBuilder();
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            vVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableBool) vVarNewBuilder.b).setData(zBooleanValue);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableBool) vVarNewBuilder.a();
    }

    public static TokenParametersOuterClass$TokenParameters.NullableUInt32 a(int i) {
        z zVarNewBuilder = TokenParametersOuterClass$TokenParameters.NullableUInt32.newBuilder();
        if (i > 0) {
            zVarNewBuilder.c();
            ((TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder.b).setData(i);
        }
        return (TokenParametersOuterClass$TokenParameters.NullableUInt32) zVarNewBuilder.a();
    }
}
