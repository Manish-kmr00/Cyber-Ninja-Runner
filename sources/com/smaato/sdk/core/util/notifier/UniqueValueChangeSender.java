package com.smaato.sdk.core.util.notifier;

/* JADX INFO: loaded from: classes10.dex */
class UniqueValueChangeSender<T> extends StandardChangeSender<T> {
    UniqueValueChangeSender(T t) {
        super(t);
    }

    @Override // com.smaato.sdk.core.util.notifier.StandardChangeSender, com.smaato.sdk.core.util.notifier.ChangeSender
    public void newValue(T t) {
        if (t.equals(getValue())) {
            return;
        }
        super.newValue(t);
    }
}
