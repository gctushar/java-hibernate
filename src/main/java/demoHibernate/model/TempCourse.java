package demoHibernate.model;


public class TempCourse {

    private String courseName;
    private int courseCode;

    public TempCourse(String courseName, int courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
