package com.company;
class Key_Data<Key, Value> {
    Key Key_1;
    Value Value;
    int Hash;
    Key_Data<Key, Value> nastypniy;

    Key_Data(int hash, Key Key, Value value, Key_Data<Key, Value> nastypniy_1) {
        Hash = hash;
        Key_1 = Key;
        Value = value;
        this.nastypniy = nastypniy_1;
    }
}