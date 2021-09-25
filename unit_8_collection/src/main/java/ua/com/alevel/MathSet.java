package ua.com.alevel;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MathSet {
    private static final int CAPACITY = 10;
    private int capacity;
    private Number[] numbers;


    MathSet() {
        this(CAPACITY);
    }

    MathSet(int capacity) {
        numbers = new Number[capacity];
    }

    MathSet(Number[] numbers) {
        this(numbers.length);
        add(numbers);
    }

    MathSet(Number[]... numbers) {
        this.numbers = new Number[numbers.length * numbers[0].length];
        for (Number[] num : numbers) {
            add(num);
        }
    }

    MathSet(MathSet numbers) {
        this(numbers.capacity);
        join(numbers);
    }

    MathSet(MathSet... numbers) {
        this(numbers.length * CAPACITY);
        for (MathSet num : numbers) {
            join(num);
        }
    }

    public void add(Number n) {
        if (numbers.length == capacity) increaseNumbers();
        if (isDifferent(n)) {
            numbers[capacity++] = n;
        }
    }

    public void add(Number... n) {
        for (int i = 0; i < n.length; i++) {
            add(n[i]);
        }
    }

    public void join(MathSet ms) {
        if (ms.hasSet()) {
            Number[] newNumbers = ms.toArray();
            add(newNumbers);
        }
    }

    public void join(MathSet... ms) {
        for (MathSet mathSet : ms) {
            this.join(mathSet);
        }
    }

    public void intersection(MathSet ms) {
        if (ms.hasSet() && this.hasSet()) {
            MathSet newNumbers = new MathSet();

            for (int i = 0; i < ms.capacity; i++) {
                for (int j = 0; j < this.capacity; j++) {
                    if (ms.get(i) == this.get(j)) {
                        newNumbers.add(ms.get(i));
                        break;
                    }
                }
            }
            numbers = newNumbers.toArray();
            capacity = newNumbers.capacity;
        } else {
            System.out.println("Values don't intersect");
        }
    }

    public void intersection(MathSet... ms) {
        for (MathSet mathSet : ms) {
            intersection(mathSet);
        }
    }

    public void sortDesc() {
        sortDesc(0, capacity - 1);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        checkIndexes(firstIndex, lastIndex);

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = i + 1; j <= lastIndex; j++) {
                    if ((numbers[i].doubleValue() - numbers[j].doubleValue()) < 0) {
                        Number temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                        isSorted = false;
                    }
                }
            }
        }
    }

    public void sortDesc(Number value) {
        sortDesc(getIndex(value), capacity - 1);
    }

    public void sortAsc() {
        sortAsc(0, capacity - 1);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        checkIndexes(firstIndex, lastIndex);

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = i + 1; j <= lastIndex; j++) {
                    if ((numbers[i].doubleValue() - numbers[j].doubleValue()) > 0) {
                        Number temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                        isSorted = false;
                    }
                }
            }
        }
    }

    public void sortAsc(Number value) {
        sortAsc(getIndex(value), capacity - 1);
    }

    public Number get(int index) {
        if (checkIndexes(index))
            return numbers[index];
        return null;
    }

    public Number getMax() {
        MathSet temp = new MathSet(getCopiedArray(numbers));
        temp.sortDesc();
        return numbers[getIndex(temp.get(0))];
    }

    public Number getMin() {
        MathSet temp = new MathSet(getCopiedArray(numbers));
        temp.sortAsc();
        return numbers[getIndex(temp.get(0))];
    }

    public Number getAverage() {
        double sum = 0;
        for (int i = 0; i < capacity; i++) {
            sum += numbers[i].doubleValue();
        }

        return sum / capacity;
    }

    public Number getMedian() {
        Number median;
        Number[] temp = getCopiedArray(numbers);
        sortAsc();
        median = numbers[capacity / 2];
        numbers = temp;
        return numbers[getIndex(median)];
    }

    public Number[] toArray() {
        Number[] newNumber = new Number[this.capacity];
        for (int i = 0; i < newNumber.length; i++) {
            newNumber[i] = this.get(i);
        }
        return newNumber;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        MathSet mathSet = cut(firstIndex, lastIndex);
        return mathSet.toArray();
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        MathSet newMathSet = null;

        if (checkIndexes(firstIndex, lastIndex) && firstIndex < lastIndex) {
            newMathSet = new MathSet(lastIndex - firstIndex + 1);
            for (int i = firstIndex; i <= lastIndex; i++) {
                newMathSet.add(this.get(i));
            }
        } else {
            System.out.println("Indexes not found");
        }
        return newMathSet;
    }

    void clear() {
        numbers = new Number[CAPACITY];
        capacity = 0;
    }

    void clear(Number[] numbers) {
        int index;
        for (Number num : numbers) {
            index = getIndex(num);
            this.numbers[index] = null;
            for (int i = index; i < this.numbers.length; i++) {
                if (i == this.numbers.length - 1)
                    this.numbers[i] = null;
                else
                    this.numbers[i] = this.numbers[i + 1];
            }
        }
    }

    private void increaseNumbers(int newCapacity) {
        Number[] newNumbers = new Number[newCapacity];
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i];
        }
        numbers = newNumbers;
    }

    private void increaseNumbers() {
        increaseNumbers(2 * capacity);
    }

    private boolean isDifferent(Number n) {
        if (n == null)
            return false;
        if (capacity > 0) {
            for (int i = 0; i < capacity; i++) {
                if (n.equals(numbers[i]))
                    return false;
            }
        }
        return true;
    }

    private Number[] toArray(MathSet numbers) {
        Number[] newNumbers = new Number[numbers.capacity];
        for (int i = 0; i < newNumbers.length; i++) {
            newNumbers[i] = numbers.get(i);
        }
        return newNumbers;
    }

    private boolean checkIndex(int index) {
        if (index >= 0 && index < this.capacity)
            return true;
        else {
            throw new IndexOutOfBoundsException("Index out of bound: " + index);
        }
    }

    private boolean checkIndexes(int... indexes) {
        for (int index : indexes) {
            if (!checkIndex(index))
                return false;
        }
        return true;
    }

    private boolean hasSet() {
        return capacity > 0;
    }

    private int getIndex(Number n) {
        for (int i = 0; i < capacity; i++) {
            if (numbers[i].equals(n))
                return i;
        }
        throw new NoSuchElementException("Element not found: " + n);
    }

    private Number[] getCopiedArray(Number[] sourceArr) {
        Number[] copiedArr = new Number[capacity];
        for (int i = 0; i < capacity; i++) {
            if (sourceArr != null)
                copiedArr[i] = sourceArr[i];
        }
        return copiedArr;
    }

    @Override
    public String toString() {
        return "MathSet{" +
                "numbers=" + Arrays.toString(numbers) +
                ", capacity=" + capacity +
                ", current_capacity" + numbers.length +
                '}';
    }
}
