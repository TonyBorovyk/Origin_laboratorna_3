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

    void ChangeNumberOfElem(int capacityValue1) {
        KeyValue[] links2 = new KeyValue[capacityValue1];
        capacityVar = capacityValue1;
        PassData(links2);
    }

    int HashGenerate(int hashKeyForGen) {
        hashKeyForGen ^= (hashKeyForGen >>> 20) ^ (hashKeyForGen >>> 12);
        return hashKeyForGen ^ (hashKeyForGen >>> 7) ^ (hashKeyForGen >>> 4);
    }

    void AddSomeData(int hash, Key hashKey, Value value, int ind) {
        KeyValue<Key, Value> data = links[ind];
        links[ind] = new KeyValue<>(hash, hashKey, value, data);
        numberOfElem++;
        if ((float) numberOfElem / (float) capacityVar >= loadCoefVar) {
            ChangeNumberOfElem(capacityVar * 2);
        }
    }


    Value Get(Key hashKey) {
        int hash = HashGenerate(hashKey.hashCode());
        int ind = FindIndex(hash, capacityVar);
        KeyValue<Key, Value> data = links[ind];
        while (data != null) {
            if (hashKey.equals(data.mHashKey))
                return data.mValue;
            data = data.next;
        }
        return null;
    }
}

    int FindIndex(int hash, int capacityVar) {
        return hash & (capacityVar - 1);
    }

