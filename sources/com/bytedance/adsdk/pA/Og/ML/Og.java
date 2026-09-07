package com.bytedance.adsdk.pA.Og.ML;

import com.bytedance.adsdk.pA.Og.Og.pA.BSW;
import com.bytedance.adsdk.pA.Og.Og.pA.Bzk;
import com.bytedance.adsdk.pA.Og.Og.pA.JG;
import com.bytedance.adsdk.pA.Og.Og.pA.ML;
import com.bytedance.adsdk.pA.Og.Og.pA.Sn;
import com.bytedance.adsdk.pA.Og.Og.pA.WV;
import com.bytedance.adsdk.pA.Og.Og.pA.Wx;
import com.bytedance.adsdk.pA.Og.Og.pA.XT;
import com.bytedance.adsdk.pA.Og.Og.pA.aBv;
import com.bytedance.adsdk.pA.Og.Og.pA.omh;
import com.bytedance.adsdk.pA.Og.Og.pA.yFO;
import com.bytedance.adsdk.pA.Og.ZZv.KZx;
import com.bytedance.adsdk.pA.Og.ZZv.ZZv;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Og {
    public static com.bytedance.adsdk.pA.Og.Og.pA pA(List<com.bytedance.adsdk.pA.Og.Og.pA> list, String str, int i) {
        KZx(list, str, i);
        Deque<com.bytedance.adsdk.pA.Og.Og.pA> dequePA = pA(Og(list, str, i));
        if (dequePA.size() != 1) {
            throw new IllegalStateException();
        }
        return dequePA.getFirst();
    }

    private static Deque<com.bytedance.adsdk.pA.Og.Og.pA> pA(Deque<com.bytedance.adsdk.pA.Og.Og.pA> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.pA.Og.Og.pA pAVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.pA.Og.Og.pA) linkedList.peekLast()).pA() == KZx.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.pA.Og.Og.pA pAVar2 = (com.bytedance.adsdk.pA.Og.Og.pA) linkedList.pollLast();
                if (((com.bytedance.adsdk.pA.Og.Og.pA) linkedList.pollLast()).pA() != KZx.QUESTION) {
                    throw new IllegalStateException();
                }
                com.bytedance.adsdk.pA.Og.Og.pA pAVar3 = (com.bytedance.adsdk.pA.Og.Og.pA) linkedList.pollLast();
                yFO yfo = new yFO();
                yfo.pA(pAVar3);
                yfo.Og(pAVar2);
                yfo.KZx(pAVar);
                linkedList.addLast(yfo);
            } else {
                linkedList.addLast(pAVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.bytedance.adsdk.pA.Og.Og.pA> Og(List<com.bytedance.adsdk.pA.Og.Og.pA> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.pA.Og.Og.pA> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.pA.Og.Og.pA pAVar : linkedList) {
                if (!linkedList2.isEmpty() && KZx.pA(((com.bytedance.adsdk.pA.Og.Og.pA) linkedList2.peekLast()).pA()) && ((KZx) ((com.bytedance.adsdk.pA.Og.Og.pA) linkedList2.peekLast()).pA()).Og() == i2) {
                    com.bytedance.adsdk.pA.Og.Og.pA pAVar2 = (com.bytedance.adsdk.pA.Og.Og.pA) linkedList2.pollLast();
                    com.bytedance.adsdk.pA.Og.Og.pA pAVar3 = (com.bytedance.adsdk.pA.Og.Og.pA) linkedList2.pollLast();
                    if (!KZx.pA(pAVar3.pA()) && !KZx.pA(pAVar.pA())) {
                        linkedList2.addLast(pA(pAVar3, pAVar2, pAVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(pAVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void KZx(List<com.bytedance.adsdk.pA.Og.Og.pA> list, String str, int i) {
        Iterator<com.bytedance.adsdk.pA.Og.Og.pA> it = list.iterator();
        while (it.hasNext()) {
            if (ZZv.pA(it.next().pA())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.pA.Og.ML.Og$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[KZx.values().length];
            pA = iArr;
            try {
                iArr[KZx.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[KZx.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[KZx.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pA[KZx.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                pA[KZx.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                pA[KZx.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                pA[KZx.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                pA[KZx.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                pA[KZx.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                pA[KZx.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                pA[KZx.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                pA[KZx.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                pA[KZx.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.bytedance.adsdk.pA.Og.Og.pA pA(com.bytedance.adsdk.pA.Og.Og.pA pAVar, com.bytedance.adsdk.pA.Og.Og.pA pAVar2, com.bytedance.adsdk.pA.Og.Og.pA pAVar3) {
        aBv bsw;
        switch (AnonymousClass1.pA[((KZx) pAVar2.pA()).ordinal()]) {
            case 1:
                bsw = new BSW();
                break;
            case 2:
                bsw = new XT();
                break;
            case 3:
                bsw = new com.bytedance.adsdk.pA.Og.Og.pA.pA();
                break;
            case 4:
                bsw = new Wx();
                break;
            case 5:
                bsw = new WV();
                break;
            case 6:
                bsw = new com.bytedance.adsdk.pA.Og.Og.pA.ZZv();
                break;
            case 7:
                bsw = new Sn();
                break;
            case 8:
                bsw = new JG();
                break;
            case 9:
                bsw = new Bzk();
                break;
            case 10:
                bsw = new ML();
                break;
            case 11:
                bsw = new omh();
                break;
            case 12:
                bsw = new com.bytedance.adsdk.pA.Og.Og.pA.Og();
                break;
            case 13:
                bsw = new com.bytedance.adsdk.pA.Og.Og.pA.KZx();
                break;
            default:
                throw new UnsupportedOperationException(pAVar2.pA().toString());
        }
        bsw.pA(pAVar);
        bsw.Og(pAVar3);
        return bsw;
    }

    public static boolean pA(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
