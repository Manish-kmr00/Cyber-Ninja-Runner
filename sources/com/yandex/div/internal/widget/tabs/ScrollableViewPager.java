package com.yandex.div.internal.widget.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.yandex.div.internal.util.NestedHorizontalScrollCompanion;
import com.yandex.div.internal.widget.OnInterceptTouchEventListener;
import com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public class ScrollableViewPager extends RtlViewPager implements OnInterceptTouchEventListenerHost {
    private Set<Integer> mDisabledPages;
    private boolean mIsEdgeScrollEnabled;
    private boolean mIsScrollEnabled;
    private boolean mIsScrollLocked;
    private boolean mIsSwipeLocked;
    private final NestedHorizontalScrollCompanion mNestedScrollCompanion;
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    private ViewDragHelper mViewDragHelper;

    public ScrollableViewPager(Context context) {
        this(context, null);
    }

    public ScrollableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNestedScrollCompanion = new NestedHorizontalScrollCompanion((ViewPager) this);
        this.mIsScrollEnabled = true;
        this.mIsEdgeScrollEnabled = true;
        this.mIsSwipeLocked = false;
        this.mIsScrollLocked = false;
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost
    public OnInterceptTouchEventListener getOnInterceptTouchEventListener() {
        return this.mOnInterceptTouchEventListener;
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListenerHost
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mNestedScrollCompanion.dispatchOnScrollChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        this.mNestedScrollCompanion.dispatchTouchEventAfterSuperCall(motionEvent);
        return zDispatchTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return processTouchEvent(motionEvent) && super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        return (onInterceptTouchEventListener != null ? onInterceptTouchEventListener.onInterceptTouchEvent(this, motionEvent) : false) || (processTouchEvent(motionEvent) && super.onInterceptTouchEvent(motionEvent));
    }

    private boolean processTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsEdgeScrollEnabled && this.mViewDragHelper != null) {
            if ((motionEvent.getAction() & 255) == 0) {
                this.mIsSwipeLocked = false;
            }
            this.mViewDragHelper.processTouchEvent(motionEvent);
        }
        Set<Integer> set = this.mDisabledPages;
        if (set != null) {
            this.mIsScrollLocked = this.mIsScrollEnabled && set.contains(Integer.valueOf(getCurrentItem()));
        }
        return (this.mIsSwipeLocked || this.mIsScrollLocked || !this.mIsScrollEnabled) ? false : true;
    }

    public void setEdgeScrollEnabled(boolean z) {
        this.mIsEdgeScrollEnabled = z;
        if (z) {
            return;
        }
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(this, new ViewDragHelper.Callback() { // from class: com.yandex.div.internal.widget.tabs.ScrollableViewPager.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onEdgeDragStarted(int i, int i2) {
                super.onEdgeDragStarted(i, i2);
                ScrollableViewPager scrollableViewPager = ScrollableViewPager.this;
                boolean z2 = true;
                if ((i & 2) == 0 && (i & 1) == 0) {
                    z2 = false;
                }
                scrollableViewPager.mIsSwipeLocked = z2;
            }
        });
        this.mViewDragHelper = viewDragHelperCreate;
        viewDragHelperCreate.setEdgeTrackingEnabled(3);
    }

    public void setScrollEnabled(boolean z) {
        this.mIsScrollEnabled = z;
    }

    public void setDisabledScrollPages(Set<Integer> set) {
        this.mDisabledPages = set;
    }
}
