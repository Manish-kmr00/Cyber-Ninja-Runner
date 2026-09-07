package com.yandex.div.internal.widget.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.PopupMenu;
import com.yandex.div.R;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.util.Views;

/* JADX INFO: loaded from: classes12.dex */
public class OverflowMenuWrapper {
    private int mButtonResourceId;
    private final Context mContext;
    private View[] mHorizontallyCompetingViews;
    private Listener mListener;
    private int mMenuGravity;
    private final int mMenuHorizontalMargin;
    private final int mMenuVerticalMargin;
    private int mOverflowAlpha;
    private int mOverflowColor;
    private int mOverflowGravity;
    private ImageView mOverflowMenuImageView;
    private final ViewGroup mParentView;
    private PopupMenu mPopupMenu;
    private View mResultView;
    private boolean mValid;
    private View[] mVerticallyCompetingViews;
    private final View mWrappedView;

    public interface Listener {

        public static class Simple implements Listener {
            @Override // com.yandex.div.internal.widget.menu.OverflowMenuWrapper.Listener
            public void onMenuCreated(PopupMenu popupMenu) {
            }

            @Override // com.yandex.div.internal.widget.menu.OverflowMenuWrapper.Listener
            public void onPopupShown() {
            }
        }

        void onMenuCreated(PopupMenu popupMenu);

        void onPopupShown();
    }

    public OverflowMenuWrapper(Context context, View view, ViewGroup viewGroup) {
        this(context, view, viewGroup, R.dimen.overflow_menu_margin_horizontal, R.dimen.overflow_menu_margin_vertical);
    }

    public OverflowMenuWrapper(Context context, View view, ViewGroup viewGroup, int i, int i2) {
        this.mOverflowGravity = 51;
        this.mOverflowColor = -1;
        this.mOverflowAlpha = 255;
        this.mMenuGravity = 83;
        this.mButtonResourceId = R.drawable.ic_more_vert_white_24dp;
        this.mHorizontallyCompetingViews = null;
        this.mVerticallyCompetingViews = null;
        this.mValid = false;
        this.mContext = context;
        this.mWrappedView = view;
        this.mParentView = viewGroup;
        this.mMenuHorizontalMargin = i;
        this.mMenuVerticalMargin = i2;
    }

    public OverflowMenuWrapper overflowGravity(int i) {
        this.mOverflowGravity = i;
        return this;
    }

    public OverflowMenuWrapper menuGravity(int i) {
        this.mMenuGravity = i;
        return this;
    }

    public OverflowMenuWrapper color(int i) {
        this.mOverflowColor = i;
        return this;
    }

    public OverflowMenuWrapper alpha(int i) {
        this.mOverflowAlpha = i;
        return this;
    }

    public OverflowMenuWrapper listener(Listener listener) {
        this.mListener = listener;
        return this;
    }

    public OverflowMenuWrapper horizontallyCompetingViews(View... viewArr) {
        this.mHorizontallyCompetingViews = viewArr;
        return this;
    }

    public OverflowMenuWrapper verticallyCompetingViews(View... viewArr) {
        this.mVerticallyCompetingViews = viewArr;
        return this;
    }

    public OverflowMenuWrapper buttonResourceId(int i) {
        this.mButtonResourceId = i;
        return this;
    }

    public void invalidate() {
        this.mValid = false;
    }

    public View getView() {
        View view;
        if (this.mValid && (view = this.mResultView) != null) {
            return view;
        }
        if (this.mResultView == null || this.mOverflowMenuImageView == null) {
            ImageView imageViewCreateOverflowMenuImageView = createOverflowMenuImageView();
            this.mOverflowMenuImageView = imageViewCreateOverflowMenuImageView;
            this.mResultView = createWrapperView(imageViewCreateOverflowMenuImageView);
        }
        Assert.assertFalse(this.mValid);
        ImageView imageView = this.mOverflowMenuImageView;
        imageView.setImageDrawable(createMenuDrawable(imageView));
        this.mOverflowMenuImageView.setOnClickListener(getOnMenuClickListener());
        this.mValid = true;
        return this.mResultView;
    }

    public View.OnClickListener getOnMenuClickListener() {
        return new View.OnClickListener() { // from class: com.yandex.div.internal.widget.menu.OverflowMenuWrapper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m6242xd3c53476(view);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$getOnMenuClickListener$0$com-yandex-div-internal-widget-menu-OverflowMenuWrapper, reason: not valid java name */
    /* synthetic */ void m6242xd3c53476(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view, this.mMenuGravity);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onMenuCreated(popupMenu);
        }
        popupMenu.show();
        Listener listener2 = this.mListener;
        if (listener2 != null) {
            listener2.onPopupShown();
        }
        this.mPopupMenu = popupMenu;
    }

    public void setMenuVisibility(int i) {
        if (this.mValid) {
            Assert.assertNotNull("mResultView is null in setMenuVisibility", this.mResultView);
            this.mOverflowMenuImageView.setVisibility(i);
        }
    }

    public void redrawMenuIcon() {
        if (this.mValid) {
            Assert.assertNotNull("mResultView is null in redrawMenuIcon", this.mResultView);
            ImageView imageView = this.mOverflowMenuImageView;
            imageView.setImageDrawable(createMenuDrawable(imageView));
        }
    }

    protected Bitmap getBitmapResource(int i, View view) {
        return BitmapFactory.decodeResource(this.mContext.getResources(), i);
    }

    private Drawable createMenuDrawable(View view) {
        Drawable drawableMutate = new BitmapDrawable(this.mContext.getResources(), getBitmapResource(this.mButtonResourceId, view)).mutate();
        drawableMutate.setColorFilter(this.mOverflowColor, PorterDuff.Mode.SRC_IN);
        drawableMutate.setAlpha(this.mOverflowAlpha);
        return drawableMutate;
    }

    private View createWrapperView(ImageView imageView) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        frameLayout.addView(this.mWrappedView);
        frameLayout.addView(imageView);
        View[] viewArr = this.mHorizontallyCompetingViews;
        if (viewArr != null) {
            boolean z = (this.mOverflowGravity & 5) != 0;
            for (View view : viewArr) {
                Views.setPadding(view, R.dimen.overflow_menu_size, z ? 4 : 2);
            }
        }
        View[] viewArr2 = this.mVerticallyCompetingViews;
        if (viewArr2 != null) {
            boolean z2 = (this.mOverflowGravity & 48) != 0;
            for (View view2 : viewArr2) {
                Views.setPadding(view2, R.dimen.overflow_menu_size, z2 ? 8 : 1);
            }
        }
        return frameLayout;
    }

    private ImageView createOverflowMenuImageView() {
        Resources resources = this.mContext.getResources();
        NonScrollImageView nonScrollImageView = new NonScrollImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mOverflowGravity;
        nonScrollImageView.setLayoutParams(layoutParams);
        nonScrollImageView.setId(R.id.overflow_menu);
        int dimensionPixelSize = resources.getDimensionPixelSize(this.mMenuHorizontalMargin);
        nonScrollImageView.setPadding(dimensionPixelSize, resources.getDimensionPixelSize(this.mMenuVerticalMargin), dimensionPixelSize, 0);
        return nonScrollImageView;
    }

    public void dismiss() {
        PopupMenu popupMenu = this.mPopupMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
            this.mPopupMenu = null;
        }
    }
}
