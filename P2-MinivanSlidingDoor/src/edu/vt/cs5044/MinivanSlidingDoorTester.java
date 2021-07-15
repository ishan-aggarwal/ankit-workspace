package edu.vt.cs5044;
public class MinivanSlidingDoorTester {
    
    public static void main(String [] args) {
        
        MinivanSlidingDoor  door = new MinivanSlidingDoor ();
        
        System.out.println();
        System.out.println( "Initial state");
        System.out.println(door.isLocked() +  " locked expect false");
        
        System.out.println();
        System.out.println("pushed lock button");
        Event event = door.pushLockButton();
        System.out.println(door.isLocked() + " locked expect true");
        System.out.println(event + " locked an unlocked; expect " + Event.DOOR_LOCKED);
     
        System.out.println();
        System.out.println("pushed locked button again");
        event = door.pushLockButton();
        System.out.println(door.isLocked() + " locked expect true");
        System.out.println(event + " locked an unlocked; expect " + Event.NO_ACTION);
     
        System.out.println();
        System.out.println("set gear to null");
        event = door.setGear(null);
        System.out.println(door.getGear() + " locked expect PARK");
        System.out.println(event + " setting null gear; expect " + Event.INVALID_PARAMETER);
     
    
    }

}
