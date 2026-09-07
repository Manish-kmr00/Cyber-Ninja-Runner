package com.yandex.div.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.internal.widget.DivViewGroup;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: LinearContainerLayout.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020-H\u0002J\u0018\u0010X\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\bH\u0002J\u0018\u0010Z\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J7\u0010[\u001a\u0004\u0018\u00010T2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bH\u0002¢\u0006\u0002\u0010bJ\u0010\u0010c\u001a\u00020T2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010d\u001a\u00020T2\u0006\u0010\\\u001a\u00020]H\u0002J\u0018\u0010e\u001a\u00020T2\u0006\u0010\\\u001a\u00020]2\u0006\u0010_\u001a\u00020\bH\u0002J\u001f\u0010f\u001a\u0004\u0018\u00010T2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\bH\u0002¢\u0006\u0002\u0010gJ\u001d\u0010h\u001a\u00020T2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020T0jH\u0082\bJ#\u0010k\u001a\u00020T2\u0018\u0010i\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020T0lH\u0082\bJ\b\u0010m\u001a\u00020IH\u0014J\b\u0010n\u001a\u00020\bH\u0016J\u0010\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\bH\u0002J\u0018\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\bH\u0002J\u0018\u0010t\u001a\u00020\b2\u0006\u0010u\u001a\u00020\b2\u0006\u0010v\u001a\u00020\bH\u0002J\u0018\u0010w\u001a\u00020\b2\u0006\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u00020\bH\u0002J\u0010\u0010z\u001a\u00020-2\u0006\u0010{\u001a\u00020\bH\u0002J\u0018\u0010|\u001a\u00020-2\u0006\u0010}\u001a\u00020\b2\u0006\u0010~\u001a\u00020\bH\u0002J\u0018\u0010\u007f\u001a\u00020-2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\bH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\bH\u0002J)\u0010\u0081\u0001\u001a\u00020T2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bH\u0002J)\u0010\u0082\u0001\u001a\u00020T2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bH\u0002J!\u0010\u0083\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J!\u0010\u0084\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J*\u0010\u0085\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020-H\u0002J!\u0010\u0087\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J\u0019\u0010\u0088\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J*\u0010\u0089\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020-H\u0002J\u0019\u0010\u008a\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\bH\u0002J!\u0010\u008b\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J\u0019\u0010\u008c\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J3\u0010\u008d\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0007\u0010\u008e\u0001\u001a\u00020-2\u0007\u0010\u0086\u0001\u001a\u00020-H\u0002J\u0019\u0010\u008f\u0001\u001a\u00020-2\u0006\u0010u\u001a\u00020\b2\u0006\u0010v\u001a\u00020\bH\u0002J\u0011\u0010\u0090\u0001\u001a\u00020T2\u0006\u0010\\\u001a\u00020]H\u0014J6\u0010\u0091\u0001\u001a\u00020T2\u0007\u0010\u0092\u0001\u001a\u00020-2\u0007\u0010\u0093\u0001\u001a\u00020\b2\u0007\u0010\u0094\u0001\u001a\u00020\b2\u0007\u0010\u0095\u0001\u001a\u00020\b2\u0007\u0010\u0096\u0001\u001a\u00020\bH\u0014J\u0019\u0010\u0097\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0014J\"\u0010\u0098\u0001\u001a\u00020\b2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\bH\u0002J*\u0010\u009a\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0007\u0010\u009b\u0001\u001a\u00020\bH\u0002J\"\u0010\u009c\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0007\u0010\u009d\u0001\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002J,\u0010\u009e\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0007\u0010\u009f\u0001\u001a\u00020\b2\u0007\u0010 \u0001\u001a\u00020\b2\u0007\u0010¡\u0001\u001a\u00020\bH\u0002J!\u0010¢\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010u\u001a\u00020\bH\u0002J!\u0010£\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010u\u001a\u00020\bH\u0002J\u0019\u0010¤\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\bH\u0002J*\u0010¥\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0007\u0010¡\u0001\u001a\u00020\b2\u0006\u0010u\u001a\u00020\bH\u0002J!\u0010¦\u0001\u001a\u00020T2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010u\u001a\u00020\bH\u0002J3\u0010§\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u009b\u0001\u001a\u00020\bH\u0002J'\u0010¨\u0001\u001a\u00020T2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bJ\t\u0010©\u0001\u001a\u00020-H\u0016J\u0011\u0010ª\u0001\u001a\u00020T2\u0006\u0010U\u001a\u00020\u0016H\u0002J\u001b\u0010«\u0001\u001a\u00020T2\u0007\u0010¬\u0001\u001a\u00020\b2\u0007\u0010\u00ad\u0001\u001a\u00020\bH\u0002R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010#R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010.R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u000604R\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R1\u00105\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0004\b;\u0010\u0012\u0012\u0004\b6\u00107\u001a\u0004\b8\u0010#\"\u0004\b9\u0010:R1\u0010<\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8F@FX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b@\u0010\u0012\u0012\u0004\b=\u00107\u001a\u0004\b>\u0010#\"\u0004\b?\u0010:R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010#R\u0018\u0010H\u001a\u00020\u000b*\u00020I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0018\u0010L\u001a\u00020\u000b*\u00020I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u0018\u0010N\u001a\u00020\b*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0018\u0010Q\u001a\u00020\b*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010P¨\u0006®\u0001"}, d2 = {"Lcom/yandex/div/core/widget/LinearContainerLayout;", "Lcom/yandex/div/internal/widget/DivViewGroup;", "Lcom/yandex/div/core/widget/AspectView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "aspectRatio", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "aspectRatio$delegate", "Lkotlin/properties/ReadWriteProperty;", "childMeasuredState", "constrainedChildren", "", "Landroid/view/View;", "crossMatchParentChildren", "", "value", "Landroid/graphics/drawable/Drawable;", "dividerDrawable", "getDividerDrawable", "()Landroid/graphics/drawable/Drawable;", "setDividerDrawable", "(Landroid/graphics/drawable/Drawable;)V", "dividerHeight", "dividerHeightWithMargins", "getDividerHeightWithMargins", "()I", "dividerMarginBottom", "dividerMarginLeft", "dividerMarginRight", "dividerMarginTop", "dividerWidth", "dividerWidthWithMargins", "getDividerWidthWithMargins", "firstVisibleChildIndex", "isVertical", "", "()Z", "lastVisibleChildIndex", "maxBaselineAscent", "maxBaselineDescent", "maxCrossSize", "offsetsHolder", "Lcom/yandex/div/internal/widget/DivViewGroup$OffsetsHolder;", "orientation", "getOrientation$annotations", "()V", "getOrientation", "setOrientation", "(I)V", "orientation$delegate", "showDividers", "getShowDividers$annotations", "getShowDividers", "setShowDividers", "showDividers$delegate", "skippedMatchParentChildren", "totalConstrainedLength", "totalLength", "totalMatchParentLength", "totalWeight", "visibleChildCount", "getVisibleChildCount", "fixedHorizontalWeight", "Lcom/yandex/div/internal/widget/DivLayoutParams;", "getFixedHorizontalWeight", "(Lcom/yandex/div/internal/widget/DivLayoutParams;)F", "fixedVerticalWeight", "getFixedVerticalWeight", "maxHeight", "getMaxHeight", "(Landroid/view/View;)I", "maxWidth", "getMaxWidth", "considerMatchParentChildInMaxHeight", "", "child", "heightMeasureSpec", "measureChild", "considerMatchParentChildMarginsInWidth", "widthMeasureSpec", "considerMatchParentChildrenInMaxWidth", "drawDivider", "canvas", "Landroid/graphics/Canvas;", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "(Landroid/graphics/Canvas;IIII)Lkotlin/Unit;", "drawDividersHorizontal", "drawDividersVertical", "drawHorizontalDivider", "drawVerticalDivider", "(Landroid/graphics/Canvas;I)Lkotlin/Unit;", "forEachSignificant", "action", "Lkotlin/Function1;", "forEachSignificantIndexed", "Lkotlin/Function2;", "generateDefaultLayoutParams", "getBaseline", "getDividerOffsetBeforeChildAt", "index", "getFixedWeight", "weight", ContentDisposition.Parameters.Size, "getFreeSpace", "delta", "spec", "getMaxLength", "current", "additional", "hasDividerBeforeChildAt", "childIndex", "hasSignificantDimension", "dimension", "parentMeasureSpec", "hasSignificantHeight", "hasSignificantWidth", "layoutHorizontal", "layoutVertical", "measureChildWithSignificantSizeHorizontal", "measureChildWithSignificantSizeVertical", "measureConstrainedHeightChildFirstTime", "considerHeight", "measureConstrainedWidthChildFirstTime", "measureHorizontal", "measureMatchParentHeightChildFirstTime", "measureMatchParentWidthChild", "measureMatchParentWidthChildFirstTime", "measureVertical", "measureVerticalFirstTime", "considerWidth", "needRemeasureChildren", "onDraw", "onLayout", "changed", "l", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "r", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "onMeasure", "remeasureChildHorizontal", "width", "remeasureChildVertical", "height", "remeasureChildrenHorizontalIfNeeded", "widthSize", "remeasureChildrenVerticalIfNeeded", "heightSize", "heightSpec", "initialMaxWidth", "remeasureConstrainedHeightChildren", "remeasureConstrainedWidthChildren", "remeasureDynamicHeightChild", "remeasureMatchParentHeightChildren", "remeasureMatchParentWidthChildren", "setChildFrame", "setDividerMargins", "shouldDelayChildPressedState", "updateBaselineOffset", "updateMaxCrossSize", "measureSpec", "childSize", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class LinearContainerLayout extends DivViewGroup implements AspectView {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinearContainerLayout.class, "orientation", "getOrientation()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinearContainerLayout.class, "aspectRatio", "getAspectRatio()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(LinearContainerLayout.class, "showDividers", "getShowDividers()I", 0))};

    /* JADX INFO: renamed from: aspectRatio$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty aspectRatio;
    private int childMeasuredState;
    private final List<View> constrainedChildren;
    private final Set<View> crossMatchParentChildren;
    private Drawable dividerDrawable;
    private int dividerHeight;
    private int dividerMarginBottom;
    private int dividerMarginLeft;
    private int dividerMarginRight;
    private int dividerMarginTop;
    private int dividerWidth;
    private int firstVisibleChildIndex;
    private int lastVisibleChildIndex;
    private int maxBaselineAscent;
    private int maxBaselineDescent;
    private int maxCrossSize;
    private final DivViewGroup.OffsetsHolder offsetsHolder;

    /* JADX INFO: renamed from: orientation$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty orientation;

    /* JADX INFO: renamed from: showDividers$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty showDividers;
    private final Set<View> skippedMatchParentChildren;
    private int totalConstrainedLength;
    private int totalLength;
    private int totalMatchParentLength;
    private float totalWeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearContainerLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float getFixedWeight(float weight, int size) {
        if (weight > 0.0f) {
            return weight;
        }
        return size == -1 ? 1.0f : 0.0f;
    }

    public static /* synthetic */ void getOrientation$annotations() {
    }

    @ShowSeparatorsMode
    public static /* synthetic */ void getShowDividers$annotations() {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public /* synthetic */ LinearContainerLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxBaselineAscent = -1;
        this.maxBaselineDescent = -1;
        this.orientation = ViewsKt.dimensionAffecting$default(0, null, 2, null);
        this.aspectRatio = AspectView.INSTANCE.aspectRatioProperty$div_release();
        this.offsetsHolder = new DivViewGroup.OffsetsHolder(this, 0.0f, 0.0f, 0, 7, null);
        this.firstVisibleChildIndex = -1;
        this.lastVisibleChildIndex = -1;
        this.showDividers = ViewsKt.dimensionAffecting$default(0, null, 2, null);
        this.constrainedChildren = new ArrayList();
        this.skippedMatchParentChildren = new LinkedHashSet();
        this.crossMatchParentChildren = new LinkedHashSet();
    }

    public final int getOrientation() {
        return ((Number) this.orientation.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setOrientation(int i) {
        this.orientation.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    @Override // com.yandex.div.core.widget.AspectView
    public float getAspectRatio() {
        return ((Number) this.aspectRatio.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    @Override // com.yandex.div.core.widget.AspectView
    public void setAspectRatio(float f) {
        this.aspectRatio.setValue(this, $$delegatedProperties[1], Float.valueOf(f));
    }

    public final Drawable getDividerDrawable() {
        return this.dividerDrawable;
    }

    public final void setDividerDrawable(Drawable drawable) {
        if (Intrinsics.areEqual(this.dividerDrawable, drawable)) {
            return;
        }
        this.dividerDrawable = drawable;
        this.dividerWidth = drawable != null ? drawable.getIntrinsicWidth() : 0;
        this.dividerHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public final void setDividerMargins(int left, int top, int right, int bottom) {
        this.dividerMarginLeft = left;
        this.dividerMarginRight = right;
        this.dividerMarginTop = top;
        this.dividerMarginBottom = bottom;
        requestLayout();
    }

    public final int getShowDividers() {
        return ((Number) this.showDividers.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final void setShowDividers(int i) {
        this.showDividers.setValue(this, $$delegatedProperties[2], Integer.valueOf(i));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.dividerDrawable == null) {
            return;
        }
        if (isVertical()) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    private final void drawDividersHorizontal(Canvas canvas) {
        int paddingLeft;
        int edgeDividerOffset;
        int width;
        int edgeDividerOffset2;
        int i;
        int i2;
        boolean zIsLayoutRtl = com.yandex.div.core.util.ViewsKt.isLayoutRtl(this);
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = linearContainerLayout.getChildAt(i3);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (hasDividerBeforeChildAt(i3)) {
                    int dividerOffsetBeforeChildAt = getDividerOffsetBeforeChildAt(i3);
                    if (zIsLayoutRtl) {
                        int right = child.getRight();
                        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                        i2 = right + ((DivLayoutParams) layoutParams).rightMargin + this.dividerMarginLeft + dividerOffsetBeforeChildAt;
                    } else {
                        int left = child.getLeft();
                        DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
                        ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                        i2 = (((left - ((DivLayoutParams) layoutParams2).leftMargin) - this.dividerWidth) - this.dividerMarginRight) - dividerOffsetBeforeChildAt;
                    }
                    drawVerticalDivider(canvas, i2);
                }
            }
        }
        if (hasDividerBeforeChildAt(getChildCount())) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null && zIsLayoutRtl) {
                paddingLeft = getPaddingLeft() + this.dividerMarginLeft;
                edgeDividerOffset = this.offsetsHolder.getEdgeDividerOffset();
            } else {
                if (childAt == null) {
                    width = ((getWidth() - getPaddingRight()) - this.dividerWidth) - this.dividerMarginRight;
                    edgeDividerOffset2 = this.offsetsHolder.getEdgeDividerOffset();
                } else if (zIsLayoutRtl) {
                    int left2 = childAt.getLeft();
                    DivViewGroup.Companion companion3 = DivViewGroup.INSTANCE;
                    ViewGroup.LayoutParams layoutParams3 = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                    width = ((left2 - ((DivLayoutParams) layoutParams3).leftMargin) - this.dividerWidth) - this.dividerMarginRight;
                    edgeDividerOffset2 = this.offsetsHolder.getEdgeDividerOffset();
                } else {
                    int right2 = childAt.getRight();
                    DivViewGroup.Companion companion4 = DivViewGroup.INSTANCE;
                    ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                    paddingLeft = right2 + ((DivLayoutParams) layoutParams4).rightMargin + this.dividerMarginLeft;
                    edgeDividerOffset = this.offsetsHolder.getEdgeDividerOffset();
                }
                i = width - edgeDividerOffset2;
                drawVerticalDivider(canvas, i);
            }
            i = paddingLeft + edgeDividerOffset;
            drawVerticalDivider(canvas, i);
        }
    }

    private final void drawHorizontalDivider(Canvas canvas, int top) {
        drawDivider(canvas, getPaddingLeft() + this.dividerMarginLeft, top, (getWidth() - getPaddingRight()) - this.dividerMarginRight, top + this.dividerHeight);
    }

    private final Unit drawVerticalDivider(Canvas canvas, int left) {
        return drawDivider(canvas, left, getPaddingTop() + this.dividerMarginTop, left + this.dividerWidth, (getHeight() - getPaddingBottom()) - this.dividerMarginBottom);
    }

    private final Unit drawDivider(Canvas canvas, int left, int top, int right, int bottom) {
        Drawable drawable = this.dividerDrawable;
        if (drawable == null) {
            return null;
        }
        float f = (left + right) / 2.0f;
        float f2 = (top + bottom) / 2.0f;
        float f3 = this.dividerWidth / 2.0f;
        float f4 = this.dividerHeight / 2.0f;
        drawable.setBounds(Math.max((int) (f - f3), left), Math.max((int) (f2 - f4), top), Math.min((int) (f + f3), right), Math.min((int) (f2 + f4), bottom));
        drawable.draw(canvas);
        return Unit.INSTANCE;
    }

    @Override // android.view.View
    public int getBaseline() {
        if (isVertical()) {
            View childAt = getChildAt(0);
            if (childAt == null) {
                return super.getBaseline();
            }
            int baseline = childAt.getBaseline();
            DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
            return baseline + ((DivLayoutParams) layoutParams).topMargin + getPaddingTop();
        }
        int i = this.maxBaselineAscent;
        if (i != -1) {
            return i + getPaddingTop();
        }
        return super.getBaseline();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        this.totalLength = 0;
        this.maxCrossSize = 0;
        this.totalConstrainedLength = 0;
        this.totalMatchParentLength = 0;
        this.totalWeight = 0.0f;
        this.childMeasuredState = 0;
        LinearContainerLayout linearContainerLayout = this;
        Iterator<View> it = ViewGroupKt.getChildren(linearContainerLayout).iterator();
        int i2 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            View next = it.next();
            if (i2 < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            if (!(next.getVisibility() == 8)) {
                break;
            } else {
                i2++;
            }
        }
        this.firstVisibleChildIndex = i2;
        int i3 = 0;
        for (View view : ViewGroupKt.getChildren(linearContainerLayout)) {
            if (i3 < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            if (!(view.getVisibility() == 8)) {
                i = i3;
            }
            i3++;
        }
        this.lastVisibleChildIndex = i;
        if (isVertical()) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        }
        this.constrainedChildren.clear();
        this.crossMatchParentChildren.clear();
        this.skippedMatchParentChildren.clear();
    }

    private final boolean hasDividerBeforeChildAt(int childIndex) {
        if (childIndex != this.firstVisibleChildIndex) {
            if (childIndex <= this.lastVisibleChildIndex) {
                if ((getShowDividers() & 2) == 0) {
                    return false;
                }
                for (int i = childIndex - 1; -1 < i; i--) {
                    View childAt = getChildAt(childIndex);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(childIndex)");
                    if (childAt.getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
            if ((getShowDividers() & 4) == 0) {
                return false;
            }
        } else if ((getShowDividers() & 1) == 0) {
            return false;
        }
        return true;
    }

    private final int getDividerOffsetBeforeChildAt(int index) {
        if (index == this.firstVisibleChildIndex) {
            return this.offsetsHolder.getEdgeDividerOffset();
        }
        return (int) (this.offsetsHolder.getSpaceBetweenChildren() / 2);
    }

    private final void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        boolean z = View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824;
        if (getAspectRatio() != 0.0f) {
            if (z) {
                heightMeasureSpec = ViewsKt.makeExactSpec(MathKt.roundToInt(size / getAspectRatio()));
            } else {
                heightMeasureSpec = ViewsKt.makeExactSpec(0);
            }
        }
        if (!z) {
            size = Math.max(getSuggestedMinimumWidth(), getHorizontalPaddings$div_release());
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(size, 0);
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = linearContainerLayout.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (hasDividerBeforeChildAt(i)) {
                    this.totalLength += getDividerHeightWithMargins();
                }
                float f = this.totalWeight;
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                this.totalWeight = f + getFixedVerticalWeight((DivLayoutParams) layoutParams);
                measureChildWithSignificantSizeVertical(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
        considerMatchParentChildrenInMaxWidth(widthMeasureSpec, heightMeasureSpec);
        Iterator<T> it = this.crossMatchParentChildren.iterator();
        while (it.hasNext()) {
            measureMatchParentWidthChild((View) it.next(), heightMeasureSpec);
        }
        if (this.totalLength > 0 && hasDividerBeforeChildAt(getChildCount())) {
            this.totalLength += getDividerHeightWithMargins();
        }
        this.totalLength += getVerticalPaddings$div_release();
        this.maxCrossSize = Math.max(iCoerceAtLeast, this.maxCrossSize + getHorizontalPaddings$div_release());
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (getAspectRatio() != 0.0f && !z) {
            size2 = MathKt.roundToInt((ViewGroup.resolveSizeAndState(this.maxCrossSize, widthMeasureSpec, this.childMeasuredState) & ViewCompat.MEASURED_SIZE_MASK) / getAspectRatio());
            heightMeasureSpec = ViewsKt.makeExactSpec(size2);
            remeasureChildrenVerticalIfNeeded(widthMeasureSpec, size2, heightMeasureSpec, iCoerceAtLeast);
        } else if (getAspectRatio() == 0.0f && !ViewsKt.isExact(heightMeasureSpec)) {
            remeasureChildrenVerticalIfNeeded(widthMeasureSpec, Math.max(this.totalLength, getSuggestedMinimumHeight()), heightMeasureSpec, iCoerceAtLeast);
            size2 = Math.max(this.totalLength, getSuggestedMinimumHeight());
        } else {
            remeasureChildrenVerticalIfNeeded(widthMeasureSpec, size2, heightMeasureSpec, iCoerceAtLeast);
        }
        setMeasuredDimension(ViewGroup.resolveSizeAndState(this.maxCrossSize, widthMeasureSpec, this.childMeasuredState), ViewGroup.resolveSizeAndState(size2, heightMeasureSpec, this.childMeasuredState << 16));
    }

    private final int getDividerHeightWithMargins() {
        return this.dividerHeight + this.dividerMarginTop + this.dividerMarginBottom;
    }

    private final void measureChildWithSignificantSizeVertical(View child, int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        boolean zIsExact = ViewsKt.isExact(widthMeasureSpec);
        boolean zHasSignificantHeight = hasSignificantHeight(child, heightMeasureSpec);
        if (zIsExact) {
            z = zHasSignificantHeight;
        } else {
            z = divLayoutParams.width != -1;
        }
        if (z) {
            measureVerticalFirstTime(child, widthMeasureSpec, heightMeasureSpec, true, true);
            return;
        }
        if (!zIsExact) {
            this.crossMatchParentChildren.add(child);
        }
        if (zHasSignificantHeight) {
            return;
        }
        this.skippedMatchParentChildren.add(child);
        int i = this.totalLength;
        DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        this.totalLength = getMaxLength(i, ((DivLayoutParams) layoutParams2).getVerticalMargins$div_release());
    }

    private final boolean hasSignificantHeight(View child, int heightMeasureSpec) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        return hasSignificantDimension(((DivLayoutParams) layoutParams).height, heightMeasureSpec);
    }

    private final void measureVerticalFirstTime(View child, int widthMeasureSpec, int heightMeasureSpec, boolean considerWidth, boolean considerHeight) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        int i = divLayoutParams.height;
        if (i == -3) {
            measureConstrainedHeightChildFirstTime(child, widthMeasureSpec, heightMeasureSpec, considerHeight);
        } else if (i == -1) {
            measureMatchParentHeightChildFirstTime(child, widthMeasureSpec, heightMeasureSpec, considerHeight);
        } else {
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        }
        this.childMeasuredState = ViewGroup.combineMeasuredStates(this.childMeasuredState, child.getMeasuredState());
        if (considerWidth) {
            updateMaxCrossSize(widthMeasureSpec, child.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release());
        }
        if (considerHeight) {
            this.totalLength = getMaxLength(this.totalLength, child.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release());
        }
    }

    private final void measureConstrainedHeightChildFirstTime(View child, int widthMeasureSpec, int heightMeasureSpec, boolean considerHeight) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        int maxHeight = divLayoutParams.getMaxHeight();
        divLayoutParams.height = -2;
        divLayoutParams.setMaxHeight(Integer.MAX_VALUE);
        measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        divLayoutParams.height = -3;
        divLayoutParams.setMaxHeight(maxHeight);
        if (considerHeight) {
            this.totalConstrainedLength = getMaxLength(this.totalConstrainedLength, child.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release());
            if (this.constrainedChildren.contains(child)) {
                return;
            }
            this.constrainedChildren.add(child);
        }
    }

    private final void measureMatchParentHeightChildFirstTime(View child, int widthMeasureSpec, int heightMeasureSpec, boolean considerHeight) {
        if (ViewsKt.isExact(heightMeasureSpec)) {
            measureChildWithMargins(child, widthMeasureSpec, 0, ViewsKt.makeExactSpec(0), 0);
            return;
        }
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        divLayoutParams.height = -2;
        measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        divLayoutParams.height = -1;
        if (considerHeight) {
            this.totalMatchParentLength = getMaxLength(this.totalMatchParentLength, child.getMeasuredHeight());
        }
    }

    private final void considerMatchParentChildrenInMaxWidth(int widthMeasureSpec, int heightMeasureSpec) {
        if (ViewsKt.isExact(widthMeasureSpec)) {
            return;
        }
        if (this.maxCrossSize != 0) {
            for (View view : this.crossMatchParentChildren) {
                int i = this.maxCrossSize;
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                this.maxCrossSize = Math.max(i, ((DivLayoutParams) layoutParams).getHorizontalMargins$div_release());
            }
            return;
        }
        for (View view2 : this.crossMatchParentChildren) {
            measureVerticalFirstTime(view2, widthMeasureSpec, heightMeasureSpec, true, false);
            this.skippedMatchParentChildren.remove(view2);
        }
    }

    private final void measureMatchParentWidthChild(View child, int heightMeasureSpec) {
        if (hasSignificantHeight(child, heightMeasureSpec)) {
            measureVerticalFirstTime(child, ViewsKt.makeExactSpec(this.maxCrossSize + getHorizontalPaddings$div_release()), heightMeasureSpec, false, true);
            this.skippedMatchParentChildren.remove(child);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private final void remeasureChildrenVerticalIfNeeded(int widthMeasureSpec, int heightSize, int heightSpec, int initialMaxWidth) {
        int i = heightSize - this.totalLength;
        List<View> list = this.constrainedChildren;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (getMaxHeight((View) it.next()) != Integer.MAX_VALUE) {
                }
            }
            if (!needRemeasureChildren(i, heightSpec)) {
                return;
            }
        } else if (!needRemeasureChildren(i, heightSpec)) {
            return;
        }
        this.totalLength = 0;
        remeasureConstrainedHeightChildren(widthMeasureSpec, heightSpec, i);
        remeasureMatchParentHeightChildren(widthMeasureSpec, heightSpec, initialMaxWidth, i);
        this.totalLength += getVerticalPaddings$div_release();
    }

    private final boolean needRemeasureChildren(int delta, int spec) {
        if (!this.skippedMatchParentChildren.isEmpty()) {
            return true;
        }
        if (!ViewsKt.isUnspecified(spec)) {
            if (delta < 0) {
                if (this.totalConstrainedLength > 0 || this.totalWeight > 0.0f) {
                    return true;
                }
            } else if (ViewsKt.isExact(spec) && delta > 0 && this.totalWeight > 0.0f) {
                return true;
            }
        }
        return false;
    }

    private final void remeasureConstrainedHeightChildren(int widthMeasureSpec, int heightMeasureSpec, int delta) {
        int freeSpace = getFreeSpace(delta, heightMeasureSpec);
        if (freeSpace < 0) {
            List<View> list = this.constrainedChildren;
            if (list.size() > 1) {
                kotlin.collections.CollectionsKt.sortWith(list, new Comparator() { // from class: com.yandex.div.core.widget.LinearContainerLayout$remeasureConstrainedHeightChildren$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        View view = (View) t2;
                        View view2 = (View) t;
                        return ComparisonsKt.compareValues(Float.valueOf(view.getMinimumHeight() / view.getMeasuredHeight()), Float.valueOf(view2.getMinimumHeight() / view2.getMeasuredHeight()));
                    }
                });
            }
            for (View view : this.constrainedChildren) {
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                int measuredHeight = view.getMeasuredHeight();
                int verticalMargins$div_release = divLayoutParams.getVerticalMargins$div_release() + measuredHeight;
                remeasureChildVertical(view, widthMeasureSpec, this.maxCrossSize, RangesKt.coerceAtMost(RangesKt.coerceAtLeast(MathKt.roundToInt((verticalMargins$div_release / this.totalConstrainedLength) * freeSpace) + measuredHeight, view.getMinimumHeight()), divLayoutParams.getMaxHeight()));
                this.childMeasuredState = ViewGroup.combineMeasuredStates(this.childMeasuredState, view.getMeasuredState() & 16777216);
                this.totalConstrainedLength -= verticalMargins$div_release;
                freeSpace -= view.getMeasuredHeight() - measuredHeight;
            }
            return;
        }
        for (View view2 : this.constrainedChildren) {
            if (getMaxHeight(view2) != Integer.MAX_VALUE) {
                remeasureChildVertical(view2, widthMeasureSpec, this.maxCrossSize, Math.min(view2.getMeasuredHeight(), getMaxHeight(view2)));
            }
        }
    }

    private final void remeasureChildVertical(View child, int widthMeasureSpec, int maxWidth, int height) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        int i = divLayoutParams.width;
        if (i == -1) {
            if (maxWidth == 0) {
                divLayoutParams.width = -3;
            } else {
                widthMeasureSpec = ViewsKt.makeExactSpec(maxWidth);
            }
        }
        int childMeasureSpec = DivViewGroup.INSTANCE.getChildMeasureSpec(widthMeasureSpec, getHorizontalPaddings$div_release() + divLayoutParams.getHorizontalMargins$div_release(), divLayoutParams.width, child.getMinimumWidth(), divLayoutParams.getMaxWidth());
        divLayoutParams.width = i;
        child.measure(childMeasureSpec, ViewsKt.makeExactSpec(height));
        this.childMeasuredState = ViewGroup.combineMeasuredStates(this.childMeasuredState, child.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
    }

    private final void remeasureMatchParentHeightChildren(int widthMeasureSpec, int heightMeasureSpec, int initialMaxWidth, int delta) {
        int freeSpace = getFreeSpace(delta, heightMeasureSpec);
        float fixedVerticalWeight = this.totalWeight;
        int i = this.maxCrossSize;
        this.maxCrossSize = 0;
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        int i2 = freeSpace;
        for (int i3 = 0; i3 < childCount; i3++) {
            View child = linearContainerLayout.getChildAt(i3);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                if (divLayoutParams.height == -1) {
                    if (freeSpace > 0) {
                        int fixedVerticalWeight2 = (int) ((getFixedVerticalWeight(divLayoutParams) * i2) / fixedVerticalWeight);
                        fixedVerticalWeight -= getFixedVerticalWeight(divLayoutParams);
                        i2 -= fixedVerticalWeight2;
                        remeasureChildVertical(child, widthMeasureSpec, i, fixedVerticalWeight2);
                    } else if (this.skippedMatchParentChildren.contains(child)) {
                        remeasureChildVertical(child, widthMeasureSpec, i, 0);
                    }
                }
                updateMaxCrossSize(widthMeasureSpec, child.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release());
                this.totalLength = getMaxLength(this.totalLength, child.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release());
            }
        }
        this.maxCrossSize = Math.max(initialMaxWidth, this.maxCrossSize + getHorizontalPaddings$div_release());
        KAssert kAssert = KAssert.INSTANCE;
        Integer numValueOf = Integer.valueOf(i);
        Integer numValueOf2 = Integer.valueOf(this.maxCrossSize);
        if (Assert.isEnabled()) {
            Assert.assertEquals("Width of vertical container changed after remeasuring", numValueOf, numValueOf2);
        }
    }

    private final int getFreeSpace(int delta, int spec) {
        int i;
        if (delta >= 0 || (i = this.totalMatchParentLength) <= 0) {
            return (delta < 0 || !ViewsKt.isExact(spec)) ? delta : delta + this.totalMatchParentLength;
        }
        return RangesKt.coerceAtLeast(delta + i, 0);
    }

    private final void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        int iMakeExactSpec;
        this.maxBaselineAscent = -1;
        this.maxBaselineDescent = -1;
        boolean zIsExact = ViewsKt.isExact(widthMeasureSpec);
        if (getAspectRatio() == 0.0f) {
            iMakeExactSpec = heightMeasureSpec;
        } else if (zIsExact) {
            iMakeExactSpec = ViewsKt.makeExactSpec(MathKt.roundToInt(View.MeasureSpec.getSize(widthMeasureSpec) / getAspectRatio()));
        } else {
            iMakeExactSpec = ViewsKt.makeExactSpec(0);
        }
        int size = View.MeasureSpec.getSize(iMakeExactSpec);
        boolean zIsExact2 = ViewsKt.isExact(iMakeExactSpec);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(zIsExact2 ? size : Math.max(getSuggestedMinimumHeight(), getVerticalPaddings$div_release()), 0);
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = linearContainerLayout.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (hasDividerBeforeChildAt(i)) {
                    this.totalLength += getDividerWidthWithMargins();
                }
                float f = this.totalWeight;
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                this.totalWeight = f + getFixedHorizontalWeight((DivLayoutParams) layoutParams);
                measureChildWithSignificantSizeHorizontal(child, widthMeasureSpec, iMakeExactSpec);
            }
        }
        int childCount2 = linearContainerLayout.getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            View child2 = linearContainerLayout.getChildAt(i2);
            if (child2.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child2, "child");
                considerMatchParentChildMarginsInWidth(child2, widthMeasureSpec);
            }
        }
        if (this.totalLength > 0 && hasDividerBeforeChildAt(getChildCount())) {
            this.totalLength += getDividerWidthWithMargins();
        }
        this.totalLength += getHorizontalPaddings$div_release();
        int iResolveSizeAndState = ViewGroup.resolveSizeAndState(Math.max(getSuggestedMinimumWidth(), this.totalLength), widthMeasureSpec, this.childMeasuredState);
        int i3 = 16777215 & iResolveSizeAndState;
        if (!zIsExact && getAspectRatio() != 0.0f) {
            size = MathKt.roundToInt(i3 / getAspectRatio());
            iMakeExactSpec = ViewsKt.makeExactSpec(size);
        }
        remeasureChildrenHorizontalIfNeeded(widthMeasureSpec, i3, iMakeExactSpec);
        if (!zIsExact2 && getAspectRatio() == 0.0f) {
            int childCount3 = linearContainerLayout.getChildCount();
            for (int i4 = 0; i4 < childCount3; i4++) {
                View child3 = linearContainerLayout.getChildAt(i4);
                if (child3.getVisibility() != 8) {
                    Intrinsics.checkNotNullExpressionValue(child3, "child");
                    considerMatchParentChildInMaxHeight(child3, iMakeExactSpec, this.maxCrossSize == 0);
                }
            }
            this.maxCrossSize = Math.max(iCoerceAtLeast, this.maxCrossSize + getVerticalPaddings$div_release());
            int i5 = this.maxBaselineAscent;
            if (i5 != -1) {
                updateMaxCrossSize(iMakeExactSpec, i5 + this.maxBaselineDescent);
            }
            size = ViewGroup.resolveSize(this.maxCrossSize, iMakeExactSpec);
        }
        int childCount4 = linearContainerLayout.getChildCount();
        for (int i6 = 0; i6 < childCount4; i6++) {
            View child4 = linearContainerLayout.getChildAt(i6);
            if (child4.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child4, "child");
                remeasureDynamicHeightChild(child4, ViewsKt.makeExactSpec(size));
            }
        }
        setMeasuredDimension(iResolveSizeAndState, ViewGroup.resolveSizeAndState(size, iMakeExactSpec, this.childMeasuredState << 16));
    }

    private final int getDividerWidthWithMargins() {
        return this.dividerWidth + this.dividerMarginRight + this.dividerMarginLeft;
    }

    private final void measureChildWithSignificantSizeHorizontal(View child, int widthMeasureSpec, int heightMeasureSpec) {
        if (hasSignificantWidth(child, widthMeasureSpec)) {
            DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
            DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
            int i = divLayoutParams.width;
            if (i == -3) {
                measureConstrainedWidthChildFirstTime(child, widthMeasureSpec, heightMeasureSpec);
            } else if (i == -1) {
                measureMatchParentWidthChildFirstTime(child, widthMeasureSpec, heightMeasureSpec);
            } else {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
            }
            this.childMeasuredState = ViewGroup.combineMeasuredStates(this.childMeasuredState, child.getMeasuredState());
            updateMaxCrossSize(heightMeasureSpec, child.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release());
            updateBaselineOffset(child);
            this.totalLength = getMaxLength(this.totalLength, child.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release());
        }
    }

    private final boolean hasSignificantWidth(View child, int widthMeasureSpec) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        return hasSignificantDimension(((DivLayoutParams) layoutParams).width, widthMeasureSpec);
    }

    private final boolean hasSignificantDimension(int dimension, int parentMeasureSpec) {
        return (dimension == -1 && ViewsKt.isExact(parentMeasureSpec)) ? false : true;
    }

    private final void measureConstrainedWidthChildFirstTime(View child, int widthMeasureSpec, int heightMeasureSpec) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        int maxWidth = divLayoutParams.getMaxWidth();
        divLayoutParams.width = -2;
        divLayoutParams.setMaxWidth(Integer.MAX_VALUE);
        measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        divLayoutParams.width = -3;
        divLayoutParams.setMaxWidth(maxWidth);
        this.totalConstrainedLength = getMaxLength(this.totalConstrainedLength, child.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release());
        this.constrainedChildren.add(child);
    }

    private final void measureMatchParentWidthChildFirstTime(View child, int widthMeasureSpec, int heightMeasureSpec) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        divLayoutParams.width = -2;
        measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        divLayoutParams.width = -1;
        this.totalMatchParentLength = getMaxLength(this.totalMatchParentLength, child.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release());
    }

    private final void considerMatchParentChildMarginsInWidth(View child, int widthMeasureSpec) {
        if (hasSignificantWidth(child, widthMeasureSpec)) {
            return;
        }
        int i = this.totalLength;
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        this.totalLength = getMaxLength(i, ((DivLayoutParams) layoutParams).getHorizontalMargins$div_release());
    }

    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private final void remeasureChildrenHorizontalIfNeeded(int widthMeasureSpec, int widthSize, int heightMeasureSpec) {
        int i = widthSize - this.totalLength;
        List<View> list = this.constrainedChildren;
        if ((list instanceof Collection) && list.isEmpty()) {
            if (!needRemeasureChildren(i, widthMeasureSpec)) {
                return;
            }
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (getMaxWidth((View) it.next()) != Integer.MAX_VALUE) {
                }
            }
            if (!needRemeasureChildren(i, widthMeasureSpec)) {
                return;
            }
        }
        this.totalLength = 0;
        remeasureConstrainedWidthChildren(widthMeasureSpec, heightMeasureSpec, i);
        remeasureMatchParentWidthChildren(widthMeasureSpec, heightMeasureSpec, i);
        this.totalLength += getHorizontalPaddings$div_release();
    }

    private final void remeasureConstrainedWidthChildren(int widthMeasureSpec, int heightMeasureSpec, int delta) {
        int freeSpace = getFreeSpace(delta, widthMeasureSpec);
        if (freeSpace < 0) {
            List<View> list = this.constrainedChildren;
            if (list.size() > 1) {
                kotlin.collections.CollectionsKt.sortWith(list, new Comparator() { // from class: com.yandex.div.core.widget.LinearContainerLayout$remeasureConstrainedWidthChildren$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        View view = (View) t2;
                        View view2 = (View) t;
                        return ComparisonsKt.compareValues(Float.valueOf(view.getMinimumWidth() / view.getMeasuredWidth()), Float.valueOf(view2.getMinimumWidth() / view2.getMeasuredWidth()));
                    }
                });
            }
            for (View view : this.constrainedChildren) {
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                int measuredWidth = view.getMeasuredWidth();
                int horizontalMargins$div_release = divLayoutParams.getHorizontalMargins$div_release() + measuredWidth;
                remeasureChildHorizontal(view, heightMeasureSpec, RangesKt.coerceAtMost(RangesKt.coerceAtLeast(MathKt.roundToInt((horizontalMargins$div_release / this.totalConstrainedLength) * freeSpace) + measuredWidth, view.getMinimumWidth()), divLayoutParams.getMaxWidth()));
                this.childMeasuredState = ViewGroup.combineMeasuredStates(this.childMeasuredState, view.getMeasuredState() & 16777216);
                this.totalConstrainedLength -= horizontalMargins$div_release;
                freeSpace -= view.getMeasuredWidth() - measuredWidth;
            }
            return;
        }
        for (View view2 : this.constrainedChildren) {
            if (getMaxWidth(view2) != Integer.MAX_VALUE) {
                remeasureChildHorizontal(view2, heightMeasureSpec, Math.min(view2.getMeasuredWidth(), getMaxWidth(view2)));
            }
        }
    }

    private final void remeasureMatchParentWidthChildren(int widthMeasureSpec, int heightMeasureSpec, int delta) {
        int freeSpace = getFreeSpace(delta, widthMeasureSpec);
        float fixedHorizontalWeight = this.totalWeight;
        this.maxCrossSize = 0;
        this.maxBaselineAscent = -1;
        this.maxBaselineDescent = -1;
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        int i = freeSpace;
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = linearContainerLayout.getChildAt(i2);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                if (divLayoutParams.width == -1) {
                    if (freeSpace > 0) {
                        int fixedHorizontalWeight2 = (int) ((getFixedHorizontalWeight(divLayoutParams) * i) / fixedHorizontalWeight);
                        fixedHorizontalWeight -= getFixedHorizontalWeight(divLayoutParams);
                        i -= fixedHorizontalWeight2;
                        remeasureChildHorizontal(child, heightMeasureSpec, fixedHorizontalWeight2);
                    } else {
                        remeasureChildHorizontal(child, heightMeasureSpec, 0);
                    }
                }
                updateMaxCrossSize(heightMeasureSpec, child.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release());
                this.totalLength = getMaxLength(this.totalLength, child.getMeasuredWidth() + divLayoutParams.getHorizontalMargins$div_release());
                updateBaselineOffset(child);
            }
        }
    }

    private final void considerMatchParentChildInMaxHeight(View child, int heightMeasureSpec, boolean measureChild) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        if (divLayoutParams.height != -1) {
            return;
        }
        if (measureChild) {
            this.maxCrossSize = Math.max(this.maxCrossSize, divLayoutParams.getVerticalMargins$div_release());
        } else {
            remeasureChildHorizontal(child, heightMeasureSpec, child.getMeasuredWidth());
            updateMaxCrossSize(heightMeasureSpec, child.getMeasuredHeight() + divLayoutParams.getVerticalMargins$div_release());
        }
    }

    private final void remeasureDynamicHeightChild(View child, int heightMeasureSpec) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        int i = ((DivLayoutParams) layoutParams).height;
        if (i == -1 || i == -3) {
            remeasureChildHorizontal(child, heightMeasureSpec, child.getMeasuredWidth());
        }
    }

    private final int remeasureChildHorizontal(View child, int heightMeasureSpec, int width) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        child.measure(ViewsKt.makeExactSpec(width), DivViewGroup.INSTANCE.getChildMeasureSpec(heightMeasureSpec, divLayoutParams.getVerticalMargins$div_release() + getVerticalPaddings$div_release(), divLayoutParams.height, child.getMinimumHeight(), divLayoutParams.getMaxHeight()));
        return ViewGroup.combineMeasuredStates(this.childMeasuredState, child.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
    }

    private final void updateMaxCrossSize(int measureSpec, int childSize) {
        if (ViewsKt.isExact(measureSpec)) {
            return;
        }
        this.maxCrossSize = Math.max(this.maxCrossSize, childSize);
    }

    private final int getMaxLength(int current, int additional) {
        return Math.max(current, additional + current);
    }

    private final void updateBaselineOffset(View child) {
        int baseline;
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
        if (divLayoutParams.getIsBaselineAligned() && (baseline = child.getBaseline()) != -1) {
            this.maxBaselineAscent = Math.max(this.maxBaselineAscent, divLayoutParams.topMargin + baseline);
            this.maxBaselineDescent = Math.max(this.maxBaselineDescent, (child.getMeasuredHeight() - baseline) - divLayoutParams.topMargin);
        }
    }

    private final void forEachSignificant(Function1<? super View, Unit> action) {
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = linearContainerLayout.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                action.invoke(child);
            }
        }
    }

    private final void forEachSignificantIndexed(Function2<? super View, ? super Integer, Unit> action) {
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = linearContainerLayout.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                action.invoke(child, Integer.valueOf(i));
            }
        }
    }

    private final int getMaxHeight(View view) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        return ((DivLayoutParams) layoutParams).getMaxHeight();
    }

    private final int getMaxWidth(View view) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        return ((DivLayoutParams) layoutParams).getMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isVertical()) {
            layoutVertical(l, t, r, b);
        } else {
            layoutHorizontal(l, t, r, b);
        }
    }

    private final void layoutVertical(int left, int top, int right, int bottom) {
        int i;
        int horizontalPaddings$div_release = (right - left) - getHorizontalPaddings$div_release();
        float f = (bottom - top) - this.totalLength;
        float paddingTop = getPaddingTop();
        this.offsetsHolder.update(f, getVerticalGravity$div_release(), getVisibleChildCount());
        float firstChildOffset = paddingTop + this.offsetsHolder.getFirstChildOffset();
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = linearContainerLayout.getChildAt(i2);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                int measuredWidth = child.getMeasuredWidth();
                int measuredHeight = child.getMeasuredHeight();
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                int horizontalGravity = DivViewGroup.INSTANCE.toHorizontalGravity(divLayoutParams.getGravity());
                if (horizontalGravity < 0) {
                    horizontalGravity = getHorizontalGravity$div_release();
                }
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                int paddingLeft = getPaddingLeft();
                int absoluteGravity = GravityCompat.getAbsoluteGravity(horizontalGravity, layoutDirection);
                if (absoluteGravity == 1) {
                    i = (((horizontalPaddings$div_release - measuredWidth) + divLayoutParams.leftMargin) - divLayoutParams.rightMargin) / 2;
                } else if (absoluteGravity != 3 && absoluteGravity == 5) {
                    i = (horizontalPaddings$div_release - measuredWidth) - divLayoutParams.rightMargin;
                } else {
                    i = divLayoutParams.leftMargin;
                }
                int i3 = paddingLeft + i;
                if (hasDividerBeforeChildAt(i2)) {
                    firstChildOffset += getDividerHeightWithMargins();
                }
                float f2 = firstChildOffset + divLayoutParams.topMargin;
                setChildFrame(child, i3, MathKt.roundToInt(f2), measuredWidth, measuredHeight);
                firstChildOffset = f2 + measuredHeight + divLayoutParams.bottomMargin + this.offsetsHolder.getSpaceBetweenChildren();
            }
        }
    }

    private final int getVisibleChildCount() {
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!(it.next().getVisibility() == 8) && (i = i + 1) < 0) {
                kotlin.collections.CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    private final void layoutHorizontal(int left, int top, int right, int bottom) {
        int i;
        int i2;
        int baseline;
        int verticalPaddings$div_release = (bottom - top) - getVerticalPaddings$div_release();
        LinearContainerLayout linearContainerLayout = this;
        int layoutDirection = ViewCompat.getLayoutDirection(linearContainerLayout);
        float f = (right - left) - this.totalLength;
        float paddingLeft = getPaddingLeft();
        this.offsetsHolder.update(f, GravityCompat.getAbsoluteGravity(getHorizontalGravity$div_release(), layoutDirection), getVisibleChildCount());
        float firstChildOffset = paddingLeft + this.offsetsHolder.getFirstChildOffset();
        IntProgression indices = com.yandex.div.core.util.ViewsKt.getIndices(linearContainerLayout, 0, getChildCount());
        int first = indices.getFirst();
        int last = indices.getLast();
        int step = indices.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            View childAt = getChildAt(first);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                int verticalGravity = DivViewGroup.INSTANCE.toVerticalGravity(divLayoutParams.getGravity());
                if (verticalGravity < 0) {
                    verticalGravity = getVerticalGravity$div_release();
                }
                int paddingTop = getPaddingTop();
                if (verticalGravity == 16) {
                    i = (((verticalPaddings$div_release - measuredHeight) + divLayoutParams.topMargin) - divLayoutParams.bottomMargin) / 2;
                } else if (verticalGravity != 48) {
                    if (verticalGravity != 80) {
                        i = 0;
                    } else {
                        i2 = verticalPaddings$div_release - measuredHeight;
                        baseline = divLayoutParams.bottomMargin;
                        i = i2 - baseline;
                    }
                } else if (!divLayoutParams.getIsBaselineAligned() || divLayoutParams.height == -1 || childAt.getBaseline() == -1) {
                    i = divLayoutParams.topMargin;
                } else {
                    i2 = this.maxBaselineAscent;
                    baseline = childAt.getBaseline();
                    i = i2 - baseline;
                }
                int i3 = paddingTop + i;
                if (hasDividerBeforeChildAt(com.yandex.div.core.util.ViewsKt.isLayoutRtl(linearContainerLayout) ? first + 1 : first)) {
                    firstChildOffset += getDividerWidthWithMargins();
                }
                float f2 = firstChildOffset + divLayoutParams.leftMargin;
                setChildFrame(childAt, MathKt.roundToInt(f2), i3, measuredWidth, measuredHeight);
                firstChildOffset = f2 + measuredWidth + divLayoutParams.rightMargin + this.offsetsHolder.getSpaceBetweenChildren();
            }
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    private final void setChildFrame(View child, int left, int top, int width, int height) {
        child.layout(left, top, width + left, height + top);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yandex.div.internal.widget.DivViewGroup, android.view.ViewGroup
    public DivLayoutParams generateDefaultLayoutParams() {
        return isVertical() ? new DivLayoutParams(-1, -2) : new DivLayoutParams(-2, -2);
    }

    private final boolean isVertical() {
        return getOrientation() == 1;
    }

    private final float getFixedHorizontalWeight(DivLayoutParams divLayoutParams) {
        return getFixedWeight(divLayoutParams.getHorizontalWeight(), divLayoutParams.width);
    }

    private final float getFixedVerticalWeight(DivLayoutParams divLayoutParams) {
        return getFixedWeight(divLayoutParams.getVerticalWeight(), divLayoutParams.height);
    }

    private final void drawDividersVertical(Canvas canvas) {
        int height;
        LinearContainerLayout linearContainerLayout = this;
        int childCount = linearContainerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = linearContainerLayout.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (hasDividerBeforeChildAt(i)) {
                    int top = child.getTop();
                    DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                    ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                    drawHorizontalDivider(canvas, (((top - ((DivLayoutParams) layoutParams).topMargin) - this.dividerHeight) - this.dividerMarginBottom) - getDividerOffsetBeforeChildAt(i));
                }
            }
        }
        if (hasDividerBeforeChildAt(getChildCount())) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                height = bottom + ((DivLayoutParams) layoutParams2).bottomMargin + this.dividerMarginTop + this.offsetsHolder.getEdgeDividerOffset();
            } else {
                height = (((getHeight() - getPaddingBottom()) - this.dividerHeight) - this.dividerMarginBottom) - this.offsetsHolder.getEdgeDividerOffset();
            }
            drawHorizontalDivider(canvas, height);
        }
    }
}
