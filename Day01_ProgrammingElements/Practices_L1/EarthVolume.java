public class EarthVolume {
    public static void main(String[] args) {
        int radius = 6378;
        double pi = 3.14;
        double volume_of_earth_km = (4.0/3) * pi * Math.pow(radius, 3);
        double volume_of_earth_mile = volume_of_earth_km/Math.pow(1.6, 3);
        System.out.println(volume_of_earth_km);
        System.out.println(volume_of_earth_mile);
    }
}
