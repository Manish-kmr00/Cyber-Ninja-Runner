package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ta0 f8516a;
    private final bh b;
    private final r02 c;

    public final Set<uj0> a(List<? extends ig<?>> assets, rr0 rr0Var) {
        Object next;
        List listEmptyList;
        x xVar;
        List<uj0> listEmptyList2;
        y20 y20VarC;
        List<x> listA;
        Object next2;
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.b.getClass();
        Set<uj0> mutableSet = CollectionsKt.toMutableSet(bh.a(assets));
        Iterator<T> it = assets.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((ig) next).b(), "feedback"));
        ig igVar = (ig) next;
        this.f8516a.getClass();
        if (igVar == null || !(igVar.d() instanceof wa0)) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            List listListOfNotNull = CollectionsKt.listOfNotNull(((wa0) igVar.d()).a());
            rr0 rr0VarA = igVar.a();
            if (rr0VarA == null || (listA = rr0VarA.a()) == null) {
                xVar = null;
            } else {
                Iterator<T> it2 = listA.iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (!Intrinsics.areEqual(((x) next2).a(), "divkit_adtune"));
                xVar = (x) next2;
            }
            k20 k20Var = xVar instanceof k20 ? (k20) xVar : null;
            if (k20Var == null || (y20VarC = k20Var.c()) == null || (listEmptyList2 = y20VarC.d()) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            listEmptyList = CollectionsKt.plus((Collection) listListOfNotNull, (Iterable) listEmptyList2);
        }
        mutableSet.addAll(listEmptyList);
        this.c.getClass();
        mutableSet.addAll(r02.a(assets, rr0Var));
        return mutableSet;
    }

    public /* synthetic */ bk0() {
        this(new ta0(), new bh(), new r02());
    }

    public bk0(ta0 feedbackImageProvider, bh assetsImagesProvider, r02 socialActionImageProvider) {
        Intrinsics.checkNotNullParameter(feedbackImageProvider, "feedbackImageProvider");
        Intrinsics.checkNotNullParameter(assetsImagesProvider, "assetsImagesProvider");
        Intrinsics.checkNotNullParameter(socialActionImageProvider, "socialActionImageProvider");
        this.f8516a = feedbackImageProvider;
        this.b = assetsImagesProvider;
        this.c = socialActionImageProvider;
    }
}
