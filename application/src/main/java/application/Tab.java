package application;

public class Tab {
    private String G = "G|";
    private String D = "D|"; 
    private String A = "A|";
    private String E = "E|";

    public String getG(){
        return G;
    }

    public String getD(){
        return D;
    }

    public String getA(){
        return A;
    }

    public String getE(){
        return E;
    }

    @Override
    public String toString(){
        return G + "\n" + D + "\n" + A + "\n" + E;
    }

}
