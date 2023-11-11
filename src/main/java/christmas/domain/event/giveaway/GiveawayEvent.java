package christmas.domain.event.giveaway;

public interface GiveawayEvent {

    static ChampagneEvent getChampagneEvent() {
        return new ChampagneEvent();
    }
}
