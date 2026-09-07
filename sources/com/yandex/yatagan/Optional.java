package com.yandex.yatagan;

import java.util.NoSuchElementException;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Optional.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0003&'(B\u0011\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u000b\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ-\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000J\u001b\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0002\b\u000eJE\u0010\u0014\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0086\bø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000J#\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00020\u0018H\u0007¢\u0006\u0002\b\u0014J?\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0000\"\b\b\u0001\u0010\u001a*\u00020\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H\u001a0\u0011H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000J3\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0000\"\b\b\u0001\u0010\u001a*\u00020\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H\u001a0\u001dH\u0007¢\u0006\u0002\b\u0019J,\u0010\u001e\u001a\u00028\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010 J\u0013\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\u00028\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0007¢\u0006\u0004\b\u001e\u0010$J\r\u0010%\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R \u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Lcom/yandex/yatagan/Optional;", "T", "", "value", "(Ljava/lang/Object;)V", "isPresent", "", "()Z", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "get", "ifPresent", "", "consumer", "Lkotlin/Function1;", "ifPresentJava", "Lcom/yandex/yatagan/Optional$Consumer;", "ifPresentOrElse", "onEmpty", "Lkotlin/Function0;", "ifPresentOrElseJava", "Ljava/lang/Runnable;", "map", "U", "mapper", "mapJava", "Lcom/yandex/yatagan/Optional$Function;", "orElse", "alternative", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "orElseJava", "Ljavax/inject/Provider;", "(Ljavax/inject/Provider;)Ljava/lang/Object;", "orNull", "Companion", "Consumer", "Function", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Optional<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Optional Empty = new Optional(null);
    private final T value;

    /* JADX INFO: compiled from: Optional.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/yatagan/Optional$Consumer;", "T", "", "accept", "", "value", "(Ljava/lang/Object;)V", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Consumer<T> {
        void accept(T value);
    }

    /* JADX INFO: compiled from: Optional.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0000*\u0006\b\u0002\u0010\u0002 \u00012\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00022\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/yandex/yatagan/Optional$Function;", "T", "R", "", "apply", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Function<T, R> {
        R apply(T value);
    }

    public /* synthetic */ Optional(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    @JvmStatic
    public static final <T> Optional<T> empty() {
        return INSTANCE.empty();
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    @JvmStatic
    public static final <T> Optional<T> of(T t) {
        return INSTANCE.of(t);
    }

    @JvmStatic
    public static final <T> Optional<T> ofNullable(T t) {
        return INSTANCE.ofNullable(t);
    }

    private Optional(T t) {
        this.value = t;
    }

    public final T getValue() {
        return this.value;
    }

    public final T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public final T orNull() {
        return this.value;
    }

    public final boolean isPresent() {
        return this.value != null;
    }

    public final T orElse(T alternative) {
        Intrinsics.checkNotNullParameter(alternative, "alternative");
        T t = this.value;
        return t == null ? alternative : t;
    }

    public final T orElse(Provider<T> alternative) {
        Intrinsics.checkNotNullParameter(alternative, "alternative");
        T t = this.value;
        if (t != null) {
            return t;
        }
        T t2 = alternative.get();
        Intrinsics.checkNotNullExpressionValue(t2, "alternative.get()");
        return t2;
    }

    public final /* synthetic */ void ifPresent(Function1<? super T, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        T value = getValue();
        if (value != null) {
            consumer.invoke(value);
        }
    }

    public final /* synthetic */ void ifPresentOrElse(Function1<? super T, Unit> consumer, Function0<Unit> onEmpty) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(onEmpty, "onEmpty");
        if (getValue() != null) {
            consumer.invoke(getValue());
        } else {
            onEmpty.invoke();
        }
    }

    public final /* synthetic */ <U> Optional<U> map(Function1<? super T, ? extends U> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return getValue() != null ? INSTANCE.ofNullable(mapper.invoke(getValue())) : INSTANCE.empty();
    }

    public final /* synthetic */ T orElse(Function0<? extends T> alternative) {
        Intrinsics.checkNotNullParameter(alternative, "alternative");
        T value = getValue();
        return value == null ? alternative.invoke() : value;
    }

    /* JADX INFO: compiled from: Optional.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0001\u0010\b*\u00020\u0001H\u0007J%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0001\u0010\b*\u00020\u00012\u0006\u0010\n\u001a\u0002H\bH\u0007¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0001\u0010\b*\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u0001H\bH\u0007¢\u0006\u0002\u0010\u000bR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/yandex/yatagan/Optional$Companion;", "", "()V", "Empty", "Lcom/yandex/yatagan/Optional;", "", "getEmpty$annotations", "empty", "T", "of", "value", "(Ljava/lang/Object;)Lcom/yandex/yatagan/Optional;", "ofNullable", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getEmpty$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> Optional<T> of(T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Optional<>(value, null);
        }

        @JvmStatic
        public final <T> Optional<T> empty() {
            return Optional.Empty;
        }

        @JvmStatic
        public final <T> Optional<T> ofNullable(T value) {
            if (value == null) {
                return Optional.Empty;
            }
            return new Optional<>(value, null);
        }
    }

    public final void ifPresent(Consumer<? super T> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        T value = getValue();
        if (value != null) {
            consumer.accept(value);
        }
    }

    public final void ifPresentOrElse(Consumer<? super T> consumer, Runnable onEmpty) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(onEmpty, "onEmpty");
        if (getValue() != null) {
            consumer.accept(getValue());
        } else {
            onEmpty.run();
        }
    }

    public final <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return getValue() != null ? INSTANCE.ofNullable(mapper.apply(getValue())) : INSTANCE.empty();
    }
}
