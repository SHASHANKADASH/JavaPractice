package utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;



//MathUtil is SUT(System under test)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)//it is the default behaviour
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)// in this case instance is created first so need for static
@DisplayName("When running MathUtils")
class MathUtilsTest {
    MathUtils mathUtils;//Dependency
    TestInfo testInfo;
    TestReporter testReporter;

    //@BeforeAll
    //void beforeAllInit(){//here @before all wont work as we cannot run a method before instance of the class is created
    //                     //hence those methods must be made static cause the don't need instance
    //    System.out.println("This needs to run before all");
    //}

    @BeforeEach
    void init(TestInfo testInfo,TestReporter testReporter){//runs before instance is created
        this.testInfo=testInfo;
        this.testReporter=testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Currently Running "+ testInfo.getDisplayName() + "with tag" + testInfo.getTags() );
    }

    //@AfterEach
    //void cleanup(){
    //    System.out.println("Cleaning up");;
    //}
    @Nested
    @DisplayName("When running Addtest")
    class AddTest{
        @Test
        @Tag("Math")
        @DisplayName("Testing add method for -")
        void addNegative() {
            int actual = mathUtils.add(-4,-2);
            assertEquals(-6,actual,"The add method should add two numbers");
        }

        @Test
        @DisplayName("Testing add method for +")
        void addPositive() {
            int actual = mathUtils.add(0,2);
            assertEquals(2,actual,"The add method should add two numbers");
        }
    }


    @Test
    @DisplayName("Testing add method")
    void add() {
        //System.out.println("Test ran");
        int expected=2;
        int actual = mathUtils.add(1,1);

        assertEquals(expected,actual,()->"The add method should return "+expected+" but returned " + actual);
        //converting the string to lambda ensures that the string is only computed when test fails not everytime
    }

    @Test
    //@Disabled
    void divideTest(){
        assumeTrue(true);
        assertThrows(ArithmeticException.class,()->mathUtils.divide(1,0),"divide by zero should throw");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @Tag("Circle")//will help to selectively run the tests
    void computeCircleArea()
    {

        assertEquals(Math.PI*10*10,mathUtils.computeCircleArea(10),"Should return the area of the circle");
    }

    @RepeatedTest(4)
    @DisplayName("multiply")
    void testMultiply(RepetitionInfo repetitionInfo)
    {
        //assertEquals(4,mathUtils.multiply(2,2),"Should return product");
        repetitionInfo.getCurrentRepetition();
        assertAll(
                ()->assertEquals(4,mathUtils.multiply(2,2)),
                ()->assertEquals(-2,mathUtils.multiply(2,-1)),
                ()->assertEquals(6,mathUtils.multiply(3,2)),
                ()->assertEquals(0,mathUtils.multiply(2,0))
        );
    }
}