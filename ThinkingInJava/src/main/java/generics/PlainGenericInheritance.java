package generics;//: generics/PlainGenericInheritance.java

class GenericSetter<T extends GenericSetter<T>> { // Not self-bounded
  void set(T arg){
    System.out.println("GenericSetter.set(GenericSetter)");
  }
}

class DerivedGS extends GenericSetter<DerivedGS> {

}	

public class PlainGenericInheritance {
  public static void main(String[] args) {
    Derived derived = new Derived();
    DerivedGS dgs = new DerivedGS();
    DerivedGS dgs1 = new DerivedGS();
    //dgs.set(derived);
    dgs.set(dgs1); // Compiles: overloaded, not overridden!
  }
} /* Output:
DerivedGS.set(Derived)
GenericSetter.set(Base)
*///:~
