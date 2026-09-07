package com.yandex.div.core;

import com.safedk.android.analytics.brandsafety.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompositeDisposable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001J\b\u0010\n\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/CompositeDisposable;", "Lcom/yandex/div/core/Disposable;", "()V", "closed", "", "disposables", "", l.l, "", "disposable", "close", "remove", "div-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CompositeDisposable implements Disposable {
    private boolean closed;
    private final List<Disposable> disposables = new ArrayList();

    public final void add(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        if (this.closed) {
            throw new IllegalArgumentException("close() method was called".toString());
        }
        if (disposable != Disposable.NULL) {
            this.disposables.add(disposable);
        }
    }

    public final void remove(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        if (this.closed) {
            throw new IllegalArgumentException("close() method was called".toString());
        }
        if (disposable != Disposable.NULL) {
            this.disposables.remove(disposable);
        }
    }

    @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
    public void close() {
        Iterator<T> it = this.disposables.iterator();
        while (it.hasNext()) {
            ((Disposable) it.next()).close();
        }
        this.disposables.clear();
        this.closed = true;
    }
}
