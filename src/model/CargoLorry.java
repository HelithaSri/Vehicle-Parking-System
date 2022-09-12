package model;

public class CargoLorry extends Vehicle {
    int[] reservedSlotsCargoLorry = {5, 6, 7, 8, 9, 10, 11};
    String[] parked = {"null", "null", "null", "null", "null", "null", "null"};
    int slot;
    String passValue;

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        if (parked[slot].equals("null")) {
            parked[slot] = vehicleNumber;
            //System.out.println("add....");
        } else {
            System.out.println("allready parked");
        }
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        for (int i=0; i < parked.length; i++){
            if (vehicleNumber.equals(parked[i])){
                //System.out.println("Delivery : "+parked[i]);
                parked[i]="null";
                slot=i;
                break;
            }else{
                System.out.println("not leving");
            }
        }
    }

    @Override
    public String setSlot(String vehicleNumber, String vehicleType) {
        /*for (int i = 0; i < reservedSlotsCargoLorry.length; i++) {
            if (parked[i].equals(vehicleNumber)) {
                passValue = "Parked";
                //System.out.println("Parked..");
                break;
            } else {
                if (parked[i].equals("null")) {
                    //System.out.println(reservedSlotsCargoLorry[i]);
                    passValue = Integer.toString(reservedSlotsCargoLorry[slot]);
                    slot = i;
                    break;
                }
            }
        }
        return passValue;*/
        for (int i = 0; i < reservedSlotsCargoLorry.length; i++) {

            for (int j = 0; j < reservedSlotsCargoLorry.length; j++) {
                if (parked[j].equals(vehicleNumber)) {
                    passValue = "Parked";
                    //System.out.println("Parked..slot");
                    return passValue;
                }
                //System.out.println("loop :" + j);
                if (j == 5) {
                    break;
                }
            }

            if (parked[i].equals("null")) {
                //System.out.println("view slot " + reservedSlotsCargoLorry[i]);
                slot = i;
                passValue = Integer.toString(reservedSlotsCargoLorry[slot]);
                break;
            }

        }
        return passValue;
    }
}
