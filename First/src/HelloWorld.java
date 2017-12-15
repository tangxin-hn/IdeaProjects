public class HelloWorld {
    private String name;

    public HelloWorld (){
        System.out.println("constructor");
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }
    public void sayHello() {
        System.out.print("Hello" + name);
    }
}
