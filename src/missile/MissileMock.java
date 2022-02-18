package missile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissileMock implements Missile {
    private boolean launchWasCalled = false;
    private boolean disableWasCalled = false;

    @Override
    public void launch() {
        launchWasCalled = true;
    }

    @Override
    public void disable() {
        disableWasCalled = true;
    }

    void verifyCodeRedAbort() {
        assertEquals(launchWasCalled, false);
        assertEquals(disableWasCalled, true);
    }
}
