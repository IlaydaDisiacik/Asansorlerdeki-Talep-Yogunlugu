
package yazlab12;

import java.util.HashMap;

/**
 *
 * @author balpe
 */
public class Elevator {

    // Uretilecek asansorun bilgileri olacak.
    private int currentFloor = 0;
    private int destination = 0;
    private int capacity = 10;
    private int count_inside = 0; // Musteri bindikce atanacak deger
    private boolean active = false; // Aktifligini tutacak.
    private int elevatorID = 0; // Atanacak deger
    private boolean mode = false; // Anlik calisip calismadigini gosterecek.
    
    

    
    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCount_inside() {
        return count_inside;
    }

    public void setCount_inside(int count_inside) {
        this.count_inside = count_inside;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public boolean getMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    public int getElevatorID() {
        return elevatorID;
    }

    public void setElevatorID(int elevatorID) {
        this.elevatorID = elevatorID;
    }

}
