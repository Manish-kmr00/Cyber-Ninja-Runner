package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.UserManager;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ux1 {
    public static SharedPreferences a(ux1 ux1Var, Context context, String prefName) {
        Object objM7904constructorimpl;
        ux1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefName, "prefName");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = context.getSystemService(POBConstants.KEY_USER);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.UserManager");
            objM7904constructorimpl = Result.m7904constructorimpl(Boolean.valueOf(((UserManager) systemService).isUserUnlocked()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.TRUE;
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = bool;
        }
        if (((Boolean) objM7904constructorimpl).booleanValue()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(prefName, 0);
            Intrinsics.checkNotNull(sharedPreferences);
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.createDeviceProtectedStorageContext().getSharedPreferences(prefName, 0);
        Intrinsics.checkNotNull(sharedPreferences2);
        return sharedPreferences2;
    }
}
