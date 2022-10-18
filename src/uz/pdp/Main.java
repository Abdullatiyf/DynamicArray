package uz.pdp;

public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray=new DynamicArray(5);
        dynamicArray.add(2022);
        dynamicArray.add('-');
        dynamicArray.add("yil");
        dynamicArray.add(18);
        dynamicArray.add('-');
        dynamicArray.add("Oktyabr");
        dynamicArray.add("soat");
        dynamicArray.add(20.39);
        System.out.println(dynamicArray);
    }
}
