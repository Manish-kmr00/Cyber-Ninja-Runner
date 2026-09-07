package com.facebook.ads.redexgen.core;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class WF {
    public static String[] A00 = {"SHB3gcLYeYHiz9EHJcwSoXi3t3dJ3Sae", "YsiV64puezA1JMx0OK9DKxP7EyirmbjM", "N4muBHoa4SjHZ7raAuzYL2vq1Yox5zaV", "XrSjTZ3QAJ3ds1", "8", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "XY8MO4Cd9EwNU5px6ussSQdlK04iGsJf", "eEhSpmY5oFVMO3yO0x4u4hP5mcUFTVnt"};

    public static WE A00(int i, long[] jArr, int[] iArr, long j) {
        int chunkSamplesRemaining = 8192 / i;
        int iA05 = 0;
        for (int i2 : iArr) {
            iA05 += AbstractC2471gE.A05(i2, chunkSamplesRemaining);
        }
        long[] jArr2 = new long[iA05];
        int[] iArr2 = new int[iA05];
        int originalSampleIndex = 0;
        long[] timestamps = new long[iA05];
        int[] flags = new int[iA05];
        int i3 = 0;
        int bufferSampleCount = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int rechunkedSampleCount = iArr[i4];
            long j2 = jArr[i4];
            String[] strArr = A00;
            String str = strArr[0];
            String str2 = strArr[2];
            int iCharAt = str.charAt(30);
            int maxSampleCount = str2.charAt(30);
            if (iCharAt != maxSampleCount) {
                throw new RuntimeException();
            }
            A00[3] = "Oz9Z3vr9qLF5H2";
            while (rechunkedSampleCount > 0) {
                int iMin = Math.min(chunkSamplesRemaining, rechunkedSampleCount);
                jArr2[bufferSampleCount] = j2;
                iArr2[bufferSampleCount] = i * iMin;
                originalSampleIndex = Math.max(originalSampleIndex, iArr2[bufferSampleCount]);
                timestamps[bufferSampleCount] = ((long) i3) * j;
                flags[bufferSampleCount] = 1;
                j2 += (long) iArr2[bufferSampleCount];
                i3 += iMin;
                rechunkedSampleCount -= iMin;
                bufferSampleCount++;
            }
        }
        return new WE(jArr2, iArr2, originalSampleIndex, timestamps, flags, j * ((long) i3));
    }
}
