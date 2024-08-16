package models.Users;

public class Admin extends Employee{

    public Admin() {
    }

    public Admin(int empID, String empName, String email, String phone, int empType, String passwd) {
        super(empID, empName, email, phone, empType, passwd);
    }

    @Override
    public int getEmployeeType() {
        return 1;
    }

//----------------------------------------------------------------------------------------------------------------------
    //Functions to be implemented for the Admin :

    //1.Create Rooms
       //Details to be inserted to the room Table of the DB
           //RoomID,RoomType,SeatingCapacity (option -Amenities)

//----------------------------------------------------------------------------------------------------------------------
    //2.Edit Meeting rooms configuration
      //Details to be updated to the room Table of the DB
          //RoomID,NewRoomType,NewSeatingCapacity

    //3. Fetch the fresh Details of the Room from the room TABLE IN DB.
          //Update the list of rooms in the Dao after any specific changes.
}