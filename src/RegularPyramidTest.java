import something.RegularPyramid;

public class RegularPyramidTest {
    public static void main(String[] args) {
        //set the parameters and instantiate an object of Regular Pyramid
        RegularPyramid rp = new RegularPyramid(6, 7, 12);

        System.out.println("Slant Height: " + rp.slantHeight());
        System.out.println("Base Circum Radius: " + rp.baseCircumradius());
        System.out.println("Base Perimeter: " + rp.basePerimeter());
        System.out.println("Base Area: " + rp.baseArea());
        System.out.println("Lateral Area: " + rp.lateralArea());
        System.out.println("Total Surface Area: " + rp.totalSurfaceArea());
        System.out.println("Volume: " + rp.volume());
    }
}
