package com.yandex.div.storage.database;

import android.database.Cursor;
import com.yandex.div.internal.util.IOUtils;
import java.io.Closeable;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadState.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0004H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/storage/database/ReadState;", "Ljava/io/Closeable;", "onCloseState", "Lkotlin/Function0;", "", "cursorProvider", "Ljavax/inject/Provider;", "Landroid/database/Cursor;", "(Lkotlin/jvm/functions/Function0;Ljavax/inject/Provider;)V", "_cursor", "cursor", "getCursor", "()Landroid/database/Cursor;", "close", "div-storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ReadState implements Closeable {
    private Cursor _cursor;
    private final Provider<Cursor> cursorProvider;
    private final Function0<Unit> onCloseState;

    public ReadState(Function0<Unit> onCloseState, Provider<Cursor> cursorProvider) {
        Intrinsics.checkNotNullParameter(onCloseState, "onCloseState");
        Intrinsics.checkNotNullParameter(cursorProvider, "cursorProvider");
        this.onCloseState = onCloseState;
        this.cursorProvider = cursorProvider;
    }

    public /* synthetic */ ReadState(AnonymousClass1 anonymousClass1, Provider provider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0<Unit>() { // from class: com.yandex.div.storage.database.ReadState.1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass1, provider);
    }

    public final Cursor getCursor() {
        if (this._cursor != null) {
            throw new RuntimeException("Cursor should be called only once");
        }
        Cursor c = this.cursorProvider.get();
        this._cursor = c;
        Intrinsics.checkNotNullExpressionValue(c, "c");
        return c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeCursorSilently(this._cursor);
        this.onCloseState.invoke();
    }
}
