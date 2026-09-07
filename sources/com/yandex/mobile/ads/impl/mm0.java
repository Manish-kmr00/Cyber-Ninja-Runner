package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAdBreakType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class mm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ye2 f9655a;

    public mm0(ye2 videoPlayerController) {
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        this.f9655a = videoPlayerController;
    }

    public final lm0 a(List<dt> adBreaks) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        ArrayList arrayList = new ArrayList();
        ArrayList<dt> arrayList2 = new ArrayList();
        for (Object obj2 : adBreaks) {
            if (Intrinsics.areEqual(((dt) obj2).e(), InstreamAdBreakType.MIDROLL)) {
                arrayList2.add(obj2);
            }
        }
        for (dt dtVar : arrayList2) {
            et etVarB = dtVar.b();
            long jB = etVarB.b();
            if (et.a.b == etVarB.a()) {
                jB = (long) ((jB / 100) * this.f9655a.b());
            }
            arrayList.add(new aj1(dtVar, jB));
        }
        Collections.sort(arrayList, new a());
        Iterator<T> it = adBreaks.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((dt) next).e(), InstreamAdBreakType.PREROLL));
        dt dtVar2 = (dt) next;
        for (Object obj3 : adBreaks) {
            if (Intrinsics.areEqual(((dt) obj3).e(), InstreamAdBreakType.POSTROLL)) {
                obj = obj3;
                break;
            }
        }
        return new lm0(arrayList, dtVar2, (dt) obj);
    }

    private static final class a implements Comparator<aj1> {
        @Override // java.util.Comparator
        public final int compare(aj1 aj1Var, aj1 aj1Var2) {
            aj1 first = aj1Var;
            aj1 second = aj1Var2;
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            if (Intrinsics.areEqual(first, second)) {
                return 0;
            }
            String strE = first.a().e();
            String strE2 = second.a().e();
            return (!Intrinsics.areEqual(strE, InstreamAdBreakType.PREROLL) && (Intrinsics.areEqual(strE2, InstreamAdBreakType.PREROLL) || Intrinsics.areEqual(strE, InstreamAdBreakType.POSTROLL) || (!Intrinsics.areEqual(strE2, InstreamAdBreakType.POSTROLL) && first.b() >= second.b()))) ? 1 : -1;
        }
    }
}
