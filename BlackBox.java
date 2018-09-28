import java.util.Random;
import java.util.Scanner;
/**
 *Created by Sripath Mishra on 9/8/2017.
 * BlackBox Game Code
 * Amrish Nayak-
 * 2/18/2018
 *
 */
public class BlackBox {
    public static char box[][]; // The matrix for the game.
    public static int size;       // to store the number of rows and columns.
    public static int numball;
    public static int numlink;
    public static boolean end;
    public static int score;
    public static int high_score=-1;
    public static int c,d,e,f,g,h;
    public static int pntb;
    public static int cnt = 0;
    public static int ls=0;
    public static String rc="";
    public static int qt=0;


    /**
     * The default constructor which places default values to the class variables
     */
    public BlackBox()
    {
        this.box=new char[0][0];
        this.size=0;
        this.numball=0;
        this.numlink=0;
        this.end=false;
        this.score=0;
    }
    /**
     * The parameterized constructor which places values to the class variables
     */
    public BlackBox(int size, int numball, int numlink, boolean end, int score)
    {
        this.box=new char[size][size];
        this.size=size;
        this.numball=numball;
        this.numlink=numlink;
        this.end=end;
        this.score=score;
    }
    /**
     * The main function takes input for the difficulty level and call the functions initialize() and
     * playgame()
     */
    public static Scanner scanner;
    public static void main(String[] args) {
        //Todo:start the game print the welcome message and ask for correct difficulty level.
        //Todo: end the game if the user says quit.
        //Todo:call the functions initialize and playgame()
        // Todo: take care of high score
        BlackBox bl = new BlackBox(7, 2, 3, true, 5);
        System.out.println("Welcome to the Blackbox Game. Please choose the difficulty level:easy/medium/hard or quit to end the game ");
        scanner = new Scanner(System.in);
        String level = scanner.nextLine();
        if (level.equals("quit")) {

        } else {
            if (level.equals("easy")) {
                setSize(7);
                char arr[][]=new char[7][7];
                setbox(arr);



            } else if (level.equals("medium")) {
                setSize(9);
                char arr[][]=new char[9][9];
               setbox(arr);
               setbox(arr);


            } else {
                setSize(10);
                char arr[][]=new char[10][10];
                setbox(arr);




            }
            initialize();
            playgame();
        }
    }
        /**
         * The initialize funtion
         */
        public static void initialize() {
            //Todo:initialise the Box[][]
            //Todo: place the 'X' and the '#'
            // Todo: place 3 '0''s randomly.
            for(int i=0;i<size;i++){
                box[0][i]='#';
                //System.out.print(arr[0][i]);

            }
            for(int i=1;i<size;i++){
                box[i][size-1]='#';
            }
            for(int k=size-2;k>=0; k--){
                box[size - 1][k] = '#';


            }
            for(int i=size-2;i>=1;i--){
                box[i][0] = '#';


            }
            box[0][0]='X';
            box[size-1][0]='X';
            box[0][size-1]='X';
            box[size-1][size-1]='X';
            Random rn=new Random();
             c=1+rn.nextInt(size-2);
             d=1+rn.nextInt(size-2);
             e=1+rn.nextInt(size-2);
             f=1+rn.nextInt(size-2);
             g=1+rn.nextInt(size-2);
             h=1+rn.nextInt(size-2);
            while (c==e&&d==f) {
                e=1+rn.nextInt(size-2);
                f=1+rn.nextInt(size-2);
            }
            while ((c==g&&d==h)||(e==g&&f==h)) {
                g=1+rn.nextInt(size-2);
                h=1+rn.nextInt(size-2);
            }
        box[c][d]='0';
        box[e][f]='0';
        box[g][h]='0';
          //  System.out.println(c+","+d+"+"+e+f+"+"+g+h);

        }
        /**
         * The printbox funtion prints out the matrix in a particular format as given in the handout.
         */
        public static void printbox() {
            //Todo:print the box in the correct order
            // for  5*5 example
            //System.out.print("\t");
            if(pntb==1) {
                for (int i = 1; i <= size; i++) {
                    System.out.print("\t " + i);

                }
                System.out.println();
                System.out.println("=============================================");
                int nk = 0;
                for (int i = 0; i < size; i++) {
                    System.out.print(++nk + " ");
                    for (int j = 0; j < size; j++) {
                        if ((i == c && j == d) || (i == e && j == f) || (i == g && j == h)) {
                            System.out.print("|" + " " + "\t");
                        } else {
                            if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                                System.out.print("|" + box[i][j] + "\t");
                            } else {
                                System.out.print("| " + box[i][j] + "\t");
                            }
                        }

                    }
                    System.out.print("|");
                    System.out.println();

                }
                System.out.println("=============================================");
            }//first type
            if(pntb==2){
                for (int i = 1; i <= size; i++) {
                    System.out.print("\t " + i);

                }
                System.out.println();
                System.out.println("=============================================");
                int nk = 0;
                for (int i = 0; i < size; i++) {
                    System.out.print(++nk + " ");
                    for (int j = 0; j < size; j++) {
                        if (box[i][j]=='0') {
                            System.out.print("|" + " " + "\t");
                        } else {
                            if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                                System.out.print("|" + box[i][j] + "\t");

                            } else {
                                System.out.print("| " + box[i][j] + "\t");
                            }
                        }

                    }
                    System.out.print("|");
                    System.out.println();

                }
                System.out.println("=============================================");

            }//with asterisk
            if(pntb==3){
                for (int i = 1; i <= size; i++) {
                    System.out.print("\t " + i);

                }
                System.out.println();
                System.out.println("=============================================");
                int nk = 0;
                for (int i = 0; i < size; i++) {
                    System.out.print(++nk + " ");
                    for (int j = 0; j < size; j++) {
                        if (box[i][j]=='0') {
                            System.out.print("|" + " " + "\t");
                        } else {
                            if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                                System.out.print("|" + box[i][j] + "\t");
                                // System.out.println();
                            } else {
                                System.out.print("| " + box[i][j] + "\t");
                            }
                        }

                    }
                    System.out.print("|");
                    System.out.println();

                }
                System.out.println("=============================================");


            }//check method
            if(pntb==4){
                for (int i = 1; i <= size; i++) {
                    System.out.print("\t " + i);

                }
                System.out.println();
                System.out.println("=============================================");
                int nk = 0;
                for (int i = 0; i < size; i++) {
                    System.out.print(++nk + " ");
                    for (int j = 0; j < size; j++) {
                        if (box[i][j]=='0') {
                            System.out.print("|" + box[i][j] + "\t");
                        } else {
                            if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                                System.out.print("|" + box[i][j] + "\t");

                            } else {
                                System.out.print("| " + box[i][j] + "\t");
                            }
                        }

                    }
                    System.out.print("|");
                    System.out.println();

                }
                System.out.println("=============================================");



            }

        /* 1  2  3  4  5  6  7
         ======================
        1|X |# |# |# |# |# |X |
        2|# |  |  |  |  |  |# |
        3|# |  |  |  |  |  |# |
        4|# |  |  |  |  |  |# |
        5|# |  |  |  |  |  |# |
        6|# |  |  |  |  |  |# |
        7|X |# |# |# |# |# |X |
         ======================*/
            //place the guesses as the come and print the balls when the player enter sumbit.
        }
        /**
         * The playgame funtion opens the first cell and is the main controller for the game. It calls various function when needed.
         */
        public static void playgame() {

            //Todo:Take input of a guess or hint from the user.
            //Todo:Check for valid input
            //Todo:call required functions
            //Todo:keep tab on score.

            numball=3;
            cnt=0;
            numlink=0;
            int rr,cc,r1=0,c1=0,r2=0,c2=0,r3=0,c3=0;
            pntb=1;
            printbox();
            pntb=2;


            scanner=new Scanner(System.in);
            int pos_;

            while (!rc.equals("quit")) {
                if(numball>0) {
                    System.out.println("Choose the new coordinates (row,column) to play the next step or say submit/quit to end the game:");
                    rc = scanner.nextLine();
                    if (!(rc.equals("quit") || rc.equals("submit"))) {
                        pos_ = rc.indexOf(",");
                        cnt++;
                        rr = Integer.parseInt(rc.substring(0, pos_));
                        cc = Integer.parseInt(rc.substring(pos_ + 1));
                        while ((rr == 1 && cc == 1) || (rr == 1 && cc == size) || (rr == size && cc == 1) || (rr == size && cc == size) || (rr > size) || (cc > size) || (rr < 1) || (cc < 1)) {
                            System.out.println("Wrong input please choose a block which is open");
                            rc = scanner.nextLine();
                            pos_ = rc.indexOf(",");
                            cnt++;
                            System.out.println(cnt);
                            rr = Integer.parseInt(rc.substring(0, pos_));
                            cc = Integer.parseInt(rc.substring(pos_ + 1));
                        }
                        if (rr == 1 || rr == size || cc == 1 || cc == size) {
                            check(rr-1, cc-1);
                        } else {
                            box[rr - 1][cc - 1] = '*';
                            printbox();
                            numball--;
                            if (numball == 2) {
                                r1 = rr;
                                c1 = cc;

                            }
                            if (numball == 1) {
                                r2 = rr;
                                c2 = cc;

                            }
                            if (numball == 0) {
                                r3 = rr;
                                c3 = cc;


                            }
                        }


                    }
                    if (rc.equals("submit")) {
                        System.out.println("Please enter your all 3 guesses for the game:)");
                        System.out.println("Choose the new coordinates (row,column) to play the next step or say submit/quit to end the game:");

                        rc = scanner.nextLine();
                        if (!rc.equals("quit")) {


                            pos_ = rc.indexOf(",");
                            rr = Integer.parseInt(rc.substring(0, pos_));
                            cnt++;
                            cc = Integer.parseInt(rc.substring(pos_ + 1));
                            while ((rr == 1 && cc == 1) || (rr == 1 && cc == size) || (rr == size && cc == 1) || (rr == size && cc == size) || (rr > size) || (cc > size) || (rr < 1) || (cc < 1)) {
                                System.out.println("Wrong input please choose a block which is open");
                                rc = scanner.nextLine();
                                pos_ = rc.indexOf(",");
                                cnt++;
                                rr = Integer.parseInt(rc.substring(0, pos_));
                                cc = Integer.parseInt(rc.substring(pos_ + 1));
                            }
                            if (rr == 1 || rr == size || cc == 1 || cc == size) {
                                check(rr-1, cc-1);

                            } else {
                                box[rr - 1][cc - 1] = '*';
                                printbox();
                                numball--;
                                if (numball == 2) {
                                    r1 = rr;
                                    c1 = cc;

                                }
                                if (numball == 1) {
                                    r2 = rr;
                                    c2 = cc;

                                }
                                if (numball == 0) {
                                    r3 = rr;
                                    c3 = cc;


                                }
                            }
                        }

                    }
                }
                else {

                    System.out.println("Choose the new coordinates (row,column) to play the next step or say submit/quit to end the game:");

                    rc = scanner.nextLine();
                    if (!rc.equals("quit")) {
                        if (!rc.equals("submit")) {
                            pos_ = rc.indexOf(",");
                            cnt++;
                            rr = Integer.parseInt(rc.substring(0, pos_));
                            cc = Integer.parseInt(rc.substring(pos_ + 1));
                            while ((rr == 1 && cc == 1) || (rr == 1 && cc == size) || (rr == size && cc == 1) || (rr == size && cc == size) || (rr > size) || (cc > size) || (rr < 1) || (cc < 1)) {
                                System.out.println("Wrong input please choose a block which is open");
                                rc = scanner.nextLine();
                                pos_ = rc.indexOf(",");
                               cnt++;
                                rr = Integer.parseInt(rc.substring(0, pos_));
                                cc = Integer.parseInt(rc.substring(pos_ + 1));
                            }
                            if (rr == 1 || rr == size || cc == 1 || cc == size) {
                                check(rr-1, cc-1);

                            } else {
                                System.out.println("You have made all of your guesses:(");
                            }
                        }
                        else {
                            numball=3;



                          if((r1-1==c)&&(c1-1==d)&&(r2-1==e)&&(c2-1==f)&&(r3-1==g)&&(c3-1==h)){
                              pntb = 4;
                              printbox();
                              ls++;
                              System.out.println("Thanks for playing the game.");

                               if(ls==1){
                                   high_score=cnt;

                                   System.out.println("Highest Score=>"+high_score);
                               }else {
                                   if(cnt<high_score){
                                       high_score=cnt;
                                       System.out.println("Highest Score=>"+high_score);
                                   }
                                   else {
                                       System.out.println("Highest Score=>"+high_score);

                                   }
                               }


                            }
                            else {


                              pntb = 4;
                              printbox();
                              System.out.println("Oops! Failed....."+"Try again! ");

                          }
                            System.out.println("Welcome to the Blackbox Game. Please choose the difficulty level:easy/medium/hard or quit to end the game ");

                            rc = scanner.nextLine();
                            if (rc.equals("quit")) {

                            } else {
                                if (rc.equals("easy")) {
                                    setSize(7);
                                    char arr[][]=new char[7][7];
                                    setbox(arr);



                                } else if (rc.equals("medium")) {
                                    setSize(9);
                                    char arr[][]=new char[9][9];
                                    setbox(arr);
                                    setbox(arr);


                                } else {
                                    setSize(10);
                                    char arr[][]=new char[10][10];
                                    setbox(arr);




                                }
                                initialize();
                                playgame();
                            }

                        }


                    }// rc="!quit";
                    if(rc.equals("quit")) {
                        qt++;
                        if (qt == 1) {
                            if (high_score == -1) {
                                System.out.println("Highest Score=>" + "none");
                            } else {
                                System.out.println("Highest Score=>" + high_score);
                            }
                        }
                    }

                }





            }//while recreated













        }
        /**
         * The check funtion takes in the row and column in the matrix, checks for Hit (H), Reflection (R) or Divergence(#num)
         *
         */
        public static void check(int i,int j) {
            //Todo:place a guess when the input of i and j are valid
            //Todo:Check for a Hit
            //Todo:Check for a reflection
            //Todo:Check for a bounce
            //Todo:Print a statement telling the user they cannot place a fourth ball.
            pntb = 3;
            int chk = 0;
            if (reflectionCheck(i, j)) {
                box[i][j] = 'R';
                printbox();

                }
                else {


                if ((c == 1 && j == d) || (e == 1 && j == f) || d == 1 || (g == 1 && j == h)) {
                    if ((i + 1 == c && j == d) || (i + 1 == e && j == f) || (i + 1 == g && j == h)) {
                        chk++;
                        if (hitcheck(i, j)) {
                            box[i][j] = 'H';
                            printbox();

                        } else if (deflectionCheck(i, j)) {
                            printbox();

                        } else {
                            straightRay(i, j);
                            printbox();
                        }
                    }


                } else if ((c == size - 2 && j == d) || (e == size - 2 && j == f) || (g == size - 2 && j == h)) {
                    if ((i - 1 == c && j == d) || (i - 1 == e && j == f) || (i - 1 == g && j == h)) {
                        chk++;
                        if (hitcheck(i, j)) {
                            box[i][j] = 'H';
                            printbox();

                        } else if (deflectionCheck(i, j)) {
                            printbox();

                        } else {
                            straightRay(i, j);
                            printbox();
                        }
                    }

                } else if ((d == 1 && i == c) || (f == 1 && i == e) || (h == 1 && g == i)) {
                    if ((j + 1 == d && i == c) || (j + 1 == f && i == e) || (j + 1 == h && i == g)) {
                        chk++;
                        if (hitcheck(i, j)) {
                            box[i][j] = 'H';
                            printbox();

                        } else if (deflectionCheck(i, j)) {
                            printbox();

                        } else {
                            straightRay(i, j);
                            printbox();
                        }
                    }

                } else if ((d == size - 2 && i == c) || (f == size - 2 && i == e) || (h == size - 2 && g == i)) {
                    if ((j - 1 == d && i == c) || (j - 1 == f && i == e) || (j - 1 == h && i == g)) {
                        chk++;

                        if (hitcheck(i, j)) {
                            box[i][j] = 'H';
                            printbox();

                        } else if (deflectionCheck(i, j)) {
                            printbox();

                        } else {
                            straightRay(i, j);
                            printbox();
                        }
                    }

                }


                if (chk == 0) {
                    if (deflectionCheck(i, j)) {
                        printbox();

                    } else if (hitcheck(i, j)) {
                        box[i][j] = 'H';
                        printbox();

                    } else {
                        straightRay(i, j);
                        printbox();
                    }
                }
            }





        }
        /**
         * The hitcheck funtion takes in the row and column in the matrix, checks for Hit (H)
         *
         */
        public static boolean hitcheck(int i, int j) {
            //todo: check if the ray causes a HIT as defined in the handout
            if(i==0||i==size-1){
                if(j==d||j==f||j==h){

                   return true;
                }
            }
            if(j==0||j==size-1){
                if(i==c||i==e||i==g){
                   return true;
                }
            }
           return false;
        }
        /**
         * The check funtion takes in the row and column in the matrix, checks for Reflection (R)
         *
         */
        public static boolean reflectionCheck(int i, int j) {
            //todo: check if the ray causes a Reflection as defined in the handout
            if(i==0){
                if((j+1==d&&i+1==c)||(j-1==d&&i+1==c)||(j+1==f&&i+1==e)||(j-1==f&&i+1==e)||(j+1==h&&i+1==g)||(j-1==h&&i+1==g)){
                    return true;

                }
                if((j+1==d||j+1==f||j+1==h)&&(j-1==d||j-1==f||j-1==h)){
                    if(c==e&&c==g){
                        return true;

                    }if(e==c&&e==g){
                        return true;
                    }if(c==g&&g==e){

                        return true;
                    }
                }
            }else if(i==size-1){
                if((j+1==d&&i-1==c)||(j-1==d&&i-1==c)||(j+1==f&&i-1==e)||(j-1==f&&i-1==e)||(j+1==h&&i-1==g)||(j-1==h&&i-1==g)){
                    return true;

                }
                if((j+1==d||j+1==f||j+1==h)&&(j-1==d||j-1==f||j-1==h)){
                    if(c==e&&c==g){
                        return true;

                    }if(e==c&&e==g){
                        return true;
                    }if(c==g&&g==e){

                        return true;
                    }

                }

            }else if(j==0){
                if((j+1==d&&i+1==c)||(j+1==d&&i-1==c)||(j+1==f&&i+1==e)||(j+1==f&&i-1==e)||(j+1==h&&i+1==g)||(j+1==h&&i-1==g)){
                    return true;

                }
                if((i+1==c||i+1==e||i+1==g)&&(i-1==c||i-1==e||i-1==g)){
                    if(d==h&&d==f){
                        return true;

                    }if(f==d&&f==h){
                        return true;
                    }if(h==g&&d==h){

                        return true;
                    }
                }

            }else if(j==size-1){
                if((j-1==d&&i+1==c)||(j-1==d&&i-1==c)||(j-1==f&&i+1==e)||(j-1==f&&i-1==e)||(j-1==h&&i+1==g)||(j-1==h&&i-1==g)){
                    return true;

                }
                if((i+1==c||i+1==e||i+1==g)&&(i-1==c||i-1==e||i-1==g)){
                    if(d==h&&d==f){
                        return true;

                    }if(f==d&&f==h){
                        return true;
                    }if(h==g&&d==h){

                        return true;
                    }
                }

            }
            return false;
        }
        /**
         * The check funtion takes in the row and column in the matrix, checks for Divergence(#num)
         *
         */
        public static boolean deflectionCheck(int i, int j) {
            //todo: check if the ray causes a Deflection as defined in the handout
            if(i==0){
                int tm=0;
                for(i=1;i<(size-1);i++){
                    if(((j+1==d)||(j+1==f)||(j+1==h))&&((i==c||i==e||i==g))){
                        if(j+1==d){
                            tm=1;
                        }
                        else if(j+1==f){
                            tm=2;
                        }else if(j+1==h){
                            tm=3;
                        }
                   if(i==c&&tm==1) {
                       numlink++;
                       box[i-1][0]=(char)(numlink+'0');
                       box[0][j]=(char)(numlink+'0');


                       return true;
                   }
                   else if(i==e&&tm==2) {
                       numlink++;
                       box[i-1][0]=(char)(numlink+'0');
                       box[0][j]=(char)(numlink+'0');


                       return true;


                      }
                      else if (i==g&&tm==3) {
                       numlink++;
                       box[i-1][0]=(char)(numlink+'0');
                       box[0][j]=(char)(numlink+'0');


                       return true;


                    }




                    }
                    if(((j-1==d)||(j-1==f)||(j-1==h))&&(i==c||i==e||i==g)){
                        if(j-1==d){
                            tm=1;
                        }
                        else if(j-1==f){
                            tm=2;
                        }else if(j-1==h){
                            tm=3;
                        }

                        if(i==c&&tm==1) {
                            numlink++;
                            box[i-1][size-1]=(char)(numlink+'0');
                            box[0][j]=(char)(numlink+'0');




                            return true;
                        }
                        else if(i==e&&tm==2) {
                            numlink++;
                            box[i-1][size-1]=(char)(numlink+'0');
                            box[0][j]=(char)(numlink+'0');




                            return true;

                        }
                        else if (i==g&&tm==3) {
                            numlink++;
                            box[i-1][size-1]=(char)(numlink+'0');
                            box[0][j]=(char)(numlink+'0');



                            return true;


                        }




                    }


                    }
            }
            if(i==size-1){
                int pm=0;
                for(i=size-1;i>0;i--){
                    if(((j+1==d)||(j+1==f)||(j+1==h))&&(i==c||i==e||i==g)){
                        if(j+1==d){
                            pm=1;
                        }
                        else if(j+1==f){
                            pm=2;
                        }else if(j+1==h){
                            pm=3;
                        }
                        if(i==c&&pm==1) {
                            numlink++;
                            box[i+1][0]=(char)(numlink+'0');
                            box[size-1][j]=(char)(numlink+'0');


                            return true;

                        }
                        else if(i==e&&pm==2) {
                            numlink++;
                            box[i+1][0]=(char)(numlink+'0');
                            box[size-1][j]=(char)(numlink+'0');


                            return true;



                        }
                        else if (i==g&&pm==3) {
                            numlink++;
                            box[i+1][0]=(char)(numlink+'0');
                            box[size-1][j]=(char)(numlink+'0');


                            return true;


                        }





                    }
                    if(((j-1==d)||(j-1==f)||(j-1==h))&&(i==c||i==e||i==g)){
                        if(j-1==d){
                            pm=1;
                        }
                        else if(j-1==f){
                            pm=2;
                        }else if(j-1==h){
                            pm=3;
                        }
                        if(i==c&&pm==1) {
                            numlink++;
                            box[i+1][size-1]=(char)(numlink+'0');
                            box[size-1][j]=(char)(numlink+'0');


                            return true;


                        }
                        else if(i==e&&pm==2) {
                            numlink++;
                            box[i+1][size-1]=(char)(numlink+'0');
                            box[size-1][j]=(char)(numlink+'0');


                            return true;




                        }
                        else if (i==g&&pm==3) {
                            numlink++;
                            box[i+1][size-1]=(char)(numlink+'0');
                            box[size-1][j]=(char)(numlink+'0');


                            return true;



                        }




                    }


                }

            }
            if(j==0) {
                int tm = 0;
                for (j = 1; j < (size - 1); j++) {
                    if (((i + 1 == c) || (i + 1 == e) || (i+ 1 == g)) && ((j == d || j== f || j == h))) {
                        if (i + 1 == c) {
                            tm = 1;
                        } else if (i + 1 == e) {
                            tm = 2;
                        } else if (i + 1 == g) {
                            tm = 3;
                        }
                        if (j == d && tm == 1) {
                            numlink++;
                            box[0][j - 1] = (char) (numlink + '0');
                            box[i][0] = (char) (numlink + '0');


                            return true;
                        } else if (j == f && tm == 2) {
                            numlink++;
                            box[0][j - 1] = (char) (numlink + '0');
                            box[i][0] = (char) (numlink + '0');


                            return true;


                        } else if (j == h && tm == 3) {
                            numlink++;
                            box[0][j - 1] = (char) (numlink + '0');
                            box[i][0] = (char) (numlink + '0');

                            return true;


                        }
                    }
                    if (((i - 1 == c) || (i - 1 == e) || (i- 1 == g)) && ((j == d || j== f || j == h))) {
                        if (i - 1 == c) {
                            tm = 1;
                        } else if (i - 1 == e) {
                            tm = 2;
                        } else if (i - 1 == g) {
                            tm = 3;
                        }
                        if (j == d && tm == 1) {
                            numlink++;
                            box[size-1][j - 1] = (char) (numlink + '0');
                            box[i][0] = (char) (numlink + '0');


                            return true;
                        } else if (j == f && tm == 2) {
                            numlink++;
                            box[size-1][j - 1] = (char) (numlink + '0');
                            box[i][0] = (char) (numlink + '0');


                            return true;


                        } else if (j == h && tm == 3) {
                            numlink++;
                            box[size-1][j - 1] = (char) (numlink + '0');
                            box[i][0] = (char) (numlink + '0');

                            return true;


                        }
                    }
                }
            }
            if(j==size-1) {
                int tm = 0;
                for (j = (size - 1); j >0 ; j--) {
                    if (((i + 1 == c) || (i + 1 == e) || (i+ 1 == g)) && ((j == d || j== f || j == h))) {
                        if (i + 1 == c) {
                            tm = 1;
                        } else if (i + 1 == e) {
                            tm = 2;
                        } else if (i + 1 == g) {
                            tm = 3;
                        }
                        if (j == d && tm == 1) {
                            numlink++;
                            box[0][j + 1] = (char) (numlink + '0');
                            box[i][size-1] = (char) (numlink + '0');


                            return true;
                        } else if (j == f && tm == 2) {
                            numlink++;
                            box[0][j + 1] = (char) (numlink + '0');
                            box[i][size-1] = (char) (numlink + '0');


                            return true;


                        } else if (j == h && tm == 3) {
                            numlink++;
                            box[0][j + 1] = (char) (numlink + '0');
                            box[i][size-1] = (char) (numlink + '0');
                             return true;


                        }
                    }
                    if (((i - 1 == c) || (i - 1 == e) || (i- 1 == g)) && ((j == d || j== f || j == h))) {
                        if (i + 1 == c) {
                            tm = 1;
                        } else if (i - 1 == e) {
                            tm = 2;
                        } else if (i - 1 == g) {
                            tm = 3;
                        }
                        if (j == d && tm == 1) {
                            numlink++;
                            box[size-1][j + 1] = (char) (numlink + '0');
                            box[i][size-1] = (char) (numlink + '0');


                            return true;
                        } else if (j == f && tm == 2) {
                            numlink++;
                            box[size-1][j + 1] = (char) (numlink + '0');
                            box[i][size-1] = (char) (numlink + '0');


                            return true;


                        } else if (j == h && tm == 3) {
                            numlink++;
                            box[size-1][j + 1] = (char) (numlink + '0');
                            box[i][size-1] = (char) (numlink + '0');

                            return true;


                        }
                    }
                }
            }
           return false;
        }
        /**
         * The straightRay funtion takes in the row and column in the matrix, checks for Straight ray
         *
         */
        public static boolean straightRay(int i, int j){
            //todo: check if the ray is a straight ray as defined in the handout

            if(i==0||i==size-1){
                if(i==0) {
                    numlink++;
                    box[size-1][j] = (char) (numlink + '0');
                    box[i][j]=(char) (numlink + '0');
                    return true;
                }
                if(i==size-1){
                    numlink++;
                    box[0][j]=(char)(numlink+'0');
                    box[i][j]=(char) (numlink + '0');
                    return true;
                }
            }
            else if(j==0||j==size-1){
                if(j==0) {
                    numlink++;

                    box[i][size-1] = (char) (numlink + '0');
                    box[i][j]=(char) (numlink + '0');
                    return true;
                }
                if(j==size-1){
                    numlink++;
                    box[i][0]=(char)(numlink+'0');
                    box[i][j]=(char) (numlink + '0');
                    return true;
                }
            }
            return false;
        }
        /**
         * The following definitions are the getters and setter functions which have to be implemented
         *
         */
        public char[][] getbox() {
            return box;
        }
        public int getscore() {
            return score;

        }
        public int getNumball() {
            return numball;

        }
        public int getNumlink() {
            return numlink;

        }
        public boolean getend() {
            return end;

        }
        public static void setbox(char box[][]) {
            BlackBox.box=box;

        }
        public static void setSize(int size){
           BlackBox.size=size;
        }
        public void setNumball(int Numball) {
            this.numball=Numball;

        }
        public void setNumlink(int Numlink) {
            this.numlink=Numlink;

        }
        public void setEnd(boolean end) {
            this.end=end;

        }
        public void setScore(int score) {
            this.setScore(score);

        }
    }
