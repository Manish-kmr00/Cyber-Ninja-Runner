package com.yandex.div.evaluable;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/FunctionProvider;", "", "get", "Lcom/yandex/div/evaluable/Function;", "name", "", "args", "", "Lcom/yandex/div/evaluable/EvaluableType;", "getMethod", "Companion", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface FunctionProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final FunctionProvider STUB = new FunctionProvider() { // from class: com.yandex.div.evaluable.FunctionProvider$Companion$STUB$1
        @Override // com.yandex.div.evaluable.FunctionProvider
        public Function get(String name, List<? extends EvaluableType> args) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(args, "args");
            return Function.STUB;
        }

        @Override // com.yandex.div.evaluable.FunctionProvider
        public Function getMethod(String name, List<? extends EvaluableType> args) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(args, "args");
            return Function.STUB;
        }
    };

    Function get(String name, List<? extends EvaluableType> args);

    Function getMethod(String name, List<? extends EvaluableType> args);

    /* JADX INFO: compiled from: FunctionProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/FunctionProvider$Companion;", "", "()V", "STUB", "Lcom/yandex/div/evaluable/FunctionProvider;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
