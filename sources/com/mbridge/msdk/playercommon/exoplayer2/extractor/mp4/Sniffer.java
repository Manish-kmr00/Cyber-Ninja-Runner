package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i) {
        if ((i >>> 8) == Util.getIntegerCodeForString("3gp")) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return sniffInternal(extractorInput, true);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z) throws InterruptedException, IOException {
        boolean z2;
        boolean z3;
        int i;
        long length = extractorInput.getLength();
        long j = -1;
        if (length == -1 || length > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            length = 4096;
        }
        int i2 = (int) length;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 < i2) {
                parsableByteArray.reset(8);
                extractorInput.peekFully(parsableByteArray.data, 0, 8);
                long unsignedInt = parsableByteArray.readUnsignedInt();
                int i4 = parsableByteArray.readInt();
                if (unsignedInt == 1) {
                    extractorInput.peekFully(parsableByteArray.data, 8, 8);
                    parsableByteArray.setLimit(16);
                    i = 16;
                    unsignedInt = parsableByteArray.readUnsignedLongToLong();
                } else {
                    if (unsignedInt == 0) {
                        long length2 = extractorInput.getLength();
                        if (length2 != j) {
                            unsignedInt = ((long) 8) + (length2 - extractorInput.getPosition());
                        }
                    }
                    i = 8;
                }
                long j2 = i;
                if (unsignedInt < j2) {
                    return false;
                }
                i3 += i;
                if (i4 != Atom.TYPE_moov) {
                    if (i4 == Atom.TYPE_moof || i4 == Atom.TYPE_mvex) {
                        z2 = true;
                        z3 = true;
                        if (!z4 && z == z3) {
                            return z2;
                        }
                    }
                    if ((((long) i3) + unsignedInt) - j2 < i2) {
                        int i5 = (int) (unsignedInt - j2);
                        i3 += i5;
                        if (i4 == Atom.TYPE_ftyp) {
                            if (i5 < 8) {
                                return false;
                            }
                            parsableByteArray.reset(i5);
                            extractorInput.peekFully(parsableByteArray.data, 0, i5);
                            int i6 = i5 / 4;
                            for (int i7 = 0; i7 < i6; i7++) {
                                if (i7 != 1) {
                                    if (isCompatibleBrand(parsableByteArray.readInt())) {
                                        z4 = true;
                                        break;
                                    }
                                } else {
                                    parsableByteArray.skipBytes(4);
                                }
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i5 != 0) {
                            extractorInput.advancePeekPosition(i5);
                        }
                        j = -1;
                    }
                }
            }
            z2 = true;
            z3 = false;
            return !z4 ? false : false;
        }
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return sniffInternal(extractorInput, false);
    }
}
