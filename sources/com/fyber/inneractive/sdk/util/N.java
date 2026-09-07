package com.fyber.inneractive.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class N {
    public final WeakHashMap b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap f2348a = new WeakHashMap();
    public final C3246j c = new C3246j(16, new I());
    public final C3246j d = new C3246j(16, new J());

    /* JADX WARN: Code duplicated, block: B:11:0x003a  */
    public final void a(Context context, View view, M m) {
        View rootView;
        IAlog.a("%strackView called with context: %s view: %s", "IAVisibilityTracker: ", context, view);
        if (context == null) {
            throw new IllegalStateException("View must be attached to an Activity context");
        }
        Context applicationContext = context.getApplicationContext();
        WeakHashMap weakHashMap = (WeakHashMap) this.b.get(applicationContext);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.b.put(applicationContext, weakHashMap);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.getWindow() != null) {
                    rootView = activity.getWindow().getDecorView();
                } else {
                    rootView = view.getRootView();
                }
            } else {
                rootView = view.getRootView();
            }
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                K k = new K(this, applicationContext);
                viewTreeObserver.addOnPreDrawListener(k);
                this.f2348a.put(applicationContext, new Pair(viewTreeObserver, k));
            }
        }
        weakHashMap.put(view, m);
        b();
    }

    public final void b() {
        for (Context context : this.b.keySet()) {
            IAlog.a("%stracking context: %s", "IAVisibilityTracker: ", context);
            WeakHashMap weakHashMap = (WeakHashMap) this.b.get(context);
            if (weakHashMap != null) {
                Iterator it = weakHashMap.keySet().iterator();
                while (it.hasNext()) {
                    IAlog.a("%stracking view: %s", "IAVisibilityTracker: ", (View) it.next());
                }
            }
        }
    }

    public final void a(View view) {
        IAlog.a("%sunTrackView called with view", "IAVisibilityTracker: ");
        if (view == null) {
            IAlog.a("%sunTrackView called with a null view!", "IAVisibilityTracker: ");
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            IAlog.a("%sview.getContext() returned null!", "IAVisibilityTracker: ");
            return;
        }
        Map map = (Map) this.b.get(context);
        if (map != null) {
            a(context, map, view);
        } else {
            for (Context context2 : new HashSet(this.b.keySet())) {
                WeakHashMap weakHashMap = (WeakHashMap) this.b.get(context2);
                if (weakHashMap != null) {
                    a(context2, weakHashMap, view);
                }
            }
        }
        b();
    }

    public final void a(Context context, Map map, View view) {
        if (map.remove(view) != null) {
            if (IAlog.f2345a <= 2) {
                IAlog.e("removeViewFromContext found view for removal!", new Object[0]);
            }
            if (map.isEmpty()) {
                this.b.remove(context);
                Pair pair = (Pair) this.f2348a.get(context);
                if (pair != null) {
                    if (((ViewTreeObserver) pair.first).isAlive()) {
                        ((ViewTreeObserver) pair.first).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) pair.second);
                    }
                    this.f2348a.remove(context);
                }
            }
        }
    }

    public final void a() {
        this.b.clear();
        Iterator it = this.f2348a.keySet().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) this.f2348a.get((Context) it.next());
            if (pair != null && ((ViewTreeObserver) pair.first).isAlive()) {
                ((ViewTreeObserver) pair.first).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) pair.second);
            }
        }
        this.f2348a.clear();
    }
}
