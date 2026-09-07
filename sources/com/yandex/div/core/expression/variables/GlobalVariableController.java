package com.yandex.div.core.expression.variables;

import com.yandex.div.data.Variable;
import com.yandex.div.data.VariableDeclarationException;
import com.yandex.div.data.VariableMutationException;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalVariableController.kt */
/* JADX INFO: loaded from: classes13.dex */
@Deprecated(message = "Do not use this class")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u000bJ\u001f\u0010\f\u001a\u00020\u00072\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\nJ\u001f\u0010\u0015\u001a\u00020\u00072\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0016\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/expression/variables/GlobalVariableController;", "", "delegate", "Lcom/yandex/div/core/expression/variables/DivVariableController;", "(Lcom/yandex/div/core/expression/variables/DivVariableController;)V", "()Lcom/yandex/div/core/expression/variables/DivVariableController;", "addVariableRequestObserver", "", "observer", "Lkotlin/Function1;", "", "Lcom/yandex/div/core/expression/variables/VariableRequestObserver;", "declare", "variables", "", "Lcom/yandex/div/data/Variable;", "([Lcom/yandex/div/data/Variable;)V", "get", "variableName", "isDeclared", "", "putOrUpdate", "removeVariableRequestObserver", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GlobalVariableController {
    private final DivVariableController delegate;

    public GlobalVariableController() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GlobalVariableController(DivVariableController delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public /* synthetic */ GlobalVariableController(DivVariableController divVariableController, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DivVariableController(null, 1, null) : divVariableController);
    }

    /* JADX INFO: renamed from: delegate, reason: from getter */
    public final DivVariableController getDelegate() {
        return this.delegate;
    }

    public final void declare(Variable... variables) throws VariableDeclarationException {
        Intrinsics.checkNotNullParameter(variables, "variables");
        this.delegate.declare((Variable[]) Arrays.copyOf(variables, variables.length));
    }

    public final Variable get(String variableName) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        return this.delegate.get(variableName);
    }

    public final boolean isDeclared(String variableName) {
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        return this.delegate.isDeclared(variableName);
    }

    public final void putOrUpdate(Variable... variables) throws VariableMutationException {
        Intrinsics.checkNotNullParameter(variables, "variables");
        this.delegate.putOrUpdate((Variable[]) Arrays.copyOf(variables, variables.length));
    }

    public final void addVariableRequestObserver(Function1<? super String, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.delegate.addVariableRequestObserver(observer);
    }

    public final void removeVariableRequestObserver(Function1<? super String, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.delegate.removeVariableRequestObserver(observer);
    }
}
