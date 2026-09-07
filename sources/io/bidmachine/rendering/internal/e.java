package io.bidmachine.rendering.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.rendering.model.ElementLayoutParams;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class e {
    public static void a(ViewGroup viewGroup, io.bidmachine.rendering.internal.view.e eVar, List list, a aVar) {
        View viewK = aVar.k();
        if (viewK == null) {
            m.a("AdViewPresenter", "AdsElement (%s) - Can't add ad element, view is null", aVar);
            return;
        }
        Context context = eVar.getContext();
        ElementLayoutParams layoutParams = aVar.i().getLayoutParams();
        int widthPx = layoutParams.getWidthPx(context);
        int heightPx = layoutParams.getHeightPx(context);
        if (widthPx <= 0) {
            widthPx = -1;
        }
        if (heightPx <= 0) {
            heightPx = -1;
        }
        io.bidmachine.rendering.internal.view.e.a aVar2 = new io.bidmachine.rendering.internal.view.e.a(widthPx, heightPx);
        aVar2.a(context, layoutParams, list);
        viewK.setTranslationX(layoutParams.getTranslationXPx(context));
        viewK.setTranslationY(layoutParams.getTranslationYPx(context));
        eVar.addView(viewK, aVar2);
        try {
            aVar.a(viewGroup);
        } catch (Throwable th) {
            m.b(th);
        }
        m.b("AdViewPresenter", "AdsElement (%s) - view added (%s)", aVar, viewK);
    }

    public static void a(ViewGroup viewGroup, io.bidmachine.rendering.internal.view.e eVar, List list) {
        eVar.removeAllViews();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a(viewGroup, eVar, list, (a) it.next());
        }
    }

    public static View a(List list, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.i().getName().equals(str)) {
                return aVar.k();
            }
        }
        return null;
    }
}
