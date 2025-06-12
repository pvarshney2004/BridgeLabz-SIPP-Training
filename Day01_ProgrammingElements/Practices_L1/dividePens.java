public class dividePens {
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;
        int pen_divided = pens/students;
        int remaining_pens = pens%students;
        System.out.println("The Pen Per Student is: " + pen_divided + " and the remaining pen not distributed is: " + remaining_pens);
    }
}
