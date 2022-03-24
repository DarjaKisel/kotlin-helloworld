package me.dzinevich;

public class MountainBike extends Bicycle {

  private int seatHeight;

  public MountainBike(int cadence,
                      int gear,
                      int speed,
                      int seatHeight) {
    super(cadence, gear, speed);
    this.seatHeight = seatHeight;
  }

  public int getSeatHeight() {
    return seatHeight;
  }

  public void setSeatHeight(int seatHeight) {
    this.seatHeight = seatHeight;
  }
}
