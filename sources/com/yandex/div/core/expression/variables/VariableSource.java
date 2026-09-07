package com.yandex.div.core.expression.variables;

import com.yandex.div.data.Variable;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\n\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000bH&J\u001c\u0010\f\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000bH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\u000e\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/expression/variables/VariableSource;", "", "getMutableVariable", "Lcom/yandex/div/data/Variable;", "name", "", "observeDeclaration", "", "observer", "Lcom/yandex/div/core/expression/variables/DeclarationObserver;", "observeVariables", "Lkotlin/Function1;", "receiveVariablesUpdates", "removeDeclarationObserver", "removeVariablesObserver", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface VariableSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Variable getMutableVariable(String name);

    void observeDeclaration(DeclarationObserver observer);

    void observeVariables(Function1<? super Variable, Unit> observer);

    void receiveVariablesUpdates(Function1<? super Variable, Unit> observer);

    void removeDeclarationObserver(DeclarationObserver observer);

    void removeVariablesObserver(Function1<? super Variable, Unit> observer);

    /* JADX INFO: compiled from: VariableSource.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086\u0002¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/expression/variables/VariableSource$Companion;", "", "()V", "invoke", "Lcom/yandex/div/core/expression/variables/VariableSource;", "variables", "", "", "Lcom/yandex/div/data/Variable;", "requestObserver", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "variableName", "", "declarationObservers", "", "Lcom/yandex/div/core/expression/variables/DeclarationObserver;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final VariableSource invoke(Map<String, ? extends Variable> variables, Function1<? super String, Unit> requestObserver, Collection<DeclarationObserver> declarationObservers) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            Intrinsics.checkNotNullParameter(requestObserver, "requestObserver");
            Intrinsics.checkNotNullParameter(declarationObservers, "declarationObservers");
            return new SingleVariableSource(variables, requestObserver, declarationObservers);
        }
    }
}
