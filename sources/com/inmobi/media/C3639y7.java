package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.y7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3639y7 extends PagerAdapter implements T7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3625x7 f3486a;
    public final L7 b;
    public final String c;
    public final int d;
    public final Handler e;
    public boolean f;
    public final SparseArray g;

    public C3639y7(C3625x7 mNativeDataModel, L7 mNativeLayoutInflater) {
        Intrinsics.checkNotNullParameter(mNativeDataModel, "mNativeDataModel");
        Intrinsics.checkNotNullParameter(mNativeLayoutInflater, "mNativeLayoutInflater");
        this.f3486a = mNativeDataModel;
        this.b = mNativeLayoutInflater;
        this.c = "y7";
        this.d = 50;
        this.e = new Handler(Looper.getMainLooper());
        this.g = new SparseArray();
    }

    public static final void a(Object item, C3639y7 this$0) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item instanceof View) {
            L7 l7 = this$0.b;
            View view = (View) item;
            l7.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            l7.m.a(view);
        }
    }

    @Override // com.inmobi.media.T7
    public final void destroy() {
        this.f = true;
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.e.removeCallbacks((Runnable) this.g.get(this.g.keyAt(i)));
        }
        this.g.clear();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup container, int i, final Object item) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof View) {
            container.removeView((View) item);
        }
        Runnable runnable = (Runnable) this.g.get(i);
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
            String TAG = this.c;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
        this.e.post(new Runnable() { // from class: com.inmobi.media.y7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3639y7.a(item, this);
            }
        });
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f3486a.d();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        View view = item instanceof View ? (View) item : null;
        Object tag = view != null ? view.getTag() : null;
        if (tag instanceof Integer) {
            return ((Number) tag).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup container, int i) {
        View relativeLayout;
        Intrinsics.checkNotNullParameter(container, "container");
        String TAG = this.c;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        C3513p7 c3513p7B = this.f3486a.b(i);
        if (c3513p7B == null || (relativeLayout = a(i, container, c3513p7B)) == null) {
            relativeLayout = new RelativeLayout(container.getContext());
        }
        relativeLayout.setTag(Integer.valueOf(i));
        container.addView(relativeLayout);
        return relativeLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual(view, obj);
    }

    public final ViewGroup a(final int i, final ViewGroup parent, final C3513p7 pageContainerAsset) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageContainerAsset, "pageContainerAsset");
        final ViewGroup viewGroupA = this.b.a(parent, pageContainerAsset);
        if (viewGroupA != null) {
            int iAbs = Math.abs(this.b.k - i);
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.y7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3639y7.a(this.f$0, i, viewGroupA, parent, pageContainerAsset);
                }
            };
            this.g.put(i, runnable);
            this.e.postDelayed(runnable, iAbs * this.d);
        }
        return viewGroupA;
    }

    public static final void a(C3639y7 this$0, int i, ViewGroup container, ViewGroup parent, C3513p7 root) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(container, "$it");
        Intrinsics.checkNotNullParameter(parent, "$parent");
        Intrinsics.checkNotNullParameter(root, "$pageContainerAsset");
        if (this$0.f) {
            return;
        }
        this$0.g.remove(i);
        L7 l7 = this$0.b;
        l7.getClass();
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(root, "root");
        l7.b(container, root);
    }
}
