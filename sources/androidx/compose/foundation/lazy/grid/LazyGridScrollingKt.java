package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LazyGridScrolling.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a\u0017\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\b\u001a-\u0010\u0011\u001a\u00020\r*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "TargetDistance", "calculateLineAverageMainAxisSize", "", "visibleItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "isVertical", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "doSmoothScrollToItem", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "index", "scrollOffset", "slotsPerLine", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridScrollingKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m3843constructorimpl(2500);
    private static final float BoundDistance = Dp.m3843constructorimpl(1500);

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridItemInfo doSmoothScrollToItem$getTargetItem(LazyGridState lazyGridState, int i) {
        LazyGridItemInfo lazyGridItemInfo;
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridState.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        for (int i2 = 0; i2 < size; i2++) {
            lazyGridItemInfo = visibleItemsInfo.get(i2);
            if (lazyGridItemInfo.getIndex() == i) {
                return lazyGridItemInfo;
            }
        }
        lazyGridItemInfo = null;
        return lazyGridItemInfo;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$doSmoothScrollToItem$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridScrolling.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$doSmoothScrollToItem$3", f = "LazyGridScrolling.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {128, Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", ToolBar.FORWARD}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "I$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ int $slotsPerLine;
        final /* synthetic */ LazyGridState $this_doSmoothScrollToItem;
        float F$0;
        float F$1;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LazyGridState lazyGridState, int i, int i2, int i3, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$this_doSmoothScrollToItem = lazyGridState;
            this.$index = i;
            this.$slotsPerLine = i2;
            this.$scrollOffset = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_doSmoothScrollToItem, this.$index, this.$slotsPerLine, this.$scrollOffset, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00ac A[Catch: ItemFoundInScroll -> 0x01ba, TryCatch #2 {ItemFoundInScroll -> 0x01ba, blocks: (B:55:0x01af, B:21:0x00a8, B:23:0x00ac, B:25:0x00b8, B:29:0x00d3, B:33:0x00e5, B:39:0x0108, B:43:0x0148, B:47:0x0151), top: B:77:0x01af }] */
        /* JADX WARN: Code duplicated, block: B:27:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:31:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:32:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:36:0x0102 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:37:0x0104  */
        /* JADX WARN: Code duplicated, block: B:41:0x0143  */
        /* JADX WARN: Code duplicated, block: B:42:0x0146  */
        /* JADX WARN: Code duplicated, block: B:45:0x014c  */
        /* JADX WARN: Code duplicated, block: B:46:0x014f  */
        /* JADX WARN: Code duplicated, block: B:53:0x01a5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x01a6  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r5v10, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v7 */
        /* JADX WARN: Type inference failed for: r8v8, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01a6 -> B:77:0x01af). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r45) {
            /*
                Method dump skipped, instruction units count: 576
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z, LazyGridState lazyGridState, int i, int i2) {
            if (z) {
                if (lazyGridState.getFirstVisibleItemIndex() <= i && (lazyGridState.getFirstVisibleItemIndex() != i || lazyGridState.getFirstVisibleItemScrollOffset() <= i2)) {
                    return false;
                }
            } else if (lazyGridState.getFirstVisibleItemIndex() >= i && (lazyGridState.getFirstVisibleItemIndex() != i || lazyGridState.getFirstVisibleItemScrollOffset() >= i2)) {
                return false;
            }
            return true;
        }
    }

    public static final Object doSmoothScrollToItem(LazyGridState lazyGridState, int i, int i2, int i3, Continuation<? super Unit> continuation) {
        if (i < 0.0f) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
        }
        Object objScroll$default = ScrollableState.scroll$default(lazyGridState, null, new AnonymousClass3(lazyGridState, i, i3, i2, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateLineAverageMainAxisSize(final List<? extends LazyGridItemInfo> list, final boolean z) {
        int iM4003getWidthimpl;
        Function1<Integer, Integer> function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridScrollingKt$calculateLineAverageMainAxisSize$lineOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int i) {
                return Integer.valueOf(z ? list.get(i).getRow() : list.get(i).getColumn());
            }
        };
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < list.size()) {
            int iIntValue = function1.invoke(Integer.valueOf(i)).intValue();
            if (iIntValue == -1) {
                i++;
            } else {
                int iMax = 0;
                while (i < list.size() && function1.invoke(Integer.valueOf(i)).intValue() == iIntValue) {
                    if (z) {
                        iM4003getWidthimpl = IntSize.m4002getHeightimpl(list.get(i).getSize());
                    } else {
                        iM4003getWidthimpl = IntSize.m4003getWidthimpl(list.get(i).getSize());
                    }
                    iMax = Math.max(iMax, iM4003getWidthimpl);
                    i++;
                }
                i2 += iMax;
                i3++;
            }
        }
        return i2 / i3;
    }
}
