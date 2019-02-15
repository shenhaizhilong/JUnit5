# Junit5
___
> 本文译自[junit5/docs/current/user-guide](https://junit.org/junit5/docs/current/user-guide/)

## 1、 回顾

### 1.1 什么是JUnit5
与之前的版本不同，JUnit5 由三个不同的子模块组合而成。

## JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage ##

JUnit Platform : 作为在JVM 上启动测试框架的基础。它还定义了 TestEngine API，用于 开发在平台上运行的测试框架。该平台提供了一个控制台启动器，用于从命令行启动平台，以及一个基于JUnit 4的运行器，用于在基于JUnit 4的环境中运行平台上的任何TestEngine。
JUnit Jupiter： 是用于在JUnit5中编写测试和扩展的新编程模型和扩展模型的组合。Jupiter子项目为在平台上运行基于Jupiter的测试提供了一个测试引擎。
JUnit Vintage: 提供一个用于在平台上运行基于JUnit 3和JUnit 4的测试引擎。
### 1.2 支持的Java版本
Java 8 或者更高。然而，你也可以测试以前版本的JDK
### 1.3 开始
[github link](https://github.com/junit-team/junit5-samples)
## 2、 编写测试
第一个测试用例：
```
	public static void assertEquals(int expected, int actual, String message) {
		AssertEquals.assertEquals(expected, actual, message);
	}
```

```
package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FirstDemo {
    private final Calculator calculator = new Calculator();
    @Test
    void addTest()
    {
        assertEquals(3,calculator.add(1,1),"1 + 1 should be equal 2");
    }
}

output:
org.opentest4j.AssertionFailedError: 1 + 1 should be equal 2 ==> 
Expected :3
Actual   :2


```
### 2.1 注解 Annotations
|注解    |描述|
|:---------------- |:------------------------
|@Test| 表示该方法是测试方法。不像JUnit4的@Test注解，这个注解并不会声明任何属性，因为JUnit |Jupiter中的测试扩展是基于它们自己专用的注解进行操作的。除非重写这个方法，否则它们将被继承
|@ParameterizedTest |表示这个方法是参数化测试。除非重写这个方法，否则它们将被继承的
|@RepeatedTest| 表示这个方法是用于重复测试的测试模板。除非重写这个方法，否则它们将被继承
|@TestFactory|表示该方法是用于动态测试的测试工厂。除非重写这个方法，否则它们将被继承
|@TestTemplate|表示该方法是测试用例的模板，设计为可多次调用，调用的次数取决于由注册提供者返回的调用上下文的数量
|@TestMethodOrder|用于对注解测试类配置测试方法的执行顺序；类似于JUnit4 的@FixMethodOrder. 这样的注解是被继承的
|@TestInstance|用于为带注解的测试类配置测试实例生命周期。这样的注解是被继承的
|@DisplayName|用于对测试类或者测试方法声明一个自定义的显示名称。此类注解不被继承
|@DisplayNameGeneration|用于对测试类声明一个自定义的显示名称生成器。此类注解被继承
|@BeforeEach|表示该注解方法应该在**每一个**当前类的@Test, @RepeatedTest, @ParameterizedTest 或者 @TestFactory方法前执行；类似与JUnit4 的@Before。除非被重写，否则此方法被继承。
|@AfterEach|表示该注解方法应该在**每一个**当前类的@Test, @RepeatedTest, @ParameterizedTest 或者 @TestFactory方法后执行；类似与JUnit4 的@After。除非被重写，否则此方法被继承。
|@BeforeAll|表示该注解方法应该在**所有**当前类的@Test, @RepeatedTest, @ParameterizedTest, 和 @TestFactory 方法前执行；类似与JUnit4的@BeforeClass。此类方法是被继承的（除非被重写或隐藏）而且必须是静态方法（除非使用了“per-class" 测试实例声明周期）
|@AfterAll|表示该注解方法应该在**所有**当前类的@Test, @RepeatedTest, @ParameterizedTest, 和 @TestFactory 方法后执行；类似与JUnit4的@AfterClass。此类方法是被继承的（除非被重写或隐藏）而且必须是静态方法（除非使用了“per-class" 测试实例声明周期
|@Nested|表示该注解类是非静态的嵌套测试类。@BeforeAll和@AfterAll方法不能直接在@嵌套测试类中使用，除非使用了“per-class”测试实例生命周期。此类注解不被继承。
|@Tag|用于声明过滤测试标签，在类或者方法级别；类似于JUnit4 中的TestNG 测试组 或者Categories
|@Disabled|用于禁用一个测试类或者测试方法；类似与JUnit4 的@Ignore。此类注解不被继承
|@ExtendWith|用于以声明方式注册扩展。此类注解被继承。
|@RegisterExtension|用于通过字段一编程方式注册扩展。此类字段被继承，除非它们被遮蔽。
|@TempDir|用于在生命周期方法或测试方法中通过字段注入或参数注入提供临时目录;位于org.junit.jupiter.api.io 包内

### 2.1.1 元注解与复合注解
JUnit Jupiter 注解可以用作元注解。这意味着你可以定义自己的复合注解---将自动继承其元注释的语义。
举个例子，你可以新建一个自定义的如下注解@Fast，来替代通篇的复制和粘贴@Tag(“Fast”)。@Fast 可以看作一个插入式替换@Tag("fast")

```
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}

```
如下@Test 方法描述了@Fast 注解的使用
```

@Fast
@Test
void myFastTest() {
    // ...
}
```
当然你甚至可以更近一步通过引入自定义的@FastTest 注解-- 可用作插入式替换@Tag("fast") 和@Test。
```
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
@Test
public @interface FastTest {

}
```
JUnit 会自动识别下面的方法为@Test 方法并且这个方法别标记为"fast"。
```
@FastTest
void myFastTest() {
    // ...
}
```


### 2.2 测试类与方法 Test Classes and Methods
**测试类** ： 任何顶级类，静态成员类或者@Nest 类 ->至少包含一个测试方法。测试类不能为抽象类，必须又一个构造函数

**测试方法** ：任何以@Test,@RepeatedTest，@ParameterizedTest，@TestFactory,@TestTemplate 注解或者元注解的实例方法

**生命周期方法** ：直接用@BeforeAll、@AfterAll、@BeforeEach或@AfterEach注解或元注解的任何方法

测试方法和生命周期方法可以在当前测试类内部声明，或者继承自父类，或者继承自接口。除此之外，测试方法和生命周期方法必须不是抽象方法而且不能有返回值
> 测试类，测试方法和生命周期方法不要求用public 修饰符修饰，但是他们不能用private修饰

示例测试类：
```
package com.example.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StandardTests {

    @BeforeAll
    public static void initAll(){

    }

    @BeforeEach
    public void init()
    {

    }

    @Test
    public void succeedingTest()
    {

    }

    @Test
    public void failingTest(){
        // fail information
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    public void skippedTest(){
        // not executed,since this method was disabled
    }

    @Test
    public void abortedTest(){
        assumeTrue("abc".contains("z"));
        fail("test should have been aborted");
    }

    @AfterEach
    public void tearDown(){}

    @AfterAll
    public static void tearDownAll(){}

}

```

<div align="center"> <img src="src/pics/20190213225006.jpg" width=""/> </div><br>

### 2.3 显示名称 Display Names
测试类或者测试方法可以通过@DisplayName声明自定义的显示名称,该名称可以是空格，特殊字符，甚至emojis，这将在测试报告中以及测试运行器和ide中显示。

```
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

}
```
### 2.3.1 显示名称生成器 Display Name Generators

JUnit Jupiter 支持自定义的显示名称生成器--可以通过@DisplayNameGeneration 注解配置。通过@DisplayName注释提供的值总是优先于DisplayNameGenerator生成的显示名称
```
package com.example.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

public class DisplayNameGeneratorDemo {
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported{
        @Test
        void if_it_is_zero(){}

        @DisplayName("A negative value for year is not supported by the leap year computation")
        @ParameterizedTest(name = "For an example,year {0} is not supported")
        @ValueSource(ints = {-1,-4})
        void if_it_is_negative(int year){}
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class A_year_is_a_leap_year{
        @Test
        void if_it_is_divisible_by_4_but_not_by_100(){}

        @ParameterizedTest(name = "Year {0} is a leap year")
        @ValueSource(ints = {2016,2020,2048})
        void if_it_is_one_of_the_following_years(int year)
        {

        }
    }


    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + ' ' + testMethod.getName();
            return name.replace('_', ' ') + '.';
        }

    }
}

```
<div align="center"> <img src="src/pics/20190213232900.jpg" width=""/> </div><br>


### 2.4 断言 Assertions
JUnit Jupiter 附带了JUnit 4所具有的许多断言方法，并添加了一些适合与Java 8 lambdas一起使用的断言方法。所有的JUnit Jupiter [org.junit.jupiter.api.Assertions](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html) 中的静态方法

```
package com.example.project;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane", "Doe");

    @Test
    public void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2), "The optional failure message");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");

    }

    @Test
    public void groupAssertions() {

        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName()));
    }

    @Test
    public void dependentAssertions() {

        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);
                    assertAll("firstName",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e")));
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                });
    }

    @Test
    public void ExceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    public void timeoutNotExceed() {
        // the following assertion succeeds
        assertTimeout(Duration.ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }

    @Test
    public void timeoutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMinutes(2), () -> "a result");
        assertEquals("a result", result);
    }

    @Test
    public void timeoutNotExceededWithMethod()
    {
        String greeting = assertTimeout(Duration.ofMinutes(2), AssertionsDemo::greeting);
        assertEquals("Hello, World!", greeting);
    }

    @Test
    public void timeoutExceeded()
    {
        assertTimeout(Duration.ofMillis(10), () ->  Thread.sleep(100));

    }


    private static String greeting()
    {
        return "Hello, World!";
    }

}

```
### 2.4.1 Kotlin Assertion 支持
JUnit Jupiter 还附带了一些新的适用于Kotlin 的断言方法。所有的Kotlin 断言是org.junit.jupiter.api 包中的顶级函数。
```
import example.domain.Person
import example.util.Calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows

class KotlinAssertionsDemo {

    val person = Person("Jane", "Doe")
    val people = setOf(person, Person("John", "Doe"))

    @Test
    fun `expected exception testing`() {
        val calculator = Calculator()
        val exception = assertThrows<ArithmeticException> ("Should throw an exception") {
            calculator.divide(1, 0)
        }
        assertEquals("/ by zero", exception.message)
    }

    @Test
    fun `grouped assertions`() {
        assertAll("Person properties",
            { assertEquals("Jane", person.firstName) },
            { assertEquals("Doe", person.lastName) }
        )
    }

    @Test
    fun `grouped assertions from a stream`() {
        assertAll("People with first name starting with J",
            people
                .stream()
                .map {
                    // This mapping returns Stream<() -> Unit>
                    { assertTrue(it.firstName.startsWith("J")) }
                }
        )
    }

    @Test
    fun `grouped assertions from a collection`() {
        assertAll("People with last name of Doe",
            people.map { { assertEquals("Doe", it.lastName) } }
        )
    }
}
```
### 2.4.2 第三方断言库
尽管JUnit Jupiter 提供了对很多测试场景都足够高效的断言工具，但有时需要更多的强大功能和附加功能，比如matchers。在这些场景，JUnit 团队推荐使用第三方断言库例如：[AssertJ](https://joel-costigliola.github.io/assertj/), [Hamcrest](https://hamcrest.org/JavaHamcrest/), [Truth](https://google.github.io/truth/) 等。因此开发者可以根据自己下需求自由的选择断言库
例如，匹配器matchers和Fluent API的组合可用于使断言更具描述性和可读性。然而，JUnit Jupiter的 org.junit.jupiter.api.Assertions 类并没有提供类似于JUnit 4中接收Hamcrest Matchers 的AssertThat() 方法。 相反，我们鼓励开发者使用第三方断言库提供的内建mathcher
以下例子阐述了如何在Junit Jupiter 测试中使用Hamcrest 的assertThat() 方法。只要Hamcrest库已经被添加到了classpath, 你可以静态导入assertThat(), is()和 equalTo()，并且像如下assertWithHamcrestMatcher() 的方法中使用它们。

```
package com.example.project;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestAssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    public void assertWithHamcrestMatcher()
    {
        assertThat(calculator.substract(4,1), is(equalTo(3)));
    }

}
```
<div align="center"> <img src="src/pics/20190214111258.jpg" width=""/> </div><br>


### 2.5 假设 Assumptions 
### 2.6 禁用测试 Disabling Tests
### 2.7 条件测试执行 Conditional Test Execution
### 2.8 标记和过滤 Tagging and Filtering
### 2.9 测试执行顺序 Test Execution Order
### 2.10 测试实例生命周期 Test Instance Lifecycle
### 2.11 嵌套测试 Nested Tests
### 2.12 构造器与方法的依赖注入 Dependency Injection for Constructors and Methods
### 2.13 测试接口与默认方法 Test Interfaces and Default Methods
### 2.14 重复测试 Repeated Tests
### 2.15 参数化测试 Parameterized Tests
### 2.16 测试模板 Test Templates
### 2.17 动态测试 Dynamic Tests
### 2.18 并行执行 Parallel Execution
### 2.19 内置扩展 Built-in Extensions