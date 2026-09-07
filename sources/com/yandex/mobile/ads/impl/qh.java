package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class qh {
    private static final rh c = jm1.a();
    public static final qh d = new qh(new int[]{2}, 8);
    private static final qh e = new qh(new int[]{2, 5, 6}, 8);
    private static final ik0<Integer, Integer> f = new ik0.a().a(5, 6).a(17, 6).a(7, 6).a(18, 6).a(6, 8).a(8, 8).a(14, 8).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f10017a;
    private final int b;

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", supportedEncodings=" + Arrays.toString(this.f10017a) + com.ironsource.b9.i.e;
    }

    public static qh a(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int i = x82.f10629a;
        if (i >= 17) {
            rh rhVar = c;
            String strA = rhVar.a();
            String str = x82.c;
            if ((strA.equals(str) || rhVar.c().equals(str)) && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
                return e;
            }
        }
        if (i >= 29 && (x82.d(context) || (i >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")))) {
            return new qh(a.a(), 8);
        }
        if (intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new qh(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return d;
    }

    public qh(int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f10017a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f10017a = new int[0];
        }
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qh)) {
            return false;
        }
        qh qhVar = (qh) obj;
        return Arrays.equals(this.f10017a, qhVar.f10017a) && this.b == qhVar.b;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f10017a) * 31) + this.b;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    public final Pair<Integer, Integer> a(gc0 gc0Var) {
        String str = gc0Var.m;
        str.getClass();
        int iB = s01.b(str, gc0Var.j);
        ik0<Integer, Integer> ik0Var = f;
        if (!ik0Var.containsKey(Integer.valueOf(iB))) {
            return null;
        }
        int i = 6;
        if (iB == 18 && Arrays.binarySearch(this.f10017a, 18) < 0) {
            iB = 6;
        } else if (iB == 8 && Arrays.binarySearch(this.f10017a, 8) < 0) {
            iB = 7;
        }
        if (Arrays.binarySearch(this.f10017a, iB) < 0) {
            return null;
        }
        int iIntValue = gc0Var.z;
        if (iIntValue != -1 && iB != 18) {
            if (iIntValue > this.b) {
                return null;
            }
        } else {
            int i2 = gc0Var.A;
            if (i2 == -1) {
                i2 = 48000;
            }
            if (x82.f10629a >= 29) {
                iIntValue = a.a(iB, i2);
            } else {
                Integer num = ik0Var.get(Integer.valueOf(iB));
                iIntValue = (num != null ? num : 0).intValue();
            }
        }
        int i3 = x82.f10629a;
        if (i3 > 28) {
            i = iIntValue;
        } else if (iIntValue == 7) {
            i = 8;
        } else if (iIntValue != 3 && iIntValue != 4 && iIntValue != 5) {
            i = iIntValue;
        }
        if (i3 <= 26 && c.b().equals(x82.b) && i == 1) {
            i = 2;
        }
        int iA = x82.a(i);
        if (iA == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(iA));
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final AudioAttributes f10018a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        public static int a(int i, int i2) {
            for (int i3 = 8; i3 > 0; i3--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(x82.a(i3)).build(), f10018a)) {
                    return i3;
                }
            }
            return 0;
        }

        public static int[] a() {
            int i = hk0.d;
            hk0.a aVar = new hk0.a();
            Iterator it = qh.f.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(num.intValue()).setSampleRate(48000).build(), f10018a)) {
                    aVar.b(num);
                }
            }
            aVar.b((Object) 2);
            return dq0.a(aVar.a());
        }
    }
}
