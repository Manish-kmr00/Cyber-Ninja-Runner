package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class c22 {
    private static boolean a(StackTraceElement stackTraceElement, Set set) {
        ArrayList<b60> arrayList = new ArrayList();
        for (Object obj : set) {
            if (((b60) obj).a() == c60.b) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (b60 b60Var : arrayList) {
            String string = stackTraceElement.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (StringsKt.contains$default((CharSequence) string, (CharSequence) b60Var.b(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(StackTraceElement[] stackTraceElementArr, Set exclusions) {
        String className;
        StackTraceElement stackTraceElement;
        String className2;
        StackTraceElement stackTraceElement2;
        String className3;
        Intrinsics.checkNotNullParameter(stackTraceElementArr, "<this>");
        Intrinsics.checkNotNullParameter(exclusions, "exclusions");
        ArrayList<b60> arrayList = new ArrayList();
        for (Object obj : exclusions) {
            if (((b60) obj).a() == c60.c) {
                arrayList.add(obj);
            }
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            for (b60 b60Var : arrayList) {
                String string = Arrays.toString(stackTraceElementArr);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (StringsKt.contains$default((CharSequence) string, (CharSequence) b60Var.b(), false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            StackTraceElement stackTraceElement3 = stackTraceElementArr[i];
            String className4 = stackTraceElement3.getClassName();
            Intrinsics.checkNotNullExpressionValue(className4, "getClassName(...)");
            if ((StringsKt.startsWith$default(className4, com.safedk.android.utils.h.y, false, 2, (Object) null) || StringsKt.startsWith$default(className4, "com.monetization.ads", false, 2, (Object) null)) && !a(stackTraceElement3, exclusions)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return false;
        }
        do {
            i++;
            StackTraceElement stackTraceElement4 = (StackTraceElement) ArraysKt.getOrNull(stackTraceElementArr, i);
            if (stackTraceElement4 == null || a(stackTraceElement4, exclusions) || (stackTraceElement = (StackTraceElement) ArraysKt.getOrNull(stackTraceElementArr, i)) == null || (className2 = stackTraceElement.getClassName()) == null || ((!StringsKt.startsWith$default(className2, com.safedk.android.utils.h.y, false, 2, (Object) null) && !StringsKt.startsWith$default(className2, "com.monetization.ads", false, 2, (Object) null)) || (stackTraceElement2 = (StackTraceElement) ArraysKt.getOrNull(stackTraceElementArr, i)) == null || (className3 = stackTraceElement2.getClassName()) == null)) {
                break;
            }
        } while (!Intrinsics.areEqual(className3, CallbackStackTraceMarker.class.getName()));
        StackTraceElement stackTraceElement5 = (StackTraceElement) ArraysKt.getOrNull(stackTraceElementArr, i);
        if (stackTraceElement5 != null && (className = stackTraceElement5.getClassName()) != null && Intrinsics.areEqual(className, CallbackStackTraceMarker.class.getName())) {
            z = true;
        }
        return !z;
    }
}
