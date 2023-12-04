package christmas.controller;

import christmas.domain.EventDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void hold() {
        EventDay eventDay = getEventDay();
    }

    private EventDay getEventDay() {
        outputView.printReadDate();
        while (true) {
            try {
                int date = inputView.readDate();
                return EventDay.from(date);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
