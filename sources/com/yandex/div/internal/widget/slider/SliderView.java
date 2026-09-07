package com.yandex.div.internal.widget.slider;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.SeekBar;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.b9;
import com.yandex.div.R;
import com.yandex.div.core.ObserverList;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.internal.widget.slider.shapes.TextDrawable;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0002*-\b\u0016\u0018\u00002\u00020\u0001:\n¯\u0001°\u0001±\u0001²\u0001³\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020AJ\u0006\u0010z\u001a\u00020xJ\u0010\u0010{\u001a\u00020\u001e2\u0006\u0010|\u001a\u00020}H\u0014J\u0010\u0010~\u001a\u00020\u001e2\u0006\u0010|\u001a\u00020\u007fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\\2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0083\u0001\u001a\u00020\u0007H\u0014J\u0012\u0010\u0084\u0001\u001a\u0002082\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0002J\u0014\u0010\u0085\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u001eH\u0002J\u001b\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0002J#\u0010\u008b\u0001\u001a\u00020x2\t\u0010\u008c\u0001\u001a\u0004\u0018\u0001082\u0007\u0010\u008d\u0001\u001a\u000208H\u0002¢\u0006\u0003\u0010\u008e\u0001J%\u0010\u008f\u0001\u001a\u00020x2\t\u0010\u008c\u0001\u001a\u0004\u0018\u0001082\t\u0010\u008d\u0001\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0003\u0010\u0090\u0001J\u0013\u0010\u0091\u0001\u001a\u00020x2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0014J'\u0010\u0094\u0001\u001a\u00020x2\u0007\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020\u00072\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0014J\u001b\u0010\u0099\u0001\u001a\u00020x2\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u0007H\u0014J\u0012\u0010\u009c\u0001\u001a\u00020\u001e2\u0007\u0010\u009d\u0001\u001a\u00020}H\u0017J\u000f\u0010\u009e\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020AJ\"\u0010\u009f\u0001\u001a\u00020x2\b\u0010\r\u001a\u0004\u0018\u0001082\t\b\u0002\u0010 \u0001\u001a\u00020\u001e¢\u0006\u0003\u0010¡\u0001J\u001a\u0010¢\u0001\u001a\u00020x2\u0006\u0010\r\u001a\u0002082\t\b\u0002\u0010 \u0001\u001a\u00020\u001eJ\t\u0010£\u0001\u001a\u00020xH\u0002J\t\u0010¤\u0001\u001a\u00020xH\u0002J.\u0010¥\u0001\u001a\u00020x2\u0007\u0010¦\u0001\u001a\u00020\\2\u0006\u0010\r\u001a\u0002082\u0007\u0010 \u0001\u001a\u00020\u001e2\t\b\u0002\u0010§\u0001\u001a\u00020\u001eH\u0002J+\u0010¨\u0001\u001a\u00020x2\b\u0010\r\u001a\u0004\u0018\u0001082\u0007\u0010 \u0001\u001a\u00020\u001e2\u0007\u0010§\u0001\u001a\u00020\u001eH\u0002¢\u0006\u0003\u0010©\u0001J%\u0010ª\u0001\u001a\u00020x2\u0006\u0010\r\u001a\u0002082\t\b\u0002\u0010 \u0001\u001a\u00020\u001e2\u0007\u0010§\u0001\u001a\u00020\u001eH\u0002J\r\u0010«\u0001\u001a\u000208*\u000208H\u0002J\r\u0010¬\u0001\u001a\u00020x*\u00020SH\u0002J\u0018\u0010\u00ad\u0001\u001a\u00020\u0007*\u0002082\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u0007H\u0003J\r\u0010\u00ad\u0001\u001a\u00020\u0007*\u00020\u0007H\u0003J\r\u0010®\u0001\u001a\u000208*\u00020\u0007H\u0002R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R(\u0010/\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R(\u00102\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u001a\u00105\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R$\u00109\u001a\u0002082\u0006\u0010\r\u001a\u000208@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\u00020\u00078BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR$\u0010E\u001a\u0002082\u0006\u0010\r\u001a\u000208@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010;\"\u0004\bG\u0010=R$\u0010H\u001a\u0002082\u0006\u0010\r\u001a\u000208@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010;\"\u0004\bJ\u0010=R\u000e\u0010K\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010X\u001a\u0004\u0018\u00010\u000e2\b\u0010W\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0011\"\u0004\bZ\u0010\u0013R\u000e\u0010[\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010^\u001a\u0004\u0018\u00010]2\b\u0010W\u001a\u0004\u0018\u00010]@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR(\u0010c\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0011\"\u0004\be\u0010\u0013R$\u0010g\u001a\u0004\u0018\u0001082\b\u0010f\u001a\u0004\u0018\u000108@BX\u0086\u000e¢\u0006\n\n\u0002\u0010j\u001a\u0004\bh\u0010iR(\u0010k\u001a\u0004\u0018\u00010]2\b\u0010W\u001a\u0004\u0018\u00010]@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010`\"\u0004\bm\u0010bR\u001e\u0010n\u001a\u0002082\u0006\u0010f\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010;R\u0012\u0010p\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010qR\u001a\u0010r\u001a\u00020\u0007*\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020\u0007*\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010t¨\u0006´\u0001"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a11yHelper", "Lcom/yandex/div/internal/widget/slider/SliderView$A11yHelper;", "activeRange", "Lcom/yandex/div/internal/widget/slider/SliderView$ActiveRange;", "value", "Landroid/graphics/drawable/Drawable;", "activeTickMarkDrawable", "getActiveTickMarkDrawable", "()Landroid/graphics/drawable/Drawable;", "setActiveTickMarkDrawable", "(Landroid/graphics/drawable/Drawable;)V", "activeTrackDrawable", "getActiveTrackDrawable", "setActiveTrackDrawable", "", "animationDuration", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "animationEnabled", "", "getAnimationEnabled", "()Z", "setAnimationEnabled", "(Z)V", "animationInterpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "getAnimationInterpolator", "()Landroid/view/animation/AccelerateDecelerateInterpolator;", "setAnimationInterpolator", "(Landroid/view/animation/AccelerateDecelerateInterpolator;)V", "animatorListener", "com/yandex/div/internal/widget/slider/SliderView$animatorListener$1", "Lcom/yandex/div/internal/widget/slider/SliderView$animatorListener$1;", "animatorSecondaryListener", "com/yandex/div/internal/widget/slider/SliderView$animatorSecondaryListener$1", "Lcom/yandex/div/internal/widget/slider/SliderView$animatorSecondaryListener$1;", "inactiveTickMarkDrawable", "getInactiveTickMarkDrawable", "setInactiveTickMarkDrawable", "inactiveTrackDrawable", "getInactiveTrackDrawable", "setInactiveTrackDrawable", "interactive", "getInteractive", "setInteractive", "", "interceptionAngle", "getInterceptionAngle", "()F", "setInterceptionAngle", "(F)V", "interceptionAngleTg", "listeners", "Lcom/yandex/div/core/ObserverList;", "Lcom/yandex/div/internal/widget/slider/SliderView$ChangedListener;", "maxTickmarkOrThumbWidth", "getMaxTickmarkOrThumbWidth", "()I", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "prevX", "prevY", "ranges", "", "Lcom/yandex/div/internal/widget/slider/SliderView$Range;", "getRanges", "()Ljava/util/List;", "sliderAnimator", "Landroid/animation/ValueAnimator;", "sliderDrawDelegate", "Lcom/yandex/div/internal/widget/slider/SliderDrawDelegate;", "sliderSecondaryAnimator", "drawable", "thumbDrawable", "getThumbDrawable", "setThumbDrawable", "thumbOnTouch", "Lcom/yandex/div/internal/widget/slider/SliderView$Thumb;", "Lcom/yandex/div/internal/widget/slider/shapes/TextDrawable;", "thumbSecondTextDrawable", "getThumbSecondTextDrawable", "()Lcom/yandex/div/internal/widget/slider/shapes/TextDrawable;", "setThumbSecondTextDrawable", "(Lcom/yandex/div/internal/widget/slider/shapes/TextDrawable;)V", "thumbSecondaryDrawable", "getThumbSecondaryDrawable", "setThumbSecondaryDrawable", "<set-?>", "thumbSecondaryValue", "getThumbSecondaryValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "thumbTextDrawable", "getThumbTextDrawable", "setThumbTextDrawable", "thumbValue", "getThumbValue", "touchSlop", "Ljava/lang/Integer;", "boundsHeight", "getBoundsHeight", "(Landroid/graphics/drawable/Drawable;)I", "boundsWidth", "getBoundsWidth", "addOnThumbChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "clearOnThumbChangedListener", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "getClosestThumb", b9.h.L, "getSuggestedMinimumHeight", "getSuggestedMinimumWidth", "getTouchValue", "getTrackLength", "viewWidth", "isThumbSecondaryEnabled", "measureDimension", "desiredSize", "measureSpec", "notifyThumbChangedListeners", "prevValue", "newValue", "(Ljava/lang/Float;F)V", "notifyThumbSecondaryChangedListeners", "(Ljava/lang/Float;Ljava/lang/Float;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "ev", "removeOnChangedListener", "setThumbSecondaryValue", "animated", "(Ljava/lang/Float;Z)V", "setThumbValue", "setThumbsInBoarders", "setThumbsOnTickMarks", "setValueToThumb", "thumb", "forced", "trySetThumbSecondaryValue", "(Ljava/lang/Float;ZZ)V", "trySetThumbValue", "inBoarders", "setBaseParams", "toPosition", "toValue", "A11yHelper", "ActiveRange", "ChangedListener", "Range", "Thumb", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SliderView extends View {
    private final A11yHelper a11yHelper;
    private final ActiveRange activeRange;
    private Drawable activeTickMarkDrawable;
    private Drawable activeTrackDrawable;
    private long animationDuration;
    private boolean animationEnabled;
    private AccelerateDecelerateInterpolator animationInterpolator;
    private final SliderView$animatorListener$1 animatorListener;
    private final SliderView$animatorSecondaryListener$1 animatorSecondaryListener;
    private Drawable inactiveTickMarkDrawable;
    private Drawable inactiveTrackDrawable;
    private boolean interactive;
    private float interceptionAngle;
    private float interceptionAngleTg;
    private final ObserverList<ChangedListener> listeners;
    private int maxTickmarkOrThumbWidth;
    private float maxValue;
    private float minValue;
    private float prevX;
    private float prevY;
    private final List<Range> ranges;
    private ValueAnimator sliderAnimator;
    private final SliderDrawDelegate sliderDrawDelegate;
    private ValueAnimator sliderSecondaryAnimator;
    private Drawable thumbDrawable;
    private Thumb thumbOnTouch;
    private TextDrawable thumbSecondTextDrawable;
    private Drawable thumbSecondaryDrawable;
    private Float thumbSecondaryValue;
    private TextDrawable thumbTextDrawable;
    private float thumbValue;
    private Integer touchSlop;

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderView$ChangedListener;", "", "onThumbSecondaryValueChanged", "", "value", "", "(Ljava/lang/Float;)V", "onThumbValueChanged", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface ChangedListener {
        default void onThumbSecondaryValueChanged(Float value) {
        }

        default void onThumbValueChanged(float value) {
        }
    }

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderView$Thumb;", "", "(Ljava/lang/String;I)V", "THUMB", "THUMB_SECONDARY", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum Thumb {
        THUMB,
        THUMB_SECONDARY
    }

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Thumb.values().length];
            try {
                iArr[Thumb.THUMB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Thumb.THUMB_SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SliderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SliderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SliderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sliderDrawDelegate = new SliderDrawDelegate();
        this.listeners = new ObserverList<>();
        this.animatorListener = new SliderView$animatorListener$1(this);
        this.animatorSecondaryListener = new SliderView$animatorSecondaryListener$1(this);
        this.ranges = new ArrayList();
        this.animationDuration = 300L;
        this.animationInterpolator = new AccelerateDecelerateInterpolator();
        this.animationEnabled = true;
        this.maxValue = 100.0f;
        this.thumbValue = this.minValue;
        A11yHelper a11yHelper = new A11yHelper(this, this);
        this.a11yHelper = a11yHelper;
        ViewCompat.setAccessibilityDelegate(this, a11yHelper);
        setAccessibilityLiveRegion(1);
        this.maxTickmarkOrThumbWidth = -1;
        this.activeRange = new ActiveRange();
        this.thumbOnTouch = Thumb.THUMB;
        this.interactive = true;
        this.interceptionAngle = 45.0f;
        this.interceptionAngleTg = (float) Math.tan(45.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyThumbChangedListeners(Float prevValue, float newValue) {
        if (Intrinsics.areEqual(prevValue, newValue)) {
            return;
        }
        Iterator<ChangedListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onThumbValueChanged(newValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyThumbSecondaryChangedListeners(Float prevValue, Float newValue) {
        if (Intrinsics.areEqual(prevValue, newValue)) {
            return;
        }
        Iterator<ChangedListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onThumbSecondaryValueChanged(newValue);
        }
    }

    public final List<Range> getRanges() {
        return this.ranges;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        if (this.animationDuration == j || j < 0) {
            return;
        }
        this.animationDuration = j;
    }

    public final AccelerateDecelerateInterpolator getAnimationInterpolator() {
        return this.animationInterpolator;
    }

    public final void setAnimationInterpolator(AccelerateDecelerateInterpolator accelerateDecelerateInterpolator) {
        Intrinsics.checkNotNullParameter(accelerateDecelerateInterpolator, "<set-?>");
        this.animationInterpolator = accelerateDecelerateInterpolator;
    }

    public final boolean getAnimationEnabled() {
        return this.animationEnabled;
    }

    public final void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    public final float getMinValue() {
        return this.minValue;
    }

    public final void setMinValue(float f) {
        if (this.minValue == f) {
            return;
        }
        setMaxValue(Math.max(this.maxValue, 1.0f + f));
        this.minValue = f;
        setThumbsInBoarders();
        invalidate();
    }

    public final float getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(float f) {
        if (this.maxValue == f) {
            return;
        }
        setMinValue(Math.min(this.minValue, f - 1.0f));
        this.maxValue = f;
        setThumbsInBoarders();
        invalidate();
    }

    public final Drawable getActiveTickMarkDrawable() {
        return this.activeTickMarkDrawable;
    }

    public final void setActiveTickMarkDrawable(Drawable drawable) {
        this.activeTickMarkDrawable = drawable;
        this.maxTickmarkOrThumbWidth = -1;
        setThumbsOnTickMarks();
        invalidate();
    }

    public final Drawable getInactiveTickMarkDrawable() {
        return this.inactiveTickMarkDrawable;
    }

    public final void setInactiveTickMarkDrawable(Drawable drawable) {
        this.inactiveTickMarkDrawable = drawable;
        this.maxTickmarkOrThumbWidth = -1;
        setThumbsOnTickMarks();
        invalidate();
    }

    public final Drawable getActiveTrackDrawable() {
        return this.activeTrackDrawable;
    }

    public final void setActiveTrackDrawable(Drawable drawable) {
        this.activeTrackDrawable = drawable;
        invalidate();
    }

    public final Drawable getInactiveTrackDrawable() {
        return this.inactiveTrackDrawable;
    }

    public final void setInactiveTrackDrawable(Drawable drawable) {
        this.inactiveTrackDrawable = drawable;
        invalidate();
    }

    public final float getThumbValue() {
        return this.thumbValue;
    }

    public static /* synthetic */ void setThumbValue$default(SliderView sliderView, float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setThumbValue");
        }
        if ((i & 2) != 0) {
            z = sliderView.animationEnabled;
        }
        sliderView.setThumbValue(f, z);
    }

    public final void setThumbValue(float value, boolean animated) {
        trySetThumbValue(value, animated, true);
    }

    static /* synthetic */ void trySetThumbValue$default(SliderView sliderView, float f, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trySetThumbValue");
        }
        if ((i & 2) != 0) {
            z = sliderView.animationEnabled;
        }
        sliderView.trySetThumbValue(f, z, z2);
    }

    private final void trySetThumbValue(float value, boolean animated, boolean forced) {
        ValueAnimator valueAnimator;
        float fInBoarders = inBoarders(value);
        float f = this.thumbValue;
        if (f == fInBoarders) {
            return;
        }
        if (animated && this.animationEnabled) {
            if (this.sliderAnimator == null) {
                this.animatorListener.setPrevThumbValue(f);
            }
            ValueAnimator valueAnimator2 = this.sliderAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            ValueAnimator trySetThumbValue$lambda$3 = ValueAnimator.ofFloat(this.thumbValue, fInBoarders);
            trySetThumbValue$lambda$3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yandex.div.internal.widget.slider.SliderView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    SliderView.trySetThumbValue$lambda$3$lambda$2(this.f$0, valueAnimator3);
                }
            });
            trySetThumbValue$lambda$3.addListener(this.animatorListener);
            Intrinsics.checkNotNullExpressionValue(trySetThumbValue$lambda$3, "trySetThumbValue$lambda$3");
            setBaseParams(trySetThumbValue$lambda$3);
            trySetThumbValue$lambda$3.start();
            this.sliderAnimator = trySetThumbValue$lambda$3;
        } else {
            if (forced && (valueAnimator = this.sliderAnimator) != null) {
                valueAnimator.cancel();
            }
            if (forced || this.sliderAnimator == null) {
                this.animatorListener.setPrevThumbValue(this.thumbValue);
                this.thumbValue = fInBoarders;
                notifyThumbChangedListeners(Float.valueOf(this.animatorListener.getPrevThumbValue()), this.thumbValue);
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trySetThumbValue$lambda$3$lambda$2(SliderView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.thumbValue = ((Float) animatedValue).floatValue();
        this$0.postInvalidateOnAnimation();
    }

    public final Drawable getThumbDrawable() {
        return this.thumbDrawable;
    }

    public final void setThumbDrawable(Drawable drawable) {
        this.thumbDrawable = drawable;
        this.maxTickmarkOrThumbWidth = -1;
        invalidate();
    }

    public final TextDrawable getThumbTextDrawable() {
        return this.thumbTextDrawable;
    }

    public final void setThumbTextDrawable(TextDrawable textDrawable) {
        this.thumbTextDrawable = textDrawable;
        invalidate();
    }

    public final Float getThumbSecondaryValue() {
        return this.thumbSecondaryValue;
    }

    public static /* synthetic */ void setThumbSecondaryValue$default(SliderView sliderView, Float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setThumbSecondaryValue");
        }
        if ((i & 2) != 0) {
            z = sliderView.animationEnabled;
        }
        sliderView.setThumbSecondaryValue(f, z);
    }

    public final void setThumbSecondaryValue(Float value, boolean animated) {
        trySetThumbSecondaryValue(value, animated, true);
    }

    private final void trySetThumbSecondaryValue(Float value, boolean animated, boolean forced) {
        ValueAnimator valueAnimator;
        Float f;
        Float fValueOf = value != null ? Float.valueOf(inBoarders(value.floatValue())) : null;
        if (Intrinsics.areEqual(this.thumbSecondaryValue, fValueOf)) {
            return;
        }
        if (animated && this.animationEnabled && (f = this.thumbSecondaryValue) != null && fValueOf != null) {
            if (this.sliderSecondaryAnimator == null) {
                this.animatorSecondaryListener.setPrevThumbSecondaryValue(f);
            }
            ValueAnimator valueAnimator2 = this.sliderSecondaryAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            Float f2 = this.thumbSecondaryValue;
            Intrinsics.checkNotNull(f2);
            ValueAnimator trySetThumbSecondaryValue$lambda$5 = ValueAnimator.ofFloat(f2.floatValue(), fValueOf.floatValue());
            trySetThumbSecondaryValue$lambda$5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yandex.div.internal.widget.slider.SliderView$$ExternalSyntheticLambda1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    SliderView.trySetThumbSecondaryValue$lambda$5$lambda$4(this.f$0, valueAnimator3);
                }
            });
            trySetThumbSecondaryValue$lambda$5.addListener(this.animatorSecondaryListener);
            Intrinsics.checkNotNullExpressionValue(trySetThumbSecondaryValue$lambda$5, "trySetThumbSecondaryValue$lambda$5");
            setBaseParams(trySetThumbSecondaryValue$lambda$5);
            trySetThumbSecondaryValue$lambda$5.start();
            this.sliderSecondaryAnimator = trySetThumbSecondaryValue$lambda$5;
        } else {
            if (forced && (valueAnimator = this.sliderSecondaryAnimator) != null) {
                valueAnimator.cancel();
            }
            if (forced || this.sliderSecondaryAnimator == null) {
                this.animatorSecondaryListener.setPrevThumbSecondaryValue(this.thumbSecondaryValue);
                this.thumbSecondaryValue = fValueOf;
                notifyThumbSecondaryChangedListeners(this.animatorSecondaryListener.getPrevThumbSecondaryValue(), this.thumbSecondaryValue);
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trySetThumbSecondaryValue$lambda$5$lambda$4(SliderView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.thumbSecondaryValue = (Float) animatedValue;
        this$0.postInvalidateOnAnimation();
    }

    public final Drawable getThumbSecondaryDrawable() {
        return this.thumbSecondaryDrawable;
    }

    public final void setThumbSecondaryDrawable(Drawable drawable) {
        this.thumbSecondaryDrawable = drawable;
        this.maxTickmarkOrThumbWidth = -1;
        invalidate();
    }

    public final TextDrawable getThumbSecondTextDrawable() {
        return this.thumbSecondTextDrawable;
    }

    public final void setThumbSecondTextDrawable(TextDrawable textDrawable) {
        this.thumbSecondTextDrawable = textDrawable;
        invalidate();
    }

    private final int getMaxTickmarkOrThumbWidth() {
        if (this.maxTickmarkOrThumbWidth == -1) {
            this.maxTickmarkOrThumbWidth = Math.max(Math.max(getBoundsWidth(this.activeTickMarkDrawable), getBoundsWidth(this.inactiveTickMarkDrawable)), Math.max(getBoundsWidth(this.thumbDrawable), getBoundsWidth(this.thumbSecondaryDrawable)));
        }
        return this.maxTickmarkOrThumbWidth;
    }

    public final void addOnThumbChangedListener(ChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.addObserver(listener);
    }

    public final void removeOnChangedListener(ChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.removeObserver(listener);
    }

    public final void clearOnThumbChangedListener() {
        this.listeners.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight();
        int suggestedMinimumHeight = getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom();
        int iMeasureDimension = measureDimension(suggestedMinimumWidth, widthMeasureSpec);
        int iMeasureDimension2 = measureDimension(suggestedMinimumHeight, heightMeasureSpec);
        setMeasuredDimension(iMeasureDimension, iMeasureDimension2);
        this.sliderDrawDelegate.onMeasure(getTrackLength(iMeasureDimension), (iMeasureDimension2 - getPaddingTop()) - getPaddingBottom());
        for (Range range : this.ranges) {
            range.setStartPosition(toPosition(Math.max(range.getStartValue(), this.minValue), iMeasureDimension) + range.getMarginStart());
            range.setEndPosition(toPosition(Math.min(range.getEndValue(), this.maxValue), iMeasureDimension) - range.getMarginEnd());
        }
    }

    private final int measureDimension(int desiredSize, int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? desiredSize : size;
        }
        return Math.min(desiredSize, size);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        Integer num;
        int iMax = Math.max(getBoundsHeight(this.activeTrackDrawable), getBoundsHeight(this.inactiveTrackDrawable));
        Iterator<T> it = this.ranges.iterator();
        if (it.hasNext()) {
            Range range = (Range) it.next();
            Integer numValueOf = Integer.valueOf(Math.max(getBoundsHeight(range.getActiveTrackDrawable()), getBoundsHeight(range.getInactiveTrackDrawable())));
            while (it.hasNext()) {
                Range range2 = (Range) it.next();
                Integer numValueOf2 = Integer.valueOf(Math.max(getBoundsHeight(range2.getActiveTrackDrawable()), getBoundsHeight(range2.getInactiveTrackDrawable())));
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        Integer num2 = num;
        return Math.max(Math.max(getBoundsHeight(this.thumbDrawable), getBoundsHeight(this.thumbSecondaryDrawable)), Math.max(iMax, num2 != null ? num2.intValue() : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getBoundsWidth(Drawable drawable) {
        Rect bounds;
        if (drawable == null || (bounds = drawable.getBounds()) == null) {
            return 0;
        }
        return bounds.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getBoundsHeight(Drawable drawable) {
        Rect bounds;
        if (drawable == null || (bounds = drawable.getBounds()) == null) {
            return 0;
        }
        return bounds.height();
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        int iMax = Math.max(Math.max(getBoundsWidth(this.thumbDrawable), getBoundsWidth(this.thumbSecondaryDrawable)), Math.max(getBoundsWidth(this.activeTrackDrawable), getBoundsWidth(this.inactiveTrackDrawable)) * ((int) ((this.maxValue - this.minValue) + 1)));
        TextDrawable textDrawable = this.thumbTextDrawable;
        int intrinsicWidth = textDrawable != null ? textDrawable.getIntrinsicWidth() : 0;
        TextDrawable textDrawable2 = this.thumbSecondTextDrawable;
        return Math.max(iMax, Math.max(intrinsicWidth, textDrawable2 != null ? textDrawable2.getIntrinsicWidth() : 0));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        int i;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getPaddingLeft() + (getMaxTickmarkOrThumbWidth() / 2), getPaddingTop());
        int iSave = canvas.save();
        for (Range range : this.ranges) {
            canvas.clipRect(range.getStartPosition() - range.getMarginStart(), 0.0f, range.getEndPosition() + range.getMarginEnd(), getHeight(), Region.Op.DIFFERENCE);
        }
        this.sliderDrawDelegate.drawInactiveTrack(canvas, this.inactiveTrackDrawable);
        float start = this.activeRange.getStart();
        float end = this.activeRange.getEnd();
        int position$default = toPosition$default(this, start, 0, 1, null);
        int position$default2 = toPosition$default(this, end, 0, 1, null);
        this.sliderDrawDelegate.drawTrackPart(canvas, this.activeTrackDrawable, RangesKt.coerceAtMost(position$default, position$default2), RangesKt.coerceAtLeast(position$default2, position$default));
        canvas.restoreToCount(iSave);
        for (Range range2 : this.ranges) {
            if (range2.getEndPosition() < position$default || range2.getStartPosition() > position$default2) {
                i = position$default2;
                onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getInactiveTrackDrawable(), 0, 0, 48, null);
            } else if (range2.getStartPosition() < position$default || range2.getEndPosition() > position$default2) {
                i = position$default2;
                if (range2.getStartPosition() < position$default && range2.getEndPosition() <= i) {
                    onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getInactiveTrackDrawable(), 0, RangesKt.coerceAtLeast(position$default - 1, range2.getStartPosition()), 16, null);
                    onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getActiveTrackDrawable(), position$default, 0, 32, null);
                } else if (range2.getStartPosition() >= position$default && range2.getEndPosition() > i) {
                    onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getActiveTrackDrawable(), 0, i, 16, null);
                    onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getInactiveTrackDrawable(), RangesKt.coerceAtMost(i + 1, range2.getEndPosition()), 0, 32, null);
                } else {
                    onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getInactiveTrackDrawable(), 0, 0, 48, null);
                    onDraw$lambda$10$drawTrackPart(range2, this, canvas, range2.getActiveTrackDrawable(), position$default, i);
                }
            } else {
                i = position$default2;
                onDraw$lambda$10$drawTrackPart$default(range2, this, canvas, range2.getActiveTrackDrawable(), 0, 0, 48, null);
            }
            position$default2 = i;
        }
        int i2 = (int) this.minValue;
        int i3 = (int) this.maxValue;
        if (i2 <= i3) {
            while (true) {
                int i4 = (int) start;
                if (i2 <= ((int) end) && i4 <= i2) {
                    drawable = this.activeTickMarkDrawable;
                } else {
                    drawable = this.inactiveTickMarkDrawable;
                }
                this.sliderDrawDelegate.drawOnPosition(canvas, drawable, toPosition(i2));
                if (i2 == i3) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.sliderDrawDelegate.drawThumb(canvas, toPosition$default(this, this.thumbValue, 0, 1, null), this.thumbDrawable, (int) this.thumbValue, this.thumbTextDrawable);
        if (isThumbSecondaryEnabled()) {
            SliderDrawDelegate sliderDrawDelegate = this.sliderDrawDelegate;
            Float f = this.thumbSecondaryValue;
            Intrinsics.checkNotNull(f);
            int position$default3 = toPosition$default(this, f.floatValue(), 0, 1, null);
            Drawable drawable2 = this.thumbSecondaryDrawable;
            Float f2 = this.thumbSecondaryValue;
            Intrinsics.checkNotNull(f2);
            sliderDrawDelegate.drawThumb(canvas, position$default3, drawable2, (int) f2.floatValue(), this.thumbSecondTextDrawable);
        }
        canvas.restore();
    }

    static /* synthetic */ void onDraw$lambda$10$drawTrackPart$default(Range range, SliderView sliderView, Canvas canvas, Drawable drawable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDraw$lambda$10$drawTrackPart");
        }
        if ((i3 & 16) != 0) {
            i = range.getStartPosition();
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = range.getEndPosition();
        }
        onDraw$lambda$10$drawTrackPart(range, sliderView, canvas, drawable, i4, i2);
    }

    private static final void onDraw$lambda$10$drawTrackPart(Range range, SliderView sliderView, Canvas canvas, Drawable drawable, int i, int i2) {
        sliderView.sliderDrawDelegate.drawTrackPart(canvas, drawable, i, i2);
    }

    public final boolean getInteractive() {
        return this.interactive;
    }

    public final void setInteractive(boolean z) {
        this.interactive = z;
    }

    public final float getInterceptionAngle() {
        return this.interceptionAngle;
    }

    public final void setInterceptionAngle(float f) {
        float fMax = Math.max(45.0f, Math.abs(f) % 90);
        this.interceptionAngle = fMax;
        this.interceptionAngleTg = (float) Math.tan(fMax);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int scaledTouchSlop;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.interactive) {
            return false;
        }
        int x = (((int) ev.getX()) - getPaddingLeft()) - (getMaxTickmarkOrThumbWidth() / 2);
        int action = ev.getAction();
        if (action == 0) {
            Thumb closestThumb = getClosestThumb(x);
            this.thumbOnTouch = closestThumb;
            setValueToThumb$default(this, closestThumb, getTouchValue(x), this.animationEnabled, false, 8, null);
            this.prevX = ev.getX();
            this.prevY = ev.getY();
            return true;
        }
        if (action == 1) {
            setValueToThumb$default(this, this.thumbOnTouch, getTouchValue(x), this.animationEnabled, false, 8, null);
            return true;
        }
        if (action != 2) {
            return false;
        }
        setValueToThumb(this.thumbOnTouch, getTouchValue(x), false, true);
        Integer num = this.touchSlop;
        if (num != null) {
            scaledTouchSlop = num.intValue();
        } else {
            scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            this.touchSlop = Integer.valueOf(scaledTouchSlop);
        }
        float fAbs = Math.abs(ev.getY() - this.prevY);
        if (fAbs < scaledTouchSlop) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            getParent().requestDisallowInterceptTouchEvent(fAbs / Math.abs(ev.getX() - this.prevX) <= this.interceptionAngleTg);
        }
        this.prevX = ev.getX();
        this.prevY = ev.getY();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Thumb getClosestThumb(int position) {
        if (!isThumbSecondaryEnabled()) {
            return Thumb.THUMB;
        }
        int iAbs = Math.abs(position - toPosition$default(this, this.thumbValue, 0, 1, null));
        Float f = this.thumbSecondaryValue;
        Intrinsics.checkNotNull(f);
        if (iAbs < Math.abs(position - toPosition$default(this, f.floatValue(), 0, 1, null))) {
            return Thumb.THUMB;
        }
        return Thumb.THUMB_SECONDARY;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        this.a11yHelper.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.a11yHelper.dispatchHoverEvent(event) || super.dispatchHoverEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.a11yHelper.dispatchKeyEvent(event) || super.dispatchKeyEvent(event);
    }

    static /* synthetic */ void setValueToThumb$default(SliderView sliderView, Thumb thumb, float f, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setValueToThumb");
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        sliderView.setValueToThumb(thumb, f, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setValueToThumb(Thumb thumb, float value, boolean animated, boolean forced) {
        int i = WhenMappings.$EnumSwitchMapping$0[thumb.ordinal()];
        if (i == 1) {
            trySetThumbValue(value, animated, forced);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            trySetThumbSecondaryValue(Float.valueOf(value), animated, forced);
        }
    }

    private final float getTouchValue(int position) {
        if (this.inactiveTickMarkDrawable != null || this.activeTickMarkDrawable != null) {
            return MathKt.roundToInt(toValue(position));
        }
        return toValue(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isThumbSecondaryEnabled() {
        return this.thumbSecondaryValue != null;
    }

    private final void setThumbsInBoarders() {
        trySetThumbValue(inBoarders(this.thumbValue), false, true);
        if (isThumbSecondaryEnabled()) {
            Float f = this.thumbSecondaryValue;
            trySetThumbSecondaryValue(f != null ? Float.valueOf(inBoarders(f.floatValue())) : null, false, true);
        }
    }

    private final void setThumbsOnTickMarks() {
        trySetThumbValue(MathKt.roundToInt(this.thumbValue), false, true);
        Float f = this.thumbSecondaryValue;
        if (f != null) {
            trySetThumbSecondaryValue(Float.valueOf(MathKt.roundToInt(f.floatValue())), false, true);
        }
    }

    static /* synthetic */ int toPosition$default(SliderView sliderView, float f, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toPosition");
        }
        if ((i2 & 1) != 0) {
            i = sliderView.getWidth();
        }
        return sliderView.toPosition(f, i);
    }

    private final int toPosition(float f, int i) {
        return MathKt.roundToInt((getTrackLength(i) / (this.maxValue - this.minValue)) * (ViewsKt.isLayoutRtl(this) ? this.maxValue - f : f - this.minValue));
    }

    static /* synthetic */ int getTrackLength$default(SliderView sliderView, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTrackLength");
        }
        if ((i2 & 1) != 0) {
            i = sliderView.getWidth();
        }
        return sliderView.getTrackLength(i);
    }

    private final int getTrackLength(int viewWidth) {
        return ((viewWidth - getPaddingLeft()) - getPaddingRight()) - getMaxTickmarkOrThumbWidth();
    }

    private final int toPosition(int i) {
        return toPosition$default(this, i, 0, 1, null);
    }

    private final float toValue(int i) {
        float f = this.minValue;
        float trackLength$default = (i * (this.maxValue - f)) / getTrackLength$default(this, 0, 1, null);
        if (ViewsKt.isLayoutRtl(this)) {
            trackLength$default = (this.maxValue - trackLength$default) - 1;
        }
        return f + trackLength$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float inBoarders(float f) {
        return Math.min(Math.max(f, this.minValue), this.maxValue);
    }

    private final void setBaseParams(ValueAnimator valueAnimator) {
        valueAnimator.setDuration(this.animationDuration);
        valueAnimator.setInterpolator(this.animationInterpolator);
    }

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderView$ActiveRange;", "", "(Lcom/yandex/div/internal/widget/slider/SliderView;)V", "end", "", "getEnd", "()F", "start", "getStart", "max", "one", "another", "(FLjava/lang/Float;)F", "min", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class ActiveRange {
        public ActiveRange() {
        }

        public final float getStart() {
            if (!SliderView.this.isThumbSecondaryEnabled()) {
                return SliderView.this.getMinValue();
            }
            return min(SliderView.this.getThumbValue(), SliderView.this.getThumbSecondaryValue());
        }

        public final float getEnd() {
            if (!SliderView.this.isThumbSecondaryEnabled()) {
                return SliderView.this.getThumbValue();
            }
            return max(SliderView.this.getThumbValue(), SliderView.this.getThumbSecondaryValue());
        }

        private final float min(float one, Float another) {
            if (another == null) {
                return one;
            }
            another.floatValue();
            return Math.min(one, another.floatValue());
        }

        private final float max(float one, Float another) {
            if (another == null) {
                return one;
            }
            another.floatValue();
            return Math.max(one, another.floatValue());
        }
    }

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u0006$"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderView$Range;", "", "()V", "activeTrackDrawable", "Landroid/graphics/drawable/Drawable;", "getActiveTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "setActiveTrackDrawable", "(Landroid/graphics/drawable/Drawable;)V", "endPosition", "", "getEndPosition", "()I", "setEndPosition", "(I)V", "endValue", "", "getEndValue", "()F", "setEndValue", "(F)V", "inactiveTrackDrawable", "getInactiveTrackDrawable", "setInactiveTrackDrawable", "marginEnd", "getMarginEnd", "setMarginEnd", "marginStart", "getMarginStart", "setMarginStart", "startPosition", "getStartPosition", "setStartPosition", "startValue", "getStartValue", "setStartValue", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Range {
        private Drawable activeTrackDrawable;
        private int endPosition;
        private float endValue;
        private Drawable inactiveTrackDrawable;
        private int marginEnd;
        private int marginStart;
        private int startPosition;
        private float startValue;

        public final float getStartValue() {
            return this.startValue;
        }

        public final void setStartValue(float f) {
            this.startValue = f;
        }

        public final float getEndValue() {
            return this.endValue;
        }

        public final void setEndValue(float f) {
            this.endValue = f;
        }

        public final int getMarginStart() {
            return this.marginStart;
        }

        public final void setMarginStart(int i) {
            this.marginStart = i;
        }

        public final int getMarginEnd() {
            return this.marginEnd;
        }

        public final void setMarginEnd(int i) {
            this.marginEnd = i;
        }

        public final Drawable getActiveTrackDrawable() {
            return this.activeTrackDrawable;
        }

        public final void setActiveTrackDrawable(Drawable drawable) {
            this.activeTrackDrawable = drawable;
        }

        public final Drawable getInactiveTrackDrawable() {
            return this.inactiveTrackDrawable;
        }

        public final void setInactiveTrackDrawable(Drawable drawable) {
            this.inactiveTrackDrawable = drawable;
        }

        public final int getStartPosition() {
            return this.startPosition;
        }

        public final void setStartPosition(int i) {
            this.startPosition = i;
        }

        public final int getEndPosition() {
            return this.endPosition;
        }

        public final void setEndPosition(int i) {
            this.endPosition = i;
        }
    }

    /* JADX INFO: compiled from: SliderView.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0014J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\bH\u0002J\f\u0010\"\u001a\u00020#*\u00020\bH\u0002J\f\u0010$\u001a\u00020\r*\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006%"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderView$A11yHelper;", "Landroidx/customview/widget/ExploreByTouchHelper;", "slider", "Lcom/yandex/div/internal/widget/slider/SliderView;", "(Lcom/yandex/div/internal/widget/slider/SliderView;Lcom/yandex/div/internal/widget/slider/SliderView;)V", "bounds", "Landroid/graphics/Rect;", "step", "", "getStep", "()I", "getVirtualViewAt", VastAttributes.HORIZONTAL_POSITION, "", VastAttributes.VERTICAL_POSITION, "getVisibleVirtualViews", "", "virtualViewIds", "", "onPerformActionForVirtualView", "", "virtualViewId", "action", "arguments", "Landroid/os/Bundle;", "onPopulateNodeForVirtualView", "node", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setThumbValue", "value", "startOrEndDescription", "", "updateBounds", "index", "toThumb", "Lcom/yandex/div/internal/widget/slider/SliderView$Thumb;", "toThumbValue", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class A11yHelper extends ExploreByTouchHelper {
        private final Rect bounds;
        private final SliderView slider;
        final /* synthetic */ SliderView this$0;

        /* JADX INFO: compiled from: SliderView.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Thumb.values().length];
                try {
                    iArr[Thumb.THUMB.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Thumb.THUMB_SECONDARY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public A11yHelper(SliderView sliderView, SliderView slider) {
            super(slider);
            Intrinsics.checkNotNullParameter(slider, "slider");
            this.this$0 = sliderView;
            this.slider = slider;
            this.bounds = new Rect();
        }

        private final int getStep() {
            return Math.max(MathKt.roundToInt(((double) (this.this$0.getMaxValue() - this.this$0.getMinValue())) * 0.05d), 1);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x, float y) {
            if (x < this.this$0.getLeftPaddingOffset()) {
                return 0;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.getClosestThumb((int) x).ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
            virtualViewIds.add(0);
            if (this.this$0.getThumbSecondaryValue() != null) {
                virtualViewIds.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            Intrinsics.checkNotNullParameter(node, "node");
            node.setClassName(SeekBar.class.getName());
            node.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(0, this.this$0.getMinValue(), this.this$0.getMaxValue(), toThumbValue(virtualViewId)));
            StringBuilder sb = new StringBuilder();
            CharSequence contentDescription = this.slider.getContentDescription();
            if (contentDescription != null) {
                sb.append(contentDescription).append(StringUtils.COMMA);
            }
            sb.append(startOrEndDescription(virtualViewId));
            node.setContentDescription(sb.toString());
            node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            updateBounds(virtualViewId);
            node.setBoundsInParent(this.bounds);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (action == 4096) {
                setThumbValue(virtualViewId, toThumbValue(virtualViewId) + getStep());
                return true;
            }
            if (action != 8192) {
                if (action != 16908349 || arguments == null || !arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    return false;
                }
                setThumbValue(virtualViewId, arguments.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE));
                return true;
            }
            setThumbValue(virtualViewId, toThumbValue(virtualViewId) - getStep());
            return true;
        }

        private final String startOrEndDescription(int virtualViewId) {
            if (this.this$0.getThumbSecondaryValue() == null) {
                return "";
            }
            if (virtualViewId == 0) {
                String string = this.this$0.getContext().getString(R.string.div_slider_range_start);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.div_slider_range_start)");
                return string;
            }
            if (virtualViewId != 1) {
                return "";
            }
            String string2 = this.this$0.getContext().getString(R.string.div_slider_range_end);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.div_slider_range_end)");
            return string2;
        }

        private final void updateBounds(int index) {
            int boundsWidth;
            int boundsHeight;
            if (index == 1) {
                SliderView sliderView = this.this$0;
                boundsWidth = sliderView.getBoundsWidth(sliderView.getThumbSecondaryDrawable());
                SliderView sliderView2 = this.this$0;
                boundsHeight = sliderView2.getBoundsHeight(sliderView2.getThumbSecondaryDrawable());
            } else {
                SliderView sliderView3 = this.this$0;
                boundsWidth = sliderView3.getBoundsWidth(sliderView3.getThumbDrawable());
                SliderView sliderView4 = this.this$0;
                boundsHeight = sliderView4.getBoundsHeight(sliderView4.getThumbDrawable());
            }
            int position$default = SliderView.toPosition$default(this.this$0, toThumbValue(index), 0, 1, null) + this.slider.getPaddingLeft();
            this.bounds.left = position$default;
            this.bounds.right = position$default + boundsWidth;
            int i = boundsHeight / 2;
            this.bounds.top = (this.slider.getHeight() / 2) - i;
            this.bounds.bottom = (this.slider.getHeight() / 2) + i;
        }

        private final void setThumbValue(int virtualViewId, float value) {
            this.this$0.setValueToThumb(toThumb(virtualViewId), this.this$0.inBoarders(value), false, true);
            sendEventForVirtualView(virtualViewId, 4);
            invalidateVirtualView(virtualViewId);
        }

        private final Thumb toThumb(int i) {
            if (i == 0) {
                return Thumb.THUMB;
            }
            return this.this$0.getThumbSecondaryValue() != null ? Thumb.THUMB_SECONDARY : Thumb.THUMB;
        }

        private final float toThumbValue(int i) {
            if (i == 0) {
                return this.this$0.getThumbValue();
            }
            Float thumbSecondaryValue = this.this$0.getThumbSecondaryValue();
            return thumbSecondaryValue != null ? thumbSecondaryValue.floatValue() : this.this$0.getThumbValue();
        }
    }
}
