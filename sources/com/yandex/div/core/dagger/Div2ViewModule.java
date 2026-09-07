package com.yandex.div.core.dagger;

import com.yandex.div.core.experiments.Experiment;
import com.yandex.div.core.view2.state.DivJoinedStateSwitcher;
import com.yandex.div.core.view2.state.DivMultipleStateSwitcher;
import com.yandex.div.core.view2.state.DivStateSwitcher;
import com.yandex.yatagan.Module;
import com.yandex.yatagan.Provides;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Div2ViewModule.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0007¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/dagger/Div2ViewModule;", "", "()V", "provideStateSwitcher", "Lcom/yandex/div/core/view2/state/DivStateSwitcher;", "multipleStateChangeEnabled", "", "joinedStateSwitcher", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/state/DivJoinedStateSwitcher;", "multipleStateSwitcher", "Lcom/yandex/div/core/view2/state/DivMultipleStateSwitcher;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module
public final class Div2ViewModule {
    public static final Div2ViewModule INSTANCE = new Div2ViewModule();

    private Div2ViewModule() {
    }

    @DivViewScope
    @JvmStatic
    @Provides
    public static final DivStateSwitcher provideStateSwitcher(@ExperimentFlag(experiment = Experiment.MULTIPLE_STATE_CHANGE_ENABLED) boolean multipleStateChangeEnabled, Provider<DivJoinedStateSwitcher> joinedStateSwitcher, Provider<DivMultipleStateSwitcher> multipleStateSwitcher) {
        DivStateSwitcher divStateSwitcher;
        String str;
        Intrinsics.checkNotNullParameter(joinedStateSwitcher, "joinedStateSwitcher");
        Intrinsics.checkNotNullParameter(multipleStateSwitcher, "multipleStateSwitcher");
        if (multipleStateChangeEnabled) {
            divStateSwitcher = multipleStateSwitcher.get();
            str = "multipleStateSwitcher.get()";
        } else {
            divStateSwitcher = joinedStateSwitcher.get();
            str = "joinedStateSwitcher.get()";
        }
        Intrinsics.checkNotNullExpressionValue(divStateSwitcher, str);
        return divStateSwitcher;
    }
}
