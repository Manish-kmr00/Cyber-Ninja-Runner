package com.yandex.div.core.view2.animations;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.divs.widgets.DivImageView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewCopies.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a$\u0010\u000b\u001a\u00020\n*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\r\u001a\u00020\n*\u00020\u00012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0012"}, d2 = {"createOrGetVisualCopy", "Landroid/view/View;", "view", "sceneRoot", "Landroid/view/ViewGroup;", "transition", "Landroidx/transition/Transition;", "endPosition", "", "invalidatePosition", "", "replace", "viewCopy", "setHierarchyImageChangeCallback", "callback", "Lkotlin/Function0;", "setScreenshotFromView", "Landroid/widget/ImageView;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ViewCopiesKt {
    public static final View createOrGetVisualCopy(final View view, ViewGroup sceneRoot, Transition transition, int[] endPosition) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sceneRoot, "sceneRoot");
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(endPosition, "endPosition");
        Object tag = view.getTag(R.id.save_overlay_view);
        View view2 = tag instanceof View ? (View) tag : null;
        if (view2 != null) {
            return view2;
        }
        final ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setScreenshotFromView(imageView, view);
        imageView.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        imageView.layout(0, 0, view.getWidth(), view.getHeight());
        final ImageView imageView2 = imageView;
        invalidatePosition(imageView2, sceneRoot, endPosition);
        view.setTag(R.id.save_overlay_view, imageView);
        replace(view, imageView2, transition, sceneRoot);
        setHierarchyImageChangeCallback(view, new Function0<Unit>() { // from class: com.yandex.div.core.view2.animations.ViewCopiesKt.createOrGetVisualCopy.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewCopiesKt.setScreenshotFromView(imageView, view);
            }
        });
        if (!imageView2.isAttachedToWindow()) {
            setHierarchyImageChangeCallback(view, null);
        } else {
            imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.yandex.div.core.view2.animations.ViewCopiesKt$createOrGetVisualCopy$$inlined$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view3) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view3) {
                    imageView2.removeOnAttachStateChangeListener(this);
                    ViewCopiesKt.setHierarchyImageChangeCallback(view, null);
                }
            });
        }
        return imageView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScreenshotFromView(final ImageView imageView, final View view) {
        Bitmap bitmap;
        ImageView imageView2 = view instanceof ImageView ? (ImageView) view : null;
        Drawable drawable = imageView2 != null ? imageView2.getDrawable() : null;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.yandex.div.core.view2.animations.ViewCopiesKt$setScreenshotFromView$drawAndSet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(view.width,… Bitmap.Config.ARGB_8888)");
                View view2 = view;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.translate(-view2.getScrollX(), -view2.getScrollY());
                view2.draw(canvas);
                imageView.setImageBitmap(bitmapCreateBitmap);
            }
        };
        if (ViewsKt.isActuallyLaidOut(view)) {
            function0.invoke();
        } else if (ViewsKt.isActuallyLaidOut(view) && !view.isLayoutRequested()) {
            function0.invoke();
        } else {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.animations.ViewCopiesKt$setScreenshotFromView$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    function0.invoke();
                }
            });
        }
    }

    private static final void invalidatePosition(View view, ViewGroup viewGroup, int[] iArr) {
        int[] iArr2 = new int[2];
        viewGroup.getLocationOnScreen(iArr2);
        view.offsetLeftAndRight(iArr[0] - iArr2[0]);
        view.offsetTopAndBottom(iArr[1] - iArr2[1]);
    }

    private static final void replace(final View view, final View view2, Transition transition, ViewGroup viewGroup) {
        final ViewGroupOverlay overlay = viewGroup.getOverlay();
        view.setVisibility(4);
        overlay.add(view2);
        transition.addListener(new TransitionListenerAdapter() { // from class: com.yandex.div.core.view2.animations.ViewCopiesKt.replace.1
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                Intrinsics.checkNotNullParameter(transition2, "transition");
                view.setVisibility(4);
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                Intrinsics.checkNotNullParameter(transition2, "transition");
                overlay.remove(view2);
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                Intrinsics.checkNotNullParameter(transition2, "transition");
                if (view2.getParent() == null) {
                    overlay.add(view2);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                Intrinsics.checkNotNullParameter(transition2, "transition");
                view.setTag(R.id.save_overlay_view, null);
                view.setVisibility(0);
                overlay.remove(view2);
                transition2.removeListener(this);
            }
        });
    }

    public static /* synthetic */ void setHierarchyImageChangeCallback$default(View view, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        setHierarchyImageChangeCallback(view, function0);
    }

    public static final void setHierarchyImageChangeCallback(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view instanceof DivImageView) {
            ((DivImageView) view).setImageChangeCallback(function0);
        } else if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                setHierarchyImageChangeCallback(it.next(), function0);
            }
        }
    }
}
