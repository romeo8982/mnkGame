import jdk.nashorn.api.scripting.JSObject;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Output {

    public static void main(String[] args) throws IOException, InterruptedException, ScriptException, NoSuchMethodException {
        Output out = new Output();
        EndChecker EndChecker = new EndChecker();
        Scanner myObj = new Scanner(System.in);
        List<Element> elements = new ArrayList<>();
        String input;
        elements.add(new Element(1,1,32));
        out.GenerateBoard(elements);
        elements.remove(0);
        int iterator=0;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName ("nashorn");
        engine.eval(new FileReader("src/JsScript/script2.js"));
        Invocable invocable = (Invocable) engine;
        System.out.println("To change IA please type s.");
        do {
            if (iterator % 2 == 0) {
                input = myObj.nextLine();
                if(input.charAt(0)=='s') {
                    System.out.println("Type script with you want to fight:");
                    input = myObj.nextLine();
                    engine.eval(new FileReader("src/JsScript/"+input));
                    invocable = (Invocable) engine;
                }
                else if (EndChecker.isLegal(elements, Character.getNumericValue(input.charAt(0)), Character.getNumericValue(input.charAt(1)))) {
                    System.out.println("This Move is incorrect, please pick another one.");
                }
                else {
                    elements.add(new Element(
                            Character.getNumericValue(input.charAt(0)),
                            Character.getNumericValue(input.charAt(1)),
                            88));
                    out.GenerateBoard(elements);
                    iterator++;
                }
            }
            else {
                JSObject obj = (JSObject)invocable.invokeFunction("pickAny", elements, 2);
                Collection<Object> result = obj.values();
                List<Integer> coordinate = new ArrayList<>();
                for (Object o : result) {
                    if (!(o instanceof Integer)) {
                        Double d = (double) o;
                        Integer x = d.intValue();
                        coordinate.add(x);
                    }
                    else
                    {
                        Integer d = (Integer) o;
                        coordinate.add(d);
                    }
                }
                if (EndChecker.isLegal(elements, coordinate.get(0), (coordinate.get(1)))) {
                    //System.out.println("This Move is incorrect, please pick another one.");
                }
                else {
                    elements.add(new Element(coordinate.get(0), (coordinate.get(1)), 79));
                    out.GenerateBoard(elements);
                    iterator++;
                }
            }
        }while (EndChecker.end(elements).equals("N")&&elements.size()<25);
        if(elements.size()==25&&EndChecker.end(elements).equals("N"))
            System.out.println("You both played perfectly and lead to draw.");
        else
            System.out.println("Player "+ EndChecker.end(elements)+" win congratulation.");
    }

    public static final char[] EXTENDED = { 0x00C7, 0x00FC, 0x00E9, 0x00E2,
            0x00E4, 0x00E0, 0x00E5, 0x00E7, 0x00EA, 0x00EB, 0x00E8, 0x00EF,
            0x00EE, 0x00EC, 0x00C4, 0x00C5, 0x00C9, 0x00E6, 0x00C6, 0x00F4,
            0x00F6, 0x00F2, 0x00FB, 0x00F9, 0x00FF, 0x00D6, 0x00DC, 0x00A2,
            0x00A3, 0x00A5, 0x20A7, 0x0192, 0x00E1, 0x00ED, 0x00F3, 0x00FA,
            0x00F1, 0x00D1, 0x00AA, 0x00BA, 0x00BF, 0x2310, 0x00AC, 0x00BD,
            0x00BC, 0x00A1, 0x00AB, 0x00BB, 0x2591, 0x2592, 0x2593, 0x2502,
            0x2524, 0x2561, 0x2562, 0x2556, 0x2555, 0x2563, 0x2551, 0x2557,
            0x255D, 0x255C, 0x255B, 0x2510, 0x2514, 0x2534, 0x252C, 0x251C,
            0x2500, 0x253C, 0x255E, 0x255F, 0x255A, 0x2554, 0x2569, 0x2566,
            0x2560, 0x2550, 0x256C, 0x2567, 0x2568, 0x2564, 0x2565, 0x2559,
            0x2558, 0x2552, 0x2553, 0x256B, 0x256A, 0x2518, 0x250C, 0x2588,
            0x2584, 0x258C, 0x2590, 0x2580, 0x03B1, 0x00DF, 0x0393, 0x03C0,
            0x03A3, 0x03C3, 0x00B5, 0x03C4, 0x03A6, 0x0398, 0x03A9, 0x03B4,
            0x221E, 0x03C6, 0x03B5, 0x2229, 0x2261, 0x00B1, 0x2265, 0x2264,
            0x2320, 0x2321, 0x00F7, 0x2248, 0x00B0, 0x2219, 0x00B7, 0x221A,
            0x207F, 0x00B2, 0x25A0, 0x00A0 };

    public static char getAscii(int code) {
        if (code >= 0x80 && code <= 0xFF) {
            return EXTENDED[code - 0x7F];
        }
        return (char) code;
    }

    public static void printChar(List<Integer> line) {
        for (Integer integer : line) {
            System.out.printf("%c", getAscii(integer));
        }
        System.out.println();
    }

    public void GenerateBoard(List<Element> listElements) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        ArrayList<ArrayList<Integer>> listOLists = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            ArrayList<Integer> verticalLine = new ArrayList<>(Arrays.asList(185, 32, 185, 32, 185, 32, 185, 32, 185, 32, 185));
            listOLists.add(verticalLine);
        }
        List<Integer> horizontalLine = Arrays.asList(200, 204, 202, 204, 202, 204, 202, 204, 202, 204, 186);
        for(int i =0;i<listElements.size();i++) {
            if(i==listElements.size()-1)printChar(horizontalLine);
            if (listElements.get(i).x == 1) {
                listOLists.get(0).set(1 + 2 * (listElements.get(i).y - 1), listElements.get(i).z);
            }
            if(i==listElements.size()-1)printChar(listOLists.get(0));
            horizontalLine = Arrays.asList(203, 204, 205, 204, 205, 204, 205, 204, 205, 204, 184);
            if(i==listElements.size()-1)printChar(horizontalLine);
            if (listElements.get(i).x == 2) {
                listOLists.get(1).set(1 + 2 * (listElements.get(i).y - 1), listElements.get(i).z);
            }
            if(i==listElements.size()-1)printChar(listOLists.get(1));
            if(i==listElements.size()-1)printChar(horizontalLine);
            if (listElements.get(i).x == 3) {
                listOLists.get(2).set(1 + 2 * (listElements.get(i).y - 1), listElements.get(i).z);
            }
            if(i==listElements.size()-1)printChar(listOLists.get(2));
            if(i==listElements.size()-1)printChar(horizontalLine);
            if (listElements.get(i).x == 4) {
                listOLists.get(3).set(1 + 2 * (listElements.get(i).y - 1), listElements.get(i).z);
            }
            if(i==listElements.size()-1)printChar(listOLists.get(3));
            if(i==listElements.size()-1)printChar(horizontalLine);
            if (listElements.get(i).x == 5) {
                listOLists.get(4).set(1 + 2 * (listElements.get(i).y - 1), listElements.get(i).z);
            }
            if(i==listElements.size()-1)printChar(listOLists.get(4));
            horizontalLine = Arrays.asList(199, 204, 201, 204, 201, 204, 201, 204, 201, 204, 187);
            if(i==listElements.size()-1)printChar(horizontalLine);
            horizontalLine = Arrays.asList(200, 204, 202, 204, 202, 204, 202, 204, 202, 204, 186);
        }
    }


}
