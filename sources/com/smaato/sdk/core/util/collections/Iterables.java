package com.smaato.sdk.core.util.collections;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.BiFunction;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class Iterables {
    static /* synthetic */ Iterator lambda$map$0(Iterable iterable, final Function function) {
        return new MappedIterator<F, T>(iterable.iterator()) { // from class: com.smaato.sdk.core.util.collections.Iterables.1
            @Override // com.smaato.sdk.core.util.collections.MappedIterator
            T map(F f) {
                return (T) function.apply(f);
            }
        };
    }

    public static <F, T> Iterable<T> map(final Iterable<F> iterable, final Function<F, T> function) {
        return new Iterable() { // from class: com.smaato.sdk.core.util.collections.Iterables$$ExternalSyntheticLambda0
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return Iterables.lambda$map$0(iterable, function);
            }
        };
    }

    public static <T> void forEach(Iterable<T> iterable, Consumer<T> consumer) {
        Objects.requireNonNull(iterable);
        Objects.requireNonNull(consumer);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static <K, R> R reduce(Iterable<K> iterable, R r, BiFunction<K, R, R> biFunction) {
        Objects.requireNonNull(biFunction);
        Iterator<K> it = iterable.iterator();
        while (it.hasNext()) {
            r = biFunction.apply(it.next(), r);
        }
        return r;
    }

    public static <T> T filterFirst(Iterable<T> iterable, Predicate<T> predicate) {
        for (T t : iterable) {
            if (predicate.test(t)) {
                return t;
            }
        }
        return null;
    }
}
