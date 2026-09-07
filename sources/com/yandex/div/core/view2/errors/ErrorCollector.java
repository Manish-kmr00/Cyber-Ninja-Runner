package com.yandex.div.core.view2.errors;

import com.yandex.div.core.Disposable;
import com.yandex.div2.DivData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorCollector.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0012JP\u0010\u001e\u001a\u00020\u001f2F\u0010 \u001aB\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010H\u0016J\b\u0010!\u001a\u00020\u000fH\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u000e¢\u0006\u0002\n\u0000RT\u0010\b\u001aH\u0012D\u0012B\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u00100\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0092\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/core/view2/errors/ErrorCollector;", "", "()V", "errors", "", "", "errorsAreValid", "", "observers", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "warnings", "", "Lcom/yandex/div/core/view2/errors/ErrorObserver;", "parsingErrors", "runtimeErrors", "attachParsingErrors", "divData", "Lcom/yandex/div2/DivData;", "cleanRuntimeWarningsAndErrors", "getWarnings", "", "logError", "e", "logWarning", "warning", "notifyObservers", "observeAndGet", "Lcom/yandex/div/core/Disposable;", "observer", "rebuildErrors", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class ErrorCollector {
    private final Set<Function2<List<? extends Throwable>, List<? extends Throwable>, Unit>> observers = new LinkedHashSet();
    private final List<Throwable> runtimeErrors = new ArrayList();
    private List<? extends Throwable> parsingErrors = CollectionsKt.emptyList();
    private List<Throwable> warnings = new ArrayList();
    private List<Throwable> errors = new ArrayList();
    private boolean errorsAreValid = true;

    public void logError(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.runtimeErrors.add(e);
        notifyObservers();
    }

    public void logWarning(Throwable warning) {
        Intrinsics.checkNotNullParameter(warning, "warning");
        this.warnings.add(warning);
        notifyObservers();
    }

    public Iterator<Throwable> getWarnings() {
        return this.warnings.listIterator();
    }

    public void cleanRuntimeWarningsAndErrors() {
        this.warnings.clear();
        this.runtimeErrors.clear();
        notifyObservers();
    }

    private void notifyObservers() {
        this.errorsAreValid = false;
        if (this.observers.isEmpty()) {
            return;
        }
        rebuildErrors();
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(this.errors, this.warnings);
        }
    }

    private void rebuildErrors() {
        if (this.errorsAreValid) {
            return;
        }
        this.errors.clear();
        this.errors.addAll(this.parsingErrors);
        this.errors.addAll(this.runtimeErrors);
        this.errorsAreValid = true;
    }

    public Disposable observeAndGet(final Function2<? super List<? extends Throwable>, ? super List<? extends Throwable>, Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
        rebuildErrors();
        observer.invoke(this.errors, this.warnings);
        return new Disposable() { // from class: com.yandex.div.core.view2.errors.ErrorCollector$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.Disposable, java.lang.AutoCloseable, java.io.Closeable
            public final void close() {
                ErrorCollector.observeAndGet$lambda$1(this.f$0, observer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeAndGet$lambda$1(ErrorCollector this$0, Function2 observer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        this$0.observers.remove(observer);
    }

    public void attachParsingErrors(DivData divData) {
        List<Exception> listEmptyList;
        if (divData == null || (listEmptyList = divData.parsingErrors) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.parsingErrors = listEmptyList;
        notifyObservers();
    }
}
