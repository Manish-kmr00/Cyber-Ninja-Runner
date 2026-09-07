package com.yandex.div.core.view2.logging.bind;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.logging.EventMessageBuilder;
import com.yandex.div.core.view2.reuse.RebindTask;
import com.yandex.div2.DivData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BindingEventReporterImpl.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0014\u0010 \u001a\u00020\n2\n\u0010\u001b\u001a\u00060!j\u0002`\"H\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/yandex/div/core/view2/logging/bind/BindingEventReporterImpl;", "Lcom/yandex/div/core/view2/logging/EventMessageBuilder;", "Lcom/yandex/div/core/view2/logging/bind/BindingEventReporter;", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "oldData", "Lcom/yandex/div2/DivData;", "newData", "(Lcom/yandex/div/core/view2/Div2View;Lcom/yandex/div2/DivData;Lcom/yandex/div2/DivData;)V", "onBindingFatalNoData", "", "onBindingFatalNoState", "onBindingFatalSameData", "onComparisonDifferentChildCount", "onComparisonDifferentClasses", "onComparisonDifferentCustomTypes", "onComparisonDifferentIdsWithTransition", "onComparisonDifferentOverlap", "onComparisonDifferentWrap", "onComparisonNoOldData", "onComparisonNoState", "onComplexRebindFatalNoState", "onComplexRebindNoDivInState", "onComplexRebindNoExistingParent", "onComplexRebindNothingToBind", "onComplexRebindSuccess", "onComplexRebindUnsupportedElementException", "e", "Lcom/yandex/div/core/view2/reuse/RebindTask$UnsupportedElementException;", "onFirstBindingCompleted", "onForceRebindFatalNoState", "onForceRebindSuccess", "onSimpleRebindException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSimpleRebindFatalNoState", "onSimpleRebindNoChild", "onSimpleRebindSuccess", "onStateUpdateCompleted", "sendLog", "result", "", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BindingEventReporterImpl extends EventMessageBuilder implements BindingEventReporter {
    private static final String EVENT_COMPARISON_FAILED = "Div comparison failed";
    private static final String EVENT_COMPLEX_REBIND_FAILED = "Complex rebind failed";
    private static final String EVENT_SIMPLE_REBIND_FAILED = "Simple rebind failed";
    private static final String MESSAGE_FATAL_NO_STATE = "Div has no state to bind";
    private final Div2View div2View;
    private final DivData newData;
    private final DivData oldData;

    public BindingEventReporterImpl(Div2View div2View, DivData divData, DivData divData2) {
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        this.div2View = div2View;
        this.oldData = divData;
        this.newData = divData2;
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonNoOldData() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "No old `DivData` to compare with");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonNoState() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "Cannot find required state of `DivData`");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonDifferentClasses() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "For some element its old and new java classes are not equal");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonDifferentIdsWithTransition() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "Some element has changed its `id` while has transitions");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonDifferentCustomTypes() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "Some `DivCustom` element has different `customType`");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonDifferentOverlap() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "Some element has changed its `orientation` from/to 'overlap'");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonDifferentWrap() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "Some element has changed its `layoutMode` from/to 'wrap'");
    }

    @Override // com.yandex.div.core.view2.animations.DivComparatorReporter
    public void onComparisonDifferentChildCount() {
        appendEventMessage(EVENT_COMPARISON_FAILED, "Some element changed its child count");
    }

    @Override // com.yandex.div.core.view2.reuse.ComplexRebindReporter
    public void onComplexRebindSuccess() {
        sendLog("Performed complex rebind");
    }

    @Override // com.yandex.div.core.view2.reuse.ComplexRebindReporter
    public void onComplexRebindNothingToBind() {
        appendEventMessage(EVENT_COMPLEX_REBIND_FAILED, "Cannot find any difference to bind");
    }

    @Override // com.yandex.div.core.view2.reuse.ComplexRebindReporter
    public void onComplexRebindUnsupportedElementException(RebindTask.UnsupportedElementException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        appendEventMessage("Complex rebind failed with exception", Reflection.getOrCreateKotlinClass(e.getClass()) + " (" + e.getMessage() + ')');
    }

    @Override // com.yandex.div.core.view2.reuse.ComplexRebindReporter
    public void onComplexRebindFatalNoState() {
        sendLog(MESSAGE_FATAL_NO_STATE);
    }

    @Override // com.yandex.div.core.view2.reuse.ComplexRebindReporter
    public void onComplexRebindNoDivInState() {
        appendEventMessage(EVENT_COMPLEX_REBIND_FAILED, "Cannot find div inside state to bind");
    }

    @Override // com.yandex.div.core.view2.reuse.ComplexRebindReporter
    public void onComplexRebindNoExistingParent() {
        appendEventMessage(EVENT_COMPLEX_REBIND_FAILED, "Cannot find any existing view to start binding");
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindSuccess() {
        sendLog("Performed simple rebind");
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindNoChild() {
        appendEventMessage(EVENT_SIMPLE_REBIND_FAILED, "Div2View has no child to rebind");
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindFatalNoState() {
        sendLog(MESSAGE_FATAL_NO_STATE);
    }

    @Override // com.yandex.div.core.view2.logging.bind.SimpleRebindReporter
    public void onSimpleRebindException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        appendEventMessage("Simple rebind failed with exception", Reflection.getOrCreateKotlinClass(e.getClass()) + " (" + e.getMessage() + ')');
    }

    @Override // com.yandex.div.core.view2.logging.bind.ForceRebindReporter
    public void onForceRebindSuccess() {
        sendLog("Performed unoptimized rebind. Old data was cleaned up");
    }

    @Override // com.yandex.div.core.view2.logging.bind.ForceRebindReporter
    public void onForceRebindFatalNoState() {
        sendLog(MESSAGE_FATAL_NO_STATE);
    }

    @Override // com.yandex.div.core.view2.logging.bind.ForceRebindReporter
    public void onFirstBindingCompleted() {
        sendLog("DivData bound for the first time");
    }

    @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
    public void onStateUpdateCompleted() {
        sendLog("Performed state update");
    }

    @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
    public void onBindingFatalNoData() {
        sendLog("Binding failed. New DivData not provided");
    }

    @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
    public void onBindingFatalNoState() {
        sendLog("Binding failed. Cannot find state to bind");
    }

    @Override // com.yandex.div.core.view2.logging.bind.BindingEventReporter
    public void onBindingFatalSameData() {
        sendLog("No actions performed. Old and new DivData are the same");
    }

    private final void sendLog(String result) {
        this.div2View.getDiv2Component().getDiv2Logger().logBindingResult(this.div2View, this.oldData, this.newData, result, buildEventsLogMessage());
    }
}
