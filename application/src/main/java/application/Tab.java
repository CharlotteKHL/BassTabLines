package application;

import java.util.HashMap;
import java.util.Scanner;

public class Tab {
    private String G = "G|";
    private String D = "D|"; 
    private String A = "A|";
    private String E = "E|";
    private HashMap<String,String> majorChordConversion = new HashMap<String,String>();
    private String INVALID_NOTE_MSG = "An invalid note has been included, please only include: C,C#,D,D#,E,F,F#,G,G#,A,A#,B";
    private String INVALID_LENGTH_MSG = "Your input is invalid, please only use 4 beats per bar";

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

    public Tab(){}

    public Tab(String input) throws InvalidInputException{
        majorChordConversion.put("C", "D2");
        majorChordConversion.put("C#", "G1");
        majorChordConversion.put("D", "G2");
        majorChordConversion.put("D#", "D1");
        majorChordConversion.put("E", "G1");
        majorChordConversion.put("F", "E1");
        majorChordConversion.put("F#", "E1");
        majorChordConversion.put("G", "A2");
        majorChordConversion.put("G#", "D1");
        majorChordConversion.put("A", "D1");
        majorChordConversion.put("A#", "A1");
        majorChordConversion.put("B", "A1");

        createTab(input);
    }

    public void createTab(String input) throws InvalidInputException{
      
        System.out.println("Input the base chords:");
        String[] chords = input.split(" ");
        int lengthCount = 0;
        String last = "";

        for(String chord : chords){
            last = chord;
            if(lengthCount >  4){
                throw new InvalidInputException(INVALID_LENGTH_MSG);
            }
            G += "-";
            D += "-";
            A += "-";
            E += "-";
            switch(chord){
                case "-":
                    G += "-";
                    D += "-";
                    A += "-";
                    E += "-";
                    lengthCount++;
                    break;
                
                case "+":
                    while(lengthCount != 4){
                        G += "-";
                        D += "-";
                        A += "-";
                        E += "-";
                        lengthCount++;
                    }
                    G += "|";
                    D += "|";
                    A += "|";
                    E += "|";
                    lengthCount = 0;
                    break;

                default:
                    String bassNote = majorChordConversion.get(chord);
                    if(bassNote != null){
                        char note = bassNote.charAt(0);
                        String fret = bassNote.substring(1);
                        lengthCount++;
                        switch(note){
                            case 'G':
                                G += fret;
                                D += "-";
                                A += "-";
                                E += "-";
                            break;

                            case 'D':
                                D += fret;   
                                G += "-";
                                A += "-";
                                E += "-";
                            break;

                            case 'A':
                                A += fret;
                                G += "-";
                                D += "-";
                                E += "-";
                            break;

                            default:
                                E += fret;
                                G += "-";
                                D += "-";
                                A += "-";
                        }
                    } else {
                        throw new InvalidInputException(INVALID_NOTE_MSG);
                    }

            }
        }
        if(lengthCount != 0) {
            while(lengthCount != 4){
                G += "-";
                D += "-";
                A += "-";
                E += "-";
                lengthCount++;
            }
            G += "-";
            D += "-";
            A += "-";
            E += "-";
            G += "|";
            D += "|";
            A += "|";
            E += "|";
        }
    }

    @Override
    public String toString(){
        return G + "\n" + D + "\n" + A + "\n" + E;
    }

}
