package com.yandex.div.core.view2.logging.patch;

import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.Log;
import com.yandex.div2.DivPatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PatchEventReporterProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/view2/logging/patch/PatchEventReporterProvider;", "", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "(Lcom/yandex/div/core/view2/Div2View;)V", "get", "Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter;", DivActionHandler.DivActionReason.PATCH, "Lcom/yandex/div2/DivPatch;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PatchEventReporterProvider {
    private final Div2View div2View;

    public PatchEventReporterProvider(Div2View div2View) {
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        this.div2View = div2View;
    }

    public final PatchEventReporter get(DivPatch patch) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        if (Log.isEnabled()) {
            return new PatchEventReporterImpl(this.div2View, patch);
        }
        return PatchEventReporter.INSTANCE.getSTUB();
    }
}
