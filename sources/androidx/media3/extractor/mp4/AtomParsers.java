package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static boolean canTrimSamplesWithTimestampChange(int i) {
        return i != 1;
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == 1953653099 && (trackApply = function.apply(parseTrak(containerAtom2, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835297121))).getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + i));
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + i));
            } else if (i2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + i);
        }
        return metadata;
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 >= 0 && i5 < i) {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            } else {
                Log.w(TAG, "Skipped metadata with unknown key index: " + i5);
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> edts;
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(1835297121));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1751411826))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1953196132))).data);
        long j2 = j == -9223372036854775807L ? tkhd.duration : j;
        long j3 = parseMvhd(leafAtom.data).timescale;
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, j3) : -9223372036854775807L;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212));
        Pair<Long, String> mdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1835296868))).data);
        Atom.LeafAtom leafAtomOfType = containerAtom3.getLeafAtomOfType(1937011556);
        if (leafAtomOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsd = parseStsd(leafAtomOfType.data, tkhd.id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom.getContainerAtomOfType(1701082227)) == null || (edts = parseEdts(containerAtomOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.id, trackTypeForHdlr, ((Long) mdhd.first).longValue(), j3, jScaleLargeTimestamp, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Code duplicated, block: B:149:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:150:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:154:0x03df  */
    /* JADX WARN: Code duplicated, block: B:156:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:164:0x0426  */
    /* JADX WARN: Code duplicated, block: B:165:0x0428  */
    /* JADX WARN: Code duplicated, block: B:167:0x042c  */
    /* JADX WARN: Code duplicated, block: B:172:0x044c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0451  */
    /* JADX WARN: Code duplicated, block: B:176:0x0454  */
    /* JADX WARN: Code duplicated, block: B:178:0x0458  */
    /* JADX WARN: Code duplicated, block: B:179:0x045b  */
    /* JADX WARN: Code duplicated, block: B:181:0x045e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0460  */
    /* JADX WARN: Code duplicated, block: B:184:0x0464  */
    /* JADX WARN: Code duplicated, block: B:185:0x0467  */
    /* JADX WARN: Code duplicated, block: B:189:0x0474  */
    /* JADX WARN: Code duplicated, block: B:191:0x0482  */
    /* JADX WARN: Code duplicated, block: B:192:0x0492  */
    /* JADX WARN: Code duplicated, block: B:195:0x049a  */
    /* JADX WARN: Code duplicated, block: B:197:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:198:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:201:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:203:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:204:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:221:0x04e8 A[SYNTHETIC] */
    private static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        Track track2;
        int i5;
        long[] jArr;
        int[] iArr;
        int i6;
        long j;
        long[] jArr2;
        int[] iArr2;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        int[] iArr3;
        int[] iArr4;
        long[] jArr3;
        int i11;
        boolean z4;
        int i12;
        int i13;
        long[] jArr4;
        int[] iArr5;
        int i14;
        boolean z5;
        long[] jArr5;
        int[] iArr6;
        int i15;
        int[] iArr7;
        long[] jArr6;
        int i16;
        int i17;
        long j2;
        long j3;
        int i18;
        int i19;
        long[] jArr7;
        int i20;
        int i21;
        long jScaleLargeTimestamp;
        long j4;
        boolean z6;
        int i22;
        int i23;
        int i24;
        boolean z7;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1937011578);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType, track.format);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1937013298);
            if (leafAtomOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1937007471);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1668232756));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011555))).data;
        ParsableByteArray parsableByteArray3 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011827))).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(1937011571);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(1668576371);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt3 > 0) {
                unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                unsignedIntToInt2 = -1;
                parsableByteArray4 = null;
            }
        } else {
            unsignedIntToInt2 = -1;
            unsignedIntToInt3 = 0;
        }
        int fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        String str = track.format.sampleMimeType;
        if (fixedSampleSize != -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt3 == 0) {
            long[] jArr8 = new long[chunkIterator.length];
            int[] iArr8 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr8[chunkIterator.index] = chunkIterator.offset;
                iArr8[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr8, iArr8, unsignedIntToInt6);
            long[] jArr9 = resultsRechunk.offsets;
            int[] iArr9 = resultsRechunk.sizes;
            int i25 = resultsRechunk.maximumSize;
            long[] jArr10 = resultsRechunk.timestamps;
            int[] iArr10 = resultsRechunk.flags;
            long j5 = resultsRechunk.duration;
            track2 = track;
            i5 = sampleCount;
            jArr = jArr9;
            iArr = iArr9;
            i6 = i25;
            iArr2 = iArr10;
            j = j5;
            jArr2 = jArr10;
        } else {
            long[] jArrCopyOf = new long[sampleCount];
            int[] iArrCopyOf = new int[sampleCount];
            long[] jArrCopyOf2 = new long[sampleCount];
            int[] iArrCopyOf2 = new int[sampleCount];
            int unsignedIntToInt7 = unsignedIntToInt2;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int unsignedIntToInt8 = 0;
            long j6 = 0;
            long j7 = 0;
            int i30 = unsignedIntToInt;
            int i31 = unsignedIntToInt6;
            int i32 = unsignedIntToInt5;
            int i33 = unsignedIntToInt4;
            int i34 = unsignedIntToInt3;
            while (true) {
                i = i33;
                if (i26 >= sampleCount) {
                    i2 = i32;
                    i3 = i29;
                    break;
                }
                long j8 = j7;
                int i35 = i29;
                boolean zMoveNext = true;
                while (i35 == 0) {
                    zMoveNext = chunkIterator.moveNext();
                    if (!zMoveNext) {
                        break;
                    }
                    int i36 = i32;
                    long j9 = chunkIterator.offset;
                    i35 = chunkIterator.numSamples;
                    j8 = j9;
                    i32 = i36;
                    i31 = i31;
                    sampleCount = sampleCount;
                }
                int i37 = sampleCount;
                i2 = i32;
                int i38 = i31;
                if (!zMoveNext) {
                    Log.w(TAG, "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i26);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i26);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i26);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i26);
                    sampleCount = i26;
                    i3 = i35;
                    break;
                }
                if (parsableByteArray5 != null) {
                    while (unsignedIntToInt8 == 0 && i30 > 0) {
                        unsignedIntToInt8 = parsableByteArray5.readUnsignedIntToInt();
                        i28 = parsableByteArray5.readInt();
                        i30--;
                    }
                    unsignedIntToInt8--;
                }
                int i39 = i28;
                jArrCopyOf[i26] = j8;
                int nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                iArrCopyOf[i26] = nextSampleSize;
                if (nextSampleSize > i27) {
                    i27 = nextSampleSize;
                }
                jArrCopyOf2[i26] = j6 + ((long) i39);
                iArrCopyOf2[i26] = parsableByteArray4 == null ? 1 : 0;
                if (i26 == unsignedIntToInt7) {
                    iArrCopyOf2[i26] = 1;
                    i34--;
                    if (i34 > 0) {
                        unsignedIntToInt7 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                    }
                }
                int i40 = unsignedIntToInt7;
                j6 += (long) i38;
                int unsignedIntToInt9 = i2 - 1;
                if (unsignedIntToInt9 != 0 || i <= 0) {
                    i7 = i38;
                    i8 = i;
                } else {
                    unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                    i7 = parsableByteArray3.readInt();
                    i8 = i - 1;
                }
                int i41 = unsignedIntToInt9;
                long j10 = j8 + ((long) iArrCopyOf[i26]);
                i29 = i35 - 1;
                i26++;
                j7 = j10;
                unsignedIntToInt7 = i40;
                i31 = i7;
                sampleCount = i37;
                i28 = i39;
                i33 = i8;
                i32 = i41;
            }
            long j11 = j6 + ((long) i28);
            if (parsableByteArray5 == null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i30 <= 0) {
                    z2 = true;
                    break;
                }
                if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                    z2 = false;
                    break;
                }
                parsableByteArray5.readInt();
                i30--;
            }
            if (i34 == 0 && i2 == 0 && i3 == 0 && i == 0) {
                i4 = unsignedIntToInt8;
                if (i4 == 0 && z2) {
                    track2 = track;
                }
                i5 = sampleCount;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i6 = i27;
                j = j11;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            } else {
                i4 = unsignedIntToInt8;
            }
            track2 = track;
            Log.w(TAG, "Inconsistent stbl box for track " + track2.id + ": remainingSynchronizationSamples " + i34 + ", remainingSamplesAtTimestampDelta " + i2 + ", remainingSamplesInChunk " + i3 + ", remainingTimestampDeltaChanges " + i + ", remainingSamplesAtTimestampOffset " + i4 + (!z2 ? ", ctts invalid" : ""));
            i5 = sampleCount;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i6 = i27;
            j = j11;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        if (track2.editListDurations == null) {
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new TrackSampleTable(track, jArr, iArr, i6, jArr2, iArr2, jScaleLargeTimestamp2);
        }
        if (track2.editListDurations.length == 1 && track2.type == 1 && jArr2.length >= 2) {
            long j12 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
            long jScaleLargeTimestamp3 = j12 + Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
            i9 = i5;
            if (canApplyEditWithGaplessInfo(jArr2, j, j12, jScaleLargeTimestamp3)) {
                long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j12 - jArr2[0], track2.format.sampleRate, track2.timescale);
                i10 = i6;
                long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(j - jScaleLargeTimestamp3, track2.format.sampleRate, track2.timescale);
                if ((jScaleLargeTimestamp4 != 0 || jScaleLargeTimestamp5 != 0) && jScaleLargeTimestamp4 <= 2147483647L && jScaleLargeTimestamp5 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp4;
                    gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp5;
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(track, jArr, iArr, i10, jArr2, iArr2, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                }
            }
            if (track2.editListDurations.length != 1 && track2.editListDurations[0] == 0) {
                long j13 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
                for (int i42 = 0; i42 < jArr2.length; i42++) {
                    jArr2[i42] = Util.scaleLargeTimestamp(jArr2[i42] - j13, 1000000L, track2.timescale);
                }
                return new TrackSampleTable(track, jArr, iArr, i10, jArr2, iArr2, Util.scaleLargeTimestamp(j - j13, 1000000L, track2.timescale));
            }
            if (track2.type == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            iArr3 = new int[track2.editListDurations.length];
            iArr4 = new int[track2.editListDurations.length];
            jArr3 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
            i11 = 0;
            z4 = false;
            i12 = 0;
            i13 = 0;
            while (i11 < track2.editListDurations.length) {
                long[] jArr11 = jArr;
                int[] iArr11 = iArr;
                j4 = jArr3[i11];
                if (j4 != -1) {
                    i23 = i13;
                    boolean z8 = z4;
                    int i43 = i12;
                    long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(track2.editListDurations[i11], track2.timescale, track2.movieTimescale);
                    iArr3[i11] = Util.binarySearchFloor(jArr2, j4, true, true);
                    iArr4[i11] = Util.binarySearchCeil(jArr2, j4 + jScaleLargeTimestamp6, z3, false);
                    while (true) {
                        i24 = iArr3[i11];
                        i22 = iArr4[i11];
                        if (i24 >= i22 || (iArr2[i24] & 1) != 0) {
                            break;
                        }
                        iArr3[i11] = i24 + 1;
                    }
                    i12 = i43 + (i22 - i24);
                    if (i23 != i24) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z6 = z8 | z7;
                } else {
                    z6 = z4;
                    i22 = i13;
                }
                i11++;
                z4 = z6;
                i13 = i22;
                iArr = iArr11;
                jArr = jArr11;
            }
            jArr4 = jArr;
            iArr5 = iArr;
            boolean z9 = z4;
            i14 = 0;
            z5 = z9 | (i12 != i9);
            if (z5) {
                jArr5 = new long[i12];
            } else {
                jArr5 = jArr4;
            }
            if (z5) {
                iArr6 = new int[i12];
            } else {
                iArr6 = iArr5;
            }
            if (z5) {
                i15 = 0;
            } else {
                i15 = i10;
            }
            if (z5) {
                iArr7 = new int[i12];
            } else {
                iArr7 = iArr2;
            }
            jArr6 = new long[i12];
            i16 = i15;
            i17 = 0;
            j2 = 0;
            while (i14 < track2.editListDurations.length) {
                j3 = track2.editListMediaTimes[i14];
                i18 = iArr3[i14];
                int[] iArr12 = iArr3;
                i19 = iArr4[i14];
                int[] iArr13 = iArr4;
                if (z5) {
                    int i44 = i19 - i18;
                    jArr7 = jArr4;
                    System.arraycopy(jArr7, i18, jArr5, i17, i44);
                    System.arraycopy(iArr5, i18, iArr6, i17, i44);
                    System.arraycopy(iArr2, i18, iArr7, i17, i44);
                } else {
                    jArr7 = jArr4;
                }
                i20 = i16;
                while (i18 < i19) {
                    int i45 = i19;
                    i21 = i20;
                    long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale);
                    long[] jArr12 = jArr2;
                    int[] iArr14 = iArr2;
                    jScaleLargeTimestamp = Util.scaleLargeTimestamp(jArr2[i18] - j3, 1000000L, track2.timescale);
                    long[] jArr13 = jArr7;
                    if (canTrimSamplesWithTimestampChange(track2.type)) {
                        jScaleLargeTimestamp = Math.max(0L, jScaleLargeTimestamp);
                    }
                    jArr6[i17] = jScaleLargeTimestamp7 + jScaleLargeTimestamp;
                    if (z5) {
                        i20 = i21;
                        if (iArr6[i17] > i20) {
                            i20 = iArr5[i18];
                        }
                    } else {
                        i20 = i21;
                    }
                    i17++;
                    i18++;
                    i19 = i45;
                    iArr7 = iArr7;
                    jArr2 = jArr12;
                    iArr2 = iArr14;
                    jArr7 = jArr13;
                    j2 = j2;
                }
                i16 = i20;
                iArr7 = iArr7;
                j2 += track2.editListDurations[i14];
                jArr2 = jArr2;
                iArr2 = iArr2;
                jArr4 = jArr7;
                iArr4 = iArr13;
                i14++;
                iArr3 = iArr12;
            }
            return new TrackSampleTable(track, jArr5, iArr6, i16, jArr6, iArr7, Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale));
        }
        i9 = i5;
        i10 = i6;
        if (track2.editListDurations.length != 1) {
        }
        if (track2.type == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        iArr3 = new int[track2.editListDurations.length];
        iArr4 = new int[track2.editListDurations.length];
        jArr3 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
        i11 = 0;
        z4 = false;
        i12 = 0;
        i13 = 0;
        while (i11 < track2.editListDurations.length) {
            long[] jArr14 = jArr;
            int[] iArr15 = iArr;
            j4 = jArr3[i11];
            if (j4 != -1) {
                i23 = i13;
                boolean z10 = z4;
                int i46 = i12;
                long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(track2.editListDurations[i11], track2.timescale, track2.movieTimescale);
                iArr3[i11] = Util.binarySearchFloor(jArr2, j4, true, true);
                iArr4[i11] = Util.binarySearchCeil(jArr2, j4 + jScaleLargeTimestamp8, z3, false);
                while (true) {
                    i24 = iArr3[i11];
                    i22 = iArr4[i11];
                    if (i24 >= i22) {
                        break;
                    }
                    break;
                    break;
                    iArr3[i11] = i24 + 1;
                }
                i12 = i46 + (i22 - i24);
                if (i23 != i24) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z6 = z10 | z7;
            } else {
                z6 = z4;
                i22 = i13;
            }
            i11++;
            z4 = z6;
            i13 = i22;
            iArr = iArr15;
            jArr = jArr14;
        }
        jArr4 = jArr;
        iArr5 = iArr;
        boolean z11 = z4;
        i14 = 0;
        z5 = z11 | (i12 != i9);
        if (z5) {
            jArr5 = new long[i12];
        } else {
            jArr5 = jArr4;
        }
        if (z5) {
            iArr6 = new int[i12];
        } else {
            iArr6 = iArr5;
        }
        if (z5) {
            i15 = 0;
        } else {
            i15 = i10;
        }
        if (z5) {
            iArr7 = new int[i12];
        } else {
            iArr7 = iArr2;
        }
        jArr6 = new long[i12];
        i16 = i15;
        i17 = 0;
        j2 = 0;
        while (i14 < track2.editListDurations.length) {
            j3 = track2.editListMediaTimes[i14];
            i18 = iArr3[i14];
            int[] iArr16 = iArr3;
            i19 = iArr4[i14];
            int[] iArr17 = iArr4;
            if (z5) {
                int i47 = i19 - i18;
                jArr7 = jArr4;
                System.arraycopy(jArr7, i18, jArr5, i17, i47);
                System.arraycopy(iArr5, i18, iArr6, i17, i47);
                System.arraycopy(iArr2, i18, iArr7, i17, i47);
            } else {
                jArr7 = jArr4;
            }
            i20 = i16;
            while (i18 < i19) {
                int i48 = i19;
                i21 = i20;
                long jScaleLargeTimestamp9 = Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale);
                long[] jArr15 = jArr2;
                int[] iArr18 = iArr2;
                jScaleLargeTimestamp = Util.scaleLargeTimestamp(jArr2[i18] - j3, 1000000L, track2.timescale);
                long[] jArr16 = jArr7;
                if (canTrimSamplesWithTimestampChange(track2.type)) {
                    jScaleLargeTimestamp = Math.max(0L, jScaleLargeTimestamp);
                }
                jArr6[i17] = jScaleLargeTimestamp9 + jScaleLargeTimestamp;
                if (z5) {
                    i20 = i21;
                    if (iArr6[i17] > i20) {
                        i20 = iArr5[i18];
                    }
                } else {
                    i20 = i21;
                }
                i17++;
                i18++;
                i19 = i48;
                iArr7 = iArr7;
                jArr2 = jArr15;
                iArr2 = iArr18;
                jArr7 = jArr16;
                j2 = j2;
            }
            i16 = i20;
            iArr7 = iArr7;
            j2 += track2.editListDurations[i14];
            jArr2 = jArr2;
            iArr2 = iArr2;
            jArr4 = jArr7;
            iArr4 = iArr17;
            i14++;
            iArr3 = iArr16;
        }
        return new TrackSampleTable(track, jArr5, iArr6, i16, jArr6, iArr7, Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale));
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String string = parsableByteArray.readString(s);
        int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i4 < i2) {
                if (parsableByteArray.getData()[position + i4] != -1) {
                    long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (unsignedInt == 0) {
                        break;
                    }
                    j = unsignedInt;
                    break;
                }
                i4++;
            } else {
                parsableByteArray.skipBytes(i2);
                break;
            }
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = 180;
        }
        return new TkhdData(i, j, i3);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        parsableByteArray.setPosition(12);
        int i4 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            int position = parsableByteArray.getPosition();
            int i6 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i6 > 0, "childAtomSize must be positive");
            int i7 = parsableByteArray.readInt();
            if (i7 == 1635148593 || i7 == 1635148595 || i7 == 1701733238 || i7 == 1831958048 || i7 == 1836070006 || i7 == 1752589105 || i7 == 1751479857 || i7 == 1932670515 || i7 == 1211250227 || i7 == 1987063864 || i7 == 1987063865 || i7 == 1635135537 || i7 == 1685479798 || i7 == 1685479729 || i7 == 1685481573 || i7 == 1685481521) {
                i3 = position;
                parseVideoSampleEntry(parsableByteArray, i7, i3, i6, i, i2, drmInitData, stsdData, i5);
            } else if (i7 == 1836069985 || i7 == 1701733217 || i7 == 1633889587 || i7 == 1700998451 || i7 == 1633889588 || i7 == 1835823201 || i7 == 1685353315 || i7 == 1685353317 || i7 == 1685353320 || i7 == 1685353324 || i7 == 1685353336 || i7 == 1935764850 || i7 == 1935767394 || i7 == 1819304813 || i7 == 1936684916 || i7 == 1953984371 || i7 == 778924082 || i7 == 778924083 || i7 == 1835557169 || i7 == 1835560241 || i7 == 1634492771 || i7 == 1634492791 || i7 == 1970037111 || i7 == 1332770163 || i7 == 1716281667) {
                i3 = position;
                parseAudioSampleEntry(parsableByteArray, i7, position, i6, i, str, z, drmInitData, stsdData, i5);
            } else {
                if (i7 == 1414810956 || i7 == 1954034535 || i7 == 2004251764 || i7 == 1937010800 || i7 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, i7, position, i6, i, str, stsdData);
                } else if (i7 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray, i7, position, i, stsdData);
                } else if (i7 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
                }
                i3 = position;
            }
            parsableByteArray.setPosition(i3 + i6);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListOf).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        float f;
        int i7;
        int i8;
        int i9;
        int i10 = i2;
        int i11 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i10 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i10, i11);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str2 = "video/3gpp";
        if (iIntValue != 1831958048) {
            str = iIntValue == 1211250227 ? "video/3gpp" : null;
        } else {
            str = "video/mpeg";
        }
        float paspFromParent = 1.0f;
        int i12 = 8;
        int i13 = 8;
        List<byte[]> listOf = null;
        String str3 = null;
        byte[] projFromParent = null;
        int i14 = -1;
        int i15 = -1;
        int iIsoColorPrimariesToColorSpace = -1;
        int i16 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        ByteBuffer byteBufferAllocateHdrStaticInfo = null;
        EsdsData esdsFromParent = null;
        boolean z = false;
        while (position - i10 < i11) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i17 = parsableByteArray.readInt();
            if (i17 == 0 && parsableByteArray.getPosition() - i10 == i11) {
                break;
            }
            ExtractorUtil.checkContainerInput(i17 > 0, "childAtomSize must be positive");
            int i18 = parsableByteArray.readInt();
            if (i18 == 1635148611) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                List<byte[]> list = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                String str4 = avcConfig.codecs;
                int i19 = avcConfig.maxNumReorderFrames;
                int i20 = avcConfig.colorSpace;
                int i21 = avcConfig.colorRange;
                int i22 = avcConfig.colorTransfer;
                int i23 = avcConfig.bitdepthLuma;
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                iIntValue = iIntValue;
                str2 = str2;
                i15 = i19;
                iIsoColorPrimariesToColorSpace = i20;
                i16 = i21;
                iIsoTransferCharacteristicsToColorTransfer = i22;
                i13 = avcConfig.bitdepthChroma;
                i12 = i23;
                listOf = list;
                str = "video/avc";
                str3 = str4;
            } else if (i18 == 1752589123) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                List<byte[]> list2 = hevcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = hevcConfig.pixelWidthHeightRatio;
                }
                int i24 = hevcConfig.maxNumReorderPics;
                String str5 = hevcConfig.codecs;
                int i25 = hevcConfig.colorSpace;
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                i15 = i24;
                iIntValue = iIntValue;
                str2 = str2;
                iIsoColorPrimariesToColorSpace = i25;
                i16 = hevcConfig.colorRange;
                iIsoTransferCharacteristicsToColorTransfer = hevcConfig.colorTransfer;
                str = "video/hevc";
                i12 = hevcConfig.bitdepthLuma;
                str3 = str5;
                listOf = list2;
                i13 = hevcConfig.bitdepthChroma;
            } else {
                if (i18 == 1685480259 || i18 == 1685485123) {
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    iIntValue = iIntValue;
                    str2 = str2;
                    f = paspFromParent;
                    i7 = i12;
                    i8 = iIsoColorPrimariesToColorSpace;
                    i9 = iIsoTransferCharacteristicsToColorTransfer;
                    DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                    if (dolbyVisionConfig != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str = "video/dolby-vision";
                    }
                } else if (i18 == 1987076931) {
                    ExtractorUtil.checkContainerInput(str == null, null);
                    String str6 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    parsableByteArray.setPosition(position2 + 12);
                    parsableByteArray.skipBytes(2);
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    int i26 = unsignedByte >> 4;
                    boolean z2 = (unsignedByte & 1) != 0;
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte2);
                    i16 = z2 ? 1 : 2;
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte3);
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    i12 = i26;
                    i13 = i12;
                    iIntValue = iIntValue;
                    str2 = str2;
                    str = str6;
                } else if (i18 == 1635135811) {
                    int i27 = i17 - 8;
                    byte[] bArr = new byte[i27];
                    parsableByteArray.readBytes(bArr, 0, i27);
                    listOf = ImmutableList.of(bArr);
                    parsableByteArray.setPosition(position2 + 8);
                    ColorInfo av1c = parseAv1c(parsableByteArray);
                    int i28 = av1c.lumaBitdepth;
                    int i29 = av1c.chromaBitdepth;
                    int i30 = av1c.colorSpace;
                    int i31 = av1c.colorRange;
                    iIsoTransferCharacteristicsToColorTransfer = av1c.colorTransfer;
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    iIntValue = iIntValue;
                    str2 = str2;
                    iIsoColorPrimariesToColorSpace = i30;
                    i16 = i31;
                    str = "video/av01";
                    i12 = i28;
                    i13 = i29;
                } else if (i18 == 1668050025) {
                    if (byteBufferAllocateHdrStaticInfo == null) {
                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer = byteBufferAllocateHdrStaticInfo;
                    byteBuffer.position(21);
                    byteBuffer.putShort(parsableByteArray.readShort());
                    byteBuffer.putShort(parsableByteArray.readShort());
                    byteBufferAllocateHdrStaticInfo = byteBuffer;
                } else if (i18 == 1835295606) {
                    if (byteBufferAllocateHdrStaticInfo == null) {
                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer2 = byteBufferAllocateHdrStaticInfo;
                    short s = parsableByteArray.readShort();
                    short s2 = parsableByteArray.readShort();
                    short s3 = parsableByteArray.readShort();
                    short s4 = parsableByteArray.readShort();
                    short s5 = parsableByteArray.readShort();
                    short s6 = parsableByteArray.readShort();
                    int i32 = i12;
                    short s7 = parsableByteArray.readShort();
                    short s8 = parsableByteArray.readShort();
                    long unsignedInt = parsableByteArray.readUnsignedInt();
                    long unsignedInt2 = parsableByteArray.readUnsignedInt();
                    byteBuffer2.position(1);
                    byteBuffer2.putShort(s5);
                    byteBuffer2.putShort(s6);
                    byteBuffer2.putShort(s);
                    byteBuffer2.putShort(s2);
                    byteBuffer2.putShort(s3);
                    byteBuffer2.putShort(s4);
                    byteBuffer2.putShort(s7);
                    byteBuffer2.putShort(s8);
                    byteBuffer2.putShort((short) (unsignedInt / 10000));
                    byteBuffer2.putShort((short) (unsignedInt2 / 10000));
                    byteBufferAllocateHdrStaticInfo = byteBuffer2;
                    i12 = i32;
                    paspFromParent = paspFromParent;
                } else {
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    iIntValue = iIntValue;
                    str2 = str2;
                    f = paspFromParent;
                    i7 = i12;
                    if (i18 == 1681012275) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        str = str2;
                    } else if (i18 == 1702061171) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                        String str7 = esdsFromParent.mimeType;
                        byte[] bArr2 = esdsFromParent.initializationData;
                        if (bArr2 != null) {
                            listOf = ImmutableList.of(bArr2);
                        }
                        str = str7;
                    } else if (i18 == 1885434736) {
                        paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                        i12 = i7;
                        z = true;
                    } else if (i18 == 1937126244) {
                        projFromParent = parseProjFromParent(parsableByteArray, position2, i17);
                    } else if (i18 == 1936995172) {
                        int unsignedByte4 = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(3);
                        if (unsignedByte4 == 0) {
                            int unsignedByte5 = parsableByteArray.readUnsignedByte();
                            if (unsignedByte5 == 0) {
                                i14 = 0;
                            } else if (unsignedByte5 == 1) {
                                i14 = 1;
                            } else if (unsignedByte5 == 2) {
                                i14 = 2;
                            } else if (unsignedByte5 == 3) {
                                i14 = 3;
                            }
                        }
                    } else if (i18 == 1668246642) {
                        i8 = iIsoColorPrimariesToColorSpace;
                        i9 = iIsoTransferCharacteristicsToColorTransfer;
                        if (i8 == -1 && i9 == -1) {
                            int i33 = parsableByteArray.readInt();
                            if (i33 == TYPE_nclx || i33 == TYPE_nclc) {
                                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                parsableByteArray.skipBytes(2);
                                boolean z3 = i17 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                i16 = z3 ? 1 : 2;
                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                            } else {
                                Log.w(TAG, "Unsupported color type: " + Atom.getAtomTypeString(i33));
                            }
                        }
                        i12 = i7;
                        paspFromParent = f;
                    } else {
                        i8 = iIsoColorPrimariesToColorSpace;
                        i9 = iIsoTransferCharacteristicsToColorTransfer;
                    }
                    i12 = i7;
                    paspFromParent = f;
                }
                iIsoColorPrimariesToColorSpace = i8;
                iIsoTransferCharacteristicsToColorTransfer = i9;
                i12 = i7;
                paspFromParent = f;
            }
            position += i17;
            i10 = i2;
            i11 = i3;
            stsdData2 = stsdData;
            iIntValue = iIntValue;
            str2 = str2;
            drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        float f2 = paspFromParent;
        int i34 = i12;
        int i35 = iIsoColorPrimariesToColorSpace;
        int i36 = iIsoTransferCharacteristicsToColorTransfer;
        if (str == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i4).setSampleMimeType(str).setCodecs(str3).setWidth(unsignedShort).setHeight(unsignedShort2).setPixelWidthHeightRatio(f2).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i14).setInitializationData(listOf).setMaxNumReorderSamples(i15).setDrmInitData(drmInitData2).setColorInfo(new ColorInfo.Builder().setColorSpace(i35).setColorRange(i16).setColorTransfer(i36).setHdrStaticInfo(byteBufferAllocateHdrStaticInfo != null ? byteBufferAllocateHdrStaticInfo.array() : null).setLumaBitdepth(i34).setChromaBitdepth(i13).build());
        if (esdsFromParent != null) {
            colorInfo.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean bit = parsableBitArray.readBit();
        boolean bit2 = parsableBitArray.readBit();
        if (bits == 2 && bit) {
            builder.setLumaBitdepth(bit2 ? 12 : 10);
            builder.setChromaBitdepth(bit2 ? 12 : 10);
        } else if (bits <= 2) {
            builder.setLumaBitdepth(bit ? 10 : 8);
            builder.setChromaBitdepth(bit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int bits2 = parsableBitArray.readBits(4);
        if (bits2 != 1) {
            Log.i(TAG, "Unsupported obu_type: " + bits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean bit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (bit3 && parsableBitArray.readBits(8) > 127) {
            Log.i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int bits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int bits4 = parsableBitArray.readBits(5);
        boolean z = false;
        for (int i = 0; i <= bits4; i++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int bits5 = parsableBitArray.readBits(4);
        int bits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(bits5 + 1);
        parsableBitArray.skipBits(bits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean bit4 = parsableBitArray.readBit();
        if (bit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (bit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean bit5 = parsableBitArray.readBit();
        if (bits3 == 2 && bit5) {
            parsableBitArray.skipBit();
        }
        if (bits3 != 1 && parsableBitArray.readBit()) {
            z = true;
        }
        if (parsableBitArray.readBit()) {
            int bits7 = parsableBitArray.readBits(8);
            int bits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits7)).setColorRange(((z || bits7 != 1 || bits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8));
        }
        return builder.build();
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1701606260);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:133:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:140:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:143:0x0213  */
    /* JADX WARN: Code duplicated, block: B:144:0x0218  */
    /* JADX WARN: Code duplicated, block: B:147:0x0228  */
    /* JADX WARN: Code duplicated, block: B:149:0x022d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0238  */
    /* JADX WARN: Code duplicated, block: B:153:0x0242  */
    /* JADX WARN: Code duplicated, block: B:154:0x0247  */
    /* JADX WARN: Code duplicated, block: B:157:0x0260  */
    /* JADX WARN: Code duplicated, block: B:196:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:198:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:199:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:202:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:204:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:206:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:207:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:209:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:227:0x03fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x03fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0139  */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int unsignedShort2;
        int unsignedFixedPoint1616;
        int i6;
        int i7;
        String str2;
        String str3;
        int i8;
        String str4;
        List<byte[]> listOf;
        String str5;
        EsdsData esdsFromParent;
        int i9;
        boolean z2;
        int i10;
        String str6;
        int iFindBoxPosition;
        byte[] bArr;
        char c;
        int unsignedByte;
        byte[] bArr2;
        int unsignedByte2;
        String str7;
        byte[] bArr3;
        ImmutableList immutableListOf;
        int i11 = i2;
        int i12 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i11 + 16);
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            i6 = parsableByteArray.readInt();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            i7 = -1;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            unsignedShort2 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(4);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            int unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            boolean z3 = (unsignedIntToInt2 & 1) != 0;
            boolean z4 = (unsignedIntToInt2 & 2) != 0;
            if (z3) {
                if (unsignedIntToInt == 32) {
                    i7 = 4;
                } else {
                    i7 = -1;
                }
            } else if (unsignedIntToInt == 8) {
                i7 = 3;
            } else if (unsignedIntToInt == 16) {
                i7 = z4 ? 268435456 : 2;
            } else if (unsignedIntToInt == 24) {
                i7 = z4 ? 1342177280 : 21;
            } else if (unsignedIntToInt == 32) {
                i7 = z4 ? 1610612736 : 22;
            } else {
                i7 = -1;
            }
            parsableByteArray.skipBytes(8);
            i6 = 0;
        }
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i11, i12);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str8 = "audio/mhm1";
        if (iIntValue == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = "audio/3gpp";
        } else if (iIntValue == 1935767394) {
            str2 = "audio/amr-wb";
        } else {
            str3 = "audio/raw";
            if (iIntValue == 1936684916) {
                i8 = 2;
            } else if (iIntValue == 1953984371) {
                i8 = 268435456;
            } else if (iIntValue == 1819304813) {
                if (i7 == -1) {
                    i8 = 2;
                } else {
                    i8 = i7;
                }
            } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                str2 = "audio/mpeg";
            } else if (iIntValue == 1835557169) {
                str2 = "audio/mha1";
            } else if (iIntValue == 1835560241) {
                i8 = i7;
                str3 = "audio/mhm1";
            } else if (iIntValue == 1634492771) {
                str2 = "audio/alac";
            } else if (iIntValue == 1634492791) {
                str2 = "audio/g711-alaw";
            } else if (iIntValue == 1970037111) {
                str2 = "audio/g711-mlaw";
            } else if (iIntValue == 1332770163) {
                str2 = "audio/opus";
            } else if (iIntValue == 1716281667) {
                str2 = "audio/flac";
            } else if (iIntValue == 1835823201) {
                str2 = "audio/true-hd";
            } else {
                i8 = i7;
                str3 = null;
            }
            int i13 = i8;
            str4 = str3;
            listOf = null;
            str5 = null;
            esdsFromParent = null;
            while (position - i11 < i12) {
                parsableByteArray.setPosition(position);
                i9 = parsableByteArray.readInt();
                if (i9 > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ExtractorUtil.checkContainerInput(z2, "childAtomSize must be positive");
                i10 = parsableByteArray.readInt();
                if (i10 == 1835557187) {
                    parsableByteArray.setPosition(position + 8);
                    parsableByteArray.skipBytes(1);
                    unsignedByte2 = parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (Objects.equals(str4, str8)) {
                        str7 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte2));
                    } else {
                        str7 = String.format("mha1.%02X", Integer.valueOf(unsignedByte2));
                    }
                    String str9 = str7;
                    int unsignedShort3 = parsableByteArray.readUnsignedShort();
                    bArr3 = new byte[unsignedShort3];
                    parsableByteArray.readBytes(bArr3, 0, unsignedShort3);
                    if (listOf == null) {
                        immutableListOf = ImmutableList.of(bArr3);
                    } else {
                        immutableListOf = ImmutableList.of(bArr3, listOf.get(0));
                    }
                    listOf = immutableListOf;
                    str5 = str9;
                } else {
                    if (i10 == 1835557200) {
                        parsableByteArray.setPosition(position + 8);
                        unsignedByte = parsableByteArray.readUnsignedByte();
                        if (unsignedByte > 0) {
                            bArr2 = new byte[unsignedByte];
                            str6 = str8;
                            parsableByteArray.readBytes(bArr2, 0, unsignedByte);
                            if (listOf == null) {
                                listOf = ImmutableList.of(bArr2);
                            } else {
                                listOf = ImmutableList.of(listOf.get(0), bArr2);
                            }
                        }
                    } else {
                        str6 = str8;
                        if (i10 != 1702061171 || (z && i10 == 2002876005)) {
                            if (i10 == 1702061171) {
                                iFindBoxPosition = position;
                            } else {
                                iFindBoxPosition = findBoxPosition(parsableByteArray, 1702061171, position, i9);
                            }
                            if (iFindBoxPosition != -1) {
                                esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                                str4 = esdsFromParent.mimeType;
                                bArr = esdsFromParent.initializationData;
                                if (bArr != null) {
                                    if ("audio/vorbis".equals(str4)) {
                                        listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                    } else {
                                        if ("audio/mp4a-latm".equals(str4)) {
                                            AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
                                            int i14 = audioSpecificConfig.sampleRateHz;
                                            int i15 = audioSpecificConfig.channelCount;
                                            str5 = audioSpecificConfig.codecs;
                                            unsignedFixedPoint1616 = i14;
                                            unsignedShort2 = i15;
                                        }
                                        listOf = ImmutableList.of(bArr);
                                    }
                                }
                            }
                        } else {
                            if (i10 == 1684103987) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i10 == 1684366131) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i10 == 1684103988) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i10 == 1684892784) {
                                if (i6 <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i6, null);
                                }
                                unsignedFixedPoint1616 = i6;
                                unsignedShort2 = 2;
                            } else if (i10 == 1684305011 || i10 == 1969517683) {
                                c = 24931;
                                stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                            } else if (i10 == 1682927731) {
                                int i16 = i9 - 8;
                                byte[] bArr4 = opusMagic;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i16);
                                parsableByteArray.setPosition(position + 8);
                                parsableByteArray.readBytes(bArrCopyOf, bArr4.length, i16);
                                listOf = OpusUtil.buildInitializationData(bArrCopyOf);
                            } else if (i10 == 1684425825) {
                                byte[] bArr5 = new byte[i9 - 8];
                                bArr5[0] = 102;
                                bArr5[1] = 76;
                                bArr5[2] = 97;
                                bArr5[3] = 67;
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr5, 4, i9 - 12);
                                listOf = ImmutableList.of(bArr5);
                            } else {
                                c = 24931;
                                if (i10 == 1634492771) {
                                    int i17 = i9 - 12;
                                    byte[] bArr6 = new byte[i17];
                                    parsableByteArray.setPosition(position + 12);
                                    parsableByteArray.readBytes(bArr6, 0, i17);
                                    Pair<Integer, Integer> alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr6);
                                    int iIntValue2 = ((Integer) alacAudioSpecificConfig.first).intValue();
                                    unsignedShort2 = ((Integer) alacAudioSpecificConfig.second).intValue();
                                    listOf = ImmutableList.of(bArr6);
                                    unsignedFixedPoint1616 = iIntValue2;
                                }
                            }
                            c = 24931;
                        }
                        position += i9;
                        i11 = i2;
                        i12 = i3;
                        str8 = str6;
                    }
                    position += i9;
                    i11 = i2;
                    i12 = i3;
                    str8 = str6;
                }
                str6 = str8;
                position += i9;
                i11 = i2;
                i12 = i3;
                str8 = str6;
            }
            if (stsdData.format == null || str4 == null) {
            }
            Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setPcmEncoding(i13).setInitializationData(listOf).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str);
            if (esdsFromParent != null) {
                language.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
            }
            stsdData.format = language.build();
            return;
        }
        str3 = str2;
        i8 = i7;
        int i18 = i8;
        str4 = str3;
        listOf = null;
        str5 = null;
        esdsFromParent = null;
        while (position - i11 < i12) {
            parsableByteArray.setPosition(position);
            i9 = parsableByteArray.readInt();
            if (i9 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            ExtractorUtil.checkContainerInput(z2, "childAtomSize must be positive");
            i10 = parsableByteArray.readInt();
            if (i10 == 1835557187) {
                parsableByteArray.setPosition(position + 8);
                parsableByteArray.skipBytes(1);
                unsignedByte2 = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(1);
                if (Objects.equals(str4, str8)) {
                    str7 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte2));
                } else {
                    str7 = String.format("mha1.%02X", Integer.valueOf(unsignedByte2));
                }
                String str10 = str7;
                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                bArr3 = new byte[unsignedShort4];
                parsableByteArray.readBytes(bArr3, 0, unsignedShort4);
                if (listOf == null) {
                    immutableListOf = ImmutableList.of(bArr3);
                } else {
                    immutableListOf = ImmutableList.of(bArr3, listOf.get(0));
                }
                listOf = immutableListOf;
                str5 = str10;
            } else {
                if (i10 == 1835557200) {
                    parsableByteArray.setPosition(position + 8);
                    unsignedByte = parsableByteArray.readUnsignedByte();
                    if (unsignedByte > 0) {
                        bArr2 = new byte[unsignedByte];
                        str6 = str8;
                        parsableByteArray.readBytes(bArr2, 0, unsignedByte);
                        if (listOf == null) {
                            listOf = ImmutableList.of(bArr2);
                        } else {
                            listOf = ImmutableList.of(listOf.get(0), bArr2);
                        }
                    }
                } else {
                    str6 = str8;
                    if (i10 != 1702061171) {
                        if (i10 == 1702061171) {
                            iFindBoxPosition = position;
                        } else {
                            iFindBoxPosition = findBoxPosition(parsableByteArray, 1702061171, position, i9);
                        }
                        if (iFindBoxPosition != -1) {
                            esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                            str4 = esdsFromParent.mimeType;
                            bArr = esdsFromParent.initializationData;
                            if (bArr != null) {
                                if ("audio/vorbis".equals(str4)) {
                                    listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                } else {
                                    if ("audio/mp4a-latm".equals(str4)) {
                                        AacUtil.Config audioSpecificConfig2 = AacUtil.parseAudioSpecificConfig(bArr);
                                        int i19 = audioSpecificConfig2.sampleRateHz;
                                        int i110 = audioSpecificConfig2.channelCount;
                                        str5 = audioSpecificConfig2.codecs;
                                        unsignedFixedPoint1616 = i19;
                                        unsignedShort2 = i110;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        }
                    } else {
                        if (i10 == 1702061171) {
                            iFindBoxPosition = position;
                        } else {
                            iFindBoxPosition = findBoxPosition(parsableByteArray, 1702061171, position, i9);
                        }
                        if (iFindBoxPosition != -1) {
                            esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                            str4 = esdsFromParent.mimeType;
                            bArr = esdsFromParent.initializationData;
                            if (bArr != null) {
                                if ("audio/vorbis".equals(str4)) {
                                    listOf = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                } else {
                                    if ("audio/mp4a-latm".equals(str4)) {
                                        AacUtil.Config audioSpecificConfig3 = AacUtil.parseAudioSpecificConfig(bArr);
                                        int i111 = audioSpecificConfig3.sampleRateHz;
                                        int i112 = audioSpecificConfig3.channelCount;
                                        str5 = audioSpecificConfig3.codecs;
                                        unsignedFixedPoint1616 = i111;
                                        unsignedShort2 = i112;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        }
                    }
                    position += i9;
                    i11 = i2;
                    i12 = i3;
                    str8 = str6;
                }
                position += i9;
                i11 = i2;
                i12 = i3;
                str8 = str6;
            }
            str6 = str8;
            position += i9;
            i11 = i2;
            i12 = i3;
            str8 = str6;
        }
        if (stsdData.format == null) {
        }
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int i4 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += i4;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, unsignedInt2 > 0 ? unsignedInt2 : -1L, unsignedInt > 0 ? unsignedInt : -1L);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String string = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == 1935894633) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!"cenc".equals(string) && !"cbc1".equals(string) && !"cens".equals(string) && !"cbcs".equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long unsignedInt;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                unsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                unsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = unsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    private static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if ("audio/raw".equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(AtomParsers.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int unsignedByte = this.data.readUnsignedByte();
                this.currentByte = unsignedByte;
                return (unsignedByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
