package com.yandex.div.core.util;

import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.downloader.DivPatchApply;
import com.yandex.div.core.downloader.DivPatchMap;
import com.yandex.div.internal.graphics.Colormap;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionList;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.DivAbsoluteEdgeInsets;
import com.yandex.div2.DivBackground;
import com.yandex.div2.DivBorder;
import com.yandex.div2.DivCornersRadius;
import com.yandex.div2.DivData;
import com.yandex.div2.DivDimension;
import com.yandex.div2.DivDrawable;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivFilter;
import com.yandex.div2.DivFixedSize;
import com.yandex.div2.DivInput;
import com.yandex.div2.DivLinearGradient;
import com.yandex.div2.DivPatch;
import com.yandex.div2.DivPivot;
import com.yandex.div2.DivPoint;
import com.yandex.div2.DivRadialGradientCenter;
import com.yandex.div2.DivRadialGradientRadius;
import com.yandex.div2.DivShadow;
import com.yandex.div2.DivShape;
import com.yandex.div2.DivSize;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivStroke;
import com.yandex.div2.DivTransform;
import com.yandex.div2.DivWrapContentSize;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivDataExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0012H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0013H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0016H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u0018H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001aH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0006H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\bH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\tH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\nH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u000bH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\fH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\rH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u000eH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u000fH\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0010H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0011H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0012H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0013H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0014H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0015H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0016H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0017H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0018H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u0019H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0005*\u0004\u0018\u00010\u001aH\u0000\u001a\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¨\u0006!"}, d2 = {"applyPatch", "Lcom/yandex/div2/DivData;", DivActionHandler.DivActionReason.PATCH, "Lcom/yandex/div2/DivPatch;", "equalsToConstant", "", "Lcom/yandex/div2/DivAbsoluteEdgeInsets;", "other", "Lcom/yandex/div2/DivBackground;", "Lcom/yandex/div2/DivBorder;", "Lcom/yandex/div2/DivCornersRadius;", "Lcom/yandex/div2/DivDimension;", "Lcom/yandex/div2/DivDrawable;", "Lcom/yandex/div2/DivEdgeInsets;", "Lcom/yandex/div2/DivFilter;", "Lcom/yandex/div2/DivFixedSize;", "Lcom/yandex/div2/DivInput$NativeInterface;", "Lcom/yandex/div2/DivLinearGradient$ColorPoint;", "Lcom/yandex/div2/DivPivot;", "Lcom/yandex/div2/DivPoint;", "Lcom/yandex/div2/DivRadialGradientCenter;", "Lcom/yandex/div2/DivRadialGradientRadius;", "Lcom/yandex/div2/DivShadow;", "Lcom/yandex/div2/DivShape;", "Lcom/yandex/div2/DivSize;", "Lcom/yandex/div2/DivStroke;", "Lcom/yandex/div2/DivTransform;", "isConstant", "toColormap", "Lcom/yandex/div/internal/graphics/Colormap;", "Lcom/yandex/div2/DivLinearGradient;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivDataExtensionsKt {
    public static final boolean equalsToConstant(DivSize divSize, DivSize divSize2) {
        if (divSize == null) {
            if (divSize2 == null) {
                return true;
            }
        } else if (divSize instanceof DivSize.Fixed) {
            if (divSize2 instanceof DivSize.Fixed) {
                DivSize.Fixed fixed = (DivSize.Fixed) divSize;
                DivSize.Fixed fixed2 = (DivSize.Fixed) divSize2;
                if (ExpressionsKt.equalsToConstant(fixed.getValue().value, fixed2.getValue().value) && ExpressionsKt.equalsToConstant(fixed.getValue().unit, fixed2.getValue().unit)) {
                    return true;
                }
            }
        } else if (divSize instanceof DivSize.MatchParent) {
            if ((divSize2 instanceof DivSize.MatchParent) && ExpressionsKt.equalsToConstant(((DivSize.MatchParent) divSize).getValue().weight, ((DivSize.MatchParent) divSize2).getValue().weight)) {
                return true;
            }
        } else {
            if (!(divSize instanceof DivSize.WrapContent)) {
                throw new NoWhenBranchMatchedException();
            }
            if (divSize2 instanceof DivSize.WrapContent) {
                DivSize.WrapContent wrapContent = (DivSize.WrapContent) divSize;
                DivSize.WrapContent wrapContent2 = (DivSize.WrapContent) divSize2;
                if (ExpressionsKt.equalsToConstant(wrapContent.getValue().constrained, wrapContent2.getValue().constrained)) {
                    DivWrapContentSize.ConstraintSize constraintSize = wrapContent.getValue().minSize;
                    Expression<Long> expression = constraintSize != null ? constraintSize.value : null;
                    DivWrapContentSize.ConstraintSize constraintSize2 = wrapContent2.getValue().minSize;
                    if (ExpressionsKt.equalsToConstant(expression, constraintSize2 != null ? constraintSize2.value : null)) {
                        DivWrapContentSize.ConstraintSize constraintSize3 = wrapContent.getValue().minSize;
                        Expression<DivSizeUnit> expression2 = constraintSize3 != null ? constraintSize3.unit : null;
                        DivWrapContentSize.ConstraintSize constraintSize4 = wrapContent2.getValue().minSize;
                        if (ExpressionsKt.equalsToConstant(expression2, constraintSize4 != null ? constraintSize4.unit : null)) {
                            DivWrapContentSize.ConstraintSize constraintSize5 = wrapContent.getValue().maxSize;
                            Expression<Long> expression3 = constraintSize5 != null ? constraintSize5.value : null;
                            DivWrapContentSize.ConstraintSize constraintSize6 = wrapContent2.getValue().maxSize;
                            if (ExpressionsKt.equalsToConstant(expression3, constraintSize6 != null ? constraintSize6.value : null)) {
                                DivWrapContentSize.ConstraintSize constraintSize7 = wrapContent.getValue().maxSize;
                                Expression<DivSizeUnit> expression4 = constraintSize7 != null ? constraintSize7.unit : null;
                                DivWrapContentSize.ConstraintSize constraintSize8 = wrapContent2.getValue().maxSize;
                                if (ExpressionsKt.equalsToConstant(expression4, constraintSize8 != null ? constraintSize8.unit : null)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivSize divSize) {
        if (divSize == null) {
            return true;
        }
        if (divSize instanceof DivSize.Fixed) {
            DivSize.Fixed fixed = (DivSize.Fixed) divSize;
            if (ExpressionsKt.isConstant(fixed.getValue().value) && ExpressionsKt.isConstant(fixed.getValue().unit)) {
                return true;
            }
        } else {
            if (divSize instanceof DivSize.MatchParent) {
                return ExpressionsKt.isConstantOrNull(((DivSize.MatchParent) divSize).getValue().weight);
            }
            if (!(divSize instanceof DivSize.WrapContent)) {
                throw new NoWhenBranchMatchedException();
            }
            DivSize.WrapContent wrapContent = (DivSize.WrapContent) divSize;
            if (ExpressionsKt.isConstantOrNull(wrapContent.getValue().constrained)) {
                DivWrapContentSize.ConstraintSize constraintSize = wrapContent.getValue().minSize;
                if (ExpressionsKt.isConstantOrNull(constraintSize != null ? constraintSize.value : null)) {
                    DivWrapContentSize.ConstraintSize constraintSize2 = wrapContent.getValue().minSize;
                    if (ExpressionsKt.isConstantOrNull(constraintSize2 != null ? constraintSize2.unit : null)) {
                        DivWrapContentSize.ConstraintSize constraintSize3 = wrapContent.getValue().maxSize;
                        if (ExpressionsKt.isConstantOrNull(constraintSize3 != null ? constraintSize3.value : null)) {
                            DivWrapContentSize.ConstraintSize constraintSize4 = wrapContent.getValue().maxSize;
                            if (ExpressionsKt.isConstantOrNull(constraintSize4 != null ? constraintSize4.unit : null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean equalsToConstant(DivFixedSize divFixedSize, DivFixedSize divFixedSize2) {
        if (divFixedSize == null && divFixedSize2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divFixedSize != null ? divFixedSize.value : null, divFixedSize2 != null ? divFixedSize2.value : null)) {
            if (ExpressionsKt.equalsToConstant(divFixedSize != null ? divFixedSize.unit : null, divFixedSize2 != null ? divFixedSize2.unit : null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivFixedSize divFixedSize) {
        if (divFixedSize == null) {
            return true;
        }
        return ExpressionsKt.isConstant(divFixedSize.value) && ExpressionsKt.isConstant(divFixedSize.unit);
    }

    public static final boolean equalsToConstant(DivEdgeInsets divEdgeInsets, DivEdgeInsets divEdgeInsets2) {
        if (divEdgeInsets == null && divEdgeInsets2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divEdgeInsets != null ? divEdgeInsets.left : null, divEdgeInsets2 != null ? divEdgeInsets2.left : null)) {
            if (ExpressionsKt.equalsToConstant(divEdgeInsets != null ? divEdgeInsets.top : null, divEdgeInsets2 != null ? divEdgeInsets2.top : null)) {
                if (ExpressionsKt.equalsToConstant(divEdgeInsets != null ? divEdgeInsets.right : null, divEdgeInsets2 != null ? divEdgeInsets2.right : null)) {
                    if (ExpressionsKt.equalsToConstant(divEdgeInsets != null ? divEdgeInsets.bottom : null, divEdgeInsets2 != null ? divEdgeInsets2.bottom : null)) {
                        if (ExpressionsKt.equalsToConstant(divEdgeInsets != null ? divEdgeInsets.start : null, divEdgeInsets2 != null ? divEdgeInsets2.start : null)) {
                            if (ExpressionsKt.equalsToConstant(divEdgeInsets != null ? divEdgeInsets.end : null, divEdgeInsets2 != null ? divEdgeInsets2.end : null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivEdgeInsets divEdgeInsets) {
        if (divEdgeInsets == null) {
            return true;
        }
        return ExpressionsKt.isConstant(divEdgeInsets.left) && ExpressionsKt.isConstant(divEdgeInsets.top) && ExpressionsKt.isConstant(divEdgeInsets.right) && ExpressionsKt.isConstant(divEdgeInsets.bottom) && ExpressionsKt.isConstantOrNull(divEdgeInsets.start) && ExpressionsKt.isConstantOrNull(divEdgeInsets.end);
    }

    public static final boolean equalsToConstant(DivAbsoluteEdgeInsets divAbsoluteEdgeInsets, DivAbsoluteEdgeInsets divAbsoluteEdgeInsets2) {
        if (divAbsoluteEdgeInsets == null && divAbsoluteEdgeInsets2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divAbsoluteEdgeInsets != null ? divAbsoluteEdgeInsets.left : null, divAbsoluteEdgeInsets2 != null ? divAbsoluteEdgeInsets2.left : null)) {
            if (ExpressionsKt.equalsToConstant(divAbsoluteEdgeInsets != null ? divAbsoluteEdgeInsets.top : null, divAbsoluteEdgeInsets2 != null ? divAbsoluteEdgeInsets2.top : null)) {
                if (ExpressionsKt.equalsToConstant(divAbsoluteEdgeInsets != null ? divAbsoluteEdgeInsets.right : null, divAbsoluteEdgeInsets2 != null ? divAbsoluteEdgeInsets2.right : null)) {
                    if (ExpressionsKt.equalsToConstant(divAbsoluteEdgeInsets != null ? divAbsoluteEdgeInsets.bottom : null, divAbsoluteEdgeInsets2 != null ? divAbsoluteEdgeInsets2.bottom : null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivAbsoluteEdgeInsets divAbsoluteEdgeInsets) {
        if (divAbsoluteEdgeInsets == null) {
            return true;
        }
        return ExpressionsKt.isConstant(divAbsoluteEdgeInsets.left) && ExpressionsKt.isConstant(divAbsoluteEdgeInsets.top) && ExpressionsKt.isConstant(divAbsoluteEdgeInsets.right) && ExpressionsKt.isConstant(divAbsoluteEdgeInsets.bottom);
    }

    public static final boolean equalsToConstant(DivTransform divTransform, DivTransform divTransform2) {
        if (divTransform == null && divTransform2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divTransform != null ? divTransform.rotation : null, divTransform2 != null ? divTransform2.rotation : null)) {
            if (equalsToConstant(divTransform != null ? divTransform.pivotX : null, divTransform2 != null ? divTransform2.pivotX : null)) {
                if (equalsToConstant(divTransform != null ? divTransform.pivotY : null, divTransform2 != null ? divTransform2.pivotY : null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivTransform divTransform) {
        if (divTransform == null) {
            return true;
        }
        return ExpressionsKt.isConstantOrNull(divTransform.rotation) && isConstant(divTransform.pivotX) && isConstant(divTransform.pivotY);
    }

    public static final boolean equalsToConstant(DivPivot divPivot, DivPivot divPivot2) {
        if (divPivot == null) {
            if (divPivot2 == null) {
                return true;
            }
        } else if (divPivot instanceof DivPivot.Fixed) {
            if (divPivot2 instanceof DivPivot.Fixed) {
                DivPivot.Fixed fixed = (DivPivot.Fixed) divPivot;
                DivPivot.Fixed fixed2 = (DivPivot.Fixed) divPivot2;
                if (ExpressionsKt.equalsToConstant(fixed.getValue().value, fixed2.getValue().value) && ExpressionsKt.equalsToConstant(fixed.getValue().unit, fixed2.getValue().unit)) {
                    return true;
                }
            }
        } else {
            if (!(divPivot instanceof DivPivot.Percentage)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((divPivot2 instanceof DivPivot.Percentage) && ExpressionsKt.equalsToConstant(((DivPivot.Percentage) divPivot).getValue().value, ((DivPivot.Percentage) divPivot2).getValue().value)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivPivot divPivot) {
        if (divPivot == null) {
            return true;
        }
        if (divPivot instanceof DivPivot.Fixed) {
            DivPivot.Fixed fixed = (DivPivot.Fixed) divPivot;
            return ExpressionsKt.isConstantOrNull(fixed.getValue().value) && ExpressionsKt.isConstantOrNull(fixed.getValue().value);
        }
        if (divPivot instanceof DivPivot.Percentage) {
            return ExpressionsKt.isConstant(((DivPivot.Percentage) divPivot).getValue().value);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean equalsToConstant(DivFilter divFilter, DivFilter divFilter2) {
        if (divFilter == null) {
            if (divFilter2 == null) {
                return true;
            }
        } else {
            if (divFilter instanceof DivFilter.RtlMirror) {
                return divFilter2 instanceof DivFilter.RtlMirror;
            }
            if (!(divFilter instanceof DivFilter.Blur)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((divFilter2 instanceof DivFilter.Blur) && ExpressionsKt.equalsToConstant(((DivFilter.Blur) divFilter).getValue().radius, ((DivFilter.Blur) divFilter2).getValue().radius)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivFilter divFilter) {
        if (divFilter == null || (divFilter instanceof DivFilter.RtlMirror)) {
            return true;
        }
        if (divFilter instanceof DivFilter.Blur) {
            return ExpressionsKt.isConstant(((DivFilter.Blur) divFilter).getValue().radius);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean equalsToConstant(DivDrawable divDrawable, DivDrawable divDrawable2) {
        if (divDrawable == null) {
            if (divDrawable2 == null) {
                return true;
            }
        } else {
            if (!(divDrawable instanceof DivDrawable.Shape)) {
                throw new NoWhenBranchMatchedException();
            }
            if (divDrawable2 instanceof DivDrawable.Shape) {
                DivDrawable.Shape shape = (DivDrawable.Shape) divDrawable;
                DivDrawable.Shape shape2 = (DivDrawable.Shape) divDrawable2;
                if (ExpressionsKt.equalsToConstant(shape.getValue().color, shape2.getValue().color) && equalsToConstant(shape.getValue().shape, shape2.getValue().shape) && equalsToConstant(shape.getValue().stroke, shape2.getValue().stroke)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivDrawable divDrawable) {
        if (divDrawable == null) {
            return true;
        }
        if (!(divDrawable instanceof DivDrawable.Shape)) {
            throw new NoWhenBranchMatchedException();
        }
        DivDrawable.Shape shape = (DivDrawable.Shape) divDrawable;
        return ExpressionsKt.isConstant(shape.getValue().color) && isConstant(shape.getValue().shape) && isConstant(shape.getValue().stroke);
    }

    public static final boolean equalsToConstant(DivShape divShape, DivShape divShape2) {
        if (divShape == null) {
            if (divShape2 == null) {
                return true;
            }
        } else if (divShape instanceof DivShape.RoundedRectangle) {
            if (divShape2 instanceof DivShape.RoundedRectangle) {
                DivShape.RoundedRectangle roundedRectangle = (DivShape.RoundedRectangle) divShape;
                DivShape.RoundedRectangle roundedRectangle2 = (DivShape.RoundedRectangle) divShape2;
                if (ExpressionsKt.equalsToConstant(roundedRectangle.getValue().backgroundColor, roundedRectangle2.getValue().backgroundColor) && equalsToConstant(roundedRectangle.getValue().stroke, roundedRectangle2.getValue().stroke) && equalsToConstant(roundedRectangle.getValue().itemWidth, roundedRectangle2.getValue().itemWidth) && equalsToConstant(roundedRectangle.getValue().itemHeight, roundedRectangle2.getValue().itemHeight) && equalsToConstant(roundedRectangle.getValue().cornerRadius, roundedRectangle2.getValue().cornerRadius)) {
                    return true;
                }
            }
        } else {
            if (!(divShape instanceof DivShape.Circle)) {
                throw new NoWhenBranchMatchedException();
            }
            if (divShape2 instanceof DivShape.Circle) {
                DivShape.Circle circle = (DivShape.Circle) divShape;
                DivShape.Circle circle2 = (DivShape.Circle) divShape2;
                if (ExpressionsKt.equalsToConstant(circle.getValue().backgroundColor, circle2.getValue().backgroundColor) && equalsToConstant(circle.getValue().stroke, circle2.getValue().stroke) && equalsToConstant(circle.getValue().radius, circle2.getValue().radius)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivShape divShape) {
        DivStroke divStroke;
        if (divShape == null) {
            return true;
        }
        if (divShape instanceof DivShape.RoundedRectangle) {
            DivShape.RoundedRectangle roundedRectangle = (DivShape.RoundedRectangle) divShape;
            if (ExpressionsKt.isConstantOrNull(roundedRectangle.getValue().backgroundColor) && isConstant(roundedRectangle.getValue().stroke) && isConstant(roundedRectangle.getValue().itemWidth) && isConstant(roundedRectangle.getValue().itemHeight) && isConstant(roundedRectangle.getValue().cornerRadius)) {
                return true;
            }
        } else {
            if (!(divShape instanceof DivShape.Circle)) {
                throw new NoWhenBranchMatchedException();
            }
            DivShape.Circle circle = (DivShape.Circle) divShape;
            if (ExpressionsKt.isConstantOrNull(circle.getValue().backgroundColor) && (((divStroke = circle.getValue().stroke) == null || isConstant(divStroke)) && isConstant(circle.getValue().radius))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean equalsToConstant(DivStroke divStroke, DivStroke divStroke2) {
        if (divStroke == null && divStroke2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divStroke != null ? divStroke.color : null, divStroke2 != null ? divStroke2.color : null)) {
            if (ExpressionsKt.equalsToConstant(divStroke != null ? divStroke.width : null, divStroke2 != null ? divStroke2.width : null)) {
                if (ExpressionsKt.equalsToConstant(divStroke != null ? divStroke.unit : null, divStroke2 != null ? divStroke2.unit : null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivStroke divStroke) {
        if (divStroke == null) {
            return true;
        }
        return ExpressionsKt.isConstant(divStroke.color) && ExpressionsKt.isConstant(divStroke.width) && ExpressionsKt.isConstant(divStroke.unit);
    }

    public static final boolean equalsToConstant(DivBorder divBorder, DivBorder divBorder2) {
        if (divBorder == null && divBorder2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divBorder != null ? divBorder.cornerRadius : null, divBorder2 != null ? divBorder2.cornerRadius : null)) {
            if (equalsToConstant(divBorder != null ? divBorder.cornersRadius : null, divBorder2 != null ? divBorder2.cornersRadius : null)) {
                if (ExpressionsKt.equalsToConstant(divBorder != null ? divBorder.hasShadow : null, divBorder2 != null ? divBorder2.hasShadow : null)) {
                    if (equalsToConstant(divBorder != null ? divBorder.shadow : null, divBorder2 != null ? divBorder2.shadow : null)) {
                        if (equalsToConstant(divBorder != null ? divBorder.stroke : null, divBorder2 != null ? divBorder2.stroke : null)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivBorder divBorder) {
        if (divBorder == null) {
            return true;
        }
        return ExpressionsKt.isConstantOrNull(divBorder.cornerRadius) && isConstant(divBorder.cornersRadius) && ExpressionsKt.isConstant(divBorder.hasShadow) && isConstant(divBorder.shadow) && isConstant(divBorder.stroke);
    }

    public static final boolean equalsToConstant(DivCornersRadius divCornersRadius, DivCornersRadius divCornersRadius2) {
        if (divCornersRadius == null && divCornersRadius2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divCornersRadius != null ? divCornersRadius.topLeft : null, divCornersRadius2 != null ? divCornersRadius2.topLeft : null)) {
            if (ExpressionsKt.equalsToConstant(divCornersRadius != null ? divCornersRadius.topRight : null, divCornersRadius2 != null ? divCornersRadius2.topRight : null)) {
                if (ExpressionsKt.equalsToConstant(divCornersRadius != null ? divCornersRadius.bottomRight : null, divCornersRadius2 != null ? divCornersRadius2.bottomRight : null)) {
                    if (ExpressionsKt.equalsToConstant(divCornersRadius != null ? divCornersRadius.bottomLeft : null, divCornersRadius2 != null ? divCornersRadius2.bottomLeft : null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivCornersRadius divCornersRadius) {
        if (divCornersRadius == null) {
            return true;
        }
        return ExpressionsKt.isConstantOrNull(divCornersRadius.topLeft) && ExpressionsKt.isConstantOrNull(divCornersRadius.topRight) && ExpressionsKt.isConstantOrNull(divCornersRadius.bottomRight) && ExpressionsKt.isConstantOrNull(divCornersRadius.bottomLeft);
    }

    public static final boolean equalsToConstant(DivShadow divShadow, DivShadow divShadow2) {
        if (divShadow == null && divShadow2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divShadow != null ? divShadow.alpha : null, divShadow2 != null ? divShadow2.alpha : null)) {
            if (ExpressionsKt.equalsToConstant(divShadow != null ? divShadow.blur : null, divShadow2 != null ? divShadow2.blur : null)) {
                if (ExpressionsKt.equalsToConstant(divShadow != null ? divShadow.color : null, divShadow2 != null ? divShadow2.color : null)) {
                    if (equalsToConstant(divShadow != null ? divShadow.offset : null, divShadow2 != null ? divShadow2.offset : null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isConstant(DivShadow divShadow) {
        if (divShadow == null) {
            return true;
        }
        return ExpressionsKt.isConstant(divShadow.alpha) && ExpressionsKt.isConstant(divShadow.blur) && ExpressionsKt.isConstant(divShadow.color) && isConstant(divShadow.offset);
    }

    public static final boolean equalsToConstant(DivPoint divPoint, DivPoint divPoint2) {
        if (divPoint == null && divPoint2 == null) {
            return true;
        }
        if (equalsToConstant(divPoint != null ? divPoint.x : null, divPoint2 != null ? divPoint2.x : null)) {
            if (equalsToConstant(divPoint != null ? divPoint.y : null, divPoint2 != null ? divPoint2.y : null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivPoint divPoint) {
        if (divPoint == null) {
            return true;
        }
        return isConstant(divPoint.x) && isConstant(divPoint.y);
    }

    public static final boolean equalsToConstant(DivDimension divDimension, DivDimension divDimension2) {
        if (divDimension == null && divDimension2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(divDimension != null ? divDimension.unit : null, divDimension2 != null ? divDimension2.unit : null)) {
            if (ExpressionsKt.equalsToConstant(divDimension != null ? divDimension.value : null, divDimension2 != null ? divDimension2.value : null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivDimension divDimension) {
        if (divDimension == null) {
            return true;
        }
        return ExpressionsKt.isConstant(divDimension.unit) && ExpressionsKt.isConstant(divDimension.value);
    }

    public static final boolean equalsToConstant(DivBackground divBackground, DivBackground divBackground2) {
        if (divBackground == null) {
            if (divBackground2 == null) {
                return true;
            }
        } else if (divBackground instanceof DivBackground.Solid) {
            if ((divBackground2 instanceof DivBackground.Solid) && ExpressionsKt.equalsToConstant(((DivBackground.Solid) divBackground).getValue().color, ((DivBackground.Solid) divBackground2).getValue().color)) {
                return true;
            }
        } else if (divBackground instanceof DivBackground.Image) {
            DivBackground.Image image = (DivBackground.Image) divBackground;
            List<DivFilter> listEmptyList = image.getValue().filters;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (divBackground2 instanceof DivBackground.Image) {
                DivBackground.Image image2 = (DivBackground.Image) divBackground2;
                if (ExpressionsKt.equalsToConstant(image.getValue().alpha, image2.getValue().alpha) && ExpressionsKt.equalsToConstant(image.getValue().contentAlignmentHorizontal, image2.getValue().contentAlignmentHorizontal) && ExpressionsKt.equalsToConstant(image.getValue().contentAlignmentVertical, image2.getValue().contentAlignmentVertical)) {
                    List<DivFilter> listEmptyList2 = image2.getValue().filters;
                    if (listEmptyList2 == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    if (listEmptyList.size() == listEmptyList2.size()) {
                        int i = 0;
                        for (Object obj : listEmptyList) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (equalsToConstant((DivFilter) obj, listEmptyList2.get(i))) {
                                i = i2;
                            }
                        }
                        if (ExpressionsKt.equalsToConstant(image.getValue().imageUrl, image2.getValue().imageUrl) && ExpressionsKt.equalsToConstant(image.getValue().preloadRequired, image2.getValue().preloadRequired) && ExpressionsKt.equalsToConstant(image.getValue().scale, image2.getValue().scale)) {
                            return true;
                        }
                    }
                }
            }
        } else if (divBackground instanceof DivBackground.LinearGradient) {
            DivBackground.LinearGradient linearGradient = (DivBackground.LinearGradient) divBackground;
            List<DivLinearGradient.ColorPoint> listEmptyList3 = linearGradient.getValue().colorMap;
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            if (divBackground2 instanceof DivBackground.LinearGradient) {
                DivBackground.LinearGradient linearGradient2 = (DivBackground.LinearGradient) divBackground2;
                if (ExpressionsKt.equalsToConstant(linearGradient.getValue().angle, linearGradient2.getValue().angle) && ExpressionsKt.equalsToConstant(linearGradient.getValue().colors, linearGradient2.getValue().colors)) {
                    List<DivLinearGradient.ColorPoint> listEmptyList4 = linearGradient2.getValue().colorMap;
                    if (listEmptyList4 == null) {
                        listEmptyList4 = CollectionsKt.emptyList();
                    }
                    if (listEmptyList3.size() == listEmptyList4.size()) {
                        int i3 = 0;
                        for (Object obj2 : listEmptyList3) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (equalsToConstant((DivLinearGradient.ColorPoint) obj2, listEmptyList4.get(i3))) {
                                i3 = i4;
                            }
                        }
                        return true;
                    }
                }
            }
        } else if (divBackground instanceof DivBackground.RadialGradient) {
            if (divBackground2 instanceof DivBackground.RadialGradient) {
                DivBackground.RadialGradient radialGradient = (DivBackground.RadialGradient) divBackground;
                DivBackground.RadialGradient radialGradient2 = (DivBackground.RadialGradient) divBackground2;
                if (equalsToConstant(radialGradient.getValue().centerX, radialGradient2.getValue().centerX) && equalsToConstant(radialGradient.getValue().centerY, radialGradient2.getValue().centerY) && ExpressionsKt.equalsToConstant(radialGradient.getValue().colors, radialGradient2.getValue().colors) && equalsToConstant(radialGradient.getValue().radius, radialGradient2.getValue().radius)) {
                    return true;
                }
            }
        } else {
            if (!(divBackground instanceof DivBackground.NinePatch)) {
                throw new NoWhenBranchMatchedException();
            }
            if (divBackground2 instanceof DivBackground.NinePatch) {
                DivBackground.NinePatch ninePatch = (DivBackground.NinePatch) divBackground;
                DivBackground.NinePatch ninePatch2 = (DivBackground.NinePatch) divBackground2;
                if (ExpressionsKt.equalsToConstant(ninePatch.getValue().imageUrl, ninePatch2.getValue().imageUrl) && equalsToConstant(ninePatch.getValue().insets, ninePatch2.getValue().insets)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    public static final boolean isConstant(DivBackground divBackground) {
        if (divBackground == null) {
            return true;
        }
        if (divBackground instanceof DivBackground.Solid) {
            return ExpressionsKt.isConstant(((DivBackground.Solid) divBackground).getValue().color);
        }
        if (divBackground instanceof DivBackground.Image) {
            DivBackground.Image image = (DivBackground.Image) divBackground;
            if (ExpressionsKt.isConstant(image.getValue().alpha) && ExpressionsKt.isConstant(image.getValue().contentAlignmentHorizontal) && ExpressionsKt.isConstant(image.getValue().contentAlignmentVertical)) {
                List<DivFilter> list = image.getValue().filters;
                if (list == null) {
                    if (ExpressionsKt.isConstant(image.getValue().imageUrl)) {
                        return true;
                    }
                } else {
                    List<DivFilter> list2 = list;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        if (ExpressionsKt.isConstant(image.getValue().imageUrl)) {
                            return true;
                        }
                    } else {
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            if (!isConstant((DivFilter) it.next())) {
                            }
                        }
                        if (ExpressionsKt.isConstant(image.getValue().imageUrl) && ExpressionsKt.isConstant(image.getValue().preloadRequired) && ExpressionsKt.isConstant(image.getValue().scale)) {
                            return true;
                        }
                    }
                }
            }
        } else if (divBackground instanceof DivBackground.LinearGradient) {
            DivBackground.LinearGradient linearGradient = (DivBackground.LinearGradient) divBackground;
            if (ExpressionsKt.isConstant(linearGradient.getValue().angle) && ExpressionsKt.isConstantOrNull(linearGradient.getValue().colors)) {
                return true;
            }
        } else if (divBackground instanceof DivBackground.RadialGradient) {
            DivBackground.RadialGradient radialGradient = (DivBackground.RadialGradient) divBackground;
            if (isConstant(radialGradient.getValue().centerX) && isConstant(radialGradient.getValue().centerY) && ExpressionsKt.isConstant(radialGradient.getValue().colors) && isConstant(radialGradient.getValue().radius)) {
                return true;
            }
        } else {
            if (!(divBackground instanceof DivBackground.NinePatch)) {
                throw new NoWhenBranchMatchedException();
            }
            DivBackground.NinePatch ninePatch = (DivBackground.NinePatch) divBackground;
            if (ExpressionsKt.isConstant(ninePatch.getValue().imageUrl) && isConstant(ninePatch.getValue().insets)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean equalsToConstant(DivLinearGradient.ColorPoint colorPoint, DivLinearGradient.ColorPoint colorPoint2) {
        if (colorPoint == null && colorPoint2 == null) {
            return true;
        }
        if (ExpressionsKt.equalsToConstant(colorPoint != null ? colorPoint.color : null, colorPoint2 != null ? colorPoint2.color : null)) {
            if (ExpressionsKt.equalsToConstant(colorPoint != null ? colorPoint.position : null, colorPoint2 != null ? colorPoint2.position : null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivLinearGradient.ColorPoint colorPoint) {
        if (colorPoint == null) {
            return true;
        }
        return ExpressionsKt.isConstant(colorPoint.color) && ExpressionsKt.isConstant(colorPoint.position);
    }

    public static final Colormap toColormap(DivLinearGradient divLinearGradient, final ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(divLinearGradient, "<this>");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        List<DivLinearGradient.ColorPoint> list = divLinearGradient.colorMap;
        List listSortedWith = list != null ? CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yandex.div.core.util.DivDataExtensionsKt$toColormap$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((DivLinearGradient.ColorPoint) t).position.evaluate(resolver), ((DivLinearGradient.ColorPoint) t2).position.evaluate(resolver));
            }
        }) : null;
        ExpressionList<Integer> expressionList = divLinearGradient.colors;
        if (listSortedWith == null) {
            if (expressionList != null) {
                return new Colormap(CollectionsKt.toIntArray(expressionList.evaluate(resolver)), null, 2, null);
            }
            return Colormap.EMPTY;
        }
        int[] iArr = new int[listSortedWith.size()];
        float[] fArr = new float[listSortedWith.size()];
        int size = listSortedWith.size();
        for (int i = 0; i < size; i++) {
            iArr[i] = ((DivLinearGradient.ColorPoint) listSortedWith.get(i)).color.evaluate(resolver).intValue();
            fArr[i] = (float) ((DivLinearGradient.ColorPoint) listSortedWith.get(i)).position.evaluate(resolver).doubleValue();
        }
        return new Colormap(iArr, fArr);
    }

    public static final boolean equalsToConstant(DivRadialGradientCenter divRadialGradientCenter, DivRadialGradientCenter divRadialGradientCenter2) {
        if (divRadialGradientCenter == null) {
            if (divRadialGradientCenter2 == null) {
                return true;
            }
        } else if (divRadialGradientCenter instanceof DivRadialGradientCenter.Fixed) {
            if (divRadialGradientCenter2 instanceof DivRadialGradientCenter.Fixed) {
                DivRadialGradientCenter.Fixed fixed = (DivRadialGradientCenter.Fixed) divRadialGradientCenter;
                DivRadialGradientCenter.Fixed fixed2 = (DivRadialGradientCenter.Fixed) divRadialGradientCenter2;
                if (ExpressionsKt.equalsToConstant(fixed.getValue().unit, fixed2.getValue().unit) && ExpressionsKt.equalsToConstant(fixed.getValue().value, fixed2.getValue().value)) {
                    return true;
                }
            }
        } else {
            if (!(divRadialGradientCenter instanceof DivRadialGradientCenter.Relative)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((divRadialGradientCenter2 instanceof DivRadialGradientCenter.Relative) && ExpressionsKt.equalsToConstant(((DivRadialGradientCenter.Relative) divRadialGradientCenter).getValue().value, ((DivRadialGradientCenter.Relative) divRadialGradientCenter2).getValue().value)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivRadialGradientCenter divRadialGradientCenter) {
        if (divRadialGradientCenter == null) {
            return true;
        }
        if (divRadialGradientCenter instanceof DivRadialGradientCenter.Fixed) {
            DivRadialGradientCenter.Fixed fixed = (DivRadialGradientCenter.Fixed) divRadialGradientCenter;
            return ExpressionsKt.isConstant(fixed.getValue().unit) && ExpressionsKt.isConstant(fixed.getValue().value);
        }
        if (divRadialGradientCenter instanceof DivRadialGradientCenter.Relative) {
            return ExpressionsKt.isConstant(((DivRadialGradientCenter.Relative) divRadialGradientCenter).getValue().value);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean equalsToConstant(DivRadialGradientRadius divRadialGradientRadius, DivRadialGradientRadius divRadialGradientRadius2) {
        if (divRadialGradientRadius == null) {
            if (divRadialGradientRadius2 == null) {
                return true;
            }
        } else if (divRadialGradientRadius instanceof DivRadialGradientRadius.FixedSize) {
            if (divRadialGradientRadius2 instanceof DivRadialGradientRadius.FixedSize) {
                DivRadialGradientRadius.FixedSize fixedSize = (DivRadialGradientRadius.FixedSize) divRadialGradientRadius;
                DivRadialGradientRadius.FixedSize fixedSize2 = (DivRadialGradientRadius.FixedSize) divRadialGradientRadius2;
                if (ExpressionsKt.equalsToConstant(fixedSize.getValue().unit, fixedSize2.getValue().unit) && ExpressionsKt.equalsToConstant(fixedSize.getValue().value, fixedSize2.getValue().value)) {
                    return true;
                }
            }
        } else {
            if (!(divRadialGradientRadius instanceof DivRadialGradientRadius.Relative)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((divRadialGradientRadius2 instanceof DivRadialGradientRadius.Relative) && ExpressionsKt.equalsToConstant(((DivRadialGradientRadius.Relative) divRadialGradientRadius).getValue().value, ((DivRadialGradientRadius.Relative) divRadialGradientRadius2).getValue().value)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isConstant(DivRadialGradientRadius divRadialGradientRadius) {
        if (divRadialGradientRadius == null) {
            return true;
        }
        if (divRadialGradientRadius instanceof DivRadialGradientRadius.FixedSize) {
            DivRadialGradientRadius.FixedSize fixedSize = (DivRadialGradientRadius.FixedSize) divRadialGradientRadius;
            return ExpressionsKt.isConstant(fixedSize.getValue().unit) && ExpressionsKt.isConstant(fixedSize.getValue().value);
        }
        if (divRadialGradientRadius instanceof DivRadialGradientRadius.Relative) {
            return ExpressionsKt.isConstant(((DivRadialGradientRadius.Relative) divRadialGradientRadius).getValue().value);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean equalsToConstant(DivInput.NativeInterface nativeInterface, DivInput.NativeInterface nativeInterface2) {
        if (nativeInterface == null && nativeInterface2 == null) {
            return true;
        }
        return ExpressionsKt.equalsToConstant(nativeInterface != null ? nativeInterface.color : null, nativeInterface2 != null ? nativeInterface2.color : null);
    }

    public static final boolean isConstant(DivInput.NativeInterface nativeInterface) {
        if (nativeInterface == null) {
            return true;
        }
        return ExpressionsKt.isConstant(nativeInterface.color);
    }

    public static final DivData applyPatch(DivData divData, DivPatch patch) {
        Intrinsics.checkNotNullParameter(divData, "<this>");
        Intrinsics.checkNotNullParameter(patch, "patch");
        List<DivData.State> listApplyPatch = new DivPatchApply(new DivPatchMap(patch)).applyPatch(divData.states, ExpressionResolver.EMPTY);
        if (listApplyPatch == null) {
            return null;
        }
        return new DivData(null, divData.logId, listApplyPatch, divData.timers, divData.transitionAnimationSelector, divData.variableTriggers, divData.variables, divData.parsingErrors, 1, null);
    }
}
