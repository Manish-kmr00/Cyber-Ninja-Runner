package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.t9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3571t9 extends AbstractC3518pc {
    public final C3389h d;
    public final C3418j0 e;
    public InMobiAdRequestStatus f;
    public final L4 g;
    public final WeakReference h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3571t9(C0 adUnit, C3389h ad, C3418j0 adSet, InMobiAdRequestStatus status, L4 l4) {
        super(adUnit, (byte) 1);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        Intrinsics.checkNotNullParameter(status, "status");
        this.d = ad;
        this.e = adSet;
        this.f = status;
        this.g = l4;
        this.h = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC3518pc
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        a(((Boolean) obj).booleanValue());
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void c() {
        super.c();
        this.f = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY);
        a(false);
    }

    public final void a(boolean z) {
        L4 l4 = this.g;
        if (l4 != null) {
            ((M4) l4).c("ParseAdResponseWorker", "onComplete result - " + z);
        }
        C0 c0 = (C0) this.h.get();
        if (c0 != null) {
            L4 l5 = this.g;
            if (l5 != null) {
                ((M4) l5).c("ParseAdResponseWorker", "updating vitals in logger");
            }
            c0.a(z, this.f);
            return;
        }
        L4 l6 = this.g;
        if (l6 != null) {
            ((M4) l6).b("ParseAdResponseWorker", "onComplete - adunit is null");
        }
    }

    @Override // com.inmobi.media.AbstractRunnableC3521q1
    public final void a() {
        L4 l4 = this.g;
        if (l4 != null) {
            ((M4) l4).c("ParseAdResponseWorker", "execute task");
        }
        C0 c0 = (C0) this.h.get();
        if (c0 == null) {
            L4 l5 = this.g;
            if (l5 != null) {
                ((M4) l5).b("ParseAdResponseWorker", "adUnit is null. fail.");
            }
            b(Boolean.FALSE);
            return;
        }
        if (this.e.n()) {
            L4 l6 = this.g;
            if (l6 != null) {
                ((M4) l6).c("ParseAdResponseWorker", "parsing for ad pods");
            }
            LinkedList<C3389h> linkedListF = this.e.f();
            C3389h first = linkedListF.getFirst();
            Intrinsics.checkNotNull(first);
            if (c0.a(first, 0, true)) {
                L4 l7 = this.g;
                if (l7 != null) {
                    ((M4) l7).c("ParseAdResponseWorker", "parse success for ad index 0");
                }
                ListIterator<C3389h> listIterator = linkedListF.listIterator(1);
                Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
                while (listIterator.hasNext()) {
                    C3389h next = listIterator.next();
                    if (!c0.a(next, linkedListF.indexOf(next), false)) {
                        L4 l8 = this.g;
                        if (l8 != null) {
                            ((M4) l8).b("ParseAdResponseWorker", "parseAdResponse fail for index - " + linkedListF.indexOf(next));
                        }
                        listIterator.remove();
                    } else {
                        L4 l9 = this.g;
                        if (l9 != null) {
                            ((M4) l9).c("ParseAdResponseWorker", "parseAdResponse success for index - " + linkedListF.indexOf(next));
                        }
                    }
                }
                b(Boolean.TRUE);
                return;
            }
            L4 l10 = this.g;
            if (l10 != null) {
                ((M4) l10).b("ParseAdResponseWorker", "didParseAdResponseAndExtractData failed");
            }
            b(Boolean.FALSE);
            return;
        }
        L4 l11 = this.g;
        if (l11 != null) {
            ((M4) l11).c("ParseAdResponseWorker", "parsing for single ad");
        }
        b(Boolean.valueOf(c0.a(this.d, 0, true)));
    }
}
