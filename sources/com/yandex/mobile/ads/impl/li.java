package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class li {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hg0 f9521a;
    private final fg0 b;

    public final String a(Context context) {
        String str;
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> listA = this.f9521a.a(context);
        if (listA.size() > 1) {
            Iterator it = CollectionsKt.dropLast(listA, 1).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                o82.f9793a.getClass();
                String strA = o82.a.a((String) next);
                if (strA != null && (!StringsKt.isBlank(strA))) {
                    fg0 fg0Var = this.b;
                    int i = fg0.c;
                    if (fg0Var.a(1000, strA)) {
                        break;
                    }
                }
            }
            str = (String) next;
            if (str == null) {
                str = (String) CollectionsKt.last((List) listA);
            }
        } else {
            str = (String) CollectionsKt.firstOrNull((List) listA);
        }
        return str == null ? "mobile.yandexadexchange.net" : str;
    }

    public /* synthetic */ li() {
        this(new hg0(), new fg0());
    }

    public li(hg0 hostsProvider, fg0 hostReachabilityRepository) {
        Intrinsics.checkNotNullParameter(hostsProvider, "hostsProvider");
        Intrinsics.checkNotNullParameter(hostReachabilityRepository, "hostReachabilityRepository");
        this.f9521a = hostsProvider;
        this.b = hostReachabilityRepository;
    }
}
