package sg.bigo.ads.core.mraid;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Rect> f13665a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f13668a;
        final int b;

        a(int i, int i2) {
            this.f13668a = i;
            this.b = i2;
        }

        final boolean a(a aVar) {
            return this.f13668a <= aVar.b && this.b >= aVar.f13668a;
        }

        public final String toString() {
            return String.format("Range: %s - %s", Integer.valueOf(this.f13668a), Integer.valueOf(this.b));
        }
    }

    m(List<Rect> list, int[] iArr) {
        List<Integer> listA = a(list);
        this.f13665a = new ArrayList();
        int i = 0;
        while (i < listA.size() - 1) {
            int iIntValue = listA.get(i).intValue();
            i++;
            int iIntValue2 = listA.get(i).intValue();
            if (iIntValue < iIntValue2) {
                a aVar = new a(iIntValue, iIntValue2);
                this.f13665a.addAll(b(aVar, a(aVar, list)));
            }
        }
        Collections.sort(this.f13665a, new Comparator<Rect>() { // from class: sg.bigo.ads.core.mraid.m.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Rect rect, Rect rect2) {
                Rect rect3 = rect;
                Rect rect4 = rect2;
                return (rect3.width() * rect3.height()) - (rect4.width() * rect4.height());
            }
        });
        Iterator<Rect> it = this.f13665a.iterator();
        while (it.hasNext()) {
            it.next().offset(-iArr[0], -iArr[1]);
        }
    }

    private List<Integer> a(List<Rect> list) {
        ArrayList arrayList = new ArrayList();
        for (Rect rect : list) {
            arrayList.add(Integer.valueOf(rect.left));
            arrayList.add(Integer.valueOf(rect.right));
        }
        Collections.sort(arrayList, new Comparator<Integer>() { // from class: sg.bigo.ads.core.mraid.m.2
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        });
        return arrayList;
    }

    private static List<a> a(List<a> list, a aVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            a aVar2 = list.get(i);
            if (!aVar.a(aVar2)) {
                arrayList.add(aVar2);
            } else if (aVar.a(aVar2)) {
                aVar = new a(aVar.f13668a < aVar2.f13668a ? aVar.f13668a : aVar2.f13668a, aVar.b > aVar2.b ? aVar.b : aVar2.b);
            }
        }
        arrayList.add(aVar);
        return arrayList;
    }

    private static List<a> a(a aVar, List<Rect> list) {
        List<a> arrayList = new ArrayList<>();
        for (Rect rect : list) {
            if (aVar.f13668a < rect.right && aVar.b > rect.left) {
                arrayList = a(arrayList, new a(rect.top, rect.bottom));
            }
        }
        return arrayList;
    }

    private static List<Rect> b(a aVar, List<a> list) {
        ArrayList arrayList = new ArrayList();
        for (a aVar2 : list) {
            arrayList.add(new Rect(aVar.f13668a, aVar2.f13668a, aVar.b, aVar2.b));
        }
        return arrayList;
    }

    final float a() {
        float fWidth = 0.0f;
        for (Rect rect : this.f13665a) {
            fWidth += rect.width() * rect.height();
        }
        return fWidth;
    }
}
