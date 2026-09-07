package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class LazySemanticsKt$lazyListSemantics$1$indexForKeyMapping$1$key$1 extends FunctionReferenceImpl implements Function1<Integer, Object> {
    LazySemanticsKt$lazyListSemantics$1$indexForKeyMapping$1$key$1(Object obj) {
        super(1, obj, LazyListItemProvider.class, "getKey", "getKey(I)Ljava/lang/Object;", 0);
    }

    public final Object invoke(int i) {
        return ((LazyListItemProvider) this.receiver).getKey(i);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
