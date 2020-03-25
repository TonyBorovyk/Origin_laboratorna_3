package com.company;


public class HashFunc<Key, Value> {
    int numberOfElem = 0;
    int capacityVar = 16;
    double loadCoefVar = 0.8d;
    KeyValue[] links = new KeyValue[capacityVar];



    int FindIndex(int hash, int capacityVar) {
        return hash & (capacityVar - 1);
    }

    Value scanKeyValueData(int hash, Key hashKey, Value value, int ind) {
        KeyValue<Key, Value> data = links[ind];
        while (data != null) {
            if (data.mHash == hash && hashKey.equals(data.mHashKey)) {
                Value deltaValue = data.mValue;
                data.mValue = value;
                return deltaValue;
            }
            data = data.next;
        }
        return null;
    }
