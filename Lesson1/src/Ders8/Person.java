package Ders8;

 public class Person {
    String name;
    public String surNname;
    private String email;
   protected String phone;
   public static String b;

   public void printHello(){
    System.out.println("hello");
   }
   private String getName(String name){
    return name;
   }

   Person(String name) {
   this.name = name;
  }

  protected Person(String name, String surNname) {
   this.name = name;
   this.surNname = surNname;
  }

  private Person() {
  }

  public Person(String name, String surNname, String email, String phone) {
   this.name = name;
   this.surNname = surNname;
   this.email = email;
   this.phone = phone;
  }

  String getSUrname(String surname){
    return surname;
   }
   protected void printSalam(){
    System.out.println("Salam");
   }

   public String finalParameter(final String a){
    return  a;
   }
}
