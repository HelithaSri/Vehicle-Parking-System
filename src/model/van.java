package model;

public class van extends Vehicle {

    int[] reservedSlotsVan = {1, 2, 3, 4, 12, 13};
    public String[] parked = {"null", "null", "null", "null", "null", "null"};
    int slot;
    String passValue;



    public void park(String vehicleNumber, String vehicleType) {
        /*for (int i=0; i<reservedSlotsVan.length; i++){
            if (parked[i].equals(vehicleNumber)){
                System.out.println("Parked..");
                break;
            }
            else{
                if (parked[i].equals("null")){
                    System.out.println(reservedSlotsVan[i]);
                    slot=i;
                    parked[i]=vehicleNumber;
                    break;
                }
            }
        }*/

        if (parked[slot].equals("null")) {
            parked[slot] = vehicleNumber;
            //System.out.println("add...." + slot);
        } else {
            System.out.println("allready parked");
        }
    }


    public void leavePark(String vehicleNumber, String vehicleType) {
        for (int i = 0; i < parked.length; i++) {
            if (vehicleNumber.equals(parked[i])) {
                //System.out.println("Delivery : "+parked[i]);
                parked[i] = "null";
                slot = i;
                break;
            } else {
               //System.out.println("not leving");
            }
        }
    }


    public String setSlot(String vehicleNumber, String vehicleType) {
        for (int i = 0; i < reservedSlotsVan.length; i++) {

            for (int j = 0; j < reservedSlotsVan.length; j++) {
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
                //System.out.println("view slot " + reservedSlotsVan[i]);
                slot = i;
                passValue = Integer.toString(reservedSlotsVan[slot]);
                break;
            }

        }
        return passValue;
    }
}
