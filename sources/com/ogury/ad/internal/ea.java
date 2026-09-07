package com.ogury.ad.internal;

import android.app.Activity;
import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t7 f7294a = t7.f7405a;

    public static void a(Context context, l6 l6Var) {
        List<Activity> listA = a.a(context);
        r2.a("Displaying whitelisted activities");
        boolean z = true;
        for (Activity activity : listA) {
            if (l6Var.a(activity)) {
                r2.a("Whitelisted: " + activity.getClass().getName());
                z = false;
            }
        }
        if (z) {
            r2.a("No activity is whitelisted");
        }
    }
}
