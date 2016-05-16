package andoresu.ultimoquiz;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Students")
public class Student extends Model{
    @Column(name = "Name")
    public String name;

    @Column(name = "LastName")
    public String lastName;

    public Student(){
        super();
    }

    public Student(String name, String lastName) {
        super();
        this.name = name;
        this.lastName = lastName;
    }

    public static List<Student> getAll(){
        return new Select()
                .from(Student.class)
                .execute();
    }

    public String getFullName(){
        return this.name + " " + this.lastName;
    }
}
