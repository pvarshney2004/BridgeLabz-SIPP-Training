public class cm_inches_feet {
    public static void main(String[] args) {
        int height_cm = 170;
        double height_inches = height_cm/2.54;
        double height_feet = height_inches/12;
        System.out.println("Your Height in cm is: "+height_cm+ " while in feet is: "+height_feet+ " and inches is: "+height_inches);
    }
}
