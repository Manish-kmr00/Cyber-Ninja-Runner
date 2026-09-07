package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PO implements InterfaceC2382em {
    public static String[] A02 = {"qG0UPMRGTXd5CQUZlvEnUJh4SiYxbqTd", "jBli3bwyMSD1TOoeRzkjUA7", "y89tkDASx2B7csG1AZ7hbWX7UvNubTul", "sj0qBufHGOHXQvZz1iWrsB2L", "GmHE", "GyRRfsLxZSK8ckGTMUM2G3BZ", "eQ9dSC", "HbjoUe4Mv2Tb3u3EPQBzrDZ"};
    public static final PO A03 = new PO(Collections.emptyMap());
    public int A00;
    public final Map<String, byte[]> A01;

    public PO() {
        this(Collections.emptyMap());
    }

    public PO(Map<String, byte[]> metadata) {
        this.A01 = Collections.unmodifiableMap(metadata);
    }

    public static Map<String, byte[]> A00(Map<String, byte[]> otherMetadata, C2383en c2383en) {
        HashMap map = new HashMap(otherMetadata);
        A01(map, c2383en.A08());
        A02(map, c2383en.A09());
        return map;
    }

    public static void A01(HashMap<String, byte[]> metadata, List<String> names) {
        for (int i = 0; i < i; i++) {
            metadata.remove(names.get(i));
        }
    }

    public static void A02(HashMap<String, byte[]> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            String key = entry.getKey();
            if (A02[7].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "O8YFDJ0srfU16hiGIa3AqDTvvnovbOx3";
            strArr[0] = "P4eVlFUbQVLxOEADUeRL69YsgYNtbckR";
            map.put(key, A04(entry.getValue()));
        }
    }

    public static boolean A03(Map<String, byte[]> second, Map<String, byte[]> map) {
        if (second.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : second.entrySet()) {
            byte[] value = entry.getValue();
            String[] strArr = A02;
            if (strArr[2].charAt(28) != strArr[0].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "4gHZYV7qNEQ2E9KU3anRDvxm";
            strArr2[3] = "hKHw0uXfbDWWetrMARcvXB9h";
            byte[] value2 = value;
            if (!Arrays.equals(value2, map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static byte[] A04(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(AbstractC2557hd.A06);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public final PO A05(C2383en c2383en) {
        Map<String, byte[]> mapA00 = A00(this.A01, c2383en);
        Map<String, byte[]> mutatedMetadata = this.A01;
        if (A03(mutatedMetadata, mapA00)) {
            return this;
        }
        return new PO(mapA00);
    }

    public final Set<Map.Entry<String, byte[]>> A06() {
        return this.A01.entrySet();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2382em
    public final long A6X(String str, long j) {
        byte[] bytes = this.A01.get(str);
        if (bytes != null) {
            return ByteBuffer.wrap(bytes).getLong();
        }
        return j;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2382em
    public final String A6Z(String str, String str2) {
        byte[] bArr = this.A01.get(str);
        if (bArr != null) {
            return new String(bArr, AbstractC2557hd.A06);
        }
        return str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return A03(this.A01, ((PO) obj).A01);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i = 0;
            for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
                int iHashCode = entry.getKey().hashCode();
                int iHashCode2 = Arrays.hashCode(entry.getValue());
                if (A02[7].length() == 21) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[5] = "1sXwMSmaAdrnJ5Ti8W8uaKU2";
                strArr[3] = "L4okRAxrSmb4Ik3dtrZTMpYe";
                i += iHashCode ^ iHashCode2;
            }
            this.A00 = i;
        }
        int result = this.A00;
        return result;
    }
}
