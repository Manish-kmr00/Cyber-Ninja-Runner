package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class CIG {

    public interface Og {
        void Og();

        void pA();

        void pA(View view, boolean z);

        void pA(boolean z);
    }

    public static void pA(final ViewGroup viewGroup, boolean z, int i, Og og, List<ViewGroup> list) {
        viewGroup.setTag(520093765, og);
        viewGroup.setTag(520093766, Integer.valueOf(i));
        if (viewGroup.getTag(520093764) == Boolean.TRUE) {
            return;
        }
        final pA pAVar = new pA(viewGroup);
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.get(i2).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.CIG.1
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewAdded(View view, View view2) {
                        pAVar.pA = view2;
                    }

                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        pAVar.pA = null;
                    }
                });
            }
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(pAVar);
        if (z) {
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.utils.CIG.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        Og og2 = (Og) viewGroup.getTag(520093765);
                        ViewGroup viewGroup2 = viewGroup;
                        CIG.Og(viewGroup2, og2, (Integer) viewGroup2.getTag(520093766));
                    } catch (Exception e) {
                        ApmHelper.reportCustomError("onScrollChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                    }
                }
            });
        }
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.CIG.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z2) {
                try {
                    Og og2 = (Og) viewGroup.getTag(520093765);
                    if (og2 != null) {
                        og2.pA(z2);
                        ViewGroup viewGroup2 = viewGroup;
                        CIG.Og(viewGroup2, og2, (Integer) viewGroup2.getTag(520093766));
                    }
                } catch (Exception e) {
                    ApmHelper.reportCustomError("onWindowFocusChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                }
            }
        });
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.CIG.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                Og og2 = (Og) viewGroup.getTag(520093765);
                if (og2 != null) {
                    og2.pA();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                Og og2 = (Og) viewGroup.getTag(520093765);
                if (og2 != null) {
                    og2.Og();
                }
            }
        });
        viewGroup.setTag(520093764, Boolean.TRUE);
    }

    class pA implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ ViewGroup Og;
        View pA = null;

        pA(ViewGroup viewGroup) {
            this.Og = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                Og og = (Og) this.Og.getTag(520093765);
                if (this.pA != null) {
                    Rect rect = new Rect();
                    this.pA.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    this.Og.getGlobalVisibleRect(rect2);
                    if (rect.contains(rect2)) {
                        if (og != null) {
                            og.pA(this.Og, false);
                        }
                        this.Og.setTag(520093763, Boolean.FALSE);
                        return;
                    } else {
                        if (og != null) {
                            og.pA(this.Og, true);
                        }
                        this.Og.setTag(520093763, Boolean.TRUE);
                        return;
                    }
                }
                ViewGroup viewGroup = this.Og;
                CIG.Og(viewGroup, og, (Integer) viewGroup.getTag(520093766));
            } catch (Exception e) {
                ApmHelper.reportCustomError("onGlobalLayout exception " + this.Og.getTag(520093765), "ViewUtils", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(View view, Og og, Integer num) {
        if (og == null) {
            return;
        }
        if (num == null) {
            num = 0;
        }
        og.pA(view, pA(view, num.intValue()));
    }

    private static boolean pA(View view, int i) {
        return com.bytedance.sdk.openadsdk.core.lT.pA(view, 20, i);
    }
}
