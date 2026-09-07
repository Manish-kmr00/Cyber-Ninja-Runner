package com.yandex.div.core.view2.divs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewGroupKt;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.expression.ExpressionFallbacksHelperKt;
import com.yandex.div.core.expression.ExpressionsRuntime;
import com.yandex.div.core.expression.local.ChildPathUnitCache;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.font.DivTypefaceProvider;
import com.yandex.div.core.state.DivPathUtils;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.DivBinder;
import com.yandex.div.core.view2.DivGestureListener;
import com.yandex.div.core.view2.DivVisibilityActionTracker;
import com.yandex.div.core.view2.animations.UtilsKt;
import com.yandex.div.core.view2.divs.widgets.BitmapEffectHelper;
import com.yandex.div.core.view2.divs.widgets.DivBorderDrawer;
import com.yandex.div.core.view2.divs.widgets.DivBorderSupports;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.core.view2.divs.widgets.DivStateLayout;
import com.yandex.div.core.view2.reuse.InputFocusTracker;
import com.yandex.div.core.view2.spannable.TextVerticalAlignment;
import com.yandex.div.core.widget.AspectView;
import com.yandex.div.core.widget.FixedLineHeightView;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.Log;
import com.yandex.div.internal.core.DivCollectionExtensionsKt;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.core.ExpressionSubscriber;
import com.yandex.div.internal.drawable.CircleDrawable;
import com.yandex.div.internal.drawable.RoundedRectDrawable;
import com.yandex.div.internal.drawable.ScalingDrawable;
import com.yandex.div.internal.widget.AspectImageView;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.internal.widget.indicator.IndicatorParams;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.Div;
import com.yandex.div2.DivAccessibility;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivAnimation;
import com.yandex.div2.DivAspect;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivBlendMode;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivCollectionItemBuilder;
import com.yandex.div2.DivContainer;
import com.yandex.div2.DivContentAlignmentHorizontal;
import com.yandex.div2.DivContentAlignmentVertical;
import com.yandex.div2.DivDefaultIndicatorItemPlacement;
import com.yandex.div2.DivDimension;
import com.yandex.div2.DivDisappearAction;
import com.yandex.div2.DivDrawable;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFilter;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivFontWeight;
import com.yandex.div2.DivImageScale;
import com.yandex.div2.DivIndicator;
import com.yandex.div2.DivIndicatorItemPlacement;
import com.yandex.div2.DivPivot;
import com.yandex.div2.DivPivotFixed;
import com.yandex.div2.DivPivotPercentage;
import com.yandex.div2.DivRadialGradientFixedCenter;
import com.yandex.div2.DivShape;
import com.yandex.div2.DivShapeDrawable;
import com.yandex.div2.DivSightAction;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivState;
import com.yandex.div2.DivStroke;
import com.yandex.div2.DivTextAlignmentVertical;
import com.yandex.div2.DivTransform;
import com.yandex.div2.DivVariable;
import com.yandex.div2.DivVisibilityAction;
import com.yandex.div2.DivWrapContentSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: BaseDivViewExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0004\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a,\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0!H\u0000\u001a\"\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(H\u0000\u001aO\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\u00100\u001a\u001c\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0000\u001a\u001c\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u0001062\b\u00104\u001a\u0004\u0018\u000107H\u0000\u001a \u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002\u001a\u001c\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020GH\u0000\u001a!\u0010H\u001a\u00020&2\b\u0010E\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\u0010K\u001a!\u0010H\u001a\u00020&2\b\u0010E\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010:H\u0000¢\u0006\u0002\u0010L\u001a4\u0010M\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020P2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u001fH\u0000\u001a\"\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020&2\b\u0010T\u001a\u0004\u0018\u00010\u000e2\u0006\u0010U\u001a\u00020VH\u0000\u001a$\u0010W\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020\u000e2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120!H\u0002\u001a \u0010Y\u001a\u00020\u001b*\u00020\u000e2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0000\u001a\u0014\u0010Z\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010[\u001a\u00020\\H\u0000\u001a\u001b\u0010]\u001a\u00020\u001b*\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\\H\u0002¢\u0006\u0002\u0010`\u001a\u0014\u0010a\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010b\u001a\u00020\u0012H\u0002\u001a@\u0010c\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020f2\u000e\u0010g\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010\u00012\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020\u001b0!H\u0000\u001a+\u0010j\u001a\u00020\u001b\"\u0010\b\u0000\u0010k*\u00020l*\u0006\u0012\u0002\b\u00030m*\u0002Hk2\u0006\u0010n\u001a\u00020\u0012H\u0000¢\u0006\u0002\u0010o\u001a \u0001\u0010p\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010d\u001a\u00020\r2\b\u0010X\u001a\u0004\u0018\u00010q2\u000e\u0010r\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u000e\u0010t\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u000e\u0010x\u001a\n\u0012\u0004\u0012\u00020q\u0018\u00010\u00012\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010|H\u0000\u001a\u001c\u0010}\u001a\u00020\u001b*\u00020~2\u0006\u0010\u007f\u001a\u00020&2\u0006\u0010;\u001a\u00020<H\u0000\u001a\u0016\u0010\u0080\u0001\u001a\u00020\u001b*\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020&H\u0002\u001a\u001d\u0010\u0082\u0001\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010N\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0015\u0010\u0083\u0001\u001a\u00020\u001b*\u00020\u000e2\u0006\u00109\u001a\u00020(H\u0000\u001a#\u0010\u0084\u0001\u001a\u00020\u001b*\u00020\u000e2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010P2\t\b\u0002\u0010\u0086\u0001\u001a\u00020&H\u0000\u001a\u001e\u0010\u0087\u0001\u001a\u00020\u001b*\u00020~2\u0007\u0010\u0088\u0001\u001a\u00020\\2\u0006\u0010\u007f\u001a\u00020&H\u0000\u001a5\u0010\u0089\u0001\u001a\u00020\u001b\"\r\b\u0000\u0010k*\u00020~*\u00030\u008a\u0001*\u0002Hk2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<H\u0000¢\u0006\u0003\u0010\u008c\u0001\u001a!\u0010\u008d\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010\u0090\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010\u0093\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010\u0095\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010\u0097\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010\u0099\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010\u009a\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0015\u0010\u009d\u0001\u001a\u00020\u001b*\u00020\u000e2\u0006\u00109\u001a\u00020(H\u0000\u001a\u001d\u0010\u009e\u0001\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010N\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a-\u0010\u009f\u0001\u001a\u00020\u001b*\u00020\u000e2\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001aO\u0010£\u0001\u001a\u00020\u001b\"\u0010\b\u0000\u0010k*\u00020l*\u0006\u0012\u0002\b\u00030m*\u0002Hk2\u000e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120¥\u00012\u0010\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010¥\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0003\u0010§\u0001\u001a\u001d\u0010¨\u0001\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010N\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a2\u0010©\u0001\u001a\u00020\u001b*\u00020\u000e2\t\u0010N\u001a\u0005\u0018\u00010ª\u00012\u0006\u0010d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0000\u001a\u0016\u0010\u00ad\u0001\u001a\u00020\u0012*\u00030®\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0017\u0010¯\u0001\u001a\u00020\u001b*\u00020\u000e2\b\u0010°\u0001\u001a\u00030±\u0001H\u0000\u001aB\u0010²\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030´\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010³\u0001*\u00020\u000e2\u0006\u0010d\u001a\u00020\r2\t\u0010µ\u0001\u001a\u0004\u0018\u00010z2\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0000\u001a&\u0010¸\u0001\u001a\u00020&\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010º\u0001\u001a\u001b\u0010¸\u0001\u001a\u00020&*\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010»\u0001\u001a&\u0010¼\u0001\u001a\u00020(\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010½\u0001\u001a\u0017\u0010¾\u0001\u001a\u00020\u001b*\u00020l2\b\u0010¿\u0001\u001a\u00030À\u0001H\u0000\u001a\u0017\u0010Á\u0001\u001a\u00020\u001b*\u00020\u000e2\b\u0010¿\u0001\u001a\u00030À\u0001H\u0000\u001a\u0017\u0010Â\u0001\u001a\u0004\u0018\u000106*\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0017\u0010Ã\u0001\u001a\u0004\u0018\u000107*\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001d\u0010Ä\u0001\u001a\u00020(*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0000\u001a\r\u0010Å\u0001\u001a\u00020\u001b*\u00020\u000eH\u0000\u001a\u0016\u0010Æ\u0001\u001a\u00020P*\u00020\u00032\u0007\u0010Ç\u0001\u001a\u00020&H\u0000\u001a(\u0010È\u0001\u001a\u00020(*\u00020\u000e2\u0007\u0010É\u0001\u001a\u00020&2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a\u0016\u0010Ì\u0001\u001a\u00020(*\u00030®\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001e\u0010Í\u0001\u001a\u00020(*\u00030Î\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a\u0010\u0010Ï\u0001\u001a\u00020\u0012*\u0005\u0018\u00010Ð\u0001H\u0000\u001a\u0016\u0010Ñ\u0001\u001a\u00020\u0012*\u00030Ò\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0016\u0010Ó\u0001\u001a\u00020\u0012*\u00030Ò\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u0016\u0010Ô\u0001\u001a\u00020\u0012*\u00030Ò\u00012\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a&\u0010Õ\u0001\u001a\u00020&\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010º\u0001\u001a\u001b\u0010Õ\u0001\u001a\u00020&*\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010»\u0001\u001a&\u0010Ö\u0001\u001a\u00020(\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010½\u0001\u001a&\u0010×\u0001\u001a\u00020&\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010º\u0001\u001a\u001b\u0010×\u0001\u001a\u00020&*\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010»\u0001\u001a&\u0010Ø\u0001\u001a\u00020(\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010½\u0001\u001a!\u0010Ù\u0001\u001a\u00030Ú\u0001*\u00020\u00032\u0007\u0010Ç\u0001\u001a\u00020&2\b\u0010Û\u0001\u001a\u00030Ú\u0001H\u0000\u001a!\u0010Ù\u0001\u001a\u00030Ú\u0001*\u00020\u00032\u0007\u0010Ü\u0001\u001a\u00020P2\b\u0010Û\u0001\u001a\u00030Ú\u0001H\u0000\u001a,\u0010Ý\u0001\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010d\u001a\u00020\r2\t\u0010µ\u0001\u001a\u0004\u0018\u00010z2\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0000\u001a&\u0010Þ\u0001\u001a\u00020&\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010º\u0001\u001a\u001b\u0010Þ\u0001\u001a\u00020&*\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010»\u0001\u001a&\u0010ß\u0001\u001a\u00020(\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>¢\u0006\u0003\u0010½\u0001\u001a\r\u0010à\u0001\u001a\u000203*\u000206H\u0000\u001a\r\u0010á\u0001\u001a\u000205*\u000207H\u0000\u001a\r\u0010â\u0001\u001a\u00020&*\u00020<H\u0000\u001a!\u0010ã\u0001\u001a\u0005\u0018\u00010ä\u0001*\u00030å\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a!\u0010ã\u0001\u001a\u0005\u0018\u00010ä\u0001*\u00030æ\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u000e\u0010ç\u0001\u001a\u00030è\u0001*\u000203H\u0000\u001a\u000f\u0010é\u0001\u001a\u00030ê\u0001*\u00030ë\u0001H\u0000\u001a.\u0010ì\u0001\u001a\u00020&*\u0005\u0018\u00010®\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001f2\f\b\u0002\u0010í\u0001\u001a\u0005\u0018\u00010î\u0001H\u0000\u001a\u000f\u0010ï\u0001\u001a\u00030ð\u0001*\u00030ñ\u0001H\u0000\u001a\u001e\u0010ò\u0001\u001a\u00020&*\u00030ó\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001e\u0010ò\u0001\u001a\u00020&*\u00030ô\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001e\u0010ò\u0001\u001a\u00020&*\u00030\u0092\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001d\u0010ò\u0001\u001a\u00020&*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0000\u001a\u001e\u0010õ\u0001\u001a\u00020(*\u00030ô\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u001e\u0010õ\u0001\u001a\u00020(*\u00030ö\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\u000f\u0010÷\u0001\u001a\u00030ø\u0001*\u00030ë\u0001H\u0000\u001a\u000f\u0010ù\u0001\u001a\u00030ú\u0001*\u00030û\u0001H\u0000\u001a\u000e\u0010ü\u0001\u001a\u00030ý\u0001*\u000205H\u0000\u001a9\u0010þ\u0001\u001a\u00020\u001b*\u00020l2\b\u0010ÿ\u0001\u001a\u00030\u0080\u00022\u000e\u0010\u0081\u0002\u001a\t\u0012\u0005\u0012\u00030\u0082\u00020\u00012\u0010\u0010\u0083\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u0082\u0002\u0018\u00010\u0001H\u0001\u001a.\u0010\u0084\u0002\u001a\u00020&\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020<¢\u0006\u0003\u0010\u0085\u0002\u001a#\u0010\u0084\u0002\u001a\u00020&*\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020<¢\u0006\u0003\u0010\u0086\u0002\u001a.\u0010\u0087\u0002\u001a\u00020(\"\t\b\u0000\u0010k*\u00030¹\u0001*\u0004\u0018\u0001Hk2\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u00020<¢\u0006\u0003\u0010\u0088\u0002\"\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005\"\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\"\u001a\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00020\u0012*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0018\u0010\u0015\u001a\u00020\u0016*\u00020\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u0089\u0002"}, d2 = {"allDisappearActions", "", "Lcom/yandex/div2/DivDisappearAction;", "Lcom/yandex/div2/DivBase;", "getAllDisappearActions", "(Lcom/yandex/div2/DivBase;)Ljava/util/List;", "allSightActions", "Lcom/yandex/div2/DivSightAction;", "getAllSightActions", "allVisibilityActions", "Lcom/yandex/div2/DivVisibilityAction;", "getAllVisibilityActions", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "Landroid/view/View;", "getBindingContext", "(Landroid/view/View;)Lcom/yandex/div/core/view2/BindingContext;", "hasSightActions", "", "getHasSightActions", "(Lcom/yandex/div2/DivBase;)Z", "itemsPlacementCompat", "Lcom/yandex/div2/DivIndicatorItemPlacement;", "Lcom/yandex/div2/DivIndicator;", "getItemsPlacementCompat", "(Lcom/yandex/div2/DivIndicator;)Lcom/yandex/div2/DivIndicatorItemPlacement;", "bindItemBuilder", "", "builder", "Lcom/yandex/div2/DivCollectionItemBuilder;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "callback", "Lkotlin/Function1;", "", "createCircle", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "color", "", "radius", "", "multiplier", "createRoundedRectangle", "width", "height", "cornerRadius", "strokeWidth", "strokeColor", "(IFFFFLjava/lang/Float;Ljava/lang/Integer;)Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "evaluateGravity", "horizontal", "Lcom/yandex/div2/DivAlignmentHorizontal;", "vertical", "Lcom/yandex/div2/DivAlignmentVertical;", "Lcom/yandex/div2/DivContentAlignmentHorizontal;", "Lcom/yandex/div2/DivContentAlignmentVertical;", "evaluatePxFloatByUnit", "value", "", "unit", "Lcom/yandex/div2/DivSizeUnit;", "metrics", "Landroid/util/DisplayMetrics;", "getRuntimeFor", "Lcom/yandex/div/core/expression/ExpressionsRuntime;", "runtimeStore", "Lcom/yandex/div/core/expression/local/RuntimeStore;", "getTypeface", "Landroid/graphics/Typeface;", "fontWeight", "typefaceProvider", "Lcom/yandex/div/core/font/DivTypefaceProvider;", "getTypefaceValue", "Lcom/yandex/div2/DivFontWeight;", "fontWeightValue", "(Lcom/yandex/div2/DivFontWeight;Ljava/lang/Integer;)I", "(Lcom/yandex/div2/DivFontWeight;Ljava/lang/Long;)I", "resolveRuntime", "div", "path", "", "parentResolver", "sendAccessibilityEventUnchecked", "event", "view", "accessibilityStateProvider", "Lcom/yandex/div/core/util/AccessibilityStateProvider;", "traverseViewHierarhy", "action", "applyAlignment", "applyAlpha", "alpha", "", "applyAspectRatio", "Lcom/yandex/div/core/widget/AspectView;", "ratio", "(Lcom/yandex/div/core/widget/AspectView;Ljava/lang/Double;)V", "applyBaselineAlignment", "baselineAligned", "applyBitmapFilters", "context", "bitmap", "Landroid/graphics/Bitmap;", "filters", "Lcom/yandex/div2/DivFilter;", "actionAfterFilters", "applyClipChildren", "T", "Landroid/view/ViewGroup;", "Lcom/yandex/div/core/view2/divs/widgets/DivHolderView;", "clip", "(Landroid/view/ViewGroup;Z)V", "applyDivActions", "Lcom/yandex/div2/DivAction;", "actions", "longTapActions", "doubleTapActions", "hoverStartActions", "hoverEndActions", "pressStartActions", "pressEndActions", "actionAnimation", "Lcom/yandex/div2/DivAnimation;", "accessibility", "Lcom/yandex/div2/DivAccessibility;", "applyFontSize", "Landroid/widget/TextView;", "fontSize", "applyGravity", "newGravity", "applyHeight", "applyHorizontalWeightValue", "applyId", "divId", "viewId", "applyLetterSpacing", "letterSpacing", "applyLineHeight", "Lcom/yandex/div/core/widget/FixedLineHeightView;", "lineHeight", "(Landroid/widget/TextView;Ljava/lang/Long;Lcom/yandex/div2/DivSizeUnit;)V", "applyMargins", "insets", "Lcom/yandex/div2/DivEdgeInsets;", "applyMaxHeight", "maxHeight", "Lcom/yandex/div2/DivWrapContentSize$ConstraintSize;", "applyMaxWidth", "maxWidth", "applyMinHeight", "minHeight", "applyMinWidth", "minWidth", "applyPaddings", "applyTransform", "transform", "Lcom/yandex/div2/DivTransform;", "applyVerticalWeightValue", "applyWidth", "bindAspectRatio", "newAspect", "Lcom/yandex/div2/DivAspect;", "oldAspect", "bindClipChildren", "newClipToBounds", "Lcom/yandex/div/json/expressions/Expression;", "oldClipToBounds", "(Landroid/view/ViewGroup;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/Expression;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "bindLayoutParams", "bindStates", "Lcom/yandex/div2/Div;", "binder", "Lcom/yandex/div/core/view2/DivBinder;", "canWrap", "Lcom/yandex/div2/DivSize;", "clearFocusOnClick", "focusTracker", "Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "createAnimatedTouchListener", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "divAnimation", "divGestureListener", "Lcom/yandex/div/core/view2/DivGestureListener;", "dpToPx", "", "(Ljava/lang/Number;Landroid/util/DisplayMetrics;)I", "(Ljava/lang/Long;Landroid/util/DisplayMetrics;)I", "dpToPxF", "(Ljava/lang/Number;Landroid/util/DisplayMetrics;)F", "drawChildrenShadows", "canvas", "Landroid/graphics/Canvas;", "drawShadow", "extractParentContentAlignmentHorizontal", "extractParentContentAlignmentVertical", "fontSizeToPx", "gainAccessibilityFocus", "getChildPathUnit", "index", "getPivotValue", POBNativeConstants.NATIVE_LENGTH, "divPivot", "Lcom/yandex/div2/DivPivot;", "getWeight", "getWidthPxF", "Lcom/yandex/div2/DivStroke;", "isConstantlyEmpty", "Lcom/yandex/div2/DivBorder;", "isHorizontal", "Lcom/yandex/div2/DivContainer;", "isVertical", "isWrapContainer", "pxToDp", "pxToDpF", "pxToSp", "pxToSpF", "resolvePath", "Lcom/yandex/div/core/state/DivStatePath;", "parentPath", "pathUnit", "setAnimatedTouchListener", "spToPx", "spToPxF", "toAlignmentHorizontal", "toAlignmentVertical", "toAndroidUnit", "toDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/yandex/div2/DivDrawable;", "Lcom/yandex/div2/DivShapeDrawable;", "toHorizontalAlignment", "Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentHorizontal;", "toImageScale", "Lcom/yandex/div/internal/widget/AspectImageView$Scale;", "Lcom/yandex/div2/DivImageScale;", "toLayoutParamsSize", "lp", "Landroid/view/ViewGroup$LayoutParams;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "Lcom/yandex/div2/DivBlendMode;", "toPx", "Lcom/yandex/div2/DivDimension;", "Lcom/yandex/div2/DivFixedSize;", "toPxF", "Lcom/yandex/div2/DivRadialGradientFixedCenter;", "toScaleType", "Lcom/yandex/div/internal/drawable/ScalingDrawable$ScaleType;", "toTextVerticalAlignment", "Lcom/yandex/div/core/view2/spannable/TextVerticalAlignment;", "Lcom/yandex/div2/DivTextAlignmentVertical;", "toVerticalAlignment", "Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentVertical;", "trackVisibilityActions", "divView", "Lcom/yandex/div/core/view2/Div2View;", "newItems", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "oldItems", "unitToPx", "(Ljava/lang/Number;Landroid/util/DisplayMetrics;Lcom/yandex/div2/DivSizeUnit;)I", "(Ljava/lang/Long;Landroid/util/DisplayMetrics;Lcom/yandex/div2/DivSizeUnit;)I", "unitToPxF", "(Ljava/lang/Number;Landroid/util/DisplayMetrics;Lcom/yandex/div2/DivSizeUnit;)F", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BaseDivViewExtensionsKt {

    /* JADX INFO: compiled from: BaseDivViewExtensions.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[DivSizeUnit.values().length];
            try {
                iArr[DivSizeUnit.DP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivSizeUnit.SP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivSizeUnit.PX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DivAlignmentHorizontal.values().length];
            try {
                iArr2[DivAlignmentHorizontal.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DivAlignmentHorizontal.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[DivAlignmentHorizontal.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DivAlignmentHorizontal.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DivAlignmentHorizontal.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DivAlignmentVertical.values().length];
            try {
                iArr3[DivAlignmentVertical.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[DivAlignmentVertical.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[DivAlignmentVertical.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[DivContentAlignmentHorizontal.values().length];
            try {
                iArr4[DivContentAlignmentHorizontal.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.SPACE_AROUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.SPACE_BETWEEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr4[DivContentAlignmentHorizontal.SPACE_EVENLY.ordinal()] = 8;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[DivContentAlignmentVertical.values().length];
            try {
                iArr5[DivContentAlignmentVertical.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr5[DivContentAlignmentVertical.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr5[DivContentAlignmentVertical.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr5[DivContentAlignmentVertical.SPACE_AROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr5[DivContentAlignmentVertical.SPACE_BETWEEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr5[DivContentAlignmentVertical.SPACE_EVENLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr5[DivContentAlignmentVertical.BASELINE.ordinal()] = 7;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[DivImageScale.values().length];
            try {
                iArr6[DivImageScale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr6[DivImageScale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr6[DivImageScale.STRETCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr6[DivImageScale.NO_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[DivTextAlignmentVertical.values().length];
            try {
                iArr7[DivTextAlignmentVertical.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr7[DivTextAlignmentVertical.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr7[DivTextAlignmentVertical.BASELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr7[DivTextAlignmentVertical.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused34) {
            }
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[DivBlendMode.values().length];
            try {
                iArr8[DivBlendMode.SOURCE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr8[DivBlendMode.SOURCE_ATOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr8[DivBlendMode.DARKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr8[DivBlendMode.LIGHTEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr8[DivBlendMode.MULTIPLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr8[DivBlendMode.SCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused40) {
            }
            $EnumSwitchMapping$7 = iArr8;
            int[] iArr9 = new int[DivFontWeight.values().length];
            try {
                iArr9[DivFontWeight.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr9[DivFontWeight.REGULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr9[DivFontWeight.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr9[DivFontWeight.BOLD.ordinal()] = 4;
            } catch (NoSuchFieldError unused44) {
            }
            $EnumSwitchMapping$8 = iArr9;
        }
    }

    public static final void applyPaddings(View view, DivEdgeInsets divEdgeInsets, ExpressionResolver resolver) {
        int px;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (divEdgeInsets == null) {
            view.setPadding(0, 0, 0, 0);
            return;
        }
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        DivSizeUnit divSizeUnitEvaluate = divEdgeInsets.unit.evaluate(resolver);
        if (divEdgeInsets.start != null || divEdgeInsets.end != null) {
            Expression<Long> expression = divEdgeInsets.start;
            if (expression != null) {
                long jLongValue = expression.evaluate(resolver).longValue();
                Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
                px = toPx(jLongValue, divSizeUnitEvaluate, metrics);
            } else {
                px = 0;
            }
            long jLongValue2 = divEdgeInsets.top.evaluate(resolver).longValue();
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            int px2 = toPx(jLongValue2, divSizeUnitEvaluate, metrics);
            Expression<Long> expression2 = divEdgeInsets.end;
            view.setPaddingRelative(px, px2, expression2 != null ? toPx(expression2.evaluate(resolver).longValue(), divSizeUnitEvaluate, metrics) : 0, toPx(divEdgeInsets.bottom.evaluate(resolver).longValue(), divSizeUnitEvaluate, metrics));
            return;
        }
        long jLongValue3 = divEdgeInsets.left.evaluate(resolver).longValue();
        Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
        view.setPadding(toPx(jLongValue3, divSizeUnitEvaluate, metrics), toPx(divEdgeInsets.top.evaluate(resolver).longValue(), divSizeUnitEvaluate, metrics), toPx(divEdgeInsets.right.evaluate(resolver).longValue(), divSizeUnitEvaluate, metrics), toPx(divEdgeInsets.bottom.evaluate(resolver).longValue(), divSizeUnitEvaluate, metrics));
    }

    public static final void applyMargins(View view, DivEdgeInsets divEdgeInsets, ExpressionResolver resolver) {
        int iUnitToPx;
        int iUnitToPx2;
        int iUnitToPx3;
        int iUnitToPx4;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DisplayMetrics metrics = view.getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Integer num = null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        if (divEdgeInsets != null) {
            DivSizeUnit divSizeUnitEvaluate = divEdgeInsets.unit.evaluate(resolver);
            Long lEvaluate = divEdgeInsets.left.evaluate(resolver);
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            iUnitToPx = unitToPx(lEvaluate, metrics, divSizeUnitEvaluate);
            iUnitToPx2 = unitToPx(divEdgeInsets.top.evaluate(resolver), metrics, divSizeUnitEvaluate);
            iUnitToPx3 = unitToPx(divEdgeInsets.right.evaluate(resolver), metrics, divSizeUnitEvaluate);
            iUnitToPx4 = unitToPx(divEdgeInsets.bottom.evaluate(resolver), metrics, divSizeUnitEvaluate);
            Expression<Long> expression = divEdgeInsets.start;
            Integer numValueOf2 = expression != null ? Integer.valueOf(unitToPx(expression.evaluate(resolver), metrics, divSizeUnitEvaluate)) : null;
            Expression<Long> expression2 = divEdgeInsets.end;
            numValueOf = expression2 != null ? Integer.valueOf(unitToPx(expression2.evaluate(resolver), metrics, divSizeUnitEvaluate)) : null;
            num = numValueOf2;
        } else {
            iUnitToPx = 0;
            iUnitToPx2 = 0;
            iUnitToPx3 = 0;
            iUnitToPx4 = 0;
            numValueOf = null;
        }
        if (marginLayoutParams.leftMargin == iUnitToPx && marginLayoutParams.topMargin == iUnitToPx2 && marginLayoutParams.rightMargin == iUnitToPx3 && marginLayoutParams.bottomMargin == iUnitToPx4 && ((num == null || marginLayoutParams.getMarginStart() == num.intValue()) && (numValueOf == null || marginLayoutParams.getMarginEnd() == numValueOf.intValue()))) {
            return;
        }
        marginLayoutParams.topMargin = iUnitToPx2;
        marginLayoutParams.bottomMargin = iUnitToPx4;
        if (num != null || numValueOf != null) {
            marginLayoutParams.setMarginStart(num != null ? num.intValue() : 0);
            marginLayoutParams.setMarginEnd(numValueOf != null ? numValueOf.intValue() : 0);
        } else {
            marginLayoutParams.leftMargin = iUnitToPx;
            marginLayoutParams.rightMargin = iUnitToPx3;
        }
        view.requestLayout();
    }

    public static /* synthetic */ int toLayoutParamsSize$default(DivSize divSize, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver, ViewGroup.LayoutParams layoutParams, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutParams = null;
        }
        return toLayoutParamsSize(divSize, displayMetrics, expressionResolver, layoutParams);
    }

    public static final int toLayoutParamsSize(DivSize divSize, DisplayMetrics metrics, ExpressionResolver resolver, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (divSize == null) {
            return -2;
        }
        if (divSize instanceof DivSize.MatchParent) {
            return -1;
        }
        if (divSize instanceof DivSize.Fixed) {
            return toPx(((DivSize.Fixed) divSize).getValue(), metrics, resolver);
        }
        if (divSize instanceof DivSize.WrapContent) {
            Expression<Boolean> expression = ((DivSize.WrapContent) divSize).getValue().constrained;
            return (expression != null && expression.evaluate(resolver).booleanValue() && (layoutParams instanceof DivLayoutParams)) ? -3 : -2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int toPx(long j, DivSizeUnit unit, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        int i = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i == 1) {
            return dpToPx(Long.valueOf(j), metrics);
        }
        if (i == 2) {
            return spToPx(Long.valueOf(j), metrics);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        long j2 = j >> 31;
        if (j2 == 0 || j2 == -1) {
            return (int) j;
        }
        KAssert kAssert = KAssert.INSTANCE;
        if (Assert.isEnabled()) {
            Assert.fail("Unable convert '" + j + "' to Int");
        }
        return j > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public static final int toPx(DivFixedSize divFixedSize, DisplayMetrics metrics, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divFixedSize, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        int i = WhenMappings.$EnumSwitchMapping$0[divFixedSize.unit.evaluate(resolver).ordinal()];
        if (i == 1) {
            return dpToPx(divFixedSize.value.evaluate(resolver), metrics);
        }
        if (i == 2) {
            return spToPx(divFixedSize.value.evaluate(resolver), metrics);
        }
        if (i == 3) {
            long jLongValue = divFixedSize.value.evaluate(resolver).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                return (int) jLongValue;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue + "' to Int");
            }
            return jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int toPx(DivWrapContentSize.ConstraintSize constraintSize, DisplayMetrics metrics, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(constraintSize, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        int i = WhenMappings.$EnumSwitchMapping$0[constraintSize.unit.evaluate(resolver).ordinal()];
        if (i == 1) {
            return dpToPx(constraintSize.value.evaluate(resolver), metrics);
        }
        if (i == 2) {
            return spToPx(constraintSize.value.evaluate(resolver), metrics);
        }
        if (i == 3) {
            long jLongValue = constraintSize.value.evaluate(resolver).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                return (int) jLongValue;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail("Unable convert '" + jLongValue + "' to Int");
            }
            return jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float toPxF(DivFixedSize divFixedSize, DisplayMetrics metrics, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divFixedSize, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return evaluatePxFloatByUnit(divFixedSize.value.evaluate(resolver).longValue(), divFixedSize.unit.evaluate(resolver), metrics);
    }

    public static final float toPxF(DivRadialGradientFixedCenter divRadialGradientFixedCenter, DisplayMetrics metrics, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divRadialGradientFixedCenter, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return evaluatePxFloatByUnit(divRadialGradientFixedCenter.value.evaluate(resolver).longValue(), divRadialGradientFixedCenter.unit.evaluate(resolver), metrics);
    }

    private static final float evaluatePxFloatByUnit(long j, DivSizeUnit divSizeUnit, DisplayMetrics displayMetrics) {
        int i = WhenMappings.$EnumSwitchMapping$0[divSizeUnit.ordinal()];
        if (i == 1) {
            return dpToPxF(Long.valueOf(j), displayMetrics);
        }
        if (i == 2) {
            return spToPxF(Long.valueOf(j), displayMetrics);
        }
        if (i == 3) {
            return j;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int toPx(DivDimension divDimension, DisplayMetrics metrics, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divDimension, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        int i = WhenMappings.$EnumSwitchMapping$0[divDimension.unit.evaluate(resolver).ordinal()];
        if (i == 1) {
            return dpToPx(divDimension.value.evaluate(resolver), metrics);
        }
        if (i == 2) {
            return spToPx(divDimension.value.evaluate(resolver), metrics);
        }
        if (i == 3) {
            return (int) divDimension.value.evaluate(resolver).doubleValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void applyHeight(View view, DivBase div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivSize height = div.getHeight();
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        int layoutParamsSize = toLayoutParamsSize(height, displayMetrics, resolver, view.getLayoutParams());
        if (view.getLayoutParams().height != layoutParamsSize) {
            view.getLayoutParams().height = layoutParamsSize;
            view.requestLayout();
        }
        applyTransform(view, div.getTransform(), resolver);
    }

    public static final void applyMinHeight(View view, DivWrapContentSize.ConstraintSize constraintSize, ExpressionResolver resolver) {
        int px;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (constraintSize != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            px = toPx(constraintSize, displayMetrics, resolver);
        } else {
            px = 0;
        }
        if (view.getMinimumHeight() != px) {
            view.setMinimumHeight(px);
            view.requestLayout();
        }
    }

    public static final void applyVerticalWeightValue(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null || divLayoutParams.getVerticalWeight() == f) {
            return;
        }
        divLayoutParams.setVerticalWeight(f);
        view.requestLayout();
    }

    public static final void applyMaxHeight(View view, DivWrapContentSize.ConstraintSize constraintSize, ExpressionResolver resolver) {
        int px;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null) {
            return;
        }
        if (constraintSize != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            px = toPx(constraintSize, displayMetrics, resolver);
        } else {
            px = Integer.MAX_VALUE;
        }
        if (divLayoutParams.getMaxHeight() != px) {
            divLayoutParams.setMaxHeight(px);
            view.requestLayout();
        }
    }

    public static final void applyWidth(View view, DivBase div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivSize width = div.getWidth();
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
        int layoutParamsSize = toLayoutParamsSize(width, displayMetrics, resolver, view.getLayoutParams());
        if (view.getLayoutParams().width != layoutParamsSize) {
            view.getLayoutParams().width = layoutParamsSize;
            view.requestLayout();
        }
        applyTransform(view, div.getTransform(), resolver);
    }

    public static final void applyMinWidth(View view, DivWrapContentSize.ConstraintSize constraintSize, ExpressionResolver resolver) {
        int px;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (constraintSize != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            px = toPx(constraintSize, displayMetrics, resolver);
        } else {
            px = 0;
        }
        if (view.getMinimumWidth() != px) {
            view.setMinimumWidth(px);
            view.requestLayout();
        }
    }

    public static final void applyHorizontalWeightValue(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null || divLayoutParams.getHorizontalWeight() == f) {
            return;
        }
        divLayoutParams.setHorizontalWeight(f);
        view.requestLayout();
    }

    public static final float getWeight(DivSize divSize, ExpressionResolver resolver) {
        Expression<Double> expression;
        Intrinsics.checkNotNullParameter(divSize, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(divSize instanceof DivSize.MatchParent) || (expression = ((DivSize.MatchParent) divSize).getValue().weight) == null) {
            return 0.0f;
        }
        return (float) expression.evaluate(resolver).doubleValue();
    }

    public static final void applyMaxWidth(View view, DivWrapContentSize.ConstraintSize constraintSize, ExpressionResolver resolver) {
        int px;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null) {
            return;
        }
        if (constraintSize != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            px = toPx(constraintSize, displayMetrics, resolver);
        } else {
            px = Integer.MAX_VALUE;
        }
        if (divLayoutParams.getMaxWidth() != px) {
            divLayoutParams.setMaxWidth(px);
            view.requestLayout();
        }
    }

    public static final void applyTransform(final View view, final DivTransform divTransform, final ExpressionResolver resolver) {
        Expression<Double> expression;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Float fValueOf = (divTransform == null || (expression = divTransform.rotation) == null) ? null : Float.valueOf((float) expression.evaluate(resolver).doubleValue());
        if (fValueOf == null) {
            view.setRotation(0.0f);
            return;
        }
        view.setRotation(fValueOf.floatValue());
        if (view.getWidth() != 0 || view.getHeight() != 0) {
            view.setPivotX(getPivotValue(view, view.getWidth(), divTransform.pivotX, resolver));
            view.setPivotY(getPivotValue(view, view.getHeight(), divTransform.pivotY, resolver));
        } else {
            OneShotPreDrawListener.add(view, new Runnable() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt$applyTransform$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = view;
                    view2.setPivotX(BaseDivViewExtensionsKt.getPivotValue(view2, view2.getWidth(), divTransform.pivotX, resolver));
                    View view3 = view;
                    view3.setPivotY(BaseDivViewExtensionsKt.getPivotValue(view3, view3.getHeight(), divTransform.pivotY, resolver));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getPivotValue(View view, int i, DivPivot divPivot, ExpressionResolver expressionResolver) {
        Object objValue = divPivot.value();
        if (objValue instanceof DivPivotFixed) {
            DivPivotFixed divPivotFixed = (DivPivotFixed) objValue;
            Expression<Long> expression = divPivotFixed.value;
            if (expression == null) {
                return i / 2.0f;
            }
            float fLongValue = expression.evaluate(expressionResolver).longValue();
            int i2 = WhenMappings.$EnumSwitchMapping$0[divPivotFixed.unit.evaluate(expressionResolver).ordinal()];
            if (i2 == 1) {
                Float fValueOf = Float.valueOf(fLongValue);
                DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                return dpToPxF(fValueOf, displayMetrics);
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    return fLongValue;
                }
                throw new NoWhenBranchMatchedException();
            }
            Float fValueOf2 = Float.valueOf(fLongValue);
            DisplayMetrics displayMetrics2 = view.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics2, "resources.displayMetrics");
            return spToPxF(fValueOf2, displayMetrics2);
        }
        if (!(objValue instanceof DivPivotPercentage)) {
            return i / 2.0f;
        }
        return i * (((float) ((DivPivotPercentage) objValue).value.evaluate(expressionResolver).doubleValue()) / 100.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void applyAlpha(View view, double d) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setAlpha((float) d);
        DivBorderSupports divBorderSupports = view instanceof DivBorderSupports ? (DivBorderSupports) view : null;
        if (divBorderSupports != null) {
            divBorderSupports.invalidateBorder();
        }
    }

    public static final boolean isHorizontal(DivContainer divContainer, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divContainer, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return divContainer.orientation.evaluate(resolver) == DivContainer.Orientation.HORIZONTAL;
    }

    public static final boolean isVertical(DivContainer divContainer, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divContainer, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return divContainer.orientation.evaluate(resolver) == DivContainer.Orientation.VERTICAL;
    }

    public static final boolean isWrapContainer(DivContainer divContainer, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divContainer, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (divContainer.layoutMode.evaluate(resolver) != DivContainer.LayoutMode.WRAP || divContainer.orientation.evaluate(resolver) == DivContainer.Orientation.OVERLAP) {
            return false;
        }
        if (isHorizontal(divContainer, resolver)) {
            return canWrap(divContainer.getWidth(), resolver);
        }
        if (canWrap(divContainer.getHeight(), resolver)) {
            return true;
        }
        DivAspect divAspect = divContainer.aspect;
        if (divAspect != null) {
            return !(((float) divAspect.ratio.evaluate(resolver).doubleValue()) == 0.0f);
        }
        return false;
    }

    public static final boolean canWrap(DivSize divSize, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divSize, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(divSize instanceof DivSize.WrapContent)) {
            return true;
        }
        Expression<Boolean> expression = ((DivSize.WrapContent) divSize).getValue().constrained;
        return expression != null && expression.evaluate(resolver).booleanValue();
    }

    public static final void applyAlignment(View view, DivAlignmentHorizontal divAlignmentHorizontal, DivAlignmentVertical divAlignmentVertical) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        applyGravity(view, evaluateGravity(divAlignmentHorizontal, divAlignmentVertical));
        applyBaselineAlignment(view, divAlignmentVertical == DivAlignmentVertical.BASELINE);
    }

    private static final void applyGravity(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof DivLayoutParams)) {
            Log.e("DivView", "tag=" + view.getTag() + ": Can't cast " + layoutParams + " to get gravity");
            return;
        }
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        if (divLayoutParams.getGravity() != i) {
            divLayoutParams.setGravity(i);
            view.requestLayout();
        }
    }

    public static final int evaluateGravity(DivAlignmentHorizontal divAlignmentHorizontal, DivAlignmentVertical divAlignmentVertical) {
        int i;
        int i2 = divAlignmentHorizontal == null ? -1 : WhenMappings.$EnumSwitchMapping$1[divAlignmentHorizontal.ordinal()];
        if (i2 == 1) {
            i = 3;
        } else if (i2 != 2) {
            i = 5;
            if (i2 != 3) {
                i = (i2 == 4 || i2 != 5) ? 8388611 : GravityCompat.END;
            }
        } else {
            i = 1;
        }
        int i3 = divAlignmentVertical != null ? WhenMappings.$EnumSwitchMapping$2[divAlignmentVertical.ordinal()] : -1;
        int i4 = 48;
        if (i3 != 1) {
            if (i3 == 2) {
                i4 = 16;
            } else if (i3 == 3) {
                i4 = 80;
            }
        }
        return i4 | i;
    }

    public static final int evaluateGravity(DivContentAlignmentHorizontal divContentAlignmentHorizontal, DivContentAlignmentVertical divContentAlignmentVertical) {
        int i = divContentAlignmentHorizontal == null ? -1 : WhenMappings.$EnumSwitchMapping$3[divContentAlignmentHorizontal.ordinal()];
        int i2 = GravityCompat.START;
        switch (i) {
            case 1:
                i2 = 3;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 5;
                break;
            case 5:
                i2 = GravityCompat.END;
                break;
            case 6:
                i2 = 16777216;
                break;
            case 7:
                i2 = 33554432;
                break;
            case 8:
                i2 = 67108864;
                break;
        }
        int i3 = 48;
        switch (divContentAlignmentVertical != null ? WhenMappings.$EnumSwitchMapping$4[divContentAlignmentVertical.ordinal()] : -1) {
            case 2:
                i3 = 16;
                break;
            case 3:
                i3 = 80;
                break;
            case 4:
                i3 = 268435456;
                break;
            case 5:
                i3 = 536870912;
                break;
            case 6:
                i3 = 1073741824;
                break;
        }
        return i3 | i2;
    }

    private static final void applyBaselineAlignment(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        DivLayoutParams divLayoutParams = layoutParams instanceof DivLayoutParams ? (DivLayoutParams) layoutParams : null;
        if (divLayoutParams == null || divLayoutParams.getIsBaselineAligned() == z) {
            return;
        }
        divLayoutParams.setBaselineAligned(z);
        view.requestLayout();
    }

    public static final <T extends Number> float dpToPxF(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return TypedValue.applyDimension(1, t != null ? t.floatValue() : 0.0f, metrics);
    }

    public static final <T extends Number> float spToPxF(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return TypedValue.applyDimension(2, t != null ? t.floatValue() : 0.0f, metrics);
    }

    public static final <T extends Number> float unitToPxF(T t, DisplayMetrics metrics, DivSizeUnit unit) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return TypedValue.applyDimension(toAndroidUnit(unit), t != null ? t.floatValue() : 0.0f, metrics);
    }

    public static final <T extends Number> float pxToDpF(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (Build.VERSION.SDK_INT >= 34) {
            return TypedValue.deriveDimension(1, t != null ? t.floatValue() : 0.0f, metrics);
        }
        return (t != null ? t.floatValue() : 0.0f) / metrics.density;
    }

    public static final <T extends Number> float pxToSpF(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (Build.VERSION.SDK_INT >= 34) {
            return TypedValue.deriveDimension(2, t != null ? t.floatValue() : 0.0f, metrics);
        }
        return (t != null ? t.floatValue() : 0.0f) / metrics.scaledDensity;
    }

    public static final <T extends Number> int dpToPx(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return MathKt.roundToInt(dpToPxF(t, metrics));
    }

    public static final <T extends Number> int spToPx(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return MathKt.roundToInt(spToPxF(t, metrics));
    }

    public static final <T extends Number> int unitToPx(T t, DisplayMetrics metrics, DivSizeUnit unit) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return MathKt.roundToInt(unitToPxF(t, metrics, unit));
    }

    public static final <T extends Number> int pxToDp(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return MathKt.roundToInt(pxToDpF(t, metrics));
    }

    public static final <T extends Number> int pxToSp(T t, DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return MathKt.roundToInt(pxToSpF(t, metrics));
    }

    public static final int dpToPx(Long l, DisplayMetrics metrics) {
        Integer numValueOf;
        int i;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return dpToPx(numValueOf, metrics);
    }

    public static final int spToPx(Long l, DisplayMetrics metrics) {
        Integer numValueOf;
        int i;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return spToPx(numValueOf, metrics);
    }

    public static final int unitToPx(Long l, DisplayMetrics metrics, DivSizeUnit unit) {
        Integer numValueOf;
        int i;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return unitToPx(numValueOf, metrics, unit);
    }

    public static final int pxToDp(Long l, DisplayMetrics metrics) {
        Integer numValueOf;
        int i;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return pxToDp(numValueOf, metrics);
    }

    public static final int pxToSp(Long l, DisplayMetrics metrics) {
        Integer numValueOf;
        int i;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return pxToSp(numValueOf, metrics);
    }

    public static final ScalingDrawable.ScaleType toScaleType(DivImageScale divImageScale) {
        Intrinsics.checkNotNullParameter(divImageScale, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$5[divImageScale.ordinal()];
        if (i == 1) {
            return ScalingDrawable.ScaleType.FILL;
        }
        if (i == 2) {
            return ScalingDrawable.ScaleType.FIT;
        }
        if (i == 3) {
            return ScalingDrawable.ScaleType.STRETCH;
        }
        return ScalingDrawable.ScaleType.NO_SCALE;
    }

    public static final ScalingDrawable.AlignmentHorizontal toHorizontalAlignment(DivAlignmentHorizontal divAlignmentHorizontal) {
        Intrinsics.checkNotNullParameter(divAlignmentHorizontal, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[divAlignmentHorizontal.ordinal()];
        if (i == 2) {
            return ScalingDrawable.AlignmentHorizontal.CENTER;
        }
        if (i == 3) {
            return ScalingDrawable.AlignmentHorizontal.RIGHT;
        }
        return ScalingDrawable.AlignmentHorizontal.LEFT;
    }

    public static final ScalingDrawable.AlignmentVertical toVerticalAlignment(DivAlignmentVertical divAlignmentVertical) {
        Intrinsics.checkNotNullParameter(divAlignmentVertical, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$2[divAlignmentVertical.ordinal()];
        if (i == 2) {
            return ScalingDrawable.AlignmentVertical.CENTER;
        }
        if (i == 3) {
            return ScalingDrawable.AlignmentVertical.BOTTOM;
        }
        return ScalingDrawable.AlignmentVertical.TOP;
    }

    public static final TextVerticalAlignment toTextVerticalAlignment(DivTextAlignmentVertical divTextAlignmentVertical) {
        Intrinsics.checkNotNullParameter(divTextAlignmentVertical, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$6[divTextAlignmentVertical.ordinal()];
        if (i == 1) {
            return TextVerticalAlignment.TOP;
        }
        if (i == 2) {
            return TextVerticalAlignment.CENTER;
        }
        if (i == 3) {
            return TextVerticalAlignment.BASELINE;
        }
        if (i == 4) {
            return TextVerticalAlignment.BOTTOM;
        }
        return TextVerticalAlignment.BASELINE;
    }

    public static final PorterDuff.Mode toPorterDuffMode(DivBlendMode divBlendMode) {
        Intrinsics.checkNotNullParameter(divBlendMode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$7[divBlendMode.ordinal()]) {
            case 1:
                return PorterDuff.Mode.SRC_IN;
            case 2:
                return PorterDuff.Mode.SRC_ATOP;
            case 3:
                return PorterDuff.Mode.DARKEN;
            case 4:
                return PorterDuff.Mode.LIGHTEN;
            case 5:
                return PorterDuff.Mode.MULTIPLY;
            case 6:
                return PorterDuff.Mode.SCREEN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void applyDivActions(View view, BindingContext context, DivAction divAction, List<DivAction> list, List<DivAction> list2, List<DivAction> list3, List<DivAction> list4, List<DivAction> list5, List<DivAction> list6, List<DivAction> list7, DivAnimation actionAnimation, DivAccessibility divAccessibility) {
        List<DivAction> listListOf;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionAnimation, "actionAnimation");
        DivActionBinder actionBinder = context.getDivView().getDiv2Component().getActionBinder();
        Intrinsics.checkNotNullExpressionValue(actionBinder, "context.divView.div2Component.actionBinder");
        List<DivAction> list8 = list;
        if (list8 == null || list8.isEmpty()) {
            listListOf = divAction != null ? CollectionsKt.listOf(divAction) : null;
        } else {
            listListOf = list;
        }
        actionBinder.bindDivActions(context, view, listListOf, list2, list3, list4, list5, list6, list7, actionAnimation, divAccessibility);
    }

    public static final void setAnimatedTouchListener(View view, BindingContext context, DivAnimation divAnimation, DivGestureListener divGestureListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        final Function2<View, MotionEvent, Boolean> function2CreateAnimatedTouchListener = createAnimatedTouchListener(view, context, divAnimation, divGestureListener);
        view.setOnTouchListener(function2CreateAnimatedTouchListener != null ? new View.OnTouchListener() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return BaseDivViewExtensionsKt.setAnimatedTouchListener$lambda$5(function2CreateAnimatedTouchListener, view2, motionEvent);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setAnimatedTouchListener$lambda$5(Function2 function2, View view, MotionEvent motionEvent) {
        return ((Boolean) function2.invoke(view, motionEvent)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    public static final Function2<View, MotionEvent, Boolean> createAnimatedTouchListener(View view, BindingContext context, DivAnimation divAnimation, DivGestureListener divGestureListener) {
        final GestureDetectorCompat gestureDetectorCompat;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        final Function2<View, MotionEvent, Unit> function2AsTouchListener = divAnimation != null ? UtilsKt.asTouchListener(divAnimation, context.getExpressionResolver(), view) : null;
        if (divGestureListener == null) {
            gestureDetectorCompat = null;
        } else {
            if (((divGestureListener.getOnSingleTapListener() == null && divGestureListener.getOnDoubleTapListener() == null) ? null : divGestureListener) != null) {
                gestureDetectorCompat = new GestureDetectorCompat(context.getDivView().getContext(), divGestureListener);
            } else {
                gestureDetectorCompat = null;
            }
        }
        if (function2AsTouchListener == null && gestureDetectorCompat == null) {
            return null;
        }
        return new Function2<View, MotionEvent, Boolean>() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt.createAnimatedTouchListener.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                Function2<View, MotionEvent, Unit> function2 = function2AsTouchListener;
                if (function2 != null) {
                    function2.invoke(v, event);
                }
                GestureDetectorCompat gestureDetectorCompat2 = gestureDetectorCompat;
                return Boolean.valueOf(gestureDetectorCompat2 != null ? gestureDetectorCompat2.onTouchEvent(event) : false);
            }
        };
    }

    public static final void applyFontSize(TextView textView, int i, DivSizeUnit unit) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        textView.setTextSize(toAndroidUnit(unit), i);
    }

    public static final int toAndroidUnit(DivSizeUnit divSizeUnit) {
        Intrinsics.checkNotNullParameter(divSizeUnit, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[divSizeUnit.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T extends TextView & FixedLineHeightView> void applyLineHeight(T t, Long l, DivSizeUnit unit) {
        int iUnitToPx;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        T t2 = t;
        if (l != null) {
            DisplayMetrics displayMetrics = t.getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            iUnitToPx = unitToPx(l, displayMetrics, unit);
        } else {
            iUnitToPx = -1;
        }
        t2.setFixedLineHeight(iUnitToPx);
    }

    public static final void applyLetterSpacing(TextView textView, double d, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setLetterSpacing(((float) d) / i);
    }

    public static /* synthetic */ void applyId$default(View view, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        applyId(view, str, i);
    }

    public static final void applyId(View view, String str, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(str);
        view.setId(i);
    }

    public static final boolean getHasSightActions(DivBase divBase) {
        List<DivVisibilityAction> visibilityActions;
        List<DivDisappearAction> disappearActions;
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        return (divBase.getVisibilityAction() == null && ((visibilityActions = divBase.getVisibilityActions()) == null || visibilityActions.isEmpty()) && ((disappearActions = divBase.getDisappearActions()) == null || disappearActions.isEmpty())) ? false : true;
    }

    public static final List<DivVisibilityAction> getAllVisibilityActions(DivBase divBase) {
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        List<DivVisibilityAction> visibilityActions = divBase.getVisibilityActions();
        if (visibilityActions != null) {
            return visibilityActions;
        }
        DivVisibilityAction visibilityAction = divBase.getVisibilityAction();
        List<DivVisibilityAction> listListOf = visibilityAction != null ? CollectionsKt.listOf(visibilityAction) : null;
        return listListOf == null ? CollectionsKt.emptyList() : listListOf;
    }

    public static final List<DivDisappearAction> getAllDisappearActions(DivBase divBase) {
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        List<DivDisappearAction> disappearActions = divBase.getDisappearActions();
        return disappearActions == null ? CollectionsKt.emptyList() : disappearActions;
    }

    public static final List<DivSightAction> getAllSightActions(DivBase divBase) {
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        return CollectionsKt.plus((Collection) getAllDisappearActions(divBase), (Iterable) getAllVisibilityActions(divBase));
    }

    public static final void bindLayoutParams(View view, DivBase div, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        try {
            applyWidth(view, div, resolver);
            applyHeight(view, div, resolver);
            Expression<DivAlignmentHorizontal> alignmentHorizontal = div.getAlignmentHorizontal();
            DivAlignmentHorizontal divAlignmentHorizontalEvaluate = alignmentHorizontal != null ? alignmentHorizontal.evaluate(resolver) : null;
            Expression<DivAlignmentVertical> alignmentVertical = div.getAlignmentVertical();
            applyAlignment(view, divAlignmentHorizontalEvaluate, alignmentVertical != null ? alignmentVertical.evaluate(resolver) : null);
        } catch (ParsingException e) {
            if (!ExpressionFallbacksHelperKt.isExpressionResolveFail(e)) {
                throw e;
            }
        }
    }

    public static final ExpressionsRuntime getRuntimeFor(RuntimeStore runtimeStore, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (runtimeStore != null) {
            return runtimeStore.getRuntimeWithOrNull$div_release(resolver);
        }
        return null;
    }

    public static final ExpressionsRuntime resolveRuntime(RuntimeStore runtimeStore, DivBase div, String path, ExpressionResolver resolver, ExpressionResolver parentResolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(parentResolver, "parentResolver");
        if (runtimeStore == null) {
            return null;
        }
        List<DivVariable> variables = div.getVariables();
        return runtimeStore.resolveRuntimeWith$div_release(path, variables != null ? DivUtilKt.toVariables(variables) : null, div.getVariableTriggers(), div.getFunctions(), resolver, parentResolver);
    }

    public static final String getChildPathUnit(DivBase divBase, int i) {
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        String id = divBase.getId();
        return id == null ? ChildPathUnitCache.INSTANCE.getValue$div_release(i) : id;
    }

    public static final DivStatePath resolvePath(DivBase divBase, int i, DivStatePath parentPath) {
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        return divBase instanceof DivState ? parentPath : parentPath.appendDiv(getChildPathUnit(divBase, i));
    }

    public static final DivStatePath resolvePath(DivBase divBase, String pathUnit, DivStatePath parentPath) {
        Intrinsics.checkNotNullParameter(divBase, "<this>");
        Intrinsics.checkNotNullParameter(pathUnit, "pathUnit");
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        return divBase instanceof DivState ? parentPath : parentPath.appendDiv(pathUnit);
    }

    public static final void bindStates(View view, Div div, BindingContext context, ExpressionResolver resolver, DivBinder binder) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(binder, "binder");
        if (div == null) {
            return;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        traverseViewHierarhy(view, new Function1<View, Boolean>() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt.bindStates.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View currentView) {
                Intrinsics.checkNotNullParameter(currentView, "currentView");
                if (!(currentView instanceof DivStateLayout)) {
                    return true;
                }
                DivStatePath path = ((DivStateLayout) currentView).getPath();
                if (path != null) {
                    linkedHashMap.put(path, currentView);
                }
                return false;
            }
        });
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            DivStatePath divStatePath = (DivStatePath) entry.getKey();
            DivStateLayout divStateLayout = (DivStateLayout) entry.getValue();
            Div divFindDivState$div_release = DivPathUtils.INSTANCE.findDivState$div_release(div, divStatePath, resolver);
            if (divFindDivState$div_release != null) {
                binder.bind(context, divStateLayout, divFindDivState$div_release, divStatePath.parentState());
            }
        }
    }

    private static final void traverseViewHierarhy(View view, Function1<? super View, Boolean> function1) {
        if (function1.invoke(view).booleanValue() && (view instanceof ViewGroup)) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                traverseViewHierarhy(it.next(), function1);
            }
        }
    }

    public static final AspectImageView.Scale toImageScale(DivImageScale divImageScale) {
        Intrinsics.checkNotNullParameter(divImageScale, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$5[divImageScale.ordinal()];
        if (i == 1) {
            return AspectImageView.Scale.FILL;
        }
        if (i == 2) {
            return AspectImageView.Scale.FIT;
        }
        if (i == 3) {
            return AspectImageView.Scale.STRETCH;
        }
        if (i == 4) {
            return AspectImageView.Scale.NO_SCALE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void trackVisibilityActions(final ViewGroup viewGroup, final Div2View divView, final List<DivItemBuilderResult> newItems, List<DivItemBuilderResult> list) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        final DivVisibilityActionTracker visibilityActionTracker = divView.getDiv2Component().getVisibilityActionTracker();
        Intrinsics.checkNotNullExpressionValue(visibilityActionTracker, "divView.div2Component.visibilityActionTracker");
        List<DivItemBuilderResult> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = newItems.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, getAllSightActions(((DivItemBuilderResult) it.next()).getDiv().value()));
            }
            HashSet hashSet = new HashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                hashSet.add(((DivSightAction) it2.next()).getLogId());
            }
            HashSet hashSet2 = hashSet;
            for (DivItemBuilderResult divItemBuilderResult : list) {
                List<DivSightAction> allSightActions = getAllSightActions(divItemBuilderResult.getDiv().value());
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : allSightActions) {
                    if (!hashSet2.contains(((DivSightAction) obj).getLogId())) {
                        arrayList2.add(obj);
                    }
                }
                visibilityActionTracker.trackVisibilityActionsOf(divView, divItemBuilderResult.getExpressionResolver(), null, divItemBuilderResult.getDiv(), arrayList2);
            }
        }
        if (newItems.isEmpty()) {
            return;
        }
        viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt$trackVisibilityActions$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                view.removeOnLayoutChangeListener(this);
                for (Pair pair : SequencesKt.zip(ViewGroupKt.getChildren(viewGroup), CollectionsKt.asSequence(newItems))) {
                    View view2 = (View) pair.component1();
                    DivItemBuilderResult divItemBuilderResult2 = (DivItemBuilderResult) pair.component2();
                    DivVisibilityActionTracker.trackVisibilityActionsOf$default(visibilityActionTracker, divView, divItemBuilderResult2.getExpressionResolver(), view2, divItemBuilderResult2.getDiv(), null, 16, null);
                }
            }
        });
    }

    public static final int getTypefaceValue(DivFontWeight divFontWeight, Integer num) {
        if (num != null) {
            return num.intValue();
        }
        int i = divFontWeight == null ? -1 : WhenMappings.$EnumSwitchMapping$8[divFontWeight.ordinal()];
        if (i == 1) {
            return 300;
        }
        if (i != 2) {
            if (i == 3) {
                return 500;
            }
            if (i == 4) {
                return 700;
            }
        }
        return 400;
    }

    public static final int getTypefaceValue(DivFontWeight divFontWeight, Long l) {
        Integer numValueOf;
        int i;
        if (l != null) {
            long jLongValue = l.longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        return getTypefaceValue(divFontWeight, numValueOf);
    }

    public static final Typeface getTypeface(int i, DivTypefaceProvider typefaceProvider) {
        Intrinsics.checkNotNullParameter(typefaceProvider, "typefaceProvider");
        Typeface typefaceFor = typefaceProvider.getTypefaceFor(i);
        if (typefaceFor != null) {
            return typefaceFor;
        }
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        return DEFAULT;
    }

    public static final float fontSizeToPx(long j, DivSizeUnit unit, DisplayMetrics metrics) {
        Number numberValueOf;
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        int i = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i == 1) {
            numberValueOf = Integer.valueOf(dpToPx(Long.valueOf(j), metrics));
        } else if (i == 2) {
            numberValueOf = Integer.valueOf(spToPx(Long.valueOf(j), metrics));
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            numberValueOf = Long.valueOf(j);
        }
        return numberValueOf.floatValue();
    }

    public static final void drawChildrenShadows(ViewGroup viewGroup, Canvas canvas) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Iterator it = SequencesKt.filter(ViewGroupKt.getChildren(viewGroup), new Function1<View, Boolean>() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt.drawChildrenShadows.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return Boolean.valueOf(it2.getVisibility() == 0);
            }
        }).iterator();
        while (it.hasNext()) {
            drawShadow((View) it.next(), canvas);
        }
    }

    public static final DivContentAlignmentVertical extractParentContentAlignmentVertical(View view, ExpressionResolver resolver) {
        Expression<DivContentAlignmentVertical> expression;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        ViewParent parent = view.getParent();
        DivHolderView divHolderView = parent instanceof DivHolderView ? (DivHolderView) parent : null;
        DivBase div = divHolderView != null ? divHolderView.getDiv() : null;
        DivContainer divContainer = div instanceof DivContainer ? (DivContainer) div : null;
        if (divContainer == null || (expression = divContainer.contentAlignmentVertical) == null) {
            return null;
        }
        return expression.evaluate(resolver);
    }

    public static final DivContentAlignmentHorizontal extractParentContentAlignmentHorizontal(View view, ExpressionResolver resolver) {
        Expression<DivContentAlignmentHorizontal> expression;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        ViewParent parent = view.getParent();
        DivHolderView divHolderView = parent instanceof DivHolderView ? (DivHolderView) parent : null;
        DivBase div = divHolderView != null ? divHolderView.getDiv() : null;
        DivContainer divContainer = div instanceof DivContainer ? (DivContainer) div : null;
        if (divContainer == null || (expression = divContainer.contentAlignmentHorizontal) == null) {
            return null;
        }
        return expression.evaluate(resolver);
    }

    public static final boolean isConstantlyEmpty(DivBorder divBorder) {
        if (divBorder == null) {
            return true;
        }
        return divBorder.cornerRadius == null && divBorder.cornersRadius == null && Intrinsics.areEqual(divBorder.hasShadow, Expression.INSTANCE.constant(false)) && divBorder.shadow == null && divBorder.stroke == null;
    }

    public static final Drawable toDrawable(DivDrawable divDrawable, DisplayMetrics metrics, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divDrawable, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (divDrawable instanceof DivDrawable.Shape) {
            return toDrawable(((DivDrawable.Shape) divDrawable).getValue(), metrics, resolver);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Drawable toDrawable(DivShapeDrawable divShapeDrawable, DisplayMetrics metrics, ExpressionResolver resolver) {
        Expression<Integer> expression;
        Expression<Integer> expression2;
        Intrinsics.checkNotNullParameter(divShapeDrawable, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        DivShape divShape = divShapeDrawable.shape;
        if (divShape instanceof DivShape.RoundedRectangle) {
            DivShape.RoundedRectangle roundedRectangle = (DivShape.RoundedRectangle) divShape;
            float pxF = toPxF(roundedRectangle.getValue().itemWidth, metrics, resolver);
            float pxF2 = toPxF(roundedRectangle.getValue().itemHeight, metrics, resolver);
            Expression<Integer> expression3 = roundedRectangle.getValue().backgroundColor;
            if (expression3 == null) {
                expression3 = divShapeDrawable.color;
            }
            int iIntValue = expression3.evaluate(resolver).intValue();
            float pxF3 = toPxF(roundedRectangle.getValue().cornerRadius, metrics, resolver);
            DivStroke divStroke = roundedRectangle.getValue().stroke;
            if (divStroke == null) {
                divStroke = divShapeDrawable.stroke;
            }
            Integer numEvaluate = (divStroke == null || (expression2 = divStroke.color) == null) ? null : expression2.evaluate(resolver);
            DivStroke divStroke2 = roundedRectangle.getValue().stroke;
            if (divStroke2 == null) {
                divStroke2 = divShapeDrawable.stroke;
            }
            return new RoundedRectDrawable(new RoundedRectDrawable.Params(pxF, pxF2, iIntValue, pxF3, numEvaluate, divStroke2 != null ? Float.valueOf(getWidthPxF(divStroke2, metrics, resolver)) : null));
        }
        if (!(divShape instanceof DivShape.Circle)) {
            return null;
        }
        DivShape.Circle circle = (DivShape.Circle) divShape;
        float pxF4 = toPxF(circle.getValue().radius, metrics, resolver);
        Expression<Integer> expression4 = circle.getValue().backgroundColor;
        if (expression4 == null) {
            expression4 = divShapeDrawable.color;
        }
        int iIntValue2 = expression4.evaluate(resolver).intValue();
        DivStroke divStroke3 = circle.getValue().stroke;
        if (divStroke3 == null) {
            divStroke3 = divShapeDrawable.stroke;
        }
        Integer numEvaluate2 = (divStroke3 == null || (expression = divStroke3.color) == null) ? null : expression.evaluate(resolver);
        DivStroke divStroke4 = circle.getValue().stroke;
        if (divStroke4 == null) {
            divStroke4 = divShapeDrawable.stroke;
        }
        return new CircleDrawable(new CircleDrawable.Params(pxF4, iIntValue2, numEvaluate2, divStroke4 != null ? Float.valueOf(getWidthPxF(divStroke4, metrics, resolver)) : null));
    }

    private static final float getWidthPxF(DivStroke divStroke, DisplayMetrics displayMetrics, ExpressionResolver expressionResolver) {
        return unitToPxF(divStroke.width.evaluate(expressionResolver), displayMetrics, divStroke.unit.evaluate(expressionResolver));
    }

    public static final DivIndicatorItemPlacement getItemsPlacementCompat(DivIndicator divIndicator) {
        Intrinsics.checkNotNullParameter(divIndicator, "<this>");
        DivIndicatorItemPlacement divIndicatorItemPlacement = divIndicator.itemsPlacement;
        return divIndicatorItemPlacement == null ? new DivIndicatorItemPlacement.Default(new DivDefaultIndicatorItemPlacement(divIndicator.spaceBetweenCenters)) : divIndicatorItemPlacement;
    }

    public static /* synthetic */ IndicatorParams.Shape createRoundedRectangle$default(int i, float f, float f2, float f3, float f4, Float f5, Integer num, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            f4 = 1.0f;
        }
        return createRoundedRectangle(i, f, f2, f3, f4, (i2 & 32) != 0 ? null : f5, (i2 & 64) != 0 ? null : num);
    }

    public static final IndicatorParams.Shape createRoundedRectangle(int i, float f, float f2, float f3, float f4, Float f5, Integer num) {
        return new IndicatorParams.Shape.RoundedRect(i, new IndicatorParams.ItemSize.RoundedRect(f * f4, f2 * f4, f3 * f4), f5 != null ? f5.floatValue() : 0.0f, num != null ? num.intValue() : 0);
    }

    public static /* synthetic */ IndicatorParams.Shape createCircle$default(int i, float f, float f2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f2 = 1.0f;
        }
        return createCircle(i, f, f2);
    }

    public static final IndicatorParams.Shape createCircle(int i, float f, float f2) {
        return new IndicatorParams.Shape.Circle(i, new IndicatorParams.ItemSize.Circle(f * f2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void bindAspectRatio(final View view, DivAspect divAspect, DivAspect divAspect2, ExpressionResolver resolver) {
        Expression<Double> expression;
        Expression<Double> expression2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (view instanceof AspectView) {
            Disposable disposableObserve = null;
            if (ExpressionsKt.equalsToConstant(divAspect != null ? divAspect.ratio : null, divAspect2 != null ? divAspect2.ratio : null)) {
                return;
            }
            applyAspectRatio((AspectView) view, (divAspect == null || (expression2 = divAspect.ratio) == null) ? null : expression2.evaluate(resolver));
            if (ExpressionsKt.isConstantOrNull(divAspect != null ? divAspect.ratio : null) || !(view instanceof ExpressionSubscriber)) {
                return;
            }
            ExpressionSubscriber expressionSubscriber = (ExpressionSubscriber) view;
            if (divAspect != null && (expression = divAspect.ratio) != null) {
                disposableObserve = expression.observe(resolver, new Function1<Double, Unit>() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt.bindAspectRatio.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Double d) {
                        invoke(d.doubleValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(double d) {
                        BaseDivViewExtensionsKt.applyAspectRatio((AspectView) view, Double.valueOf(d));
                    }
                });
            }
            expressionSubscriber.addSubscription(disposableObserve);
        }
    }

    public static final void applyBitmapFilters(final View view, BindingContext context, final Bitmap bitmap, final List<? extends DivFilter> list, final Function1<? super Bitmap, Unit> actionAfterFilters) {
        int i;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(actionAfterFilters, "actionAfterFilters");
        if (list == null) {
            actionAfterFilters.invoke(bitmap);
            return;
        }
        final ExpressionResolver expressionResolver = context.getExpressionResolver();
        final BitmapEffectHelper bitmapEffectHelper = context.getDivView().getDiv2Component().getBitmapEffectHelper();
        Intrinsics.checkNotNullExpressionValue(bitmapEffectHelper, "context.divView.div2Component.bitmapEffectHelper");
        if (ViewsKt.isActuallyLaidOut(view) && !view.isLayoutRequested()) {
            float fMax = Math.max(view.getHeight() / bitmap.getHeight(), view.getWidth() / bitmap.getWidth());
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fMax), (int) (fMax * bitmap.getHeight()), false);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(\n    …lter = */ false\n        )");
            for (DivFilter divFilter : list) {
                if (divFilter instanceof DivFilter.Blur) {
                    long jLongValue = ((DivFilter.Blur) divFilter).getValue().radius.evaluate(expressionResolver).longValue();
                    long j = jLongValue >> 31;
                    if (j == 0 || j == -1) {
                        i = (int) jLongValue;
                    } else {
                        KAssert kAssert = KAssert.INSTANCE;
                        if (Assert.isEnabled()) {
                            Assert.fail("Unable convert '" + jLongValue + "' to Int");
                        }
                        i = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    Integer numValueOf = Integer.valueOf(i);
                    DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
                    Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
                    bitmapCreateScaledBitmap = bitmapEffectHelper.blurBitmap(bitmapCreateScaledBitmap, dpToPx(numValueOf, displayMetrics));
                } else if ((divFilter instanceof DivFilter.RtlMirror) && ViewsKt.isLayoutRtl(view)) {
                    bitmapCreateScaledBitmap = bitmapEffectHelper.mirrorBitmap$div_release(bitmapCreateScaledBitmap);
                }
            }
            actionAfterFilters.invoke(bitmapCreateScaledBitmap);
            return;
        }
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt$applyBitmapFilters$$inlined$doOnActualLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                int i2;
                view2.removeOnLayoutChangeListener(this);
                float fMax2 = Math.max(view.getHeight() / bitmap.getHeight(), view.getWidth() / bitmap.getWidth());
                Bitmap bitmap2 = bitmap;
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap2, (int) (bitmap2.getWidth() * fMax2), (int) (fMax2 * bitmap.getHeight()), false);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap2, "createScaledBitmap(\n    …lter = */ false\n        )");
                for (DivFilter divFilter2 : list) {
                    if (divFilter2 instanceof DivFilter.Blur) {
                        long jLongValue2 = ((DivFilter.Blur) divFilter2).getValue().radius.evaluate(expressionResolver).longValue();
                        long j2 = jLongValue2 >> 31;
                        if (j2 == 0 || j2 == -1) {
                            i2 = (int) jLongValue2;
                        } else {
                            KAssert kAssert2 = KAssert.INSTANCE;
                            if (Assert.isEnabled()) {
                                Assert.fail("Unable convert '" + jLongValue2 + "' to Int");
                            }
                            i2 = jLongValue2 > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        Integer numValueOf2 = Integer.valueOf(i2);
                        DisplayMetrics displayMetrics2 = view.getResources().getDisplayMetrics();
                        Intrinsics.checkNotNullExpressionValue(displayMetrics2, "resources.displayMetrics");
                        bitmapCreateScaledBitmap2 = bitmapEffectHelper.blurBitmap(bitmapCreateScaledBitmap2, BaseDivViewExtensionsKt.dpToPx(numValueOf2, displayMetrics2));
                    } else if ((divFilter2 instanceof DivFilter.RtlMirror) && ViewsKt.isLayoutRtl(view)) {
                        bitmapCreateScaledBitmap2 = bitmapEffectHelper.mirrorBitmap$div_release(bitmapCreateScaledBitmap2);
                    }
                }
                actionAfterFilters.invoke(bitmapCreateScaledBitmap2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyAspectRatio(AspectView aspectView, Double d) {
        aspectView.setAspectRatio(d != null ? (float) d.doubleValue() : 0.0f);
    }

    public static final DivAlignmentHorizontal toAlignmentHorizontal(DivContentAlignmentHorizontal divContentAlignmentHorizontal) {
        Intrinsics.checkNotNullParameter(divContentAlignmentHorizontal, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$3[divContentAlignmentHorizontal.ordinal()];
        if (i == 1) {
            return DivAlignmentHorizontal.LEFT;
        }
        if (i == 2) {
            return DivAlignmentHorizontal.CENTER;
        }
        if (i == 3) {
            return DivAlignmentHorizontal.RIGHT;
        }
        return DivAlignmentHorizontal.LEFT;
    }

    public static final DivAlignmentVertical toAlignmentVertical(DivContentAlignmentVertical divContentAlignmentVertical) {
        Intrinsics.checkNotNullParameter(divContentAlignmentVertical, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$4[divContentAlignmentVertical.ordinal()];
        if (i == 1) {
            return DivAlignmentVertical.TOP;
        }
        if (i == 2) {
            return DivAlignmentVertical.CENTER;
        }
        if (i == 3) {
            return DivAlignmentVertical.BOTTOM;
        }
        if (i == 7) {
            return DivAlignmentVertical.BASELINE;
        }
        return DivAlignmentVertical.TOP;
    }

    public static final void clearFocusOnClick(View view, InputFocusTracker focusTracker) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(focusTracker, "focusTracker");
        if (view.isFocused() || !view.isInTouchMode()) {
            return;
        }
        focusTracker.removeFocusFromFocusedInput();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BindingContext getBindingContext(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        DivHolderView divHolderView = view instanceof DivHolderView ? (DivHolderView) view : null;
        if (divHolderView != null) {
            return divHolderView.getBindingContext();
        }
        return null;
    }

    public static final void bindItemBuilder(DivCollectionItemBuilder builder, ExpressionResolver resolver, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(callback, "callback");
        builder.data.observe(resolver, callback);
        ExpressionResolver itemResolver = DivCollectionExtensionsKt.getItemResolver(builder, resolver);
        Iterator<T> it = builder.prototypes.iterator();
        while (it.hasNext()) {
            ((DivCollectionItemBuilder.Prototype) it.next()).selector.observe(itemResolver, callback);
        }
    }

    public static final void gainAccessibilityFocus(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.performAccessibilityAction(64, null);
        view.sendAccessibilityEvent(1);
    }

    public static final void sendAccessibilityEventUnchecked(int i, View view, AccessibilityStateProvider accessibilityStateProvider) {
        Intrinsics.checkNotNullParameter(accessibilityStateProvider, "accessibilityStateProvider");
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (accessibilityStateProvider.isAccessibilityEnabled(context)) {
            view.sendAccessibilityEventUnchecked(Build.VERSION.SDK_INT >= 30 ? new AccessibilityEvent(i) : AccessibilityEvent.obtain(i));
        }
    }

    public static final <T extends ViewGroup & DivHolderView<?>> void bindClipChildren(final T t, Expression<Boolean> newClipToBounds, Expression<Boolean> expression, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(newClipToBounds, "newClipToBounds");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (ExpressionsKt.equalsToConstant(newClipToBounds, expression)) {
            return;
        }
        applyClipChildren(t, newClipToBounds.evaluate(resolver).booleanValue());
        if (ExpressionsKt.isConstant(newClipToBounds)) {
            return;
        }
        ((DivHolderView) t).addSubscription(newClipToBounds.observe(resolver, new Function1<Boolean, Unit>() { // from class: com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt.bindClipChildren.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                BaseDivViewExtensionsKt.applyClipChildren(t, z);
            }
        }));
    }

    public static final <T extends ViewGroup & DivHolderView<?>> void applyClipChildren(T t, boolean z) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        ((DivHolderView) t).setNeedClipping(z);
        ViewParent parent = t.getParent();
        if (z || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).setClipChildren(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void drawShadow(View view, Canvas canvas) {
        DivBorderDrawer divBorderDrawer;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int iSave = canvas.save();
        try {
            canvas.translate(view.getX(), view.getY());
            canvas.rotate(view.getRotation(), view.getPivotX(), view.getPivotY());
            DivBorderSupports divBorderSupports = view instanceof DivBorderSupports ? (DivBorderSupports) view : null;
            if (divBorderSupports != null && (divBorderDrawer = divBorderSupports.getBorderDrawer()) != null) {
                divBorderDrawer.drawShadow(canvas);
            }
        } finally {
            canvas.restoreToCount(iSave);
        }
    }
}
