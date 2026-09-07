package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2M extends BroadcastReceiver {
    public static String[] A03 = {"dggRIwntGnoxWZ7BDQUg45Sl6NQgoMuN", "38c9H60yn2P1pt17", "STlEyQPStERy8tSXGvH8F24LWNUxdBhq", "hCwe", "bKRxwQpiW0PmVHVfGUn2RavmyNEFkRji", "VPPe2MO9HED0sxCZzVAB8cvkabJHsXeP", "uH31h0PRXTyVkIOgrCb5PcgaQIfZ1AyX", "pPlbIWWtmQkYN3MHTwcOdVUNUzBLXTby"};
    public AbstractC2859mh A00;
    public C2L A01;
    public String A02;

    public C2M(String str, AbstractC2859mh abstractC2859mh, C2L c2l) {
        this.A00 = abstractC2859mh;
        this.A01 = c2l;
        this.A02 = str;
    }

    public final IntentFilter A00() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IV.A06.A04(this.A02));
        intentFilter.addAction(IV.A09.A04(this.A02));
        intentFilter.addAction(IV.A04.A04(this.A02));
        intentFilter.addAction(IV.A0A.A04(this.A02));
        intentFilter.addAction(IV.A05.A04(this.A02));
        intentFilter.addAction(IV.A0C.A04(this.A02));
        intentFilter.addAction(IV.A0B.A04(this.A02));
        intentFilter.addAction(IV.A03.A04(this.A02));
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        IV iv = IV.A06;
        String action2 = this.A02;
        if (iv.A04(action2).equals(action)) {
            this.A01.AEy(this.A00);
            return;
        }
        IV iv2 = IV.A09;
        String action3 = this.A02;
        if (iv2.A04(action3).equals(action)) {
            if (C14499m.A1r(context)) {
                this.A01.AEz(this.A00, AdError.AD_PRESENTATION_ERROR);
                return;
            } else {
                this.A01.AEz(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        }
        IV iv3 = IV.A04;
        String action4 = this.A02;
        if (iv3.A04(action4).equals(action)) {
            this.A01.AEv(this.A00);
            return;
        }
        IV iv4 = IV.A0A;
        String action5 = this.A02;
        if (iv4.A04(action5).equals(action)) {
            this.A01.AEx(this.A00);
            return;
        }
        IV iv5 = IV.A05;
        String action6 = this.A02;
        boolean zEquals = iv5.A04(action6).equals(action);
        if (A03[6].charAt(8) != 'X') {
            throw new RuntimeException();
        }
        A03[6] = "gVjZHTAPXXqW3paCpGTUxeCgOEd4dSxo";
        if (zEquals) {
            this.A01.onRewardedVideoClosed();
            return;
        }
        IV iv6 = IV.A0B;
        String action7 = this.A02;
        if (iv6.A04(action7).equals(action)) {
            C2L c2l = this.A01;
            AbstractC2859mh abstractC2859mh = this.A00;
            String[] strArr = A03;
            if (strArr[2].charAt(25) != strArr[4].charAt(25)) {
                throw new RuntimeException();
            }
            A03[6] = "QgP7tKiwXm5h6JnagwUE7gN68w8IQRlz";
            c2l.AEt(abstractC2859mh);
            return;
        }
        IV iv7 = IV.A0C;
        String action8 = this.A02;
        if (iv7.A04(action8).equals(action)) {
            this.A01.AEu(this.A00);
            return;
        }
        IV iv8 = IV.A03;
        String str = this.A02;
        if (A03[0].charAt(19) != 'F') {
            A03[1] = "4VvB4uonEo2HdG2J";
            String action9 = iv8.A04(str);
            if (!action9.equals(action)) {
                return;
            }
        } else {
            String action10 = iv8.A04(str);
            if (!action10.equals(action)) {
                return;
            }
        }
        this.A01.onRewardedVideoActivityDestroyed();
    }
}
