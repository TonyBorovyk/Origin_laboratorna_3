package com.company;
class KeyValue<Key, Value> {
    Key mHashKey;
    Value mValue;
    int mHash;
    KeyValue<Key, Value> next;

    KeyValue(int hash, Key hashKey, Value value, KeyValue<Key, Value> next) {
        mHash = hash;
        mHashKey = hashKey;
        mValue = value;
        this.next = next;
    }
}