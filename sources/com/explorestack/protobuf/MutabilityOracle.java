package com.explorestack.protobuf;

/* JADX INFO: loaded from: classes7.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() { // from class: com.explorestack.protobuf.MutabilityOracle.1
        @Override // com.explorestack.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
