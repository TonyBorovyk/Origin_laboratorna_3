package com.company;

public class Hash_function<Key, Value> {
    double factor_nagryzky = 0.8d;
    int capacity = 16;
    Key_Data[] links = new Key_Data[capacity];
    int size = 0;
    int HashGenerate(int hashKeyForGen) {
        hashKeyForGen ^= (hashKeyForGen >>> 20) ^ (hashKeyForGen >>> 12);
        return hashKeyForGen ^ (hashKeyForGen >>> 7) ^ (hashKeyForGen >>> 4);
    }
    void PutInfo(Key key, Value value) {
        if (key == null) {
            System.out.print("Ви нічого не ввели!");
        }
        int hash = HashGenerate(key.hashCode());
        int index = FindIndex(hash, capacity);
        Value checked = scanKeyValueData(hash, key, value, index);
        if (checked != null)
            return;

        AddSomeData(hash, key, value, index);
    }
    int FindIndex(int hash, int capacityVar) {
        return hash & (capacityVar - 1);
    }
    Value scanKeyValueData(int hash, Key Hashkey, Value value, int ind) {
        Key_Data<Key, Value> data = links[ind];
        while (data != null) {
            if (data.Hash == hash && Hashkey.equals(data.Key_1)) {
                Value deltaValue = data.Value;
                data.Value = value;
                return deltaValue;
            }
            data = data.nastypniy;
        }
        return null;
    }
    void change_size(int newCapacity) {
        Key_Data[] table2 = new Key_Data[newCapacity];
        capacity = newCapacity;
        ChangeInformation(table2);
    }
    void AddSomeData(int hash, Key key, Value value, int index) {
        Key_Data<Key, Value> data = links[index];
        links[index] = new Key_Data<>(hash, key, value, data);
        size++;
        if ((float) size / (float) capacity >= factor_nagryzky) {
            change_size(capacity * 2);
        }
    }
    Value GetKey(Key key) {
        int hash = HashGenerate(key.hashCode());
        int index = FindIndex(hash, capacity);
        Key_Data<Key, Value> data = links[index];
        while (data != null) {
            if (key.equals(data.Key_1))
                return data.Value;
            data = data.nastypniy;
        }
        return null;
    }
    void ChangeInformation(Key_Data<Key, Value>[] newTable) {
        Key_Data[] copiedLastTable = this.links.clone();
        this.links = newTable;
        size = 0;
        for (int i = 0; i < copiedLastTable.length; i++) {
            Key_Data<Key, Value> data = copiedLastTable[i];
            while (data != null) {
                PutInfo(data.Key_1, data.Value);
                data = data.nastypniy;
            }
        }
    }
}
