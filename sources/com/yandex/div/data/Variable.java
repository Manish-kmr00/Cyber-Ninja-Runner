package com.yandex.div.data;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.div.core.ObserverList;
import com.yandex.div.evaluable.types.Color;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.parser.ParsingConvertersKt;
import com.yandex.div.internal.util.ConvertUtilsKt;
import com.yandex.div2.BoolVariable;
import com.yandex.div2.NumberVariable;
import com.yandex.div2.StrVariable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Variable.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b()*+,-./B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\u0001H\u0016J\b\u0010\u000e\u001a\u00020\u0001H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0000H\u0014J\u001c\u0010\u0011\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0017J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0000H\u0017J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0001H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0004H\u0012J\u001c\u0010\u001b\u001a\u00020\u001c*\u00020\u0004H\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u001f\u001a\u00020 *\u00020\u0004H\u0012J\f\u0010!\u001a\u00020\"*\u00020\u0004H\u0012J\f\u0010#\u001a\u00020\u0018*\u00020\u0004H\u0012J\f\u0010$\u001a\u00020%*\u00020\u0004H\u0012J\f\u0010&\u001a\u00020'*\u00020\u0004H\u0012R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t0\bX\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0001\b01234567\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/yandex/div/data/Variable;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "observers", "Lcom/yandex/div/core/ObserverList;", "Lkotlin/Function1;", "", "addObserver", "observer", "getDefaultValue", "getValue", "notifyVariableChanged", "v", "removeObserver", "set", "newValue", "setValue", TypedValues.TransitionType.S_FROM, "setValueDirectly", "writeToJSON", "Lorg/json/JSONObject;", "parseAsBoolean", "", "parseAsColor", "Lcom/yandex/div/evaluable/types/Color;", "parseAsColor-C4zCDoM", "(Ljava/lang/String;)I", "parseAsDouble", "", "parseAsInt", "", "parseAsJsonObject", "parseAsLong", "", "parseAsUri", "Landroid/net/Uri;", "ArrayVariable", "BooleanVariable", "ColorVariable", "DictVariable", "DoubleVariable", "IntegerVariable", "StringVariable", "UrlVariable", "Lcom/yandex/div/data/Variable$ArrayVariable;", "Lcom/yandex/div/data/Variable$BooleanVariable;", "Lcom/yandex/div/data/Variable$ColorVariable;", "Lcom/yandex/div/data/Variable$DictVariable;", "Lcom/yandex/div/data/Variable$DoubleVariable;", "Lcom/yandex/div/data/Variable$IntegerVariable;", "Lcom/yandex/div/data/Variable$StringVariable;", "Lcom/yandex/div/data/Variable$UrlVariable;", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Variable {
    private final ObserverList<Function1<Variable, Unit>> observers;

    public /* synthetic */ Variable(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getName();

    private Variable() {
        this.observers = new ObserverList<>();
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R$\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/yandex/div/data/Variable$StringVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;)V", "getDefaultValue", "()Ljava/lang/String;", "getName", "value", "getValue$div_data_release", "setValue$div_data_release", "(Ljava/lang/String;)V", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class StringVariable extends Variable {
        private final String defaultValue;
        private final String name;
        private String value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.Variable
        public String getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringVariable(String name, String defaultValue) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            this.name = name;
            this.defaultValue = defaultValue;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public String getValue() {
            return this.value;
        }

        public void setValue$div_data_release(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(this.value, value)) {
                return;
            }
            this.value = value;
            notifyVariableChanged(this);
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/data/Variable$IntegerVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "", "(Ljava/lang/String;J)V", "getDefaultValue", "()J", "getName", "()Ljava/lang/String;", "value", "getValue$div_data_release", "setValue$div_data_release", "(J)V", "set", "", "newValue", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class IntegerVariable extends Variable {
        private final long defaultValue;
        private final String name;
        private long value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        public long getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegerVariable(String name, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.defaultValue = j;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public long getValue() {
            return this.value;
        }

        public void setValue$div_data_release(long j) {
            if (this.value == j) {
                return;
            }
            this.value = j;
            notifyVariableChanged(this);
        }

        public void set(long newValue) {
            setValue$div_data_release(newValue);
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/data/Variable$BooleanVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "", "(Ljava/lang/String;Z)V", "getDefaultValue", "()Z", "getName", "()Ljava/lang/String;", "value", "getValue$div_data_release", "setValue$div_data_release", "(Z)V", "set", "", "newValue", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class BooleanVariable extends Variable {
        private final boolean defaultValue;
        private final String name;
        private boolean value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        public boolean getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BooleanVariable(String name, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.defaultValue = z;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public boolean getValue() {
            return this.value;
        }

        public void setValue$div_data_release(boolean z) {
            if (this.value == z) {
                return;
            }
            this.value = z;
            notifyVariableChanged(this);
        }

        public void set(boolean newValue) {
            setValue$div_data_release(newValue);
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/data/Variable$DoubleVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "", "(Ljava/lang/String;D)V", "getDefaultValue", "()D", "getName", "()Ljava/lang/String;", "value", "getValue$div_data_release", "setValue$div_data_release", "(D)V", "set", "", "newValue", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class DoubleVariable extends Variable {
        private final double defaultValue;
        private final String name;
        private double value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        public double getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoubleVariable(String name, double d) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.defaultValue = d;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public double getValue() {
            return this.value;
        }

        public void setValue$div_data_release(double d) {
            if (this.value == d) {
                return;
            }
            this.value = d;
            notifyVariableChanged(this);
        }

        public void set(double newValue) {
            setValue$div_data_release(newValue);
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR/\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@PX\u0090\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/data/Variable$ColorVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "", "(Ljava/lang/String;I)V", "getDefaultValue", "()I", "getName", "()Ljava/lang/String;", "value", "Lcom/yandex/div/evaluable/types/Color;", "getValue-WpymAT4$div_data_release", "setValue-cIhhviA$div_data_release", "(I)V", "I", "set", "", "newValue", "set-cIhhviA", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class ColorVariable extends Variable {
        private final int defaultValue;
        private final String name;
        private int value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        public int getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorVariable(String name, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.defaultValue = i;
            this.value = Color.m6218constructorimpl(getDefaultValue());
        }

        /* JADX INFO: renamed from: getValue-WpymAT4$div_data_release, reason: not valid java name and from getter */
        public int getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: setValue-cIhhviA$div_data_release, reason: not valid java name */
        public void m6162setValuecIhhviA$div_data_release(int i) {
            if (Color.m6220equalsimpl0(this.value, i)) {
                return;
            }
            this.value = i;
            notifyVariableChanged(this);
        }

        /* JADX INFO: renamed from: set-cIhhviA, reason: not valid java name */
        public void m6161setcIhhviA(int newValue) throws VariableMutationException {
            Integer numInvoke = ParsingConvertersKt.STRING_TO_COLOR_INT.invoke(Color.m6217boximpl(newValue));
            if (numInvoke == null) {
                throw new VariableMutationException("Wrong value format for color variable: '" + ((Object) Color.m6224toStringimpl(newValue)) + '\'', null, 2, null);
            }
            m6162setValuecIhhviA$div_data_release(Color.m6218constructorimpl(numInvoke.intValue()));
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/data/Variable$UrlVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;)V", "getDefaultValue", "()Landroid/net/Uri;", "getName", "()Ljava/lang/String;", "value", "getValue$div_data_release", "setValue$div_data_release", "(Landroid/net/Uri;)V", "set", "", "newValue", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class UrlVariable extends Variable {
        private final Uri defaultValue;
        private final String name;
        private Uri value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.Variable
        public Uri getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UrlVariable(String name, Uri defaultValue) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            this.name = name;
            this.defaultValue = defaultValue;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public Uri getValue() {
            return this.value;
        }

        public void setValue$div_data_release(Uri value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(this.value, value)) {
                return;
            }
            this.value = value;
            notifyVariableChanged(this);
        }

        public void set(Uri newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            setValue$div_data_release(newValue);
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/data/Variable$DictVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getDefaultValue", "()Lorg/json/JSONObject;", "getName", "()Ljava/lang/String;", "value", "getValue$div_data_release", "setValue$div_data_release", "(Lorg/json/JSONObject;)V", "set", "", "newValue", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class DictVariable extends Variable {
        private final JSONObject defaultValue;
        private final String name;
        private JSONObject value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.Variable
        public JSONObject getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DictVariable(String name, JSONObject defaultValue) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            this.name = name;
            this.defaultValue = defaultValue;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public JSONObject getValue() {
            return this.value;
        }

        public void setValue$div_data_release(JSONObject value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(this.value, value)) {
                return;
            }
            this.value = value;
            notifyVariableChanged(this);
        }

        public void set(JSONObject newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            setValue$div_data_release(newValue);
        }
    }

    /* JADX INFO: compiled from: Variable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/data/Variable$ArrayVariable;", "Lcom/yandex/div/data/Variable;", "name", "", "defaultValue", "Lorg/json/JSONArray;", "(Ljava/lang/String;Lorg/json/JSONArray;)V", "getDefaultValue", "()Lorg/json/JSONArray;", "getName", "()Ljava/lang/String;", "value", "getValue$div_data_release", "setValue$div_data_release", "(Lorg/json/JSONArray;)V", "set", "", "newValue", "div-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class ArrayVariable extends Variable {
        private final JSONArray defaultValue;
        private final String name;
        private JSONArray value;

        @Override // com.yandex.div.data.Variable
        public String getName() {
            return this.name;
        }

        @Override // com.yandex.div.data.Variable
        public JSONArray getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayVariable(String name, JSONArray defaultValue) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            this.name = name;
            this.defaultValue = defaultValue;
            this.value = getDefaultValue();
        }

        /* JADX INFO: renamed from: getValue$div_data_release, reason: from getter */
        public JSONArray getValue() {
            return this.value;
        }

        public void setValue$div_data_release(JSONArray value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(this.value, value)) {
                return;
            }
            this.value = value;
            notifyVariableChanged(this);
        }

        public void set(JSONArray newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            setValue$div_data_release(newValue);
        }
    }

    public Object getValue() {
        if (this instanceof StringVariable) {
            return ((StringVariable) this).getValue();
        }
        if (this instanceof IntegerVariable) {
            return Long.valueOf(((IntegerVariable) this).getValue());
        }
        if (this instanceof BooleanVariable) {
            return Boolean.valueOf(((BooleanVariable) this).getValue());
        }
        if (this instanceof DoubleVariable) {
            return Double.valueOf(((DoubleVariable) this).getValue());
        }
        if (this instanceof ColorVariable) {
            return Color.m6217boximpl(((ColorVariable) this).getValue());
        }
        if (this instanceof UrlVariable) {
            return ((UrlVariable) this).getValue();
        }
        if (this instanceof DictVariable) {
            return ((DictVariable) this).getValue();
        }
        if (this instanceof ArrayVariable) {
            return ((ArrayVariable) this).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public Object getDefaultValue() {
        if (this instanceof StringVariable) {
            return ((StringVariable) this).getDefaultValue();
        }
        if (this instanceof IntegerVariable) {
            return Long.valueOf(((IntegerVariable) this).getDefaultValue());
        }
        if (this instanceof BooleanVariable) {
            return Boolean.valueOf(((BooleanVariable) this).getDefaultValue());
        }
        if (this instanceof DoubleVariable) {
            return Double.valueOf(((DoubleVariable) this).getDefaultValue());
        }
        if (this instanceof ColorVariable) {
            return Integer.valueOf(((ColorVariable) this).getDefaultValue());
        }
        if (this instanceof UrlVariable) {
            return ((UrlVariable) this).getDefaultValue();
        }
        if (this instanceof DictVariable) {
            return ((DictVariable) this).getDefaultValue();
        }
        if (this instanceof ArrayVariable) {
            return ((ArrayVariable) this).getDefaultValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    public void addObserver(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.addObserver(observer);
    }

    public void removeObserver(Function1<? super Variable, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.removeObserver(observer);
    }

    protected void notifyVariableChanged(Variable v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Assert.assertMainThread();
        Iterator<Function1<Variable, Unit>> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().invoke(v);
        }
    }

    public void set(String newValue) throws VariableMutationException {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (this instanceof StringVariable) {
            ((StringVariable) this).setValue$div_data_release(newValue);
            return;
        }
        if (this instanceof IntegerVariable) {
            ((IntegerVariable) this).setValue$div_data_release(parseAsLong(newValue));
            return;
        }
        if (this instanceof BooleanVariable) {
            ((BooleanVariable) this).setValue$div_data_release(parseAsBoolean(newValue));
            return;
        }
        if (this instanceof DoubleVariable) {
            ((DoubleVariable) this).setValue$div_data_release(parseAsDouble(newValue));
            return;
        }
        if (this instanceof ColorVariable) {
            ((ColorVariable) this).m6162setValuecIhhviA$div_data_release(m6159parseAsColorC4zCDoM(newValue));
            return;
        }
        if (this instanceof UrlVariable) {
            ((UrlVariable) this).setValue$div_data_release(parseAsUri(newValue));
        } else if (this instanceof DictVariable) {
            ((DictVariable) this).setValue$div_data_release(parseAsJsonObject(newValue));
        } else {
            if (!(this instanceof ArrayVariable)) {
                throw new NoWhenBranchMatchedException();
            }
            throw new VariableMutationException("Url action set_variable not allowed for arrays, use property \"typed\" instead", null, 2, null);
        }
    }

    public void setValue(Variable from) throws VariableMutationException {
        Intrinsics.checkNotNullParameter(from, "from");
        if ((this instanceof StringVariable) && (from instanceof StringVariable)) {
            ((StringVariable) this).setValue$div_data_release(((StringVariable) from).getValue());
            return;
        }
        if ((this instanceof IntegerVariable) && (from instanceof IntegerVariable)) {
            ((IntegerVariable) this).setValue$div_data_release(((IntegerVariable) from).getValue());
            return;
        }
        if ((this instanceof BooleanVariable) && (from instanceof BooleanVariable)) {
            ((BooleanVariable) this).setValue$div_data_release(((BooleanVariable) from).getValue());
            return;
        }
        if ((this instanceof DoubleVariable) && (from instanceof DoubleVariable)) {
            ((DoubleVariable) this).setValue$div_data_release(((DoubleVariable) from).getValue());
            return;
        }
        if ((this instanceof ColorVariable) && (from instanceof ColorVariable)) {
            ((ColorVariable) this).m6162setValuecIhhviA$div_data_release(((ColorVariable) from).getValue());
            return;
        }
        if ((this instanceof UrlVariable) && (from instanceof UrlVariable)) {
            ((UrlVariable) this).setValue$div_data_release(((UrlVariable) from).getValue());
            return;
        }
        if ((this instanceof DictVariable) && (from instanceof DictVariable)) {
            ((DictVariable) this).setValue$div_data_release(((DictVariable) from).getValue());
        } else {
            if (!(this instanceof ArrayVariable) || !(from instanceof ArrayVariable)) {
                throw new VariableMutationException("Setting value to " + this + " from " + from + " not supported!", null, 2, null);
            }
            ((ArrayVariable) this).setValue$div_data_release(((ArrayVariable) from).getValue());
        }
    }

    public void setValueDirectly(Object newValue) throws VariableMutationException {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        try {
            if (this instanceof StringVariable) {
                ((StringVariable) this).setValue$div_data_release((String) newValue);
                return;
            }
            if (this instanceof IntegerVariable) {
                ((IntegerVariable) this).setValue$div_data_release(((Number) newValue).longValue());
                return;
            }
            if (this instanceof BooleanVariable) {
                ((BooleanVariable) this).setValue$div_data_release(((Boolean) newValue).booleanValue());
                return;
            }
            if (this instanceof DoubleVariable) {
                ((DoubleVariable) this).setValue$div_data_release(((Number) newValue).doubleValue());
                return;
            }
            if (this instanceof ColorVariable) {
                ((ColorVariable) this).m6162setValuecIhhviA$div_data_release(((Color) newValue).m6225unboximpl());
                return;
            }
            if (this instanceof UrlVariable) {
                ((UrlVariable) this).setValue$div_data_release((Uri) newValue);
            } else if (this instanceof DictVariable) {
                ((DictVariable) this).setValue$div_data_release((JSONObject) newValue);
            } else {
                if (!(this instanceof ArrayVariable)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((ArrayVariable) this).setValue$div_data_release((JSONArray) newValue);
            }
        } catch (ClassCastException unused) {
            throw new VariableMutationException("Unable to set value with type " + newValue.getClass() + " to " + this, null, 2, null);
        }
    }

    private long parseAsLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new VariableMutationException(null, e, 1, null);
        }
    }

    private int parseAsInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new VariableMutationException(null, e, 1, null);
        }
    }

    private boolean parseAsBoolean(String str) {
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str);
        if (booleanStrictOrNull == null && (booleanStrictOrNull = ConvertUtilsKt.toBoolean(parseAsInt(str))) == null) {
            throw new VariableMutationException("Unable to convert " + str + " to boolean", null, 2, null);
        }
        return booleanStrictOrNull.booleanValue();
    }

    private double parseAsDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new VariableMutationException(null, e, 1, null);
        }
    }

    /* JADX INFO: renamed from: parseAsColor-C4zCDoM, reason: not valid java name */
    private int m6159parseAsColorC4zCDoM(String str) {
        Integer numInvoke = ParsingConvertersKt.STRING_TO_COLOR_INT.invoke(str);
        if (numInvoke == null) {
            throw new VariableMutationException("Wrong value format for color variable: '" + str + '\'', null, 2, null);
        }
        return Color.m6218constructorimpl(numInvoke.intValue());
    }

    private Uri parseAsUri(String str) {
        try {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(uri, "{\n            Uri.parse(this)\n        }");
            return uri;
        } catch (IllegalArgumentException e) {
            throw new VariableMutationException(null, e, 1, null);
        }
    }

    private JSONObject parseAsJsonObject(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            throw new VariableMutationException(null, e, 1, null);
        }
    }

    public JSONObject writeToJSON() throws JSONException {
        com.yandex.div2.UrlVariable urlVariable;
        if (this instanceof ArrayVariable) {
            urlVariable = new com.yandex.div2.ArrayVariable(getName(), ((ArrayVariable) this).getValue());
        } else if (this instanceof BooleanVariable) {
            urlVariable = new BoolVariable(getName(), ((BooleanVariable) this).getValue());
        } else if (this instanceof ColorVariable) {
            urlVariable = new com.yandex.div2.ColorVariable(getName(), ((ColorVariable) this).getValue());
        } else if (this instanceof DictVariable) {
            urlVariable = new com.yandex.div2.DictVariable(getName(), ((DictVariable) this).getValue());
        } else if (this instanceof DoubleVariable) {
            urlVariable = new NumberVariable(getName(), ((DoubleVariable) this).getValue());
        } else if (this instanceof IntegerVariable) {
            urlVariable = new com.yandex.div2.IntegerVariable(getName(), ((IntegerVariable) this).getValue());
        } else if (this instanceof StringVariable) {
            urlVariable = new StrVariable(getName(), ((StringVariable) this).getValue());
        } else {
            if (!(this instanceof UrlVariable)) {
                throw new NoWhenBranchMatchedException();
            }
            urlVariable = new com.yandex.div2.UrlVariable(getName(), ((UrlVariable) this).getValue());
        }
        JSONObject jSONObjectWriteToJSON = urlVariable.writeToJSON();
        Intrinsics.checkNotNullExpressionValue(jSONObjectWriteToJSON, "serializable.writeToJSON()");
        return jSONObjectWriteToJSON;
    }
}
