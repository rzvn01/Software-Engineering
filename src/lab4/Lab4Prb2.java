package lab4;

import java.util.Arrays;

/**
 * Cacu Razvan GR-2023
 * Define a class X that will have the following attributes: a private array of characters, a protected String object
 * and an integer without access specifier. The class will contain an explicit constructor, which will initialize the
 * attributes, accessor and mutator methods for fields that cannot be accessed outside the class and redefine the
 * finalize() method inherited from the Object class, which will display an appropriate message.
 * In the main() method, placed in another class, create an object of X class, display the attribute values, and then
 * prepare the object to be removed by garbage collector. Then create a new X object, change the attribute values,
 * and display their attribute values.
 */


class X {
    private char[] array;

    protected String string;

    int integer;

    public X(char[] array, String string, int integer) {
        this.array = array;
        this.string = string;
        this.integer = integer;
    }

    public char[] getArray() {
        return array;
    }

    public void setArray(char[] array) {
        this.array = array;
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() method was called ! ");
    }
}

public class Lab4Prb2 {

    public static void main(String[] args) {
        char[] array = "Character array".toCharArray();
        String string = "String text ";
        X x = new X(array, string, 1);

        System.out.println("The values of the X instance : \n Array :" + Arrays.toString(x.getArray()));
        System.out.println("String : " + x.string);
        System.out.println("Integer : " + x.integer);

        try {
            x.setArray(null);
            x.string = null;

            x.finalize();
        } catch (Throwable e) {
            System.out.println("The finalize method could not be called ! ");
        }

        X x2 = new X(new char[]{'a', 'b'}, string + "modified ", 10);

        System.out.println("The values of the new  X instance : \n Array :" + Arrays.toString(x2.getArray()));
        System.out.println("String : " + x2.string);
        System.out.println("Integer : " + x2.integer);

    }


}
