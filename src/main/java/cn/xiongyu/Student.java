package cn.xiongyu;

/**
 * ClassName: Student
 * Description:
 * Create by xiongyu
 * Date: 2020/4/30 2:11 下午
 */
public class Student {
    private String id;
    private String name;
    private String school;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student() {
    }

    public Student(String id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode() + name.hashCode() + school.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Student stu = (Student) obj;
        return stu.id.equals(this.id) && stu.name.equals(this.name) && stu.school.equals(this.school);
    }
}
