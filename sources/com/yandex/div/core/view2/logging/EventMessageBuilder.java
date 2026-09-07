package com.yandex.div.core.view2.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventMessageBuilder.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0004R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/logging/EventMessageBuilder;", "", "()V", "consolidatedEvents", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendEventMessage", "", "event", "", "message", "buildEventsLogMessage", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class EventMessageBuilder {
    private final StringBuilder consolidatedEvents = new StringBuilder();

    protected final void appendEventMessage(String event, String message) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.consolidatedEvents.length() > 0) {
            this.consolidatedEvents.append(", ");
        }
        this.consolidatedEvents.append(event + " (" + message + ')');
    }

    protected final String buildEventsLogMessage() {
        StringBuilder sb = this.consolidatedEvents;
        if (sb.length() <= 0) {
            return null;
        }
        String string = sb.toString();
        StringsKt.clear(sb);
        return string;
    }
}
