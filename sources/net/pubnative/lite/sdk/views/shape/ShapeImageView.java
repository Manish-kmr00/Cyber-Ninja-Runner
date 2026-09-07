package net.pubnative.lite.sdk.views.shape;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.views.shape.shader.ShaderHelper;
import net.pubnative.lite.sdk.views.shape.shader.SvgShader;

/* JADX INFO: loaded from: classes13.dex */
public class ShapeImageView extends ShaderImageView {
    private SvgShader shader;

    @Override // net.pubnative.lite.sdk.views.shape.ShaderImageView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // net.pubnative.lite.sdk.views.shape.ShaderImageView, android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ShapeImageView(Context context) {
        super(context);
    }

    public ShapeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShapeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // net.pubnative.lite.sdk.views.shape.ShaderImageView
    public ShaderHelper createImageViewHelper() {
        SvgShader svgShader = new SvgShader();
        this.shader = svgShader;
        return svgShader;
    }

    public void setStrokeMiter(int i) {
        SvgShader svgShader = this.shader;
        if (svgShader != null) {
            svgShader.setStrokeMiter(i);
            invalidate();
        }
    }

    public void setStrokeCap(int i) {
        SvgShader svgShader = this.shader;
        if (svgShader != null) {
            svgShader.setStrokeCap(i);
            invalidate();
        }
    }

    public void setStrokeJoin(int i) {
        SvgShader svgShader = this.shader;
        if (svgShader != null) {
            svgShader.setStrokeJoin(i);
            invalidate();
        }
    }

    public void setBorderType(int i) {
        SvgShader svgShader = this.shader;
        if (svgShader != null) {
            svgShader.setBorderType(i);
            invalidate();
        }
    }

    public void setShapeResId(int i) {
        SvgShader svgShader = this.shader;
        if (svgShader != null) {
            svgShader.setShapeResId(getContext(), i);
            invalidate();
        }
    }
}
