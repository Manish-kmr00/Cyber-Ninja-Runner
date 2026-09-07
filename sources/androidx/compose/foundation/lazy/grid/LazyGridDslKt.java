package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001aE\u0010!\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010%\u001aE\u0010&\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\"¢\u0006\u0002\b\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003ø\u0001\u0000¢\u0006\u0002\u0010'\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u00107\u001aá\u0001\u0010(\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2%\b\n\u0010+\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\u001420\b\n\u00100\u001a*\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010\"¢\u0006\u0002\b\u00162%\b\n\u00103\u001a\u001f\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\u001423\b\u0004\u00104\u001a-\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u00108\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0*2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010<\u001aµ\u0002\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010)*\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H)0\u001c2:\b\n\u0010+\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010\"2E\b\n\u00100\u001a?\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u000202\u0018\u00010;¢\u0006\u0002\b\u00162:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010/0\"2H\b\u0004\u00104\u001aB\u0012\u0004\u0012\u000205\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(:\u0012\u0013\u0012\u0011H)¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\b6¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010=\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006>"}, d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", FirebaseAnalytics.Param.ITEMS, "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridDslKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:103:0x012d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0131  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:108:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:115:0x0160  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0198 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x019a  */
    /* JADX WARN: Code duplicated, block: B:132:0x019f  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:147:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:153:0x01df  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:160:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:166:0x026c  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:91:0x0109  */
    /* JADX WARN: Code duplicated, block: B:92:0x0110  */
    /* JADX WARN: Code duplicated, block: B:94:0x0116  */
    /* JADX WARN: Code duplicated, block: B:96:0x011c  */
    /* JADX WARN: Code duplicated, block: B:97:0x011f  */
    public static final void LazyVerticalGrid(final GridCells columns, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyGridScope, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        Arrangement.Horizontal horizontal2;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier.Companion companion;
        LazyGridState lazyGridStateRememberLazyGridState;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        boolean z4;
        Arrangement.Vertical bottom;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior2;
        boolean z5;
        boolean z6;
        PaddingValues paddingValues3;
        Arrangement.Vertical vertical3;
        Arrangement.Horizontal horizontal3;
        FlingBehavior flingBehavior3;
        Arrangement arrangement;
        final Modifier modifier2;
        final LazyGridState lazyGridState2;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        final Arrangement.Horizontal horizontal4;
        final boolean z8;
        final Arrangement.Vertical vertical4;
        final PaddingValues paddingValues4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)65@3041L23,71@3401L15,75@3523L71,76@3599L431:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(columns) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                i3 |= ((i2 & 4) == 0 || !composerStartRestartGroup.changed(lazyGridState)) ? 128 : 256;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            vertical2 = vertical;
                            int i14 = composerStartRestartGroup.changed(vertical2) ? 131072 : 65536;
                            i3 |= i14;
                        } else {
                            vertical2 = vertical;
                        }
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        horizontal2 = horizontal;
                    } else {
                        horizontal2 = horizontal;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(horizontal2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        if ((i & 1879048192) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 536870912;
                            } else {
                                i12 = 268435456;
                            }
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i2 & 4) != 0) {
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyGridStateRememberLazyGridState = lazyGridState;
                                }
                                if (i4 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                z4 = i6 == 0 ? z3 : false;
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getBottom();
                                    } else {
                                        bottom = arrangement.getTop();
                                    }
                                    i3 &= -458753;
                                } else {
                                    bottom = vertical2;
                                }
                                if (i8 != 0) {
                                    start = Arrangement.INSTANCE.getStart();
                                } else {
                                    start = horizontal2;
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i10 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                z6 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior3 = flingBehavior2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                companion = modifier;
                                lazyGridStateRememberLazyGridState = lazyGridState;
                                flingBehavior3 = flingBehavior;
                                z5 = z2;
                                paddingValues3 = paddingValues2;
                                z6 = z3;
                                vertical3 = vertical2;
                                horizontal3 = horizontal2;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i15 = i3 >> 3;
                            Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i15 & 896));
                            int i16 = (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i15 & 112) | (i3 & 7168) | (57344 & i3) | (i15 & 3670016) | (i15 & 29360128);
                            int i17 = i3 << 9;
                            int i18 = i16 | (i17 & 234881024) | (i17 & 1879048192);
                            int i19 = (i3 >> 27) & 14;
                            modifier2 = companion;
                            lazyGridState2 = lazyGridStateRememberLazyGridState;
                            flingBehavior4 = flingBehavior3;
                            z7 = z5;
                            LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i18, i19, 0);
                            horizontal4 = horizontal3;
                            z8 = z6;
                            vertical4 = vertical3;
                            paddingValues4 = paddingValues3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyGridState2 = lazyGridState;
                            flingBehavior4 = flingBehavior;
                            paddingValues4 = paddingValues2;
                            horizontal4 = horizontal2;
                            z8 = z3;
                            vertical4 = vertical2;
                            z7 = z2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i20) {
                                LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i12 = C.ENCODING_PCM_32BIT;
                    i3 |= i12;
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i110 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums2 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i110 & 896));
                        int i111 = (i110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i110 & 112) | (i3 & 7168) | (57344 & i3) | (i110 & 3670016) | (i110 & 29360128);
                        int i112 = i3 << 9;
                        int i113 = i111 | (i112 & 234881024) | (i112 & 1879048192);
                        int i114 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums2, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i113, i114, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i115 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums3 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i115 & 896));
                        int i116 = (i115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i115 & 112) | (i3 & 7168) | (57344 & i3) | (i115 & 3670016) | (i115 & 29360128);
                        int i117 = i3 << 9;
                        int i118 = i116 | (i117 & 234881024) | (i117 & 1879048192);
                        int i119 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums3, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i118, i119, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                z3 = z;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1110 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums4 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1110 & 896));
                        int i1111 = (i1110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1110 & 112) | (i3 & 7168) | (57344 & i3) | (i1110 & 3670016) | (i1110 & 29360128);
                        int i1112 = i3 << 9;
                        int i1113 = i1111 | (i1112 & 234881024) | (i1112 & 1879048192);
                        int i1114 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums4, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1113, i1114, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1115 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums5 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1115 & 896));
                        int i1116 = (i1115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1115 & 112) | (i3 & 7168) | (57344 & i3) | (i1115 & 3670016) | (i1115 & 29360128);
                        int i1117 = i3 << 9;
                        int i1118 = i1116 | (i1117 & 234881024) | (i1117 & 1879048192);
                        int i1119 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums5, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1118, i1119, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i12 = C.ENCODING_PCM_32BIT;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums6 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11110 & 896));
                    int i11111 = (i11110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11110 & 112) | (i3 & 7168) | (57344 & i3) | (i11110 & 3670016) | (i11110 & 29360128);
                    int i11112 = i3 << 9;
                    int i11113 = i11111 | (i11112 & 234881024) | (i11112 & 1879048192);
                    int i11114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums6, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11113, i11114, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums7 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11115 & 896));
                    int i11116 = (i11115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11115 & 112) | (i3 & 7168) | (57344 & i3) | (i11115 & 3670016) | (i11115 & 29360128);
                    int i11117 = i3 << 9;
                    int i11118 = i11116 | (i11117 & 234881024) | (i11117 & 1879048192);
                    int i11119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums7, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11118, i11119, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i111110 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums8 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111110 & 896));
                        int i111111 = (i111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111110 & 112) | (i3 & 7168) | (57344 & i3) | (i111110 & 3670016) | (i111110 & 29360128);
                        int i111112 = i3 << 9;
                        int i111113 = i111111 | (i111112 & 234881024) | (i111112 & 1879048192);
                        int i111114 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums8, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111113, i111114, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i111115 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums9 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111115 & 896));
                        int i111116 = (i111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111115 & 112) | (i3 & 7168) | (57344 & i3) | (i111115 & 3670016) | (i111115 & 29360128);
                        int i111117 = i3 << 9;
                        int i111118 = i111116 | (i111117 & 234881024) | (i111117 & 1879048192);
                        int i111119 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums9, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111118, i111119, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i12 = C.ENCODING_PCM_32BIT;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1111110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums10 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111110 & 896));
                    int i1111111 = (i1111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111110 & 112) | (i3 & 7168) | (57344 & i3) | (i1111110 & 3670016) | (i1111110 & 29360128);
                    int i1111112 = i3 << 9;
                    int i1111113 = i1111111 | (i1111112 & 234881024) | (i1111112 & 1879048192);
                    int i1111114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums10, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111113, i1111114, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1111115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums11 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111115 & 896));
                    int i1111116 = (i1111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111115 & 112) | (i3 & 7168) | (57344 & i3) | (i1111115 & 3670016) | (i1111115 & 29360128);
                    int i1111117 = i3 << 9;
                    int i1111118 = i1111116 | (i1111117 & 234881024) | (i1111117 & 1879048192);
                    int i1111119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums11, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111118, i1111119, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums12 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111110 & 896));
                    int i11111111 = (i11111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111110 & 112) | (i3 & 7168) | (57344 & i3) | (i11111110 & 3670016) | (i11111110 & 29360128);
                    int i11111112 = i3 << 9;
                    int i11111113 = i11111111 | (i11111112 & 234881024) | (i11111112 & 1879048192);
                    int i11111114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums12, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111113, i11111114, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums13 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111115 & 896));
                    int i11111116 = (i11111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111115 & 112) | (i3 & 7168) | (57344 & i3) | (i11111115 & 3670016) | (i11111115 & 29360128);
                    int i11111117 = i3 << 9;
                    int i11111118 = i11111116 | (i11111117 & 234881024) | (i11111117 & 1879048192);
                    int i11111119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums13, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111118, i11111119, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i12 = C.ENCODING_PCM_32BIT;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111111110 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums14 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111110 & 896));
                int i111111111 = (i111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i111111110 & 3670016) | (i111111110 & 29360128);
                int i111111112 = i3 << 9;
                int i111111113 = i111111111 | (i111111112 & 234881024) | (i111111112 & 1879048192);
                int i111111114 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums14, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111113, i111111114, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111111115 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums15 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111115 & 896));
                int i111111116 = (i111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i111111115 & 3670016) | (i111111115 & 29360128);
                int i111111117 = i3 << 9;
                int i111111118 = i111111116 | (i111111117 & 234881024) | (i111111117 & 1879048192);
                int i111111119 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums15, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111118, i111111119, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        if ((i & 896) != 0) {
            i3 |= ((i2 & 4) == 0 || !composerStartRestartGroup.changed(lazyGridState)) ? 128 : 256;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                        }
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    horizontal2 = horizontal;
                } else {
                    horizontal2 = horizontal;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111111110 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums16 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111110 & 896));
                        int i1111111111 = (i1111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111110 & 3670016) | (i1111111110 & 29360128);
                        int i1111111112 = i3 << 9;
                        int i1111111113 = i1111111111 | (i1111111112 & 234881024) | (i1111111112 & 1879048192);
                        int i1111111114 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums16, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111113, i1111111114, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -458753;
                            } else {
                                bottom = vertical2;
                            }
                            if (i8 != 0) {
                                start = Arrangement.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111111115 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums17 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111115 & 896));
                        int i1111111116 = (i1111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111115 & 3670016) | (i1111111115 & 29360128);
                        int i1111111117 = i3 << 9;
                        int i1111111118 = i1111111116 | (i1111111117 & 234881024) | (i1111111117 & 1879048192);
                        int i1111111119 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums17, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111118, i1111111119, 0);
                        horizontal4 = horizontal3;
                        z8 = z6;
                        vertical4 = vertical3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i20) {
                            LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i12 = C.ENCODING_PCM_32BIT;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111111110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums18 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111110 & 896));
                    int i11111111111 = (i11111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111110 & 3670016) | (i11111111110 & 29360128);
                    int i11111111112 = i3 << 9;
                    int i11111111113 = i11111111111 | (i11111111112 & 234881024) | (i11111111112 & 1879048192);
                    int i11111111114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums18, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111113, i11111111114, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111111115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums19 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111115 & 896));
                    int i11111111116 = (i11111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111115 & 3670016) | (i11111111115 & 29360128);
                    int i11111111117 = i3 << 9;
                    int i11111111118 = i11111111116 | (i11111111117 & 234881024) | (i11111111117 & 1879048192);
                    int i11111111119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums19, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111118, i11111111119, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111111111110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums110 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111110 & 896));
                    int i111111111111 = (i111111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i111111111110 & 3670016) | (i111111111110 & 29360128);
                    int i111111111112 = i3 << 9;
                    int i111111111113 = i111111111111 | (i111111111112 & 234881024) | (i111111111112 & 1879048192);
                    int i111111111114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums110, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111111113, i111111111114, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111111111115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums111 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111115 & 896));
                    int i111111111116 = (i111111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i111111111115 & 3670016) | (i111111111115 & 29360128);
                    int i111111111117 = i3 << 9;
                    int i111111111118 = i111111111116 | (i111111111117 & 234881024) | (i111111111117 & 1879048192);
                    int i111111111119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums111, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111111118, i111111111119, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i12 = C.ENCODING_PCM_32BIT;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111111110 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums112 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111110 & 896));
                int i1111111111111 = (i1111111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111111110 & 3670016) | (i1111111111110 & 29360128);
                int i1111111111112 = i3 << 9;
                int i1111111111113 = i1111111111111 | (i1111111111112 & 234881024) | (i1111111111112 & 1879048192);
                int i1111111111114 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums112, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111111113, i1111111111114, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111111115 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums113 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111115 & 896));
                int i1111111111116 = (i1111111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111111115 & 3670016) | (i1111111111115 & 29360128);
                int i1111111111117 = i3 << 9;
                int i1111111111118 = i1111111111116 | (i1111111111117 & 234881024) | (i1111111111117 & 1879048192);
                int i1111111111119 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums113, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111111118, i1111111111119, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                horizontal2 = horizontal;
            } else {
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111111111110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums114 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111110 & 896));
                    int i11111111111111 = (i11111111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111111110 & 3670016) | (i11111111111110 & 29360128);
                    int i11111111111112 = i3 << 9;
                    int i11111111111113 = i11111111111111 | (i11111111111112 & 234881024) | (i11111111111112 & 1879048192);
                    int i11111111111114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums114, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111111113, i11111111111114, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -458753;
                        } else {
                            bottom = vertical2;
                        }
                        if (i8 != 0) {
                            start = Arrangement.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111111111115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums115 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111115 & 896));
                    int i11111111111116 = (i11111111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111111115 & 3670016) | (i11111111111115 & 29360128);
                    int i11111111111117 = i3 << 9;
                    int i11111111111118 = i11111111111116 | (i11111111111117 & 234881024) | (i11111111111117 & 1879048192);
                    int i11111111111119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums115, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111111118, i11111111111119, 0);
                    horizontal4 = horizontal3;
                    z8 = z6;
                    vertical4 = vertical3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i20) {
                        LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i12 = C.ENCODING_PCM_32BIT;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111111111111110 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums116 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111110 & 896));
                int i111111111111111 = (i111111111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i111111111111110 & 3670016) | (i111111111111110 & 29360128);
                int i111111111111112 = i3 << 9;
                int i111111111111113 = i111111111111111 | (i111111111111112 & 234881024) | (i111111111111112 & 1879048192);
                int i111111111111114 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums116, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111111111113, i111111111111114, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111111111111115 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums117 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111111115 & 896));
                int i111111111111116 = (i111111111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i111111111111115 & 3670016) | (i111111111111115 & 29360128);
                int i111111111111117 = i3 << 9;
                int i111111111111118 = i111111111111116 | (i111111111111117 & 234881024) | (i111111111111117 & 1879048192);
                int i111111111111119 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums117, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111111111118, i111111111111119, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        z3 = z;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i14;
            } else {
                vertical2 = vertical;
            }
            i3 |= i14;
        } else {
            vertical2 = vertical;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            horizontal2 = horizontal;
        } else {
            horizontal2 = horizontal;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111111111110 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums118 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111110 & 896));
                int i1111111111111111 = (i1111111111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111111111110 & 3670016) | (i1111111111111110 & 29360128);
                int i1111111111111112 = i3 << 9;
                int i1111111111111113 = i1111111111111111 | (i1111111111111112 & 234881024) | (i1111111111111112 & 1879048192);
                int i1111111111111114 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums118, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111111111113, i1111111111111114, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -458753;
                    } else {
                        bottom = vertical2;
                    }
                    if (i8 != 0) {
                        start = Arrangement.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111111111115 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums119 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111111111115 & 896));
                int i1111111111111116 = (i1111111111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111111111115 & 3670016) | (i1111111111111115 & 29360128);
                int i1111111111111117 = i3 << 9;
                int i1111111111111118 = i1111111111111116 | (i1111111111111117 & 234881024) | (i1111111111111117 & 1879048192);
                int i1111111111111119 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums119, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111111111118, i1111111111111119, 0);
                horizontal4 = horizontal3;
                z8 = z6;
                vertical4 = vertical3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i20) {
                    LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i12 = C.ENCODING_PCM_32BIT;
        i3 |= i12;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior3 = flingBehavior2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior3 = flingBehavior2;
            }
            composerStartRestartGroup.endDefaults();
            int i11111111111111110 = i3 >> 3;
            Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums1110 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111110 & 896));
            int i11111111111111111 = (i11111111111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111111111110 & 3670016) | (i11111111111111110 & 29360128);
            int i11111111111111112 = i3 << 9;
            int i11111111111111113 = i11111111111111111 | (i11111111111111112 & 234881024) | (i11111111111111112 & 1879048192);
            int i11111111111111114 = (i3 >> 27) & 14;
            modifier2 = companion;
            lazyGridState2 = lazyGridStateRememberLazyGridState;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
            LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums1110, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111111111113, i11111111111111114, 0);
            horizontal4 = horizontal3;
            z8 = z6;
            vertical4 = vertical3;
            paddingValues4 = paddingValues3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior3 = flingBehavior2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -458753;
                } else {
                    bottom = vertical2;
                }
                if (i8 != 0) {
                    start = Arrangement.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior3 = flingBehavior2;
            }
            composerStartRestartGroup.endDefaults();
            int i11111111111111115 = i3 >> 3;
            Function2<Density, Constraints, List<Integer>> function2RememberColumnWidthSums1111 = rememberColumnWidthSums(columns, horizontal3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111111111115 & 896));
            int i11111111111111116 = (i11111111111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111111111115 & 3670016) | (i11111111111111115 & 29360128);
            int i11111111111111117 = i3 << 9;
            int i11111111111111118 = i11111111111111116 | (i11111111111111117 & 234881024) | (i11111111111111117 & 1879048192);
            int i11111111111111119 = (i3 >> 27) & 14;
            modifier2 = companion;
            lazyGridState2 = lazyGridStateRememberLazyGridState;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
            LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberColumnWidthSums1111, paddingValues3, z6, true, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111111111118, i11111111111111119, 0);
            horizontal4 = horizontal3;
            z8 = z6;
            vertical4 = vertical3;
            paddingValues4 = paddingValues3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyVerticalGrid.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i20) {
                LazyGridDslKt.LazyVerticalGrid(columns, modifier2, lazyGridState2, paddingValues4, z8, vertical4, horizontal4, flingBehavior4, z7, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:103:0x012d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0131  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:108:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:115:0x0160  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0198 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x019a  */
    /* JADX WARN: Code duplicated, block: B:132:0x019f  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:147:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:153:0x01df  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:160:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:166:0x026f  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:91:0x0109  */
    /* JADX WARN: Code duplicated, block: B:92:0x0110  */
    /* JADX WARN: Code duplicated, block: B:94:0x0116  */
    /* JADX WARN: Code duplicated, block: B:96:0x011c  */
    /* JADX WARN: Code duplicated, block: B:97:0x011f  */
    public static final void LazyHorizontalGrid(final GridCells rows, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyGridScope, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Horizontal horizontal2;
        int i8;
        Arrangement.Vertical vertical2;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier.Companion companion;
        LazyGridState lazyGridStateRememberLazyGridState;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        boolean z4;
        Arrangement.Horizontal end;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior2;
        boolean z5;
        boolean z6;
        PaddingValues paddingValues3;
        Arrangement.Horizontal horizontal3;
        Arrangement.Vertical vertical3;
        FlingBehavior flingBehavior3;
        Arrangement arrangement;
        final Modifier modifier2;
        final LazyGridState lazyGridState2;
        final FlingBehavior flingBehavior4;
        final boolean z7;
        final Arrangement.Vertical vertical4;
        final boolean z8;
        final Arrangement.Horizontal horizontal4;
        final PaddingValues paddingValues4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(rows, "rows");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)119@5584L23,125@5941L15,129@6063L64,130@6132L432:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(rows) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) != 0) {
                i3 |= ((i2 & 4) == 0 || !composerStartRestartGroup.changed(lazyGridState)) ? 128 : 256;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 57344) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            horizontal2 = horizontal;
                            int i14 = composerStartRestartGroup.changed(horizontal2) ? 131072 : 65536;
                            i3 |= i14;
                        } else {
                            horizontal2 = horizontal;
                        }
                        i3 |= i14;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                        vertical2 = vertical;
                    } else {
                        vertical2 = vertical;
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(vertical2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        if ((i & 1879048192) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i12 = 536870912;
                            } else {
                                i12 = 268435456;
                            }
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i2 & 4) != 0) {
                                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -897;
                                } else {
                                    lazyGridStateRememberLazyGridState = lazyGridState;
                                }
                                if (i4 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                                }
                                z4 = i6 == 0 ? z3 : false;
                                if ((i2 & 32) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        end = arrangement.getEnd();
                                    } else {
                                        end = arrangement.getStart();
                                    }
                                    i3 &= -458753;
                                } else {
                                    end = horizontal2;
                                }
                                if (i8 != 0) {
                                    top = Arrangement.INSTANCE.getTop();
                                } else {
                                    top = vertical2;
                                }
                                if ((i2 & 128) != 0) {
                                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    flingBehavior2 = flingBehavior;
                                }
                                if (i10 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                z6 = z4;
                                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior3 = flingBehavior2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                companion = modifier;
                                lazyGridStateRememberLazyGridState = lazyGridState;
                                flingBehavior3 = flingBehavior;
                                z5 = z2;
                                paddingValues3 = paddingValues2;
                                z6 = z3;
                                horizontal3 = horizontal2;
                                vertical3 = vertical2;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i15 = i3 >> 3;
                            Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i15 & 896));
                            int i16 = (i15 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i15 & 112) | (i3 & 7168) | (57344 & i3) | (i15 & 3670016) | (i15 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                            int i17 = (i3 >> 27) & 14;
                            modifier2 = companion;
                            lazyGridState2 = lazyGridStateRememberLazyGridState;
                            flingBehavior4 = flingBehavior3;
                            z7 = z5;
                            LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i16, i17, 0);
                            vertical4 = vertical3;
                            z8 = z6;
                            horizontal4 = horizontal3;
                            paddingValues4 = paddingValues3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyGridState2 = lazyGridState;
                            flingBehavior4 = flingBehavior;
                            paddingValues4 = paddingValues2;
                            vertical4 = vertical2;
                            z8 = z3;
                            horizontal4 = horizontal2;
                            z7 = z2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i18) {
                                LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i12 = C.ENCODING_PCM_32BIT;
                    i3 |= i12;
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i18 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums2 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i18 & 896));
                        int i19 = (i18 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i18 & 112) | (i3 & 7168) | (57344 & i3) | (i18 & 3670016) | (i18 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i110 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums2, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i19, i110, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i111 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums3 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111 & 896));
                        int i112 = (i111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111 & 112) | (i3 & 7168) | (57344 & i3) | (i111 & 3670016) | (i111 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i113 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums3, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i112, i113, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i114) {
                            LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                z3 = z;
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                        }
                        i3 |= i14;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i114 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums4 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i114 & 896));
                        int i115 = (i114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i114 & 112) | (i3 & 7168) | (57344 & i3) | (i114 & 3670016) | (i114 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i116 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums4, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i115, i116, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i117 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums5 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i117 & 896));
                        int i118 = (i117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i117 & 112) | (i3 & 7168) | (57344 & i3) | (i117 & 3670016) | (i117 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i119 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums5, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i118, i119, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1110) {
                            LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i12 = C.ENCODING_PCM_32BIT;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1110 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums6 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1110 & 896));
                    int i1111 = (i1110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1110 & 112) | (i3 & 7168) | (57344 & i3) | (i1110 & 3670016) | (i1110 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i1112 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums6, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111, i1112, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1113 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums7 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1113 & 896));
                    int i1114 = (i1113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1113 & 112) | (i3 & 7168) | (57344 & i3) | (i1113 & 3670016) | (i1113 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i1115 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums7, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1114, i1115, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1116) {
                        LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            paddingValues2 = paddingValues;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                        }
                        i3 |= i14;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1116 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums8 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1116 & 896));
                        int i1117 = (i1116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1116 & 112) | (i3 & 7168) | (57344 & i3) | (i1116 & 3670016) | (i1116 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i1118 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums8, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1117, i1118, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1119 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums9 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1119 & 896));
                        int i11110 = (i1119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1119 & 112) | (i3 & 7168) | (57344 & i3) | (i1119 & 3670016) | (i1119 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i11111 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums9, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11110, i11111, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11112) {
                            LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i12 = C.ENCODING_PCM_32BIT;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11112 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums10 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11112 & 896));
                    int i11113 = (i11112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11112 & 112) | (i3 & 7168) | (57344 & i3) | (i11112 & 3670016) | (i11112 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i11114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums10, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11113, i11114, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums11 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11115 & 896));
                    int i11116 = (i11115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11115 & 112) | (i3 & 7168) | (57344 & i3) | (i11115 & 3670016) | (i11115 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i11117 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums11, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11116, i11117, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11118) {
                        LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11118 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums12 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11118 & 896));
                    int i11119 = (i11118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11118 & 112) | (i3 & 7168) | (57344 & i3) | (i11118 & 3670016) | (i11118 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i111110 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums12, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11119, i111110, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111111 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums13 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111 & 896));
                    int i111112 = (i111111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111 & 112) | (i3 & 7168) | (57344 & i3) | (i111111 & 3670016) | (i111111 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i111113 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums13, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111112, i111113, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111114) {
                        LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i12 = C.ENCODING_PCM_32BIT;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111114 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums14 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111114 & 896));
                int i111115 = (i111114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111114 & 112) | (i3 & 7168) | (57344 & i3) | (i111114 & 3670016) | (i111114 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i111116 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums14, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111115, i111116, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111117 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums15 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111117 & 896));
                int i111118 = (i111117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111117 & 112) | (i3 & 7168) | (57344 & i3) | (i111117 & 3670016) | (i111117 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i111119 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums15, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111118, i111119, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i1111110) {
                    LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 48;
        if ((i & 896) != 0) {
            i3 |= ((i2 & 4) == 0 || !composerStartRestartGroup.changed(lazyGridState)) ? 128 : 256;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 57344) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((458752 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                        }
                        i3 |= i14;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                    vertical2 = vertical;
                } else {
                    vertical2 = vertical;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i12 = 536870912;
                        } else {
                            i12 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111110 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums16 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111110 & 896));
                        int i1111111 = (i1111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111110 & 112) | (i3 & 7168) | (57344 & i3) | (i1111110 & 3670016) | (i1111110 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i1111112 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums16, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111, i1111112, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -897;
                            } else {
                                lazyGridStateRememberLazyGridState = lazyGridState;
                            }
                            if (i4 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                            }
                            if (i6 == 0) {
                            }
                            if ((i2 & 32) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -458753;
                            } else {
                                end = horizontal2;
                            }
                            if (i8 != 0) {
                                top = Arrangement.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 128) != 0) {
                                flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                flingBehavior2 = flingBehavior;
                            }
                            if (i10 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            z6 = z4;
                            paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior3 = flingBehavior2;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111113 = i3 >> 3;
                        Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums17 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111113 & 896));
                        int i1111114 = (i1111113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111113 & 112) | (i3 & 7168) | (57344 & i3) | (i1111113 & 3670016) | (i1111113 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                        int i1111115 = (i3 >> 27) & 14;
                        modifier2 = companion;
                        lazyGridState2 = lazyGridStateRememberLazyGridState;
                        flingBehavior4 = flingBehavior3;
                        z7 = z5;
                        LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums17, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111114, i1111115, 0);
                        vertical4 = vertical3;
                        z8 = z6;
                        horizontal4 = horizontal3;
                        paddingValues4 = paddingValues3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i1111116) {
                            LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                        }
                    });
                }
                i12 = C.ENCODING_PCM_32BIT;
                i3 |= i12;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1111116 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums18 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111116 & 896));
                    int i1111117 = (i1111116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111116 & 112) | (i3 & 7168) | (57344 & i3) | (i1111116 & 3670016) | (i1111116 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i1111118 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums18, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111117, i1111118, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1111119 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums19 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111119 & 896));
                    int i11111110 = (i1111119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111119 & 112) | (i3 & 7168) | (57344 & i3) | (i1111119 & 3670016) | (i1111119 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i11111111 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums19, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111110, i11111111, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111112) {
                        LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            z3 = z;
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111112 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums110 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111112 & 896));
                    int i11111113 = (i11111112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111112 & 112) | (i3 & 7168) | (57344 & i3) | (i11111112 & 3670016) | (i11111112 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i11111114 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums110, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111113, i11111114, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i11111115 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums111 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111115 & 896));
                    int i11111116 = (i11111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111115 & 112) | (i3 & 7168) | (57344 & i3) | (i11111115 & 3670016) | (i11111115 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i11111117 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums111, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111116, i11111117, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11111118) {
                        LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i12 = C.ENCODING_PCM_32BIT;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i11111118 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums112 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111118 & 896));
                int i11111119 = (i11111118 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111118 & 112) | (i3 & 7168) | (57344 & i3) | (i11111118 & 3670016) | (i11111118 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i111111110 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums112, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111119, i111111110, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i111111111 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums113 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111111 & 896));
                int i111111112 = (i111111111 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111111 & 112) | (i3 & 7168) | (57344 & i3) | (i111111111 & 3670016) | (i111111111 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i111111113 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums113, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111112, i111111113, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i111111114) {
                    LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        paddingValues2 = paddingValues;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 57344) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((458752 & i) == 0) {
                if ((i2 & 32) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
                vertical2 = vertical;
            } else {
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i12 = 536870912;
                    } else {
                        i12 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111111114 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums114 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111114 & 896));
                    int i111111115 = (i111111114 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111114 & 112) | (i3 & 7168) | (57344 & i3) | (i111111114 & 3670016) | (i111111114 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i111111116 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums114, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111115, i111111116, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -897;
                        } else {
                            lazyGridStateRememberLazyGridState = lazyGridState;
                        }
                        if (i4 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                        }
                        if (i6 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -458753;
                        } else {
                            end = horizontal2;
                        }
                        if (i8 != 0) {
                            top = Arrangement.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 128) != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        z6 = z4;
                        paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior3 = flingBehavior2;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111111117 = i3 >> 3;
                    Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums115 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i111111117 & 896));
                    int i111111118 = (i111111117 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i111111117 & 112) | (i3 & 7168) | (57344 & i3) | (i111111117 & 3670016) | (i111111117 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                    int i111111119 = (i3 >> 27) & 14;
                    modifier2 = companion;
                    lazyGridState2 = lazyGridStateRememberLazyGridState;
                    flingBehavior4 = flingBehavior3;
                    z7 = z5;
                    LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums115, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i111111118, i111111119, 0);
                    vertical4 = vertical3;
                    z8 = z6;
                    horizontal4 = horizontal3;
                    paddingValues4 = paddingValues3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i1111111110) {
                        LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                    }
                });
            }
            i12 = C.ENCODING_PCM_32BIT;
            i3 |= i12;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111110 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums116 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111110 & 896));
                int i1111111111 = (i1111111110 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111110 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111110 & 3670016) | (i1111111110 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i1111111112 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums116, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111111, i1111111112, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111113 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums117 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111113 & 896));
                int i1111111114 = (i1111111113 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111113 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111113 & 3670016) | (i1111111113 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i1111111115 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums117, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111114, i1111111115, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i1111111116) {
                    LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        z3 = z;
        if ((458752 & i) == 0) {
            if ((i2 & 32) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                }
                i3 |= i14;
            } else {
                horizontal2 = horizontal;
            }
            i3 |= i14;
        } else {
            horizontal2 = horizontal;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
            vertical2 = vertical;
        } else {
            vertical2 = vertical;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(vertical2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(flingBehavior)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i12 = 536870912;
                } else {
                    i12 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111116 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums118 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111116 & 896));
                int i1111111117 = (i1111111116 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111116 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111116 & 3670016) | (i1111111116 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i1111111118 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums118, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i1111111117, i1111111118, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -897;
                    } else {
                        lazyGridStateRememberLazyGridState = lazyGridState;
                    }
                    if (i4 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                    }
                    if (i6 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -458753;
                    } else {
                        end = horizontal2;
                    }
                    if (i8 != 0) {
                        top = Arrangement.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 128) != 0) {
                        flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    z6 = z4;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior3 = flingBehavior2;
                }
                composerStartRestartGroup.endDefaults();
                int i1111111119 = i3 >> 3;
                Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums119 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i1111111119 & 896));
                int i11111111110 = (i1111111119 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i1111111119 & 112) | (i3 & 7168) | (57344 & i3) | (i1111111119 & 3670016) | (i1111111119 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
                int i11111111111 = (i3 >> 27) & 14;
                modifier2 = companion;
                lazyGridState2 = lazyGridStateRememberLazyGridState;
                flingBehavior4 = flingBehavior3;
                z7 = z5;
                LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums119, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111110, i11111111111, 0);
                vertical4 = vertical3;
                z8 = z6;
                horizontal4 = horizontal3;
                paddingValues4 = paddingValues3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11111111112) {
                    LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
                }
            });
        }
        i12 = C.ENCODING_PCM_32BIT;
        i3 |= i12;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior3 = flingBehavior2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior3 = flingBehavior2;
            }
            composerStartRestartGroup.endDefaults();
            int i11111111112 = i3 >> 3;
            Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums1110 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111112 & 896));
            int i11111111113 = (i11111111112 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111112 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111112 & 3670016) | (i11111111112 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
            int i11111111114 = (i3 >> 27) & 14;
            modifier2 = companion;
            lazyGridState2 = lazyGridStateRememberLazyGridState;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
            LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums1110, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111113, i11111111114, 0);
            vertical4 = vertical3;
            z8 = z6;
            horizontal4 = horizontal3;
            paddingValues4 = paddingValues3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior3 = flingBehavior2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -897;
                } else {
                    lazyGridStateRememberLazyGridState = lazyGridState;
                }
                if (i4 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues2;
                }
                if (i6 == 0) {
                }
                if ((i2 & 32) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -458753;
                } else {
                    end = horizontal2;
                }
                if (i8 != 0) {
                    top = Arrangement.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 128) != 0) {
                    flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = z4;
                paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior3 = flingBehavior2;
            }
            composerStartRestartGroup.endDefaults();
            int i11111111115 = i3 >> 3;
            Function2<Density, Constraints, List<Integer>> function2RememberRowHeightSums1111 = rememberRowHeightSums(rows, vertical3, paddingValues3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 15) & 112) | (i11111111115 & 896));
            int i11111111116 = (i11111111115 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i11111111115 & 112) | (i3 & 7168) | (57344 & i3) | (i11111111115 & 3670016) | (i11111111115 & 29360128) | ((i3 << 6) & 234881024) | ((i3 << 12) & 1879048192);
            int i11111111117 = (i3 >> 27) & 14;
            modifier2 = companion;
            lazyGridState2 = lazyGridStateRememberLazyGridState;
            flingBehavior4 = flingBehavior3;
            z7 = z5;
            LazyGridKt.LazyGrid(modifier2, lazyGridState2, function2RememberRowHeightSums1111, paddingValues3, z6, false, flingBehavior4, z7, vertical3, horizontal3, content, composerStartRestartGroup, i11111111116, i11111111117, 0);
            vertical4 = vertical3;
            z8 = z6;
            horizontal4 = horizontal3;
            paddingValues4 = paddingValues3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.LazyHorizontalGrid.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i11111111118) {
                LazyGridDslKt.LazyHorizontalGrid(rows, modifier2, lazyGridState2, paddingValues4, z8, horizontal4, vertical4, flingBehavior4, z7, content, composer2, i | 1, i2);
            }
        });
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(-1355301804);
        ComposerKt.sourceInformation(composer, "C(rememberColumnWidthSums)P(!1,2)152@6816L830:LazyGridDsl.kt#7791vq");
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(gridCells) | composer.changed(horizontal) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new Function2<Density, Constraints, List<Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberColumnWidthSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ List<Integer> invoke(Density density, Constraints constraints) {
                    return m585invoke0kLqBqw(density, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final List<Integer> m585invoke0kLqBqw(Density density, long j) {
                    Intrinsics.checkNotNullParameter(density, "$this$null");
                    if (Constraints.m3799getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
                    }
                    List<Integer> mutableList = CollectionsKt.toMutableList((Collection) gridCells.calculateCrossAxisCellSizes(density, Constraints.m3799getMaxWidthimpl(j) - density.mo312roundToPx0680j_4(Dp.m3843constructorimpl(PaddingKt.calculateStartPadding(paddingValues, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(paddingValues, LayoutDirection.Ltr))), density.mo312roundToPx0680j_4(horizontal.getSpacing())));
                    int size = mutableList.size();
                    for (int i2 = 1; i2 < size; i2++) {
                        mutableList.set(i2, Integer.valueOf(mutableList.get(i2).intValue() + mutableList.get(i2 - 1).intValue()));
                    }
                    return mutableList;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) objRememberedValue;
        composer.endReplaceableGroup();
        return function2;
    }

    private static final Function2<Density, Constraints, List<Integer>> rememberRowHeightSums(final GridCells gridCells, final Arrangement.Vertical vertical, final PaddingValues paddingValues, Composer composer, int i) {
        composer.startReplaceableGroup(239683573);
        ComposerKt.sourceInformation(composer, "C(rememberRowHeightSums)P(1,2)184@7885L786:LazyGridDsl.kt#7791vq");
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(gridCells) | composer.changed(vertical) | composer.changed(paddingValues);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new Function2<Density, Constraints, List<Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$rememberRowHeightSums$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ List<Integer> invoke(Density density, Constraints constraints) {
                    return m586invoke0kLqBqw(density, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final List<Integer> m586invoke0kLqBqw(Density density, long j) {
                    Intrinsics.checkNotNullParameter(density, "$this$null");
                    if (Constraints.m3798getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
                    }
                    List<Integer> mutableList = CollectionsKt.toMutableList((Collection) gridCells.calculateCrossAxisCellSizes(density, Constraints.m3798getMaxHeightimpl(j) - density.mo312roundToPx0680j_4(Dp.m3843constructorimpl(paddingValues.getTop() + paddingValues.getBottom())), density.mo312roundToPx0680j_4(vertical.getSpacing())));
                    int size = mutableList.size();
                    for (int i2 = 1; i2 < size; i2++) {
                        mutableList.set(i2, Integer.valueOf(mutableList.get(i2).intValue() + mutableList.get(i2 - 1).intValue()));
                    }
                    return mutableList;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<Density, Constraints, List<Integer>> function2 = (Function2) objRememberedValue;
        composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List items, Function1 function1, Function2 function2, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            contentType = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.size(), function1 != null ? new AnonymousClass2(function1, items) : null, function2 != null ? new AnonymousClass3(function2, items) : null, new AnonymousClass4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new AnonymousClass5(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$key = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$key.invoke((T) this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass3 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, List<? extends T> list) {
            super(2);
            this.$span = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m558boximpl(m581invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m581invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
            return this.$span.invoke(lazyGridItemSpanScope, (T) this.$items.get(i)).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass4 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
            super(1);
            this.$contentType = function1;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke((T) this.$items.get(i));
        }
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.size(), function1 != null ? new AnonymousClass2(function1, items) : null, function2 != null ? new AnonymousClass3(function2, items) : null, new AnonymousClass4(contentType, items), ComposableLambdaKt.composableLambdaInstance(699646206, true, new AnonymousClass5(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$5, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass5 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyGridItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C391@16605L22:LazyGridDsl.kt#7791vq");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, (T) this.$items.get(i), composer, Integer.valueOf(i3 & 14));
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List items, Function2 function2, Function3 function3, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            contentType = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.size(), function2 != null ? new C10202(function2, items) : null, function3 != null ? new C10213(function3, items) : null, new C10224(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C10235(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10202 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10202(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$key = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10213 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10213(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, List<? extends T> list) {
            super(2);
            this.$span = function3;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m558boximpl(m583invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m583invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), (T) this.$items.get(i)).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10224 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10224(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
            super(1);
            this.$contentType = function2;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), (T) this.$items.get(i));
        }
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.size(), function2 != null ? new C10202(function2, items) : null, function3 != null ? new C10213(function3, items) : null, new C10224(contentType, items), ComposableLambdaKt.composableLambdaInstance(1229287273, true, new C10235(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10235 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10235(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyGridItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C424@18380L26:LazyGridDsl.kt#7791vq");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, Integer.valueOf(i), (T) this.$items.get(i), composer, Integer.valueOf(i3 & 126));
            }
        }
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] items, Function1 function1, Function2 function2, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            contentType = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(T t) {
                    return null;
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.length, function1 != null ? new AnonymousClass7(function1, items) : null, function2 != null ? new AnonymousClass8(function2, items) : null, new AnonymousClass9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new AnonymousClass10(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$7, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass7 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$key = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$key.invoke(this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$8, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass8 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<LazyGridItemSpanScope, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, T[] tArr) {
            super(2);
            this.$span = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m558boximpl(m582invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m582invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
            return this.$span.invoke(lazyGridItemSpanScope, this.$items[i]).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$9, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass9 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function1<? super T, ? extends Object> function1, T[] tArr) {
            super(1);
            this.$contentType = function1;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$contentType.invoke(this.$items[i]);
        }
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] items, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> contentType, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.length, function1 != null ? new AnonymousClass7(function1, items) : null, function2 != null ? new AnonymousClass8(function2, items) : null, new AnonymousClass9(contentType, items), ComposableLambdaKt.composableLambdaInstance(407562193, true, new AnonymousClass10(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$10, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass10 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyGridItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyGridItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C457@20033L22:LazyGridDsl.kt#7791vq");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, this.$items[i], composer, Integer.valueOf(i3 & 14));
            }
        }
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] items, Function2 function2, Function3 function3, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            contentType = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.length, function2 != null ? new C10257(function2, items) : null, function3 != null ? new C10268(function3, items) : null, new C10279(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C101910(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10257 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10257(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$key = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$key.invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10268 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $span;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10268(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, T[] tArr) {
            super(2);
            this.$span = function3;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
            return GridItemSpan.m558boximpl(m584invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m584invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
            return this.$span.invoke(lazyGridItemSpanScope, Integer.valueOf(i), this.$items[i]).getPackedValue();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$9, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10279 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10279(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
            super(1);
            this.$contentType = function2;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invoke(int i) {
            return this.$contentType.invoke(Integer.valueOf(i), this.$items[i]);
        }
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyGridScope.items(items.length, function2 != null ? new C10257(function2, items) : null, function3 != null ? new C10268(function3, items) : null, new C10279(contentType, items), ComposableLambdaKt.composableLambdaInstance(-911455938, true, new C101910(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$10, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C101910 extends Lambda implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C101910(Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void invoke(LazyGridItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C490@21812L26:LazyGridDsl.kt#7791vq");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(items) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$itemContent.invoke(items, Integer.valueOf(i), this.$items[i], composer, Integer.valueOf(i3 & 126));
            }
        }
    }
}
