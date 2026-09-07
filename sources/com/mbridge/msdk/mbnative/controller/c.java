package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.o0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImpressionTracker.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<ViewTreeObserver> f5202a;
    private List<View> b;
    private ViewTreeObserver.OnPreDrawListener c;
    private d d;
    private Handler e;
    private boolean f;
    private int g;

    /* JADX INFO: compiled from: ImpressionTracker.java */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            c.this.b();
            return true;
        }
    }

    /* JADX INFO: compiled from: ImpressionTracker.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.mbnative.controller.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImpressionTracker.java */
    class RunnableC0457c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f5205a;

        RunnableC0457c(View view) {
            this.f5205a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = this.f5205a.getViewTreeObserver();
            if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                c.this.f5202a = new WeakReference(viewTreeObserver);
                if (c.this.c != null) {
                    viewTreeObserver.addOnPreDrawListener(c.this.c);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ImpressionTracker.java */
    public interface d {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public c(List<View> list, d dVar, Handler handler, int i) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = null;
        this.d = dVar;
        this.e = handler;
        this.g = i;
        if (list != null) {
            this.b = list;
        } else {
            arrayList.clear();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f = false;
            List<View> list = this.b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            for (int i = 0; i < this.b.size(); i++) {
                View view = this.b.get(i);
                if (b(view)) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(arrayList, arrayList2);
            }
            if (arrayList.size() > 0) {
                a();
            }
            arrayList.clear();
            arrayList2.clear();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f) {
            return;
        }
        Handler handler = this.e;
        if (handler != null) {
            if (this.g == 1) {
                d();
            } else {
                handler.postDelayed(new b(), 100L);
            }
        }
        this.f = true;
    }

    private void c() {
        try {
            b();
        } catch (Throwable th) {
            o0.b("ImpressionTracker", th.getMessage(), th);
        }
        try {
            this.c = new a();
        } catch (Throwable th2) {
            o0.b("ImpressionTracker", th2.getMessage(), th2);
        }
    }

    public void a(View view) {
        View viewA;
        View view2;
        if (view != null) {
            viewA = f.a(view.getContext(), view);
            this.b.add(view);
        } else {
            List<View> list = this.b;
            viewA = null;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.b.size() && ((view2 = this.b.get(i)) == null || (viewA = f.a(view2.getContext(), view2)) == null); i++) {
                }
            }
        }
        if (viewA == null) {
            return;
        }
        viewA.post(new RunnableC0457c(viewA));
    }

    private boolean b(View view) {
        return !b1.a(view, this.g);
    }

    public void a() {
        try {
            this.f = false;
            WeakReference<ViewTreeObserver> weakReference = this.f5202a;
            if (weakReference != null && weakReference.get() != null) {
                ViewTreeObserver viewTreeObserver = this.f5202a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.f5202a.clear();
            }
            this.d = null;
            this.c = null;
            List<View> list = this.b;
            if (list != null) {
                list.clear();
            }
            this.b = null;
        } catch (Throwable unused) {
        }
    }
}
