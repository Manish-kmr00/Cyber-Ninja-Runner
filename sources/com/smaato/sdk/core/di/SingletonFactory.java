package com.smaato.sdk.core.di;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
final class SingletonFactory<T> implements ClassFactory<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile ClassFactory factory;
    private volatile Object instance = UNINITIALIZED;

    private SingletonFactory(ClassFactory classFactory) {
        this.factory = (ClassFactory) Objects.requireNonNull(classFactory);
    }

    @Override // com.smaato.sdk.core.di.ClassFactory
    public T get(DiConstructor diConstructor) {
        Object obj = (T) this.instance;
        Object obj2 = UNINITIALIZED;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.instance;
                if (obj == obj2) {
                    Object obj3 = this.factory.get(diConstructor);
                    Object obj4 = this.instance;
                    if (obj4 != obj2 && obj4 != obj3) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj3 + ". This is likely due to a circular dependency.");
                    }
                    this.instance = obj3;
                    this.factory = null;
                    obj = (T) obj3;
                }
            }
        }
        return (T) obj;
    }

    public static <T> ClassFactory<T> wrap(ClassFactory<T> classFactory) {
        Objects.requireNonNull(classFactory);
        return classFactory instanceof SingletonFactory ? classFactory : new SingletonFactory(classFactory);
    }
}
