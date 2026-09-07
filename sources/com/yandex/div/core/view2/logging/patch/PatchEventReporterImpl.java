package com.yandex.div.core.view2.logging.patch;

import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.logging.EventMessageBuilder;
import com.yandex.div2.DivPatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PatchEventReporterImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u000b\u001a\u00020\t2\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/logging/patch/PatchEventReporterImpl;", "Lcom/yandex/div/core/view2/logging/EventMessageBuilder;", "Lcom/yandex/div/core/view2/logging/patch/PatchEventReporter;", "div2View", "Lcom/yandex/div/core/view2/Div2View;", DivActionHandler.DivActionReason.PATCH, "Lcom/yandex/div2/DivPatch;", "(Lcom/yandex/div/core/view2/Div2View;Lcom/yandex/div2/DivPatch;)V", "onPatchNoState", "", "onPatchSuccess", "onSimpleRebindException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSimpleRebindFatalNoState", "onSimpleRebindNoChild", "sendLog", "result", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PatchEventReporterImpl extends EventMessageBuilder implements PatchEventReporter {
    private static final String EVENT_SIMPLE_REBIND_FAILED = "Simple rebind failed";
    private final Div2View div2View;
    private final DivPatch patch;

    public PatchEventReporterImpl(Div2View div2View, DivPatch patch) {
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(patch, "patch");
        this.div2View = div2View;
        this.patch = patch;
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindNoChild() {
        appendEventMessage(EVENT_SIMPLE_REBIND_FAILED, "Div2View has no child to rebind");
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindFatalNoState() {
        appendEventMessage(EVENT_SIMPLE_REBIND_FAILED, "Div has no state to bind");
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        appendEventMessage("Simple rebind failed with exception", Reflection.getOrCreateKotlinClass(e.getClass()) + " (" + e.getMessage() + ')');
    }

    @Override // com.yandex.div.core.view2.logging.patch.PatchEventReporter
    public void onPatchSuccess() {
        sendLog("Div patched successfully");
    }

    @Override // com.yandex.div.core.view2.logging.patch.PatchEventReporter
    public void onPatchNoState() {
        sendLog("Patch not performed. Cannot find state to bind");
    }

    private final void sendLog(@PatchResult String result) {
        this.div2View.getDiv2Component().getDiv2Logger().logPatchResult(this.div2View, this.patch, result, buildEventsLogMessage());
    }
}
