package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WeakReference<View> f13671a;
    b d;
    boolean e;
    private final ViewTreeObserver.OnPreDrawListener i;
    private WeakReference<ViewTreeObserver> j;
    float f = -1.0f;
    Rect g = new Rect();
    boolean h = false;
    final Handler c = new Handler();
    final a b = new a();

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:23:0x008d  */
        @Override // java.lang.Runnable
        public final void run() {
            View view;
            float f;
            boolean z = false;
            p.this.e = false;
            if (p.this.d == null || (view = p.this.f13671a.get()) == null) {
                return;
            }
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            Rect rect2 = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            boolean zIsShown = view.isShown();
            float f2 = 0.0f;
            boolean z2 = view.getAlpha() == 0.0f;
            List arrayList = new ArrayList();
            if (globalVisibleRect && zIsShown && !z2) {
                Pair pairA = p.a(rect2, view);
                if (((Boolean) pairA.first).booleanValue()) {
                    f = 0.0f;
                } else {
                    m mVar = new m((List) pairA.second, iArr);
                    float fA = mVar.a();
                    float width = view.getWidth() * view.getHeight();
                    float fWidth = rect.width() * rect.height();
                    if (width > 0.0f) {
                        float f3 = (fWidth * 100.0f) / width;
                        f = ((fWidth - fA) * 100.0f) / width;
                        f2 = f3;
                    } else {
                        f = 0.0f;
                    }
                    arrayList = mVar.f13665a;
                }
            } else {
                f = 0.0f;
            }
            if (f2 == p.this.f && rect.equals(p.this.g)) {
                return;
            }
            p pVar = p.this;
            if (pVar.h) {
                f2 = f;
            }
            pVar.f = f2;
            p.this.g = rect;
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            if (p.this.h) {
                b bVar = p.this.d;
                if (globalVisibleRect && zIsShown && !z2) {
                    z = true;
                }
                bVar.a(z, new sg.bigo.ads.core.mraid.b(p.this.f, p.a(p.this.g, displayMetrics.densityDpi), p.a(arrayList, displayMetrics.densityDpi)));
                return;
            }
            b bVar2 = p.this.d;
            if (globalVisibleRect && zIsShown && !z2) {
                z = true;
            }
            bVar2.a(z, new sg.bigo.ads.core.mraid.b(p.this.f, p.a(p.this.g, displayMetrics.densityDpi), null));
        }
    }

    public interface b {
        void a(boolean z, sg.bigo.ads.core.mraid.b bVar);
    }

    public p(View view) {
        String str;
        this.f13671a = new WeakReference<>(view);
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: sg.bigo.ads.core.mraid.p.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                p pVar = p.this;
                if (!pVar.e) {
                    pVar.e = true;
                    pVar.c.postDelayed(pVar.b, 500L);
                }
                return true;
            }
        };
        this.i = onPreDrawListener;
        this.j = new WeakReference<>(null);
        Context context = view.getContext();
        ViewTreeObserver viewTreeObserver = this.j.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View viewA = u.a(context, view);
            if (viewA == null) {
                str = "Unable to set Visibility Tracker due to no available root view.";
            } else {
                ViewTreeObserver viewTreeObserver2 = viewA.getViewTreeObserver();
                if (viewTreeObserver2.isAlive()) {
                    this.j = new WeakReference<>(viewTreeObserver2);
                    viewTreeObserver2.addOnPreDrawListener(onPreDrawListener);
                    return;
                }
                str = "Visibility Tracker was unable to track views because the root view tree observer was not alive";
            }
            sg.bigo.ads.common.t.a.a(0, VisibilityTracker.TAG, str);
        }
    }

    static Rect a(Rect rect, int i) {
        return new Rect((rect.left * 160) / i, (rect.top * 160) / i, (rect.right * 160) / i, (rect.bottom * 160) / i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    static /* synthetic */ Pair a(Rect rect, View view) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        loop0: while (true) {
            ?? r2 = view;
            view = (ViewGroup) view.getParent();
            while (true) {
                if (view == 0) {
                    z = false;
                    break loop0;
                }
                z = true;
                if (view.getAlpha() == 0.0f) {
                    break loop0;
                }
                for (int iIndexOfChild = view.indexOfChild(r2) + 1; iIndexOfChild < view.getChildCount(); iIndexOfChild++) {
                    View childAt = view.getChildAt(iIndexOfChild);
                    if (childAt.getVisibility() == 0) {
                        Rect rect2 = new Rect();
                        childAt.getGlobalVisibleRect(rect2);
                        if (Rect.intersects(rect, rect2)) {
                            arrayList.add(new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom)));
                        }
                    }
                }
                if (view != viewGroup) {
                    break;
                }
                view = 0;
            }
        }
        return new Pair(Boolean.valueOf(z), arrayList);
    }

    static /* synthetic */ List a(List list, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((Rect) it.next(), i));
        }
        return arrayList;
    }
}
