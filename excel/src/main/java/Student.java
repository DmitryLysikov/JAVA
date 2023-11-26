import java.util.UUID;

public class Student {
    private String name;
    private String surname;
    private String email;
    private UUID ulearnID;
    private String studentGroup;
    public String getName(){
        return name;
    }
    public void setName(String name){
        if (!name.isEmpty() && name != null){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        if (!surname.isEmpty() && surname != null){
            this.name = surname;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        if (!email.isEmpty() && email != null){
            this.email = email;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public UUID getUlearnID(){
        return ulearnID;
    }
    public void setUlearnID(UUID ulearnID){
        if (ulearnID != null){
            this.ulearnID = ulearnID;
        }
    }
    public String getStudentGroup(){
        return studentGroup;
    }
    public void setStudentGroup(String studentGroup){
        if(!studentGroup.isEmpty() && studentGroup != null){
            this.studentGroup = studentGroup;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
