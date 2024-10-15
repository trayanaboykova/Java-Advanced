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
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        return newData;
    }

    public int size() {
        return index;
    }

    public int get(int index) {
        return data[index];
    }

    public int remove(int index) {
        int element = data[index];
        for (int i = index; i < this.index - 1; i++) {
            data[i] = data[i + 1];
        }
        data[this.index - 1] = 0;
        this.index--;
        return element;
    }
}
