// Exceptions class is to help me recap exceptions

public class Exceptions {

    public void testingExceptions() {
        nullPointer();
        arrayOutOfBounds();
    }

    public void nullPointer() {
        String npe = null;
        try {
            System.out.println(npe.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        }
    }

    public void arrayOutOfBounds() {
        int aoub[] = {1, 2, 3, 4};
        try {
            System.out.println(aoub[7]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }
    }



}
