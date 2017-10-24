package edu.upc.data;

public class Track extends DAO{

    public int id;
    public String group;
    public String titulo;

public void setGroup(String group)
{
    this.group = group;
}


    public static void main (String[] args) {
        Track t = new Track();
        t.insert();
    }
}
