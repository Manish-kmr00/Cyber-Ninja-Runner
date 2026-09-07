package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ek2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eb2 f8809a;
    private final ck2 b;
    private final dk2 c;
    private final fk2 d;
    private final Context e;

    public final ArrayList a(List videoAds) {
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(videoAds, 10));
        Iterator it = videoAds.iterator();
        while (it.hasNext()) {
            eb2 inlineVideoAd = (eb2) it.next();
            ArrayList arrayListA = this.b.a(inlineVideoAd);
            dk2 dk2Var = this.c;
            eb2 wrapperVideoAd = this.f8809a;
            dk2Var.getClass();
            Intrinsics.checkNotNullParameter(inlineVideoAd, "videoAd");
            Intrinsics.checkNotNullParameter(wrapperVideoAd, "wrapperVideoAd");
            mb2 mb2VarL = inlineVideoAd.l();
            mb2 mb2VarL2 = wrapperVideoAd.l();
            mb2 mb2VarA = new mb2.a().a(CollectionsKt.plus((Collection) mb2VarL.a(), (Iterable) mb2VarL2.a())).b(CollectionsKt.plus((Collection) mb2VarL.b(), (Iterable) mb2VarL2.b())).a();
            fk2 fk2Var = this.d;
            eb2 wrapperVideoAd2 = this.f8809a;
            fk2Var.getClass();
            Intrinsics.checkNotNullParameter(inlineVideoAd, "inlineVideoAd");
            Intrinsics.checkNotNullParameter(wrapperVideoAd2, "wrapperVideoAd");
            List listListOf = CollectionsKt.listOf((Object[]) new eb2[]{inlineVideoAd, wrapperVideoAd2});
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = listListOf.iterator();
            while (it2.hasNext()) {
                rh2 rh2VarM = ((eb2) it2.next()).m();
                List<String> listA = rh2VarM != null ? rh2VarM.a() : null;
                if (listA == null) {
                    listA = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList2, listA);
            }
            rh2 rh2Var = new rh2(arrayList2);
            Map<String, List<String>> mapH = inlineVideoAd.h();
            Map<String, List<String>> mapH2 = this.f8809a.h();
            List listPlus = CollectionsKt.plus((Collection) inlineVideoAd.d(), (Iterable) this.f8809a.d());
            Context context = this.e;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            arrayList.add(new eb2.a(context, inlineVideoAd.o()).f(inlineVideoAd.g()).a(arrayListA).a(mapH).c(inlineVideoAd.b()).d(inlineVideoAd.c()).e(inlineVideoAd.f()).g(inlineVideoAd.j()).h(inlineVideoAd.k()).a(mb2VarA).a(rh2Var).a(inlineVideoAd.n()).a(mapH2).a(listPlus).a());
        }
        return arrayList;
    }

    public /* synthetic */ ek2(Context context, eb2 eb2Var) {
        this(context, eb2Var, new ck2(eb2Var), new dk2(), new fk2());
    }

    public ek2(Context context, eb2 wrapperVideoAd, ck2 wrappedAdCreativesCreator, dk2 wrappedAdExtensionsCreator, fk2 wrappedViewableImpressionCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrapperVideoAd, "wrapperVideoAd");
        Intrinsics.checkNotNullParameter(wrappedAdCreativesCreator, "wrappedAdCreativesCreator");
        Intrinsics.checkNotNullParameter(wrappedAdExtensionsCreator, "wrappedAdExtensionsCreator");
        Intrinsics.checkNotNullParameter(wrappedViewableImpressionCreator, "wrappedViewableImpressionCreator");
        this.f8809a = wrapperVideoAd;
        this.b = wrappedAdCreativesCreator;
        this.c = wrappedAdExtensionsCreator;
        this.d = wrappedViewableImpressionCreator;
        this.e = context.getApplicationContext();
    }
}
