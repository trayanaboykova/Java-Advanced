package Lesson07_WorkshopCustomDataStructures;

public class SmartArray {
    private int[] data;
    private int index;
    public SmartArray() {
        this.data = new int[2];
        this.index = 0;
    }
    public void add(int element) {
        if (index == data.length) {
           data = resize();
        }
        data[index] = element;
        index++;
    }

    private int[] resize() {
        int[] newData = new int[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        return newData;
    }

    public int size() {
        return index;
    }

    public int get(int index) {
        return data[index];
    }
}
