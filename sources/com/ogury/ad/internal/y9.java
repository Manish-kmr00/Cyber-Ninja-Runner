package com.ogury.ad.internal;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z9 f7456a;

    public y9(z9 rectHelper) {
        Intrinsics.checkNotNullParameter(rectHelper, "rectHelper");
        this.f7456a = rectHelper;
    }

    public final ArrayList a(List viewsAfterOverlay, Rect webViewOnScreenRect) {
        Intrinsics.checkNotNullParameter(viewsAfterOverlay, "viewsAfterOverlay");
        Intrinsics.checkNotNullParameter(webViewOnScreenRect, "webViewOnScreenRect");
        ArrayList arrayList = new ArrayList();
        Iterator it = viewsAfterOverlay.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (view.getVisibility() == 0) {
                this.f7456a.getClass();
                Rect rectB = z9.b(view);
                Rect rect = new Rect(webViewOnScreenRect);
                if (rect.intersect(rectB)) {
                    arrayList.add(rect);
                }
            }
        }
        return arrayList;
    }

    public static int a(Rect webViewRect, ArrayList rectangles) {
        int i;
        Intrinsics.checkNotNullParameter(webViewRect, "webViewRect");
        Intrinsics.checkNotNullParameter(rectangles, "overlappingRects");
        int i2 = 0;
        if (rectangles.isEmpty()) {
            return 0;
        }
        Intrinsics.checkNotNullParameter(webViewRect, "<this>");
        Intrinsics.checkNotNullParameter(rectangles, "rectangles");
        if (rectangles.contains(webViewRect)) {
            Intrinsics.checkNotNullParameter(webViewRect, "<this>");
            return webViewRect.height() * webViewRect.width();
        }
        if (rectangles.size() <= 2) {
            Iterator it = rectangles.iterator();
            int iMin = 0;
            while (it.hasNext()) {
                Rect rect = (Rect) it.next();
                Intrinsics.checkNotNullParameter(rect, "<this>");
                iMin += rect.height() * rect.width();
            }
            int size = rectangles.size() - 2;
            if (size >= 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    int size2 = rectangles.size();
                    for (int i5 = i4; i5 < size2; i5++) {
                        Rect rect2 = (Rect) rectangles.get(i3);
                        Rect rect3 = (Rect) rectangles.get(i5);
                        Intrinsics.checkNotNullParameter(rect2, "<this>");
                        Intrinsics.checkNotNullParameter(rect3, "rect2");
                        int i6 = rect2.left;
                        iMin -= (i6 >= rect3.right || (i = rect3.left) >= rect2.right || rect2.top >= rect3.bottom || rect3.top >= rect2.bottom) ? 0 : (Math.min(rect2.bottom, rect3.bottom) - Math.max(rect2.top, rect3.top)) * (Math.min(rect2.right, rect3.right) - Math.max(i6, i));
                    }
                    if (i3 == size) {
                        break;
                    }
                    i3 = i4;
                }
            }
            return iMin;
        }
        int i7 = webViewRect.right;
        for (int i8 = webViewRect.left; i8 < i7; i8++) {
            int i9 = webViewRect.bottom;
            for (int i10 = webViewRect.top; i10 < i9; i10++) {
                Intrinsics.checkNotNullParameter(rectangles, "<this>");
                Iterator it2 = rectangles.iterator();
                while (it2.hasNext()) {
                    if (((Rect) it2.next()).contains(i8, i10)) {
                        i2++;
                        break;
                    }
                }
            }
        }
        return i2;
    }
}
