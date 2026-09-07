package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CF extends XP {
    public static String[] A00 = {"K87usX8Jo4", "a5lOCotzloix2YHLYEy1qfheEirjsZYz", "EoycNpp2QpS0HErxt2XEehPkNAVVVguP", "5kOpJF9", "IqFPDMOPOcST3YHl4gakx4s2mTc1u7Ci", "I0COtB8myu1V6qaz2pFn24gWM3i63awa", "OuYEyxGmbGQyn5d36FCCjEWWJ9Q2R8bz", "9nZAUSyU6UzF4MWzhjoqSDLOwyr0AbQy"};

    @Override // com.facebook.ads.redexgen.core.XP
    public final RT A09(RT rt) throws RU {
        int i = rt.A02;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            if (i != 2) {
                return new RT(rt.A03, rt.A01, 2);
            }
            return RT.A05;
        }
        throw new RU(rt);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x004d  */
    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[ADDED_TO_REGION, LOOP:0: B:17:0x0053->B:21:0x0065, LOOP_START, PHI: r4
  0x0053: PHI (r4v9 int) = (r4v0 int), (r4v10 int) binds: [B:14:0x004a, B:21:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    /* JADX WARN: Code duplicated, block: B:21:0x0065 A[LOOP:0: B:17:0x0053->B:21:0x0065, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x0082 A[ADDED_TO_REGION, LOOP:1: B:22:0x0082->B:23:0x0084, LOOP_START, PHI: r4
  0x0082: PHI (r4v7 int) = (r4v0 int), (r4v8 int) binds: [B:14:0x004a, B:23:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x0084 A[LOOP:1: B:22:0x0082->B:23:0x0084, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0099 A[ADDED_TO_REGION, LOOP:2: B:24:0x0099->B:25:0x009b, LOOP_START, PHI: r4
  0x0099: PHI (r4v5 int) = (r4v0 int), (r4v6 int) binds: [B:14:0x004a, B:25:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x009b A[LOOP:2: B:24:0x0099->B:25:0x009b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x00b0 A[ADDED_TO_REGION, LOOP:3: B:26:0x00b0->B:27:0x00b2, LOOP_START, PHI: r4
  0x00b0: PHI (r4v3 int) = (r4v0 int), (r4v4 int) binds: [B:14:0x004a, B:27:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2 A[LOOP:3: B:26:0x00b0->B:27:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x00d5 A[ADDED_TO_REGION, LOOP:4: B:28:0x00d5->B:29:0x00d7, LOOP_START, PHI: r4
  0x00d5: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:14:0x004a, B:29:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x00d7 A[LOOP:4: B:28:0x00d5->B:29:0x00d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x0033 A[SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.core.RV
    public final void AGP(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA00;
        int position;
        int i;
        int iPosition = byteBuffer.position();
        int resampledSize = byteBuffer.limit();
        int limit = resampledSize - iPosition;
        int position2 = this.A05.A02;
        switch (position2) {
            case 3:
                limit *= 2;
                byteBufferA00 = A00(limit);
                position = this.A05.A02;
                switch (position) {
                    case 3:
                        while (iPosition < resampledSize) {
                            byteBufferA00.put((byte) 0);
                            int position3 = byteBuffer.get(iPosition);
                            byteBufferA00.put((byte) ((position3 & 255) - 128));
                            iPosition++;
                        }
                        int position4 = byteBuffer.limit();
                        byteBuffer.position(position4);
                        byteBufferA00.flip();
                        return;
                    case 4:
                        while (iPosition < resampledSize) {
                            int position5 = (int) (32767.0f * AbstractC2471gE.A00(byteBuffer.getFloat(iPosition), -1.0f, 1.0f));
                            int limit2 = (short) position5;
                            int position6 = limit2 & 255;
                            byteBufferA00.put((byte) position6);
                            int position7 = limit2 >> 8;
                            byteBufferA00.put((byte) (position7 & 255));
                            iPosition += 4;
                        }
                        int position8 = byteBuffer.limit();
                        byteBuffer.position(position8);
                        byteBufferA00.flip();
                        return;
                    case 268435456:
                        while (iPosition < resampledSize) {
                            i = iPosition + 1;
                            if (A00[0].length() == 10) {
                                throw new RuntimeException();
                            }
                            String[] strArr = A00;
                            strArr[4] = "lE2Bf5epoqEX36dJZXu8HwZc9TJvlS81";
                            strArr[2] = "bp2aTFC43ActhQwES5pwfObrZTRosGvf";
                            byteBufferA00.put(byteBuffer.get(i));
                            byteBufferA00.put(byteBuffer.get(iPosition));
                            iPosition += 2;
                        }
                        int position9 = byteBuffer.limit();
                        byteBuffer.position(position9);
                        byteBufferA00.flip();
                        return;
                    case 536870912:
                        while (iPosition < resampledSize) {
                            int position10 = iPosition + 1;
                            byteBufferA00.put(byteBuffer.get(position10));
                            int position11 = iPosition + 2;
                            byteBufferA00.put(byteBuffer.get(position11));
                            iPosition += 3;
                        }
                        int position12 = byteBuffer.limit();
                        byteBuffer.position(position12);
                        byteBufferA00.flip();
                        return;
                    case C.ENCODING_PCM_32BIT /* 805306368 */:
                        while (iPosition < resampledSize) {
                            int position13 = iPosition + 2;
                            byteBufferA00.put(byteBuffer.get(position13));
                            int position14 = iPosition + 3;
                            byteBufferA00.put(byteBuffer.get(position14));
                            iPosition += 4;
                        }
                        int position15 = byteBuffer.limit();
                        byteBuffer.position(position15);
                        byteBufferA00.flip();
                        return;
                    default:
                        throw new IllegalStateException();
                }
            case 4:
            case C.ENCODING_PCM_32BIT /* 805306368 */:
                limit /= 2;
                byteBufferA00 = A00(limit);
                position = this.A05.A02;
                switch (position) {
                    case 3:
                        while (iPosition < resampledSize) {
                            byteBufferA00.put((byte) 0);
                            int position16 = byteBuffer.get(iPosition);
                            byteBufferA00.put((byte) ((position16 & 255) - 128));
                            iPosition++;
                        }
                        int position17 = byteBuffer.limit();
                        byteBuffer.position(position17);
                        byteBufferA00.flip();
                        return;
                    case 4:
                        while (iPosition < resampledSize) {
                            int position18 = (int) (32767.0f * AbstractC2471gE.A00(byteBuffer.getFloat(iPosition), -1.0f, 1.0f));
                            int limit3 = (short) position18;
                            int position19 = limit3 & 255;
                            byteBufferA00.put((byte) position19);
                            int position20 = limit3 >> 8;
                            byteBufferA00.put((byte) (position20 & 255));
                            iPosition += 4;
                        }
                        int position110 = byteBuffer.limit();
                        byteBuffer.position(position110);
                        byteBufferA00.flip();
                        return;
                    case 268435456:
                        while (iPosition < resampledSize) {
                            i = iPosition + 1;
                            if (A00[0].length() == 10) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A00;
                            strArr2[4] = "lE2Bf5epoqEX36dJZXu8HwZc9TJvlS81";
                            strArr2[2] = "bp2aTFC43ActhQwES5pwfObrZTRosGvf";
                            byteBufferA00.put(byteBuffer.get(i));
                            byteBufferA00.put(byteBuffer.get(iPosition));
                            iPosition += 2;
                        }
                        int position111 = byteBuffer.limit();
                        byteBuffer.position(position111);
                        byteBufferA00.flip();
                        return;
                    case 536870912:
                        while (iPosition < resampledSize) {
                            int position112 = iPosition + 1;
                            byteBufferA00.put(byteBuffer.get(position112));
                            int position113 = iPosition + 2;
                            byteBufferA00.put(byteBuffer.get(position113));
                            iPosition += 3;
                        }
                        int position114 = byteBuffer.limit();
                        byteBuffer.position(position114);
                        byteBufferA00.flip();
                        return;
                    case C.ENCODING_PCM_32BIT /* 805306368 */:
                        while (iPosition < resampledSize) {
                            int position115 = iPosition + 2;
                            byteBufferA00.put(byteBuffer.get(position115));
                            int position116 = iPosition + 3;
                            byteBufferA00.put(byteBuffer.get(position116));
                            iPosition += 4;
                        }
                        int position117 = byteBuffer.limit();
                        byteBuffer.position(position117);
                        byteBufferA00.flip();
                        return;
                    default:
                        throw new IllegalStateException();
                }
            case 268435456:
                byteBufferA00 = A00(limit);
                position = this.A05.A02;
                switch (position) {
                    case 3:
                        while (iPosition < resampledSize) {
                            byteBufferA00.put((byte) 0);
                            int position118 = byteBuffer.get(iPosition);
                            byteBufferA00.put((byte) ((position118 & 255) - 128));
                            iPosition++;
                        }
                        int position119 = byteBuffer.limit();
                        byteBuffer.position(position119);
                        byteBufferA00.flip();
                        return;
                    case 4:
                        while (iPosition < resampledSize) {
                            int position120 = (int) (32767.0f * AbstractC2471gE.A00(byteBuffer.getFloat(iPosition), -1.0f, 1.0f));
                            int limit4 = (short) position120;
                            int position121 = limit4 & 255;
                            byteBufferA00.put((byte) position121);
                            int position21 = limit4 >> 8;
                            byteBufferA00.put((byte) (position21 & 255));
                            iPosition += 4;
                        }
                        int position1110 = byteBuffer.limit();
                        byteBuffer.position(position1110);
                        byteBufferA00.flip();
                        return;
                    case 268435456:
                        while (iPosition < resampledSize) {
                            i = iPosition + 1;
                            if (A00[0].length() == 10) {
                                throw new RuntimeException();
                            }
                            String[] strArr3 = A00;
                            strArr3[4] = "lE2Bf5epoqEX36dJZXu8HwZc9TJvlS81";
                            strArr3[2] = "bp2aTFC43ActhQwES5pwfObrZTRosGvf";
                            byteBufferA00.put(byteBuffer.get(i));
                            byteBufferA00.put(byteBuffer.get(iPosition));
                            iPosition += 2;
                        }
                        int position1111 = byteBuffer.limit();
                        byteBuffer.position(position1111);
                        byteBufferA00.flip();
                        return;
                    case 536870912:
                        while (iPosition < resampledSize) {
                            int position1112 = iPosition + 1;
                            byteBufferA00.put(byteBuffer.get(position1112));
                            int position1113 = iPosition + 2;
                            byteBufferA00.put(byteBuffer.get(position1113));
                            iPosition += 3;
                        }
                        int position1114 = byteBuffer.limit();
                        byteBuffer.position(position1114);
                        byteBufferA00.flip();
                        return;
                    case C.ENCODING_PCM_32BIT /* 805306368 */:
                        while (iPosition < resampledSize) {
                            int position1115 = iPosition + 2;
                            byteBufferA00.put(byteBuffer.get(position1115));
                            int position1116 = iPosition + 3;
                            byteBufferA00.put(byteBuffer.get(position1116));
                            iPosition += 4;
                        }
                        int position1117 = byteBuffer.limit();
                        byteBuffer.position(position1117);
                        byteBufferA00.flip();
                        return;
                    default:
                        throw new IllegalStateException();
                }
            case 536870912:
                int i2 = limit / 3;
                String[] strArr4 = A00;
                String str = strArr4[5];
                String str2 = strArr4[6];
                int limit5 = str.charAt(23);
                int position22 = str2.charAt(23);
                if (limit5 == position22) {
                    A00[0] = "GdZd01WdGT";
                    limit = i2 * 2;
                    byteBufferA00 = A00(limit);
                    position = this.A05.A02;
                    switch (position) {
                        case 3:
                            while (iPosition < resampledSize) {
                                byteBufferA00.put((byte) 0);
                                int position1118 = byteBuffer.get(iPosition);
                                byteBufferA00.put((byte) ((position1118 & 255) - 128));
                                iPosition++;
                            }
                            int position1119 = byteBuffer.limit();
                            byteBuffer.position(position1119);
                            byteBufferA00.flip();
                            return;
                        case 4:
                            while (iPosition < resampledSize) {
                                int position122 = (int) (32767.0f * AbstractC2471gE.A00(byteBuffer.getFloat(iPosition), -1.0f, 1.0f));
                                int limit6 = (short) position122;
                                int position123 = limit6 & 255;
                                byteBufferA00.put((byte) position123);
                                int position23 = limit6 >> 8;
                                byteBufferA00.put((byte) (position23 & 255));
                                iPosition += 4;
                            }
                            int position11110 = byteBuffer.limit();
                            byteBuffer.position(position11110);
                            byteBufferA00.flip();
                            return;
                        case 268435456:
                            while (iPosition < resampledSize) {
                                i = iPosition + 1;
                                if (A00[0].length() == 10) {
                                    String[] strArr5 = A00;
                                    strArr5[4] = "lE2Bf5epoqEX36dJZXu8HwZc9TJvlS81";
                                    strArr5[2] = "bp2aTFC43ActhQwES5pwfObrZTRosGvf";
                                    byteBufferA00.put(byteBuffer.get(i));
                                    byteBufferA00.put(byteBuffer.get(iPosition));
                                    iPosition += 2;
                                }
                                break;
                            }
                            int position11111 = byteBuffer.limit();
                            byteBuffer.position(position11111);
                            byteBufferA00.flip();
                            return;
                        case 536870912:
                            while (iPosition < resampledSize) {
                                int position11112 = iPosition + 1;
                                byteBufferA00.put(byteBuffer.get(position11112));
                                int position11113 = iPosition + 2;
                                byteBufferA00.put(byteBuffer.get(position11113));
                                iPosition += 3;
                            }
                            int position11114 = byteBuffer.limit();
                            byteBuffer.position(position11114);
                            byteBufferA00.flip();
                            return;
                        case C.ENCODING_PCM_32BIT /* 805306368 */:
                            while (iPosition < resampledSize) {
                                int position11115 = iPosition + 2;
                                byteBufferA00.put(byteBuffer.get(position11115));
                                int position11116 = iPosition + 3;
                                byteBufferA00.put(byteBuffer.get(position11116));
                                iPosition += 4;
                            }
                            int position11117 = byteBuffer.limit();
                            byteBuffer.position(position11117);
                            byteBufferA00.flip();
                            return;
                        default:
                            throw new IllegalStateException();
                    }
                }
                throw new RuntimeException();
            default:
                throw new IllegalStateException();
        }
    }
}
