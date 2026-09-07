package com.yandex.div.core.tooltip;

import androidx.activity.OnBackPressedCallback;
import com.yandex.div.core.DivPreloader;
import com.yandex.div.core.util.SafePopupWindow;
import com.yandex.div2.Div;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTooltipController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/core/tooltip/TooltipData;", "", "popupWindow", "Lcom/yandex/div/core/util/SafePopupWindow;", "div", "Lcom/yandex/div2/Div;", "ticket", "Lcom/yandex/div/core/DivPreloader$Ticket;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "dismissed", "", "(Lcom/yandex/div/core/util/SafePopupWindow;Lcom/yandex/div2/Div;Lcom/yandex/div/core/DivPreloader$Ticket;Landroidx/activity/OnBackPressedCallback;Z)V", "getDismissed", "()Z", "setDismissed", "(Z)V", "getDiv", "()Lcom/yandex/div2/Div;", "getOnBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "getPopupWindow", "()Lcom/yandex/div/core/util/SafePopupWindow;", "getTicket", "()Lcom/yandex/div/core/DivPreloader$Ticket;", "setTicket", "(Lcom/yandex/div/core/DivPreloader$Ticket;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TooltipData {
    private boolean dismissed;
    private final Div div;
    private final OnBackPressedCallback onBackPressedCallback;
    private final SafePopupWindow popupWindow;
    private DivPreloader.Ticket ticket;

    public TooltipData(SafePopupWindow popupWindow, Div div, DivPreloader.Ticket ticket, OnBackPressedCallback onBackPressedCallback, boolean z) {
        Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
        Intrinsics.checkNotNullParameter(div, "div");
        this.popupWindow = popupWindow;
        this.div = div;
        this.ticket = ticket;
        this.onBackPressedCallback = onBackPressedCallback;
        this.dismissed = z;
    }

    public /* synthetic */ TooltipData(SafePopupWindow safePopupWindow, Div div, DivPreloader.Ticket ticket, OnBackPressedCallback onBackPressedCallback, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(safePopupWindow, div, (i & 4) != 0 ? null : ticket, onBackPressedCallback, (i & 16) != 0 ? false : z);
    }

    public final SafePopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    public final Div getDiv() {
        return this.div;
    }

    public final DivPreloader.Ticket getTicket() {
        return this.ticket;
    }

    public final void setTicket(DivPreloader.Ticket ticket) {
        this.ticket = ticket;
    }

    public final OnBackPressedCallback getOnBackPressedCallback() {
        return this.onBackPressedCallback;
    }

    public final boolean getDismissed() {
        return this.dismissed;
    }

    public final void setDismissed(boolean z) {
        this.dismissed = z;
    }
}
