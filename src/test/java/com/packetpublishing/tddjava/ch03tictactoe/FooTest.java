package com.packetpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author mofei
 * @see tdd-java-ch03-tic-tac-toe
 * @since 2020/12/7 11:22
 */
public class FooTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Foo foo;

    @Before
    public final void before() {
        foo= new Foo();
    }

    @Test
    public void whenDoFooThenThrowRuntimeException() {
        Foo foo = new Foo();
//        exception.expect(RuntimeException.class);
        foo.doFoo();
    }

    /**
     * given /when /then
     */
    @Test
    public void whenSomethingThenResultIsSomethingElse() {

    }
}
