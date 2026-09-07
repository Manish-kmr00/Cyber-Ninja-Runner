package com.yandex.div.core.expression.triggers;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConditionPart.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000 \u00062\u00020\u0001:\n\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fJ\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\b\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State;", "", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "Companion", "End", "EndOfString", "Function", "Input", "QuotedString", "QuotedStringEscaped", "Raw", "Start", "Variable", "Lcom/yandex/div/core/expression/triggers/State$End;", "Lcom/yandex/div/core/expression/triggers/State$EndOfString;", "Lcom/yandex/div/core/expression/triggers/State$Function;", "Lcom/yandex/div/core/expression/triggers/State$QuotedString;", "Lcom/yandex/div/core/expression/triggers/State$QuotedStringEscaped;", "Lcom/yandex/div/core/expression/triggers/State$Raw;", "Lcom/yandex/div/core/expression/triggers/State$Start;", "Lcom/yandex/div/core/expression/triggers/State$Variable;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
interface State {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final /* synthetic */ Companion INSTANCE = Companion.$$INSTANCE;

    State input(Input input, Result result);

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Start;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Start implements State {
        public static final Start INSTANCE = new Start();

        private Start() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public State input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            return State.INSTANCE.initialInput(input);
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Raw;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Raw implements State {
        public static final Raw INSTANCE = new Raw();

        /* JADX INFO: compiled from: ConditionPart.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Input.values().length];
                try {
                    iArr[Input.Other.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Input.VarSpecial.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Input.OpeningBracket.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Input.EscapeCharacter.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Input.Letter.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Input.SingleQuote.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Input.EndOfLine.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Raw() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public State input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            switch (WhenMappings.$EnumSwitchMapping$0[input.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return INSTANCE;
                case 5:
                    result.emitRaw();
                    return Variable.INSTANCE;
                case 6:
                    result.emitRaw();
                    return QuotedString.INSTANCE;
                case 7:
                    result.emitRaw();
                    return End.INSTANCE;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Variable;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Variable implements State {
        public static final Variable INSTANCE = new Variable();

        /* JADX INFO: compiled from: ConditionPart.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Input.values().length];
                try {
                    iArr[Input.Letter.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Input.VarSpecial.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Input.OpeningBracket.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Input.Other.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Input.EscapeCharacter.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Input.SingleQuote.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Input.EndOfLine.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Variable() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public State input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            switch (WhenMappings.$EnumSwitchMapping$0[input.ordinal()]) {
                case 1:
                case 2:
                    return INSTANCE;
                case 3:
                    return Function.INSTANCE;
                case 4:
                case 5:
                    result.emitVariable();
                    return Raw.INSTANCE;
                case 6:
                    result.emitVariable();
                    return QuotedString.INSTANCE;
                case 7:
                    result.emitVariable();
                    return End.INSTANCE;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Function;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Function implements State {
        public static final Function INSTANCE = new Function();

        private Function() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public State input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            result.emitRaw();
            return State.INSTANCE.initialInput(input);
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$QuotedString;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class QuotedString implements State {
        public static final QuotedString INSTANCE = new QuotedString();

        /* JADX INFO: compiled from: ConditionPart.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Input.values().length];
                try {
                    iArr[Input.Letter.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Input.VarSpecial.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Input.OpeningBracket.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Input.Other.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Input.SingleQuote.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Input.EscapeCharacter.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Input.EndOfLine.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private QuotedString() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public State input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            switch (WhenMappings.$EnumSwitchMapping$0[input.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return INSTANCE;
                case 5:
                    return EndOfString.INSTANCE;
                case 6:
                    return QuotedStringEscaped.INSTANCE;
                case 7:
                    result.throwError("Invalid quoted string");
                    throw new KotlinNothingValueException();
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$QuotedStringEscaped;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$QuotedString;", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class QuotedStringEscaped implements State {
        public static final QuotedStringEscaped INSTANCE = new QuotedStringEscaped();

        /* JADX INFO: compiled from: ConditionPart.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Input.values().length];
                try {
                    iArr[Input.Letter.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Input.VarSpecial.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Input.OpeningBracket.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Input.Other.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Input.EscapeCharacter.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Input.SingleQuote.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Input.EndOfLine.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private QuotedStringEscaped() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public QuotedString input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            switch (WhenMappings.$EnumSwitchMapping$0[input.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return QuotedString.INSTANCE;
                case 7:
                    result.throwError("Invalid escape sequence");
                    throw new KotlinNothingValueException();
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$EndOfString;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EndOfString implements State {
        public static final EndOfString INSTANCE = new EndOfString();

        private EndOfString() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public State input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            result.emitRaw();
            return State.INSTANCE.initialInput(input);
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$End;", "Lcom/yandex/div/core/expression/triggers/State;", "()V", "input", "", "Lcom/yandex/div/core/expression/triggers/State$Input;", "result", "Lcom/yandex/div/core/expression/triggers/Result;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class End implements State {
        public static final End INSTANCE = new End();

        private End() {
        }

        @Override // com.yandex.div.core.expression.triggers.State
        public /* bridge */ /* synthetic */ State input(Input input, Result result) {
            return (State) m6118input(input, result);
        }

        /* JADX INFO: renamed from: input, reason: collision with other method in class */
        public Void m6118input(Input input, Result result) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(result, "result");
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Input;", "", "(Ljava/lang/String;I)V", "Letter", "VarSpecial", "OpeningBracket", "Other", "SingleQuote", "EscapeCharacter", "EndOfLine", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Input {
        Letter,
        VarSpecial,
        OpeningBracket,
        Other,
        SingleQuote,
        EscapeCharacter,
        EndOfLine;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: ConditionPart.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Input$Companion;", "", "()V", "fromChar", "Lcom/yandex/div/core/expression/triggers/State$Input;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Input fromChar(char c) {
                if (('A' <= c && c < '[') || (('a' <= c && c < '{') || c == '_')) {
                    return Input.Letter;
                }
                if (c == '.' || ('0' <= c && c < ':')) {
                    return Input.VarSpecial;
                }
                if (c == '(') {
                    return Input.OpeningBracket;
                }
                if (c == '\'') {
                    return Input.SingleQuote;
                }
                if (c == '\\') {
                    return Input.EscapeCharacter;
                }
                return Input.Other;
            }
        }
    }

    /* JADX INFO: compiled from: ConditionPart.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/expression/triggers/State$Companion;", "", "()V", "initialInput", "Lcom/yandex/div/core/expression/triggers/State;", "input", "Lcom/yandex/div/core/expression/triggers/State$Input;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: compiled from: ConditionPart.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Input.values().length];
                try {
                    iArr[Input.Letter.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Input.VarSpecial.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Input.OpeningBracket.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Input.Other.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Input.EscapeCharacter.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Input.SingleQuote.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Input.EndOfLine.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final State initialInput(Input input) {
            switch (WhenMappings.$EnumSwitchMapping$0[input.ordinal()]) {
                case 1:
                    return Variable.INSTANCE;
                case 2:
                case 3:
                case 4:
                case 5:
                    return Raw.INSTANCE;
                case 6:
                    return QuotedString.INSTANCE;
                case 7:
                    return End.INSTANCE;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}
