package Classes;

public class Workers {
    public static int counter = 0;

    private int code;
    private String name;
    private String surname;

    public Workers(int code, String name, String surname) {
        super();
        this.code = counter;
        counter++;
        this.name = name;
        this.surname = surname;
    }
    public Workers() {
        super();
        this.code = 0;
        this.name = "";
        this.surname = "";
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Workers.counter = counter;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Workers [code=" + code + ", name=" + name + ", surname=" + surname + "]";
    }

}
