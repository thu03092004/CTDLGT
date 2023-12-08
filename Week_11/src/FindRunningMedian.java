import java.util.*;

class Element implements Comparable<Element> {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element other) {
        if (this.value == other.value) {
            return this.index - other.index;
        }
        return this.value - other.value;
    }
}

public class FindRunningMedian {
    public static void printMedians(int[] arr) {
        TreeSet<Element> set = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            Element element = new Element(arr[i], i);
            set.add(element);

            Element median = null;
            if (i % 2 == 0) {
                median = set.lower(set.higher(element));
            } else {
                median = set.higher(element);
            }

            System.out.println(median.value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        printMedians(a);
    }
}