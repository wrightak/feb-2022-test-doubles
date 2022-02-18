package missile;

import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MissileLauncherTest {
    @Test
    public void givenGoodLaunchCodes_MissileIsLaunched() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new GoodLaunchCodeStub());

        assertEquals(missileSpy.launchWasCalled(), true);
    }

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_dummy() {
        launchMissile(new DummyMissile(), new ExpiredLaunchCodeStub());
    }

    @Test
    void givenExpiredLaunchCodes_MissileIsNotLaunched_spy() {
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, new ExpiredLaunchCodeStub());

        assertEquals(missileSpy.launchWasCalled(), false);
    }
}
