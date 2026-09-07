package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ek0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bk0 f8807a;
    private final pb1 b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<uj0> f8808a;
        private final Set<uj0> b;
        private final Set<uj0> c;

        public a(HashSet imagesToLoad, Set imagesToLoadPreview, Set imagesToLoadInBack) {
            Intrinsics.checkNotNullParameter(imagesToLoad, "imagesToLoad");
            Intrinsics.checkNotNullParameter(imagesToLoadPreview, "imagesToLoadPreview");
            Intrinsics.checkNotNullParameter(imagesToLoadInBack, "imagesToLoadInBack");
            this.f8808a = imagesToLoad;
            this.b = imagesToLoadPreview;
            this.c = imagesToLoadInBack;
        }

        public final Set<uj0> a() {
            return this.f8808a;
        }

        public final Set<uj0> b() {
            return this.b;
        }

        public final Set<uj0> c() {
            return this.c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f8808a, aVar.f8808a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final int hashCode() {
            return this.c.hashCode() + ((this.b.hashCode() + (this.f8808a.hashCode() * 31)) * 31);
        }

        public final String toString() {
            return "Images(imagesToLoad=" + this.f8808a + ", imagesToLoadPreview=" + this.b + ", imagesToLoadInBack=" + this.c + ")";
        }
    }

    public final a a(o41 nativeAdBlock) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        o8<?> o8VarB = nativeAdBlock.b();
        u61 nativeAdResponse = nativeAdBlock.c();
        List<c41> nativeAds = nativeAdResponse.e();
        bk0 bk0Var = this.f8807a;
        bk0Var.getClass();
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nativeAds, 10));
        for (c41 c41Var : nativeAds) {
            arrayList.add(bk0Var.a(c41Var.b(), c41Var.e()));
        }
        Set set = CollectionsKt.toSet(CollectionsKt.flatten(arrayList));
        this.f8807a.getClass();
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        List<y20> listC = nativeAdResponse.c();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            List<uj0> listD = ((y20) it.next()).d();
            if (listD != null) {
                arrayList2.add(listD);
            }
        }
        Set setPlus = SetsKt.plus(set, (Iterable) CollectionsKt.toSet(CollectionsKt.flatten(arrayList2)));
        Set<uj0> setC = this.b.c(nativeAdResponse);
        Set setPlus2 = SetsKt.plus(setPlus, (Iterable) setC);
        if (!o8VarB.Q()) {
            setPlus = null;
        }
        if (setPlus == null) {
            setPlus = SetsKt.emptySet();
        }
        Set setPlus3 = SetsKt.plus((Set) setC, (Iterable) setPlus);
        HashSet hashSet = new HashSet();
        for (Object obj : setPlus3) {
            if (((uj0) obj).b()) {
                hashSet.add(obj);
            }
        }
        return new a(hashSet, setPlus2, SetsKt.minus(setPlus2, (Iterable) hashSet));
    }

    public /* synthetic */ ek0() {
        this(new bk0(), new pb1());
    }

    public ek0(bk0 imageValuesProvider, pb1 nativeVideoUrlsProvider) {
        Intrinsics.checkNotNullParameter(imageValuesProvider, "imageValuesProvider");
        Intrinsics.checkNotNullParameter(nativeVideoUrlsProvider, "nativeVideoUrlsProvider");
        this.f8807a = imageValuesProvider;
        this.b = nativeVideoUrlsProvider;
    }
}
