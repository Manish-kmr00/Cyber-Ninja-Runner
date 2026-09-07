package com.yandex.div.core.expression.triggers;

import com.yandex.div.json.ParsingExceptionKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConditionPart.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0010H\u0082\bJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/expression/triggers/Result;", "", "input", "", "(Ljava/lang/String;)V", "end", "", "getInput", "()Ljava/lang/String;", "result", "", "Lcom/yandex/div/core/expression/triggers/ConditionPart;", "start", "emit", "", "part", "Lkotlin/Function1;", "emitRaw", "emitVariable", "parse", "", "throwError", "", "message", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class Result {
    private int end;
    private final String input;
    private final List<ConditionPart> result;
    private int start;

    public Result(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.result = new ArrayList();
    }

    public final String getInput() {
        return this.input;
    }

    public final Void throwError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw ParsingExceptionKt.invalidCondition(message, this.input);
    }

    private final void emit(Function1<? super String, ? extends ConditionPart> part) {
        List<ConditionPart> list = this.result;
        String strSubstring = this.input.substring(this.start, this.end);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        list.add(part.invoke(strSubstring));
        this.start = this.end;
    }

    public final List<ConditionPart> parse() {
        State stateInput = State.Start.INSTANCE;
        String str = this.input;
        for (int i = 0; i < str.length(); i++) {
            stateInput = stateInput.input(State.Input.INSTANCE.fromChar(str.charAt(i)), this);
            this.end++;
        }
        stateInput.input(State.Input.EndOfLine, this);
        return this.result;
    }

    public final void emitRaw() {
        List<ConditionPart> list = this.result;
        String strSubstring = this.input.substring(this.start, this.end);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        list.add(new ConditionPart.RawString(strSubstring));
        this.start = this.end;
    }

    public final void emitVariable() {
        List<ConditionPart> list = this.result;
        String strSubstring = this.input.substring(this.start, this.end);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        list.add(new ConditionPart.Variable(strSubstring));
        this.start = this.end;
    }
}
