package com.yandex.div.core.tooltip;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.activity.OnBackPressedCallback;
import androidx.core.view.ViewGroupKt;
import com.yandex.div.R;
import com.yandex.div.core.util.AccessibilityStateProvider;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivDimension;
import com.yandex.div2.DivPoint;
import com.yandex.div2.DivTooltip;
import com.yandex.div2.DivTooltipMode;
import io.ktor.http.LinkHeader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTooltipController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0001\u001a&\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\bH\u0002\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0013*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*\u0096\u0001\b\u0000\u0010\u001c\"G\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001d2G\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001d¨\u0006%"}, d2 = {"CANT_FIND_ON_BACKPRESS_DISPATCHER", "", "calcPopupLocation", "Landroid/graphics/Point;", "popupView", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "divTooltip", "Lcom/yandex/div2/DivTooltip;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "findChildWithTooltip", "Lkotlin/Pair;", "tooltipId", "view", "getWindowFrame", "Landroid/graphics/Rect;", "Lcom/yandex/div/core/view2/Div2View;", "isModal", "", "removeBackPressedCallback", "", "Landroid/widget/PopupWindow;", "data", "Lcom/yandex/div/core/tooltip/TooltipData;", "accessibilityStateProvider", "Lcom/yandex/div/core/util/AccessibilityStateProvider;", "shouldDismissByOutsideTouch", "CreatePopupCall", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "contentView", "", "width", "height", "Lcom/yandex/div/core/util/SafePopupWindow;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivTooltipControllerKt {
    private static final String CANT_FIND_ON_BACKPRESS_DISPATCHER = "Can't find onBackPressedDispatcher to set on back press listener on tooltip.";

    /* JADX INFO: compiled from: DivTooltipController.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivTooltip.Position.values().length];
            try {
                iArr[DivTooltip.Position.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivTooltip.Position.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivTooltip.Position.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DivTooltip.Position.TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DivTooltip.Position.RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DivTooltip.Position.BOTTOM_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DivTooltip.Position.TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DivTooltip.Position.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DivTooltip.Position.CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<DivTooltip, View> findChildWithTooltip(String str, View view) {
        Object tag = view.getTag(R.id.div_tooltips_tag);
        List<DivTooltip> list = tag instanceof List ? (List) tag : null;
        if (list != null) {
            for (DivTooltip divTooltip : list) {
                if (Intrinsics.areEqual(divTooltip.id, str)) {
                    return TuplesKt.to(divTooltip, view);
                }
            }
        }
        if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                Pair<DivTooltip, View> pairFindChildWithTooltip = findChildWithTooltip(str, it.next());
                if (pairFindChildWithTooltip != null) {
                    return pairFindChildWithTooltip;
                }
            }
        }
        return null;
    }

    public static final Point calcPopupLocation(View popupView, View anchor, DivTooltip divTooltip, ExpressionResolver resolver) {
        int width;
        int height;
        int px;
        DivDimension divDimension;
        DivDimension divDimension2;
        Intrinsics.checkNotNullParameter(popupView, "popupView");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(divTooltip, "divTooltip");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        int[] iArr = new int[2];
        anchor.getLocationInWindow(iArr);
        int px2 = 0;
        Point point = new Point(iArr[0], iArr[1]);
        DivTooltip.Position positionEvaluate = divTooltip.position.evaluate(resolver);
        int i = point.x;
        switch (WhenMappings.$EnumSwitchMapping$0[positionEvaluate.ordinal()]) {
            case 1:
            case 2:
            case 3:
                width = -popupView.getWidth();
                break;
            case 4:
            case 5:
            case 6:
                width = anchor.getWidth();
                break;
            case 7:
            case 8:
            case 9:
                width = (anchor.getWidth() - popupView.getWidth()) / 2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        point.x = i + width;
        int i2 = point.y;
        switch (WhenMappings.$EnumSwitchMapping$0[positionEvaluate.ordinal()]) {
            case 1:
            case 5:
            case 9:
                height = (anchor.getHeight() - popupView.getHeight()) / 2;
                break;
            case 2:
            case 4:
            case 7:
                height = -popupView.getHeight();
                break;
            case 3:
            case 6:
            case 8:
                height = anchor.getHeight();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        point.y = i2 + height;
        DisplayMetrics displayMetrics = anchor.getResources().getDisplayMetrics();
        int i3 = point.x;
        DivPoint divPoint = divTooltip.offset;
        if (divPoint == null || (divDimension2 = divPoint.x) == null) {
            px = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
            px = BaseDivViewExtensionsKt.toPx(divDimension2, displayMetrics, resolver);
        }
        point.x = i3 + px;
        int i4 = point.y;
        DivPoint divPoint2 = divTooltip.offset;
        if (divPoint2 != null && (divDimension = divPoint2.y) != null) {
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
            px2 = BaseDivViewExtensionsKt.toPx(divDimension, displayMetrics, resolver);
        }
        point.y = i4 + px2;
        return point;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeBackPressedCallback(PopupWindow popupWindow, TooltipData tooltipData, AccessibilityStateProvider accessibilityStateProvider) {
        BaseDivViewExtensionsKt.sendAccessibilityEventUnchecked(32, popupWindow.getContentView(), accessibilityStateProvider);
        OnBackPressedCallback onBackPressedCallback = tooltipData.getOnBackPressedCallback();
        if (onBackPressedCallback == null) {
            return;
        }
        onBackPressedCallback.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isModal(DivTooltip divTooltip) {
        return divTooltip.mode instanceof DivTooltipMode.Modal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldDismissByOutsideTouch(DivTooltip divTooltip, ExpressionResolver expressionResolver) {
        return divTooltip.closeByTapOutside.evaluate(expressionResolver).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getWindowFrame(Div2View div2View) {
        Rect rect = new Rect();
        div2View.getWindowVisibleDisplayFrame(rect);
        return rect;
    }
}
