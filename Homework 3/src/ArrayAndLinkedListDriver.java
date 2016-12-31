
import javax.swing.JFrame;

public class ArrayAndLinkedListDriver {

    static LinkedListInterface myList = new LinkedListInterface();
    static ArrayListInterface myArray = new ArrayListInterface();
    static DataForChart data = new DataForChart();
    static long start;
    static long stop;
    static long timeLength;
    private static long linkedListMemory = 0;//size of linked list in bytes.
    private static long arrayListMemory = 0;//size of array list in bytes.
    private static long freeMemory = 0;//starting storage.
    static Runtime runtime = Runtime.getRuntime();//instance of the runtime class.

    public static void firstCase(int j) {
        freeMemory = runtime.freeMemory();//starting storage size.
        start = System.nanoTime();//starts time.
        for (Integer i = 1; i <= 9999; i += 2)// adds odd numbers up to 9999, to the empty linked list.
        {
            myList.addSorted(i);
        }
        stop = System.nanoTime();//stops time.
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(0, j, timeLength);// sets each time run so it can be retrieved later.
        runtime.gc();// runs garbage collector to clean up any unused storage.
        linkedListMemory += runtime.totalMemory() - freeMemory;//calculates storage used in the linked list.
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        timeLength = 0;
        for (Integer i = 1; i <= 9999; i += 2)// adds odd numbers up to 9999, to the empty array list.
        {
            myArray.addSorted(i);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(1, j, timeLength);
        runtime.gc();
        arrayListMemory += runtime.totalMemory() - freeMemory;//calculates storage used in the array list.
    }

    public static void secondCase(int j) {
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        for (Integer i = 2; i <= 10000; i += 2)// adds even numbers up to 10000, to the linked list from case 1.
        {
            myList.addSorted(i);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(2, j, timeLength);
        runtime.gc();
        linkedListMemory += runtime.totalMemory() - freeMemory;
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        timeLength = 0;
        for (Integer i = 2; i <= 10000; i += 2)// adds even numbers up to 10000, to the array list from case 1.
        {
            myArray.addSorted(i);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(3, j, timeLength);
        runtime.gc();
        arrayListMemory += runtime.totalMemory() - freeMemory;
        myArray.removeAll();//clears the list.
        myList.removeAll();
    }

    public static void thirdCase(int j) {
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        for (Integer i = 1; i <= 10000; i++)// adds 10000 Integer numbers to the empty linked list. 
        {
            myList.add(i);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(4, j, timeLength);
        runtime.gc();
        linkedListMemory += runtime.totalMemory() - freeMemory;
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        timeLength = 0;
        for (Integer i = 1; i <= 10000; i++)// adds 10000 Integer numbers to the empty array list. 
        {
            myArray.add(i);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(5, j, timeLength);
        runtime.gc();
        arrayListMemory += runtime.totalMemory() - freeMemory;
        myList.removeAll();
        myArray.removeAll();
    }

    public static void fourthCase(int j) {
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        for (Integer i = 10000; i >= 1; i--) // adds 10000 Integer numbers to the empty linked list, at index zero.
        {
            myList.add(i, 0);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(6, j, timeLength);
        runtime.gc();
        linkedListMemory += runtime.totalMemory() - freeMemory;
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        timeLength = 0;
        for (Integer i = 10000; i >= 1; i--) // adds 10000 Integer numbers to the empty array list at index zero.
        {
            myArray.add(i, 0);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(7, j, timeLength);
        runtime.gc();
        arrayListMemory += runtime.totalMemory() - freeMemory;
        myList.removeAll();
        myArray.removeAll();
    }

    public static void fifthCase(int j) {
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        for (Integer index = 1; index <= 9999; index++) //starts with a linked list of 10000 and removes all even numbers.
        {
            myList.remove(index);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(8, j, timeLength);
        runtime.gc();
        linkedListMemory += runtime.totalMemory() - freeMemory;
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        timeLength = 0;
        for (Integer index = 1; index <= 9999; index++) //starts with a array list of 10000 and removes all even numbers.
        {
            myArray.remove(index);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(9, j, timeLength);
        runtime.gc();
        arrayListMemory += runtime.totalMemory() - freeMemory;
        myList.removeAll();
        myArray.removeAll();
    }

    public static void sixthCase(int j) {
        for (Integer i = 1; i <= 10000; i++) {
            myList.add(i);
            myArray.add(i);
        }
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        for (Integer index = 9998; index >= 0; index = index - 2) //starts with a linked list of 10000 and removes all odd numbers.
        {
            myList.remove(index);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(10, j, timeLength);
        runtime.gc();
        linkedListMemory += runtime.totalMemory() - freeMemory;
        freeMemory = runtime.freeMemory();
        start = System.nanoTime();
        timeLength = 0;
        for (Integer index = 9998; index >= 0; index = index - 2) //starts with a array list of 10000 and removes all odd numbers.
        {
            myArray.remove(index);
        }
        stop = System.nanoTime();
        timeLength = (stop - start);//time in nanoseconds.
        data.setTime(11, j, timeLength);
        runtime.gc();
        arrayListMemory += runtime.totalMemory() - freeMemory;
        myList.removeAll();
        myArray.removeAll();
    }

    public static void chart() {
        data.chart();// MAKES CHART
        data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ALLOWS TO CLOSE.
        data.setSize(1600, 300);// SETS SIZE OF WINDOW TO DISPLAY CHART.
        data.setVisible(true);
        data.setTitle("Test Results");//SETS TITLE

    }

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            switch (1) {
                case 1:
                    firstCase(j);
                case 2:
                    secondCase(j);
                case 3:
                    thirdCase(j);
                case 4:
                    fourthCase(j);
                case 5:
                    fifthCase(j);
                case 6:
                    sixthCase(j);
                    System.out.println((j + 1) + " test cycle complete.");//lets the user know how many cycles the 6 test case have been through.
                    break;// stops the test cases.
            }
        }
        System.out.println("The linked list used an average of: " + ((linkedListMemory)) + " Bytes, or: " + ((linkedListMemory) / 1000000) + " Megabytes."
                + "\nThe Array list used an average of:   " + ((arrayListMemory)) + " Bytes, or: " + ((arrayListMemory) / 1000000) + "  Megabytes.");
        data.averageAndDev();//calculates the average and standard deviation.
        chart();
    }
}
