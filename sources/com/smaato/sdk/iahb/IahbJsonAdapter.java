package com.smaato.sdk.iahb;

import android.util.JsonReader;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.log.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class IahbJsonAdapter {
    private final Logger logger;

    public IahbJsonAdapter(Logger logger) {
        this.logger = logger;
    }

    public IahbResponse fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader == null) {
            throw new NullPointerException("'reader' specified as non-null is null");
        }
        try {
            return readResponse(jsonReader);
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    private IahbResponse readResponse(JsonReader jsonReader) throws IOException {
        if (jsonReader == null) {
            throw new NullPointerException("'reader' specified as non-null is null");
        }
        jsonReader.beginObject();
        IahbResponse.Builder builder = IahbResponse.builder();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("bidid")) {
                builder.bidId(jsonReader.nextString());
            } else if (strNextName.equals("seatbid")) {
                IahbBid seatBid = readSeatBid(jsonReader);
                if (seatBid != null) {
                    builder.bid(seatBid);
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private IahbBid readSeatBid(JsonReader jsonReader) throws IOException {
        IahbBid bid;
        if (jsonReader == null) {
            throw new NullPointerException("'reader' specified as non-null is null");
        }
        jsonReader.beginArray();
        do {
            try {
                bid = null;
                if (!jsonReader.hasNext()) {
                    jsonReader.endArray();
                    return null;
                }
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    if ("bid".equals(jsonReader.nextName())) {
                        bid = readBid(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } catch (Throwable th) {
                jsonReader.endArray();
                throw th;
            }
        } while (bid == null);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return bid;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    private IahbBid readBid(JsonReader jsonReader) throws IOException {
        IahbBid iahbBidBuild;
        byte b;
        if (jsonReader == null) {
            throw new NullPointerException("'reader' specified as non-null is null");
        }
        jsonReader.beginArray();
        do {
            try {
                if (!jsonReader.hasNext()) {
                    jsonReader.endArray();
                    return null;
                }
                jsonReader.beginObject();
                IahbBid.Builder builder = IahbBid.builder();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != -1377881982) {
                        if (iHashCode != 96426) {
                            if (iHashCode == 100897 && strNextName.equals("ext")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (strNextName.equals("adm")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(POBConstants.KEY_BUNDLE)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        builder.adm(jsonReader.nextString());
                    } else if (b == 1) {
                        builder.bundleId(jsonReader.nextString());
                    } else if (b != 2) {
                        jsonReader.skipValue();
                    } else {
                        IahbExt ext = readExt(jsonReader);
                        if (ext != null) {
                            builder.ext(ext);
                        }
                    }
                }
                jsonReader.endObject();
                iahbBidBuild = builder.build(this.logger);
            } catch (Throwable th) {
                jsonReader.endArray();
                throw th;
            }
        } while (iahbBidBuild == null);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return iahbBidBuild;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    private IahbExt readExt(JsonReader jsonReader) throws IOException {
        byte b;
        if (jsonReader == null) {
            throw new NullPointerException("'reader' specified as non-null is null");
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            try {
                if ("smt".equals(jsonReader.nextName())) {
                    IahbExt.Builder builder = IahbExt.builder();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName = jsonReader.nextName();
                        int iHashCode = strNextName.hashCode();
                        if (iHashCode != -1422011939) {
                            if (iHashCode != -1309235404) {
                                if (iHashCode != -1001268717) {
                                    if (iHashCode == 1240754974 && strNextName.equals("adspaceid")) {
                                        b = 0;
                                    } else {
                                        b = -1;
                                    }
                                } else if (strNextName.equals("impressionmeasurement")) {
                                    b = 3;
                                } else {
                                    b = -1;
                                }
                            } else if (strNextName.equals("expires")) {
                                b = 2;
                            } else {
                                b = -1;
                            }
                        } else if (strNextName.equals("adtype")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                        if (b == 0) {
                            builder.adspaceid(jsonReader.nextString());
                        } else if (b == 1) {
                            builder.adtype(jsonReader.nextString());
                        } else if (b == 2) {
                            builder.expiresAt(jsonReader.nextLong());
                        } else if (b != 3) {
                            jsonReader.skipValue();
                        } else {
                            builder.impressionMeasurement(jsonReader.nextString().equalsIgnoreCase("viewable") ? ImpressionCountingType.VIEWABLE : ImpressionCountingType.STANDARD);
                        }
                    }
                    jsonReader.endObject();
                    IahbExt iahbExtBuild = builder.build();
                    jsonReader.endObject();
                    return iahbExtBuild;
                }
                jsonReader.skipValue();
            } catch (Throwable th) {
                jsonReader.endObject();
                throw th;
            }
        }
        jsonReader.endObject();
        return null;
    }
}
