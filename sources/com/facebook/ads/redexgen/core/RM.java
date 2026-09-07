package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RM {
    public static String[] A00 = {"JcCiwe", "I1yyjDxSLafUtbPIgH190wjO8EQGjRQP", "NMea3kEfVtg4hKxB7e7ATctPEr", "cY7", "qlIPemaH8SzyKht6jnQdMjFGFN", "4YyAYXPqR8nG3TCHg", "HcI0SKLclevzdljtRNfZmpadUZvS2y3N", "s8dTGHmqq3gUosBKcQEjF12TegLlWnsa"};
    public static final AudioAttributes A01 = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int A00(int i, int i2) {
        for (int i3 = 8; i3 > 0; i3--) {
            AudioFormat.Builder sampleRate = new AudioFormat.Builder().setEncoding(i).setSampleRate(i2);
            int channelCount = AbstractC2471gE.A01(i3);
            AudioFormat audioFormat = sampleRate.setChannelMask(channelCount).build();
            if (AudioTrack.isDirectPlaybackSupported(audioFormat, A01)) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4T != com.google.common.collect.ImmutableList$Builder<java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    public static int[] A01() {
        C4T c4tA01 = OI.A01();
        AbstractC2964oj it = RN.A06.keySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A00;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            A00[7] = "6Zm9tjo0LFpSz1JYBrkkBsAMinRVg5T8";
            if (zHasNext) {
                int encoding = ((Integer) it.next()).intValue();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(encoding).setSampleRate(48000).build(), A01)) {
                    c4tA01.A04(Integer.valueOf(encoding));
                }
            } else {
                c4tA01.A04(2);
                return AbstractC1785Nn.A0C(c4tA01.A05());
            }
        }
    }
}
