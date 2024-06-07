package ders14;

public class Main14 {
    public static void main(String[] args) {
        //User john=new User("james","12");
        //saveUser(john);

        int[] m={4,5};
        try
        {
            printArrayElement(m,9);
        }catch (MenimExc ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getAlma().color);
        }

    }

    static void printArrayElement(int[] massiv,int index) throws MenimExc{
        if(index>=massiv.length || index<0){
            Alma quba=new Alma();
            quba.color="red";
            quba.price=222;
            throw new MenimExc("massivin l",quba);
        }
        System.out.println(massiv[index]);
    }

    static void saveUser(User user){
        String[] realUsernames={"kenan","james"};
        boolean thisUsernameAlreadyExists=false;
        for (String un: realUsernames) {
            if(un.equals(user.getUsername())){
                thisUsernameAlreadyExists=true;
                break;
            }

        }

        if(thisUsernameAlreadyExists){
            System.out.println("basqa username secin");

        }else{
            System.out.println("ugurla qeyd olundunuz");
        }
    }



}
