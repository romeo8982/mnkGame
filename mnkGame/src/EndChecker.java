import java.util.List;

public class EndChecker {
    public static boolean isLegal(List<Element> elements, int x, int y)
    {
        for (Element element:elements)
        {
            if(element.x==x && element.y==y)
            {
                return true;
            }
        }
        return false;
    }
    public static String end(List<Element> elements)
    {
        int iterator_X;
        int iterator_O;
        int sumOfAll_X;
        int sumOfAll_O;
        int sumOfArray_x;
        int sumOfArray_O;
        int missingNumber_x;
        int missingNumber_O;
        for(int row=1;row<6;row++) {
            iterator_X = 0;
            iterator_O = 0;
            sumOfAll_X = 15;
            sumOfAll_O = 15;
            sumOfArray_x = 0;
            sumOfArray_O = 0;
            for (Element element : elements) {
                if (element.x == row) {
                    if (element.z == 79) {
                        iterator_O++;
                        sumOfArray_O = sumOfArray_O+element.y;
                    }
                    else if (element.z == 88) {
                        iterator_X++;
                        sumOfArray_x = sumOfArray_x+element.y;
                    }
                    missingNumber_x = sumOfAll_X-sumOfArray_x;
                    if (iterator_X >= 4 && (missingNumber_x==5||missingNumber_x==1||missingNumber_x==0)) return "X";
                    missingNumber_O = sumOfAll_O-sumOfArray_O;
                    if (iterator_O >= 4 && (missingNumber_O==5||missingNumber_O==1||missingNumber_O==0)) return "O";

                }
            }
        }

        for(int col=1;col<6;col++)
        {
            sumOfAll_X = 15;
            sumOfAll_O = 15;
            sumOfArray_x = 0;
            sumOfArray_O = 0;
            iterator_X = 0;
            iterator_O = 0;
            for (Element element : elements) {
                if (element.y == col) {
                    if (element.z == 79) {
                        iterator_O++;
                        sumOfArray_O = sumOfArray_O + element.x;
                    } else if (element.z == 88) {
                        iterator_X++;
                        sumOfArray_x = sumOfArray_x + element.x;
                    }
                    missingNumber_x = sumOfAll_X - sumOfArray_x;
                    if (iterator_X >= 4 && (missingNumber_x == 5 || missingNumber_x == 1 || missingNumber_x == 0))
                        return "X";
                    missingNumber_O = sumOfAll_O - sumOfArray_O;
                    if (iterator_O >= 4 && (missingNumber_O == 5 || missingNumber_O == 1 || missingNumber_O == 0))
                        return "O";

                }
            }
        }
        iterator_X = 0;
        iterator_O = 0;
        sumOfAll_X = 15;
        sumOfAll_O = 15;
        sumOfArray_x = 0;
        sumOfArray_O = 0;
        for (Element element : elements) {
            if (element.x == element.y) {
                if (element.z == 79) {
                    iterator_O++;
                    sumOfArray_O = sumOfArray_O+element.y;
                }
                else if (element.z == 88) {
                    iterator_X++;
                    sumOfArray_x = sumOfArray_x+element.y;
                }
                missingNumber_x = sumOfAll_X-sumOfArray_x;
                if (iterator_X >= 4 && (missingNumber_x==5||missingNumber_x==1||missingNumber_x==0)) return "X";
                missingNumber_O = sumOfAll_O-sumOfArray_O;
                if (iterator_O >= 4 && (missingNumber_O==5||missingNumber_O==1||missingNumber_O==0)) return "O";
            }
        }

        iterator_X = 0;
        iterator_O = 0;
        for (Element element : elements) {
            if (element.x + 1 == element.y) {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
                if (iterator_X >= 4) return "X";
                if (iterator_O >= 4) return "O";
            }
        }
        iterator_X = 0;
        iterator_O = 0;
        for (Element element : elements) {
            if (element.x - 1 == element.y) {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
                if (iterator_X >= 4) return "X";
                if (iterator_O >= 4) return "O";
            }
        }
        iterator_X = 0;
        iterator_O = 0;
        for (Element element : elements) {
            if (element.x == 1 && element.y==4 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 2 && element.y==3 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 3 && element.y==2 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 4 && element.y==1 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (iterator_X >= 4) return "X";
            if (iterator_O >= 4) return "O";
        }
        iterator_X = 0;
        iterator_O = 0;
        for (Element element : elements) {
            if (element.x == 2 && element.y==5 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 3 && element.y==4 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 4 && element.y==3 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 5 && element.y==2 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (iterator_X >= 4) return "X";
            if (iterator_O >= 4) return "O";
        }
        iterator_X = 0;
        iterator_O = 0;
        for (Element element : elements) {
            if (element.x == 1 && element.y==5 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 2 && element.y==4 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 3 && element.y==3 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 4 && element.y==2 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (iterator_X >= 4) return "X";
            if (iterator_O >= 4) return "O";
        }
        iterator_X = 0;
        iterator_O = 0;
        for (Element element : elements) {
            if (element.x == 2 && element.y==4 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 3 && element.y==3 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 4 && element.y==2 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (element.x == 5 && element.y==1 )
            {
                if (element.z == 79) iterator_O++;
                if (element.z == 88) iterator_X++;
            }
            if (iterator_X >= 4) return "X";
            if (iterator_O >= 4) return "O";
        }

        return "N";
    }
}
