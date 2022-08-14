import exception.NoSachInteger;
import exception.OutOfSize;
import exception.ParametrIsNotInteger;
import exception.ParametrIsNull;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private int lenght;
    private Integer[] array;
    private int arraySize;


    public StringListImpl() {
        this.lenght = 10;
        this.array = new Integer[lenght];
        this.arraySize = 0;
    }

    private void grow(){
        if(array[lenght - 1] != null){
            lenght = lenght + lenght/2;
            Integer[] newArray = new Integer[lenght];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }


    private void checkParametr(int index){
        if(index > size()){
            throw new OutOfSize("The index is larger than the actual size of the array");
        }
        if(index < 0){
            throw new OutOfSize("The index less than zero");
        }
    }

    private void checkParametr(String string) {
        if (string == null) {
            throw new ParametrIsNull("The resulting string parameter is null");
        }
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException e){
            throw new ParametrIsNotInteger("The resulting string parameter is not integer");
        }
    }

    @Override
    public String add(String item) {
        checkParametr(item);
        grow();
        array[size()] = Integer.parseInt(item);
        System.out.println(Arrays.toString(array));
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkParametr(item);
        checkParametr(index);
        grow();
        Integer[] newArray = new Integer[lenght];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = Integer.parseInt(item);
        System.arraycopy(array, index, newArray, index + 1, size() - index);
        array = newArray;
        System.out.println(Arrays.toString(array));
        return String.valueOf(array[index]);
    }

    @Override
    public String set(int index, String item) {
        checkParametr(item);
        checkParametr(index + 1);
        array[index] = Integer.parseInt(item);
        System.out.println(Arrays.toString(array));
        return String.valueOf(array[index]);
    }

    @Override
    public String remove(String item) {
        checkParametr(item);
        if(indexOf(item) == -1) {
            throw new NoSachInteger("Such a integer was not found in the array");
        } else {
            this.remove(indexOf(item));
            return item;
        }
    }

    @Override
    public String remove(int index) {
        checkParametr(index + 1);
        Integer removingItem = array[index];
        Integer[] newArray = new Integer[lenght];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size() - index);
        array = newArray;
        System.out.println(Arrays.toString(array));
        return String.valueOf(removingItem);
    }

    @Override
    public boolean contains(String item) {
        checkParametr(item);
        this.quickSort(this.array, 0, this.size() - 1);
        return this.binareSearch(item);
    }

    @Override
    public int indexOf(String item) {
        checkParametr(item);
        for (int i = 0; i < size(); i++) {
            if(Objects.equals(array[i], Integer.parseInt(item))){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkParametr(item);
        int index = -1;
        for (int i = 0; i <= size() ; i++) {
            if(Objects.equals(array[i], Integer.parseInt(item))){
                index = i;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        checkParametr(index);
        return String.valueOf(array[index]);
    }

    @Override
    public boolean equals(StringList otherList) {
        if(this.size() != otherList.size()){
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if(!Objects.equals(this.get(i), otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size(){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                arraySize = i;
                break;
            }
        }
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return array[0] == null;
    }

    @Override
    public void clear() {
        this.lenght = 10;
        this.array = new Integer[lenght];
        this.arraySize = 0;
        System.out.println(Arrays.toString(array));
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    public void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private boolean binareSearch(String element) {
        int min = 0;
        int max = this.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Integer.parseInt(element) == array[mid]) {
                return true;
            }

            if (Integer.parseInt(element) < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
