package net.pubnative.lite.sdk.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.Random;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.core.R;
import net.pubnative.lite.sdk.utils.ViewUtils;
import net.pubnative.lite.sdk.vpaid.helpers.BitmapHelper;

/* JADX INFO: loaded from: classes4.dex */
public class CloseableContainer extends FrameLayout {
    static final float CLOSE_BUTTON_PADDING_BORDER_DP = 0.0f;
    static final float CLOSE_BUTTON_PADDING_DP = 0.0f;
    private static final float CLOSE_REGION_SIZE_DP = 30.0f;
    private final ImageButton mCloseButton;
    private ClosePosition mClosePosition;
    private Integer mCustomCloseSize;
    private OnCloseListener mOnCloseListener;

    public interface OnCloseListener {
        void onClose();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public enum ClosePosition {
        TOP_LEFT(8388659),
        TOP_CENTER(49),
        TOP_RIGHT(8388661),
        CENTER(17),
        BOTTOM_LEFT(8388691),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(8388693),
        RANDOM(0);

        private final int mGravity;

        ClosePosition(int i) {
            this.mGravity = i;
        }

        int getGravity() {
            return this.mGravity;
        }

        public static ClosePosition getRandomPosition() {
            return values()[new Random().nextInt(values().length)];
        }
    }

    public CloseableContainer(Context context) {
        this(context, null, 0);
    }

    public CloseableContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloseableContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCustomCloseSize = null;
        this.mClosePosition = ClosePosition.TOP_LEFT;
        int iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(0.0f, context);
        int iConvertDpToPixel2 = (int) ViewUtils.convertDpToPixel(0.0f, context);
        ImageButton imageButton = new ImageButton(context);
        this.mCloseButton = imageButton;
        Bitmap bitmap = BitmapHelper.toBitmap(context, HyBid.getNormalCloseXmlResource(), Integer.valueOf(R.mipmap.close));
        if (bitmap != null) {
            imageButton.setImageBitmap(bitmap);
        } else {
            imageButton.setImageBitmap(BitmapHelper.decodeResource(imageButton.getContext(), Integer.valueOf(R.mipmap.close)));
        }
        imageButton.setId(R.id.button_fullscreen_close);
        imageButton.setBackgroundColor(0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setPadding(iConvertDpToPixel, iConvertDpToPixel2, iConvertDpToPixel2, iConvertDpToPixel);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.views.CloseableContainer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m9785lambda$new$0$netpubnativelitesdkviewsCloseableContainer(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$net-pubnative-lite-sdk-views-CloseableContainer, reason: not valid java name */
    /* synthetic */ void m9785lambda$new$0$netpubnativelitesdkviewsCloseableContainer(View view) {
        playSoundEffect(0);
        OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    private void positionButton() {
        FrameLayout.LayoutParams layoutParams;
        if (this.mCustomCloseSize != null) {
            layoutParams = new FrameLayout.LayoutParams(this.mCustomCloseSize.intValue(), this.mCustomCloseSize.intValue());
            this.mCloseButton.setId(R.id.button_fullscreen_close_small);
            int iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(8.0f, getContext());
            layoutParams.setMargins(iConvertDpToPixel, iConvertDpToPixel, iConvertDpToPixel, iConvertDpToPixel);
        } else {
            int iConvertDpToPixel2 = (int) ViewUtils.convertDpToPixel(30.0f, getContext());
            layoutParams = new FrameLayout.LayoutParams(iConvertDpToPixel2, iConvertDpToPixel2);
        }
        layoutParams.gravity = this.mClosePosition.getGravity();
        removeView(this.mCloseButton);
        addView(this.mCloseButton, layoutParams);
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setClosePosition(ClosePosition closePosition) {
        if (closePosition != null) {
            if (closePosition == ClosePosition.RANDOM) {
                this.mClosePosition = ClosePosition.getRandomPosition();
                return;
            }
            if (closePosition == ClosePosition.TOP_LEFT) {
                int iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(0.0f, getContext());
                int iConvertDpToPixel2 = (int) ViewUtils.convertDpToPixel(0.0f, getContext());
                this.mClosePosition = closePosition;
                this.mCloseButton.setPadding(iConvertDpToPixel2, iConvertDpToPixel2, iConvertDpToPixel, iConvertDpToPixel);
                return;
            }
            this.mClosePosition = closePosition;
        }
    }

    public void setCloseVisible(boolean z) {
        ImageButton imageButton = this.mCloseButton;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
            if (z) {
                positionButton();
            }
        }
    }

    public void setCloseSize(Integer num) {
        this.mCustomCloseSize = Integer.valueOf((int) ViewUtils.convertDpToPixel(num.floatValue(), getContext()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mCustomCloseSize.intValue(), this.mCustomCloseSize.intValue());
        layoutParams.gravity = this.mClosePosition.getGravity();
        removeView(this.mCloseButton);
        addView(this.mCloseButton, layoutParams);
    }
}
