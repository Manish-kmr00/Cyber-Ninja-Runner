package com.inmobi.media;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.d4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3338d4 implements InterfaceC3408i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3291a;

    @Override // com.inmobi.media.Zc
    public final boolean a(View view, View view2, int i, Object obj) {
        if (view2 == null || view2.getVisibility() != 0) {
            return false;
        }
        if ((view != null ? view.getParent() : null) == null || !view2.isShown()) {
            return false;
        }
        Ba ba = view2 instanceof Ba ? (Ba) view2 : null;
        if (ba == null) {
            return false;
        }
        if (ba.getPlacementType() != 1 && (ba.getHeight() <= 0 || ba.getWidth() <= 0)) {
            return false;
        }
        Rect rect = new Rect();
        if (!ba.getGlobalVisibleRect(rect)) {
            return false;
        }
        this.f3291a = ((long) rect.height()) * ((long) rect.width());
        if (ba.getPlacementType() == 1) {
            ba.setConfiguredArea(ba.getHeight() * ba.getWidth());
        }
        if (ba.getArea() > 0) {
            return ((long) 100) * this.f3291a >= ba.getConfiguredArea() * ((long) i);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:58:0x010c  */
    /* JADX WARN: Code duplicated, block: B:59:0x010e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    @Override // com.inmobi.media.Zc
    public final boolean a(View rootView, View adView, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(adView, "adView");
        ViewParent parent = rootView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        boolean z4 = viewGroup == null || a(viewGroup, adView, i);
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int iIndexOfChild = viewGroup.indexOfChild(rootView) + 1; iIndexOfChild < childCount; iIndexOfChild++) {
                View childAt = viewGroup.getChildAt(iIndexOfChild);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                if (childAt.getVisibility() == 0) {
                    if (adView instanceof Ba) {
                        if (childAt instanceof C6) {
                            continue;
                        } else {
                            Ba ba = (Ba) adView;
                            Map<View, FriendlyObstructionPurpose> friendlyViews = ba.getFriendlyViews();
                            if (friendlyViews != null ? friendlyViews.containsKey(childAt) : false) {
                                continue;
                            } else {
                                Rect rect = new Rect();
                                adView.getGlobalVisibleRect(rect);
                                Rect rect2 = new Rect();
                                childAt.getGlobalVisibleRect(rect2);
                                Rect rect3 = new Rect();
                                boolean intersect = rect3.setIntersect(rect, rect2);
                                Intrinsics.checkNotNullParameter(rect, "<this>");
                                int i2 = (rect.bottom - rect.top) * (rect.right - rect.left);
                                Intrinsics.checkNotNullParameter(rect3, "<this>");
                                int i3 = i2 - ((rect3.bottom - rect3.top) * (rect3.right - rect3.left));
                                float configuredArea = (i / 100) * ba.getConfiguredArea();
                                if (intersect && i3 < configuredArea) {
                                    if (childAt.getAlpha() > 0.3f) {
                                        if (!(childAt instanceof ImageView) || ((ImageView) childAt).getDrawable() == null) {
                                            if (childAt.getBackground() instanceof ColorDrawable) {
                                                Drawable background = childAt.getBackground();
                                                Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
                                                if (((ColorDrawable) background).getColor() == 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                            } else if (childAt.getBackground() == null) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (childAt.getForeground() instanceof ColorDrawable) {
                                                Drawable foreground = childAt.getForeground();
                                                Intrinsics.checkNotNull(foreground, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
                                                if (((ColorDrawable) foreground).getColor() == 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                            } else if (childAt.getForeground() == null) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z2 && z3) {
                                                z = true;
                                            }
                                        }
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (!z) {
                                    }
                                }
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return z4;
    }
}
