# junit-expect-exception
In this project we show how to test if exception was thrown using `junit4` and `junit5`.

# junit4
We use `4.12`:
```testCompile group: 'junit', name: 'junit', version: '4.12'```

* Before `4.7`:
    ```
    @Test(expected = RuntimeException.class)
    public void expect_exception() {
        throw new RuntimeException();
    }
    ```
    
* After `4.7`:
    ```
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void expect_exception() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("test");
        
        throw new RuntimeException("test");
    }
    ```

* `@Rule` is:  
    A `JUnit 4` `@Rule` is a component that intercepts test method calls and allows us to do 
    something before a test method is run and after a test method has been run. All 
    `JUnit 4` rule classes must implement the `org.junit.rules.TestRule` interface.  
    _Example use_: Create files and directories which are deleted after a test method 
    has been run.
    
    _Reference_: https://www.testwithspring.com/lesson/introduction-to-junit-4-rules/
    
    
# junit5 + java 8
We use `5.2.0`:
```
testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.2.0'
```
```
@Test
void expect_exception() {
    Executable executable = () -> new TestedObject().testedMethod("test");

    assertThrows(RuntimeException.class, executable, "test");
}

class TestedObject {
    void testedMethod(String param) {
        throw new RuntimeException(param);
    }
}
```
