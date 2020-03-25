package com.company;


public class HashFunc<Key, Value> {
    int numberOfElem = 0;
    int capacityVar = 16;
    double loadCoefVar = 0.8d;
    KeyValue[] links = new KeyValue[capacityVar];



    int FindIndex(int hash, int capacityVar) {
        return hash & (capacityVar - 1);
    }
}


