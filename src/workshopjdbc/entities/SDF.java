/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopjdbc.entities;


/**
 *
 * @author hp
 */
public class SDF {
      private int id;
          private String Name;
        private String last_name;
        private String gender;
        private int age;
         private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SDF(String Name, String last_name, String gender, int age, String image) {
        this.Name = Name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.image = image;
    }

    public SDF(){}

    public SDF(String text, String text0, String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SDF(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public String toString() {
        return "SDF{" + "id=" + id + ", Name=" + Name + ", last_name=" + last_name + ", gender=" + gender + ", age=" + age + '}';
    }

    public SDF(int id, String Name, String last_name, String gender, int age) {
        this.id = id;
        this.Name = Name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public SDF(String Name, String last_name, String gender,int age) {
        this.Name = Name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
return age;    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 3;
      
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SDF other = (SDF) obj;
        if (this.id != other.id) {
            return false;
        }
       
        return true;
    }
    

   
        
}
