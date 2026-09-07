package com.facebook.ads.redexgen.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3L extends Handler {
    public static byte[] A0A;
    public Messenger A00;
    public boolean A01;
    public boolean A02;
    public final ServiceConnection A03;
    public final Handler A04;
    public final Messenger A05;
    public final AbstractC2822m5 A06;
    public final C2699k1 A07;
    public final C2698k0 A08;
    public final BY A09;

    static {
        A07();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{-30, -17, -25, -37, -63, -64, -59, -53, -42, -55, -51, -42, -72, -57, -57, -42, -58, -55, -64, -68, -59, -53, -72, -53, -64, -58, -59, -42, -62, -68, -48, -54, -35, -27, -25, -20, -35, -104, -21, -35, -22, -18, -31, -37, -35, -104, -35, -22, -22, -25, -22, -90, -84, -83, -85, -72, -102, -99, -72, -94, -99, -72, -92, -98, -78, 71, 58, 54, 72, 37, 74, 65, 54};
    }

    public C3L(C2699k1 c2699k1, AbstractC2822m5 abstractC2822m5) {
        super(Looper.getMainLooper());
        this.A04 = new Handler(Looper.getMainLooper());
        this.A03 = new ServiceConnection() { // from class: com.facebook.ads.redexgen.X.3K
            public static String[] A01 = {"5NfIE0YcA1j7k4kI09Qd", "GOyJyQVDSAttzLj2dwW1R", "UEE9UjADaku6tgIVG7TE", "AlbuaripePsmIRlIONJuvTINhX", "hDpBwlS77lkTDgpWlwn57aFtHcNJW0B1", "G5FnfniCDoZltv23hjG8RcIHEgm214hW", "K1Tu", "8SU16w9FmjIzUCDhhEyMBCCw6KqJKOI3"};

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                this.A00.A07.A0F().AHD();
                this.A00.A04.removeCallbacks(this.A00.A09);
                if (iBinder != null) {
                    this.A00.A00 = new Messenger(iBinder);
                    if (this.A00.A02) {
                        this.A00.A02 = false;
                        this.A00.A06.A06();
                        return;
                    }
                    return;
                }
                this.A00.A07.A0F().AHF();
                C3L c3l = this.A00;
                if (A01[3].length() != 26) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "klTZBPtNd5GFvPmgAP3f";
                strArr[2] = "mBOUVEJ7kKkpCLxr10ij";
                c3l.A06();
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                this.A00.A07.A0F().AHE();
                if (!this.A00.A01) {
                    return;
                }
                this.A00.A06();
            }
        };
        this.A07 = c2699k1;
        this.A08 = c2699k1.A02();
        this.A05 = new Messenger(this);
        this.A06 = abstractC2822m5;
        this.A09 = new C2808lq(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A01) {
            A0C();
            this.A00 = null;
        }
        this.A06.A09();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        this.A00 = null;
        A0C();
        if (this.A06.A03().A6f() == C3D.A06 || this.A06.A03().A6g() == C3D.A07) {
            this.A07.A0F().AH4();
            this.A06.A0B(10, AdErrorType.INTERNAL_ERROR, null);
        } else {
            if (this.A06.A03().A6f() != C3D.A05) {
                return;
            }
            if (AbstractC14529p.A0A(this.A07)) {
                this.A07.A0F().AHA();
                this.A06.A03().AAl();
                this.A06.A0D(true);
                this.A06.A09();
                return;
            }
            this.A07.A0F().AHA();
            this.A06.A03().AIX(new AdError(2008, A04(31, 21, 34)));
        }
    }

    private void A08(Messenger messenger, int i, Bundle bundle) throws RemoteException {
        Message messageObtain = Message.obtain((Handler) null, i);
        messageObtain.replyTo = this.A05;
        if (bundle != null) {
            messageObtain.setData(bundle);
        }
        messageObtain.getData().putString(A04(52, 13, 3), this.A06.A04());
        messenger.send(messageObtain);
    }

    public static void A0B(C2699k1 c2699k1, String str) {
        c2699k1.A0F().AGy(str);
        AnonymousClass81 anonymousClass81A0G = c2699k1.A0G();
        if (anonymousClass81A0G != null && anonymousClass81A0G.A6e() != null && anonymousClass81A0G.A6a() != null) {
            anonymousClass81A0G.A6e().onError(anonymousClass81A0G.A6a(), AdError.AD_PRESENTATION_ERROR);
        }
    }

    public final void A0C() {
        if (this.A01) {
            this.A07.A0F().AHM();
            this.A01 = false;
            this.A08.unbindService(this.A03);
        }
    }

    public final void A0D(C2699k1 c2699k1, int i) {
        this.A07.A0F().AHK();
        AdActivityIntent adActivityIntentA05 = C1491Bq.A05(c2699k1);
        adActivityIntentA05.putExtra(A04(65, 8, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), BG.A0E);
        adActivityIntentA05.putExtra(A04(52, 13, 3), this.A06.A04());
        adActivityIntentA05.putExtra(A04(5, 26, 33), i);
        try {
            int usedContext = C1491Bq.A00(c2699k1, adActivityIntentA05);
            this.A07.A0F().AHL(usedContext);
        } catch (C1489Bo e) {
            String strA04 = A04(0, 5, 75);
            Throwable cause = e.getCause();
            if (cause != null) {
                strA04 = strA04 + cause.toString();
            }
            A0B(c2699k1, strA04);
        }
    }

    public final void A0E(boolean z) {
        this.A01 = C3M.A04(this.A08, z, this.A03);
        if (this.A01) {
            this.A07.A0F().AH0();
            if (this.A00 == null) {
                this.A04.postDelayed(this.A09, AbstractC14529p.A00(this.A08));
                return;
            }
            return;
        }
        this.A07.A0F().AH8();
        this.A02 = false;
        this.A06.A09();
    }

    public final boolean A0F(int i, Bundle bundle) {
        try {
            Messenger service = this.A00;
            if (service != null) {
                A08(service, i, bundle);
                return true;
            }
            return false;
        } catch (RemoteException e) {
            A0C();
            this.A07.A0F().AH3(e);
            return false;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (message.what == 3) {
                return;
            }
            if (message.what == 20 || message.what == 30 || message.what == 40) {
                if (message.what == 20) {
                    this.A07.A0F().AHH();
                    AbstractC14529p.A06(this.A08);
                } else {
                    this.A07.A0F().AHG();
                }
                A05();
                return;
            }
            String adId = message.getData().getString(A04(52, 13, 3));
            if (!this.A06.A04().equals(adId)) {
                this.A07.A0F().AHN();
            } else if (message.what == 2001 || message.what == 1011) {
                C3M.A02(this.A08, message);
            } else {
                this.A07.A0F().AH9(message.what);
                this.A06.A0C(message);
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
