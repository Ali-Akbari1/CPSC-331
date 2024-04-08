
// Student Class
class Student implements Hashable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String key() {
        return Integer.toString(id);
    }

    @Override
    public String toString() {
        return id + ":" + name;
    }
}