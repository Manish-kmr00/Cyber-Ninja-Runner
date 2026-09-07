package io.bidmachine.rendering.utils;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectHolder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f12433a;

    public ObjectHolder() {
        this(null);
    }

    public T get() {
        return (T) this.f12433a;
    }

    public void set(T object) {
        this.f12433a = object;
    }

    public ObjectHolder(T object) {
        this.f12433a = object;
    }
}
