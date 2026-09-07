package com.yandex.div.core;

import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: Disposable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/Disposable;", "Ljava/lang/AutoCloseable;", "Ljava/io/Closeable;", "close", "", "Companion", "div-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Disposable extends AutoCloseable, Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final Disposable NULL = new Disposable() { // from class: com.yandex.div.core.Disposable$$ExternalSyntheticLambda0
        @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
        public final void close() {
            Disposable.NULL$lambda$0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static void NULL$lambda$0() {
    }

    @Override // java.lang.AutoCloseable, java.io.Closeable
    void close();

    /* JADX INFO: compiled from: Disposable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/Disposable$Companion;", "", "()V", "NULL", "Lcom/yandex/div/core/Disposable;", "div-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
