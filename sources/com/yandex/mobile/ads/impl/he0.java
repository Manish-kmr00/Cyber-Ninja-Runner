package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class he0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sx f9085a;

    @DebugMetadata(c = "com.yandex.mobile.ads.features.debugpanel.domain.GetAdUnitDataUseCase", f = "GetAdUnitDataUseCase.kt", i = {0, 0}, l = {17}, m = "invoke", n = {"this", "adUnitId"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {
        he0 b;
        String c;
        /* synthetic */ Object d;
        int f;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return he0.this.a(null, false, this);
        }
    }

    public he0(sx repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.f9085a = repo;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object a(String str, boolean z, Continuation<? super hw> continuation) throws Throwable {
        a aVar;
        he0 he0Var;
        String str2;
        Object next;
        kw kwVar;
        Object next2;
        Object next3;
        String strD;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.f = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            sx sxVar = this.f9085a;
            aVar.b = this;
            aVar.c = str;
            aVar.f = 1;
            objA = sxVar.a(z, aVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            he0Var = this;
            str2 = str;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = aVar.c;
            he0Var = aVar.b;
            ResultKt.throwOnFailure(objA);
        }
        yw ywVar = (yw) objA;
        Iterator<T> it = ywVar.a().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((ew) next).a(), str2));
        ew ewVar = (ew) next;
        if (ewVar == null) {
            return null;
        }
        List<ow> listA = ywVar.b().a();
        iw iwVarC = ewVar.c();
        he0Var.getClass();
        if (iwVarC == null) {
            kwVar = new kw(CollectionsKt.emptyList());
        } else {
            List<fw> listB = iwVarC.b();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
            for (fw fwVar : listB) {
                Iterator<T> it2 = listA.iterator();
                do {
                    if (!it2.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it2.next();
                } while (!Intrinsics.areEqual(((ow) next3).e(), fwVar.e()));
                ow owVar = (ow) next3;
                String str3 = (owVar == null || (strD = owVar.d()) == null) ? "" : strD;
                List<vw> listC = fwVar.c();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
                for (vw vwVar : listC) {
                    arrayList2.add(new mx(vwVar.a(), vwVar.b()));
                }
                arrayList.add(new jw(str3, fwVar.e(), arrayList2, fwVar.b(), fwVar.d(), jw.a.C0749a.f9353a));
            }
            List<lw> listC2 = iwVarC.c();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC2, 10));
            for (lw lwVar : listC2) {
                Iterator<T> it3 = listA.iterator();
                do {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                } while (!Intrinsics.areEqual(((ow) next2).e(), lwVar.e()));
                ow owVar2 = (ow) next2;
                String strD2 = owVar2 != null ? owVar2.d() : null;
                String str4 = strD2 == null ? "" : strD2;
                List<ky> listF = lwVar.f();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listF, 10));
                for (ky kyVar : listF) {
                    arrayList4.add(new mx(kyVar.a(), kyVar.b()));
                }
                arrayList3.add(new jw(str4, lwVar.e(), arrayList4, null, lwVar.d(), new jw.a.b(lwVar.c(), lwVar.b())));
            }
            kwVar = new kw(CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList3));
        }
        return new hw(ewVar.d(), ewVar.b(), str2, kwVar);
    }
}
