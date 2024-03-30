package SpringCore.bean;

public class Store {
    public Item item1;

    @Override
    public String toString() {
        return "\n == Item-1 == \n\tName : "+item1.getName()+
                "\n\tCode : "+item1.getCode()+
                "\n\tdetail : "+item1.getDetail()+
                "\n=========================================";
    }
}
