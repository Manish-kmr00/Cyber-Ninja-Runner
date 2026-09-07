package com.inmobi.media;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.nb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3489nb extends S7 implements ViewPager.OnPageChangeListener {
    public final String b;
    public final ViewPager c;
    public final Point d;
    public final Point e;
    public boolean f;
    public L7 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3489nb(Context context) {
        super(context, (byte) 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = "nb";
        this.d = new Point();
        this.e = new Point();
        setClipChildren(false);
        setLayerType(1, null);
        ViewPager viewPager = new ViewPager(getContext());
        this.c = viewPager;
        viewPager.addOnPageChangeListener(this);
        addView(viewPager);
    }

    @Override // com.inmobi.media.S7
    public final void a(C3513p7 scrollableContainerAsset, T7 dataSource, int i, int i2, L7 l7) {
        FrameLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(scrollableContainerAsset, "scrollableContainerAsset");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        C3455l7 c3455l7 = scrollableContainerAsset.B > 0 ? (C3455l7) scrollableContainerAsset.A.get(0) : null;
        if (c3455l7 != null) {
            HashMap map = K8.c;
            ViewGroup.LayoutParams layoutParamsA = C3584u8.a(c3455l7, this);
            Intrinsics.checkNotNull(layoutParamsA, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            layoutParams = (FrameLayout.LayoutParams) layoutParamsA;
            layoutParams.setMarginStart(20);
            layoutParams.setMarginEnd(20);
            layoutParams.gravity = i2;
        } else {
            layoutParams = null;
        }
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            viewPager.setLayoutParams(layoutParams);
            viewPager.setAdapter(dataSource instanceof C3639y7 ? (C3639y7) dataSource : null);
            viewPager.setOffscreenPageLimit(2);
            viewPager.setPageMargin(16);
            viewPager.setCurrentItem(i);
        }
        this.g = l7;
    }

    @Override // com.inmobi.media.S7, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.inmobi.media.S7, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        this.f = i != 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        if (this.f) {
            invalidate();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        int i2;
        Intrinsics.checkNotNullExpressionValue(this.b, "TAG");
        ViewPager viewPager = this.c;
        ViewGroup.LayoutParams layoutParams = viewPager != null ? viewPager.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        L7 l7 = this.g;
        if (l7 != null) {
            if (layoutParams2 != null) {
                l7.k = i;
                C3513p7 asset = l7.c.b(i);
                if (asset != null) {
                    E7 e7 = l7.d;
                    Intrinsics.checkNotNullParameter(asset, "asset");
                    F7 f7 = e7.f3058a;
                    if (!f7.f3070a) {
                        C3313b7 c3313b7 = f7.b;
                        c3313b7.getClass();
                        Intrinsics.checkNotNullParameter(asset, "asset");
                        if (!c3313b7.n.contains(Integer.valueOf(i)) && !c3313b7.t) {
                            c3313b7.m();
                            if (!c3313b7.t) {
                                c3313b7.n.add(Integer.valueOf(i));
                                asset.y = System.currentTimeMillis();
                                if (c3313b7.r) {
                                    HashMap mapA = c3313b7.a(asset);
                                    L4 l4 = c3313b7.j;
                                    if (l4 != null) {
                                        String TAG = c3313b7.m;
                                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                                        ((M4) l4).a(TAG, "Page-view impression record request");
                                    }
                                    asset.a("page_view", mapA, (T6) null, c3313b7.j);
                                } else {
                                    c3313b7.o.add(asset);
                                }
                            }
                        }
                    }
                }
                int i3 = l7.k;
                if (i3 == 0) {
                    i2 = GravityCompat.START;
                } else {
                    i2 = i3 == l7.c.d() - 1 ? GravityCompat.END : 1;
                }
                layoutParams2.gravity = i2;
            }
            ViewPager viewPager2 = this.c;
            if (viewPager2 != null) {
                viewPager2.requestLayout();
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        Point point = this.d;
        point.x = i / 2;
        point.y = i2 / 2;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b2  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent ev) {
        double dCeil;
        double dCeil2;
        int i;
        ViewPager viewPager;
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.e.x = (int) ev.getX();
            this.e.y = (int) ev.getY();
            Point point = this.d;
            int i2 = point.x;
            Point point2 = this.e;
            ev.offsetLocation(i2 - point2.x, point.y - point2.y);
        } else if (action != 1) {
            Point point3 = this.d;
            int i3 = point3.x;
            Point point4 = this.e;
            ev.offsetLocation(i3 - point4.x, point3.y - point4.y);
        } else {
            float f = this.e.x;
            float x = ev.getX();
            ViewPager viewPager2 = this.c;
            Intrinsics.checkNotNull(viewPager2);
            int currentItem = viewPager2.getCurrentItem();
            PagerAdapter adapter = this.c.getAdapter();
            Intrinsics.checkNotNull(adapter);
            int count = adapter.getCount();
            int width = this.c.getWidth();
            int width2 = getWidth();
            if (currentItem == 0 || count - 1 == currentItem) {
                int i4 = width2 - width;
                if (currentItem == 0) {
                    float f2 = i4;
                    if (f > f2 && x > f2) {
                        dCeil2 = Math.ceil((x - f2) / width);
                        i = (int) dCeil2;
                    }
                    if (i != 0) {
                        ev.setAction(3);
                        viewPager = this.c;
                        if (viewPager != null) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + i);
                        }
                    }
                    Point point5 = this.d;
                    int i5 = point5.x;
                    Point point6 = this.e;
                    ev.offsetLocation(i5 - point6.x, point5.y - point6.y);
                } else {
                    float f3 = i4;
                    if (f < f3 && x < f3) {
                        dCeil = Math.ceil((f3 - x) / width);
                        dCeil2 = -dCeil;
                        i = (int) dCeil2;
                    }
                    if (i != 0) {
                        ev.setAction(3);
                        viewPager = this.c;
                        if (viewPager != null) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + i);
                        }
                    }
                    Point point7 = this.d;
                    int i6 = point7.x;
                    Point point8 = this.e;
                    ev.offsetLocation(i6 - point8.x, point7.y - point8.y);
                }
                i = 0;
                if (i != 0) {
                    ev.setAction(3);
                    viewPager = this.c;
                    if (viewPager != null) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + i);
                    }
                }
                Point point9 = this.d;
                int i7 = point9.x;
                Point point10 = this.e;
                ev.offsetLocation(i7 - point10.x, point9.y - point10.y);
            } else {
                float f4 = (width2 - width) / 2;
                if (f >= f4 || x >= f4) {
                    float f5 = (width2 + width) / 2;
                    if (f <= f5 || x <= f5) {
                        i = 0;
                    } else {
                        dCeil2 = Math.ceil((x - f5) / width);
                    }
                    if (i != 0) {
                        ev.setAction(3);
                        viewPager = this.c;
                        if (viewPager != null) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + i);
                        }
                    }
                    Point point11 = this.d;
                    int i8 = point11.x;
                    Point point12 = this.e;
                    ev.offsetLocation(i8 - point12.x, point11.y - point12.y);
                } else {
                    dCeil = Math.ceil((f4 - x) / width);
                    dCeil2 = -dCeil;
                }
                i = (int) dCeil2;
                if (i != 0) {
                    ev.setAction(3);
                    viewPager = this.c;
                    if (viewPager != null) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + i);
                    }
                }
                Point point13 = this.d;
                int i9 = point13.x;
                Point point14 = this.e;
                ev.offsetLocation(i9 - point14.x, point13.y - point14.y);
            }
        }
        ViewPager viewPager3 = this.c;
        if (viewPager3 != null) {
            return viewPager3.dispatchTouchEvent(ev);
        }
        return false;
    }
}
