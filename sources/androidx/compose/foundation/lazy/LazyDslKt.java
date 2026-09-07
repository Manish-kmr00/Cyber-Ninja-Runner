package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LazyDsl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001av\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001al\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001av\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a¬\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010+\u001a\u0085\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010,\u001a¬\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u00112%\b\n\u0010&\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010.\u001a\u0085\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2%\b\n\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010\u001123\b\u0004\u0010'\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010(¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010/\u001aë\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u00104\u001a¯\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001aë\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2:\b\u0006\u0010&\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0006\u0012\u0004\u0018\u00010%0(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000¢\u0006\u0002\u00106\u001a¯\u0001\u00100\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0-2:\b\n\u0010!\u001a4\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%\u0018\u00010(2H\b\u0004\u0010'\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000103¢\u0006\u0002\b*¢\u0006\u0002\b\u0013H\u0087\bø\u0001\u0000¢\u0006\u0002\u00107\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "userScrollEnabled", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.ITEMS, "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10061 extends Lambda implements Function1 {
        public static final C10061 INSTANCE = new C10061();

        public C10061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(T t) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$5, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass5 extends Lambda implements Function1 {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(T t) {
            return null;
        }
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List items, Function1 function1, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            contentType = C10061.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function1 != null ? new C10072(function1, items) : null, new AnonymousClass3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10072 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10072(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super T, ? extends Object> function1, List<? extends T> list) {
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

    public static final <T> void items(LazyListScope lazyListScope, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> contentType, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function1 != null ? new C10072(function1, items) : null, new AnonymousClass3(contentType, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, List<? extends T> list) {
            super(4);
            this.$itemContent = function4;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C145@6504L22:LazyDsl.kt#428nma");
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

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, List items, Function1 function1, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function1 != null ? new C10072(function1, items) : null, new AnonymousClass3(C10061.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List items, Function2 function2, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            contentType = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function2 != null ? new C10092(function2, items) : null, new C10103(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10114(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10092 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10092(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10103 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10103(Function2<? super Integer, ? super T, ? extends Object> function2, List<? extends T> list) {
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

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function2 != null ? new C10092(function2, items) : null, new C10103(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10114(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10114 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10114(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, List<? extends T> list) {
            super(4);
            this.$itemContent = function5;
            this.$items = list;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void invoke(LazyItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C180@8213L26:LazyDsl.kt#428nma");
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

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, List items, Function2 function2, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function2 != null ? new C10092(function2, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10114(itemContent, items)));
    }

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] items, Function1 function1, Function1 contentType, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            contentType = AnonymousClass5.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function1 != null ? new AnonymousClass6(function1, items) : null, new AnonymousClass7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$6, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass6 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(Function1<? super T, ? extends Object> function1, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$7, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass7 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function1<? super T, ? extends Object> function1, T[] tArr) {
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

    public static final <T> void items(LazyListScope lazyListScope, T[] items, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> contentType, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function1 != null ? new AnonymousClass6(function1, items) : null, new AnonymousClass7(contentType, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$8, reason: invalid class name */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass8 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
            super(4);
            this.$itemContent = function4;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
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
        public final void invoke(LazyItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C215@9854L22:LazyDsl.kt#428nma");
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

    public static /* synthetic */ void items$default(LazyListScope lazyListScope, Object[] items, Function1 function1, Function4 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function1 != null ? new AnonymousClass6(function1, items) : null, new AnonymousClass7(AnonymousClass5.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] items, Function2 function2, Function2 contentType, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            contentType = new Function2() { // from class: androidx.compose.foundation.lazy.LazyDslKt.itemsIndexed.5
                public final Void invoke(int i2, T t) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), obj3);
                }
            };
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function2 != null ? new C10136(function2, items) : null, new C10147(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10158(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10136 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10136(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10147 extends Lambda implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10147(Function2<? super Integer, ? super T, ? extends Object> function2, T[] tArr) {
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

    public static final <T> void itemsIndexed(LazyListScope lazyListScope, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function2 != null ? new C10136(function2, items) : null, new C10147(contentType, items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10158(itemContent, items)));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LazyDsl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C10158 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10158(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
            super(4);
            this.$itemContent = function5;
            this.$items = tArr;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
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
        public final void invoke(LazyItemScope items, int i, Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            ComposerKt.sourceInformation(composer, "C250@11568L26:LazyDsl.kt#428nma");
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

    public static /* synthetic */ void itemsIndexed$default(LazyListScope lazyListScope, Object[] items, Function2 function2, Function5 itemContent, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function2 != null ? new C10136(function2, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10158(itemContent, items)));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:104:0x013f  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0179 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x017b  */
    /* JADX WARN: Code duplicated, block: B:121:0x0180  */
    /* JADX WARN: Code duplicated, block: B:124:0x0187  */
    /* JADX WARN: Code duplicated, block: B:125:0x018f  */
    /* JADX WARN: Code duplicated, block: B:127:0x0193  */
    /* JADX WARN: Code duplicated, block: B:128:0x019d  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:149:0x01db  */
    /* JADX WARN: Code duplicated, block: B:155:0x024e  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:97:0x0119  */
    public static final void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyListScope, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z3;
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        Alignment.Vertical vertical2;
        int i7;
        FlingBehavior flingBehavior2;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        LazyListState lazyListStateRememberLazyListState;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        boolean z4;
        Arrangement.Horizontal end;
        Alignment.Vertical top;
        FlingBehavior flingBehavior3;
        boolean z5;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        boolean z6;
        Arrangement.Horizontal horizontal3;
        Alignment.Vertical vertical3;
        FlingBehavior flingBehavior4;
        Arrangement arrangement;
        final Modifier modifier2;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues3;
        final boolean z7;
        final Arrangement.Horizontal horizontal4;
        final Alignment.Vertical vertical4;
        final FlingBehavior flingBehavior5;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1724297413);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyRow)P(4,6,1,5,3,8,2,7)291@13992L23,297@14343L15,301@14445L389:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(lazyListState)) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        int i14 = composerStartRestartGroup.changed(horizontal2) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i14;
                } else {
                    horizontal2 = horizontal;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((i & 458752) == 0) {
                        vertical2 = vertical;
                        if (composerStartRestartGroup.changed(vertical2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i & 3670016) == 0) {
                        flingBehavior2 = flingBehavior;
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior2)) {
                            i11 = 524288;
                        } else {
                            i11 = 1048576;
                        }
                        i3 |= i11;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 256) != 0) {
                        if ((234881024 & i) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i10 = 67108864;
                            } else {
                                i10 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i2 & 2) != 0) {
                                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    lazyListStateRememberLazyListState = lazyListState;
                                }
                                if (i13 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                                }
                                z4 = i4 == 0 ? z3 : false;
                                if ((i2 & 16) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        end = arrangement.getEnd();
                                    } else {
                                        end = arrangement.getStart();
                                    }
                                    i3 &= -57345;
                                } else {
                                    end = horizontal2;
                                }
                                if (i6 != 0) {
                                    top = Alignment.INSTANCE.getTop();
                                } else {
                                    top = vertical2;
                                }
                                if ((i2 & 64) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    flingBehavior3 = flingBehavior2;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                lazyListState2 = lazyListStateRememberLazyListState;
                                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                                z6 = z4;
                                horizontal3 = end;
                                vertical3 = top;
                                flingBehavior4 = flingBehavior3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                lazyListState2 = lazyListState;
                                paddingValues2 = paddingValues;
                                z5 = z2;
                                z6 = z3;
                                horizontal3 = horizontal2;
                                flingBehavior4 = flingBehavior2;
                                vertical3 = vertical2;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i15 = i3 >> 3;
                            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i15) | (i15 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                            modifier2 = companion;
                            lazyListState3 = lazyListState2;
                            paddingValues3 = paddingValues2;
                            z7 = z6;
                            horizontal4 = horizontal3;
                            vertical4 = vertical3;
                            flingBehavior5 = flingBehavior4;
                            z8 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState3 = lazyListState;
                            paddingValues3 = paddingValues;
                            z7 = z3;
                            horizontal4 = horizontal2;
                            flingBehavior5 = flingBehavior2;
                            vertical4 = vertical2;
                            z8 = z2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                            public final void invoke(Composer composer2, int i16) {
                                LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i10 = 100663296;
                    i3 |= i10;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i16 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i16) | (i16 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i17 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i17) | (i17 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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
                            LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                vertical2 = vertical;
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i18 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i18) | (i18 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i19 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i19) | (i19 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                        public final void invoke(Composer composer2, int i110) {
                            LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i110 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i110) | (i110 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i111) | (i111 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                    public final void invoke(Composer composer2, int i112) {
                        LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z3 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
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
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((i & 458752) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i112 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i112) | (i112 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i113 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i113) | (i113 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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
                            LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i114 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i114) | (i114 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i115 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i115) | (i115 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                    public final void invoke(Composer composer2, int i116) {
                        LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            vertical2 = vertical;
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i116 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i116) | (i116 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i117 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i117) | (i117 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                    public final void invoke(Composer composer2, int i118) {
                        LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i118 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i118) | (i118 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i119 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i119) | (i119 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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
                    LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
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
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((i & 458752) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1110 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1110) | (i1110 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    end = arrangement.getStart();
                                } else {
                                    end = arrangement.getEnd();
                                }
                                i3 &= -57345;
                            } else {
                                end = horizontal2;
                            }
                            if (i6 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            } else {
                                top = vertical2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            horizontal3 = end;
                            vertical3 = top;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1111) | (i1111 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        horizontal4 = horizontal3;
                        vertical4 = vertical3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                        public final void invoke(Composer composer2, int i1112) {
                            LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1112 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1112) | (i1112 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1113 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1113) | (i1113 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                    public final void invoke(Composer composer2, int i1114) {
                        LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            vertical2 = vertical;
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1114 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1114) | (i1114 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1115 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1115) | (i1115 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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
                        LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i1116 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1116) | (i1116 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i1117 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1117) | (i1117 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                public final void invoke(Composer composer2, int i1118) {
                    LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z3 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
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
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((i & 458752) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1118 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1118) | (i1118 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                end = arrangement.getStart();
                            } else {
                                end = arrangement.getEnd();
                            }
                            i3 &= -57345;
                        } else {
                            end = horizontal2;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        } else {
                            top = vertical2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        horizontal3 = end;
                        vertical3 = top;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1119 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1119) | (i1119 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    horizontal4 = horizontal3;
                    vertical4 = vertical3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                    public final void invoke(Composer composer2, int i11110) {
                        LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11110 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11110) | (i11110 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11111 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11111) | (i11111 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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
                    LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        vertical2 = vertical;
        if ((i & 3670016) == 0) {
            flingBehavior2 = flingBehavior;
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        } else {
            flingBehavior2 = flingBehavior;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i2 & 256) != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11112 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11112) | (i11112 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                    } else {
                        end = horizontal2;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    } else {
                        top = vertical2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    horizontal3 = end;
                    vertical3 = top;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11113 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11113) | (i11113 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                horizontal4 = horizontal3;
                vertical4 = vertical3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

                public final void invoke(Composer composer2, int i11114) {
                    LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i10 = 100663296;
        i3 |= i10;
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior4 = flingBehavior3;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior4 = flingBehavior3;
            }
            composerStartRestartGroup.endDefaults();
            int i11114 = i3 >> 3;
            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11114) | (i11114 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
            modifier2 = companion;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z7 = z6;
            horizontal4 = horizontal3;
            vertical4 = vertical3;
            flingBehavior5 = flingBehavior4;
            z8 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior4 = flingBehavior3;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                } else {
                    end = horizontal2;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                } else {
                    top = vertical2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                horizontal3 = end;
                vertical3 = top;
                flingBehavior4 = flingBehavior3;
            }
            composerStartRestartGroup.endDefaults();
            int i11115 = i3 >> 3;
            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, false, flingBehavior4, z5, null, null, vertical3, horizontal3, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11115) | (i11115 & 3670016) | ((i3 << 12) & 1879048192), ((i3 >> 12) & 14) | ((i3 >> 21) & 112), 384);
            modifier2 = companion;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z7 = z6;
            horizontal4 = horizontal3;
            vertical4 = vertical3;
            flingBehavior5 = flingBehavior4;
            z8 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.1
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

            public final void invoke(Composer composer2, int i11116) {
                LazyDslKt.LazyRow(modifier2, lazyListState3, paddingValues3, z7, horizontal4, vertical4, flingBehavior5, z8, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0126  */
    /* JADX WARN: Code duplicated, block: B:104:0x0140  */
    /* JADX WARN: Code duplicated, block: B:106:0x014d  */
    /* JADX WARN: Code duplicated, block: B:119:0x017a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:121:0x0181  */
    /* JADX WARN: Code duplicated, block: B:124:0x0188  */
    /* JADX WARN: Code duplicated, block: B:125:0x0190  */
    /* JADX WARN: Code duplicated, block: B:127:0x0194  */
    /* JADX WARN: Code duplicated, block: B:128:0x019e  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:149:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:155:0x024d  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x0109  */
    /* JADX WARN: Code duplicated, block: B:92:0x010d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:96:0x0117  */
    /* JADX WARN: Code duplicated, block: B:97:0x011a  */
    public static final void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1<? super LazyListScope, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z3;
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        Alignment.Horizontal horizontal2;
        int i7;
        FlingBehavior flingBehavior2;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        LazyListState lazyListStateRememberLazyListState;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        boolean z4;
        Arrangement.Vertical bottom;
        Alignment.Horizontal start;
        FlingBehavior flingBehavior3;
        boolean z5;
        LazyListState lazyListState2;
        PaddingValues paddingValues2;
        boolean z6;
        Arrangement.Vertical vertical3;
        Alignment.Horizontal horizontal3;
        FlingBehavior flingBehavior4;
        Arrangement arrangement;
        final Modifier modifier2;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues3;
        final boolean z7;
        final Arrangement.Vertical vertical4;
        final Alignment.Horizontal horizontal4;
        final FlingBehavior flingBehavior5;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-740714857);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyColumn)P(4,6,1,5,8,3,2,7)347@16925L23,353@17279L15,357@17381L388:LazyDsl.kt#428nma");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(lazyListState)) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 896) == 0) {
                i3 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        int i14 = composerStartRestartGroup.changed(vertical2) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i14;
                } else {
                    vertical2 = vertical;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((i & 458752) == 0) {
                        horizontal2 = horizontal;
                        if (composerStartRestartGroup.changed(horizontal2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i & 3670016) == 0) {
                        flingBehavior2 = flingBehavior;
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior2)) {
                            i11 = 524288;
                        } else {
                            i11 = 1048576;
                        }
                        i3 |= i11;
                    } else {
                        flingBehavior2 = flingBehavior;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 256) != 0) {
                        if ((i & 234881024) == 0) {
                            if (composerStartRestartGroup.changed(content)) {
                                i10 = 67108864;
                            } else {
                                i10 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if ((i2 & 2) != 0) {
                                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                    i3 &= -113;
                                } else {
                                    lazyListStateRememberLazyListState = lazyListState;
                                }
                                if (i13 != 0) {
                                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                                } else {
                                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                                }
                                z4 = i4 == 0 ? z3 : false;
                                if ((i2 & 16) != 0) {
                                    arrangement = Arrangement.INSTANCE;
                                    if (z4) {
                                        bottom = arrangement.getBottom();
                                    } else {
                                        bottom = arrangement.getTop();
                                    }
                                    i3 &= -57345;
                                } else {
                                    bottom = vertical2;
                                }
                                if (i6 != 0) {
                                    start = Alignment.INSTANCE.getStart();
                                } else {
                                    start = horizontal2;
                                }
                                if ((i2 & 64) != 0) {
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    flingBehavior3 = flingBehavior2;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                lazyListState2 = lazyListStateRememberLazyListState;
                                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                                z6 = z4;
                                vertical3 = bottom;
                                horizontal3 = start;
                                flingBehavior4 = flingBehavior3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                lazyListState2 = lazyListState;
                                paddingValues2 = paddingValues;
                                z5 = z2;
                                z6 = z3;
                                vertical3 = vertical2;
                                flingBehavior4 = flingBehavior2;
                                horizontal3 = horizontal2;
                            }
                            composerStartRestartGroup.endDefaults();
                            int i15 = i3 >> 3;
                            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i15) | (i15 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                            modifier2 = companion;
                            lazyListState3 = lazyListState2;
                            paddingValues3 = paddingValues2;
                            z7 = z6;
                            vertical4 = vertical3;
                            horizontal4 = horizontal3;
                            flingBehavior5 = flingBehavior4;
                            z8 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            lazyListState3 = lazyListState;
                            paddingValues3 = paddingValues;
                            z7 = z3;
                            vertical4 = vertical2;
                            flingBehavior5 = flingBehavior2;
                            horizontal4 = horizontal2;
                            z8 = z2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                            public final void invoke(Composer composer2, int i16) {
                                LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                            }
                        });
                    }
                    i10 = 100663296;
                    i3 |= i10;
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i16 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i16) | (i16 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i17 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i17) | (i17 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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
                            LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                horizontal2 = horizontal;
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i18 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i18) | (i18 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i19 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i19) | (i19 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                        public final void invoke(Composer composer2, int i110) {
                            LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i110 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i110) | (i110 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i111 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i111) | (i111 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                    public final void invoke(Composer composer2, int i112) {
                        LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z3 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
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
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((i & 458752) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i112 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i112) | (i112 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i113 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i113) | (i113 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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
                            LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i114 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i114) | (i114 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i115 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i115) | (i115 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                    public final void invoke(Composer composer2, int i116) {
                        LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            horizontal2 = horizontal;
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i116 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i116) | (i116 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i117 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i117) | (i117 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                    public final void invoke(Composer composer2, int i118) {
                        LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i118 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i118) | (i118 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i119 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i119) | (i119 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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
                    LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
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
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((i & 458752) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i2 & 256) != 0) {
                    if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changed(content)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1110 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1110) | (i1110 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        } else {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                i3 &= -113;
                            } else {
                                lazyListStateRememberLazyListState = lazyListState;
                            }
                            if (i13 != 0) {
                                paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                            } else {
                                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                            }
                            if (i4 == 0) {
                            }
                            if ((i2 & 16) != 0) {
                                arrangement = Arrangement.INSTANCE;
                                if (z4) {
                                    bottom = arrangement.getTop();
                                } else {
                                    bottom = arrangement.getBottom();
                                }
                                i3 &= -57345;
                            } else {
                                bottom = vertical2;
                            }
                            if (i6 != 0) {
                                start = Alignment.INSTANCE.getStart();
                            } else {
                                start = horizontal2;
                            }
                            if ((i2 & 64) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                flingBehavior3 = flingBehavior2;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z6 = z4;
                            vertical3 = bottom;
                            horizontal3 = start;
                            flingBehavior4 = flingBehavior3;
                        }
                        composerStartRestartGroup.endDefaults();
                        int i1111 = i3 >> 3;
                        LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1111) | (i1111 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                        modifier2 = companion;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        vertical4 = vertical3;
                        horizontal4 = horizontal3;
                        flingBehavior5 = flingBehavior4;
                        z8 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                        public final void invoke(Composer composer2, int i1112) {
                            LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                        }
                    });
                }
                i10 = 100663296;
                i3 |= i10;
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1112 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1112) | (i1112 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1113 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1113) | (i1113 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                    public final void invoke(Composer composer2, int i1114) {
                        LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            horizontal2 = horizontal;
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1114 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1114) | (i1114 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1115 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1115) | (i1115 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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
                        LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i1116 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1116) | (i1116 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i1117 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1117) | (i1117 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                public final void invoke(Composer composer2, int i1118) {
                    LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z3 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
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
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((i & 458752) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                flingBehavior2 = flingBehavior;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i2 & 256) != 0) {
                if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1118 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1118) | (i1118 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i13 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        } else {
                            paddingValuesM416PaddingValues0680j_4 = paddingValues;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z4) {
                                bottom = arrangement.getTop();
                            } else {
                                bottom = arrangement.getBottom();
                            }
                            i3 &= -57345;
                        } else {
                            bottom = vertical2;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        } else {
                            start = horizontal2;
                        }
                        if ((i2 & 64) != 0) {
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            flingBehavior3 = flingBehavior2;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z6 = z4;
                        vertical3 = bottom;
                        horizontal3 = start;
                        flingBehavior4 = flingBehavior3;
                    }
                    composerStartRestartGroup.endDefaults();
                    int i1119 = i3 >> 3;
                    LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i1119) | (i1119 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                    modifier2 = companion;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    vertical4 = vertical3;
                    horizontal4 = horizontal3;
                    flingBehavior5 = flingBehavior4;
                    z8 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                    public final void invoke(Composer composer2, int i11110) {
                        LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                    }
                });
            }
            i10 = 100663296;
            i3 |= i10;
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11110 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11110) | (i11110 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11111 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11111) | (i11111 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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
                    LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        horizontal2 = horizontal;
        if ((i & 3670016) == 0) {
            flingBehavior2 = flingBehavior;
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        } else {
            flingBehavior2 = flingBehavior;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i2 & 256) != 0) {
            if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11112 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11112) | (i11112 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i13 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    } else {
                        paddingValuesM416PaddingValues0680j_4 = paddingValues;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z4) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                    } else {
                        bottom = vertical2;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    } else {
                        start = horizontal2;
                    }
                    if ((i2 & 64) != 0) {
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        flingBehavior3 = flingBehavior2;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z6 = z4;
                    vertical3 = bottom;
                    horizontal3 = start;
                    flingBehavior4 = flingBehavior3;
                }
                composerStartRestartGroup.endDefaults();
                int i11113 = i3 >> 3;
                LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11113) | (i11113 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
                modifier2 = companion;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                vertical4 = vertical3;
                horizontal4 = horizontal3;
                flingBehavior5 = flingBehavior4;
                z8 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

                public final void invoke(Composer composer2, int i11114) {
                    LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
                }
            });
        }
        i10 = 100663296;
        i3 |= i10;
        if ((191739611 & i3) == 38347922) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior4 = flingBehavior3;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior4 = flingBehavior3;
            }
            composerStartRestartGroup.endDefaults();
            int i11114 = i3 >> 3;
            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11114) | (i11114 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
            modifier2 = companion;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z7 = z6;
            vertical4 = vertical3;
            horizontal4 = horizontal3;
            flingBehavior5 = flingBehavior4;
            z8 = z5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior4 = flingBehavior3;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i13 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                } else {
                    paddingValuesM416PaddingValues0680j_4 = paddingValues;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z4) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                } else {
                    bottom = vertical2;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                } else {
                    start = horizontal2;
                }
                if ((i2 & 64) != 0) {
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    flingBehavior3 = flingBehavior2;
                }
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                lazyListState2 = lazyListStateRememberLazyListState;
                paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                z6 = z4;
                vertical3 = bottom;
                horizontal3 = start;
                flingBehavior4 = flingBehavior3;
            }
            composerStartRestartGroup.endDefaults();
            int i11115 = i3 >> 3;
            LazyListKt.LazyList(companion, lazyListState2, paddingValues2, z6, true, flingBehavior4, z5, horizontal3, vertical3, null, null, content, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11115) | (i11115 & 3670016) | ((i3 << 6) & 29360128) | ((i3 << 12) & 234881024), (i3 >> 21) & 112, 1536);
            modifier2 = companion;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z7 = z6;
            vertical4 = vertical3;
            horizontal4 = horizontal3;
            flingBehavior5 = flingBehavior4;
            z8 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.1
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

            public final void invoke(Composer composer2, int i11116) {
                LazyDslKt.LazyColumn(modifier2, lazyListState3, paddingValues3, z7, vertical4, horizontal4, flingBehavior5, z8, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0155 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0157  */
    /* JADX WARN: Code duplicated, block: B:112:0x015c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0165  */
    /* JADX WARN: Code duplicated, block: B:116:0x016c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0181  */
    /* JADX WARN: Code duplicated, block: B:125:0x0185  */
    /* JADX WARN: Code duplicated, block: B:126:0x018a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:132:0x019e  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:138:0x0206  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:89:0x0107  */
    /* JADX WARN: Code duplicated, block: B:93:0x011c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0127  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyColumn(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, final Function1 content, Composer composer, final int i, final int i2) {
        int i3;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        int i4;
        boolean z2;
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        Alignment.Horizontal start;
        int i7;
        FlingBehavior flingBehavior2;
        int i8;
        Modifier.Companion companion;
        Modifier modifier2;
        LazyListState lazyListStateRememberLazyListState;
        Modifier modifier3;
        LazyListState lazyListState2;
        FlingBehavior flingBehavior3;
        PaddingValues paddingValues2;
        boolean z3;
        Arrangement arrangement;
        Arrangement.Vertical bottom;
        final Modifier modifier4;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Vertical vertical3;
        final Alignment.Horizontal horizontal2;
        final FlingBehavior flingBehavior4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-563353797);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyColumn)P(4,6,1,5,7,3,2)375@17943L23,381@18297L15,384@18360L350:LazyDsl.kt#428nma");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(lazyListState)) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 896) == 0) {
                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValuesM416PaddingValues0680j_4) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        vertical2 = vertical;
                        int i12 = composerStartRestartGroup.changed(vertical2) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        vertical2 = vertical;
                    }
                    i3 |= i12;
                } else {
                    vertical2 = vertical;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    start = horizontal;
                } else {
                    start = horizontal;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(start)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior2)) {
                        i9 = 524288;
                    } else {
                        i9 = 1048576;
                    }
                    i3 |= i9;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        modifier3 = modifier;
                        lazyListState2 = lazyListState;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        modifier2 = companion;
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i11 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        }
                        if (i4 != 0) {
                            z2 = false;
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z2) {
                                bottom = arrangement.getBottom();
                            } else {
                                bottom = arrangement.getTop();
                            }
                            i3 &= -57345;
                            vertical2 = bottom;
                        }
                        if (i6 != 0) {
                            start = Alignment.INSTANCE.getStart();
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            modifier3 = modifier2;
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z3 = z2;
                        } else {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                        }
                        Arrangement.Vertical vertical4 = vertical2;
                        Alignment.Horizontal horizontal3 = start;
                        composerStartRestartGroup.endDefaults();
                        LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical4, horizontal3, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                        modifier4 = modifier3;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z4 = z3;
                        vertical3 = vertical4;
                        horizontal2 = horizontal3;
                        flingBehavior4 = flingBehavior3;
                    }
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                    Arrangement.Vertical vertical5 = vertical2;
                    Alignment.Horizontal horizontal4 = start;
                    composerStartRestartGroup.endDefaults();
                    LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical5, horizontal4, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z4 = z3;
                    vertical3 = vertical5;
                    horizontal2 = horizontal4;
                    flingBehavior4 = flingBehavior3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    lazyListState3 = lazyListState;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    z4 = z2;
                    flingBehavior4 = flingBehavior2;
                    vertical3 = vertical2;
                    horizontal2 = start;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.2
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

                    public final void invoke(Composer composer2, int i13) {
                        LazyDslKt.LazyColumn(modifier4, lazyListState3, paddingValues3, z4, vertical3, horizontal2, flingBehavior4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i12;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i12;
            } else {
                vertical2 = vertical;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                start = horizontal;
            } else {
                start = horizontal;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                flingBehavior2 = flingBehavior;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Vertical vertical6 = vertical2;
                Alignment.Horizontal horizontal5 = start;
                composerStartRestartGroup.endDefaults();
                LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical6, horizontal5, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                vertical3 = vertical6;
                horizontal2 = horizontal5;
                flingBehavior4 = flingBehavior3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Vertical vertical7 = vertical2;
                Alignment.Horizontal horizontal6 = start;
                composerStartRestartGroup.endDefaults();
                LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical7, horizontal6, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                vertical3 = vertical7;
                horizontal2 = horizontal6;
                flingBehavior4 = flingBehavior3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.2
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

                public final void invoke(Composer composer2, int i13) {
                    LazyDslKt.LazyColumn(modifier4, lazyListState3, paddingValues3, z4, vertical3, horizontal2, flingBehavior4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        paddingValuesM416PaddingValues0680j_4 = paddingValues;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    vertical2 = vertical;
                    if (composerStartRestartGroup.changed(vertical2)) {
                    }
                    i3 |= i12;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i12;
            } else {
                vertical2 = vertical;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                start = horizontal;
            } else {
                start = horizontal;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(start)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                flingBehavior2 = flingBehavior;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Vertical vertical8 = vertical2;
                Alignment.Horizontal horizontal7 = start;
                composerStartRestartGroup.endDefaults();
                LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical8, horizontal7, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                vertical3 = vertical8;
                horizontal2 = horizontal7;
                flingBehavior4 = flingBehavior3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getTop();
                        } else {
                            bottom = arrangement.getBottom();
                        }
                        i3 &= -57345;
                        vertical2 = bottom;
                    }
                    if (i6 != 0) {
                        start = Alignment.INSTANCE.getStart();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Vertical vertical9 = vertical2;
                Alignment.Horizontal horizontal8 = start;
                composerStartRestartGroup.endDefaults();
                LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical9, horizontal8, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                vertical3 = vertical9;
                horizontal2 = horizontal8;
                flingBehavior4 = flingBehavior3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.2
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

                public final void invoke(Composer composer2, int i13) {
                    LazyDslKt.LazyColumn(modifier4, lazyListState3, paddingValues3, z4, vertical3, horizontal2, flingBehavior4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i12;
            } else {
                vertical2 = vertical;
            }
            i3 |= i12;
        } else {
            vertical2 = vertical;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            start = horizontal;
        } else {
            start = horizontal;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(start)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i & 3670016) == 0) {
            flingBehavior2 = flingBehavior;
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        } else {
            flingBehavior2 = flingBehavior;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((29360128 & i) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        }
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            }
            Arrangement.Vertical vertical10 = vertical2;
            Alignment.Horizontal horizontal9 = start;
            composerStartRestartGroup.endDefaults();
            LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical10, horizontal9, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z4 = z3;
            vertical3 = vertical10;
            horizontal2 = horizontal9;
            flingBehavior4 = flingBehavior3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    i3 &= -57345;
                    vertical2 = bottom;
                }
                if (i6 != 0) {
                    start = Alignment.INSTANCE.getStart();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            }
            Arrangement.Vertical vertical11 = vertical2;
            Alignment.Horizontal horizontal10 = start;
            composerStartRestartGroup.endDefaults();
            LazyColumn(modifier3, lazyListState2, paddingValues2, z3, vertical11, horizontal10, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z4 = z3;
            vertical3 = vertical11;
            horizontal2 = horizontal10;
            flingBehavior4 = flingBehavior3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyColumn.2
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

            public final void invoke(Composer composer2, int i13) {
                LazyDslKt.LazyColumn(modifier4, lazyListState3, paddingValues3, z4, vertical3, horizontal2, flingBehavior4, content, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0155 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0157  */
    /* JADX WARN: Code duplicated, block: B:112:0x015c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0165  */
    /* JADX WARN: Code duplicated, block: B:116:0x016c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0181  */
    /* JADX WARN: Code duplicated, block: B:125:0x0185  */
    /* JADX WARN: Code duplicated, block: B:126:0x018a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:132:0x019e  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:138:0x0206  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:89:0x0107  */
    /* JADX WARN: Code duplicated, block: B:93:0x011c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0127  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyRow(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, FlingBehavior flingBehavior, final Function1 content, Composer composer, final int i, final int i2) {
        int i3;
        PaddingValues paddingValuesM416PaddingValues0680j_4;
        int i4;
        boolean z2;
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        Alignment.Vertical top;
        int i7;
        FlingBehavior flingBehavior2;
        int i8;
        Modifier.Companion companion;
        Modifier modifier2;
        LazyListState lazyListStateRememberLazyListState;
        Modifier modifier3;
        LazyListState lazyListState2;
        FlingBehavior flingBehavior3;
        PaddingValues paddingValues2;
        boolean z3;
        Arrangement arrangement;
        Arrangement.Horizontal end;
        final Modifier modifier4;
        final LazyListState lazyListState3;
        final PaddingValues paddingValues3;
        final boolean z4;
        final Arrangement.Horizontal horizontal3;
        final Alignment.Vertical vertical2;
        final FlingBehavior flingBehavior4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(407929823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazyRow)P(4,6,1,5,3,7,2)401@18881L23,407@19232L15,410@19295L347:LazyDsl.kt#428nma");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(lazyListState)) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 896) == 0) {
                paddingValuesM416PaddingValues0680j_4 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValuesM416PaddingValues0680j_4) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0) {
                        horizontal2 = horizontal;
                        int i12 = composerStartRestartGroup.changed(horizontal2) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i3 |= i12;
                } else {
                    horizontal2 = horizontal;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    top = vertical;
                } else {
                    top = vertical;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(top)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                }
                if ((i & 3670016) == 0) {
                    flingBehavior2 = flingBehavior;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(flingBehavior2)) {
                        i9 = 524288;
                    } else {
                        i9 = 1048576;
                    }
                    i3 |= i9;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(content)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        modifier3 = modifier;
                        lazyListState2 = lazyListState;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        modifier2 = companion;
                        if ((i2 & 2) != 0) {
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            i3 &= -113;
                        } else {
                            lazyListStateRememberLazyListState = lazyListState;
                        }
                        if (i11 != 0) {
                            paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                        }
                        if (i4 != 0) {
                            z2 = false;
                        }
                        if ((i2 & 16) != 0) {
                            arrangement = Arrangement.INSTANCE;
                            if (z2) {
                                end = arrangement.getEnd();
                            } else {
                                end = arrangement.getStart();
                            }
                            i3 &= -57345;
                            horizontal2 = end;
                        }
                        if (i6 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            modifier3 = modifier2;
                            flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                            lazyListState2 = lazyListStateRememberLazyListState;
                            paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                            z3 = z2;
                        } else {
                            modifier3 = modifier2;
                            lazyListState2 = lazyListStateRememberLazyListState;
                        }
                        Arrangement.Horizontal horizontal4 = horizontal2;
                        Alignment.Vertical vertical3 = top;
                        composerStartRestartGroup.endDefaults();
                        LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal4, vertical3, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                        modifier4 = modifier3;
                        lazyListState3 = lazyListState2;
                        paddingValues3 = paddingValues2;
                        z4 = z3;
                        horizontal3 = horizontal4;
                        vertical2 = vertical3;
                        flingBehavior4 = flingBehavior3;
                    }
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                    Arrangement.Horizontal horizontal5 = horizontal2;
                    Alignment.Vertical vertical4 = top;
                    composerStartRestartGroup.endDefaults();
                    LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal5, vertical4, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                    modifier4 = modifier3;
                    lazyListState3 = lazyListState2;
                    paddingValues3 = paddingValues2;
                    z4 = z3;
                    horizontal3 = horizontal5;
                    vertical2 = vertical4;
                    flingBehavior4 = flingBehavior3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier;
                    lazyListState3 = lazyListState;
                    paddingValues3 = paddingValuesM416PaddingValues0680j_4;
                    z4 = z2;
                    flingBehavior4 = flingBehavior2;
                    horizontal3 = horizontal2;
                    vertical2 = top;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.2
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

                    public final void invoke(Composer composer2, int i13) {
                        LazyDslKt.LazyRow(modifier4, lazyListState3, paddingValues3, z4, horizontal3, vertical2, flingBehavior4, content, composer2, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i12;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i12;
            } else {
                horizontal2 = horizontal;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                top = vertical;
            } else {
                top = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(top)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                flingBehavior2 = flingBehavior;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Horizontal horizontal6 = horizontal2;
                Alignment.Vertical vertical5 = top;
                composerStartRestartGroup.endDefaults();
                LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal6, vertical5, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                horizontal3 = horizontal6;
                vertical2 = vertical5;
                flingBehavior4 = flingBehavior3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Horizontal horizontal7 = horizontal2;
                Alignment.Vertical vertical6 = top;
                composerStartRestartGroup.endDefaults();
                LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal7, vertical6, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                horizontal3 = horizontal7;
                vertical2 = vertical6;
                flingBehavior4 = flingBehavior3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.2
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

                public final void invoke(Composer composer2, int i13) {
                    LazyDslKt.LazyRow(modifier4, lazyListState3, paddingValues3, z4, horizontal3, vertical2, flingBehavior4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        paddingValuesM416PaddingValues0680j_4 = paddingValues;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 57344) == 0) {
                if ((i2 & 16) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                    }
                    i3 |= i12;
                } else {
                    horizontal2 = horizontal;
                }
                i3 |= i12;
            } else {
                horizontal2 = horizontal;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                top = vertical;
            } else {
                top = vertical;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(top)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 3670016) == 0) {
                flingBehavior2 = flingBehavior;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                flingBehavior2 = flingBehavior;
            }
            if ((i2 & 128) != 0) {
                i3 |= 12582912;
            } else if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(content)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((23967451 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Horizontal horizontal8 = horizontal2;
                Alignment.Vertical vertical7 = top;
                composerStartRestartGroup.endDefaults();
                LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal8, vertical7, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                horizontal3 = horizontal8;
                vertical2 = vertical7;
                flingBehavior4 = flingBehavior3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    modifier2 = companion;
                    if ((i2 & 2) != 0) {
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        i3 &= -113;
                    } else {
                        lazyListStateRememberLazyListState = lazyListState;
                    }
                    if (i11 != 0) {
                        paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            end = arrangement.getStart();
                        } else {
                            end = arrangement.getEnd();
                        }
                        i3 &= -57345;
                        horizontal2 = end;
                    }
                    if (i6 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        modifier3 = modifier2;
                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                    } else {
                        modifier3 = modifier2;
                        lazyListState2 = lazyListStateRememberLazyListState;
                        paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                        z3 = z2;
                        flingBehavior3 = flingBehavior2;
                    }
                }
                Arrangement.Horizontal horizontal9 = horizontal2;
                Alignment.Vertical vertical8 = top;
                composerStartRestartGroup.endDefaults();
                LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal9, vertical8, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
                modifier4 = modifier3;
                lazyListState3 = lazyListState2;
                paddingValues3 = paddingValues2;
                z4 = z3;
                horizontal3 = horizontal9;
                vertical2 = vertical8;
                flingBehavior4 = flingBehavior3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.2
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

                public final void invoke(Composer composer2, int i13) {
                    LazyDslKt.LazyRow(modifier4, lazyListState3, paddingValues3, z4, horizontal3, vertical2, flingBehavior4, content, composer2, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                }
                i3 |= i12;
            } else {
                horizontal2 = horizontal;
            }
            i3 |= i12;
        } else {
            horizontal2 = horizontal;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            top = vertical;
        } else {
            top = vertical;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(top)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
        }
        if ((i & 3670016) == 0) {
            flingBehavior2 = flingBehavior;
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        } else {
            flingBehavior2 = flingBehavior;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((29360128 & i) == 0) {
            if (composerStartRestartGroup.changed(content)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        }
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            }
            Arrangement.Horizontal horizontal10 = horizontal2;
            Alignment.Vertical vertical9 = top;
            composerStartRestartGroup.endDefaults();
            LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal10, vertical9, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z4 = z3;
            horizontal3 = horizontal10;
            vertical2 = vertical9;
            flingBehavior4 = flingBehavior3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                modifier2 = companion;
                if ((i2 & 2) != 0) {
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    i3 &= -113;
                } else {
                    lazyListStateRememberLazyListState = lazyListState;
                }
                if (i11 != 0) {
                    paddingValuesM416PaddingValues0680j_4 = PaddingKt.m416PaddingValues0680j_4(Dp.m3843constructorimpl(0));
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        end = arrangement.getStart();
                    } else {
                        end = arrangement.getEnd();
                    }
                    i3 &= -57345;
                    horizontal2 = end;
                }
                if (i6 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    modifier3 = modifier2;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                } else {
                    modifier3 = modifier2;
                    lazyListState2 = lazyListStateRememberLazyListState;
                    paddingValues2 = paddingValuesM416PaddingValues0680j_4;
                    z3 = z2;
                    flingBehavior3 = flingBehavior2;
                }
            }
            Arrangement.Horizontal horizontal11 = horizontal2;
            Alignment.Vertical vertical10 = top;
            composerStartRestartGroup.endDefaults();
            LazyRow(modifier3, lazyListState2, paddingValues2, z3, horizontal11, vertical10, flingBehavior3, true, content, composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016) | (234881024 & (i3 << 3)), 0);
            modifier4 = modifier3;
            lazyListState3 = lazyListState2;
            paddingValues3 = paddingValues2;
            z4 = z3;
            horizontal3 = horizontal11;
            vertical2 = vertical10;
            flingBehavior4 = flingBehavior3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyDslKt.LazyRow.2
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

            public final void invoke(Composer composer2, int i13) {
                LazyDslKt.LazyRow(modifier4, lazyListState3, paddingValues3, z4, horizontal3, vertical2, flingBehavior4, content, composer2, i | 1, i2);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, List<? extends T> items, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function1 != null ? new C10072(function1, items) : null, new AnonymousClass3(C10061.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-632812321, true, new AnonymousClass4(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.size(), function2 != null ? new C10092(function2, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(items), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new C10114(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope lazyListScope, T[] items, Function1<? super T, ? extends Object> function1, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function1 != null ? new AnonymousClass6(function1, items) : null, new AnonymousClass7(AnonymousClass5.INSTANCE, items), ComposableLambdaKt.composableLambdaInstance(-1043393750, true, new AnonymousClass8(itemContent, items)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope lazyListScope, T[] items, Function2<? super Integer, ? super T, ? extends Object> function2, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        lazyListScope.items(items.length, function2 != null ? new C10136(function2, items) : null, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(items), ComposableLambdaKt.composableLambdaInstance(1600639390, true, new C10158(itemContent, items)));
    }
}
