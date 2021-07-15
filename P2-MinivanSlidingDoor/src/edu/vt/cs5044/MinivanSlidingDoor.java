package edu.vt.cs5044;

public class MinivanSlidingDoor {

    // TODO: Add your private fields here
    private Gear gear;
    private boolean locked;
    private boolean open;
    private boolean childSafe;
  

    public MinivanSlidingDoor() {
        gear = Gear.PARK;
        locked = false;
        open = false;
        childSafe = false;
     
        // TODO: Your implementation goes here
    }

    public boolean isOpen() {

        return open; 
    }

    public boolean isLocked() {

        return locked; 
    }

    public boolean isChildSafe() {
        return childSafe; 
    }

    public Gear getGear() {
        return gear;     }

    public Event setGear(Gear newGear) {
        Event event = null;
        Gear currentGear = getGear();

        if (newGear == null) {
            event = Event.INVALID_PARAMETER;
        }

        if (currentGear == Gear.PARK && newGear != Gear.PARK) {
            event = Event.GEAR_RELEASED;
        }

        if (currentGear != Gear.PARK && newGear == Gear.PARK) {
            event = Event.GEAR_PARKED;
        }

        if (currentGear != Gear.PARK && newGear != Gear.PARK) {
            event = Event.GEAR_CHANGED;
        }
        return event;
    }

    public Event setChildSafe(boolean engage) {
        boolean isDoorOpen = isOpen();
        Event event = null;
        if (isDoorOpen) {
            childSafe = engage;
            event = childSafe ? Event.CHILDSAFE_ENGAGED : Event.CHILDSAFE_DISENGAGED;
        } else {
            event = Event.CHILDSAFE_INACCESSIBLE;
        }
        return event;
    }

    public Event pushLockButton() {
       if (!locked) {
           locked = true;
           return Event.DOOR_LOCKED;
       }
        return Event.NO_ACTION; 
    }

    public Event pushUnlockButton() {
        if (!locked) {
            locked = true;
            return Event.DOOR_UNLOCKED;
        }
        return Event.NO_ACTION;
    }
private Event handleOpenProcess(Direction direction) {
    //logic goes here...
    return null;
    
}

    public Event pushDashboardButton(Direction direction) {
        
        return handleOpenProcess(direction);
    }

    public Event pullInsideHandle(Direction direction) {
        // TODO: need to first handle child-safe
        return handleOpenProcess(direction);
        
    }

    public Event pullOutsideHandle(Direction direction) {
       
        return handleOpenProcess(direction);
    }

}
