package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig;
import com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo;
import com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class MatroskaExtractor implements Extractor {
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private long blockDurationUs;
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int[] blockLacingSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new MatroskaExtractor()};
        }
    };
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SUBRIP_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] SSA_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private final class InnerEbmlReaderOutput implements EbmlReaderOutput {
        private InnerEbmlReaderOutput() {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws InterruptedException, IOException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void floatElement(int i, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public int getElementType(int i) {
            switch (i) {
                case 131:
                case 136:
                case MatroskaExtractor.ID_BLOCK_DURATION /* 155 */:
                case MatroskaExtractor.ID_CHANNELS /* 159 */:
                case MatroskaExtractor.ID_PIXEL_WIDTH /* 176 */:
                case MatroskaExtractor.ID_CUE_TIME /* 179 */:
                case MatroskaExtractor.ID_PIXEL_HEIGHT /* 186 */:
                case 215:
                case MatroskaExtractor.ID_TIME_CODE /* 231 */:
                case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /* 241 */:
                case MatroskaExtractor.ID_REFERENCE_BLOCK /* 251 */:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                case MatroskaExtractor.ID_DOC_TYPE_READ_VERSION /* 17029 */:
                case MatroskaExtractor.ID_EBML_READ_VERSION /* 17143 */:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                case MatroskaExtractor.ID_CONTENT_ENCODING_ORDER /* 20529 */:
                case MatroskaExtractor.ID_CONTENT_ENCODING_SCOPE /* 20530 */:
                case MatroskaExtractor.ID_SEEK_POSITION /* 21420 */:
                case MatroskaExtractor.ID_STEREO_MODE /* 21432 */:
                case MatroskaExtractor.ID_DISPLAY_WIDTH /* 21680 */:
                case MatroskaExtractor.ID_DISPLAY_UNIT /* 21682 */:
                case MatroskaExtractor.ID_DISPLAY_HEIGHT /* 21690 */:
                case MatroskaExtractor.ID_FLAG_FORCED /* 21930 */:
                case MatroskaExtractor.ID_COLOUR_RANGE /* 21945 */:
                case MatroskaExtractor.ID_COLOUR_TRANSFER /* 21946 */:
                case MatroskaExtractor.ID_COLOUR_PRIMARIES /* 21947 */:
                case MatroskaExtractor.ID_MAX_CLL /* 21948 */:
                case MatroskaExtractor.ID_MAX_FALL /* 21949 */:
                case MatroskaExtractor.ID_CODEC_DELAY /* 22186 */:
                case MatroskaExtractor.ID_SEEK_PRE_ROLL /* 22203 */:
                case MatroskaExtractor.ID_AUDIO_BIT_DEPTH /* 25188 */:
                case MatroskaExtractor.ID_DEFAULT_DURATION /* 2352003 */:
                case MatroskaExtractor.ID_TIMECODE_SCALE /* 2807729 */:
                    return 2;
                case 134:
                case 17026:
                case MatroskaExtractor.ID_LANGUAGE /* 2274716 */:
                    return 3;
                case MatroskaExtractor.ID_BLOCK_GROUP /* 160 */:
                case MatroskaExtractor.ID_TRACK_ENTRY /* 174 */:
                case MatroskaExtractor.ID_CUE_TRACK_POSITIONS /* 183 */:
                case MatroskaExtractor.ID_CUE_POINT /* 187 */:
                case 224:
                case MatroskaExtractor.ID_AUDIO /* 225 */:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS /* 18407 */:
                case MatroskaExtractor.ID_SEEK /* 19899 */:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION /* 20532 */:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION /* 20533 */:
                case MatroskaExtractor.ID_COLOUR /* 21936 */:
                case MatroskaExtractor.ID_MASTERING_METADATA /* 21968 */:
                case MatroskaExtractor.ID_CONTENT_ENCODING /* 25152 */:
                case MatroskaExtractor.ID_CONTENT_ENCODINGS /* 28032 */:
                case MatroskaExtractor.ID_PROJECTION /* 30320 */:
                case MatroskaExtractor.ID_SEEK_HEAD /* 290298740 */:
                case 357149030:
                case MatroskaExtractor.ID_TRACKS /* 374648427 */:
                case MatroskaExtractor.ID_SEGMENT /* 408125543 */:
                case MatroskaExtractor.ID_EBML /* 440786851 */:
                case MatroskaExtractor.ID_CUES /* 475249515 */:
                case MatroskaExtractor.ID_CLUSTER /* 524531317 */:
                    return 1;
                case MatroskaExtractor.ID_BLOCK /* 161 */:
                case MatroskaExtractor.ID_SIMPLE_BLOCK /* 163 */:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION_SETTINGS /* 16981 */:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_KEY_ID /* 18402 */:
                case MatroskaExtractor.ID_SEEK_ID /* 21419 */:
                case MatroskaExtractor.ID_CODEC_PRIVATE /* 25506 */:
                case MatroskaExtractor.ID_PROJECTION_PRIVATE /* 30322 */:
                    return 4;
                case MatroskaExtractor.ID_SAMPLING_FREQUENCY /* 181 */:
                case MatroskaExtractor.ID_DURATION /* 17545 */:
                case MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                case MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                case MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                case MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                case MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                case MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                case MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                case MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                case MatroskaExtractor.ID_LUMNINANCE_MAX /* 21977 */:
                case MatroskaExtractor.ID_LUMNINANCE_MIN /* 21978 */:
                    return 5;
                default:
                    return 0;
            }
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public boolean isLevel1Element(int i) {
            return i == 357149030 || i == MatroskaExtractor.ID_CLUSTER || i == MatroskaExtractor.ID_CUES || i == MatroskaExtractor.ID_TRACKS;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }
    }

    private static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        private String language;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.put((byte) 0);
            byteBufferWrap.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) (this.maxMasteringLuminance + 0.5f));
            byteBufferWrap.putShort((short) (this.minMasteringLuminance + 0.5f));
            byteBufferWrap.putShort((short) this.maxContentLuminance);
            byteBufferWrap.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (littleEndianUnsignedInt == 1482049860) {
                    return new Pair<>("video/3gpp", null);
                }
                if (littleEndianUnsignedInt != 826496599) {
                    Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>("video/x-unknown", null);
                }
                byte[] bArr = parsableByteArray.data;
                for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                    if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length)));
                    }
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort == 1) {
                    return true;
                }
                if (littleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                return parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if (i != -1) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + i;
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if (i2 != -1) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (bArr[i8] != 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:174:0x0341  */
        /* JADX WARN: Code duplicated, block: B:177:0x0349  */
        /* JADX WARN: Code duplicated, block: B:178:0x036f  */
        /* JADX WARN: Code duplicated, block: B:180:0x0375  */
        /* JADX WARN: Code duplicated, block: B:182:0x0379  */
        /* JADX WARN: Code duplicated, block: B:184:0x037e  */
        /* JADX WARN: Code duplicated, block: B:187:0x0386  */
        /* JADX WARN: Code duplicated, block: B:189:0x038b  */
        /* JADX WARN: Code duplicated, block: B:192:0x0390  */
        /* JADX WARN: Code duplicated, block: B:195:0x039e  */
        /* JADX WARN: Code duplicated, block: B:198:0x03a6  */
        /* JADX WARN: Code duplicated, block: B:199:0x03b8  */
        /* JADX WARN: Code duplicated, block: B:201:0x03e5  */
        /* JADX WARN: Code duplicated, block: B:203:0x03eb  */
        /* JADX WARN: Code duplicated, block: B:205:0x03fa  */
        /* JADX WARN: Code duplicated, block: B:207:0x0400  */
        /* JADX WARN: Code duplicated, block: B:208:0x0433  */
        /* JADX WARN: Code duplicated, block: B:210:0x0439  */
        /* JADX WARN: Code duplicated, block: B:4:0x0018  */
        public void initializeOutput(ExtractorOutput extractorOutput, int i) throws ParserException {
            byte b;
            List<byte[]> listSingletonList;
            String str;
            int pcmEncoding;
            List<byte[]> vorbisCodecPrivate;
            String str2;
            int i2;
            int i3;
            List<byte[]> listSingletonList2;
            String str3;
            int i4;
            int i5;
            Format formatCreateImageSampleFormat;
            int i6;
            int i7;
            float f;
            ColorInfo colorInfo;
            int i8;
            int i9;
            int i10;
            String str4 = this.codecId;
            str4.hashCode();
            str4.hashCode();
            int i11 = 1;
            switch (str4) {
                case "V_MPEG4/ISO/AP":
                    b = 0;
                    break;
                case "V_MPEG4/ISO/SP":
                    b = 1;
                    break;
                case "A_MS/ACM":
                    b = 2;
                    break;
                case "A_TRUEHD":
                    b = 3;
                    break;
                case "A_VORBIS":
                    b = 4;
                    break;
                case "A_MPEG/L2":
                    b = 5;
                    break;
                case "A_MPEG/L3":
                    b = 6;
                    break;
                case "V_MS/VFW/FOURCC":
                    b = 7;
                    break;
                case "S_DVBSUB":
                    b = 8;
                    break;
                case "V_MPEG4/ISO/ASP":
                    b = 9;
                    break;
                case "V_MPEG4/ISO/AVC":
                    b = 10;
                    break;
                case "S_VOBSUB":
                    b = Ascii.VT;
                    break;
                case "A_DTS/LOSSLESS":
                    b = Ascii.FF;
                    break;
                case "A_AAC":
                    b = Ascii.CR;
                    break;
                case "A_AC3":
                    b = Ascii.SO;
                    break;
                case "A_DTS":
                    b = Ascii.SI;
                    break;
                case "V_VP8":
                    b = Ascii.DLE;
                    break;
                case "V_VP9":
                    b = 17;
                    break;
                case "S_HDMV/PGS":
                    b = Ascii.DC2;
                    break;
                case "V_THEORA":
                    b = 19;
                    break;
                case "A_DTS/EXPRESS":
                    b = Ascii.DC4;
                    break;
                case "A_PCM/INT/LIT":
                    b = Ascii.NAK;
                    break;
                case "S_TEXT/ASS":
                    b = Ascii.SYN;
                    break;
                case "V_MPEGH/ISO/HEVC":
                    b = Ascii.ETB;
                    break;
                case "S_TEXT/UTF8":
                    b = Ascii.CAN;
                    break;
                case "V_MPEG2":
                    b = Ascii.EM;
                    break;
                case "A_EAC3":
                    b = Ascii.SUB;
                    break;
                case "A_FLAC":
                    b = Ascii.ESC;
                    break;
                case "A_OPUS":
                    b = Ascii.FS;
                    break;
                default:
                    b = -1;
                    break;
            }
            String str5 = "audio/raw";
            switch (b) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr = this.codecPrivate;
                    listSingletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str = "video/mp4v-es";
                    str5 = str;
                    listSingletonList2 = listSingletonList;
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    } else if (MimeTypes.isVideo(str2)) {
                        if (this.displayUnit == 0) {
                            i9 = this.displayWidth;
                            i6 = -1;
                            if (i9 == -1) {
                                i9 = this.width;
                            }
                            this.displayWidth = i9;
                            i10 = this.displayHeight;
                            if (i10 == -1) {
                                i10 = this.height;
                            }
                            this.displayHeight = i10;
                        } else {
                            i6 = -1;
                        }
                        i7 = this.displayWidth;
                        if (i7 != i6 || (i8 = this.displayHeight) == i6) {
                            f = -1.0f;
                        } else {
                            f = (this.height * i7) / (this.width * i8);
                        }
                        float f2 = f;
                        if (this.hasColorInfo) {
                            colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                        } else {
                            colorInfo = null;
                        }
                        formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f2, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                        i11 = 2;
                    } else {
                        if ("application/x-subrip".equals(str2)) {
                            formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                        } else if ("text/x-ssa".equals(str2)) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                            arrayList.add(this.codecPrivate);
                            formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList);
                        } else {
                            if ("application/vobsub".equals(str2) && !"application/pgs".equals(str2) && !"application/dvbsubs".equals(str2)) {
                                throw new ParserException("Unexpected MIME type.");
                            }
                            formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                        }
                        i11 = 3;
                    }
                    TrackOutput trackOutputTrack = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack;
                    trackOutputTrack.format(formatCreateImageSampleFormat);
                    return;
                case 2:
                    if (parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate))) {
                        pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        }
                        listSingletonList2 = null;
                        i4 = pcmEncoding;
                        vorbisCodecPrivate = listSingletonList2;
                        str2 = str5;
                        i3 = -1;
                        i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                        if (MimeTypes.isAudio(str2)) {
                            if (MimeTypes.isVideo(str2)) {
                                if (this.displayUnit == 0) {
                                    i9 = this.displayWidth;
                                    i6 = -1;
                                    if (i9 == -1) {
                                        i9 = this.width;
                                    }
                                    this.displayWidth = i9;
                                    i10 = this.displayHeight;
                                    if (i10 == -1) {
                                        i10 = this.height;
                                    }
                                    this.displayHeight = i10;
                                } else {
                                    i6 = -1;
                                }
                                i7 = this.displayWidth;
                                if (i7 != i6) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                float f3 = f;
                                if (this.hasColorInfo) {
                                    colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                                } else {
                                    colorInfo = null;
                                }
                                formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f3, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                                i11 = 2;
                            } else {
                                if ("application/x-subrip".equals(str2)) {
                                    formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                                } else if ("text/x-ssa".equals(str2)) {
                                    ArrayList arrayList2 = new ArrayList(2);
                                    arrayList2.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                    arrayList2.add(this.codecPrivate);
                                    formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList2);
                                } else {
                                    if ("application/vobsub".equals(str2)) {
                                    }
                                    formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                                }
                                i11 = 3;
                            }
                            break;
                        } else {
                            formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                        }
                        TrackOutput trackOutputTrack2 = extractorOutput.track(this.number, i11);
                        this.output = trackOutputTrack2;
                        trackOutputTrack2.format(formatCreateImageSampleFormat);
                        return;
                    }
                    Log.w(MatroskaExtractor.TAG, "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    str5 = "audio/x-unknown";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f4 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f4, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList3 = new ArrayList(2);
                                arrayList3.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList3.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList3);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack3 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack3;
                    trackOutputTrack3.format(formatCreateImageSampleFormat);
                    return;
                case 3:
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str5 = "audio/true-hd";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f5 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f5, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList4 = new ArrayList(2);
                                arrayList4.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList4.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList4);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack4 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack4;
                    trackOutputTrack4.format(formatCreateImageSampleFormat);
                    return;
                case 4:
                    vorbisCodecPrivate = parseVorbisCodecPrivate(this.codecPrivate);
                    str2 = "audio/vorbis";
                    i2 = 8192;
                    i3 = i2;
                    i4 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f6 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f6, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList5 = new ArrayList(2);
                                arrayList5.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList5.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList5);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack5 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack5;
                    trackOutputTrack5.format(formatCreateImageSampleFormat);
                    return;
                case 5:
                    str2 = "audio/mpeg-L2";
                    i3 = 4096;
                    vorbisCodecPrivate = null;
                    i4 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f7 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f7, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList6 = new ArrayList(2);
                                arrayList6.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList6.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList6);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack6 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack6;
                    trackOutputTrack6.format(formatCreateImageSampleFormat);
                    return;
                case 6:
                    str2 = "audio/mpeg";
                    i3 = 4096;
                    vorbisCodecPrivate = null;
                    i4 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f8 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f8, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList7 = new ArrayList(2);
                                arrayList7.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList7.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList7);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack7 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack7;
                    trackOutputTrack7.format(formatCreateImageSampleFormat);
                    return;
                case 7:
                    Pair<String, List<byte[]>> fourCcPrivate = parseFourCcPrivate(new ParsableByteArray(this.codecPrivate));
                    str = (String) fourCcPrivate.first;
                    listSingletonList = (List) fourCcPrivate.second;
                    str5 = str;
                    listSingletonList2 = listSingletonList;
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f9 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f9, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList8 = new ArrayList(2);
                                arrayList8.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList8.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList8);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack8 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack8;
                    trackOutputTrack8.format(formatCreateImageSampleFormat);
                    return;
                case 8:
                    byte[] bArr2 = this.codecPrivate;
                    listSingletonList2 = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str5 = "application/dvbsubs";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f10 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f10, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList9 = new ArrayList(2);
                                arrayList9.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList9.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList9);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack9 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack9;
                    trackOutputTrack9.format(formatCreateImageSampleFormat);
                    return;
                case 10:
                    AvcConfig avcConfig = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    listSingletonList2 = avcConfig.initializationData;
                    this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                    str3 = "video/avc";
                    str5 = str3;
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f11 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f11, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList10 = new ArrayList(2);
                                arrayList10.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList10.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList10);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack10 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack10;
                    trackOutputTrack10.format(formatCreateImageSampleFormat);
                    return;
                case 11:
                    listSingletonList2 = Collections.singletonList(this.codecPrivate);
                    str5 = "application/vobsub";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f12 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f12, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList11 = new ArrayList(2);
                                arrayList11.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList11.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList11);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack11 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack11;
                    trackOutputTrack11.format(formatCreateImageSampleFormat);
                    return;
                case 12:
                    str5 = "audio/vnd.dts.hd";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f13 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f13, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList12 = new ArrayList(2);
                                arrayList12.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList12.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList12);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack12 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack12;
                    trackOutputTrack12.format(formatCreateImageSampleFormat);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(this.codecPrivate);
                    str = "audio/mp4a-latm";
                    str5 = str;
                    listSingletonList2 = listSingletonList;
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f14 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f14, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList13 = new ArrayList(2);
                                arrayList13.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList13.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList13);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack13 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack13;
                    trackOutputTrack13.format(formatCreateImageSampleFormat);
                    return;
                case 14:
                    str5 = "audio/ac3";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f15 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f15, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList14 = new ArrayList(2);
                                arrayList14.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList14.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList14);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack14 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack14;
                    trackOutputTrack14.format(formatCreateImageSampleFormat);
                    return;
                case 15:
                case 20:
                    str5 = "audio/vnd.dts";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f16 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f16, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList15 = new ArrayList(2);
                                arrayList15.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList15.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList15);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack15 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack15;
                    trackOutputTrack15.format(formatCreateImageSampleFormat);
                    return;
                case 16:
                    str5 = "video/x-vnd.on2.vp8";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f17 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f17, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList16 = new ArrayList(2);
                                arrayList16.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList16.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList16);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack16 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack16;
                    trackOutputTrack16.format(formatCreateImageSampleFormat);
                    return;
                case 17:
                    str5 = "video/x-vnd.on2.vp9";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f18 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f18, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList17 = new ArrayList(2);
                                arrayList17.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList17.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList17);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack17 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack17;
                    trackOutputTrack17.format(formatCreateImageSampleFormat);
                    return;
                case 18:
                    str5 = "application/pgs";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f19 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f19, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList18 = new ArrayList(2);
                                arrayList18.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList18.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList18);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack18 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack18;
                    trackOutputTrack18.format(formatCreateImageSampleFormat);
                    return;
                case 19:
                    str5 = "video/x-unknown";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f110 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f110, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList19 = new ArrayList(2);
                                arrayList19.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList19.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList19);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack19 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack19;
                    trackOutputTrack19.format(formatCreateImageSampleFormat);
                    return;
                case 21:
                    pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding == 0) {
                        Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        str5 = "audio/x-unknown";
                        pcmEncoding = -1;
                    }
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f111 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f111, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList110 = new ArrayList(2);
                                arrayList110.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList110.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList110);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack110 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack110;
                    trackOutputTrack110.format(formatCreateImageSampleFormat);
                    return;
                case 22:
                    str5 = "text/x-ssa";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f112 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f112, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList111 = new ArrayList(2);
                                arrayList111.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList111.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList111);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack111 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack111;
                    trackOutputTrack111.format(formatCreateImageSampleFormat);
                    return;
                case 23:
                    HevcConfig hevcConfig = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    listSingletonList2 = hevcConfig.initializationData;
                    this.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    str3 = "video/hevc";
                    str5 = str3;
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f113 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f113, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList112 = new ArrayList(2);
                                arrayList112.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList112.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList112);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack112 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack112;
                    trackOutputTrack112.format(formatCreateImageSampleFormat);
                    return;
                case 24:
                    str5 = "application/x-subrip";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f114 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f114, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList113 = new ArrayList(2);
                                arrayList113.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList113.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList113);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack113 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack113;
                    trackOutputTrack113.format(formatCreateImageSampleFormat);
                    return;
                case 25:
                    str5 = "video/mpeg2";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f115 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f115, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList114 = new ArrayList(2);
                                arrayList114.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList114.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList114);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack114 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack114;
                    trackOutputTrack114.format(formatCreateImageSampleFormat);
                    return;
                case 26:
                    str5 = "audio/eac3";
                    pcmEncoding = -1;
                    listSingletonList2 = null;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f116 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f116, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList115 = new ArrayList(2);
                                arrayList115.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList115.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList115);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack115 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack115;
                    trackOutputTrack115.format(formatCreateImageSampleFormat);
                    return;
                case 27:
                    listSingletonList = Collections.singletonList(this.codecPrivate);
                    str = "audio/flac";
                    str5 = str;
                    listSingletonList2 = listSingletonList;
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    vorbisCodecPrivate = listSingletonList2;
                    str2 = str5;
                    i3 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f117 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f117, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList116 = new ArrayList(2);
                                arrayList116.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList116.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList116);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack116 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack116;
                    trackOutputTrack116.format(formatCreateImageSampleFormat);
                    return;
                case 28:
                    vorbisCodecPrivate = new ArrayList<>(3);
                    vorbisCodecPrivate.add(this.codecPrivate);
                    vorbisCodecPrivate.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.codecDelayNs).array());
                    vorbisCodecPrivate.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.seekPreRollNs).array());
                    str2 = "audio/opus";
                    i2 = MatroskaExtractor.OPUS_MAX_INPUT_SIZE;
                    i3 = i2;
                    i4 = -1;
                    i5 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : 0);
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i9 = this.displayWidth;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.width;
                                }
                                this.displayWidth = i9;
                                i10 = this.displayHeight;
                                if (i10 == -1) {
                                    i10 = this.height;
                                }
                                this.displayHeight = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.displayWidth;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f118 = f;
                            if (this.hasColorInfo) {
                                colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                            } else {
                                colorInfo = null;
                            }
                            formatCreateImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i), str2, null, -1, i3, this.width, this.height, -1.0f, vorbisCodecPrivate, -1, f118, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                            i11 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, i5, this.language, this.drmInitData);
                            } else if ("text/x-ssa".equals(str2)) {
                                ArrayList arrayList117 = new ArrayList(2);
                                arrayList117.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                                arrayList117.add(this.codecPrivate);
                                formatCreateImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i), str2, null, -1, i5, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList117);
                            } else {
                                if ("application/vobsub".equals(str2)) {
                                }
                                formatCreateImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i), str2, null, -1, i5, vorbisCodecPrivate, this.language, this.drmInitData);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatCreateImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i), str2, null, -1, i3, this.channelCount, this.sampleRate, i4, vorbisCodecPrivate, this.drmInitData, i5, this.language);
                    }
                    TrackOutput trackOutputTrack117 = extractorOutput.track(this.number, i11);
                    this.output = trackOutputTrack117;
                    trackOutputTrack117.format(formatCreateImageSampleFormat);
                    return;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
        }

        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    private static final class TrueHdSampleRechunker {
        private int blockFlags;
        private int chunkSize;
        private boolean foundSyncframe;
        private int sampleCount;
        private final byte[] syncframePrefix = new byte[10];
        private long timeUs;

        public void outputPendingSampleMetadata(Track track) {
            if (!this.foundSyncframe || this.sampleCount <= 0) {
                return;
            }
            track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
            this.sampleCount = 0;
        }

        public void reset() {
            this.foundSyncframe = false;
        }

        public void sampleMetadata(Track track, long j) {
            if (this.foundSyncframe) {
                int i = this.sampleCount;
                int i2 = i + 1;
                this.sampleCount = i2;
                if (i == 0) {
                    this.timeUs = j;
                }
                if (i2 < 16) {
                    return;
                }
                track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                this.sampleCount = 0;
            }
        }

        public void startSample(ExtractorInput extractorInput, int i, int i2) throws InterruptedException, IOException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 10);
                extractorInput.resetPeekPosition();
                if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) == -1) {
                    return;
                }
                this.foundSyncframe = true;
                this.sampleCount = 0;
            }
            if (this.sampleCount == 0) {
                this.blockFlags = i;
                this.chunkSize = 0;
            }
            this.chunkSize += i2;
        }
    }

    public MatroskaExtractor() {
        this(0);
    }

    private SeekMap buildSeekMap() {
        LongArray longArray;
        LongArray longArray2;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || (longArray = this.cueTimesUs) == null || longArray.size() == 0 || (longArray2 = this.cueClusterPositions) == null || longArray2.size() != this.cueTimesUs.size()) {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = this.cueTimesUs.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            jArr3[i2] = this.cueTimesUs.get(i2);
            jArr[i2] = this.segmentContentPosition + this.cueClusterPositions.get(i2);
        }
        while (true) {
            int i3 = size - 1;
            if (i >= i3) {
                iArr[i3] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i3]);
                jArr2[i3] = this.durationUs - jArr3[i3];
                this.cueTimesUs = null;
                this.cueClusterPositions = null;
                return new ChunkIndex(iArr, jArr, jArr2, jArr3);
            }
            int i4 = i + 1;
            iArr[i] = (int) (jArr[i4] - jArr[i]);
            jArr2[i] = jArr3[i4] - jArr3[i];
            i = i4;
        }
    }

    private void commitSampleToOutput(Track track, long j) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, j);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                commitSubtitleSample(track, SUBRIP_TIMECODE_FORMAT, 19, 1000L, SUBRIP_TIMECODE_EMPTY);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                commitSubtitleSample(track, SSA_TIMECODE_FORMAT, 21, 10000L, SSA_TIMECODE_EMPTY);
            }
            track.output.sampleMetadata(j, this.blockFlags, this.sampleBytesWritten, 0, track.cryptoData);
        }
        this.sampleRead = true;
        resetSample();
    }

    private void commitSubtitleSample(Track track, String str, int i, long j, byte[] bArr) {
        setSampleDuration(this.subtitleSample.data, this.blockDurationUs, str, i, j, bArr);
        TrackOutput trackOutput = track.output;
        ParsableByteArray parsableByteArray = this.subtitleSample;
        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
        this.sampleBytesWritten += this.subtitleSample.limit();
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private static boolean isCodecSupported(String str) {
        return CODEC_ID_VP8.equals(str) || CODEC_ID_VP9.equals(str) || CODEC_ID_MPEG2.equals(str) || CODEC_ID_MPEG4_SP.equals(str) || CODEC_ID_MPEG4_ASP.equals(str) || CODEC_ID_MPEG4_AP.equals(str) || CODEC_ID_H264.equals(str) || CODEC_ID_H265.equals(str) || CODEC_ID_FOURCC.equals(str) || CODEC_ID_THEORA.equals(str) || CODEC_ID_OPUS.equals(str) || CODEC_ID_VORBIS.equals(str) || CODEC_ID_AAC.equals(str) || CODEC_ID_MP2.equals(str) || CODEC_ID_MP3.equals(str) || CODEC_ID_AC3.equals(str) || CODEC_ID_E_AC3.equals(str) || CODEC_ID_TRUEHD.equals(str) || CODEC_ID_DTS.equals(str) || CODEC_ID_DTS_EXPRESS.equals(str) || CODEC_ID_DTS_LOSSLESS.equals(str) || CODEC_ID_FLAC.equals(str) || CODEC_ID_ACM.equals(str) || CODEC_ID_PCM_INT_LIT.equals(str) || CODEC_ID_SUBRIP.equals(str) || CODEC_ID_ASS.equals(str) || CODEC_ID_VOBSUB.equals(str) || CODEC_ID_PGS.equals(str) || CODEC_ID_DVBSUB.equals(str);
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j2 = this.seekPositionAfterBuildingCues;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i) throws InterruptedException, IOException {
        if (this.scratch.limit() >= i) {
            return;
        }
        if (this.scratch.capacity() < i) {
            ParsableByteArray parsableByteArray = this.scratch;
            byte[] bArr = parsableByteArray.data;
            parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i)), this.scratch.limit());
        }
        ParsableByteArray parsableByteArray2 = this.scratch;
        extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), i - this.scratch.limit());
        this.scratch.setLimit(i);
    }

    private int readToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i) throws InterruptedException, IOException {
        int iSampleData;
        int iBytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (iBytesLeft > 0) {
            iSampleData = Math.min(i, iBytesLeft);
            trackOutput.sampleData(this.sampleStrippedBytes, iSampleData);
        } else {
            iSampleData = trackOutput.sampleData(extractorInput, i, false);
        }
        this.sampleBytesRead += iSampleData;
        this.sampleBytesWritten += iSampleData;
        return iSampleData;
    }

    private void readToTarget(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        int iMin = Math.min(i2, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i, iMin);
        }
        this.sampleBytesRead += i2;
    }

    private void resetSample() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long j) throws ParserException {
        long j2 = this.timecodeScale;
        if (j2 != -9223372036854775807L) {
            return Util.scaleLargeTimestamp(j, j2, 1000L);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void setSampleDuration(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] utf8Bytes;
        if (j == -9223372036854775807L) {
            utf8Bytes = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - (((long) (i2 * 3600)) * 1000000);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - (((long) (i3 * 60)) * 1000000);
            int i4 = (int) (j4 / 1000000);
            utf8Bytes = Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (((long) i4) * 1000000)) / j2))));
        }
        System.arraycopy(utf8Bytes, 0, bArr, i, bArr2.length);
    }

    private void writeSampleData(ExtractorInput extractorInput, Track track, int i) throws InterruptedException, IOException {
        int i2;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
            return;
        }
        if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
            return;
        }
        TrackOutput trackOutput = track.output;
        if (!this.sampleEncodingHandled) {
            if (track.hasContentEncryption) {
                this.blockFlags &= -1073741825;
                if (!this.sampleSignalByteRead) {
                    extractorInput.readFully(this.scratch.data, 0, 1);
                    this.sampleBytesRead++;
                    byte b = this.scratch.data[0];
                    if ((b & 128) == 128) {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                    this.sampleSignalByte = b;
                    this.sampleSignalByteRead = true;
                }
                byte b2 = this.sampleSignalByte;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.blockFlags |= 1073741824;
                    if (!this.sampleInitializationVectorRead) {
                        extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        ParsableByteArray parsableByteArray = this.scratch;
                        parsableByteArray.data[0] = (byte) ((z ? 128 : 0) | 8);
                        parsableByteArray.setPosition(0);
                        trackOutput.sampleData(this.scratch, 1);
                        this.sampleBytesWritten++;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput.sampleData(this.encryptionInitializationVector, 8);
                        this.sampleBytesWritten += 8;
                    }
                    if (z) {
                        if (!this.samplePartitionCountRead) {
                            extractorInput.readFully(this.scratch.data, 0, 1);
                            this.sampleBytesRead++;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i3 = this.samplePartitionCount * 4;
                        this.scratch.reset(i3);
                        extractorInput.readFully(this.scratch.data, 0, i3);
                        this.sampleBytesRead += i3;
                        short s = (short) ((this.samplePartitionCount / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i4);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.samplePartitionCount;
                            if (i5 >= i2) {
                                break;
                            }
                            int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
                            if (i5 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort((short) (unsignedIntToInt - i6));
                            } else {
                                this.encryptionSubsampleDataBuffer.putInt(unsignedIntToInt - i6);
                            }
                            i5++;
                            i6 = unsignedIntToInt;
                        }
                        int i7 = (i - this.sampleBytesRead) - i6;
                        if (i2 % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(i7);
                        } else {
                            this.encryptionSubsampleDataBuffer.putShort((short) i7);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i4);
                        trackOutput.sampleData(this.encryptionSubsampleData, i4);
                        this.sampleBytesWritten += i4;
                    }
                }
            } else {
                byte[] bArr = track.sampleStrippedBytes;
                if (bArr != null) {
                    this.sampleStrippedBytes.reset(bArr, bArr.length);
                }
            }
            this.sampleEncodingHandled = true;
        }
        int iLimit = i + this.sampleStrippedBytes.limit();
        if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
            if (track.trueHdSampleRechunker != null) {
                Assertions.checkState(this.sampleStrippedBytes.limit() == 0);
                track.trueHdSampleRechunker.startSample(extractorInput, this.blockFlags, iLimit);
            }
            while (true) {
                int i8 = this.sampleBytesRead;
                if (i8 >= iLimit) {
                    break;
                } else {
                    readToOutput(extractorInput, trackOutput, iLimit - i8);
                }
            }
        } else {
            byte[] bArr2 = this.nalLength.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i9 = track.nalUnitLengthFieldLength;
            int i10 = 4 - i9;
            while (this.sampleBytesRead < iLimit) {
                int i11 = this.sampleCurrentNalBytesRemaining;
                if (i11 == 0) {
                    readToTarget(extractorInput, bArr2, i10, i9);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                } else {
                    this.sampleCurrentNalBytesRemaining = i11 - readToOutput(extractorInput, trackOutput, i11);
                }
            }
        }
        if (CODEC_ID_VORBIS.equals(track.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) throws InterruptedException, IOException {
        int length = bArr.length + i;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.data, bArr.length, i);
        this.subtitleSample.reset(length);
    }

    void endMasterElement(int i) throws ParserException {
        if (i == ID_BLOCK_GROUP) {
            if (this.blockState != 2) {
                return;
            }
            if (!this.sampleSeenReferenceBlock) {
                this.blockFlags |= 1;
            }
            commitSampleToOutput(this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
            this.blockState = 0;
            return;
        }
        if (i == ID_TRACK_ENTRY) {
            if (isCodecSupported(this.currentTrack.codecId)) {
                Track track = this.currentTrack;
                track.initializeOutput(this.extractorOutput, track.number);
                SparseArray<Track> sparseArray = this.tracks;
                Track track2 = this.currentTrack;
                sparseArray.put(track2.number, track2);
            }
            this.currentTrack = null;
            return;
        }
        if (i == ID_SEEK) {
            int i2 = this.seekEntryId;
            if (i2 != -1) {
                long j = this.seekEntryPosition;
                if (j != -1) {
                    if (i2 == ID_CUES) {
                        this.cuesContentPosition = j;
                        return;
                    }
                    return;
                }
            }
            throw new ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == ID_CONTENT_ENCODING) {
            Track track3 = this.currentTrack;
            if (track3.hasContentEncryption) {
                if (track3.cryptoData == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey));
                return;
            }
            return;
        }
        if (i == ID_CONTENT_ENCODINGS) {
            Track track4 = this.currentTrack;
            if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                throw new ParserException("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.timecodeScale == -9223372036854775807L) {
                this.timecodeScale = 1000000L;
            }
            long j2 = this.durationTimecode;
            if (j2 != -9223372036854775807L) {
                this.durationUs = scaleTimecodeToUs(j2);
                return;
            }
            return;
        }
        if (i == ID_TRACKS) {
            if (this.tracks.size() == 0) {
                throw new ParserException("No valid tracks were found");
            }
            this.extractorOutput.endTracks();
        } else if (i == ID_CUES && !this.sentSeekMap) {
            this.extractorOutput.seekMap(buildSeekMap());
            this.sentSeekMap = true;
        }
    }

    void floatElement(int i, double d) {
        if (i == ID_SAMPLING_FREQUENCY) {
            this.currentTrack.sampleRate = (int) d;
        }
        if (i == ID_DURATION) {
            this.durationTimecode = (long) d;
            return;
        }
        switch (i) {
            case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                this.currentTrack.primaryRChromaticityX = (float) d;
                break;
            case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                this.currentTrack.primaryRChromaticityY = (float) d;
                break;
            case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                this.currentTrack.primaryGChromaticityX = (float) d;
                break;
            case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                this.currentTrack.primaryGChromaticityY = (float) d;
                break;
            case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                this.currentTrack.primaryBChromaticityX = (float) d;
                break;
            case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                this.currentTrack.primaryBChromaticityY = (float) d;
                break;
            case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                this.currentTrack.whitePointChromaticityX = (float) d;
                break;
            case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                this.currentTrack.whitePointChromaticityY = (float) d;
                break;
            case ID_LUMNINANCE_MAX /* 21977 */:
                this.currentTrack.maxMasteringLuminance = (float) d;
                break;
            case ID_LUMNINANCE_MIN /* 21978 */:
                this.currentTrack.minMasteringLuminance = (float) d;
                break;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws InterruptedException, IOException {
        this.sampleRead = false;
        boolean z = true;
        while (z && !this.sampleRead) {
            z = this.reader.read(extractorInput);
            if (z && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).outputPendingSampleMetadata();
        }
        return -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetSample();
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).reset();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        return new Sniffer().sniff(extractorInput);
    }

    void startMasterElement(int i, long j, long j2) throws ParserException {
        if (i == ID_BLOCK_GROUP) {
            this.sampleSeenReferenceBlock = false;
            return;
        }
        if (i == ID_TRACK_ENTRY) {
            this.currentTrack = new Track();
            return;
        }
        if (i == ID_CUE_POINT) {
            this.seenClusterPositionForCurrentCuePoint = false;
            return;
        }
        if (i == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
            return;
        }
        if (i == ID_CONTENT_ENCRYPTION) {
            this.currentTrack.hasContentEncryption = true;
            return;
        }
        if (i == ID_MASTERING_METADATA) {
            this.currentTrack.hasColorInfo = true;
            return;
        }
        if (i == ID_SEGMENT) {
            long j3 = this.segmentContentPosition;
            if (j3 != -1 && j3 != j) {
                throw new ParserException("Multiple Segment elements not supported");
            }
            this.segmentContentPosition = j;
            this.segmentContentSize = j2;
            return;
        }
        if (i == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i == ID_CLUSTER && !this.sentSeekMap) {
            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                this.seekForCues = true;
            } else {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
            }
        }
    }

    void stringElement(int i, String str) throws ParserException {
        if (i == 134) {
            this.currentTrack.codecId = str;
            return;
        }
        if (i != 17026) {
            if (i != ID_LANGUAGE) {
                return;
            }
            this.currentTrack.language = str;
        } else if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
            throw new ParserException("DocType " + str + " not supported");
        }
    }

    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i);
    }

    void binaryElement(int i, int i2, ExtractorInput extractorInput) throws InterruptedException, IOException {
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        int i8 = 0;
        if (i != ID_BLOCK && i != ID_SIMPLE_BLOCK) {
            if (i == ID_CONTENT_COMPRESSION_SETTINGS) {
                byte[] bArr = new byte[i2];
                this.currentTrack.sampleStrippedBytes = bArr;
                extractorInput.readFully(bArr, 0, i2);
                return;
            }
            if (i == ID_CONTENT_ENCRYPTION_KEY_ID) {
                byte[] bArr2 = new byte[i2];
                extractorInput.readFully(bArr2, 0, i2);
                this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            }
            if (i == ID_SEEK_ID) {
                Arrays.fill(this.seekEntryIdBytes.data, (byte) 0);
                extractorInput.readFully(this.seekEntryIdBytes.data, 4 - i2, i2);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                return;
            }
            if (i == ID_CODEC_PRIVATE) {
                byte[] bArr3 = new byte[i2];
                this.currentTrack.codecPrivate = bArr3;
                extractorInput.readFully(bArr3, 0, i2);
                return;
            } else {
                if (i != ID_PROJECTION_PRIVATE) {
                    throw new ParserException("Unexpected id: " + i);
                }
                byte[] bArr4 = new byte[i2];
                this.currentTrack.projectionData = bArr4;
                extractorInput.readFully(bArr4, 0, i2);
                return;
            }
        }
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = -9223372036854775807L;
            this.blockState = 1;
            this.scratch.reset();
        }
        Track track = this.tracks.get(this.blockTrackNumber);
        if (track == null) {
            extractorInput.skipFully(i2 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i9 = (this.scratch.data[2] & 6) >> 1;
            byte b = 255;
            if (i9 == 0) {
                this.blockLacingSampleCount = 1;
                int[] iArrEnsureArrayCapacity = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
                this.blockLacingSampleSizes = iArrEnsureArrayCapacity;
                iArrEnsureArrayCapacity[0] = (i2 - this.blockTrackNumberLength) - 3;
            } else {
                if (i != ID_SIMPLE_BLOCK) {
                    throw new ParserException("Lacing only supported in SimpleBlocks.");
                }
                int i10 = 4;
                readScratch(extractorInput, 4);
                int i11 = (this.scratch.data[3] & 255) + 1;
                this.blockLacingSampleCount = i11;
                int[] iArrEnsureArrayCapacity2 = ensureArrayCapacity(this.blockLacingSampleSizes, i11);
                this.blockLacingSampleSizes = iArrEnsureArrayCapacity2;
                if (i9 == 2) {
                    int i12 = (i2 - this.blockTrackNumberLength) - 4;
                    int i13 = this.blockLacingSampleCount;
                    Arrays.fill(iArrEnsureArrayCapacity2, 0, i13, i12 / i13);
                } else if (i9 == 1) {
                    int i14 = 0;
                    int i15 = 0;
                    while (true) {
                        i4 = this.blockLacingSampleCount - 1;
                        if (i14 >= i4) {
                            break;
                        }
                        this.blockLacingSampleSizes[i14] = 0;
                        while (true) {
                            i5 = i10 + 1;
                            readScratch(extractorInput, i5);
                            int i16 = this.scratch.data[i10] & 255;
                            int[] iArr = this.blockLacingSampleSizes;
                            i6 = iArr[i14] + i16;
                            iArr[i14] = i6;
                            if (i16 != 255) {
                                break;
                            } else {
                                i10 = i5;
                            }
                        }
                        i15 += i6;
                        i14++;
                        i10 = i5;
                    }
                    this.blockLacingSampleSizes[i4] = ((i2 - this.blockTrackNumberLength) - i10) - i15;
                } else {
                    if (i9 != 3) {
                        throw new ParserException("Unexpected lacing value: " + i9);
                    }
                    int i17 = 0;
                    int i18 = 0;
                    while (true) {
                        int i19 = this.blockLacingSampleCount - i7;
                        if (i17 >= i19) {
                            this.blockLacingSampleSizes[i19] = ((i2 - this.blockTrackNumberLength) - i10) - i18;
                            break;
                        }
                        this.blockLacingSampleSizes[i17] = i8;
                        int i20 = i10 + 1;
                        readScratch(extractorInput, i20);
                        if (this.scratch.data[i10] == 0) {
                            throw new ParserException("No valid varint length mask found");
                        }
                        int i21 = i8;
                        while (true) {
                            if (i21 >= 8) {
                                j = 0;
                                break;
                            }
                            int i22 = i7 << (7 - i21);
                            if ((this.scratch.data[i10] & i22) != 0) {
                                i20 += i21;
                                readScratch(extractorInput, i20);
                                j = (~i22) & this.scratch.data[i10] & b;
                                int i23 = i10 + 1;
                                while (i23 < i20) {
                                    j = (j << 8) | ((long) (this.scratch.data[i23] & b));
                                    i23++;
                                    b = 255;
                                }
                                if (i17 <= 0) {
                                    break;
                                }
                                j -= (1 << ((i21 * 7) + 6)) - 1;
                                break;
                            }
                            i21++;
                            i7 = 1;
                            b = 255;
                        }
                        i10 = i20;
                        if (j < -2147483648L || j > 2147483647L) {
                            throw new ParserException("EBML lacing sample size out of range.");
                        }
                        int i24 = (int) j;
                        int[] iArr2 = this.blockLacingSampleSizes;
                        if (i17 != 0) {
                            i24 += iArr2[i17 - 1];
                        }
                        iArr2[i17] = i24;
                        i18 += i24;
                        i17++;
                        i7 = 1;
                        i8 = 0;
                        b = 255;
                    }
                }
            }
            byte[] bArr5 = this.scratch.data;
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((bArr5[1] & 255) | (bArr5[0] << 8));
            byte b2 = this.scratch.data[2];
            this.blockFlags = ((track.type == 2 || (i == ID_SIMPLE_BLOCK && (b2 & 128) == 128)) ? 1 : 0) | ((b2 & 8) == 8 ? Integer.MIN_VALUE : 0);
            this.blockState = 2;
            this.blockLacingSampleIndex = 0;
            i3 = ID_SIMPLE_BLOCK;
        } else {
            i3 = ID_SIMPLE_BLOCK;
        }
        if (i != i3) {
            writeSampleData(extractorInput, track, this.blockLacingSampleSizes[0]);
            return;
        }
        while (true) {
            int i25 = this.blockLacingSampleIndex;
            if (i25 >= this.blockLacingSampleCount) {
                this.blockState = 0;
                return;
            } else {
                writeSampleData(extractorInput, track, this.blockLacingSampleSizes[i25]);
                commitSampleToOutput(track, this.blockTimeUs + ((long) ((this.blockLacingSampleIndex * track.defaultSampleDurationNs) / 1000)));
                this.blockLacingSampleIndex++;
            }
        }
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlReaderOutput());
        this.seekForCuesEnabled = (i & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
    }

    void integerElement(int i, long j) throws ParserException {
        if (i == ID_CONTENT_ENCODING_ORDER) {
            if (j != 0) {
                throw new ParserException("ContentEncodingOrder " + j + " not supported");
            }
            return;
        }
        if (i == ID_CONTENT_ENCODING_SCOPE) {
            if (j != 1) {
                throw new ParserException("ContentEncodingScope " + j + " not supported");
            }
            return;
        }
        switch (i) {
            case 131:
                this.currentTrack.type = (int) j;
                return;
            case 136:
                this.currentTrack.flagDefault = j == 1;
                return;
            case ID_BLOCK_DURATION /* 155 */:
                this.blockDurationUs = scaleTimecodeToUs(j);
                return;
            case ID_CHANNELS /* 159 */:
                this.currentTrack.channelCount = (int) j;
                return;
            case ID_PIXEL_WIDTH /* 176 */:
                this.currentTrack.width = (int) j;
                return;
            case ID_CUE_TIME /* 179 */:
                this.cueTimesUs.add(scaleTimecodeToUs(j));
                return;
            case ID_PIXEL_HEIGHT /* 186 */:
                this.currentTrack.height = (int) j;
                return;
            case 215:
                this.currentTrack.number = (int) j;
                return;
            case ID_TIME_CODE /* 231 */:
                this.clusterTimecodeUs = scaleTimecodeToUs(j);
                return;
            case ID_CUE_CLUSTER_POSITION /* 241 */:
                if (this.seenClusterPositionForCurrentCuePoint) {
                    return;
                }
                this.cueClusterPositions.add(j);
                this.seenClusterPositionForCurrentCuePoint = true;
                return;
            case ID_REFERENCE_BLOCK /* 251 */:
                this.sampleSeenReferenceBlock = true;
                return;
            case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                if (j != 3) {
                    throw new ParserException("ContentCompAlgo " + j + " not supported");
                }
                return;
            case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                if (j < 1 || j > 2) {
                    throw new ParserException("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case ID_EBML_READ_VERSION /* 17143 */:
                if (j != 1) {
                    throw new ParserException("EBMLReadVersion " + j + " not supported");
                }
                return;
            case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                if (j != 5) {
                    throw new ParserException("ContentEncAlgo " + j + " not supported");
                }
                return;
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                if (j != 1) {
                    throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case ID_SEEK_POSITION /* 21420 */:
                this.seekEntryPosition = j + this.segmentContentPosition;
                return;
            case ID_STEREO_MODE /* 21432 */:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.currentTrack.stereoMode = 0;
                    return;
                }
                if (i2 == 1) {
                    this.currentTrack.stereoMode = 2;
                    return;
                } else if (i2 == 3) {
                    this.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.currentTrack.stereoMode = 3;
                    return;
                }
            case ID_DISPLAY_WIDTH /* 21680 */:
                this.currentTrack.displayWidth = (int) j;
                return;
            case ID_DISPLAY_UNIT /* 21682 */:
                this.currentTrack.displayUnit = (int) j;
                return;
            case ID_DISPLAY_HEIGHT /* 21690 */:
                this.currentTrack.displayHeight = (int) j;
                return;
            case ID_FLAG_FORCED /* 21930 */:
                this.currentTrack.flagForced = j == 1;
                return;
            case ID_CODEC_DELAY /* 22186 */:
                this.currentTrack.codecDelayNs = j;
                return;
            case ID_SEEK_PRE_ROLL /* 22203 */:
                this.currentTrack.seekPreRollNs = j;
                return;
            case ID_AUDIO_BIT_DEPTH /* 25188 */:
                this.currentTrack.audioBitDepth = (int) j;
                return;
            case ID_DEFAULT_DURATION /* 2352003 */:
                this.currentTrack.defaultSampleDurationNs = (int) j;
                return;
            case ID_TIMECODE_SCALE /* 2807729 */:
                this.timecodeScale = j;
                return;
            default:
                switch (i) {
                    case ID_COLOUR_RANGE /* 21945 */:
                        int i3 = (int) j;
                        if (i3 == 1) {
                            this.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.currentTrack.colorRange = 1;
                            return;
                        }
                    case ID_COLOUR_TRANSFER /* 21946 */:
                        int i4 = (int) j;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.currentTrack.colorTransfer = 6;
                                return;
                            } else if (i4 == 18) {
                                this.currentTrack.colorTransfer = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.currentTrack.colorTransfer = 3;
                        return;
                    case ID_COLOUR_PRIMARIES /* 21947 */:
                        Track track = this.currentTrack;
                        track.hasColorInfo = true;
                        int i5 = (int) j;
                        if (i5 == 1) {
                            track.colorSpace = 1;
                            return;
                        }
                        if (i5 == 9) {
                            track.colorSpace = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                track.colorSpace = 2;
                                return;
                            }
                            return;
                        }
                    case ID_MAX_CLL /* 21948 */:
                        this.currentTrack.maxContentLuminance = (int) j;
                        return;
                    case ID_MAX_FALL /* 21949 */:
                        this.currentTrack.maxFrameAverageLuminance = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }
}
