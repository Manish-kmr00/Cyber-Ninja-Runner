package com.yandex.div.evaluable.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.l;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: compiled from: Token.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\t\u0007\b\t\n\u000b\f\r\u000e\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token;", "", "Bracket", "Function", "Operand", "Operator", "StringTemplate", "Lcom/yandex/div/evaluable/internal/Token$Bracket;", "Lcom/yandex/div/evaluable/internal/Token$Function;", "Lcom/yandex/div/evaluable/internal/Token$Function$ArgumentDelimiter;", "Lcom/yandex/div/evaluable/internal/Token$Operand;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "Lcom/yandex/div/evaluable/internal/Token$StringTemplate$End;", "Lcom/yandex/div/evaluable/internal/Token$StringTemplate$EndOfExpression;", "Lcom/yandex/div/evaluable/internal/Token$StringTemplate$Start;", "Lcom/yandex/div/evaluable/internal/Token$StringTemplate$StartOfExpression;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Token {

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0003\u0004\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operand;", "Lcom/yandex/div/evaluable/internal/Token;", "Literal", "Variable", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "Lcom/yandex/div/evaluable/internal/Token$Operand$Variable;", "Lcom/yandex/div/evaluable/internal/Token$StringTemplate;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Operand extends Token {

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "Lcom/yandex/div/evaluable/internal/Token$Operand;", "Bool", "Num", "Str", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal$Bool;", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal$Num;", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal$Str;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public interface Literal extends Operand {

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operand$Literal$Num;", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "value", "", "constructor-impl", "(Ljava/lang/Number;)Ljava/lang/Number;", "getValue", "()Ljava/lang/Number;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/Number;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Number;)I", "toString", "", "toString-impl", "(Ljava/lang/Number;)Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            @JvmInline
            public static final class Num implements Literal {
                private final Number value;

                /* JADX INFO: renamed from: box-impl, reason: not valid java name */
                public static final /* synthetic */ Num m6192boximpl(Number number) {
                    return new Num(number);
                }

                /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
                public static Number m6193constructorimpl(Number value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return value;
                }

                /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
                public static boolean m6194equalsimpl(Number number, Object obj) {
                    return (obj instanceof Num) && Intrinsics.areEqual(number, ((Num) obj).m6198unboximpl());
                }

                /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
                public static final boolean m6195equalsimpl0(Number number, Number number2) {
                    return Intrinsics.areEqual(number, number2);
                }

                /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
                public static int m6196hashCodeimpl(Number number) {
                    return number.hashCode();
                }

                /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
                public static String m6197toStringimpl(Number number) {
                    return "Num(value=" + number + ')';
                }

                public boolean equals(Object obj) {
                    return m6194equalsimpl(this.value, obj);
                }

                public int hashCode() {
                    return m6196hashCodeimpl(this.value);
                }

                public String toString() {
                    return m6197toStringimpl(this.value);
                }

                /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
                public final /* synthetic */ Number m6198unboximpl() {
                    return this.value;
                }

                private /* synthetic */ Num(Number number) {
                    this.value = number;
                }

                public final Number getValue() {
                    return this.value;
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operand$Literal$Bool;", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "value", "", "constructor-impl", "(Z)Z", "getValue", "()Z", "equals", "other", "", "equals-impl", "(ZLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Z)I", "toString", "", "toString-impl", "(Z)Ljava/lang/String;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            @JvmInline
            public static final class Bool implements Literal {
                private final boolean value;

                /* JADX INFO: renamed from: box-impl, reason: not valid java name */
                public static final /* synthetic */ Bool m6185boximpl(boolean z) {
                    return new Bool(z);
                }

                /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
                public static boolean m6186constructorimpl(boolean z) {
                    return z;
                }

                /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
                public static boolean m6187equalsimpl(boolean z, Object obj) {
                    return (obj instanceof Bool) && z == ((Bool) obj).m6191unboximpl();
                }

                /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
                public static final boolean m6188equalsimpl0(boolean z, boolean z2) {
                    return z == z2;
                }

                /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
                public static int m6189hashCodeimpl(boolean z) {
                    if (z) {
                        return 1;
                    }
                    return z ? 1 : 0;
                }

                /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
                public static String m6190toStringimpl(boolean z) {
                    return "Bool(value=" + z + ')';
                }

                public boolean equals(Object obj) {
                    return m6187equalsimpl(this.value, obj);
                }

                public int hashCode() {
                    return m6189hashCodeimpl(this.value);
                }

                public String toString() {
                    return m6190toStringimpl(this.value);
                }

                /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
                public final /* synthetic */ boolean m6191unboximpl() {
                    return this.value;
                }

                private /* synthetic */ Bool(boolean z) {
                    this.value = z;
                }

                public final boolean getValue() {
                    return this.value;
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operand$Literal$Str;", "Lcom/yandex/div/evaluable/internal/Token$Operand$Literal;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            @JvmInline
            public static final class Str implements Literal {
                private final String value;

                /* JADX INFO: renamed from: box-impl, reason: not valid java name */
                public static final /* synthetic */ Str m6199boximpl(String str) {
                    return new Str(str);
                }

                /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
                public static String m6200constructorimpl(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    return value;
                }

                /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
                public static boolean m6201equalsimpl(String str, Object obj) {
                    return (obj instanceof Str) && Intrinsics.areEqual(str, ((Str) obj).m6205unboximpl());
                }

                /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
                public static final boolean m6202equalsimpl0(String str, String str2) {
                    return Intrinsics.areEqual(str, str2);
                }

                /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
                public static int m6203hashCodeimpl(String str) {
                    return str.hashCode();
                }

                /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
                public static String m6204toStringimpl(String str) {
                    return "Str(value=" + str + ')';
                }

                public boolean equals(Object obj) {
                    return m6201equalsimpl(this.value, obj);
                }

                public int hashCode() {
                    return m6203hashCodeimpl(this.value);
                }

                public String toString() {
                    return m6204toStringimpl(this.value);
                }

                /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
                public final /* synthetic */ String m6205unboximpl() {
                    return this.value;
                }

                private /* synthetic */ Str(String str) {
                    this.value = str;
                }

                public final String getValue() {
                    return this.value;
                }
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operand$Variable;", "Lcom/yandex/div/evaluable/internal/Token$Operand;", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @JvmInline
        public static final class Variable implements Operand {
            private final String name;

            /* JADX INFO: renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ Variable m6206boximpl(String str) {
                return new Variable(str);
            }

            /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
            public static String m6207constructorimpl(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return name;
            }

            /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
            public static boolean m6208equalsimpl(String str, Object obj) {
                return (obj instanceof Variable) && Intrinsics.areEqual(str, ((Variable) obj).m6212unboximpl());
            }

            /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m6209equalsimpl0(String str, String str2) {
                return Intrinsics.areEqual(str, str2);
            }

            /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
            public static int m6210hashCodeimpl(String str) {
                return str.hashCode();
            }

            /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
            public static String m6211toStringimpl(String str) {
                return "Variable(name=" + str + ')';
            }

            public boolean equals(Object obj) {
                return m6208equalsimpl(this.name, obj);
            }

            public int hashCode() {
                return m6210hashCodeimpl(this.name);
            }

            public String toString() {
                return m6211toStringimpl(this.name);
            }

            /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
            public final /* synthetic */ String m6212unboximpl() {
                return this.name;
            }

            private /* synthetic */ Variable(String str) {
                this.name = str;
            }

            public final String getName() {
                return this.name;
            }
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator;", "Lcom/yandex/div/evaluable/internal/Token;", "Binary", "Dot", "TernaryElse", "TernaryIf", "TernaryIfElse", "Try", "Unary", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Dot;", "Lcom/yandex/div/evaluable/internal/Token$Operator$TernaryElse;", "Lcom/yandex/div/evaluable/internal/Token$Operator$TernaryIf;", "Lcom/yandex/div/evaluable/internal/Token$Operator$TernaryIfElse;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Try;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Operator extends Token {

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Unary;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "Minus", "Not", "Plus", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary$Minus;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary$Not;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary$Plus;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public interface Unary extends Operator {

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Unary$Plus;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Plus implements Unary {
                public static final Plus INSTANCE = new Plus();

                private Plus() {
                }

                public String toString() {
                    return Marker.ANY_NON_NULL_MARKER;
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Unary$Minus;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Minus implements Unary {
                public static final Minus INSTANCE = new Minus();

                private Minus() {
                }

                public String toString() {
                    return "-";
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Unary$Not;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Unary;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Not implements Unary {
                public static final Not INSTANCE = new Not();

                private Not() {
                }

                public String toString() {
                    return "!";
                }
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "Comparison", "Equality", "Factor", "Logical", "Power", "Sum", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Power;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public interface Binary extends Operator {

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "Minus", "Plus", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum$Minus;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum$Plus;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public interface Sum extends Binary {

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum$Plus;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Plus implements Sum {
                    public static final Plus INSTANCE = new Plus();

                    private Plus() {
                    }

                    public String toString() {
                        return Marker.ANY_NON_NULL_MARKER;
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum$Minus;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Sum;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Minus implements Sum {
                    public static final Minus INSTANCE = new Minus();

                    private Minus() {
                    }

                    public String toString() {
                        return "-";
                    }
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "Division", "Modulo", "Multiplication", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor$Division;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor$Modulo;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor$Multiplication;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public interface Factor extends Binary {

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor$Multiplication;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Multiplication implements Factor {
                    public static final Multiplication INSTANCE = new Multiplication();

                    private Multiplication() {
                    }

                    public String toString() {
                        return "*";
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor$Division;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Division implements Factor {
                    public static final Division INSTANCE = new Division();

                    private Division() {
                    }

                    public String toString() {
                        return RemoteSettings.FORWARD_SLASH_STRING;
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor$Modulo;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Factor;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Modulo implements Factor {
                    public static final Modulo INSTANCE = new Modulo();

                    private Modulo() {
                    }

                    public String toString() {
                        return "%";
                    }
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Power;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Power implements Binary {
                public static final Power INSTANCE = new Power();

                private Power() {
                }

                public String toString() {
                    return "^";
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "And", "Or", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical$And;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical$Or;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public interface Logical extends Binary {

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical$And;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class And implements Logical {
                    public static final And INSTANCE = new And();

                    private And() {
                    }

                    public String toString() {
                        return "&&";
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical$Or;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Logical;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Or implements Logical {
                    public static final Or INSTANCE = new Or();

                    private Or() {
                    }

                    public String toString() {
                        return l.ac;
                    }
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "Greater", "GreaterOrEqual", "Less", "LessOrEqual", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$Greater;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$GreaterOrEqual;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$Less;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$LessOrEqual;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public interface Comparison extends Binary {

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$Greater;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Greater implements Comparison {
                    public static final Greater INSTANCE = new Greater();

                    private Greater() {
                    }

                    public String toString() {
                        return ">";
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$GreaterOrEqual;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class GreaterOrEqual implements Comparison {
                    public static final GreaterOrEqual INSTANCE = new GreaterOrEqual();

                    private GreaterOrEqual() {
                    }

                    public String toString() {
                        return ">=";
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$Less;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Less implements Comparison {
                    public static final Less INSTANCE = new Less();

                    private Less() {
                    }

                    public String toString() {
                        return "<";
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison$LessOrEqual;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Comparison;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class LessOrEqual implements Comparison {
                    public static final LessOrEqual INSTANCE = new LessOrEqual();

                    private LessOrEqual() {
                    }

                    public String toString() {
                        return "<=";
                    }
                }
            }

            /* JADX INFO: compiled from: Token.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary;", "Equal", "NotEqual", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality$Equal;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality$NotEqual;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public interface Equality extends Binary {

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality$Equal;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class Equal implements Equality {
                    public static final Equal INSTANCE = new Equal();

                    private Equal() {
                    }

                    public String toString() {
                        return "==";
                    }
                }

                /* JADX INFO: compiled from: Token.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality$NotEqual;", "Lcom/yandex/div/evaluable/internal/Token$Operator$Binary$Equality;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public static final class NotEqual implements Equality {
                    public static final NotEqual INSTANCE = new NotEqual();

                    private NotEqual() {
                    }

                    public String toString() {
                        return "!=";
                    }
                }
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Try;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Try implements Operator {
            public static final Try INSTANCE = new Try();

            private Try() {
            }

            public String toString() {
                return "!:";
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$Dot;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Dot implements Operator {
            public static final Dot INSTANCE = new Dot();

            private Dot() {
            }

            public String toString() {
                return ".";
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$TernaryIf;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class TernaryIf implements Operator {
            public static final TernaryIf INSTANCE = new TernaryIf();

            private TernaryIf() {
            }

            public String toString() {
                return "?";
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$TernaryElse;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class TernaryElse implements Operator {
            public static final TernaryElse INSTANCE = new TernaryElse();

            private TernaryElse() {
            }

            public String toString() {
                return ":";
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Operator$TernaryIfElse;", "Lcom/yandex/div/evaluable/internal/Token$Operator;", "()V", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class TernaryIfElse implements Operator {
            public static final TernaryIfElse INSTANCE = new TernaryIfElse();

            private TernaryIfElse() {
            }
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Function;", "Lcom/yandex/div/evaluable/internal/Token;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ArgumentDelimiter", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Function implements Token {
        private final String name;

        public static /* synthetic */ Function copy$default(Function function, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = function.name;
            }
            return function.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Function copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Function(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Function) && Intrinsics.areEqual(this.name, ((Function) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Function(name=" + this.name + ')';
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Function$ArgumentDelimiter;", "Lcom/yandex/div/evaluable/internal/Token;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class ArgumentDelimiter implements Token {
            public static final ArgumentDelimiter INSTANCE = new ArgumentDelimiter();

            private ArgumentDelimiter() {
            }

            public String toString() {
                return StringUtils.COMMA;
            }
        }

        public Function(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$StringTemplate;", "Lcom/yandex/div/evaluable/internal/Token$Operand;", "()V", "End", "EndOfExpression", "Start", "StartOfExpression", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StringTemplate implements Operand {
        public static final StringTemplate INSTANCE = new StringTemplate();

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$StringTemplate$Start;", "Lcom/yandex/div/evaluable/internal/Token;", "()V", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Start implements Token {
            public static final Start INSTANCE = new Start();

            private Start() {
            }
        }

        private StringTemplate() {
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$StringTemplate$End;", "Lcom/yandex/div/evaluable/internal/Token;", "()V", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class End implements Token {
            public static final End INSTANCE = new End();

            private End() {
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$StringTemplate$StartOfExpression;", "Lcom/yandex/div/evaluable/internal/Token;", "()V", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class StartOfExpression implements Token {
            public static final StartOfExpression INSTANCE = new StartOfExpression();

            private StartOfExpression() {
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$StringTemplate$EndOfExpression;", "Lcom/yandex/div/evaluable/internal/Token;", "()V", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class EndOfExpression implements Token {
            public static final EndOfExpression INSTANCE = new EndOfExpression();

            private EndOfExpression() {
            }
        }
    }

    /* JADX INFO: compiled from: Token.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Bracket;", "Lcom/yandex/div/evaluable/internal/Token;", "LeftRound", "RightRound", "Lcom/yandex/div/evaluable/internal/Token$Bracket$LeftRound;", "Lcom/yandex/div/evaluable/internal/Token$Bracket$RightRound;", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Bracket extends Token {

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Bracket$LeftRound;", "Lcom/yandex/div/evaluable/internal/Token$Bracket;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class LeftRound implements Bracket {
            public static final LeftRound INSTANCE = new LeftRound();

            private LeftRound() {
            }

            public String toString() {
                return "(";
            }
        }

        /* JADX INFO: compiled from: Token.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/evaluable/internal/Token$Bracket$RightRound;", "Lcom/yandex/div/evaluable/internal/Token$Bracket;", "()V", "toString", "", "div-evaluable"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class RightRound implements Bracket {
            public static final RightRound INSTANCE = new RightRound();

            private RightRound() {
            }

            public String toString() {
                return ")";
            }
        }
    }
}
