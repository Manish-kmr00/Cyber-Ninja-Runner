package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes12.dex */
public final class qg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f10016a = CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});

    public static void a(Context context) throws xo0 {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            List mutableList = CollectionsKt.toMutableList((Collection) f10016a);
            String[] requestedPermissions = packageInfo.requestedPermissions;
            if (requestedPermissions != null) {
                Intrinsics.checkNotNullExpressionValue(requestedPermissions, "requestedPermissions");
                mutableList.removeAll(ArraysKt.toList(requestedPermissions));
                if (mutableList.size() <= 0) {
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("Please, check %s permission in AndroidManifest file.", Arrays.copyOf(new Object[]{mutableList}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                throw new xo0(str, str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
