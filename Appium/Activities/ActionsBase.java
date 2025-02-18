package activities;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

import org.openqa.selenium.Point;
import java.util.Arrays;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {
    // Create the pointer for touch actions
    private static final PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    // Create the swipe action
    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        // Create sequence of actions
        Sequence swipe = new Sequence(pointer, 1)
            .addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.x, start.y)) // Move to start point
            .addAction(pointer.createPointerDown(LEFT.asArg())) // Finger touches the screen (Use 0 instead of LEFT.asArg())
            .addAction(pointer.createPointerMove(ofMillis(duration), viewport(), end.x, end.y)) // Move to end point
            .addAction(pointer.createPointerUp(LEFT.asArg())); // Finger lifts up (Use 0 instead of LEFT.asArg())

        driver.perform(Arrays.asList(swipe));
    }
}
