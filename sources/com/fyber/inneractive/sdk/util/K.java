package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class K implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f2346a;
    public final /* synthetic */ N b;

    public K(N n, Context context) {
        this.b = n;
        this.f2346a = context;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        N n = this.b;
        Context context = this.f2346a;
        if (context == null) {
            n.getClass();
            return true;
        }
        WeakHashMap weakHashMap = (WeakHashMap) n.b.get(context);
        if (weakHashMap == null) {
            return true;
        }
        C3246j c3246j = n.d;
        Object objPoll = c3246j.f2366a.poll();
        if (objPoll == null) {
            objPoll = c3246j.b.a();
        }
        HashSet<View> hashSet = (HashSet) objPoll;
        hashSet.addAll(weakHashMap.keySet());
        for (View view : hashSet) {
            M m = (M) weakHashMap.get(view);
            if (m != null) {
                C3246j c3246j2 = n.c;
                Object objPoll2 = c3246j2.f2366a.poll();
                if (objPoll2 == null) {
                    objPoll2 = c3246j2.b.a();
                }
                Rect rect = (Rect) objPoll2;
                m.a((view == null || view.getParent() == null || !view.isShown() || !view.getGlobalVisibleRect(rect)) ? 0.0f : (rect.width() * rect.height()) / (view.getWidth() * view.getHeight()), rect);
                n.c.f2366a.offer(rect);
            }
        }
        hashSet.clear();
        n.d.f2366a.offer(hashSet);
        return true;
    }
}
