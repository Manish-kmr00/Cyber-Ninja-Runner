package com.yandex.div.core.widget.wraplayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.json.b9;
import com.json.ug;
import com.safedk.android.analytics.reporters.b;
import com.yandex.div.core.widget.AspectView;
import com.yandex.div.core.widget.ShowSeparatorsMode;
import com.yandex.div.core.widget.ViewsKt;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.internal.widget.DivViewGroup;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.IntProgression;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WrapContainerLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b)\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u009d\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u001cH\u0002J\u0010\u0010g\u001a\u00020e2\u0006\u0010h\u001a\u00020\u001cH\u0002J\u0018\u0010i\u001a\u00020e2\u0006\u0010j\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u001cH\u0002J\u0010\u0010k\u001a\u00020e2\u0006\u0010f\u001a\u00020\u001cH\u0002J\u0018\u0010l\u001a\u00020e2\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u0010H\u0002J \u0010o\u001a\u00020e2\u0006\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u0010H\u0002J\u0010\u0010s\u001a\u00020e2\u0006\u0010t\u001a\u00020uH\u0014J0\u0010v\u001a\u00020e2\u0006\u0010t\u001a\u00020u2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010H\u0002J0\u0010{\u001a\u00020e2\u0006\u0010t\u001a\u00020u2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010H\u0002JA\u0010{\u001a\u0004\u0018\u00010e2\b\u0010|\u001a\u0004\u0018\u00010#2\u0006\u0010t\u001a\u00020u2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010}J\u0010\u0010~\u001a\u00020e2\u0006\u0010t\u001a\u00020uH\u0002J\u0010\u0010\u007f\u001a\u00020e2\u0006\u0010t\u001a\u00020uH\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0010H\u0016J\u001b\u0010\u0081\u0001\u001a\u00020\u00102\u0007\u0010\u0082\u0001\u001a\u00020^2\u0007\u0010\u0083\u0001\u001a\u00020\u0010H\u0002J-\u0010\u0084\u0001\u001a\u00020\u00102\u0007\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0007\u0010\u0087\u0001\u001a\u00020\u00102\u0007\u0010\u0088\u0001\u001a\u00020 H\u0002J6\u0010\u0089\u0001\u001a\u00020\u00102\u0007\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u008a\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0007\u0010\u0087\u0001\u001a\u00020\u00102\u0007\u0010\u008b\u0001\u001a\u00020\u0010H\u0002J\u001a\u0010\u008c\u0001\u001a\u00020\u00102\u0007\u0010\u0082\u0001\u001a\u00020^2\u0006\u0010h\u001a\u00020\u001cH\u0002J6\u0010\u008d\u0001\u001a\u00020 2\u0007\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0087\u0001\u001a\u00020\u00102\u0007\u0010\u008e\u0001\u001a\u00020\u00102\u0007\u0010\u008f\u0001\u001a\u00020\u00102\u0007\u0010\u0090\u0001\u001a\u00020\u0010H\u0002J\u0019\u0010\u0091\u0001\u001a\u00020e2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010H\u0002J\u0019\u0010\u0092\u0001\u001a\u00020e2\u0006\u0010x\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010H\u0002J2\u0010\u0093\u0001\u001a\u00020e2\u0007\u0010\u0094\u0001\u001a\u00020 2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010H\u0014J\u0019\u0010\u0095\u0001\u001a\u00020e2\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u0010H\u0014J'\u0010\u0096\u0001\u001a\u00020e2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010J'\u0010\u0097\u0001\u001a\u00020e2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u0010J\u0014\u0010\u0098\u0001\u001a\u00020 2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0010H\u0002J\u0014\u0010\u0099\u0001\u001a\u00020 2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0010H\u0002J\u0014\u0010\u009a\u0001\u001a\u00020 2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0010H\u0002J\u0014\u0010\u009b\u0001\u001a\u00020 2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0010H\u0002J\u0014\u0010\u009c\u0001\u001a\u00020 2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0010H\u0002R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014R/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u000e\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0014R\u0012\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c01X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0014R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0014R\u0012\u00107\u001a\u000608R\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R/\u00109\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u0014\u0010=\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0014R\u0012\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R1\u0010C\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00108F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\bI\u0010\u000e\u0012\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010HR1\u0010J\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00108F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\bN\u0010\u000e\u0012\u0004\bK\u0010E\u001a\u0004\bL\u0010\u0014\"\u0004\bM\u0010HR\u0014\u0010O\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0014R\u0014\u0010Q\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u0014R\u0014\u0010S\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u0014R\u000e\u0010U\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0014R*\u0010Y\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bZ\u0010E\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010HR\u0018\u0010]\u001a\u00020 *\u00020^8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0018\u0010a\u001a\u00020 *\u00020^8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010`R\u001a\u0010b\u001a\u00020 *\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006\u009e\u0001"}, d2 = {"Lcom/yandex/div/core/widget/wraplayout/WrapContainerLayout;", "Lcom/yandex/div/internal/widget/DivViewGroup;", "Lcom/yandex/div/core/widget/AspectView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "aspectRatio", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "aspectRatio$delegate", "Lkotlin/properties/ReadWriteProperty;", "childState", "", "edgeLineSeparatorOffset", "edgeLineSeparatorsLength", "getEdgeLineSeparatorsLength", "()I", "edgeSeparatorsLength", "getEdgeSeparatorsLength", "endLineSeparatorLength", "getEndLineSeparatorLength", "endSeparatorLength", "getEndSeparatorLength", "firstVisibleLine", "Lcom/yandex/div/core/widget/wraplayout/WrapContainerLayout$WrapLine;", "getFirstVisibleLine", "()Lcom/yandex/div/core/widget/wraplayout/WrapContainerLayout$WrapLine;", "isRowDirection", "", "largestMainSize", "getLargestMainSize", "Landroid/graphics/drawable/Drawable;", "lineSeparatorDrawable", "getLineSeparatorDrawable", "()Landroid/graphics/drawable/Drawable;", "setLineSeparatorDrawable", "(Landroid/graphics/drawable/Drawable;)V", "lineSeparatorDrawable$delegate", "lineSeparatorLength", "getLineSeparatorLength", "lineSeparatorMarginBottom", "lineSeparatorMarginLeft", "lineSeparatorMarginRight", "lineSeparatorMarginTop", b.d, "", "middleLineSeparatorLength", "getMiddleLineSeparatorLength", "middleLineSeparatorOffset", "middleSeparatorLength", "getMiddleSeparatorLength", "offsetsHolder", "Lcom/yandex/div/internal/widget/DivViewGroup$OffsetsHolder;", "separatorDrawable", "getSeparatorDrawable", "setSeparatorDrawable", "separatorDrawable$delegate", "separatorLength", "getSeparatorLength", "separatorMarginBottom", "separatorMarginLeft", "separatorMarginRight", "separatorMarginTop", "showLineSeparators", "getShowLineSeparators$annotations", "()V", "getShowLineSeparators", "setShowLineSeparators", "(I)V", "showLineSeparators$delegate", "showSeparators", "getShowSeparators$annotations", "getShowSeparators", "setShowSeparators", "showSeparators$delegate", "startLineSeparatorLength", "getStartLineSeparatorLength", "startSeparatorLength", "getStartSeparatorLength", "sumOfCrossSize", "getSumOfCrossSize", "tempSumCrossSize", "visibleLinesCount", "getVisibleLinesCount", "value", "wrapDirection", "getWrapDirection$annotations", "getWrapDirection", "setWrapDirection", "hasIncorrectSize", "Landroid/view/View;", "getHasIncorrectSize", "(Landroid/view/View;)Z", "isHidden", "isIncorrectForCrossAxis", "(Ljava/lang/Integer;)Z", "addEdgeSpace", "", "spaceLine", "addLine", "line", "addLineIfNeeded", "childIndex", "addSpaceBetweenLines", "calculateLines", "widthMeasureSpec", "heightMeasureSpec", "determineCrossSize", "measureSpec", "crossAlignment", "paddingAlongCrossAxis", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawLineSeparator", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "drawSeparator", "separator", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Canvas;IIII)Lkotlin/Unit;", "drawSeparatorsHorizontal", "drawSeparatorsVertical", "getBaseline", "getLeftOffsetForVerticalLayout", "view", "lineWidth", "getSize", b9.a.t, ContentDisposition.Parameters.Size, SDKConstants.PARAM_CONTEXT_MAX_SIZE, "isCrossAxis", "getState", "state", "tooSmallState", "getTopOffsetForHorizontalLayout", "isWrapRequired", "currentLength", "childLength", "lineItemsCount", "layoutHorizontal", "layoutVertical", "onLayout", "changed", "onMeasure", "setLineSeparatorMargins", "setSeparatorMargins", "showLeftSeparator", "showRightSeparator", "showSeparatorAtEnd", "showSeparatorAtStart", "showSeparatorBetween", "WrapLine", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class WrapContainerLayout extends DivViewGroup implements AspectView {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WrapContainerLayout.class, "showSeparators", "getShowSeparators()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WrapContainerLayout.class, "showLineSeparators", "getShowLineSeparators()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WrapContainerLayout.class, "separatorDrawable", "getSeparatorDrawable()Landroid/graphics/drawable/Drawable;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WrapContainerLayout.class, "lineSeparatorDrawable", "getLineSeparatorDrawable()Landroid/graphics/drawable/Drawable;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WrapContainerLayout.class, "aspectRatio", "getAspectRatio()F", 0))};

    /* JADX INFO: renamed from: aspectRatio$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty aspectRatio;
    private int childState;
    private int edgeLineSeparatorOffset;
    private boolean isRowDirection;

    /* JADX INFO: renamed from: lineSeparatorDrawable$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty lineSeparatorDrawable;
    private int lineSeparatorMarginBottom;
    private int lineSeparatorMarginLeft;
    private int lineSeparatorMarginRight;
    private int lineSeparatorMarginTop;
    private final List<WrapLine> lines;
    private int middleLineSeparatorOffset;
    private final DivViewGroup.OffsetsHolder offsetsHolder;

    /* JADX INFO: renamed from: separatorDrawable$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty separatorDrawable;
    private int separatorMarginBottom;
    private int separatorMarginLeft;
    private int separatorMarginRight;
    private int separatorMarginTop;

    /* JADX INFO: renamed from: showLineSeparators$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty showLineSeparators;

    /* JADX INFO: renamed from: showSeparators$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty showSeparators;
    private int tempSumCrossSize;
    private int wrapDirection;

    @ShowSeparatorsMode
    public static /* synthetic */ void getShowLineSeparators$annotations() {
    }

    @ShowSeparatorsMode
    public static /* synthetic */ void getShowSeparators$annotations() {
    }

    public static /* synthetic */ void getWrapDirection$annotations() {
    }

    private final boolean showSeparatorAtEnd(@ShowSeparatorsMode int mode) {
        return (mode & 4) != 0;
    }

    private final boolean showSeparatorAtStart(@ShowSeparatorsMode int mode) {
        return (mode & 1) != 0;
    }

    private final boolean showSeparatorBetween(@ShowSeparatorsMode int mode) {
        return (mode & 2) != 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContainerLayout(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showSeparators = ViewsKt.dimensionAffecting$default(0, null, 2, null);
        this.showLineSeparators = ViewsKt.dimensionAffecting$default(0, null, 2, null);
        this.separatorDrawable = ViewsKt.dimensionAffecting$default(null, null, 2, null);
        this.lineSeparatorDrawable = ViewsKt.dimensionAffecting$default(null, null, 2, null);
        this.isRowDirection = true;
        this.lines = new ArrayList();
        this.offsetsHolder = new DivViewGroup.OffsetsHolder(this, 0.0f, 0.0f, 0, 7, null);
        this.aspectRatio = AspectView.INSTANCE.aspectRatioProperty$div_release();
    }

    public final int getWrapDirection() {
        return this.wrapDirection;
    }

    public final void setWrapDirection(int i) {
        if (this.wrapDirection != i) {
            this.wrapDirection = i;
            boolean z = true;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("Invalid value for the wrap direction is set: " + this.wrapDirection);
                }
                z = false;
            }
            this.isRowDirection = z;
            requestLayout();
        }
    }

    public final int getShowSeparators() {
        return ((Number) this.showSeparators.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setShowSeparators(int i) {
        this.showSeparators.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    public final int getShowLineSeparators() {
        return ((Number) this.showLineSeparators.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final void setShowLineSeparators(int i) {
        this.showLineSeparators.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
    }

    public final Drawable getSeparatorDrawable() {
        return (Drawable) this.separatorDrawable.getValue(this, $$delegatedProperties[2]);
    }

    public final void setSeparatorDrawable(Drawable drawable) {
        this.separatorDrawable.setValue(this, $$delegatedProperties[2], drawable);
    }

    public final Drawable getLineSeparatorDrawable() {
        return (Drawable) this.lineSeparatorDrawable.getValue(this, $$delegatedProperties[3]);
    }

    public final void setLineSeparatorDrawable(Drawable drawable) {
        this.lineSeparatorDrawable.setValue(this, $$delegatedProperties[3], drawable);
    }

    public final void setSeparatorMargins(int left, int top, int right, int bottom) {
        this.separatorMarginLeft = left;
        this.separatorMarginRight = right;
        this.separatorMarginTop = top;
        this.separatorMarginBottom = bottom;
        requestLayout();
    }

    public final void setLineSeparatorMargins(int left, int top, int right, int bottom) {
        this.lineSeparatorMarginLeft = left;
        this.lineSeparatorMarginRight = right;
        this.lineSeparatorMarginTop = top;
        this.lineSeparatorMarginBottom = bottom;
        requestLayout();
    }

    private final int getSeparatorLength() {
        int intrinsicHeight;
        int i;
        if (this.isRowDirection) {
            Drawable separatorDrawable = getSeparatorDrawable();
            intrinsicHeight = (separatorDrawable != null ? separatorDrawable.getIntrinsicWidth() : 0) + this.separatorMarginLeft;
            i = this.separatorMarginRight;
        } else {
            Drawable separatorDrawable2 = getSeparatorDrawable();
            intrinsicHeight = (separatorDrawable2 != null ? separatorDrawable2.getIntrinsicHeight() : 0) + this.separatorMarginTop;
            i = this.separatorMarginBottom;
        }
        return intrinsicHeight + i;
    }

    private final int getLineSeparatorLength() {
        int intrinsicWidth;
        int i;
        if (this.isRowDirection) {
            Drawable lineSeparatorDrawable = getLineSeparatorDrawable();
            intrinsicWidth = (lineSeparatorDrawable != null ? lineSeparatorDrawable.getIntrinsicHeight() : 0) + this.lineSeparatorMarginTop;
            i = this.lineSeparatorMarginBottom;
        } else {
            Drawable lineSeparatorDrawable2 = getLineSeparatorDrawable();
            intrinsicWidth = (lineSeparatorDrawable2 != null ? lineSeparatorDrawable2.getIntrinsicWidth() : 0) + this.lineSeparatorMarginLeft;
            i = this.lineSeparatorMarginRight;
        }
        return intrinsicWidth + i;
    }

    @Override // com.yandex.div.core.widget.AspectView
    public float getAspectRatio() {
        return ((Number) this.aspectRatio.getValue(this, $$delegatedProperties[4])).floatValue();
    }

    @Override // com.yandex.div.core.widget.AspectView
    public void setAspectRatio(float f) {
        this.aspectRatio.setValue(this, $$delegatedProperties[4], Float.valueOf(f));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMakeMeasureSpec;
        int mode;
        int size;
        this.lines.clear();
        this.childState = 0;
        int mode2 = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
        int i = 1073741824;
        if (getAspectRatio() != 0.0f && mode2 == 1073741824) {
            int iRoundToInt = MathKt.roundToInt(size2 / getAspectRatio());
            size = iRoundToInt;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRoundToInt, 1073741824);
            mode = 1073741824;
        } else {
            iMakeMeasureSpec = heightMeasureSpec;
            mode = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
        }
        calculateLines(widthMeasureSpec, iMakeMeasureSpec);
        if (this.isRowDirection) {
            determineCrossSize(iMakeMeasureSpec, getVerticalGravity$div_release(), getVerticalPaddings$div_release());
        } else {
            determineCrossSize(widthMeasureSpec, getHorizontalGravity$div_release(), getHorizontalPaddings$div_release());
        }
        int largestMainSize = this.isRowDirection ? getLargestMainSize() : getSumOfCrossSize() + getHorizontalPaddings$div_release();
        int sumOfCrossSize = this.isRowDirection ? getSumOfCrossSize() + getVerticalPaddings$div_release() : getLargestMainSize();
        this.childState = getState(mode2, this.childState, size2, largestMainSize, 16777216);
        int iResolveSizeAndState = ViewGroup.resolveSizeAndState(getSize(mode2, size2, largestMainSize, !this.isRowDirection), widthMeasureSpec, this.childState);
        if (!this.isRowDirection || getAspectRatio() == 0.0f || mode2 == 1073741824) {
            i = mode;
        } else {
            size = MathKt.roundToInt((16777215 & iResolveSizeAndState) / getAspectRatio());
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        this.childState = getState(i, this.childState, size, sumOfCrossSize, 256);
        setMeasuredDimension(iResolveSizeAndState, ViewGroup.resolveSizeAndState(getSize(i, size, sumOfCrossSize, this.isRowDirection), iMakeMeasureSpec, this.childState));
    }

    private final void calculateLines(int widthMeasureSpec, int heightMeasureSpec) {
        int edgeSeparatorsLength;
        int edgeSeparatorsLength2;
        int i;
        int i2;
        this.tempSumCrossSize = getEdgeLineSeparatorsLength();
        int i3 = this.isRowDirection ? widthMeasureSpec : heightMeasureSpec;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int edgeSeparatorsLength3 = getEdgeSeparatorsLength() + (this.isRowDirection ? getHorizontalPaddings$div_release() : getVerticalPaddings$div_release());
        WrapLine wrapLine = new WrapLine(0, edgeSeparatorsLength3, 0, 5, null);
        WrapLine wrapLine2 = wrapLine;
        int i4 = 0;
        int iMax = Integer.MIN_VALUE;
        for (View view : ViewGroupKt.getChildren(this)) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            if (isHidden(view2)) {
                wrapLine2.setGoneItemCount(wrapLine2.getGoneItemCount() + 1);
                wrapLine2.setItemCount(wrapLine2.getItemCount() + 1);
                addLineIfNeeded(i4, wrapLine2);
            } else {
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                int horizontalPaddings$div_release = getHorizontalPaddings$div_release() + divLayoutParams.getHorizontalMargins$div_release();
                int verticalPaddings$div_release = getVerticalPaddings$div_release() + divLayoutParams.getVerticalMargins$div_release();
                if (this.isRowDirection) {
                    edgeSeparatorsLength = horizontalPaddings$div_release + getEdgeSeparatorsLength();
                    edgeSeparatorsLength2 = this.tempSumCrossSize;
                } else {
                    edgeSeparatorsLength = horizontalPaddings$div_release + this.tempSumCrossSize;
                    edgeSeparatorsLength2 = getEdgeSeparatorsLength();
                }
                view2.measure(DivViewGroup.INSTANCE.getChildMeasureSpec(widthMeasureSpec, edgeSeparatorsLength, divLayoutParams.width, view2.getMinimumWidth(), divLayoutParams.getMaxWidth()), DivViewGroup.INSTANCE.getChildMeasureSpec(heightMeasureSpec, verticalPaddings$div_release + edgeSeparatorsLength2, divLayoutParams.height, view2.getMinimumHeight(), divLayoutParams.getMaxHeight()));
                this.childState = View.combineMeasuredStates(this.childState, view2.getMeasuredState());
                int measuredWidth = view2.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release();
                int measuredHeight = view2.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release();
                if (this.isRowDirection) {
                    i2 = measuredWidth;
                    i = measuredHeight;
                } else {
                    i = measuredWidth;
                    i2 = measuredHeight;
                }
                int i6 = i;
                if (isWrapRequired(mode, size, wrapLine2.getMainSize(), i2, wrapLine2.getItemCount())) {
                    if (wrapLine2.getItemCountNotGone() > 0) {
                        addLine(wrapLine2);
                    }
                    wrapLine2 = new WrapLine(i4, edgeSeparatorsLength3, 1);
                    iMax = Integer.MIN_VALUE;
                } else {
                    if (wrapLine2.getItemCount() > 0) {
                        wrapLine2.setMainSize(wrapLine2.getMainSize() + getMiddleSeparatorLength());
                    }
                    wrapLine2.setItemCount(wrapLine2.getItemCount() + 1);
                }
                if (this.isRowDirection && divLayoutParams.getIsBaselineAligned()) {
                    wrapLine2.setMaxBaseline(Math.max(wrapLine2.getMaxBaseline(), view2.getBaseline() + divLayoutParams.topMargin));
                    wrapLine2.setMaxHeightUnderBaseline(Math.max(wrapLine2.getMaxHeightUnderBaseline(), (view2.getMeasuredHeight() + divLayoutParams.bottomMargin) - view2.getBaseline()));
                }
                wrapLine2.setMainSize(wrapLine2.getMainSize() + i2);
                iMax = Math.max(iMax, i6);
                wrapLine2.setCrossSize(Math.max(wrapLine2.getCrossSize(), iMax));
                addLineIfNeeded(i4, wrapLine2);
            }
            i4 = i5;
            mode = mode;
        }
    }

    private final int getEdgeSeparatorsLength() {
        return getStartSeparatorLength() + getEndSeparatorLength();
    }

    private final int getEdgeLineSeparatorsLength() {
        return getStartLineSeparatorLength() + getEndLineSeparatorLength();
    }

    private final int getStartSeparatorLength() {
        if (showSeparatorAtStart(getShowSeparators())) {
            return getSeparatorLength();
        }
        return 0;
    }

    private final int getMiddleSeparatorLength() {
        if (showSeparatorBetween(getShowSeparators())) {
            return getSeparatorLength();
        }
        return 0;
    }

    private final int getEndSeparatorLength() {
        if (showSeparatorAtEnd(getShowSeparators())) {
            return getSeparatorLength();
        }
        return 0;
    }

    private final int getStartLineSeparatorLength() {
        if (showSeparatorAtStart(getShowLineSeparators())) {
            return getLineSeparatorLength();
        }
        return 0;
    }

    private final int getMiddleLineSeparatorLength() {
        if (showSeparatorBetween(getShowLineSeparators())) {
            return getLineSeparatorLength();
        }
        return 0;
    }

    private final int getEndLineSeparatorLength() {
        if (showSeparatorAtEnd(getShowLineSeparators())) {
            return getLineSeparatorLength();
        }
        return 0;
    }

    private final boolean isHidden(View view) {
        return view.getVisibility() == 8 || getHasIncorrectSize(view);
    }

    private final boolean getHasIncorrectSize(View view) {
        if (this.isRowDirection) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return isIncorrectForCrossAxis(layoutParams != null ? Integer.valueOf(layoutParams.height) : null);
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        return isIncorrectForCrossAxis(layoutParams2 != null ? Integer.valueOf(layoutParams2.width) : null);
    }

    private final boolean isIncorrectForCrossAxis(Integer num) {
        return num != null && num.intValue() == -1;
    }

    private final void addLineIfNeeded(int childIndex, WrapLine line) {
        if (childIndex != getChildCount() - 1 || line.getItemCountNotGone() == 0) {
            return;
        }
        addLine(line);
    }

    private final void addLine(WrapLine line) {
        this.lines.add(line);
        if (line.getMaxBaseline() > 0) {
            line.setCrossSize(Math.max(line.getCrossSize(), line.getMaxBaseline() + line.getMaxHeightUnderBaseline()));
        }
        this.tempSumCrossSize += line.getCrossSize();
    }

    private final boolean isWrapRequired(int mode, int maxSize, int currentLength, int childLength, int lineItemsCount) {
        return mode != 0 && maxSize < (currentLength + childLength) + (lineItemsCount != 0 ? getMiddleSeparatorLength() : 0);
    }

    private final void determineCrossSize(int measureSpec, int crossAlignment, int paddingAlongCrossAxis) {
        this.middleLineSeparatorOffset = 0;
        this.edgeLineSeparatorOffset = 0;
        if (this.lines.size() != 0 && View.MeasureSpec.getMode(measureSpec) == 1073741824) {
            int size = View.MeasureSpec.getSize(measureSpec);
            if (this.lines.size() == 1) {
                this.lines.get(0).setCrossSize(size - paddingAlongCrossAxis);
                return;
            }
            int sumOfCrossSize = (size - getSumOfCrossSize()) + paddingAlongCrossAxis;
            if (crossAlignment != 1) {
                if (crossAlignment != 5) {
                    if (crossAlignment != 16) {
                        if (crossAlignment != 80) {
                            if (crossAlignment != 16777216) {
                                if (crossAlignment != 33554432) {
                                    if (crossAlignment != 67108864) {
                                        if (crossAlignment != 268435456) {
                                            if (crossAlignment != 536870912) {
                                                if (crossAlignment != 1073741824) {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    WrapLine wrapLine = new WrapLine(0, 0, 0, 7, null);
                                    int iRoundToInt = MathKt.roundToInt(DivViewGroup.INSTANCE.getSpaceEvenlyPart$div_release(sumOfCrossSize, this.lines.size()));
                                    wrapLine.setCrossSize(iRoundToInt);
                                    int i = iRoundToInt / 2;
                                    this.middleLineSeparatorOffset = i;
                                    this.edgeLineSeparatorOffset = i;
                                    addSpaceBetweenLines(wrapLine);
                                    addEdgeSpace(wrapLine);
                                    return;
                                }
                                WrapLine wrapLine2 = new WrapLine(0, 0, 0, 7, null);
                                int iRoundToInt2 = MathKt.roundToInt(DivViewGroup.INSTANCE.getSpaceBetweenPart$div_release(sumOfCrossSize, this.lines.size()));
                                wrapLine2.setCrossSize(iRoundToInt2);
                                this.middleLineSeparatorOffset = iRoundToInt2 / 2;
                                addSpaceBetweenLines(wrapLine2);
                                return;
                            }
                            WrapLine wrapLine3 = new WrapLine(0, 0, 0, 7, null);
                            int iRoundToInt3 = MathKt.roundToInt(DivViewGroup.INSTANCE.getSpaceAroundPart$div_release(sumOfCrossSize, this.lines.size()));
                            wrapLine3.setCrossSize(iRoundToInt3);
                            this.middleLineSeparatorOffset = iRoundToInt3;
                            this.edgeLineSeparatorOffset = iRoundToInt3 / 2;
                            for (int i2 = 0; i2 < this.lines.size(); i2 += 3) {
                                this.lines.add(i2, wrapLine3);
                                this.lines.add(i2 + 2, wrapLine3);
                            }
                            return;
                        }
                    }
                }
                WrapLine wrapLine4 = new WrapLine(0, 0, 0, 7, null);
                wrapLine4.setCrossSize(sumOfCrossSize);
                this.lines.add(0, wrapLine4);
                return;
            }
            WrapLine wrapLine5 = new WrapLine(0, 0, 0, 7, null);
            wrapLine5.setCrossSize(sumOfCrossSize / 2);
            addEdgeSpace(wrapLine5);
        }
    }

    private final void addEdgeSpace(WrapLine spaceLine) {
        this.lines.add(0, spaceLine);
        this.lines.add(spaceLine);
    }

    private final void addSpaceBetweenLines(WrapLine spaceLine) {
        for (int i = 1; i < this.lines.size(); i += 2) {
            this.lines.add(i, spaceLine);
        }
    }

    private final int getSize(int mode, int size, int maxSize, boolean isCrossAxis) {
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalStateException("Unknown size mode is set: " + mode);
            }
        } else {
            if (isCrossAxis) {
                return Math.min(size, maxSize);
            }
            if (maxSize > size || getVisibleLinesCount() > 1) {
                return size;
            }
        }
        return maxSize;
    }

    private final int getVisibleLinesCount() {
        List<WrapLine> list = this.lines;
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((WrapLine) it.next()).getItemCountNotGone() > 0 && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    private final int getState(int mode, int state, int size, int maxSize, int tooSmallState) {
        return (mode != 0 && size < maxSize) ? ViewGroup.combineMeasuredStates(state, tooSmallState) : state;
    }

    private final int getLargestMainSize() {
        Integer num;
        Iterator<T> it = this.lines.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(((WrapLine) it.next()).getMainSize());
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((WrapLine) it.next()).getMainSize());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        Integer num2 = num;
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    private final int getSumOfCrossSize() {
        Iterator<T> it = this.lines.iterator();
        int crossSize = 0;
        while (it.hasNext()) {
            crossSize += ((WrapLine) it.next()).getCrossSize();
        }
        return crossSize + getEdgeLineSeparatorsLength() + (getMiddleLineSeparatorLength() * (getVisibleLinesCount() - 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.isRowDirection) {
            layoutHorizontal(left, right);
        } else {
            layoutVertical(top, bottom);
        }
    }

    private final void layoutHorizontal(int left, int right) {
        WrapContainerLayout wrapContainerLayout;
        int paddingTop = getPaddingTop() + getStartLineSeparatorLength();
        WrapContainerLayout wrapContainerLayout2 = this;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(getHorizontalGravity$div_release(), ViewCompat.getLayoutDirection(wrapContainerLayout2));
        boolean z = false;
        for (WrapLine wrapLine : this.lines) {
            float paddingLeft = getPaddingLeft() + (com.yandex.div.core.util.ViewsKt.isLayoutRtl(wrapContainerLayout2) ? getEndSeparatorLength() : getStartSeparatorLength());
            float mainSize = (right - left) - wrapLine.getMainSize();
            DivViewGroup.OffsetsHolder offsetsHolder = this.offsetsHolder;
            offsetsHolder.update(mainSize, absoluteGravity, wrapLine.getItemCountNotGone());
            float firstChildOffset = paddingLeft + offsetsHolder.getFirstChildOffset();
            wrapLine.setSpaceBetweenChildren(offsetsHolder.getSpaceBetweenChildren());
            wrapLine.setEdgeSeparatorOffset(offsetsHolder.getEdgeDividerOffset());
            if (wrapLine.getItemCountNotGone() > 0) {
                if (z) {
                    paddingTop += getMiddleLineSeparatorLength();
                }
                z = true;
            }
            IntProgression indices = com.yandex.div.core.util.ViewsKt.getIndices(wrapContainerLayout2, wrapLine.getFirstIndex(), wrapLine.getItemCount());
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                wrapContainerLayout = wrapContainerLayout2;
            } else {
                boolean z2 = false;
                while (true) {
                    View child = getChildAt(first);
                    if (child == null || isHidden(child)) {
                        wrapContainerLayout = wrapContainerLayout2;
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        if (getHasIncorrectSize(child)) {
                            child.layout(0, 0, 0, 0);
                        }
                    } else {
                        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                        float middleSeparatorLength = firstChildOffset + divLayoutParams.leftMargin;
                        if (z2) {
                            middleSeparatorLength += getMiddleSeparatorLength();
                        }
                        int topOffsetForHorizontalLayout = getTopOffsetForHorizontalLayout(child, wrapLine) + paddingTop;
                        wrapContainerLayout = wrapContainerLayout2;
                        child.layout(MathKt.roundToInt(middleSeparatorLength), topOffsetForHorizontalLayout, MathKt.roundToInt(middleSeparatorLength) + child.getMeasuredWidth(), topOffsetForHorizontalLayout + child.getMeasuredHeight());
                        firstChildOffset = middleSeparatorLength + child.getMeasuredWidth() + divLayoutParams.rightMargin + wrapLine.getSpaceBetweenChildren();
                        z2 = true;
                    }
                    if (first != last) {
                        first += step;
                        wrapContainerLayout2 = wrapContainerLayout;
                    }
                }
            }
            paddingTop += wrapLine.getCrossSize();
            wrapLine.setRight(MathKt.roundToInt(firstChildOffset));
            wrapLine.setBottom(paddingTop);
            wrapContainerLayout2 = wrapContainerLayout;
        }
    }

    private final int getTopOffsetForHorizontalLayout(View view, WrapLine line) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        int verticalGravity = DivViewGroup.INSTANCE.toVerticalGravity(divLayoutParams.getGravity());
        if (verticalGravity == 16) {
            return (((line.getCrossSize() - view.getMeasuredHeight()) + divLayoutParams.topMargin) - divLayoutParams.bottomMargin) / 2;
        }
        if (verticalGravity != 80) {
            return divLayoutParams.getIsBaselineAligned() ? Math.max(line.getMaxBaseline() - view.getBaseline(), divLayoutParams.topMargin) : divLayoutParams.topMargin;
        }
        return (line.getCrossSize() - view.getMeasuredHeight()) - divLayoutParams.bottomMargin;
    }

    private final void layoutVertical(int top, int bottom) {
        WrapContainerLayout wrapContainerLayout = this;
        int paddingLeft = getPaddingLeft() + (com.yandex.div.core.util.ViewsKt.isLayoutRtl(wrapContainerLayout) ? getEndLineSeparatorLength() : getStartLineSeparatorLength());
        Iterator<Integer> it = com.yandex.div.core.util.ViewsKt.getIndices(wrapContainerLayout, 0, this.lines.size()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            WrapLine wrapLine = this.lines.get(((IntIterator) it).nextInt());
            float mainSize = (bottom - top) - wrapLine.getMainSize();
            float paddingTop = getPaddingTop() + getStartSeparatorLength();
            DivViewGroup.OffsetsHolder offsetsHolder = this.offsetsHolder;
            offsetsHolder.update(mainSize, getVerticalGravity$div_release(), wrapLine.getItemCountNotGone());
            float firstChildOffset = paddingTop + offsetsHolder.getFirstChildOffset();
            wrapLine.setSpaceBetweenChildren(offsetsHolder.getSpaceBetweenChildren());
            wrapLine.setEdgeSeparatorOffset(offsetsHolder.getEdgeDividerOffset());
            if (wrapLine.getItemCountNotGone() > 0) {
                if (z) {
                    paddingLeft += getMiddleLineSeparatorLength();
                }
                z = true;
            }
            int itemCount = wrapLine.getItemCount();
            boolean z2 = false;
            for (int i = 0; i < itemCount; i++) {
                View child = getChildAt(wrapLine.getFirstIndex() + i);
                if (child == null || isHidden(child)) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    if (getHasIncorrectSize(child)) {
                        child.layout(0, 0, 0, 0);
                    }
                } else {
                    DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                    ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                    DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                    float middleSeparatorLength = firstChildOffset + divLayoutParams.topMargin;
                    if (z2) {
                        middleSeparatorLength += getMiddleSeparatorLength();
                    }
                    int leftOffsetForVerticalLayout = getLeftOffsetForVerticalLayout(child, wrapLine.getCrossSize()) + paddingLeft;
                    child.layout(leftOffsetForVerticalLayout, MathKt.roundToInt(middleSeparatorLength), child.getMeasuredWidth() + leftOffsetForVerticalLayout, MathKt.roundToInt(middleSeparatorLength) + child.getMeasuredHeight());
                    firstChildOffset = middleSeparatorLength + child.getMeasuredHeight() + divLayoutParams.bottomMargin + wrapLine.getSpaceBetweenChildren();
                    z2 = true;
                }
            }
            paddingLeft += wrapLine.getCrossSize();
            wrapLine.setRight(paddingLeft);
            wrapLine.setBottom(MathKt.roundToInt(firstChildOffset));
        }
    }

    private final int getLeftOffsetForVerticalLayout(View view, int lineWidth) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(DivViewGroup.INSTANCE.toHorizontalGravity(divLayoutParams.getGravity()), ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            return (((lineWidth - view.getMeasuredWidth()) + divLayoutParams.leftMargin) - divLayoutParams.rightMargin) / 2;
        }
        if (absoluteGravity == 5) {
            return (lineWidth - view.getMeasuredWidth()) - divLayoutParams.rightMargin;
        }
        return divLayoutParams.leftMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (getSeparatorDrawable() == null && getLineSeparatorDrawable() == null) {
            return;
        }
        if (getShowSeparators() == 0 && getShowLineSeparators() == 0) {
            return;
        }
        if (this.isRowDirection) {
            drawSeparatorsHorizontal(canvas);
        } else {
            drawSeparatorsVertical(canvas);
        }
    }

    private final void drawSeparatorsHorizontal(Canvas canvas) {
        int right;
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        if (this.lines.size() > 0 && showSeparatorAtStart(getShowLineSeparators())) {
            WrapLine firstVisibleLine = getFirstVisibleLine();
            intRef.element = firstVisibleLine != null ? firstVisibleLine.getBottom() - firstVisibleLine.getCrossSize() : 0;
            drawSeparatorsHorizontal$drawLineSeparator(this, canvas, intRef.element - this.edgeLineSeparatorOffset);
        }
        boolean z = false;
        for (WrapLine wrapLine : this.lines) {
            if (wrapLine.getItemCountNotGone() != 0) {
                intRef2.element = wrapLine.getBottom();
                intRef.element = intRef2.element - wrapLine.getCrossSize();
                if (z && showSeparatorBetween(getShowLineSeparators())) {
                    drawSeparatorsHorizontal$drawLineSeparator(this, canvas, intRef.element - this.middleLineSeparatorOffset);
                }
                IntProgression indices = com.yandex.div.core.util.ViewsKt.getIndices(this, wrapLine.getFirstIndex(), wrapLine.getItemCount());
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    right = 0;
                    boolean z2 = true;
                    while (true) {
                        View childAt = getChildAt(first);
                        if (childAt != null && !isHidden(childAt)) {
                            DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                            DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                            int left = childAt.getLeft() - divLayoutParams.leftMargin;
                            right = divLayoutParams.rightMargin + childAt.getRight();
                            if (z2) {
                                if (showLeftSeparator(getShowSeparators())) {
                                    drawSeparatorsHorizontal$lambda$12$drawSeparator(this, canvas, intRef, intRef2, left - wrapLine.getEdgeSeparatorOffset());
                                }
                                z2 = false;
                            } else if (showSeparatorBetween(getShowSeparators())) {
                                drawSeparatorsHorizontal$lambda$12$drawSeparator(this, canvas, intRef, intRef2, left - ((int) (wrapLine.getSpaceBetweenChildren() / 2)));
                            }
                        }
                        if (first == last) {
                            break;
                        } else {
                            first += step;
                        }
                    }
                } else {
                    right = 0;
                }
                if (right > 0 && showRightSeparator(getShowSeparators())) {
                    drawSeparatorsHorizontal$lambda$12$drawSeparator(this, canvas, intRef, intRef2, right + getSeparatorLength() + wrapLine.getEdgeSeparatorOffset());
                }
                z = true;
            }
        }
        if (intRef2.element <= 0 || !showSeparatorAtEnd(getShowLineSeparators())) {
            return;
        }
        drawSeparatorsHorizontal$drawLineSeparator(this, canvas, intRef2.element + getLineSeparatorLength() + this.edgeLineSeparatorOffset);
    }

    private static final void drawSeparatorsHorizontal$drawLineSeparator(WrapContainerLayout wrapContainerLayout, Canvas canvas, int i) {
        wrapContainerLayout.drawLineSeparator(canvas, wrapContainerLayout.getPaddingLeft(), i - wrapContainerLayout.getLineSeparatorLength(), wrapContainerLayout.getWidth() - wrapContainerLayout.getPaddingRight(), i);
    }

    private static final void drawSeparatorsHorizontal$lambda$12$drawSeparator(WrapContainerLayout wrapContainerLayout, Canvas canvas, Ref.IntRef intRef, Ref.IntRef intRef2, int i) {
        wrapContainerLayout.drawSeparator(canvas, i - wrapContainerLayout.getSeparatorLength(), intRef.element, i, intRef2.element);
    }

    private final void drawSeparatorsVertical(Canvas canvas) {
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        if (this.lines.size() > 0 && showLeftSeparator(getShowLineSeparators())) {
            WrapLine firstVisibleLine = getFirstVisibleLine();
            intRef.element = firstVisibleLine != null ? firstVisibleLine.getRight() - firstVisibleLine.getCrossSize() : 0;
            drawSeparatorsVertical$drawLineSeparator$13(this, canvas, intRef.element - this.edgeLineSeparatorOffset);
        }
        Iterator<Integer> it = com.yandex.div.core.util.ViewsKt.getIndices(this, 0, this.lines.size()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            WrapLine wrapLine = this.lines.get(((IntIterator) it).nextInt());
            if (wrapLine.getItemCountNotGone() != 0) {
                intRef2.element = wrapLine.getRight();
                intRef.element = intRef2.element - wrapLine.getCrossSize();
                if (z && showSeparatorBetween(getShowLineSeparators())) {
                    drawSeparatorsVertical$drawLineSeparator$13(this, canvas, intRef.element - this.middleLineSeparatorOffset);
                }
                boolean z2 = true;
                z = getLineSeparatorDrawable() != null;
                int itemCount = wrapLine.getItemCount();
                int bottom = 0;
                for (int i = 0; i < itemCount; i++) {
                    View childAt = getChildAt(wrapLine.getFirstIndex() + i);
                    if (childAt != null && !isHidden(childAt)) {
                        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                        int top = childAt.getTop() - divLayoutParams.topMargin;
                        bottom = divLayoutParams.bottomMargin + childAt.getBottom();
                        if (z2) {
                            if (showSeparatorAtStart(getShowSeparators())) {
                                drawSeparatorsVertical$lambda$16$drawSeparator$15(this, canvas, intRef, intRef2, top - wrapLine.getEdgeSeparatorOffset());
                            }
                            z2 = false;
                        } else if (showSeparatorBetween(getShowSeparators())) {
                            drawSeparatorsVertical$lambda$16$drawSeparator$15(this, canvas, intRef, intRef2, top - ((int) (wrapLine.getSpaceBetweenChildren() / 2)));
                        }
                    }
                }
                if (bottom > 0 && showSeparatorAtEnd(getShowSeparators())) {
                    drawSeparatorsVertical$lambda$16$drawSeparator$15(this, canvas, intRef, intRef2, bottom + getSeparatorLength() + wrapLine.getEdgeSeparatorOffset());
                }
            }
        }
        if (intRef2.element <= 0 || !showRightSeparator(getShowLineSeparators())) {
            return;
        }
        drawSeparatorsVertical$drawLineSeparator$13(this, canvas, intRef2.element + getLineSeparatorLength() + this.edgeLineSeparatorOffset);
    }

    private static final void drawSeparatorsVertical$drawLineSeparator$13(WrapContainerLayout wrapContainerLayout, Canvas canvas, int i) {
        wrapContainerLayout.drawLineSeparator(canvas, i - wrapContainerLayout.getLineSeparatorLength(), wrapContainerLayout.getPaddingTop(), i, wrapContainerLayout.getHeight() - wrapContainerLayout.getPaddingBottom());
    }

    private static final void drawSeparatorsVertical$lambda$16$drawSeparator$15(WrapContainerLayout wrapContainerLayout, Canvas canvas, Ref.IntRef intRef, Ref.IntRef intRef2, int i) {
        wrapContainerLayout.drawSeparator(canvas, intRef.element, i - wrapContainerLayout.getSeparatorLength(), intRef2.element, i);
    }

    private final void drawSeparator(Canvas canvas, int left, int top, int right, int bottom) {
        drawSeparator(getSeparatorDrawable(), canvas, left + this.separatorMarginLeft, top - this.separatorMarginTop, right - this.separatorMarginRight, bottom + this.separatorMarginBottom);
    }

    private final void drawLineSeparator(Canvas canvas, int left, int top, int right, int bottom) {
        drawSeparator(getLineSeparatorDrawable(), canvas, left + this.lineSeparatorMarginLeft, top - this.lineSeparatorMarginTop, right - this.lineSeparatorMarginRight, bottom + this.lineSeparatorMarginBottom);
    }

    private final Unit drawSeparator(Drawable separator, Canvas canvas, int left, int top, int right, int bottom) {
        if (separator == null) {
            return null;
        }
        float f = (left + right) / 2.0f;
        float f2 = (top + bottom) / 2.0f;
        float intrinsicWidth = separator.getIntrinsicWidth() / 2.0f;
        float intrinsicHeight = separator.getIntrinsicHeight() / 2.0f;
        separator.setBounds((int) (f - intrinsicWidth), (int) (f2 - intrinsicHeight), (int) (f + intrinsicWidth), (int) (f2 + intrinsicHeight));
        separator.draw(canvas);
        return Unit.INSTANCE;
    }

    private final boolean showLeftSeparator(@ShowSeparatorsMode int mode) {
        return com.yandex.div.core.util.ViewsKt.isLayoutRtl(this) ? showSeparatorAtEnd(mode) : showSeparatorAtStart(mode);
    }

    private final boolean showRightSeparator(@ShowSeparatorsMode int mode) {
        return com.yandex.div.core.util.ViewsKt.isLayoutRtl(this) ? showSeparatorAtStart(mode) : showSeparatorAtEnd(mode);
    }

    private final WrapLine getFirstVisibleLine() {
        Object obj = null;
        if (!this.isRowDirection && com.yandex.div.core.util.ViewsKt.isLayoutRtl(this)) {
            List<WrapLine> list = this.lines;
            ListIterator<WrapLine> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                objPrevious = listIterator.previous();
                if (((WrapLine) objPrevious).isVisible()) {
                    obj = objPrevious;
                    break;
                }
            }
        } else {
            for (Object objPrevious : this.lines) {
                if (((WrapLine) objPrevious).isVisible()) {
                    obj = objPrevious;
                    break;
                }
            }
        }
        return (WrapLine) obj;
    }

    @Override // android.view.View
    public int getBaseline() {
        WrapLine firstVisibleLine = getFirstVisibleLine();
        return firstVisibleLine != null ? firstVisibleLine.getMaxBaseline() + getPaddingTop() : super.getBaseline();
    }

    /* JADX INFO: compiled from: WrapContainerLayout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J'\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00067"}, d2 = {"Lcom/yandex/div/core/widget/wraplayout/WrapContainerLayout$WrapLine;", "", "firstIndex", "", "mainSize", "itemCount", "(III)V", "bottom", "getBottom", "()I", "setBottom", "(I)V", "crossSize", "getCrossSize", "setCrossSize", "edgeSeparatorOffset", "getEdgeSeparatorOffset", "setEdgeSeparatorOffset", "getFirstIndex", "goneItemCount", "getGoneItemCount", "setGoneItemCount", ug.k, "", "()Z", "getItemCount", "setItemCount", "itemCountNotGone", "getItemCountNotGone", "getMainSize", "setMainSize", "maxBaseline", "getMaxBaseline", "setMaxBaseline", "maxHeightUnderBaseline", "getMaxHeightUnderBaseline", "setMaxHeightUnderBaseline", "right", "getRight", "setRight", "spaceBetweenChildren", "", "getSpaceBetweenChildren", "()F", "setSpaceBetweenChildren", "(F)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final /* data */ class WrapLine {
        private int bottom;
        private int crossSize;
        private int edgeSeparatorOffset;
        private final int firstIndex;
        private int goneItemCount;
        private int itemCount;
        private int mainSize;
        private int maxBaseline;
        private int maxHeightUnderBaseline;
        private int right;
        private float spaceBetweenChildren;

        public WrapLine() {
            this(0, 0, 0, 7, null);
        }

        public static /* synthetic */ WrapLine copy$default(WrapLine wrapLine, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = wrapLine.firstIndex;
            }
            if ((i4 & 2) != 0) {
                i2 = wrapLine.mainSize;
            }
            if ((i4 & 4) != 0) {
                i3 = wrapLine.itemCount;
            }
            return wrapLine.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFirstIndex() {
            return this.firstIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMainSize() {
            return this.mainSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getItemCount() {
            return this.itemCount;
        }

        public final WrapLine copy(int firstIndex, int mainSize, int itemCount) {
            return new WrapLine(firstIndex, mainSize, itemCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WrapLine)) {
                return false;
            }
            WrapLine wrapLine = (WrapLine) other;
            return this.firstIndex == wrapLine.firstIndex && this.mainSize == wrapLine.mainSize && this.itemCount == wrapLine.itemCount;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.firstIndex) * 31) + Integer.hashCode(this.mainSize)) * 31) + Integer.hashCode(this.itemCount);
        }

        public String toString() {
            return "WrapLine(firstIndex=" + this.firstIndex + ", mainSize=" + this.mainSize + ", itemCount=" + this.itemCount + ')';
        }

        public WrapLine(int i, int i2, int i3) {
            this.firstIndex = i;
            this.mainSize = i2;
            this.itemCount = i3;
            this.maxBaseline = -1;
        }

        public /* synthetic */ WrapLine(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
        }

        public final int getFirstIndex() {
            return this.firstIndex;
        }

        public final int getMainSize() {
            return this.mainSize;
        }

        public final void setMainSize(int i) {
            this.mainSize = i;
        }

        public final int getItemCount() {
            return this.itemCount;
        }

        public final void setItemCount(int i) {
            this.itemCount = i;
        }

        public final int getCrossSize() {
            return this.crossSize;
        }

        public final void setCrossSize(int i) {
            this.crossSize = i;
        }

        public final int getMaxBaseline() {
            return this.maxBaseline;
        }

        public final void setMaxBaseline(int i) {
            this.maxBaseline = i;
        }

        public final int getMaxHeightUnderBaseline() {
            return this.maxHeightUnderBaseline;
        }

        public final void setMaxHeightUnderBaseline(int i) {
            this.maxHeightUnderBaseline = i;
        }

        public final int getRight() {
            return this.right;
        }

        public final void setRight(int i) {
            this.right = i;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final void setBottom(int i) {
            this.bottom = i;
        }

        public final int getGoneItemCount() {
            return this.goneItemCount;
        }

        public final void setGoneItemCount(int i) {
            this.goneItemCount = i;
        }

        public final int getEdgeSeparatorOffset() {
            return this.edgeSeparatorOffset;
        }

        public final void setEdgeSeparatorOffset(int i) {
            this.edgeSeparatorOffset = i;
        }

        public final float getSpaceBetweenChildren() {
            return this.spaceBetweenChildren;
        }

        public final void setSpaceBetweenChildren(float f) {
            this.spaceBetweenChildren = f;
        }

        public final int getItemCountNotGone() {
            return this.itemCount - this.goneItemCount;
        }

        public final boolean isVisible() {
            return getItemCountNotGone() > 0;
        }
    }
}
