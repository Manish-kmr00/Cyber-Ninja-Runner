package com.yandex.div.core.timer;

import com.json.sdk.controller.f;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.DivActionBinder;
import com.yandex.div.core.view2.errors.ErrorCollector;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivTimer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimerController.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\fJ\u0010\u0010 \u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\fJ\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010%\u001a\u00020\u001bJ\b\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020#H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/yandex/div/core/timer/TimerController;", "", "divTimer", "Lcom/yandex/div2/DivTimer;", "divActionBinder", "Lcom/yandex/div/core/view2/divs/DivActionBinder;", "errorCollector", "Lcom/yandex/div/core/view2/errors/ErrorCollector;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Lcom/yandex/div2/DivTimer;Lcom/yandex/div/core/view2/divs/DivActionBinder;Lcom/yandex/div/core/view2/errors/ErrorCollector;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "getDivTimer", "()Lcom/yandex/div2/DivTimer;", "endActions", "", "Lcom/yandex/div2/DivAction;", "id", "", "savedForBackground", "", "tickActions", "ticker", "Lcom/yandex/div/core/timer/Ticker;", "valueVariable", "applyCommand", "", f.b.COMMAND, "isAttachedToView", "view", "onAttach", "onDetach", "onEnd", "time", "", "onTick", TimerController.RESET_COMMAND, "updateTimer", "updateTimerVariable", "value", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimerController {
    public static final String CANCEL_COMMAND = "cancel";
    public static final String PAUSE_COMMAND = "pause";
    public static final String RESET_COMMAND = "reset";
    public static final String RESUME_COMMAND = "resume";
    public static final String START_COMMAND = "start";
    public static final String STOP_COMMAND = "stop";
    private Div2View div2View;
    private final DivActionBinder divActionBinder;
    private final DivTimer divTimer;
    private final List<DivAction> endActions;
    private final ErrorCollector errorCollector;
    private final ExpressionResolver expressionResolver;
    private final String id;
    private boolean savedForBackground;
    private final List<DivAction> tickActions;
    private final Ticker ticker;
    private final String valueVariable;

    public TimerController(DivTimer divTimer, DivActionBinder divActionBinder, ErrorCollector errorCollector, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(divTimer, "divTimer");
        Intrinsics.checkNotNullParameter(divActionBinder, "divActionBinder");
        Intrinsics.checkNotNullParameter(errorCollector, "errorCollector");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        this.divTimer = divTimer;
        this.divActionBinder = divActionBinder;
        this.errorCollector = errorCollector;
        this.expressionResolver = expressionResolver;
        String str = divTimer.id;
        this.id = str;
        this.valueVariable = divTimer.valueVariable;
        this.endActions = divTimer.endActions;
        this.tickActions = divTimer.tickActions;
        this.ticker = new Ticker(str, new TimerController$ticker$1(this), new TimerController$ticker$2(this), new TimerController$ticker$3(this), new TimerController$ticker$4(this), errorCollector);
        divTimer.duration.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.timer.TimerController.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                TimerController.this.updateTimer();
            }
        });
        Expression<Long> expression = divTimer.tickInterval;
        if (expression != null) {
            expression.observeAndGet(expressionResolver, new Function1<Long, Unit>() { // from class: com.yandex.div.core.timer.TimerController.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke(l.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j) {
                    TimerController.this.updateTimer();
                }
            });
        }
    }

    public final DivTimer getDivTimer() {
        return this.divTimer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimer() {
        Ticker ticker = this.ticker;
        long jLongValue = this.divTimer.duration.evaluate(this.expressionResolver).longValue();
        Expression<Long> expression = this.divTimer.tickInterval;
        ticker.update(jLongValue, expression != null ? expression.evaluate(this.expressionResolver) : null);
    }

    public final void onAttach(Div2View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.div2View = view;
        if (this.savedForBackground) {
            this.ticker.restoreState(true);
            this.savedForBackground = false;
        }
    }

    public final void onDetach(Div2View view) {
        if (Intrinsics.areEqual(view, this.div2View)) {
            reset();
        }
    }

    public final void reset() {
        this.div2View = null;
        this.ticker.saveState();
        this.savedForBackground = true;
    }

    public final boolean isAttachedToView(Div2View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return Intrinsics.areEqual(view, this.div2View);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void applyCommand(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        switch (command.hashCode()) {
            case -1367724422:
                if (command.equals(CANCEL_COMMAND)) {
                    this.ticker.cancel();
                    return;
                }
                break;
            case -934426579:
                if (command.equals("resume")) {
                    this.ticker.resume();
                    return;
                }
                break;
            case 3540994:
                if (command.equals(STOP_COMMAND)) {
                    this.ticker.stop();
                    return;
                }
                break;
            case 106440182:
                if (command.equals("pause")) {
                    this.ticker.pause();
                    return;
                }
                break;
            case 108404047:
                if (command.equals(RESET_COMMAND)) {
                    this.ticker.reset();
                    return;
                }
                break;
            case 109757538:
                if (command.equals("start")) {
                    this.ticker.start();
                    return;
                }
                break;
        }
        this.errorCollector.logError(new IllegalArgumentException(command + " is unsupported timer command!"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTick(long time) {
        updateTimerVariable(time);
        Div2View div2View = this.div2View;
        if (div2View != null) {
            DivActionBinder.handleActions$div_release$default(this.divActionBinder, div2View, div2View.getExpressionResolver(), this.tickActions, "timer", null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEnd(long time) {
        updateTimerVariable(time);
        Div2View div2View = this.div2View;
        if (div2View != null) {
            DivActionBinder.handleActions$div_release$default(this.divActionBinder, div2View, div2View.getExpressionResolver(), this.endActions, "timer", null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimerVariable(long value) {
        Div2View div2View;
        String str = this.valueVariable;
        if (str == null || (div2View = this.div2View) == null) {
            return;
        }
        div2View.setVariable(str, String.valueOf(value));
    }
}
