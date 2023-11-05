import java.io.*;

public class NotesOption {

    int count = 1;
    String note[][] = new String[10][3];
    
    String user, pass;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void welcomeMsg() {
        System.out.println("\n\t**********************************************");
        System.out.println("\t***************     Notes      ***************");
        System.out.println("\t**********************************************");
    }

    void leaveMsg() {
        System.out.println("\n\t**********************************************");
        System.out.println("\t*********   Thanks for using Notes    ********");
        System.out.println("\t**********************************************\n");
    }

    void login() throws IOException {
        System.out.println("\n\t\t------------- Login --------------");
        
        try{
            System.out.print("\nEnter your user name - ");
            user = br.readLine();

            System.out.print("\nEnter your password - ");
            pass = br.readLine();
        }catch(NumberFormatException e)
        {
            System.out.println("\nPlease enter valid digits!\n");
        }
    }

    void noteInput(int index) throws IOException {
        try {
            note[index][0] = Integer.toString(index);

            System.out.print("\nEnter the title - ");
            note[index][1] = br.readLine();

            System.out.print("Enter Body - ");
            note[index][2] = br.readLine();
        } catch (IOException i) {
            System.out.println("Invalid input!");
            System.out.println("Please check your input and try again....");
        } catch (NumberFormatException n) {
            System.out.println("Invalid number format!");
            System.out.println("Please check your input and try again....");
        }

    }

    void noteCreate() throws IOException {
        try {
            noteInput(count);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Number of notes exceeded!");
            System.out.println("Please delete unused notes and try again....");
        }

        System.out.println("\nNew note " + note[count][1] + " added to your list!");
        count++;
    }

    void noteEdit() throws IOException {
        System.out.print("\nEnter serial no. of note that you want to edit - ");

        int edit;

        try {
            edit = Integer.parseInt(br.readLine());

            if (edit < count) {
                noteInput(edit);

                System.out.println("\nNote " + note[edit][1] + " edited in your list!");
            } else {
                System.out
                        .println("\nEntered serial of note doesn't exist,\nPlease try again with valid serial number.");
            }
        } catch (NumberFormatException n) {
            System.out.println("Invalid number format!");
            System.out.println("Please check your input and try again....");
        } catch (IOException i) {
            System.out.println("Invalid input!");
            System.out.println("Please check your input and try again....");
        }
    }

    void noteDisplay() {
        System.out.println("\n\t Sr. no \t Title \t\t Body");

        for (int i = 1; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" \t " + note[i][j] + " \t");
            }
            System.out.println();
        }
    }

    void noteDelete() throws IOException {
        System.out.println("\nEnter serial no. of note that you want to delete - ");
        int i, j, del = Integer.parseInt(br.readLine());

        if (del < count) {

            System.out.println("\nNote " + note[del][1] + " deleted from your list!");

            try {
                for (i = del; i < count; i++) {
                    for (j = 0; j < 3; j++) {
                        note[i][j] = note[i + 1][j];
                    }
                }

                for (j = 0; j < 3; j++) {
                    note[i][j] = null;
                }

                note[del][0] = Integer.toString(del--);
                count--;
            } catch (ArrayIndexOutOfBoundsException a) {
                System.out.println("Number of notes exceeded!");
                System.out.println("Please delete unused notes and try again....");
            }
        } else {
            System.out.println("\nEntered serial of note doesn't exist,\nPlease try again with valid serial number.");
        }

    }

}
