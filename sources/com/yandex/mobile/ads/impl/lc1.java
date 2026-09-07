package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vb2<gb1> f9500a;
    private final td2 b;

    public /* synthetic */ lc1(Context context, o3 o3Var) {
        this(context, o3Var, new vb2(context, new hb1()), new td2(context, o3Var, new ua1(o3Var), new mf1()));
    }

    public lc1(Context context, o3 adConfiguration, vb2<gb1> videoAdInfoListCreator, td2 videoAdsResponseHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(videoAdInfoListCreator, "videoAdInfoListCreator");
        Intrinsics.checkNotNullParameter(videoAdsResponseHandler, "videoAdsResponseHandler");
        this.f9500a = videoAdInfoListCreator;
        this.b = videoAdsResponseHandler;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object a(lc1 lc1Var, List list, Continuation continuation) throws Throwable {
        jc1 jc1Var;
        lc1Var.getClass();
        if (continuation instanceof jc1) {
            jc1Var = (jc1) continuation;
            int i = jc1Var.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                jc1Var.e = i - Integer.MIN_VALUE;
            } else {
                jc1Var = new jc1(lc1Var, continuation);
            }
        } else {
            jc1Var = new jc1(lc1Var, continuation);
        }
        Object objA = jc1Var.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = jc1Var.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            td2 td2Var = lc1Var.b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((rb2) it.next()).g());
            }
            jc1Var.b = lc1Var;
            jc1Var.e = 1;
            objA = td2Var.a(arrayList, jc1Var);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lc1Var = jc1Var.b;
            ResultKt.throwOnFailure(objA);
        }
        rd2 rd2Var = (rd2) objA;
        if (rd2Var instanceof rd2.a) {
            return CollectionsKt.emptyList();
        }
        if (rd2Var instanceof rd2.b) {
            return lc1Var.f9500a.a(((rd2.b) rd2Var).a());
        }
        throw new NoWhenBranchMatchedException();
    }
}
